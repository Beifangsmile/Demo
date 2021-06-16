package com.u_u.core.scheduler;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


public class SchedulerCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata){
        return Boolean.valueOf(context.getEnvironment().getProperty("server.scheduler.enabled"));
    }

}
