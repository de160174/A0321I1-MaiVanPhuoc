package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger= Logger.getLogger(Logger.class.getName());

    @Pointcut("execution(* com.example.demo.service.BookService.*(..))")
    public void BookService(){

    }

    @After("BookService()")
    public void log(JoinPoint joinPoint){
        String method=joinPoint.getSignature().getName();
        logger.info("After returning: End call " + method);
    }
}
