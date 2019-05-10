package com.yl.mapper;

import com.yl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //根据id删除
    int deleteByPrimaryKey(Long id);
    //插入数据
    int insert(User record);
    //
    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getUser(@Param("name")String name, @Param("role")String role);
}