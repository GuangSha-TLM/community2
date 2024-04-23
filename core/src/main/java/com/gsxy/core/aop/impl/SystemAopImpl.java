package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.SystemAop;
import com.gsxy.core.util.ThreadLocalUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zhuxinyu 2023-10-23
 */
@Component
@Aspect
public class SystemAopImpl implements SystemAop {
    /**
     * @author zhuxinyu 2023-10-23
     * 清理ThreadLocal 防止内存泄漏
     * @param joinpoint
     * @throws Exception
     */
    @Override
    @After("execution(* com.gsxy.core.controller.*.*(..))")
    public void removeAllThreadLocal(JoinPoint joinpoint) throws Exception {
        ThreadLocalUtil.mapThreadLocalOfJWT.remove();
        ThreadLocalUtil.mapThreadLocal.remove();
        ThreadLocalUtil.DataOfThreadLocal.remove();

    }

}
