//package com.yl.utils;
//
//import com.yl.service.JobService;
//import com.yl.service.StudentService;
//import com.yl.service.UserService;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.remoting.rmi.RmiProxyFactoryBean;
//
//public class RMIService {
//    static Logger logger = Logger.getLogger(String.valueOf(RMIService.class));
//
//    @Autowired
//    @Qualifier("student")
//    private RmiProxyFactoryBean rmiProxyFactoryStudent;
//
//    @Autowired
//    @Qualifier("job")
//    private RmiProxyFactoryBean rmiProxyFactoryJob;
//
//    @Autowired
//    @Qualifier("user")
//    private RmiProxyFactoryBean rmiProxyFactoryUser;
//
//    public StudentService getStudentService(){
//        StudentService studentService;
//        studentService =(StudentService) rmiProxyFactoryStudent.getObject();
//        return studentService;
//    }
//
//    public JobService getJobService(){
//        JobService jobService;
//        jobService =(JobService) rmiProxyFactoryJob.getObject();
//        return jobService;
//    }
//
//    public UserService getUserService(){
//        UserService userService;
//        userService =(UserService) rmiProxyFactoryUser.getObject();
//        return userService;
//    }
//}