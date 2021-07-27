package com.antxl.simplequartzdemo.service;

public interface QuartzTestService {
    void addGlobalItem(String item);
    void pauseTimelyTask();
    void resumeTimelyTask();
    void forceRunTask();
}
