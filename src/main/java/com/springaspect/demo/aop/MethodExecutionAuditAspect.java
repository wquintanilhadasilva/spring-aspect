package com.springaspect.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionAuditAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("@annotation(com.springaspect.demo.aop.Auditoria)")
	public void before(JoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("Time START Taken by {} is {}", joinPoint, startTime);
    }
	
	@After("@annotation(com.springaspect.demo.aop.Auditoria)")
	public void after(JoinPoint joinPoint) throws Throwable {

        long timeTaken = System.currentTimeMillis(); // - startTime;
        logger.info("Time END Taken by {} is {}", joinPoint, timeTaken);
    }
	
	@Around("@annotation(com.springaspect.demo.aop.Auditoria)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("AROUND {} is {}", joinPoint, System.currentTimeMillis());
		Object result = joinPoint.proceed();
		logger.info("Result of method...: {}", result);
		return result;
	}

}
