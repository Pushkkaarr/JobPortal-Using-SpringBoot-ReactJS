package com.pushkar.SpringBoot_REST.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


// this directory mainly contains the classes , that are used for validation purposes to check if project is properly ,
//without messing the business logic , this keeps code clean and easy to read
// these are of no use for users , we developers use it for verifying the current condition of the project
@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

                 //return type, class-name.method-name(args)  --format of below stars
    @Before("execution(* com.pushkar.SpringBoot_REST.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called :- "+ jp.getSignature().getName());
    }

    @After("execution(* com.pushkar.SpringBoot_REST.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed :- "+ jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.pushkar.SpringBoot_REST.service.JobService.getJob(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method Has Some Issues :- "+ jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.pushkar.SpringBoot_REST.service.JobService.getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("Method Executed Successfully :- "+ jp.getSignature().getName());
    }
}
