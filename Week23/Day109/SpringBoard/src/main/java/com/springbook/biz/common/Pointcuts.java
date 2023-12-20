package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Pointcuts {
	@Pointcut("execution(* com.springbook.biz.board.impl.*Impl.get*(..))")
	public void getLog(){}
}
