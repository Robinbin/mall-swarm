package com.macro.mall.common.aop;

import com.macro.mall.common.util.CountUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CountValueCheckAspect {

    @Pointcut("execution(public * com.macro.mall.service.*.*(..))||execution(public * com.macro.mall.*.service.*.*(..))")
    public void countValueCheck() {
    }

    @Around(value = "countValueCheck()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        if (result instanceof Integer) {
            return CountUtil.handleCount((Integer) result);
        }

        return result;
    }
}
