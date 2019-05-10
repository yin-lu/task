package com.yl;

import com.yl.entity.Banner;
import com.yl.service.BannerService;
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
public class BannerTest {

    static Logger logger = Logger.getLogger(FirstTest.class);

    @Autowired
    private BannerService bannerService;
   Banner banner=new Banner();

    @Test
    public void deleteByPrimaryKey() {
        bannerService.deleteByPrimaryKey((long) 3);
    }
    @Test
    public  void insert(){
        banner.setCover("动物");
        banner.setUrl("www.1234.com");
        banner.setState(1);
        banner.setCreateAt(System.currentTimeMillis());
        banner.setUpdateAt(System.currentTimeMillis());
        banner.setEditor("张三");
        bannerService.insert(banner);
    }
    @Test
    public void updateByPrimaryKeySelective() {
        banner.setId((long) 1);
        banner.setState(0);
        bannerService.updateByPrimaryKeySelective(banner);
    }

    @Test
    public void selectByPrimaryKey() {
        banner = bannerService.selectByPrimaryKey((long) 1);
        logger.info(banner);
    }
    @Test
    public void getBanner() {
        List<Banner> list = bannerService.getBanner(null,1);
        for(Banner b : list) {
            logger.info(b);
        }
    }
}