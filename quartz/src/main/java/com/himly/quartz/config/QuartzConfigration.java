package com.himly.quartz.config;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.List;

/**
 * create_at:MaZheng
 * create_by:${date} ${time}
 */
@Configuration
public class QuartzConfigration {


    @Bean(name = "test")
    public MethodInvokingJobDetailFactoryBean testDetail(Task task) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();

        //并发执行支持,详情请google
        jobDetail.setConcurrent(true);

        //任务基础信息
        jobDetail.setName("test");
        jobDetail.setGroup("test");

        jobDetail.setTargetObject(task);
        jobDetail.setTargetMethod("sayHello");

        return jobDetail;
    }


    @Bean(name = "test1")
    public MethodInvokingJobDetailFactoryBean testDetail1(Task task) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();

        //并发执行支持,详情请google
        jobDetail.setConcurrent(true);

        //任务基础信息
        jobDetail.setName("test1");
        jobDetail.setGroup("test1");

        jobDetail.setTargetObject(task);
        jobDetail.setTargetMethod("sayHello1");

        return jobDetail;
    }


    @Bean(name = "testJobTrigger")
    public CronTriggerFactoryBean testJobTrigger(JobDetail test) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(test);
        trigger.setCronExpression("2/3 * * * * ? *");
        trigger.setName("test");

        return trigger;
    }

    @Bean(name = "testJobTrigger1")
    public CronTriggerFactoryBean testJobTrigger1(JobDetail test1) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(test1);
        trigger.setCronExpression("2/3 * * * * ? *");
        trigger.setName("test1");

        return trigger;
    }

    /**
     * attention:
     * Details：定义quartz调度工厂
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger... triggers) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        bean.setOverwriteExistingJobs(true);
        // 延时启动，应用启动1秒后
        bean.setStartupDelay(1);
        // 注册触发器
        bean.setTriggers(triggers);
        return bean;
    }
}
