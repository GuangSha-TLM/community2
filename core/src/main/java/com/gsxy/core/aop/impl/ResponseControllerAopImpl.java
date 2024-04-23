package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.ResponseControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ResponseControllerAopImpl implements ResponseControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ResponseController.responseSelect(..))")
    public void responseSelect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ResponseSelectByIdBo responseSelectByIdBo = (ResponseSelectByIdBo) args[0];
        String token = responseSelectByIdBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      删除鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ResponseController.responseDeleteById(..))")
    public void imgDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ResponseDeleteByIdBo responseDeleteByIdBo = (ResponseDeleteByIdBo) args[0];
        String token = responseDeleteByIdBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      增加鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ResponseController.responseAdd(..))")
    public void responseAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ResponseAddByBo responseAddByBo = (ResponseAddByBo) args[0];
        String token = responseAddByBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      修改鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ResponseController.responseUpdateById(..))")
    public void responseUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ResponseUpdateByIdBo responseUpdateByIdBo = (ResponseUpdateByIdBo) args[0];
        String token = responseUpdateByIdBo.getToken();
        systemService.auth(token);
    }



}
