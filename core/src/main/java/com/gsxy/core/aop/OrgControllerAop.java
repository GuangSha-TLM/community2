package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

import java.util.List;

public interface OrgControllerAop {
    /**
     * @author zhuxinyu 2023-10-24
     * 添加org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String OrgAdd(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-24
     * 删除org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String OrgDeleteById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-24
     * 查找org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String OrgSelectById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-24
     * 修改org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String OrgUpdateById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-25
     *      根据org查找user
     * @param joinPoint
     * @return
     */
//    public List<OrgSelectByUserBo> OrgSelectByUser(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-30
     *      org分页查询鉴权
     * @param joinPoint
     */
    public void OrgPagingToGetData(JoinPoint joinPoint);

}
