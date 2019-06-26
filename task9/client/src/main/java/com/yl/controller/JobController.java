package com.yl.controller;

import com.yl.entity.Job;
import com.yl.service.JobService;

import com.yl.service.TusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class JobController {

    @Autowired
    private TusService tusService;
    private JobService jobService;

    @RequestMapping(value = "/job")
    public String job(Model model) {
        jobService=tusService.getJobService();
        System.out.println("进入职业分类");
        List<Job> jobs=jobService.list();
        model.addAttribute("jobs",jobs) ;
        return "jobTiles";//返回tiles定义中的name
    }
}