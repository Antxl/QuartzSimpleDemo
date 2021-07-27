package com.antxl.simplequartzdemo.controller;

import com.antxl.simplequartzdemo.service.QuartzTestService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("task")
@Setter(onMethod_={@Autowired})
public class TaskController {
    private QuartzTestService quartzTestService;

    @PostMapping("add")
    public void addContextItem(@RequestParam(name = "item") String item){
        quartzTestService.addGlobalItem(item);
    }

    @RequestMapping("pause")
    public void pauseTask(){
        quartzTestService.pauseTimelyTask();
    }

    @RequestMapping("resume")
    public void resumeTask(){
        quartzTestService.resumeTimelyTask();
    }

    @RequestMapping("trigger")
    public void forceRunTask(){
        quartzTestService.forceRunTask();
    }
}
