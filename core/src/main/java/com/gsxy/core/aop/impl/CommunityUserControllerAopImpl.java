package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.CommunityUserControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommunityUserControllerAopImpl implements CommunityUserControllerAop {
    @Autowired
    private SystemService systemService;

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户添加鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityUserController.CommunityUserAdd(..))")
    public String CommunityUserAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUserAddBo arg =(CommunityUserAddBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,0);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户删除鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityUserController.CommunityUserDeleteById(..))")
    public String CommunityUserDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUserDeleteByIdBo arg = (CommunityUserDeleteByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-30
     *    社团用户查询鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityUserController.CommunityUserSelectById(..))")
    public String CommunityUserSelectById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUserSelectByIdBo arg = (CommunityUserSelectByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,1);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户修改鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityUserController.CommunityUserUpdateById(..))")
    public String CommunityUserUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUserUpdateByIdBo arg = (CommunityUserUpdateByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);
        return null;
    }

    /**
     * @author zhuxinyu 2023-11-03
     *      删除社员
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityUserController.CommunityUserdeleteUser(..))")
    public String CommunityUserdeleteUser(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        CommunityUserdeleteUserBo arg = (CommunityUserdeleteUserBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);
        return null;
    }

    /**
     * @author zhuxinyu 2023-11-07
     *       社长向用户发送已加入通知
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityUserController.CommunityToUserNotice(..))")
    public void CommunityToUserNotice(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUserAndUserNoticeBo arg = (CommunityUserAndUserNoticeBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);
    }
}
