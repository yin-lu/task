package com.yl.service.impl;

import com.yl.entity.Studio;
import com.yl.mapper.StudioMapper;
import com.yl.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studioService")
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Studio record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Studio record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Studio selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Studio record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Studio record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Studio> getStudio(String name, Integer state) {
        return mapper.getStudio(name,state);
    }
}
