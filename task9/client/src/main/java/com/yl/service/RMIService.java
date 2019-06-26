//package com.yl.service;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.remoting.rmi.RmiProxyFactoryBean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RMIService {
//
//    static Logger logger = Logger.getLogger(String.valueOf(RMIService.class));
//
//    /**
//     * 分别注入2个service,其中每个包括4项服务：ProfessionService,UserService,StudentService,UploadService
//     */
//
//    @Autowired
//    @Qualifier("studentService1")
//    private RmiProxyFactoryBean rmiProxyFactoryStudent1;
//
//
//    @Autowired
//    @Qualifier("studentService2")
//    private RmiProxyFactoryBean rmiProxyFactoryStudent2;
//
//    @Autowired
//    @Qualifier("userService1")
//    private RmiProxyFactoryBean rmiProxyFactoryUser1;
//
//
//    @Autowired
//    @Qualifier("userService2")
//    private RmiProxyFactoryBean rmiProxyFactoryUser2;
//
//    @Autowired
//    @Qualifier("jobService1")
//    private RmiProxyFactoryBean rmiProxyFactoryJob1;
//
//
//    @Autowired
//    @Qualifier("jobService2")
//    private RmiProxyFactoryBean rmiProxyFactoryJob2;
//
//
//    /**
//     * 随机数获取 StudentService (利用三目表达式） eg: A?B:C ,A为true,则为B,A为false,则为C
//     * 随机生成（0,1）内的数字，大于0.5 启动第1个service,小于0.5，则启动第2个service
//     * 如果发生异常，特别是与RMI相关的异常，则直接切换除自己以外的服务端
//     *
//     * @return studentService
//     */
//    public StudentService getStudentService() {
//        StudentService studentService ;
//        int randomNum = Math.random() >= 0.5 ? 1 : 0;
//        if (1 == randomNum) {
//            try {
//                studentService = (StudentService) rmiProxyFactoryStudent2.getObject();
//            } catch (Exception e) {
//                studentService = (StudentService) rmiProxyFactoryStudent1.getObject();
//            }
//        } else {
//            try {
//                studentService = (StudentService) rmiProxyFactoryStudent1.getObject();
//            } catch (Exception e) {
//                studentService = (StudentService) rmiProxyFactoryStudent2.getObject();
//            }
//        }
//        logger.info(" studentService:{}=" + studentService);
//        return studentService;
//    }
//
//    public UserService getUserService() {
//        UserService userService ;
//        int randomNum = Math.random() >= 0.5 ? 1 : 0;
//        if (1 == randomNum) {
//            try {
//                userService = (UserService) rmiProxyFactoryUser1.getObject();
//            } catch (Exception e) {
//                userService = (UserService) rmiProxyFactoryUser2.getObject();
//            }
//        } else {
//            try {
//                userService = (UserService) rmiProxyFactoryUser2.getObject();
//            } catch (Exception e) {
//                userService = (UserService) rmiProxyFactoryUser1.getObject();
//            }
//        }
//        logger.info("  userService:{}=" + userService);
//        return userService;
//    }
//
//    public JobService getJobService() {
//        JobService jobService ;
//        int randomNum = Math.random() >= 0.5 ? 1 : 0;
//        if (1 == randomNum) {
//            try {
//                jobService = (JobService) rmiProxyFactoryJob1.getObject();
//            } catch (Exception e) {
//                jobService = (JobService) rmiProxyFactoryJob2.getObject();
//            }
//        } else {
//            try {
//                jobService = (JobService) rmiProxyFactoryJob2.getObject();
//            } catch (Exception e) {
//                jobService = (JobService) rmiProxyFactoryJob1.getObject();
//            }
//        }
//        logger.info("jobService:{}=" + jobService);
//        return jobService;
//    }
//}