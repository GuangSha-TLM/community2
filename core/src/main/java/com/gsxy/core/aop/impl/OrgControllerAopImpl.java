package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.OrgControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.OrgPagingToGetDataVo;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Aspect
public class OrgControllerAopImpl implements OrgControllerAop {

    @Autowired
    private SystemService systemService;
    /**
     * @author zhuxinyu 2023-10-24
     * 添加Org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.OrgController.orgAdd(..))")
    public String OrgAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        OrgAddBo arg = (OrgAddBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,0);
        return null;
    }
    /**
     * @author zhuxinyu 2023-10-24
     *      删除班级权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.OrgController.orgDeleteById(..))")
    public String OrgDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        OrgDeleteByIdBo arg = (OrgDeleteByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,0);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-24
     * 做了权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.OrgController.orgSelectById(..))")
    public String OrgSelectById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        OrgSelectByIdBo arg = (OrgSelectByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,1);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-24
     *   修改权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.OrgController.orgUpdateById(..))")
    public String OrgUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        OrgUpdateByIdBo arg = (OrgUpdateByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,0);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-25
     *       根据Org查找user的权限验证
     * @param joinPoint
     * @return
     */
//    @Override
//    @Before("execution(* com.gsxy.core.controller.OrgController.orgSelectByUser())")
//    public List<OrgSelectByUserBo> OrgSelectByUser(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        OrgSelectByUserBo arg = (OrgSelectByUserBo) args[0];
//        String token = arg.getToken();
//        systemService.auth(token);
//        return null;
//    }

    /**
     * @author zhuxinyu 2023-10-30
     *      org分页查询鉴权
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.OrgController.orgPagingToGetData(..))")
    public void OrgPagingToGetData(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        OrgPagingToGetDataBo orgPagingToGetDataBo =(OrgPagingToGetDataBo) args[0];
        String token = orgPagingToGetDataBo.getToken();
        systemService.auth(token);
    }
}
