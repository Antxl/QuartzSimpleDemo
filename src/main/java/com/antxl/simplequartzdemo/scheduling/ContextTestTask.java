package com.antxl.simplequartzdemo.scheduling;

import com.antxl.simplequartzdemo.common.DateUtil;
import com.antxl.simplequartzdemo.config.QuartzConfiguration;
import lombok.Setter;
import lombok.SneakyThrows;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Optional;

@Setter
public class ContextTestTask extends QuartzJobBean {
    private String testKey;
    private String globalKey;

    @SneakyThrows
    @Override
    protected void executeInternal(JobExecutionContext context) {
        System.out.println("TestQuartz----Context:" + DateUtil.now() + '\n' +
                QuartzConfiguration.TRIGGER_TEST_KEY + ": " + Optional.ofNullable(testKey).orElse("None") + ' ' +
                QuartzConfiguration.GLOBAL_TEST_KEY + ": " + Optional.ofNullable(globalKey).orElse("None"));
    }
}
