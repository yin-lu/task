package com.yl.mapper;

import com.yl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int addUser(User user);

    int deleteUser(long id);

    int updateUser(User user);

    User getUser(@Param("name")String name);

    User login(@Param("name")String name,@Param("pwd")String pwd);

    List<User> listUser();

}
