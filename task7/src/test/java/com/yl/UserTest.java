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
        user.setImage("111");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userService.addUser(user);
    }
//    @Test
//    public void delete(){
//        userService.deleteUser(3);
//    }
    @Test
    public void updateSelective(){
        User user=new User();
        user.setId(46);
        user.setImage("http://ylcom-1258882338.cos.ap-chengdu.myqcloud.com/1560771934927.png");
//        user.setName("小米");
//        user.setPwd("123456");
//        user.setPhone("1521479635");
//        user.setEmail("www.xy.com");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userService.updateSelective(user);
    }
    @Test
    public void getByName(){
        User user=userService.getByName("666");
        logger.info(String.valueOf(user));
    }

    @Test
    public void getByPhone(){
        User user=userService.getByPhone("15886423685");
        logger.info(String.valueOf(user));
    }

    @Test
    public void getByEmail(){
        User user=userService.getByEmail("eee");
        logger.info(String.valueOf(user));
    }
    @Test
    public void getById(){
        User user=userService.getById((long) 32);
        logger.info(String.valueOf(user));
    }

//    @Test
//    public void login(){
//        User user=userService.login("小明","123456");
//        logger.info(String.valueOf(user));
//    }
//    @Test
//    public void listUser(){
//        List<User> users=userService.listUser();
//        for (User user:users){
//            logger.info(String.valueOf(user));
//        }
//    }

}
