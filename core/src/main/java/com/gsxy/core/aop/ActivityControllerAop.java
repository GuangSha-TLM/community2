package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public interface ActivityControllerAop {

    /**
     * @author zhuxinyu 2023-10-24
     * 添加org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String addActive(JoinPoint joinPoint);

    public String deleteActive(JoinPoint joinPoint);

    public String selectActive(JoinPoint joinPoint);

    public String updateActive(JoinPoint joinPoint);

    public String activeLikeToGet(JoinPoint joinPoint);

    public String pagingToGetActiveData(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-10
     *      根据前端传入的token返回数据 - 查询该社团的所有活动
     * @param joinPoint
     * @return
     */
    public String selectByToken(JoinPoint joinPoint);

}
