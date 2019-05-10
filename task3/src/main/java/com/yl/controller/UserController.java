package com.yl.controller;


import com.yl.entity.User;
import com.yl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class UserController {
    static Logger logger=Logger.getLogger(String.valueOf(UserController.class));
    @Autowired
    UserService userService;
    /**
     *增加用户
     * */
    @ResponseBody
    @RequestMapping(value = "/a/user",method = RequestMethod.POST)
    public Map addUser(User user){
      logger.info("添加方法被调用");
      Map<String,Object> map=new HashMap();
      int number=userService.insert(user);
      if(number==0) {
          map.put("code", 100);
          map.put("message", "添加失败");
      }else{
          map.put("code",0);
          map.put("message","添加成功");
      }
      logger.info("添加结果为："+user);
      return map;
    }
    /**
     * 条件多个查询
     * */
    @ResponseBody
    @RequestMapping(value ="/a/user",method = RequestMethod.GET)
    public Map listUser(@RequestParam(value="name",required = false)String name,@RequestParam(value = "role",required = false)String role){
      logger.info("条件查询被调用");
        logger.info("查询条件为"+name+"，"+role);
        Map<String,Object> map=new HashMap();
        List<User> users=userService.getUser(name,role);
        if (users == null || users.size() == 0) {
            map.put("code", 100);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "查询成功");
            map.put("data", users);
        }
        logger.info("：查询结果" + users);
        return map;
    }
    /**
     * 按id删除用户
     * */
    @ResponseBody
    @RequestMapping(value = "/a/user/{id}" ,method = RequestMethod.DELETE)
    public Map deleteUser(@PathVariable Long id){
        logger.info("删除被调用");
        logger.info("被删除数据的id为："+id);
        Map<String,Object> map=new HashMap();
        int number=userService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/a/user",method = RequestMethod.PUT)
    public Map updateById(User user){
        logger.info("编辑被调用");
        Map<String,Object> map=new HashMap();
        int number=userService.updateByPrimaryKeySelective(user);
        if(number==0) {
            map.put("code", 100);
            map.put("message", "编辑失败");
        }else{
            map.put("code",0);
            map.put("message","编辑成功");
        }
        logger.info("编辑改动部分为：" + user);
        return map;
    }
    /**
     * 查询单个作品
     * */
    @ResponseBody
    @RequestMapping(value ="/a/user/{id}",method = RequestMethod.GET)
    public Map getById(@PathVariable Long id){
        logger.info("单个查询被调用");
        logger.info("查询id为"+id);
        Map<String,Object> map=new HashMap();
        User user=userService.selectByPrimaryKey(id);

        if (user == null ) {
            map.put("code", 100);
            map.put("message", "单个查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 0);
            map.put("message", "单个查询成功");
            map.put("data", user);
        }
        logger.info("：查询结果" + user);
        return map;
    }
}
