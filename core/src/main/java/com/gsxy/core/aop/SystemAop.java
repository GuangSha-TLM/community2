package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author zhuxinyu 2023-10-23
 */
@Component
public interface SystemAop {
    /**
     * @author zhuxinyu 2023-10-23
     * 清理ThreadLocal 防止内存泄露
     * @param joinpoint
     * @throws Exception
     */

    public void removeAllThreadLocal(JoinPoint joinpoint) throws Exception;
}
