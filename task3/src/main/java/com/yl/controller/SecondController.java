package com.yl.controller;



import com.yl.entity.Second;
import com.yl.service.SecondService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class SecondController {
    static java.util.logging.Logger logger= Logger.getLogger(String.valueOf(SecondController.class));
    @Autowired
    SecondService secondService;
    /**
     *增加二级作品类
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/second",method = RequestMethod.POST)
    public Map addSecond(Second second){
        logger.info("添加方法被调用");
        Map<String,Object> map=new HashMap();
        int a=secondService.insert(second);
        if(a==0) {
            map.put("code", 100);
            map.put("message", "添加失败");
        }else{
            map.put("code",0);
            map.put("message","添加成功");
        }
        logger.info("添加结果为："+second);
        return map;
    }
    /**
     * 条件多个查询
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/second",method = RequestMethod.GET)
    public Map listSecond(@RequestParam(value="name",required = false)String name, @RequestParam(value = "state",required = false)Integer state){
        logger.info("条件查询被调用");
        logger.info("查询条件为"+name+"，"+state);
        Map<String,Object> map=new HashMap();
        List<Second> seconds=secondService.getSecond(name,state);
        if (seconds == null || seconds.size() == 0) {
            map.put("code", 100);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "查询成功");
            map.put("data", seconds);
        }
        logger.info("：查询结果" + seconds);
        return map;
    }
    /**
     * 按id删除二级作品类
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/second/{id}" ,method = RequestMethod.DELETE)
    public Map deleteSecond(@PathVariable Long id){
        logger.info("删除被调用");
        logger.info("被删除数据的id为："+id);
        Map<String,Object> map=new HashMap();
        int a=secondService.deleteByPrimaryKey(id);
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
     * 动态更新二级作品类
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/second",method = RequestMethod.PUT)
    public Map updateById(Second second){
        logger.info("编辑被调用");
        Map<String,Object> map=new HashMap();
        int a=secondService.updateByPrimaryKeySelective(second);
        if(a==0) {
            map.put("code", 100);
            map.put("message", "编辑失败");
        }else{
            map.put("code",0);
            map.put("message","编辑成功");
        }
        logger.info("编辑改动部分为：" + second);
        return map;
    }
    /**
     * 查询单个二级作品类
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/second/{id}",method = RequestMethod.GET)
    public Map getById(@PathVariable Long id){
        logger.info("单个查询被调用");
        logger.info("查询id为"+id);
        Map<String,Object> map=new HashMap();
        Second second=secondService.selectByPrimaryKey(id);
        if (second == null ) {
            map.put("code", 100);
            map.put("message", "单个查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "单个查询成功");
            map.put("data", second);
        }
        logger.info("：查询结果" + second);
        return map;
    }
}

