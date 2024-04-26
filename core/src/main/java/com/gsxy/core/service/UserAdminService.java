package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  管理员业务接口
 */
public interface UserAdminService {


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      根据id查询数据.
     * @param userAdminSelectByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo userAdminSelectById(UserAdminSelectByIdBo userAdminSelectByIdBo);


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id删除UserAdmin数据.
     * @param userAdminDeleteByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo userAdminDeleteById(UserAdminDeleteByIdBo userAdminDeleteByIdBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      增加新数据.
     * @param userAdminAddByBo
     * @return ResponseVo.class
     */
    public ResponseVo userAdminAdd(UserAdminAddByBo userAdminAddByBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id更新userAdmin数据.
     * @param userAdminUpdateByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo userAdminUpdateById(UserAdminUpdateByIdBo userAdminUpdateByIdBo);


    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param userAdminPagingToGetDataBo
     * @return String.class
     */
    public Object pagingToGetUserAdminData(UserAdminPagingToGetDataBo userAdminPagingToGetDataBo);

    /**
     * @author hln 2023-11-01
     *      管理员查看所有签到状态
     * @return
     */
    ResponseVo findAllSignInStatus();

    /**
     * @author hln 2023-12-03
     *      管理员查看新发起的签到信息
     * @return
     */
    ResponseVo adminToGetSignInReal(String token);

//    /**
//     * @author hln 2024-4-26
//     *      管理员发起签到通知相关社团成员
//     * @param adminSignInNoticeBo
//     * @return
//     */
//    ResponseVo adminSignInNotice(AdminSignInNoticeBo adminSignInNoticeBo);
}



