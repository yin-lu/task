package com.yl.controller;

import com.yl.entity.Banner;
import com.yl.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class BannerController {
    static java.util.logging.Logger logger= Logger.getLogger(String.valueOf(BannerController.class));
    @Autowired
    BannerService bannerService;
    /**
     *增加Banner图
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/banner",method = RequestMethod.POST)
    public Map addBanner(Banner banner){
        logger.info("添加方法被调用");
        Map<String,Object> map=new HashMap();
        int number=bannerService.insert(banner);
        if(number==0) {
            map.put("code", 100);
            map.put("message", "添加失败");
        }else{
            map.put("code",0);
            map.put("message","添加成功");
        }
        logger.info("添加结果为："+banner);
        return map;
    }
    /**
     * 条件多个查询
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/banner",method = RequestMethod.GET)
    public Map listBanner(@RequestParam(value="editor",required = false)String editor, @RequestParam(value = "state",required = false)Integer state){
        logger.info("条件查询被调用");
        logger.info("查询条件为"+editor+"，"+state);
        Map<String,Object> map=new HashMap();
        List<Banner> banners=bannerService.getBanner(editor,state);
        if (banners == null || banners.size() == 0) {
            map.put("code", 100);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "查询成功");
            map.put("data", banners);
        }
        logger.info("查询结果:" + banners);
        return map;
    }
    /**
     * 按id删除banner图
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/banner/{id}" ,method = RequestMethod.DELETE)
    public Map deleteBanner(@PathVariable Long id){
        logger.info("删除被调用");
        logger.info("被删除数据的id为："+id);
        Map<String,Object> map=new HashMap();
        int number=bannerService.deleteByPrimaryKey(id);
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
     * 动态更新banner图
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/banner",method = RequestMethod.PUT)
    public Map updateById(Banner banner){
        logger.info("编辑被调用");
        Map<String,Object> map=new HashMap();
        int a=bannerService.updateByPrimaryKeySelective(banner);
        if(a==0) {
            map.put("code", 100);
            map.put("message", "编辑失败");
        }else{
            map.put("code",0);
            map.put("message","编辑成功");
        }
        logger.info("编辑改动部分为：" + banner);
        return map;
    }
    /**
     * 查询单个banner图
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/banner/{id}",method = RequestMethod.GET)
    public Map getById(@PathVariable Long id ){
        logger.info("单个查询被调用");
        logger.info("查询id为"+id);
        Map<String,Object> map=new HashMap();
        Banner banner=bannerService.selectByPrimaryKey(id);
        if (banner == null ) {
            map.put("code", 100);
            map.put("message", "单个查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "单个查询成功");
            map.put("data", banner);
        }
        logger.info("：查询结果" + banner);
        return map;
    }
}

