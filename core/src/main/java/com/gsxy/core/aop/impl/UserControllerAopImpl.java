package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.UserControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.apache.poi.ss.formula.functions.T;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserControllerAopImpl implements UserControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author hln 2023-12-03
     *      查询所有信息
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.findAllByPaging(..))")
    public void findAll(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        FindAllBo arg = (FindAllBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
    }

    /**
     * @author hln 2024-4-26
     *      用户签到
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.userSignIn(..))")
    public void userSignIn(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserSignInRequestBo userSignInRequestBo = (UserSignInRequestBo) args[0];
        String token = userSignInRequestBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author hln 2024-4-26
     *      获取签到通知信息
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.noticeUserSignIn(..))")
    public void noticeUserSignIn(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        TokenBo tokenBo = (TokenBo) args[0];
        String token = tokenBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author hln 2023-10-31
     *      查找user鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.selectByUserId(..))")
    public String selectByUserId(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserSelectByUserIdBo userSelectByUserIdBo = (UserSelectByUserIdBo) args[0];
        String token = userSelectByUserIdBo.getToken();
        systemService.auth(token);

        return null;
    }

    /**
     * @author hln 2023-10-31
     *      修改user鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.updateByUserId(..))")
    public String updateByUserId(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserUpdateByUserIdBo userUpdateByUserIdBo = (UserUpdateByUserIdBo) args[0];
        String token = userUpdateByUserIdBo.getToken();
        systemService.auth(token);

        return null;
    }

    /**
     * @author hln 2023-10-31
     *      删除user鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.deleteByUserId(..))")
    public String deleteByUserId(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserDeleteByIdBo arg = (UserDeleteByIdBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);

        return null;
    }

    /**
     * @author hln 2023-10-31
     *      分页查找user鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.pagingToGetUserData(..))")
    public String pagingToGetUserData(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        PagingToGetUserDataBo arg = (PagingToGetUserDataBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);

        return null;
    }

//    /**
//     * @author hln 2023-10-27
//     *      做了用户签到功能权限验证
//     * @param joinPoint
//     * @return
//     */
//    @Override
//    @Before("execution(* com.gsxy.core.controller.UserController.userSignIn(..))")
//    public String userSignIn(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        UserSignInBo arg = (UserSignInBo) args[0];
//        String token = arg.getToken();
//        systemService.auth(token);
//
//        return null;
//    }

    /**
     * @author hln 2023-10-31
     *      根据前端指定字段返回User信息鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.selectToGetUser(..))")
    public String selectToGetUser(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserSelectToGetBo arg = (UserSelectToGetBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);

        return null;
    }
}
