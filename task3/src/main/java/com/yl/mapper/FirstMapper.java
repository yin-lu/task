package com.yl.mapper;

import com.yl.entity.First;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FirstMapper {
    int deleteByPrimaryKey(Long id);

    int insert(First record);

    int insertSelective(First record);

    First selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(First record);

    int updateByPrimaryKey(First record);

    List<First> getFirst(@Param("name")String name,@Param("state")Integer state);
}