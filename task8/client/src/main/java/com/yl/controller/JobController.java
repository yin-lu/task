package com.yl.controller;

import com.yl.entity.Job;
import com.yl.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("")
public class JobController {


    @Resource
    JobService jobService;

    @RequestMapping(value = "/job")
    public String job(Model model) {

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springMybatis.xml");
//        JobService jobService = (JobService) applicationContext.getBean("job");
//        static Logger logger = Logger.getLogger(String.valueOf(JobController.class));
        System.out.println("进入职业分类");
        List<Job> jobs=jobService.list();
//        for(Job job:jobs){
//           logger.info("前端方向"+job);
//        }
        model.addAttribute("jobs",jobs) ;
        return "jobTiles";//返回tiles定义中的name
    }
}