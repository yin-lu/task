package com.yl.controller;

import com.yl.entity.Message;
import com.yl.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class MessageController {
    static java.util.logging.Logger logger= Logger.getLogger(String.valueOf(MessageController.class));
    @Autowired
    MessageService messageService;
    /**
     *增加留言
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/message",method = RequestMethod.POST)
    public Map addMessage(Message message){
        logger.info("添加方法被调用");
        Map<String,Object> map=new HashMap();
        int number=messageService.insert(message);
        if(number==0) {
            map.put("code", 100);
            map.put("message", "添加失败");
        }else{
            map.put("code",0);
            map.put("message","添加成功");
        }
        logger.info("添加结果为："+message);
        return map;
    }
    /**
     * 条件多个查询
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/message",method = RequestMethod.GET)
    public Map listMessage(@RequestParam(value="articleId",required = false)Long articleId, @RequestParam(value = "state",required = false)Integer state){
        logger.info("条件查询被调用");
        Map<String,Object> map=new HashMap();
        logger.info("查询条件为"+articleId+"，"+state);
        List<Message> messages=messageService.getMessage(articleId,state);
        if (messages == null || messages.size() == 0) {
            map.put("code", 100);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "查询成功");
            map.put("data", messages);
        }
        logger.info("：查询结果" + messages);
        return map;
    }
    /**
     * 按id删除留言
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/message/{id}" ,method = RequestMethod.DELETE)
    public Map deleteMessage(@PathVariable Long id){
        logger.info("删除被调用");
        logger.info("被删除数据的id为："+id);
        Map<String,Object> map=new HashMap();
        int number=messageService.deleteByPrimaryKey(id);
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
     * 动态更新留言
     * */
    @ResponseBody
    @RequestMapping(value = "/a/u/message",method = RequestMethod.PUT)
    public Map updateById(Message message){
        logger.info("编辑被调用");
        Map<String,Object> map=new HashMap();
        int a=messageService.updateByPrimaryKeySelective(message);
        if(a==0) {
            map.put("code", 100);
            map.put("message", "编辑失败");
        }else{
            map.put("code",0);
            map.put("message","编辑成功");
        }
        logger.info("编辑改动部分为：" + message);
        return map;
    }
    /**
     * 查询单个留言
     * */
    @ResponseBody
    @RequestMapping(value ="/a/u/message/{id}",method = RequestMethod.GET)
    public Map getById(@PathVariable Long id){
        logger.info("单个查询被调用");
        logger.info("查询id为"+id);
        Map<String,Object> map=new HashMap();
        Message message=messageService.selectByPrimaryKey(id);
        if (message == null ) {
            map.put("code", 100);
            map.put("message", "单个查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "单个查询成功");
            map.put("data", message);
        }
        logger.info("：查询结果" + message);
        return map;
    }
}

