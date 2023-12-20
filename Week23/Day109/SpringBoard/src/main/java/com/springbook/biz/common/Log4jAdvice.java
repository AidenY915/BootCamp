package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class Log4jAdvice {
	public void printLogging() {
		System.out.println("[공통 로그-Log4j] 비즈니스 로직 수행 전 동작");
	}
	public void printGetLog() {
		System.out.println("get등장!");
	}
	public void afterLog1() {
		System.out.println("after1");
	}
	public void afterLog2() {
		System.out.println("after2");
	}
	public void afterThrowingLog(JoinPoint jp, Exception exception) {
		System.out.println("afterThrowing");
		System.out.println(exception.getMessage());
	}
	public void afterReturningLog(JoinPoint jp, Object returnObj) {
		System.out.println("after-returning 시작");
		System.out.println(jp.getSignature().getName());
		System.out.println("매개변수");
		for(Object obj : jp.getArgs()) {
			System.out.println(obj);
		}
		System.out.println("결과: " + returnObj);
		System.out.println("after-returning 종료");
	}
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
