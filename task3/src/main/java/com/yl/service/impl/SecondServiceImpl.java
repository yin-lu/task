package com.yl.service.impl;

import com.yl.entity.Second;
import com.yl.mapper.SecondMapper;
import com.yl.service.SecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("secondService")
public class SecondServiceImpl implements SecondService {

    @Autowired
    private SecondMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Second record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Second record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Second selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Second record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Second record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Second> getSecond(String name, Integer state) {
        return mapper.getSecond(name,state);
    }
}
