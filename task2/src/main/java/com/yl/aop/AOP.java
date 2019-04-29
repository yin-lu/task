//package com.yl.aop;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//
//@Aspect
//@Component
//public class AOP {
//    private static final Log logger = LogFactory.getLog(AOP.class);
//
//    //service层的统计耗时切面，统计方法执行耗时Around环绕通知
//    @Around("execution(* com.yl.service.StudentService.*(..))")
//    public Object timeAround(ProceedingJoinPoint joinPoint) {
//        //定义返回对象、得到方法需要的参数
//        Object obj = null;
//        Object[] args = joinPoint.getArgs();
//        long startTime = System.currentTimeMillis();
//        try {
//            obj = joinPoint.proceed(args);
//        } catch (Throwable throwable) {
//            logger.error("统计某方法执行耗时环绕通知出错", throwable);
//        }
//        //获取执行的方法名
//        long endTime = System.currentTimeMillis();
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
//        //打印耗时的信息
//        this.printExecTime(methodName, startTime, endTime);
//        return obj;
//    }
//
//    //打印方法耗时的信息
//    private void printExecTime(String methodName, long startTime, long endTime) {
//        long diffTime = endTime - startTime;
//        System.out.println("-----" + methodName + " 方法执行耗时：" + diffTime + " ms");
//    }
//
//}
