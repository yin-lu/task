package com.yl.service.impl;

import com.yl.entity.First;
import com.yl.mapper.FirstMapper;
import com.yl.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("firstService")
public class FirstServiceImpl implements FirstService {

    @Autowired
    private FirstMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(First record) {
        return mapper.insert( record);
    }

    @Override
    public int insertSelective(First record) {
        return mapper.insertSelective(record);
    }

    @Override
    public First selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey( id);
    }

    @Override
    public int updateByPrimaryKeySelective(First record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(First record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<First> getFirst(String name, Integer state) {
        return mapper.getFirst(name, state);
    }
}
