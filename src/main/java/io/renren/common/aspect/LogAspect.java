package io.renren.common.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Aspect
@Component
public class LogAspect {
	
	private Logger logger =  LoggerFactory.getLogger(LogAspect.class);
	public static Gson gson = new GsonBuilder().serializeNulls().create();
	
	
	@Pointcut("execution(* io.renren.modules..*.apicontroller.*.*(..))")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		
		MethodSignature signature = (MethodSignature) point.getSignature();
		//请求的方法名
		String className = point.getTarget().getClass().getName();
		String methodName = signature.getName();
		Object[] parameterValues =point.getArgs();
		logger.info("请求类:{},方法名:{},入参:{}",className,methodName,Arrays.toString(parameterValues));
		//执行方法
		Object result = point.proceed();
		
		long time = System.currentTimeMillis() - beginTime;
//		logger.info("返回参数；"+result+",运行时长："+ time);

		return result;
	}
}
