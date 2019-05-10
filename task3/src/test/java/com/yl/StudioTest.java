package com.yl;

import com.yl.entity.Studio;
import com.yl.service.StudioService;
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
public class StudioTest {

    static Logger logger = Logger.getLogger(FirstTest.class);

    @Autowired
    private StudioService studioService;
    Studio studio = new Studio();

    @Test
    public void deleteByPrimaryKey() {
        studioService.deleteByPrimaryKey((long) 3);
    }
    @Test
    public  void insert(){
        studio.setName("工作室简介");
        studio.setPicture("动物画");
        studio.setText("好看");
        studio.setState(1);
        studio.setCreateAt(System.currentTimeMillis());
        studio.setUpdateAt(System.currentTimeMillis());
        studio.setEditor("张飞");
        studioService.insert(studio);
    }
    @Test
    public void updateByPrimaryKeySelective() {
        studio.setId((long) 1);
        studio.setState(0);
        studioService.updateByPrimaryKeySelective(studio);
    }

    @Test
    public void selectByPrimaryKey() {
        studio = studioService.selectByPrimaryKey((long) 1);
        logger.info(studio);
    }
    @Test
    public void getStudio() {
        List<Studio> list = studioService.getStudio("工作室简介",null);
        for(Studio s : list) {
            logger.info(s);
        }
    }
}