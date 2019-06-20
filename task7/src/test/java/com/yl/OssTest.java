package com.yl;

import com.yl.utils.OssClientUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OssTest {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springMybatis.xml");
    OssClientUtil ossClientUtil= (OssClientUtil) applicationContext.getBean("ossClientUtil");

    @Test
    public void demo()throws Exception{
//            String key="/image/1.jpg";

//            String key = UUID.randomUUID().toString();
        String url="C:\\Users\\YL\\Desktop\\1.jpg";
        ossClientUtil.uploadImg2Oss(url);
    }
}