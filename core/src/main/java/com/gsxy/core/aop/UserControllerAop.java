package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public interface UserControllerAop {

    /**
     * @author hln 2023-10-31
     *      查找user鉴权
     * @param joinPoint
     * @return
     */
    public String selectByUserId(JoinPoint joinPoint);

    /**
     * @author hln 2023-10-31
     *      修改user鉴权
     * @param joinPoint
     * @return
     */
    public String updateByUserId(JoinPoint joinPoint);

    /**
     * @author hln 2023-10-31
     *      删除user鉴权
     * @param joinPoint
     * @return
     */
    public String deleteByUserId(JoinPoint joinPoint);

    /**
     * @author hln 2023-10-31
     *      分页查询user鉴权
     * @param joinPoint
     * @return
     */
    public String pagingToGetUserData(JoinPoint joinPoint);

//    /**
//     * @author hln 2023-10-31
//     *      用户签到鉴权
//     * @param joinPoint
//     * @return
//     */
//    public String userSignIn(JoinPoint joinPoint);

    /**
     * @author hln 2023-10-31
     *      根据前端指定字段返回User信息鉴权
     * @param joinPoint
     * @return
     */
    public String selectToGetUser(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-07
     *      用户签到-WebSocket鉴权
     * @param joinPoint
     * @return
     */
    public String userSignInWebSocket(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-07
     *      用户签到-WebSocket鉴权
     * @param joinPoint
     * @return
     */
    public String userSignInWebSocketNew(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-03
     *      查询所有信息
     * @param joinPoint
     */
    void findAll(JoinPoint joinPoint);

}
