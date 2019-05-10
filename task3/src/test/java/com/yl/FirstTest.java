package com.yl;

import com.yl.entity.First;
import com.yl.service.FirstService;
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
public class FirstTest {

    static Logger logger = Logger.getLogger(FirstTest.class);

    @Autowired
    private FirstService firstService;
    First first = new First();

    @Test
    public void deleteByPrimaryKey() {
        firstService.deleteByPrimaryKey((long) 3);
    }
    @Test
    public  void insert(){
        first.setName("架上绘画装置");
        first.setState(1);
        first.setCreateAt(System.currentTimeMillis());
        first.setUpdateAt(System.currentTimeMillis());
        first.setEditor("张三");
        firstService.insert(first);
    }
    @Test
    public void updateByPrimaryKeySelective() {
        first.setId((long) 1);
        first.setState(0);
        firstService.updateByPrimaryKeySelective(first);
    }

    @Test
    public void selectByPrimaryKey() {
        first = firstService.selectByPrimaryKey((long) 1);
        logger.info(first.getName());
    }
    @Test
    public void getFirst() {
        List<First> list = firstService.getFirst("架上绘画装置",null);
        for(First f : list) {
            logger.info(f);
        }
    }
}
