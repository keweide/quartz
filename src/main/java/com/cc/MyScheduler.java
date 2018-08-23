package com.cc;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyScheduler {

    public static void main(String[] args) throws Exception {
        //可执行的任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).
                withIdentity("myjob",                 //任务名
                        Scheduler.DEFAULT_GROUP)             //任务组
                .build();
        //触发器
        Trigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger",Scheduler.DEFAULT_GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0/1 * * * * ?"))) //cron时间表达式
                .build();
        //调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        scheduler.scheduleJob(jobDetail,cronTrigger);

        scheduler.start();

        //scheduler.clear();
    }
}
