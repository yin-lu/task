package com.yl;

import com.yl.entity.Reply;
import com.yl.service.ReplyService;
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
public class ReplyTest {

    static Logger logger = Logger.getLogger(FirstTest.class);

    @Autowired
    private ReplyService replyService;
    Reply reply = new Reply();

    @Test
    public void deleteByPrimaryKey() {
        replyService.deleteByPrimaryKey((long) 3);
    }
    @Test
    public  void insert(){
        reply.setNick("YYUH");
        reply.setMessageId((long)1);
        reply.setWord("好书");
        reply.setCreateAt(System.currentTimeMillis());
        reply.setUpdateAt(System.currentTimeMillis());
        reply.setEditor("刘备");
        replyService.insert(reply);
    }
    @Test
    public void updateByPrimaryKeySelective() {
        reply.setId((long) 1);
        reply.setNick("shjsh");
        reply.setMessageId((long)2);
        reply.setWord("垃圾书");
        replyService.updateByPrimaryKeySelective(reply);
    }

    @Test
    public void selectByPrimaryKey() {
        reply = replyService.selectByPrimaryKey((long) 1);
        logger.info(reply);
    }
    /**
     * 根据id条件查询
     * */
    @Test
    public void getReply() {
        List<Reply> list =replyService.getReply((long)1);
        for(Reply r : list) {
            logger.info(r);
        }
    }
}
