package com.yl.service;

import com.yl.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService  {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> getArticle(@Param("name")String name, @Param("state")Integer state);
}
