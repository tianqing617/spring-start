package top.smartliu.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before(){
        System.out.println("前置增强..........");
    }

    // 环绕通知
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强");
        // 切点方法
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强");

        return proceed;
    }
}
