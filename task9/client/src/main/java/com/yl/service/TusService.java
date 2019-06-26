package com.yl.service;

import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Logger;

@Component
public class TusService {
    static Logger logger = Logger.getLogger(String.valueOf(TusService.class));

    /**
     * 随机数获取 StudentService (利用三目表达式） eg: A?B:C ,A为true,则为B,A为false,则为C
     * 随机生成（0,1）内的数字，大于0.5 启动第1个service,小于0.5，则启动第2个service
     * 如果发生异常，特别是与RMI相关的异常，则直接切换除自己以外的服务端
     *
     * @return studentService
     */
    public StudentService getStudentService() {
        StudentService studentService = null;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                studentService = (StudentService) Naming.lookup("rmi://localhost:1199/studentService");
            } catch (Exception e) {
                logger.info("服务器1挂了，{}" + e);
                try {
                    studentService = (StudentService) Naming.lookup("rmi://localhost:1200/studentService");
                } catch (NotBoundException | MalformedURLException | RemoteException e1) {
                    logger.info("服务器1,2都挂了，{}" + e1);
                }
            }
        } else {
            try {
                studentService = (StudentService) Naming.lookup("rmi://localhost:1200/studentService");
            } catch (Exception e) {
                logger.info("服务器2挂了，{}" + e);
                try {
                    studentService = (StudentService) Naming.lookup("rmi://localhost:1199/studentService");
                } catch (NotBoundException | MalformedURLException | RemoteException e1) {
                    logger.info("服务器1,2都挂了，{}" + e1);
                }
            }
        }
        logger.info(" studentService:{}=" + studentService);
        return studentService;
    }

    public UserService getUserService() {
        UserService userService = null;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                userService = (UserService) Naming.lookup("rmi://localhost:1199/userService");
            } catch (Exception e) {
                logger.info("服务器1挂了，{}" + e);
                try {
                    userService = (UserService) Naming.lookup("rmi://localhost:1200/userService");
                } catch (NotBoundException | MalformedURLException | RemoteException e1) {
                    logger.info("服务器1,2都挂了，{}" + e1);
                }
            }
        } else {
            try {
                userService = (UserService) Naming.lookup("rmi://localhost:1200/userService");
            } catch (Exception e) {
                logger.info("服务器2挂了，{}" + e);
                try {
                    userService = (UserService) Naming.lookup("rmi://localhost:1199/userService");
                } catch (NotBoundException | MalformedURLException | RemoteException e1) {
                    logger.info("服务器1,2都挂了，{}" + e1);
                }
            }
        }
        logger.info("userService:{}=" + userService);
        return userService;
    }


    public JobService getJobService() {
        JobService jobService = null;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                jobService = (JobService) Naming.lookup("rmi://localhost:1199/jobService");
            } catch (Exception e) {
                logger.info("服务器1挂了，{}" + e);
                try {
                    jobService = (JobService) Naming.lookup("rmi://localhost:1200/jobService");
                } catch (NotBoundException | MalformedURLException | RemoteException e1) {
                    logger.info("服务器1,2都挂了，{}" + e1);
                }
            }
        } else {
            try {
                jobService = (JobService) Naming.lookup("rmi://localhost:1200/jobService");
            } catch (Exception e) {
                logger.info("服务器2挂了，{}" + e);
                try {
                    jobService = (JobService) Naming.lookup("rmi://localhost:1199/jobService");
                } catch (NotBoundException | MalformedURLException | RemoteException e1) {
                    logger.info("服务器1,2都挂了，{}" + e1);
                }
            }
        }
        logger.info("jobService:{}=" + jobService);
        return jobService;
    }
}