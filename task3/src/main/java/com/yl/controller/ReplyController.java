package com.yl.controller;

import com.yl.entity.Reply;
import com.yl.service.ReplyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReplyController {
  static Logger logger=Logger.getLogger(String.valueOf(ReplyController.class));

  @Autowired
  ReplyService replyService;
    /**
     *增加回复
     * */
  @ResponseBody
  @RequestMapping(value ="/a/u/reply",method = RequestMethod.POST)
  public Map addReply(Reply reply){
      logger.info("调用添加方法");
      Map<String,Object> map=new HashMap();
      int number=replyService.insert(reply);
      if(number==0) {
          map.put("code", 100);
          map.put("message", "添加失败");
      }else{
          map.put("code",0);
          map.put("message","添加成功");
      }
      logger.info("添加结果为："+reply);
      return map;
  }
    /**
     * 条件多个查询
     * */
  @ResponseBody
  @RequestMapping(value = "/a/u/reply",method = RequestMethod.GET)
  public Map listReply(@RequestParam(value="messageId",required = false)Long messageId){
      logger.info("调用条件查询");
      logger.info("查询条件为"+messageId);
      List<Reply> replys=replyService.getReply(messageId);
      Map<String,Object> map=new HashMap();
      if(replys==null || replys.size()==0) {
          map.put("code", 100);
          map.put("message", "条件查询失败");
          map.put("data", "无法查询");
      }else {
          map.put("code", 100);
          map.put("message", "条件查询成功");
          map.put("data", replys);
      }
      logger.info("查询结果：" +replys);
      return map;
  }
    /**
     * 按id删除回复
     * */
  @ResponseBody
  @RequestMapping(value = "/a/u/reply/{id}",method = RequestMethod.DELETE)
  public Map deleteReply(@PathVariable Long id){
      logger.info("调用删除方法");
      logger.info("被删除数据的id为："+id);
      Map<String,Object> map=new HashMap();
      int number=replyService.deleteByPrimaryKey(id);
      if(number==0) {
          map.put("code", 100);
          map.put("message", "删除失败");
      }else{
          map.put("code",0);
          map.put("message","删除成功");
      }
      logger.info(id);
      return map;
  }
    /**
     * 动态更新回复
     * */
  @ResponseBody
  @RequestMapping(value = "/a/u/reply",method = RequestMethod.PUT)
  public Map updateReply(Reply reply){
      logger.info("调用编辑方法");
      Map<String,Object> map=new HashMap();
      int number=replyService.updateByPrimaryKeySelective(reply);
      if(number==0) {
          map.put("code", 100);
          map.put("message", "编辑失败");
      }else{
          map.put("code",0);
          map.put("message","编辑成功");
      }
      logger.info("编辑改动部分为：" + reply);
      return map;
  }
    /**
     * 查询单个回复
     * */
  @ResponseBody
  @RequestMapping(value = "/a/u/reply/{id}",method =RequestMethod.GET)
  public Map getById(@PathVariable Long id){
      logger.info("调用单个查询");
      logger.info("查询id为"+id);
      Map<String,Object> map=new HashMap();
      Reply reply=replyService.selectByPrimaryKey(id);
      if(reply==null){
          map.put("code", 100);
          map.put("message", "单个查询失败");
          map.put("data", "无法查询");
      }else {
          map.put("code", 100);
          map.put("message", "单个查询成功");
          map.put("data", reply);
      }
      logger.info("查询结果：" +reply);
      return map;
  }
}
