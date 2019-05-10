package com.yl.service;

import com.yl.entity.Studio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudioService {

    int deleteByPrimaryKey(Long id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);

    List<Studio> getStudio(@Param("name")String name, @Param("state")Integer state);
}
