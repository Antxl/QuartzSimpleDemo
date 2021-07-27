package com.antxl.simplequartzdemo.config;

import com.antxl.simplequartzdemo.scheduling.TimelyInvokedTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfiguration {
    public static final String TIMELY_JOB_KEY = "timelyTask";
    public static final String TIMELY_TRIGGER_KEY = "timelyTrigger";

    @Bean
    public JobDetail getTimelyJob(){
        return JobBuilder.newJob(TimelyInvokedTask.class)
                .withIdentity(TIMELY_JOB_KEY)
                .storeDurably().build();
    }

    @Bean
    public Trigger getTimelyTrigger(){
        ScheduleBuilder<CronTrigger> scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0-59 * * * ? *")
                .withMisfireHandlingInstructionDoNothing();
        return TriggerBuilder.newTrigger().forJob(TIMELY_JOB_KEY)
                .withSchedule(scheduleBuilder)
                .withIdentity(TIMELY_TRIGGER_KEY)
                .startNow().build();
    }

    @Bean("testScheduler")
    public Scheduler getScheduler(SchedulerFactoryBean schedulerFactoryBean){
        return schedulerFactoryBean.getScheduler();
    }
}
