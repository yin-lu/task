package com.yl.service.impl;

import com.yl.entity.User;
import com.yl.mapper.UserMapper;
import com.yl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return mapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> getUser(String name, String role) {
        return mapper.getUser(name,role);
    }
}
