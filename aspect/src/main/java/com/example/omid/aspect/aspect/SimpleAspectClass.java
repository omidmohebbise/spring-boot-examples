package com.example.omid.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SimpleAspectClass {


    @Before("execution(* com.example.omid.aspect.aspect.SimpleRestController.printHelloWorld()))")
    public void logBeforCallRest(JoinPoint joinPoint){
        System.out.println("Hellooo");
    }
/*
    @AfterReturning(
            pointcut="com.example.omid.aspect.aspect.SimpleRestController.printHelloWorld()",
            returning="retVal")
    public void doAccessCheck(Object retVal) {
        // ...
    }
*/
}
