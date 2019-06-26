package com.yl.service;

import com.yl.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    int addUser(User user);

    int updateSelective(User user);

    User getById(@Param("id") Long id);

    User getByName(@Param("name") String name);

    User getByPhone(@Param("phone") String phone);

    User getByEmail(@Param("email") String email);

    int sendPhone(String phone);

    int sendEmail(String email);


}
