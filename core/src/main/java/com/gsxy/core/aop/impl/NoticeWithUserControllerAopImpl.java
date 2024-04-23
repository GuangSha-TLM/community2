package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.NoticeWithUserControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 通知和用户的Aop的实现类
 */
@Component
@Aspect
public class NoticeWithUserControllerAopImpl implements NoticeWithUserControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeWithUserController.noticeWithUserSelect(..))")
    public void noticeWithUserSelect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeWithUserSelectByIdBo noticeWithUserSelectByIdBo = (NoticeWithUserSelectByIdBo) args[0];
        String token = noticeWithUserSelectByIdBo.getToken();
        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      删除鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeWithUserController.noticeWithUserDeleteById(..))")
    public void noticeWithUserDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeWithUserDeleteByIdBo noticeWithUserDeleteByIdBo = (NoticeWithUserDeleteByIdBo) args[0];
        String token = noticeWithUserDeleteByIdBo.getToken();
        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      增加鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeWithUserController.noticeWithUserAdd(..))")
    public void noticeWithUserAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeWithUserAddByBo noticeWithUserAddByBo = (NoticeWithUserAddByBo) args[0];
        String token = noticeWithUserAddByBo.getToken();
        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      修改鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeWithUserController.noticeWithUserUpdateById(..))")
    public void noticeWithUserUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeWithUserUpdateByIdBo noticeWithUserUpdateByIdBo = (NoticeWithUserUpdateByIdBo) args[0];
        String token = noticeWithUserUpdateByIdBo.getToken();
        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-28
     *      分页查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeWithUserController.noticeWithUserPagingToGetData(..))")
    public void noticeWithUserPagingToGetData(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeWithUserPagingToGetDataBo noticeWithUserPagingToGetDataBo = (NoticeWithUserPagingToGetDataBo) args[0];
        String token = noticeWithUserPagingToGetDataBo.getToken();
        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }
}
