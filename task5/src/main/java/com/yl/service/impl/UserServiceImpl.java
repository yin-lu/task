package com.yl.service.impl;

import com.yl.entity.User;
import com.yl.mapper.UserMapper;
import com.yl.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public int addUser(User user) {
        return mapper.addUser(user);
    }

    @Override
    public int deleteUser(long id) {
        return mapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return mapper.updateUser(user);
    }

    @Override
    public User getUser(@Param("name")String name) {
        return mapper.getUser(name);
    }

    @Override
    public User login(@Param("name")String name,@Param("pwd")String pwd) {
        return mapper.login(name,pwd);
    }

    @Override
    public List<User> listUser() {
        return mapper.listUser();
    }
}
