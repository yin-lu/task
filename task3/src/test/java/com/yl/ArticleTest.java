package com.yl;

import com.yl.entity.Article;
import com.yl.service.ArticleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

    //声明时spring的测试类
    @RunWith(SpringJUnit4ClassRunner.class)
//定位Spring配置文件
    @ContextConfiguration("classpath:springMybatis.xml")
    public class ArticleTest {

        static Logger logger = Logger.getLogger(ArticleTest.class);

        @Autowired
        private ArticleService articleService;
        Article article = new Article();

        @Test
        public void deleteByPrimaryKey() {
            articleService.deleteByPrimaryKey((long) 5);
        }
        @Test
        public  void insert(){
//            article.setId((long)2);
            article.setName("塞尚的三姨");
            article.setFirstId((long)1);
            article.setSecondId((long)2);
            article.setState(1);
            article.setIntro("简介1");
            article.setThumbnails("缩略图1");
            article.setVedio("视频链接1");
            article.setPicture("图片链接1");
            article.setIntroduction("正文介绍1");
            article.setCreateAt(System.currentTimeMillis());
            article.setUpdateAt(System.currentTimeMillis());
            article.setEditor("张飞");
            articleService.insert(article);
        }
        @Test
        public void updateByPrimaryKeySelective() {
            article.setId((long) 1);
            article.setState(0);
            articleService.updateByPrimaryKeySelective(article);
        }

        @Test
        public void selectByPrimaryKey() {
            article = articleService.selectByPrimaryKey((long) 1);
            logger.info(article);
        }
        @Test
        public void getArticle() {
            List<Article> list = articleService.getArticle(null,1);
            for(Article a : list) {
                logger.info(a);
            }
        }
    }

