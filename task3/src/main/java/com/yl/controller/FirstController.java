package com.yl.controller;


import com.yl.entity.First;
import com.yl.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class FirstController {
    static java.util.logging.Logger logger= Logger.getLogger(String.valueOf(FirstController.class));
    @Autowired
    FirstService firstService;
    /**
     *增加一级作品集
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/first",method = RequestMethod.POST)
    public Map addFirst(First first){
        logger.info("添加方法被调用");
        Map<String,Object> map=new HashMap();
        int number=firstService.insert(first);
        if(number==0) {
            map.put("code", 100);
            map.put("message", "添加失败");
        }else{
            map.put("code",0);
            map.put("message","添加成功");
        }
        logger.info("添加结果为："+first);
        return map;
    }
    /**
     * 条件多个查询
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/first",method = RequestMethod.GET)
    public Map listFirst(@RequestParam(value="name",required = false)String name, @RequestParam(value = "state",required = false)Integer state){
        logger.info("条件查询被调用");
        logger.info("查询条件为"+name+"，"+state);
        Map<String,Object> map=new HashMap();
        List<First> firsts=firstService.getFirst(name,state);
        if (firsts == null || firsts.size() == 0) {
            map.put("code", 100);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "查询成功");
            map.put("data", firsts);
        }
        logger.info("：查询结果" + firsts);
        return map;
    }
    /**
     * 按id删除一级作品集
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/first/{id}" ,method = RequestMethod.DELETE)
    public Map deleteFirst(@PathVariable Long id){
        logger.info("删除被调用");
        logger.info("被删除数据的id为："+id);
        Map<String,Object> map=new HashMap();
        int number=firstService.deleteByPrimaryKey(id);
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
     * 动态更新一级作品集
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/first",method = RequestMethod.PUT)
    public Map updateById(First first){
        logger.info("编辑被调用");
        Map<String,Object> map=new HashMap();
        int number=firstService.updateByPrimaryKeySelective(first);
        if(number==0) {
            map.put("code", 100);
            map.put("message", "编辑失败");
        }else{
            map.put("code",0);
            map.put("message","编辑成功");
        }
        logger.info("编辑改动部分为：" + first);
        return map;
    }
    /**
     * 查询单个一级作品集
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/first/{id}",method = RequestMethod.GET)
    public Map getById(@PathVariable Long id){
        logger.info("单个查询被调用");
        logger.info("查询id为"+id);
        Map<String,Object> map=new HashMap();
        First first=firstService.selectByPrimaryKey(id);
        if (first == null ) {
            map.put("code", 100);
            map.put("message", "单个查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "单个查询成功");
            map.put("data", first);
        }
        logger.info("：查询结果" + first);
        return map;
    }
}

