package com.yl;

import com.yl.entity.Job;
import com.yl.service.impl.JobServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springMybatis.xml")
public class JobTest {
    static Logger logger = Logger.getLogger(String.valueOf(JobTest.class));
    @Autowired
    JobServiceImpl jobService;

    @Test
    public void directionList() {
        List<Job> jobs = jobService.list();
        for (Job job : jobs) {
            logger.info(String.valueOf(job));
        }
    }

}
