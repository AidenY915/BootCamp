package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturning {
	@org.aspectj.lang.annotation.AfterReturning(pointcut="Pointcuts.getPointcut()", returning="rslt")
	public void afterReturning(JoinPoint jp, Object rslt) {
		System.out.println("@AfterReturning");
		System.out.println(rslt);
	}
}
