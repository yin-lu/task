package com.yl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRMI {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springMybatis.xml");
        System.out.println("服务端1开启");
    }
}
