package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.NoticeControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 通知Aop的实现类
 */
@Component
@Aspect
public class NoticeControllerAopImpl implements NoticeControllerAop {

    @Autowired
    private SystemService systemService;


    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticeSelectById(..))")
    public void noticeSelect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String token =  (String) args[0];
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      删除鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticeDeleteById(..))")
    public void noticeDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeDeleteByIdBo noticeDeleteByIdBo = (NoticeDeleteByIdBo) args[0];
        String token = noticeDeleteByIdBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      发布通知鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticeAdd(..))")
    public void noticeAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeAddByBo noticeAddByBo = (NoticeAddByBo) args[0];
        String token = noticeAddByBo.getToken();
        //对操作通知面板的用户进行权限判定
        systemService.isAdmin(token, 2);

    }

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      修改鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticeUpdateById(..))")
    public void noticeUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeUpdateByIdBo noticeUpdateByIdBo = (NoticeUpdateByIdBo) args[0];
        String token = noticeUpdateByIdBo.getToken();
        //对操作通知面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }


    /**
     * @author Oh...Yeah!!!  2023-10-28
     *      分页查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticePagingToGetData(..))")
    public void userAdminPagingToGetData(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticePagingToGetDataBo noticePagingToGetDataBo = (NoticePagingToGetDataBo) args[0];
        String token = noticePagingToGetDataBo.getToken();
        systemService.auth(token);
    }


    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      查看通知鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.NoticeController.noticeSelectByNoticeId(..))")
    public void noticeSelectByNoticeId(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        NoticeSelectByNoticeIdBo noticeSelectByNoticeIdBo = (NoticeSelectByNoticeIdBo) args[0];
        String token = noticeSelectByNoticeIdBo.getToken();
        systemService.auth(token);
    }


}
