package com.ydh.bootsample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* com.ydh.bootsample..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("START: " + joinPoint.toLongString());

        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toLongString() + " " + timeMs + "ms");
        }
    }
}
