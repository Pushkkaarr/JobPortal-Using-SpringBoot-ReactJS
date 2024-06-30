package com.pushkar.SpringBoot_REST.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

                 //return type, class-name.method-name(args)  --format of below stars
    @Before("execution(* com.pushkar.SpringBoot_REST.service.JobService.*(..))")
    public void logMethodCall(){
        LOGGER.info("Method Called");
    }

}
