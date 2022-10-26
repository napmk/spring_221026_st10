package com.napmkmk.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //공통기능

public class LogAop {
	@Pointcut("within(com.napmkmk.test.Soldier)")
	//@Pointcut("within(com.napmkmk.test.*)")
	private void pointcutMethod() {
		
	}
	@Around("pointcutMethod()")
	
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
	String	signatyreStr = joinpoint.getSignature().toString();
	
	System.out.println(signatyreStr + "메서드가 시작됨!!");
	System.out.println("**자기소개 하기**");//공통기능
	
	try {
		 Object obj = joinpoint.proceed();
		 return obj;
	}finally {
		System.out.println(signatyreStr + "메서드가 종료 되었음!!!");
	}
	}
}
