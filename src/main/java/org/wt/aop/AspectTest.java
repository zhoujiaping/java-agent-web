package org.wt.aop;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@PostConstruct
	public void init(){
		logger.info(this.getClass()+" init");
	}

	@Around("execution(* org.wt..*(..)) or execution(* com.wt2..*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//Object target = joinPoint.getTarget();
		//Class<?> targetClass = AopUtils.getTargetClass(target);
		logger.info("around "+joinPoint);
		return joinPoint.proceed();
	}

}
