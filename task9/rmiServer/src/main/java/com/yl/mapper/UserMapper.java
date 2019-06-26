package com.yl.mapper;

import com.yl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int addUser(User user);

    int updateSelective(User user);

    User getById(@Param("id") Long id);

    User getByName(@Param("name")String name);

    User getByPhone(@Param("phone")String phone);

    User getByEmail(@Param("email")String email);


//    int deleteUser(long id);

//    int updateUser(User user);

//    User login(@Param("name")String name,@Param("pwd")String pwd);
//
//    List<User> listUser();

}
