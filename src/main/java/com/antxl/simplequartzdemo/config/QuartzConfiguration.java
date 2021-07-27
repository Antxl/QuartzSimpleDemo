package com.antxl.simplequartzdemo.config;

import com.antxl.simplequartzdemo.scheduling.ContextTestTask;
import com.antxl.simplequartzdemo.scheduling.TimelyInvokedTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfiguration {
    public static final String TIMELY_JOB_KEY = "timelyTask";
    public static final String CONTEXT_JOB_KEY = "contextTask";
    public static final String TIMELY_TRIGGER_KEY = "timelyTrigger";
    public static final String CONTEXT_TRIGGER_KEY = "contextTrigger";
    public static final String TRIGGER_TEST_KEY = "testKey";
    public static final String GLOBAL_TEST_KEY = "globalKey";

    @Bean("timelyJob")
    public JobDetail getTimelyJob(){
        return JobBuilder.newJob(TimelyInvokedTask.class)
                .withIdentity(TIMELY_JOB_KEY)
                .storeDurably().build();
    }

    @Bean("contextJob")
    public JobDetail getContextTestJob(){
        return JobBuilder.newJob(ContextTestTask.class)
                .withIdentity(CONTEXT_JOB_KEY)
                .storeDurably().build();
    }

    @Bean("timelyJobTrigger")
    public Trigger getTimelyTrigger(){
        ScheduleBuilder<CronTrigger> scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0-59 * * * ? *")
                .withMisfireHandlingInstructionDoNothing();
        return TriggerBuilder.newTrigger().forJob(TIMELY_JOB_KEY)
                .withSchedule(scheduleBuilder)
                .withIdentity(TIMELY_TRIGGER_KEY)
                .startNow().build();
    }

    @Bean("contextJobTrigger")
    public Trigger getContextTestTrigger(){
        ScheduleBuilder<CronTrigger> scheduleBuilder = CronScheduleBuilder.cronSchedule("1 0-59 * * * ? *")
                .withMisfireHandlingInstructionDoNothing();
        return TriggerBuilder.newTrigger().forJob(CONTEXT_JOB_KEY)
                .withSchedule(scheduleBuilder)
                .withIdentity(CONTEXT_TRIGGER_KEY)
                .usingJobData(TRIGGER_TEST_KEY, "context aware!")
                .startNow().build();
    }

    @Bean("testScheduler")
    public Scheduler getScheduler(SchedulerFactoryBean schedulerFactoryBean){
        return schedulerFactoryBean.getScheduler();
    }
}
