package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 通知Aop
 */
public interface NoticeControllerAop {


    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      查看通知鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeSelect(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      删除鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeDeleteById(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      发布通知鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeAdd(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      修改鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeUpdateById(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-28
     *      分页查询鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminPagingToGetData(JoinPoint joinPoint);


    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      查看通知鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeSelectByNoticeId(JoinPoint joinPoint);



}
