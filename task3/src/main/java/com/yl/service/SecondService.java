package com.yl.service;

import com.yl.entity.Second;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondService {

    int deleteByPrimaryKey(Long id);

    int insert(Second record);

    int insertSelective(Second record);

    Second selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Second record);

    int updateByPrimaryKey(Second record);

    List<Second> getSecond(@Param("name")String name, @Param("state")Integer state);
}
