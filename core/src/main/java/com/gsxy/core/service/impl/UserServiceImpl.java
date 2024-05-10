package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.NoticeMapper;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.*;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.*;
import com.gsxy.core.service.SystemService;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.service.UserService;
import com.gsxy.core.util.JwtUtil;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAdminService userAdminService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private UserAdminMapper userAdminMapper;
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * @author hln 2023-10-23
     *      用户注册
     * @param user
     * @return
     */
    public ResponseVo userReg(User user){
        User username = userMapper.findByUsername(user.getUsername());

        if(username != null){
            return new ResponseVo("该username已经存在",null,"0x202");
        }

        user.setCreateTime(new Date());

        user.setStatus(0);
        user.setDelFlag(0);
        Long aLong = userMapper.userReg(user);

        if(aLong.longValue() == 0L){
            return new ResponseVo("注册失败",null,"0x500");
        }

        return new ResponseVo("注册成功",null,"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      用户登录
     * @param userLoginBo
     * @return
     */
    public ResponseVo userLogin(UserLoginBo userLoginBo){
        //通过username去获取用户
        User user = userMapper.userLogin(userLoginBo);

        //比较用户密码和数据库中密码是否一致
        if(user == null || !user.getPassword().equals(userLoginBo.getPassword())){
            return new ResponseVo("登录失败",null,"0x500");
        }

        Long id = user.getId();

        String jwt = JwtUtil.createJWT(user);

        //记录用户当前的登录时间
        user.setLoginTime(new Date());

        //返回数据库中 user 和 userAdmin 中前端想获取的数据
        Integer role = userMapper.selectByUserAndUserAdminId(id);

        if(role == null){
            role = 0;
        }

        userMapper.userRegRole(user.getId(),0);

        UserAndUserAdminBo userAndUserAdminBo = new UserAndUserAdminBo();
        BeanUtils.copyProperties(user,userAndUserAdminBo);
        userAndUserAdminBo.setRole(role);
        UserAndUserAdminSelectByIdBo userAndUserAdminSelectByIdBo = new UserAndUserAdminSelectByIdBo();
        userAndUserAdminSelectByIdBo.setToken(jwt);
        userAndUserAdminSelectByIdBo.setUserAndUserAdminBo(userAndUserAdminBo);

        return new ResponseVo("登录成功",userAndUserAdminSelectByIdBo,"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      通过id查找用户信息
     * @param userSelectByUserIdBo
     * @return
     */
    @Override
    public ResponseVo selectByUserId(UserSelectByUserIdBo userSelectByUserIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        SelectUserVo user = userMapper.selectToUserId(userSelectByUserIdBo.getId());

        if(user == null){
            return new ResponseVo("查询条件不存在",null,"0x500");
        }

        return new ResponseVo("查找成功",user,"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      通过id删除用户
     * @param userDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo deleteByUserId(UserDeleteByIdBo userDeleteByIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long aLong = userMapper.deleteByUserId(userDeleteByIdBo.getId());

        if(aLong == null || aLong.longValue() == 0L){
            return new ResponseVo("删除失败",null,"0x500");
        }

        return new ResponseVo("删除成功",aLong,"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      通过id修改用户
     * @param userUpdateByUserIdBo
     * @return
     */
    @Override
    public ResponseVo updateByUserId(UserUpdateByUserIdBo userUpdateByUserIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        userUpdateByUserIdBo.getUser().setUpdateBy(userId);
        userUpdateByUserIdBo.getUser().setUpdateTime(new Date());
        User user = userUpdateByUserIdBo.getUser();
        Long aLong = userMapper.updateByUserId(user);

        if(aLong == null || aLong.longValue() == 0L){
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",user.getId(),"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      查找所有信息
     * @return
     */
    @Override
    public ResponseVo userFindAll() {
        List<User> list = userMapper.userFindAll();

        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     * @author hln 2023-10-27
     *      分页查询
     * @param pagingToGetUserDataBo
     * @return
     */
    @Override
    public ResponseVo pagingToGetUserData(PagingToGetUserDataBo pagingToGetUserDataBo) {

        //获取所有用户的数据
        List<User> userList = userMapper.pagingToGetUserData(pagingToGetUserDataBo);

        //获取用户总数
        Long count = userMapper.pagingToGetCountOfUserData(pagingToGetUserDataBo);

        PagingToGetUserDataVo pagingToGetUserDataVo = new PagingToGetUserDataVo();
        pagingToGetUserDataVo.setCount(count);
        pagingToGetUserDataVo.setList(userList);

        return new ResponseVo("查询成功",pagingToGetUserDataVo,"0x200");
    }

//    /**
//     * @quthor hln 2023-10-30
//     *      用户签到
//     * @param userSignInBo
//     * @return
//     */
//    @Override
//    public ResponseVo userSignIn(UserSignInBo userSignInBo) {
//
//        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
//        Long userId = Long.valueOf(userIdOfStr);//用户id
//
//        if(userId == null || userId == 0L){
//            return new ResponseVo("token解析失败",null,"0x501");
//        }
//
//        userSignInBo.setStatus(1);
//        userSignInBo.setUserId(userId);
//        userSignInBo.setCreateTime(new Date());
//        //插入sign_in表中
//        userMapper.userSignIn(userSignInBo);
//
//        //根据user_id获取社团id
//        UserSignInBo userSignInBo1 = userMapper.selectToGetCommunityIdByUserId(userSignInBo);
//
//        if (userSignInBo1 == null){
//            userMapper.deleteSignIn(userSignInBo1);
//            return new ResponseVo("签到失败",null,"0x500");
//        }
//
//        userSignInBo1.setToken(userSignInBo.getToken());
//
//        /*
//         *  思路分析：
//         *  1. admin先发起签到
//         *  2. 用户后发签到
//         *  3. 所以向用户签到状态表中插入数据的步骤是在用户板块中进行
//         */
//        //插入最终实体数据到sign_in_user_status表中
//        UserSignInStatusBo userSignInStatusBo = new UserSignInStatusBo();
//
//        //获取user表中需要的字段
//        UserSignBo userSignBo = new UserSignBo();
//        userSignBo.setUserId(userId);
//
//        //映射user和signInAdmin中需要的字段的值到userSignInStatusBo中
//        userSignInStatusBo.setUserId(userSignInBo1.getUserId());
//        userSignInStatusBo.setCommunityId(userSignInBo1.getCommunityId());
//        userSignInStatusBo.setCreateTime(userSignInBo1.getCreateTime());
//
//        //先将sign_in_admin中查找出的字段放到sign_in_user_status表中
//        userAdminMapper.insertSignInUserStatus(userSignInStatusBo);//bug
//
//        //查询实体类所需返回全部字段
//        UserSignInStatusBo userSignInStatusBo1 = userAdminMapper.selectToGetUserBo(userSignInStatusBo);
//
//        if (userSignInStatusBo1 != null) {
//            //删除实体类中的不全信息
//            userAdminMapper.deleteBYIdToStatus(userSignInStatusBo1);
//
//            //插入所有的实体类信息
//            userAdminMapper.insertSignInUserStatusAll(userSignInStatusBo1);
//        }
//
//        return new ResponseVo("签到成功",userSignInBo1,"0x200");
//    }

    /**
     * @author hln 2023-11-03
     *      根据前端指定字段返回User信息
     * @param userSelectToGetBo
     * @return
     */
    @Override
    public ResponseVo selectToGetUser(UserSelectToGetBo userSelectToGetBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);//用户id

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        //获取指定字段的User数据
        List<UserSelectToGetVo> list = userMapper.selectToGetUser(userSelectToGetBo);

        UserSelectToGetListVo userSelectToGetListVo = new UserSelectToGetListVo();
        userSelectToGetListVo.setList(list);

        return new ResponseVo("查询成功",userSelectToGetListVo,"0x200");
    }

    /**
     * @author hln 2023-11-07
     *      用户签到（响应）功能
     * @param signInWebSocketBo
     * @return
     */
    @Override
    public ResponseVo userSignInWebSocket(SignInWebSocketBo signInWebSocketBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);//用户id

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long communityId = userMapper.selectToGetCommunityId(userId);

        if(communityId == null || communityId == 0L){
            return new ResponseVo<>("该社团内找不到此用户",null,"0x500");
        }

        SignInWebSocket signInWebSocket = new SignInWebSocket();
        signInWebSocket.setUserId(userId);
        signInWebSocket.setCreateTime(new Date());
        signInWebSocket.setContent(signInWebSocketBo.getContent());
        signInWebSocket.setCommunityId(communityId);
        signInWebSocket.setUuid(signInWebSocketBo.getUuid());

        userMapper.insertSignInWeb(signInWebSocket);

        SignInUserStatusWeb signInUserStatusWeb = userMapper.selectToGetUserAndAdminSignIn(userId);

        if (signInUserStatusWeb == null){
            return new ResponseVo("签到失败",null,"0x500");
        }

        Long id = userMapper.insertSignInUserWithAdmin(signInUserStatusWeb);

        if(id == 0L){
            return new ResponseVo("签到失败",null,"0x502");
        }

        //修改通知处理状态，若签到成功则dealt = 1
        String uuid = signInWebSocketBo.getUuid();
        noticeMapper.updateByIdDealt(uuid,userId);

        return new ResponseVo("签到成功",signInWebSocketBo,"0x200");
    }

    /**
     * @author hln 2023-11-07
     *      用户签到（响应）功能
     * @param signInWebSocketBo
     * @return
     */
    @Override
    public ResponseVo userSignInWebSocketNew(SignInWebSocketBo signInWebSocketBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);//用户id

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long communityId = userMapper.selectToGetCommunityId(userId);

        if(communityId == null || communityId == 0L){
            return new ResponseVo<>("该社团内找不到此用户",null,"0x500");
        }

        SignInWebSocket signInWebSocket = new SignInWebSocket();
        signInWebSocket.setUserId(userId);
        signInWebSocket.setCreateTime(new Date());
        signInWebSocket.setContent(signInWebSocketBo.getContent());
        signInWebSocket.setCommunityId(communityId);
        signInWebSocket.setUuid(signInWebSocketBo.getUuid());

        userMapper.insertSignInWeb(signInWebSocket);

        SignInUserStatusWeb signInUserStatusWeb = userMapper.selectToGetUserAndAdminSignInNew(userId);

        if (signInUserStatusWeb == null){
            return new ResponseVo("签到失败",null,"0x500");
        }

        Long id = userMapper.insertSignInUserWithAdmin(signInUserStatusWeb);

        if(id == 0L){
            return new ResponseVo("签到失败",null,"0x502");
        }

        //修改通知处理状态，若签到成功则dealt = 1
        String uuid = signInWebSocketBo.getUuid();
        noticeMapper.updateByIdDealt(uuid,userId);

        return new ResponseVo("签到成功",signInWebSocketBo,"0x200");
    }

    /**
     * @param findAllBo
     * @return
     * @author hln 2023-11-03
     * 查询所有信息
     */
    @Override
    public ResponseVo findAll(FindAllBo findAllBo) {
        String userOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userOfStr);

        if (userId == 0L || userId == null) {
            return new ResponseVo("token解析失败",null,"0x501");
        }

        int page = (findAllBo.getPage() - 1) * findAllBo.getSize();
        findAllBo.setPage(page);

        List<FindAllVo> list;
//        //判断前端是否传数据
//        //1）若传
//        if ((findAllBo.getCollege() != 0 && findAllBo.getCollege() != null) || findAllBo.getGrade() != null || findAllBo.getProfessional() != null) {
//            list = userMapper.selectToGetUserBy(findAllBo);
//        }
//        //2）若不传
//        else {
//            list = userMapper.selectGetUser();
//        }

        FindAllBoNew findAllBoNew = new FindAllBoNew();
        findAllBoNew.setCollege(findAllBo.getCollege());
        findAllBoNew.setGrade(findAllBo.getGrade());
        findAllBoNew.setPage(findAllBo.getPage());
        findAllBoNew.setProfessional(findAllBo.getProfessional());
        findAllBoNew.setSize(findAllBo.getSize());
        findAllBoNew.setUserId(userId);

        list = userMapper.selectToGetUserBy(findAllBoNew);
        int count = userMapper.selectToGetCount(findAllBo);
        int countNew = userMapper.selectToGetCountNew(userId);

//        //记录在社团的用户的id
//        List<Long> listNew = userMapper.selectGetUserId(userId);
//
//        Set<FindAllVo> set = new HashSet<>();
//
//        for (Long l : listNew) {
//            for (int i = 0; i < list.size(); i++) {
//                if (l == list.get(i).getId()) {
//                    list.remove(list.get(i));
//                }
//            }
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//
//        }

        FindAllVoNew findAllVoNew = new FindAllVoNew();
        findAllVoNew.setList(list);
        findAllVoNew.setCount(count - countNew - 1);

        return new ResponseVo("查询成功",findAllVoNew,"0x200");
    }

    /**
     * @author hln 2024-4-26
     *      获取签到通知信息
     * @return
     */
    @Override
    public ResponseVo NoticeUserSignIn() {

        Long userId = Long.valueOf((String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id"));
        List<SignInAdminNotice> list = userMapper.NoticeUserSignIn(userId);
        System.out.println(list);
        System.out.println(list);

        return new ResponseVo("查询成功",list,"0x200");
    }

}
