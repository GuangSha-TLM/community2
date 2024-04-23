package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface CommunityControllerAop {
    /**
     * @author zhuxinyu 2023-10-26
     * 添加社团鉴权
     * @param joinPoint
     * @return
     */
    public String communityAdd(JoinPoint joinPoint);

    /**
     *  @author zhuxinyu 2023-10-26
     *  删除社团鉴权
     * @param joinPoint
     * @return
     */
    public String communityDeleteById(JoinPoint joinPoint);

    /**
     *  @author zhuxinyu 2023-10-26
     *  查找社团鉴权
     * @param joinPoint
     * @return
     */
    public String communitySelectById(JoinPoint joinPoint);

    /**
     *  @author zhuxinyu 2023-10-26
     *  修改社团鉴权
     * @param joinPoint
     * @return
     */
    public String communityUpdateById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-30
     *      community分页查询鉴权
     * @param joinPoint
     */
    public void communityPagingToGetData(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-30
     *      根据社团Id查询该社团的所有用户数据
     * @return
     */
    public String communityAndUser(JoinPoint joinPoint);

    /**
     * @author  zhuxinyu 2023-11-02
     *      根据社团Id查询社团的所有活动
     * @param joinPoint
     * @return
     */
    public String communityAndActive(JoinPoint joinPoint);
    /**
     * @author Oh… Yeah!!!, 2023-10-30
     *       用户向社长发送通知，加入社团(鉴权)
     * @param joinPoint
     * @return void
     */
    public void userSendNoticeToAdmin(JoinPoint joinPoint);


    /**
     * @author Oh… Yeah!!!, 2023-10-30
     *       社长向用户发送回复通知(鉴权)
     * @param joinPoint
     * @return void
     */
    public void adminReplyNoticeToUser(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-14
     *      社长发起签到通知鉴权
     * @param joinPoint
     */
    public void adminSendNotification(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-14
     *      社团成员接受签到通知鉴权
     * @param joinPoint
     */
    public void userReceiveNotifications(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-14
     *      社长发起签到通知鉴权
     * @param joinPoint
     */
    public void adminSendNotificationNew(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-14
     *      社团成员接受签到通知鉴权
     * @param joinPoint
     */
    public void userReceiveNotificationsNew(JoinPoint joinPoint);

}
