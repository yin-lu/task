//package com.yl;
//
//import com.yl.utils.RandonNumberUtils;
//import com.yl.utils.SMS;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//
//public class SDKTestSendTemplateSMS {
//    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springMybatis.xml");
//    SMS sms= (SMS) applicationContext.getBean("smsSDK");
//
//    @Test
//    public void msgTest(){
//        String phone="15886423685";
//        String msgCode= RandonNumberUtils.getRandonString(6);
//        sms.smsSending(phone,msgCode);
//    }
//}
//
//
