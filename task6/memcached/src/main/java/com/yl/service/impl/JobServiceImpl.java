package com.yl.service.impl;

import com.yl.entity.Job;
import com.yl.mapper.JobMapper;
import com.yl.service.JobService;
import com.yl.utils.MemcachedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("jobService")
public class JobServiceImpl implements JobService {

    Logger logger = Logger.getLogger(String.valueOf(JobServiceImpl.class));

    @Autowired
    private JobMapper mapper;

    @Override
    public List<Job> list() {


        List<Job> jobs;
        if (MemcachedUtil.get("listJob") == null) {
            jobs = mapper.list();
            logger.info("开始缓存" + jobs);
            MemcachedUtil.set("list", jobs, 60 * 60 * 24);
        } else {
            jobs = (List<Job>) MemcachedUtil.get("listJob");
            logger.info("从缓存中取到的值" + jobs);
        }
        return jobs;
    }
}
