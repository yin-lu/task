package com.yl.controller;

import com.yl.entity.User;
import com.yl.service.UserService;
import com.yl.utils.DESUtil;
import com.yl.utils.JWTUtil;
import com.yl.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@Controller
@RequestMapping("")
public class UserController {

    static Logger logger = Logger.getLogger(String.valueOf(UserController.class));

    @Autowired
    UserService userService;

    //跳转到登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        logger.info("跳转到登录页面");
        return "loginTiles";
    }

    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "pwd", required = false) String pwd, Model model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("进入接口");
        logger.info(name + "+" + pwd);
        if (name.isEmpty()) {
            model.addAttribute("error", "用户名不能为空");
            return "loginTiles";
        }
        if (pwd.isEmpty()) {
            model.addAttribute("error", "密码不能为空");
            return "loginTiles";
        } else {
            User user = userService.getUser(name);
            if (user == null) {
                logger.info("登陆失败");
                model.addAttribute("error", "请输入正确的用户名和密码");
                return "loginTiles";
            }
            logger.info("user=" + user);
            if (MD5Util.verify(pwd, user.getPwd())) {
                logger.info("登陆成功");

//                String token = MD5Util.MD5(name + System.currentTimeMillis());
                try {
//                    DESUtil desUtil=new DESUtil();
//                    String token = de  sUtil.encrypt(String.valueOf(user.getId() + System.currentTimeMillis()));
                    String token= JWTUtil.createToken(user.getId());
                    logger.info(String.valueOf(user.getId() + System.currentTimeMillis()));
                    logger.info("token="+token);
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
                model.addAttribute("error", "请输入正确的用户名和密码");
                return "loginTiles";
            }
        }
    }

    //跳转到注册页面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toRegister() {
        logger.info("跳转到注册页面");
        return "registerTiles";
    }

    //用户注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user, Model model) {
        logger.info("开始注册");
        logger.info(String.valueOf(user));
        String name = user.getName();
        String pwd = user.getPwd();
        logger.info(name);
        logger.info(pwd);
        if (name.isEmpty()) {
            model.addAttribute("error", "用户名不能为空");
            return "registerTiles";
        }
        if (pwd.isEmpty()) {
            model.addAttribute("error", "密码不能为空");
            return "registerTiles";
        }
        if (userService.getUser(name) != null) {
            model.addAttribute("error", "用户名已注册");
            logger.info("用户名已注册");
            return "registerTiles";
        } else {
            user.setPwd(MD5Util.generate(pwd));
            user.setCreateAt(System.currentTimeMillis());
            user.setUpdateAt(System.currentTimeMillis());
            userService.addUser(user);
            model.addAttribute("error", "注册成功");
        }
        return "loginTiles";

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
