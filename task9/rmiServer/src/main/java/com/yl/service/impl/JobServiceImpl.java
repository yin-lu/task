package com.yl.service.impl;

import com.yl.entity.Job;
import com.yl.mapper.JobMapper;
import com.yl.service.JobService;
import com.yl.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService{

    @Autowired
    private JobMapper mapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Job> list() {

     List<Job> jobs= (List<Job>) redisUtil.get("jobs");
     if (jobs==null){
         jobs=mapper.list();
         redisUtil.set("jobs",jobs, Long.valueOf(6000));
         System.out.println(jobs);
     }
        return jobs;

    }

}
