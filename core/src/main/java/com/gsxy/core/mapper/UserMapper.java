package com.gsxy.core.mapper;

import com.gsxy.core.pojo.SignInUserStatusWeb;
import com.gsxy.core.pojo.SignInWebSocket;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.FindAllVo;
import com.gsxy.core.pojo.vo.SelectUserVo;
import com.gsxy.core.pojo.vo.UserSelectToGetVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * @author hln 2023-10-23
     *      用户登录
     * @param userLoginBo
     * @return
     */
    User userLogin(UserLoginBo userLoginBo);

    /**
     * @author hln 2023-10-23
     *      根据用户名查询用户是否存在
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * @author hln 2023-10-23
     *      用户注册
     * @param user
     * @return
     */
    Long userReg(User user);

    /**
     * @param userId
     * @return
     * @author hln 2023-10-23
     * 通过id查找用户
     */
    public User selectByUserId(Long userId);

    /**
     * @author hln 2023-10-23
     *      通过id删除用户
     * @param id
     * @return
     */
    Long deleteByUserId(Long id);

    /**
     * @author hln 2023-10-23
     *      通过id修改用户
     * @param user
     * @return
     */
    Long updateByUserId(User user);

    /**
     * @author hln 2023-10-23
     *      查找所有信息
     * @return
     */
    List<User> userFindAll();

    /**
     * @author hln 2023-10-27
     *      分页查询
     * @param pagingToGetUserDataBo
     * @return
     */
    List<User> pagingToGetUserData(PagingToGetUserDataBo pagingToGetUserDataBo);

    /**
     * @author hln 2023-10-27
     *      获取活动总数
     * @param pagingToGetUserDataBo
     * @return
     */
    Long pagingToGetCountOfUserData(PagingToGetUserDataBo pagingToGetUserDataBo);

    /**
     * @param id
     * @return
     * @author hln 2023-10-29
     * 通过id获取管理员权限
     */
    Integer selectByUserAndUserAdminId(Long id);

//    /**
//     * @quthor hln 2023-10-30
//     *      查询用户签到状态
//     * @param userSignInBo
//     * @return
//     */
//    void userSignIn(UserSignInBo userSignInBo);

//    /**
//     * @quthor hln 2023-10-30
//     *      根据user_id获取社团id
//     * @param userSignInBo
//     * @return
//     */
//    UserSignInBo selectToGetCommunityIdByUserId(UserSignInBo userSignInBo);
//
//    /**
//     * @author hln 2023-10-31
//     *      删除签到记录（如果该社团没有该用户）
//     * @param userSignInBo1
//     */
//    void deleteSignIn(UserSignInBo userSignInBo1);

    /**
     * @author hln 2023-11-03
     *      根据前端指定字段返回User信
     * @param userSelectToGetBo
     * @return
     */
    List<UserSelectToGetVo> selectToGetUser(UserSelectToGetBo userSelectToGetBo);

    /**
     * @author hln 2023-11-03
     *      根据userId获取communityId
     * @param userId
     * @return
     */
    Long selectToGetCommunityId(Long userId);

    /**
     * @author hln 2023-11-07
     *      将用户签到响应数据插入到sign_in_websocket
     * @param signInWebSocket
     */
    void insertSignInWeb(SignInWebSocket signInWebSocket);

    /**
     * @author hln 2023-11-10
     *      查询UserAndAdminSignIn实体类信息
     * @return
     */
    SignInUserStatusWeb selectToGetUserAndAdminSignIn(Long userId);

    /**
     * @author hln 2023-11-10
     *      查询UserAndAdminSignIn实体类信息
     * @return
     */
    SignInUserStatusWeb selectToGetUserAndAdminSignInNew(Long userId);

    /**
     * @param signInUserStatusWeb
     * @return
     * @author hln 2023-11-10
     * 插入数据到 sign_in_user_status_web
     */
    Long insertSignInUserWithAdmin(SignInUserStatusWeb signInUserStatusWeb);

    /**
     * @author hln 2023-11-20
     *      查询用户姓名根据id
     * @param aLong
     * @return
     */
    String selectToGetNameByUserId(Long aLong);

    /**
     * @param findAllBoNew
     * @return
     * @author hln 2023-12-03
     * 查询前段指定字段查询用户信息
     */
    List<FindAllVo> selectToGetUserBy(FindAllBoNew findAllBoNew);

    /**
     * @author hln 2023-12-03
     *      返回所有用户信息
     * @return
     */
    List<FindAllVo> selectGetUser();

    /**
     * @author hln 2023-12-03
     *      返回用户表中所有数据的个数
     * @return
     */
    int selectToGetCount(FindAllBo findAllBo);

    /**
     * @author hln 2023-12-04
     *      根据传入的id查找该社团内的用户id
     * @param userId
     * @return
     */
    ArrayList<Long> selectGetUserId(Long userId);

    /**
     * @author hln 2023-12-04
     *      根据传入的id查找该社团内的用户的总数
     * @param userId
     * @return
     */
    int selectToGetCountNew(Long userId);

    /**
     * @author hln 2023-12-04
     *      查找用户id
     * @param id
     * @return
     */
    SelectUserVo selectToUserId(Long id);

    /**
     * @author hln 2024-4-23
     * 插入权限
     * @param id
     * @param role
     */
    void userRegRole(Long id, Integer role);
}
