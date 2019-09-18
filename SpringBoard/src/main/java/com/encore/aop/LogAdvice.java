package com.encore.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

	@Before("execution(* com.encore.service.SampleService*.*(..))")
	public void logBefore() {
		System.out.println("===========" + new Date() + "===========");
	}

	@Before("execution(* com.encore.service.SampleService*.doAdd(String,String)) && args(str1,str2)")
	public void logBeforeWithparam(String str1, String str2) {
		System.out.println("str1::" + str1);
		System.out.println("str2::" + str2);
	}

	@AfterThrowing(pointcut = "execution(* com.encore.service.SampleService*.*(..))", throwing = "e")
	public void logException(Exception e) {
		System.out.println("예외가 발생했습니다.");
		System.out.println("예외내용: " + e.getMessage());
	}

	// Target메소드(핵심메소드)의 전후 처리
	@Around(value = "execution(* com.encore.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint joinPoint) {

		System.out.println("## doAdd호출전 고통코드");
		Object result = null;
		long start = System.currentTimeMillis();

		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} // 핵심 메소드(doAdd) 호출 시점!!
		long end = System.currentTimeMillis();

		System.out.println("## doAdd호출후 고통코드");
		System.out.println("메소드 실행시간: " + (end - start));
		return result;
	}

}
