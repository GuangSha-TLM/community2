package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface ResponseControllerAop {


    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      查询鉴权
     * @param joinPoint
     * @return void
     */
    public void responseSelect(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      删除鉴权
     * @param joinPoint
     * @return void
     */
    public void imgDeleteById(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      增加鉴权
     * @param joinPoint
     * @return void
     */
    public void responseAdd(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      修改鉴权
     * @param joinPoint
     * @return void
     */
    public void responseUpdateById(JoinPoint joinPoint);


}


