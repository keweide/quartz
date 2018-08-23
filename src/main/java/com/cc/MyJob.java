package com.cc;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 任务
 */
public class MyJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        // context 获取 jobdetail 传过来的参数
        System.out.println("hello world");
    }
}
