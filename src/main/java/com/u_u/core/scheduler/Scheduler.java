package com.u_u.core.scheduler;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.TaskManagementConfigUtils;

/**
 * 定时开关 配置
 */

//@Configuration
public class Scheduler {

    /**
     *
     *
     *
     * @Conditional 注解可作为条件参数判断，直接传了一个class类，该类事项了Condition接口，并重写了matches方法，如果改 方法返回的是true 则启动了Bean注入,否则spring 不注入改bean
     * @return
     */
//    @Conditional(SchedulerCondition.class)
//    @Bean(name = TaskManagementConfigUtils.SCHEDULED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public ScheduledAnnotationBeanPostProcessor scheduledAnnotationBeanPostProcessor(){
        return new ScheduledAnnotationBeanPostProcessor();
    }

    /**
     * ThreadPoolTaskScheduler 多线程定时，注入这个bean后，可以多个定时可以同时执行
     * @return
     */
    //@Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }

}
