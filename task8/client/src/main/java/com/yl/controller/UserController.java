package com.yl.controller;

import com.yl.entity.User;
import com.yl.service.UserService;
import com.yl.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    SMS sms;

    @Autowired
    SendEmail sendEmail;

    @Resource
    UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CosClientUtil cosClientUtil;


    static Logger logger = Logger.getLogger(String.valueOf(UserController.class));

    //跳转到登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        logger.info("跳转到登录页面");
        return "loginTiles";
    }

    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "message", required = false) String message, @RequestParam(value = "pwd", required = false) String pwd, Model model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("进入接口");
        logger.info(message + "+" + pwd);
        if (message.isEmpty()) {
            model.addAttribute("error", "用户不能为空");
            return "loginTiles";
        }
        if (pwd.isEmpty()) {
            model.addAttribute("error", "密码不能为空");
            return "loginTiles";
        } else {
            User user = null;
            String mobileRegex = "^1(3|4|5|7|8|9)\\d{9}$";
            String emailRegex = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
            if (message.matches(mobileRegex)) {
                user = userService.getByPhone(message);
            } else {
                if (message.matches(emailRegex)) {
                    user = userService.getByEmail(message);
                } else {
                    user = userService.getByName(message);
                }
            }
            if (user != null) {
                logger.info("user=" + user);
                if (MD5Util.verify(pwd, user.getPwd())) {
                    logger.info("登陆成功");
                    try {
                        String token = JWTUtil.createToken(user.getId());
                        logger.info(String.valueOf(user.getId() + System.currentTimeMillis()));
                        logger.info("token=" + token);
                        Cookie cookie = new Cookie("token", token);
                        cookie.setMaxAge(7 * 24 * 60 * 60);//有效期7天
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        //使用request对象的getSession()获取session，如果session不存在则创建一个
                        HttpSession session = request.getSession();
                        //将数据存储到session中
                        session.setAttribute("user", user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "redirect:/home";
                } else {
                    logger.info("登陆失败");
                    model.addAttribute("error", "密码错误");
                    return "loginTiles";
                }
            } else {
                logger.info("登陆失败");
                model.addAttribute("error", "此用户不存在");
                return "loginTiles";
            }
        }
    }

    //生成手机验证码
    @ResponseBody
    @RequestMapping(value = "/phone/msgCode", method = RequestMethod.GET)
    public Map msgCodeCreate(String phone, Model model) {
        logger.info("手机号" + phone);
        logger.info("开始生成手机验证码");
        Map map = new HashMap();
        String mobileRegex = "^1(3|4|5|7|8|9)\\d{9}$";
        if (phone.matches(mobileRegex) && userService.getByPhone(phone) == null) {
            int status = userService.sendPhone(phone);
            logger.info("发送状态码：" + status);
            if (status == 0) {
                map.put("message", "验证码发送成功");
            }
            if (status == 1) {
                map.put("message", "发送失败请稍后再试");
            }
            if (status == 2) {
                map.put("message", "发送次数过于频繁");
            }
            if (status == 3) {
                map.put("message", "发送验证码次数已经超过3次,24小时后重试");
            }
        } else {
            map.put("message", "此手机已注册或者格式错误，请重新输入");
            logger.info("此手机已注册或者格式错误，请重新输入");
        }
        return map;
    }


    //跳转到手机注册页面
    @RequestMapping(value = "/phone", method = RequestMethod.GET)
    public String toPhoneRegister() {
        logger.info("跳转到手机注册页面");
        return "phoneTiles";
    }

    //手机注册
    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public String phoneRegister(User user, Model model, String msgCode) {
        logger.info("开始手机注册");
        logger.info(String.valueOf(user));
        String name = user.getName();
        String pwd = user.getPwd();
        String phone = user.getPhone();
        logger.info("用户名+密码+手机+验证码" + name + pwd + phone + msgCode);
        if (name.isEmpty() || pwd.isEmpty() || phone.isEmpty()) {
            model.addAttribute("error", "用户名、密码、手机号不能为空");
            return "phoneTiles";
        }
        if (userService.getByName(name) != null || !msgCode.equals(redisUtil.get("phoneMsgCode" + msgCode))) {
            model.addAttribute("error", "用户名已注册或验证码不正确");
            logger.info("用户名已注册或验证码不正确");
            return "phoneTiles";
        } else {
            user.setPwd(MD5Util.generate(pwd));
            user.setCreateAt(System.currentTimeMillis());
            user.setUpdateAt(System.currentTimeMillis());
            userService.addUser(user);
            model.addAttribute("error", "注册成功");
            model.addAttribute("user", user);
        }
        return "loginTiles";

    }

    //生成邮箱验证码
    @ResponseBody
    @RequestMapping(value = "/email/emailCode", method = RequestMethod.GET)
    public Map emailCodeCreate(String email, Model model) {
        logger.info("开始生成邮箱验证码");
        Map map = new HashMap();
        String emailRegex = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        if (email.matches(emailRegex) && userService.getByEmail(email) == null) {
            int status = userService.sendEmail(email);
            logger.info("发送状态码：" + status);
            if (status == 0) {
                map.put("message", "验证码发送成功");
            }
            if (status == 1) {
                map.put("message", "发送失败请稍后再试");
            }
            if (status == 2) {
                map.put("message", "发送次数过于频繁");
            }
            if (status == 3) {
                map.put("message", "发送验证码次数已经超过3次,24小时后重试");
            }
        } else {
            map.put("message", "此邮箱已注册或者格式错误，请重新输入");
            logger.info("此邮箱已注册或者格式错误，请重新输入");
        }
        return map;
    }

    //跳转到邮箱注册页面
    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String toEmailRegister() {
        logger.info("跳转到邮箱注册页面");
        return "emailTiles";
    }

    //邮箱注册
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public String emailRegister(User user, Model model, String emailCode) {
        logger.info("开始邮箱注册");
        logger.info(String.valueOf(user));
        String name = user.getName();
        String pwd = user.getPwd();
        String email = user.getEmail();
        logger.info("用户名+密码+邮箱+验证码" + name + pwd + email + emailCode);
        if (name.isEmpty() || pwd.isEmpty() || email.isEmpty()) {
            model.addAttribute("error", "用户名、密码、邮箱不能为空");
            return "emailTiles";
        }
        if (userService.getByName(name) != null || !emailCode.equals(redisUtil.get("emailMsgCode" + email))) {
            model.addAttribute("error", "用户名已注册或验证码不正确");
            logger.info("用户名已注册或验证码不正确");
            return "emailTiles";
        } else {
            user.setPwd(MD5Util.generate(pwd));
            logger.info(pwd);
            logger.info(MD5Util.generate(pwd));
            user.setImage("https://ylcom-1258882338.cos.ap-chengdu.myqcloud.com/1560590167090.png");
            user.setCreateAt(System.currentTimeMillis());
            user.setUpdateAt(System.currentTimeMillis());
            userService.addUser(user);
            model.addAttribute("error", "注册成功");
        }
        return "loginTiles";

    }

    @RequestMapping(value = "/u/details/{id}", method = RequestMethod.GET)
    public String userDetails(@PathVariable Long id, Model model) {
        logger.info("进入个人信息页面");
        logger.info("id=" + id);
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "uploadTiles";
    }

    /**
     * @param file //     * @param id
     * @param user
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/u/upload/{id}", method = RequestMethod.POST)
    public String upload(HttpSession session,
                         ModelMap model,
                         MultipartFile file,
                         User user,
                         @PathVariable Long id) throws Exception {
        logger.info("进入文件上传");
        logger.info("user=" + user);
        String imgName = cosClientUtil.uploadFile2Cos(file);
        String imgUrl = cosClientUtil.getImgUrl(imgName);
        String url = imgUrl.split("[?]")[0];
        user = userService.getById(id);
        if (user == null) {
            logger.info("用户数据为空");
            model.addAttribute("code", "用户数据为空");
        }
        user.setName(user.getName());
        user.setImage(url);
        int a = userService.updateSelective(user);
        session.setAttribute("image", user.getImage());
        logger.info(url);
        logger.info(imgUrl);
        return url;
    }

    //用户退出
    @RequestMapping(value = "/outLogin", method = RequestMethod.GET)
    public String outLogin(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    logger.info("开始清理");
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    request.getSession().removeAttribute("user");
                }
            }
        }
        return "loginTiles";
    }
}
