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

    @Before("execution(* com.example.omid.aspect.aspect.SimpleRestController.*()))")
    public void logBeforCallRest1(JoinPoint joinPoint){
        System.out.println("Hellooo1");
    }


}
