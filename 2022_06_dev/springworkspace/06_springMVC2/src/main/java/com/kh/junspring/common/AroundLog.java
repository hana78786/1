package com.kh.junspring.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Component
@Aspect
public class AroundLog {

	@Pointcut("execution(* com.kh.junspring..*Impl*.*(..))")
	public void allPointCut() {
		
	}
	
	@Around(value = "allPointCut()")
	public Object aorundLogs(ProceedingJoinPoint pp) throws Throwable {
		//ProceedingJoinPoint는 JoinPoint를 상속받아 구현된 인터페이스
		//ProceedingJoinPoint를 사용하는 이유는 advice가 실행되는 시점을
		//프로그래밍 하기 위해서임
		StopWatch stopWatch = new StopWatch();
		//start
		stopWatch.start();
		Object obj = pp.proceed(); //pointcut 적용시점 메소드 proceed라는 메소드를 실행한다(이미 자바안에 들어있는메소드)
		//stop
		stopWatch.stop();
		//메소드가 실행되는 시간 출력
		String methodname = pp.getSignature().getName();//메소드명 구하는 코드
		System.out.println(methodname + "()메소드 수행에 걸린 시간 : " +stopWatch.getTotalTimeMillis()+"(ms)");
		
		return obj; //꼭 obj를 반환하지 않아도 된다! void도 가능
		
	}
}
