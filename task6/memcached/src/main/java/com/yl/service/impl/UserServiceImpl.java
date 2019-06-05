package com.yl.service.impl;

import com.yl.entity.User;
import com.yl.mapper.UserMapper;
import com.yl.service.UserService;
import com.yl.utils.MemcachedUtil;
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

    @Override
    public int addUser(User user) {
        int id = mapper.addUser(user);
        if (id == 1) {
            MemcachedUtil.add("user" + id, user, 60 * 60 * 24);
        }
        return id;
    }

    @Override
    public int deleteUser(long id) {
        int a = mapper.deleteUser(id);
        if (a == 1) {
            MemcachedUtil.delete("user" + id);
        }
        return a;
    }

    @Override
    public int updateUser(User user) {
        int a = mapper.updateUser(user);
        if (a == 1) {
            MemcachedUtil.replace("user" + user.getId(), user, 60 * 60 * 24);
        }
        return a;
    }

    @Override
    public User getUser(@Param("name") String name) {
        User user = (User) MemcachedUtil.get("user" + name);
        if (user == null) {
            logger.info("user无缓存，开始缓存");
            user = mapper.getUser(name);
            MemcachedUtil.set("user" + name, user, 60 * 60 * 24);
        }
        return user;
    }

    @Override
    public User login(@Param("name") String name, @Param("pwd") String pwd) {
        User user = (User) MemcachedUtil.get("user" + name);
        if (user == null) {
            logger.info("user无缓存，开始缓存");
            user = mapper.login(name, pwd);
            MemcachedUtil.set("user" + name + pwd, user, 60 * 60 * 24);
            user = mapper.getUser(name);
        }
        return user;
    }

    @Override
    public List<User> listUser() {
        List<User> users = (List<User>) MemcachedUtil.get("user");
        if (users == null) {
            logger.info("users无缓存，开始缓存");
            users = mapper.listUser();
            MemcachedUtil.set("user", users, 60 * 60 * 24);
        }
        logger.info("users有缓存，读取缓存");
        return users;
    }
}
