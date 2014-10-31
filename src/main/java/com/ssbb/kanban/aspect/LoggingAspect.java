package com.ssbb.kanban.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	private final static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution(* aroundMethod(..))")
	public void aroundSetMethod(ProceedingJoinPoint joinPoint){
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		try{
			logger.info("Entering method: {}({})", method, args);
			joinPoint.proceed();
			logger.info("Exiting method: {}({})", method, args);
			logger.info("*******Around aspect successful********");
		} catch (Throwable e) {
			e.printStackTrace();
			logger.error("Unable to proceed in joinpoint");
		}
	}
	
}
