package com.yl.service.impl;

import com.yl.entity.User;
import com.yl.mapper.UserMapper;
import com.yl.service.UserService;
import com.yl.utils.RedisUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("userService")
public class UserServiceImpl implements UserService {

    Logger logger = Logger.getLogger(String.valueOf(UserServiceImpl.class));

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
    public int deleteUser(long id) {
        int a = mapper.deleteUser(id);
        if (a == 1) {
            redisUtil.remove("user" + id);
        }
        return a;
    }

    @Override
    public int updateUser(User user) {
        int a = mapper.updateUser(user);
        if (a == 1) {
            redisUtil.set("user" + user.getId(), user, Long.valueOf(60 * 60 * 24));
        }
        return a;
    }

    @Override
    public User getUser(@Param("name") String name) {
        User user = (User) redisUtil.get("user" + name);
        if (user == null) {
            logger.info("user无缓存，开始缓存");
            user = mapper.getUser(name);
            redisUtil.set("user" + name, user, Long.valueOf(60 * 60 * 24));
        }
        return user;
    }

    @Override
    public User login(@Param("name") String name, @Param("pwd") String pwd) {
        User user = (User) redisUtil.get("user" + name);
        if (user == null) {
            logger.info("user无缓存，开始缓存");
            user = mapper.login(name, pwd);
            redisUtil.set("user" + name + pwd, user, Long.valueOf(60 * 60 * 24));
            user = mapper.getUser(name);
        }
        return user;
    }

    @Override
    public List<User> listUser() {
        List<User> users = (List<User>) redisUtil.get("user");
        if (users == null) {
            logger.info("users无缓存，开始缓存");
            users = mapper.listUser();
            redisUtil.set("user", users, Long.valueOf(60 * 60 * 24));
        }
        logger.info("users有缓存，读取缓存");
        return users;
    }
}
