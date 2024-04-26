package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.UserAdminControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.apache.poi.ss.formula.functions.T;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author Oh...Yeah!!! 2023-10-28
 * 管理员Aop实现类
 */
@Component
@Aspect
public class UserAdminControllerAopImpl implements UserAdminControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      UserAdmin查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.userAdminSelect(..))")
    public void userAdminSelect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserAdminSelectByIdBo userAdminSelectByIdBo = (UserAdminSelectByIdBo) args[0];
        String token = userAdminSelectByIdBo.getToken();

        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin删除鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.userAdminDeleteById(..))")
    public void userAdminDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserAdminDeleteByIdBo userAdminDeleteByIdBo = (UserAdminDeleteByIdBo) args[0];
        String token = userAdminDeleteByIdBo.getToken();

        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin添加鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.userAdminAdd(..))")
    public void userAdminAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserAdminAddByBo userAdminAddByBo = (UserAdminAddByBo) args[0];
        String token = userAdminAddByBo.getToken();

        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin修改鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.userAdminUpdateById(..))")
    public void userAdminUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserAdminUpdateByIdBo userAdminUpdateByIdBo = (UserAdminUpdateByIdBo) args[0];
        String token = userAdminUpdateByIdBo.getToken();

        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-28
     *      UserAdmin分页查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.userAdminPagingToGetData(..))")
    public void userAdminPagingToGetData(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserAdminPagingToGetDataBo userAdminPagingToGetDataBo = (UserAdminPagingToGetDataBo) args[0];
        String token = userAdminPagingToGetDataBo.getToken();

        //对操作管理员面板的用户进行权限判定
        systemService.isAdmin(token, 2);

    }

    /**
     * @author hln 2023-12-03
     *      管理员查看新发起的签到信息
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.adminToGetSignInReal(..))")
    public void adminToGetSignInReal(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String token = (String) args[0];
        systemService.isAdmin(token,2);
    }

    /**
     * @author hln 2024-4-26
     *      管理员发起签到鉴权
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.adminSignInRedis(..))")
    public void adminSignInRedis(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        AdminSignInRequestBo adminSignInRequestBo = (AdminSignInRequestBo) args[0];
        String token = adminSignInRequestBo.getToken();
        systemService.isAdmin(token,2);
    }

    /**
     * @author hln 2024-4-26
     *      管理员发起签到通知相关社团成员 鉴权
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.adminSignInNotice(..))")
    public void adminSignInNotice(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        String token = (String) args[0];
        systemService.isAdmin(token,2);
    }

//    @Override
//    @Before("execution(* com.gsxy.core.controller.UserAdminController.querySignInUser(..))")
//    public void querySignInUser(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        TokenBo tokenBo = (TokenBo) args[0];
//        String token = tokenBo.getToken();
//        systemService.isAdmin(token,2);
//    }

    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.findAll(..))")
    public void findAll(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        TokenBo tokenBo = (TokenBo) args[0];
        String token = tokenBo.getToken();
        systemService.isAdmin(token,2);
    }

//    /**
//     * @author hln 2023-11-01
//     *      管理员查看所有用户签到鉴权(相应社团)
//     * @param joinPoint
//     * @return
//     */
//    @Override
//    public String userAdminFindAllSignInStatus(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        UserSignInStatusBo arg = (UserSignInStatusBo) args[0];
//        String token = arg.getToken();
//        systemService.isAdmin(token,2);
//
//        return null;
//    }



}
