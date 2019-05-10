package com.yl;

import com.yl.entity.Second;
import com.yl.service.SecondService;
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
public class SecondTest {

    static Logger logger = Logger.getLogger(FirstTest.class);

    @Autowired
    private SecondService secondService;
    Second second = new Second();

    @Test
    public void deleteByPrimaryKey() {
        secondService.deleteByPrimaryKey((long) 1);
    }
    @Test
    public  void insert(){
        second.setName("垂钓者空间");
        second.setFirstId((long)1);
        second.setState(1);
        second.setCreateAt(System.currentTimeMillis());
        second.setUpdateAt(System.currentTimeMillis());
        second.setEditor("张飞");
        secondService.insert(second);
    }
    @Test
    public void updateByPrimaryKeySelective() {
        second.setId((long) 1);
        second.setState(0);
        secondService.updateByPrimaryKeySelective(second);
    }

    @Test
    public void selectByPrimaryKey() {
        second = secondService.selectByPrimaryKey((long) 1);
        logger.info(second);
    }
    @Test
    public void getSecond() {
        List<Second> list = secondService.getSecond(null,1);
        for(Second s : list) {
            logger.info(s);
        }
    }
}
