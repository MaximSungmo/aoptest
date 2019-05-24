package com.cafe24.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	/*조인트포인트 (포인트컷)*/
	/*execution() 메소드 실행 전에 하기 메소드를 실행하라*/
	@Before("execution(ProductVo com.cafe24.aoptest.ProductService.find(Stirng))")
	public void beforAdvice() {
		System.out.println("-------before advice--------");
	}
	
	/* 모든 리턴타입, 모든패키지 내 클래스의 모든 메소드  */
	@After("execution(* *..*.ProductService.*(..))")
	public void AfterAdvice() {
		System.out.println("-------After advice--------");
	}
	
	/*After 가 실행되고 난 후에 진행*/
	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void AfterReturningAdvice() {
		System.out.println("-------AfterReturning advice--------");
	}
	
	/*기술할 때 추가 내용이 있음, exception이 발생할 시*/
	@AfterThrowing(value= "execution(* *..*.ProductService.*(..))", throwing="ex")
	public void AfterThrowingAdvice(Throwable ex) {
		System.out.println("-------AfterThrowing advice--------" + ex);
	}
	
	@Around(value= "execution(* *..*.ProductService.*(..))")
	public Object roundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		/*before advice*/
		System.out.println("------------aroundAdvice(Before)-------------");
		
		// PointCut 되는 메소드 호출 
		// 파라미터 변경 
		Object[] parameters = {"Camera"};
		Object result = pjp.proceed(parameters);
		
//		Object result = pjp.proceed();
		
		/*After advice*/
		System.out.println("------------aroundAdvice(After)-------------");

		
		return result;
	}
	
}
