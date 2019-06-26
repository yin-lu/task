//package com.yl;
//
//import com.yl.entity.Job;
//import com.yl.entity.Student;
//import com.yl.service.JobService;
//import com.yl.service.StudentService;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//import java.util.logging.Logger;
//
//public class TestRMI {
//
//
//    static Logger logger = Logger.getLogger(String.valueOf(TestRMI.class));
//        @Test
//        public void getById() {
//            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springMybatis.xml");
//            StudentService studentService = (StudentService) applicationContext.getBean("student1");
//            Student s = studentService.getById(4);
//            logger.info(String.valueOf(s));
//        }
//
//    @Test
//    public void directionList(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springMybatis.xml");
//        JobService jobService = (JobService) applicationContext.getBean("job");
//
//        List<Job> jobs=jobService.list();
//        for(Job job:jobs){
//            logger.info(String.valueOf(job));
//        }
//    }
//    }
//
