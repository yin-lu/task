package com.yl.controller;


import com.yl.entity.Studio;
import com.yl.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class StudioController {
    static java.util.logging.Logger logger= Logger.getLogger(String.valueOf(StudioController.class));
    @Autowired
    StudioService studioService;
    /**
     *增加工作室
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/studio",method = RequestMethod.POST)
    public Map addStudio(Studio studio){
        logger.info("添加方法被调用");
        Map<String,Object> map=new HashMap();
        int a=studioService.insert(studio);
        if(a==0) {
            map.put("code", 100);
            map.put("message", "添加失败");
        }else{
            map.put("code",0);
            map.put("message","添加成功");
        }
        logger.info("添加结果为："+studio);
        return map;
    }
    /**
     * 条件多个查询
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/studio",method = RequestMethod.GET)
    public Map listStudio(@RequestParam(value="name",required = false)String name, @RequestParam(value = "state",required = false)Integer state){
        logger.info("条件查询被调用");
        logger.info("查询条件为"+name+"，"+state);
        Map<String,Object> map=new HashMap();
        List<Studio> studios=studioService.getStudio(name,state);
        if (studios == null || studios.size() == 0) {
            map.put("code", 100);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "查询成功");
            map.put("data", studios);
        }
        logger.info("：查询结果" + studios);
        return map;
    }
    /**
     * 按id删除工作室
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/studio/{id}" ,method = RequestMethod.DELETE)
    public Map deleteStudio(@PathVariable Long id){
        logger.info("删除被调用");
        logger.info("被删除数据的id为："+id);
        Map<String,Object> map=new HashMap();
        int a=studioService.deleteByPrimaryKey(id);
        if(a==0) {
            map.put("code", 100);
            map.put("message", "删除失败");
        }else{
            map.put("code",0);
            map.put("message","删除成功");
        }
        return map;
    }
    /**
     * 动态更新工作室
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/studio",method = RequestMethod.PUT)
    public Map updateById(Studio studio){
        logger.info("编辑被调用");
        Map<String,Object> map=new HashMap();
        int a=studioService.updateByPrimaryKeySelective(studio);
        if(a==0) {
            map.put("code", 100);
            map.put("message", "编辑失败");
        }else{
            map.put("code",0);
            map.put("message","编辑成功");
        }
        logger.info("编辑改动部分为：" + studio);
        return map;
    }
    /**
     * 查询单个工作室
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/studio/{id}",method = RequestMethod.GET)
    public Map getById(@PathVariable Long id){
        logger.info("单个查询被调用");
        logger.info("查询id为"+id);
        Map<String,Object> map=new HashMap();
        Studio studio=studioService.selectByPrimaryKey(id);
        if (studio == null ) {
            map.put("code", 100);
            map.put("message", "单个查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "单个查询成功");
            map.put("data", studio);
        }
        logger.info("：查询结果" + studio);
        return map;
    }
}

