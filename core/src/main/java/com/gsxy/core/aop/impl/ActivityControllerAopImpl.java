package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.ActivityControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ActivityControllerAopImpl implements ActivityControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author hln
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ActivityController.addActive(..))")
    public String addActive(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ActiveAddBo arg = (ActiveAddBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @author hln
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ActivityController.deleteActive(..))")
    public String deleteActive(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ActiveDeleteByIdBo arg = (ActiveDeleteByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @author hln
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ActivityController.selectActive(..))")
    public String selectActive(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ActiveSelectByIdBo arg = (ActiveSelectByIdBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);

        return null;
    }

    /**
     * @author hln
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ActivityController.updateActive(..))")
    public String updateActive(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ActiveUpdateByIdBo arg = (ActiveUpdateByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @author hln
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ActivityController.activeLikeToGet(..))")
    public String activeLikeToGet(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ActiveLikeToGetByTitleBo arg = (ActiveLikeToGetByTitleBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @author hln
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ActivityController.pagingToGetActiveData(..))")
    public String pagingToGetActiveData(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        PagingToGetActiveDataBo arg = (PagingToGetActiveDataBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @author hln 2023-11-10
     *      根据前端传入的token返回数据 - 查询该社团的所有活动(用户鉴权)
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ActivityController.selectByToken(..))")
    public String selectByToken(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String token = (String) args[0];
        systemService.auth(token);

        return null;
    }
}
