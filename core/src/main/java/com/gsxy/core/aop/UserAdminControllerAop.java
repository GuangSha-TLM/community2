package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 管理员Aop
 */
public interface UserAdminControllerAop {

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      UserAdmin查询鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminSelect(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin删除鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminDeleteById(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin添加鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminAdd(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin修改鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminUpdateById(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-28
     *      UserAdmin分页查询鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminPagingToGetData(JoinPoint joinPoint);

//    /**
//     * @author hln 2023-10-31
//     *      管理员发起签到鉴权
//     * @param joinPoint
//     * @return
//     */
//    public String userAdminSignIn(JoinPoint joinPoint);

//    /**
//     * @author hln 2023-11-07
//     *      管理员发起签到
//     * @param joinPoint
//     * @return
//     */
//    public String userAdminSignInWebSocket(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-22
     *      管理员查看实时签到信息
     * @param joinPoint
     */
    void adminCheckInStatusInRealTime(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-07
     *      管理员发起签到
     * @param joinPoint
     * @return
     */
    public String userAdminSignInWebSocketNew(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-22
     *      管理员查看实时签到信息
     * @param joinPoint
     */
    void adminCheckInStatusInRealTimeNew(JoinPoint joinPoint);

//    /**
//     * @author hln 2023-11-01
//     *      管理员查看所有用户签到鉴权(相应社团)
//     * @param joinPoint
//     * @return
//     */
//    public String userAdminFindAllSignInStatus(JoinPoint joinPoint);

    /**
     * @author hln 2023-12-03
     *      管理员查看新发起的签到信息
     * @param joinPoint
     */
    void adminToGetSignInReal(JoinPoint joinPoint);

}
