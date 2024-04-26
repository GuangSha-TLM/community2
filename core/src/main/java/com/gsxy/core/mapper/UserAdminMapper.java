package com.gsxy.core.mapper;

import com.gsxy.core.pojo.*;
import com.gsxy.core.pojo.bo.AdminSignInNoticeBo;
import com.gsxy.core.pojo.bo.SignInAdminWebSocketBo;
import com.gsxy.core.pojo.bo.UserAdminPagingToGetDataBo;
import com.gsxy.core.pojo.bo.UserSignInStatusBo;
import com.gsxy.core.pojo.vo.SignInAdminWebVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  管理员持久层
 */
@Mapper
public interface UserAdminMapper {

    /**
     * 2023-10-28
     *      在管理员库中查找目标用户.
     * @param userId
     * @return UserAdmin.class
     */
    @Select("select * from user_admin where user_id = #{userId} limit 1")
    public UserAdmin queryByUserId(@Param("userId")Long userId);

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      根据id查询数据.
     * @param id
     * @return UserAdmin.class
     */
    public UserAdmin selectByIdUserAdmin(Long id);


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id删除UserAdmin数据.
     * @param id
     * @return Long.class
     */
    public Long deleteByIdUserAdmin(Long id);


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      增加新数据.
     * @param userAdmin
     * @return Long.class
     */
    public Long addUserAdmin(UserAdmin userAdmin);


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id更新userAdmin数据.
     * @param userAdmin
     * @return Long.class
     */
    public Long updateByIdUserAdmin(UserAdmin userAdmin);

    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param userAdminPagingToGetDataBo
     * @return String.class
     */
    public List<UserAdmin> userAdminPagingToGetData(UserAdminPagingToGetDataBo userAdminPagingToGetDataBo);

    /**
     * @author hln 2023-10-31
     *      插入发起签到信息到sign_in_admin表中
     * @param signInAdmin
     */
    void insertSignInAdmin(SignInAdmin signInAdmin);

    /**
     * @author hln 2023-10-31
     *      根据admin_id查询sign_in_admin表中相应数据
     * @param signInAdmin
     * @return
     */
    Long selectToGetByAdminId(SignInAdmin signInAdmin);

    /**
     * @author hln 2023-11-01
     *      管理员查看所有签到状态
     * @return
     */
    List<UserSignInStatusBo> findAllSignInStatus();

    /**
     * @author hln 2023-11-01
     *      查找社团id
     * @param signInAdmin
     * @return
     */
    SignInAdmin selectToGetCommunityId(SignInAdmin signInAdmin);

    //--------------------------
//    /**
//     * @author hln 2023-11-01
//     *      获取所需返回的user中的字段
//     * @param userSignInStatusBo
//     * @return
//     */
//    UserSignInStatusBo selectToGetUserBo(UserSignInStatusBo userSignInStatusBo);

    //---------------------------------
    /**
     * @author hln 2023-11-01
     *      先将sign_in_admin中查找出的字段放到sign_in_user_status表中
     * @param userSignInStatusBo
     * @return
     */
    void insertSignInUserStatus(UserSignInStatusBo userSignInStatusBo);

    //-------------------------------
    /**
     * @author hln 2023-11-01
     *      删除实体类中的不全信息
     * @param userSignInStatusBo1
     */
    void deleteBYIdToStatus(UserSignInStatusBo userSignInStatusBo1);

    //--------------------------------
    /**
     * @author hln 2023-11-01
     *      插入所有的实体类信息
     * @param userSignInStatusBo1
     */
    void insertSignInUserStatusAll(UserSignInStatusBo userSignInStatusBo1);

    /**
     * @author hln 2023-11-01
     *      删除先前插入不完整的信息
     * @param signInAdmin
     */
    void deleteByIdSignIn(SignInAdmin signInAdmin);

    /**
     * @author hln 2023-11-05
     *      插入所有的实体类SignInAdminWebSocket的信息到sign_in_admin_websocket
     * @param socketBo
     */
    void insertSignInAdminWebSocket(SignInAdminWebSocketBo socketBo);

    /**
     * @author hln 2023-11-05
     *      查询所有的实体类SignInAdminWebSocket的信息到sign_in_admin_websocket
     * @param adminId
     * @return
     */
    SignInAdminWebSocketBo selectToGetWebByAdminId(Long adminId);

    /**
     * @author hln 2023-11-07
     *      插入所有的实体类SignInAdminWebSocketBo的信息到sign_in_admin_websocket
     * @param signInAdminWebSocket
     */
    void insertPutSignIn(SignInAdminWebSocket signInAdminWebSocket);

    /**
     * @author hln 2023-11-07
     *      插入所有的实体类SignInAdminWebSocketBo的信息到sign_in_admin_websocket
     * @param signInAdminWebSocket
     */
    void insertPutSignInNew(SignInAdminWebSocket signInAdminWebSocket);

    /**
     * @param adminId
     * @param uuid
     * @return
     * @author hln 2023-11-22
     * 封装所有用户签到状态表中的用户id
     */
    Set<Long> selectToGetIdByAdminId(Long adminId, String uuid);

    /**
     * @param adminId
     * @return
     * @author hln 2023-11-22
     * 封装该社团所有用户id到List集合中
     */
    List<Long> selectToGetUserIdByAdminId(Long adminId);

    /**
     * @author hln 2023-11-22
     *      查找当前的id对应用户的姓名
     * @param userId
     * @return
     */
    String selectToGetName(Long userId);

    /**
     * @author hln 2023-11-22
     *      查找当前的id对应用户的姓名
     * @param userId
     * @return
     */
    String selectToGetNameNew(Long userId);

    /**
     * @author hln 2023-12-01
     *      根据userId查找签到内容
     * @return
     */
    String selectToGetContent();

    /**
     * @author hln 2023-12-03
     *      查找最新发布签到的id
     * @return
     */
    Long selectToGetId();

    /**
     * @param noticeId
     * @return
     * @author hln 2023-12-03
     * 根据uuid找该社团中签到的人
     */
    Set<String> selectToIdByAdminId(Long noticeId);

    /**
     * @author hln 2023-12-03
     *      返回最新签到信息
     * @return
     */
    List<SignInAdminWebVo> selectToGetSignInReal(Long adminId);

    /**
     * @author hln 2023-12-03
     *      查找最新发布签到内容
     * @return
     */
    String selectToGetContentNew();

    /**
     * @author hln 2024-4-26
     *      将签到信息存入mysql
     * @param signInAdminR
     */
    void insertSignInAdminR(SignInAdminR signInAdminR);

    /**
     * @author hln 2024-4-26
     *      将通知信息存入mysql
     * @param adminSignInNoticeBo
     */
    void insertNotice(AdminSignInNoticeBo adminSignInNoticeBo);

    /**
     * @param userId
     * @return
     * @author hln 2024-4-26
     * 实时查看签到信息
     */
    List<SignInUser> queryByCommunityId(Long userId);

    /**
     * @author hln 2024-4-26
     * 查看该社团所有成员信息
     * @param userId
     * @return
     */
    List<CommunityUser> queryUser(Long userId);


    List<SignInUser> queryAll();

    SignInAdminR querySignInNotice(Long id);

    List<Long> queryCommunityUserAll(Long adminId);

    List<Long> querySignUserAll(String key);

}
