package com.antxl.simplequartzdemo.service.impl;

import com.antxl.simplequartzdemo.config.QuartzConfiguration;
import com.antxl.simplequartzdemo.service.QuartzTestService;
import lombok.Setter;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("quartzTestService")
@Setter(onMethod_={@Autowired})
class QuartzTestServiceImpl implements QuartzTestService {
    private Scheduler testScheduler;

    @Override
    public void pauseTimelyTask() {
        JobKey key = new JobKey(QuartzConfiguration.TIMELY_JOB_KEY);
        try {
            testScheduler.pauseJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resumeTimelyTask() {
        JobKey key = new JobKey(QuartzConfiguration.TIMELY_JOB_KEY);
        try {
            testScheduler.resumeJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void forceRunTask() {
        JobKey key = new JobKey(QuartzConfiguration.TIMELY_JOB_KEY);
        try {
            testScheduler.triggerJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
