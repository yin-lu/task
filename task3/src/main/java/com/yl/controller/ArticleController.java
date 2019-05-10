package com.yl.controller;



import com.yl.entity.Article;
import com.yl.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class ArticleController {
    static java.util.logging.Logger logger= Logger.getLogger(String.valueOf(ArticleController.class));
    @Autowired
    ArticleService articleService;
    /**
     *增加作品
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/article",method = RequestMethod.POST)
    public Map addArticle(Article article){
        logger.info("添加方法被调用");
        Map<String,Object> map=new HashMap();
        int number=articleService.insert(article);
        if(number==0) {
            map.put("code", 100);
            map.put("message", "添加失败");
        }else{
            map.put("code",0);
            map.put("message","添加成功");
        }
        logger.info("添加结果为："+article);
        return map;
    }
    /**
     * 条件多个查询
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/article",method = RequestMethod.GET)
    public Map listArticle(@RequestParam(value="name",required = false)String name, @RequestParam(value = "state",required = false)Integer state){
        logger.info("条件查询被调用");
        logger.info("查询条件为"+name+"，"+state);
        Map<String,Object> map=new HashMap();
        List<Article> articles=articleService.getArticle(name,state);
        if (articles == null || articles.size() == 0) {
            map.put("code", 100);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "查询成功");
            map.put("data", articles);
        }
        logger.info("查询结果：" + articles);
        return map;
    }
    /**
     * 按id删除作品
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/article/{id}" ,method = RequestMethod.DELETE)
    public Map deleteArticle(@PathVariable Long id){
        logger.info("删除被调用");
        logger.info("被删除数据的id为："+id);
        Map<String,Object> map=new HashMap();
        int number=articleService.deleteByPrimaryKey(id);
        if(number==0) {
            map.put("code", 100);
            map.put("message", "删除失败");
        }else{
            map.put("code",0);
            map.put("message","删除成功");
        }
        return map;
    }
    /**
     * 动态更新作品
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/article",method = RequestMethod.PUT)
    public Map updateById(Article article){
        logger.info("编辑被调用");
        Map<String,Object> map=new HashMap();
        int number=articleService.updateByPrimaryKeySelective(article);
        if(number==0) {
            map.put("code", 100);
            map.put("message", "编辑失败");
        }else{
            map.put("code",0);
            map.put("message","编辑成功");
        }
        logger.info("编辑改动部分为：" + article);
        return map;
    }
    /**
     * 查询单个作品
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/article/{id}",method = RequestMethod.GET)
    public Map getById(@PathVariable Long id){
        logger.info("单个查询被调用");
        logger.info("查询id为"+id);
        Map<String,Object> map=new HashMap();
        Article article=articleService.selectByPrimaryKey(id);
        if (article == null ) {
            map.put("code", 100);
            map.put("message", "单个查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "单个查询成功");
            map.put("data", article);
        }
        logger.info("查询结果：" + article);
        return map;
    }
}

