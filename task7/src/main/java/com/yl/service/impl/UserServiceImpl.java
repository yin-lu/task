package com.yl.service.impl;

import com.yl.entity.User;
import com.yl.mapper.UserMapper;
import com.yl.service.UserService;
import com.yl.utils.RandonNumberUtils;
import com.yl.utils.RedisUtil;
import com.yl.utils.SMS;
import com.yl.utils.SendEmail;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service("userService")
public class UserServiceImpl implements UserService {

    Logger logger = Logger.getLogger(String.valueOf(UserServiceImpl.class));

    @Autowired
    SMS sms;

    @Autowired
    SendEmail sendEmail;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int addUser(User user) {
        int id = mapper.addUser(user);
        if (id == 1) {
            redisUtil.set("user" + id, user, Long.valueOf(60 * 60 * 24));
        }
        return id;
    }

    @Override
    public int updateSelective(User user) {
        int a = mapper.updateSelective(user);
        if (a == 1) {
            redisUtil.set("user" + user.getId(), user, Long.valueOf(60 * 60 * 24));
        }
        return a;
    }

    @Override
    public User getById(Long id) {
        return mapper.getById(id);
//        User user = (User) redisUtil.get("user" + id);
//        if (user == null) {
//            user = mapper.getById(id);
//            if (user != null) {
//                logger.info("user无缓存，开始缓存");
//                redisUtil.set("user" + id, user, Long.valueOf(60 * 60 * 24));
//            }
//        }
//        return user;
    }

    @Override
    public User getByName(@Param("name") String name) {
        User user = (User) redisUtil.get("user" + name);
        if (user == null) {
            user = mapper.getByName(name);
            if (user != null) {
                logger.info("user无缓存，开始缓存");
                redisUtil.set("user" + name, user, Long.valueOf(60 * 60 * 24));
            }
        }
        return user;
    }

    @Override
    public User getByPhone(@Param("phone") String phone) {
        User user = (User) redisUtil.get("user" + phone);
        if (user == null) {
            user = mapper.getByPhone(phone);
            if (user != null) {
                logger.info("user无缓存，开始缓存");
                redisUtil.set("user" + phone, user, Long.valueOf(60 * 60 * 24));
            }
        }
        return user;
    }

    @Override
    public User getByEmail(@Param("email") String email) {
        User user = (User) redisUtil.get("user" + email);
        if (user == null) {
            logger.info("user无缓存，开始缓存");
            user = mapper.getByEmail(email);
            redisUtil.set("user" + email, user, Long.valueOf(60 * 60 * 24));
        }
        return user;
    }

    @Override
    public int sendPhone(String phone) {
        //邮箱发送初始时间
        long phoneTime = 0;
        //邮箱发送累计次数
        int phoneFrequency = 0;

        if (null != redisUtil.get("phoneTime" + phone)) {
            phoneTime = (long) redisUtil.get("phoneTime" + phone);
            long data = System.currentTimeMillis();
            if ((data - phoneTime) < 1000 * 60) {
                return 2;
            }
        }
        if (null != redisUtil.get("phoneFrequency" + phone)) {
            phoneFrequency = (int) redisUtil.get("phoneFrequency" + phone);
            logger.info("获得:" + redisUtil.get("phoneFrequency" + phone));
            logger.info("获得：" + phoneFrequency);
            if (phoneFrequency >= 3) {
                return 3;
            }
        }
        //生成长度为6的验证码
        String msgCode = "111111";
//        String msgCode = RandonNumberUtils.getRandonString(6);
        logger.info("手机号验证码为：" + msgCode);
        String msgStatus = null;
        msgStatus = String.valueOf(sms.smsSending(phone, msgCode));
        if (msgStatus != null && "true".equals(msgStatus)) {
            redisUtil.set("phoneTime" + phone, System.currentTimeMillis(), Long.valueOf(60));
            redisUtil.set("phoneFrequency" + phone, ++phoneFrequency, Long.valueOf(60 * 60 * 24));
            redisUtil.set("phoneMsgCode" + msgCode, msgCode, Long.valueOf(60));
            logger.info("此手机本日累计发送次数:" + redisUtil.get("phoneFrequency" + phone));
            return 0;
        }
        return 1;
    }

    @Override
    public int sendEmail(String email) {
        //邮箱发送初始时间
        long emailTime = 0;
        //邮箱发送累计次数
        int emailFrequency = 0;
        //判断验证码是否超过60秒
        if (null != redisUtil.get("emailTime" + email)) {
            emailTime = (long) redisUtil.get("emailTime" + email);
            long data = System.currentTimeMillis();
            if ((data - emailTime) < 1000 * 60) {
                return 2;
            }
        }
        //判断24小时之内发送验证码次数是否超过3次
        if (null != redisUtil.get("emailFrequency" + email)) {
            emailFrequency = (int) redisUtil.get("emailFrequency" + email);
            logger.info("获得:" + redisUtil.get("emailFrequency" + email));
            logger.info("获得：" + emailFrequency);
            if (emailFrequency >= 3) {
                return 3;
            }
        }
        //生成长度为4的验证码
//        String emailCode = RandonNumberUtils.getRandonString(4);
        String emailCode ="1111";
        logger.info("邮箱验证码为：" + emailCode);
        String msgStatus = null;
        try {
            //使用sendCloud发送邮箱验证码
            msgStatus = String.valueOf(sendEmail.sendingEmail(email, emailCode));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断发送结果是否成功，成功则将验证码、当前时间以及发送次数放入缓存
        if (msgStatus != null && "true".equals(msgStatus)) {
            //发送邮箱验证码当前时间
            redisUtil.set("emailTime" + email, System.currentTimeMillis(), Long.valueOf(60));
            //发送验证码的缓存
            redisUtil.set("emailMsgCode" + email, emailCode, Long.valueOf(60));
            //发送验证码次数
            redisUtil.set("emailFrequency" + email, ++emailFrequency, Long.valueOf(60 * 60 * 24));
            logger.info("此邮箱本日发送累计次数：" + redisUtil.get(("emailFrequency" + email)));
            return 0;
        }
        return 1;
    }
}
