package com.yl.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOP {
    private static final Log logger= LogFactory.getLog(AOP.class);
    private long startTime;

    @Pointcut("execution(* com.yl.service.*.*(..))")
    public void pointcut(){}//声明一个切入点
    //声明该方法是一个前置通知，在目标方法执行之前执行
    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        logger.info(joinPoint.getSignature().getName());
        logger.info("----前置通知----");
        this.startTime=System.currentTimeMillis();
    }
    //声明该方法是一个后置通知，在目标方法执行之前执行
    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        logger.info("----后置通知----");
        long endTime=System.currentTimeMillis();
        logger.info("方法执行了"+(endTime-this.startTime)+"ms");
    }
    //声明该方法是一个环绕通知
    @Around(value = "execution(* com.yl.controller.*.*(..)) || execution(* com.yl.service.*.*(..)) ")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        logger.info(proceedingJoinPoint.getSignature().getName());
        logger.info("----------环绕前置-----------");
        Object result = proceedingJoinPoint.proceed();
        logger.info("--------环绕后置-----------");
        return result;
    }
    // 声明该方法是一个返回结果通知
    @AfterReturning(value = "execution(* com.yl.service.*.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        logger.info(joinPoint.getSignature().getName());
        logger.info("结果是"+result);
        logger.info("-------返回结果--------");
    }
    // 声明该方法是一个异常通知
    @AfterThrowing(value = "execution(* com.yl.service.*.*(..))",throwing = "exp")
    public void afterThrowing(JoinPoint joinPoint,Exception exp){
        logger.info(joinPoint.getSignature().getName());
        logger.info("异常消息："+exp.getMessage());
        logger.info("---------异常通知-------------");
    }
}

