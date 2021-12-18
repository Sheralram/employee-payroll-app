package com.bridgelabz.employeepayrollapp.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {
    @Pointcut(value="execution(* com.bridgelabz.employeepayrollapp.*.*.*(..) )")
    public void myPointCut() {

    }

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper(); //to get the output in JSON format
        String methodName = proceedingJoinPoint.getSignature().getName(); //to get the method name
        String className = proceedingJoinPoint.getTarget().getClass().toString(); //to get the class name
        Object[] array = proceedingJoinPoint.getArgs(); //to get the inputs
        //before executing the method invoking method and class name corresponding the arguments
        log.info("method invoked"+className+" : "+methodName+"()"+"arguments : "
                +mapper.writeValueAsString(array));
        Object object = proceedingJoinPoint.proceed();
        //after executing the method get back the response of that particular class or method
        log.info(className+" : "+methodName+"()"+"response : "
                +mapper.writeValueAsString(object));
        return object;
    }
}
