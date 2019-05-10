package com.yl.service.impl;

import com.yl.entity.Article;
import com.yl.mapper.ArticleMapper;
import com.yl.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("article")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Article record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Article record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Article selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Article> getArticle(String name, Integer state) {
        return mapper.getArticle(name,state);
    }
}
