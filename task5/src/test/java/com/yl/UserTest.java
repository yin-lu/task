package com.yl;

import com.yl.entity.User;
import com.yl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springMybatis.xml")
public class UserTest {

    static Logger logger=Logger.getLogger(String.valueOf(UserTest.class));

    @Autowired
    UserService userService;

    @Test
    public void add(){
        User user=new User();
        user.setName("小米");
        user.setPwd("123456");
        user.setPhone("15214796352");
        user.setEmail("www.xy.com");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userService.addUser(user);
    }
    @Test
    public void delete(){
        userService.deleteUser(3);
    }
    @Test
    public void update(){
        User user=new User();
        user.setId(1);
        user.setName("小米");
        user.setPwd("123456");
        user.setPhone("1521479635");
        user.setEmail("www.xy.com");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userService.updateUser(user);
    }
    @Test
    public void getUser(){
        User user=userService.getUser("小明");
        logger.info(String.valueOf(user));
    }

    @Test
    public void login(){
        User user=userService.login("小明","123456");
        logger.info(String.valueOf(user));
    }
    @Test
    public void listUser(){
        List<User> users=userService.listUser();
        for (User user:users){
            logger.info(String.valueOf(user));
        }
    }

}
