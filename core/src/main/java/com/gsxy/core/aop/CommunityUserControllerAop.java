package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface CommunityUserControllerAop {
    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户添加鉴权
     * @param joinPoint
     * @return
     */
    public String CommunityUserAdd(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户删除鉴权
     * @param joinPoint
     * @return
     */
    public String CommunityUserDeleteById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户查询鉴权
     * @param joinPoint
     * @return
     */
    public String CommunityUserSelectById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户修改鉴权
     * @param joinPoint
     * @return
     */
    public String CommunityUserUpdateById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-11-03
     *      删除社员
     * @param joinPoint
     * @return
     */
    public String CommunityUserdeleteUser(JoinPoint joinPoint);
    /**
     * @author zhuxinyu 2023-11-07
     *       社长向用户发送已加入通知
     * @param joinPoint
     * @return void
     */
    public void CommunityToUserNotice(JoinPoint joinPoint);
}
