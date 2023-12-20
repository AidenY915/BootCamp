package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class LogAdvice {
	@Before("Pointcuts.getLog()")
	public void printLog1(JoinPoint jp) {
		System.out.println("어노테이션Before1");
	}
	@Before("Pointcuts.getLog()")
	public void printLog2(JoinPoint jp) {
		System.out.println("어노테이션Before2");
	}
	
	@Around("Pointcuts.getLog()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before");
		StopWatch sw = new StopWatch();
		sw.start();
		Object rsltObj = pjp.proceed();
		sw.stop();
		System.out.println(sw.getTotalTimeMillis());
		System.out.println("around after");
		return rsltObj;
	}
	
	
}
