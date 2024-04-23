package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 通知和用户的Aop
 */
public interface NoticeWithUserControllerAop {


    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      查询鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeWithUserSelect(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      删除鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeWithUserDeleteById(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      增加鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeWithUserAdd(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      修改鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeWithUserUpdateById(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-28
     *      分页查询鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeWithUserPagingToGetData(JoinPoint joinPoint);





}
