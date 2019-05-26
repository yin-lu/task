package com.yl.service.impl;

import com.yl.entity.Job;
import com.yl.mapper.JobMapper;
import com.yl.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService{

    @Autowired
    private JobMapper mapper;

    @Override
    public List<Job> list() {

        return mapper.list();
    }



}
