package com.yl;

import com.yl.entity.User;
import com.yl.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


//声明时spring的测试类
@RunWith(SpringJUnit4ClassRunner.class)
//定位Spring配置文件
@ContextConfiguration("classpath:springMybatis.xml")
public class UserTest {
    static Logger logger = Logger.getLogger(UserTest.class);
    @Autowired
    private UserService userService;
    User user = new User();

    @Test
    public void deleteByPrimaryKey() {
        userService.deleteByPrimaryKey((long) 10);
    }

    @Test
    public void insert() {
        user.setName("关关");
        user.setPassword("y123456");
        user.setRole("销售");
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        user.setEditor("张三");
        userService.insert(user);
        logger.info("添加成功");
    }

    @Test
    public void updateByPrimaryKeySelective() {
        user.setId((long) 1);
        user.setPassword("123555");
        userService.updateByPrimaryKeySelective(user);
    }

    @Test
    public void selectByPrimaryKey() {
        user = userService.selectByPrimaryKey((long) 1);
        logger.info(user.toString());
    }
    @Test
    public void getUser() {
        List<User> list = userService.getUser(null,"运营");
        for(User u : list) {
            logger.info(u);
        }
    }
}