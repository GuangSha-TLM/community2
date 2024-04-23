package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.ImgControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 图片Aop实现类
 */
@Component
@Aspect
public class ImgControllerAopImpl implements ImgControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      对Img查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ImgController.imgSelect(..))")
    public void imgSelect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ImgSelectByIdBo imgSelectByIdBo = (ImgSelectByIdBo) args[0];
        String token = imgSelectByIdBo.getToken();
        systemService.auth(token);
    }


    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      对删除鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ImgController.imgDeleteById(..))")
    public void imgDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ImgDeleteByIdBo imgDeleteByIdBo = (ImgDeleteByIdBo) args[0];
        String token = imgDeleteByIdBo.getToken();
        systemService.auth(token);

    }


    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      对Img增加鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ImgController.imgAdd(..))")
    public void imgAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ImgAddByBo imgAddByBo = (ImgAddByBo) args[0];
        String token = imgAddByBo.getToken();
        systemService.auth(token);
    }


    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      对修改鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ImgController.imgUpdateById(..))")
    public void imgUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ImgUpdateByIdBo imgUpdateById = (ImgUpdateByIdBo) args[0];
        String token = imgUpdateById.getToken();
        systemService.auth(token);

    }

    /**
     * @author Oh...Yeah!!!  2023-10-28
     *      Img分页查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ImgController.imgPagingToGetData(..))")
    public void imgPagingToGetData(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ImgPagingToGetDataBo imgPagingToGetDataBo = (ImgPagingToGetDataBo) args[0];
        String token = imgPagingToGetDataBo.getToken();
        systemService.auth(token);

    }

}

