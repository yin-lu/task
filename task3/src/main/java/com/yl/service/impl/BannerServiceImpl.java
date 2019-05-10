package com.yl.service.impl;

import com.yl.entity.Banner;
import com.yl.mapper.BannerMapper;
import com.yl.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bannerService")
public class BannerServiceImpl implements BannerService{

    @Autowired
    private BannerMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Banner record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Banner record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Banner selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Banner> getBanner(String editor, Integer state) {
        return mapper.getBanner(editor,state);
    }
}
