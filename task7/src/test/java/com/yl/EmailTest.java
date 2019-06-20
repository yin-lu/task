package com.yl;

import com.yl.utils.RandonNumberUtils;
import com.yl.utils.SendEmail;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class EmailTest {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springMybatis.xml");
    SendEmail sendEmail= (SendEmail) applicationContext.getBean("emailSending");

    @Test
    public void emailTest(){
        String email="23191875790@qq.com";
        String emailCode= RandonNumberUtils.getRandonString(4);
        try {
            sendEmail.sendingEmail(email,emailCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
