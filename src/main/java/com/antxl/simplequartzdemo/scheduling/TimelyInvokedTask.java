package com.antxl.simplequartzdemo.scheduling;

import com.antxl.simplequartzdemo.common.DateUtil;
import lombok.Setter;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Optional;

@Setter
public class TimelyInvokedTask extends QuartzJobBean {
    private String globalKey;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("TestQuartz----Timely:" + DateUtil.now() +
                " globalKey: " + Optional.ofNullable(globalKey).orElse("None"));
    }
}
