package com.yl.controller;

import com.yl.entity.Job;
import com.yl.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class JobController {
    static Logger logger = Logger.getLogger(String.valueOf(JobController.class));
    @Autowired
    JobServiceImpl jobService;

    @RequestMapping(value = "/job")
    public String job(Model model) {
        System.out.println("进入职业分类");
        List<Job> jobs=jobService.list();
        for(Job job:jobs){
           logger.info("前端方向"+job);
        }
        model.addAttribute("jobs",jobs) ;
        return "jobTiles";//返回tiles定义中的name
    }
}