package com.gsxy.core.service;

import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;

/**
 * 用户板块
 */
public interface UserService {

    /**
     * @author hln 2023-10-23
     *      用户登录
     * @param userLoginBo
     * @return
     */
    ResponseVo userLogin(UserLoginBo userLoginBo);

    /**
     * @author hln 2023-10-23
     *      用户注册
     * @param user
     * @return
     */
    ResponseVo userReg(User user);

    /**
     * @author hln 2023-10-23
     *      通过id查找用户
     * @param userSelectByUserIdBo
     * @return
     */
    ResponseVo selectByUserId(UserSelectByUserIdBo userSelectByUserIdBo);

    /**
     * @author hln 2023-10-23
     *      通过id删除用户
     * @param userDeleteByIdBo
     * @return
     */
    ResponseVo deleteByUserId(UserDeleteByIdBo userDeleteByIdBo);

    /**
     * @author hln 2023-10-23
     *      通过id修改用户
     * @param userUpdateByUserIdBo
     * @return
     */
    ResponseVo updateByUserId(UserUpdateByUserIdBo userUpdateByUserIdBo);

    /**
     * @author hln 2023-10-23
     *      查找所有信息
     * @return
     */
    ResponseVo userFindAll();

    /**
     * @author hln 2023-10-27
     *      分页查询
     * @param pagingToGetUserDataBo
     * @return
     */
    ResponseVo pagingToGetUserData(PagingToGetUserDataBo pagingToGetUserDataBo);

//    /**
//     * @quthor hln 2023-10-30
//     *      用户签到
//     * @param userSignInBo
//     * @return
//     */
//    ResponseVo userSignIn(UserSignInBo userSignInBo);

    /**
     * @author hln 2023-11-03
     *      根据前端指定字段返回User信息
     * @param userSelectToGetBo
     * @return
     */
    ResponseVo selectToGetUser(UserSelectToGetBo userSelectToGetBo);

    /**
     * @author hln 2023-11-07
     *      用户签到（响应）功能
     * @param signInWebSocketBo
     * @return
     */
    ResponseVo userSignInWebSocket(SignInWebSocketBo signInWebSocketBo);

    /**
     * @author hln 2023-11-07
     *      用户签到（响应）功能
     * @param signInWebSocketBo
     * @return
     */
    ResponseVo userSignInWebSocketNew(SignInWebSocketBo signInWebSocketBo);

    /**
     * @param findAllBo
     * @return
     * @author hln 2023-11-03
     * 查询所有信息
     */
    ResponseVo findAll(FindAllBo findAllBo);

    /**
     * @author hln 2024-4-26
     *      获取签到通知信息
     * @return
     */
    ResponseVo NoticeUserSignIn();
}
