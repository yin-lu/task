package com.yl;

import com.yl.entity.Message;
import com.yl.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

//声明时spring的测试类
@RunWith(SpringJUnit4ClassRunner.class)
//定位Spring配置文件
@ContextConfiguration("classpath:springMybatis.xml")
public class MessageTest {

    static Logger logger=Logger.getLogger(String.valueOf(MessageTest.class));

    @Autowired
    private MessageService messageService;
    Message message=new Message();

    @Test
    public void delete(){
        messageService.deleteByPrimaryKey((long) 10);
    }

    @Test
    public void insert() {
//        message.setId((long)1);
        message.setArticleId((long)2);
        message.setNick("lyxs2255");
        message.setState(0);
        message.setCreateAt(System.currentTimeMillis());
        message.setUpdateAt(System.currentTimeMillis());
        message.setEditor("张三");
        messageService.insert(message);
        logger.info("添加成功");
    }

    @Test
    public void updateByPrimaryKeySelective() {
        message.setId((long) 1);
        message.setState(1);
        messageService.updateByPrimaryKeySelective(message);
    }

    @Test
    public void selectByPrimaryKey() {
        message = messageService.selectByPrimaryKey((long) 1);
        logger.info(message.toString());
    }
    @Test
    public void getUser() {
        List<Message> list = messageService.getMessage(null,1);
        for(Message user : list) {
            System.out.println(list);
        }
    }
}



