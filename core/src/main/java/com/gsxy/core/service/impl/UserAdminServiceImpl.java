package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.NoticeMapper;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.SignInAdmin;
import com.gsxy.core.pojo.SignInAdminWebSocket;
import com.gsxy.core.pojo.UserAdmin;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.pojo.vo.SignInAdminWebVo;
import com.gsxy.core.pojo.vo.UserAdminPagingToGetDataVo;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  管理员业务接口实现类
 */
@Service
public class UserAdminServiceImpl implements UserAdminService {

    @Autowired
    private UserAdminMapper userAdminMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      根据id查询数据.
     * @param userAdminSelectByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminSelectById(UserAdminSelectByIdBo userAdminSelectByIdBo) {

        UserAdmin userAdmin = userAdminMapper.selectByIdUserAdmin(userAdminSelectByIdBo.getId());
        if (userAdmin == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功", userAdmin, "0x200");
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id删除UserAdmin数据.
     * @param userAdminDeleteByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminDeleteById(UserAdminDeleteByIdBo userAdminDeleteByIdBo) {

        Long id = userAdminDeleteByIdBo.getId();
        Long numbersOfOpetion = userAdminMapper.deleteByIdUserAdmin(id);
        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");

    }


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      增加新数据.
     * @param userAdminAddByBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminAdd(UserAdminAddByBo userAdminAddByBo) {

        Long aLong = userAdminMapper.addUserAdmin(userAdminAddByBo.getUserAdmin());
        if (aLong.longValue() == 0){
            return new ResponseVo("增加失败",  null, "0x500");
        }
        return new ResponseVo("增加成功", null, "0x200");
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id更新userAdmin数据.
     * @param userAdminUpdateByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminUpdateById(UserAdminUpdateByIdBo userAdminUpdateByIdBo) {

        UserAdmin userAdmin = userAdminUpdateByIdBo.getUserAdmin();
        Long numbersOfOpertion = userAdminMapper.updateByIdUserAdmin(userAdmin);
        if (numbersOfOpertion.longValue() == 0L){
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");

    }

    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param userAdminPagingToGetDataBo
     * @return String.class
     */
    @Override
    public Object pagingToGetUserAdminData(UserAdminPagingToGetDataBo userAdminPagingToGetDataBo) {

        List<UserAdmin> list = userAdminMapper.userAdminPagingToGetData(userAdminPagingToGetDataBo);
        UserAdminPagingToGetDataVo userAdminPagingToGetDataVo = new UserAdminPagingToGetDataVo();
        userAdminPagingToGetDataVo.setCount(list.size());
        userAdminPagingToGetDataVo.setList(list);

        return new ResponseVo<>(null,userAdminPagingToGetDataVo,"0x200");

    }

    /**
     * @author hln 2023-10-31
     *      管理员发起签到
     * @param signInAdminBo
     * @return
     */
    @Override
    public ResponseVo userAdminSignIn(SignInAdminBo signInAdminBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(userIdOfStr);

        if (adminId == null || adminId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        SignInAdmin signInAdmin = new SignInAdmin();
        signInAdmin.setAdminId(adminId);
        signInAdmin.setCreateTime(new Date());

        //插入发起签到信息到sign_in_admin表中
        userAdminMapper.insertSignInAdmin(signInAdmin);

        //查找社团id
        SignInAdmin signInAdmin1 = userAdminMapper.selectToGetCommunityId(signInAdmin);

        if (signInAdmin1 != null){
            userAdminMapper.deleteByIdSignIn(signInAdmin1);
            userAdminMapper.insertSignInAdmin(signInAdmin1);
        }

        //根据admin_id查询sign_in_admin表中相应数据
        Long id = userAdminMapper.selectToGetByAdminId(signInAdmin1);

        if (id == null){
            return new ResponseVo("签到发起失败",null,"0x500");
        }

        signInAdminBo.setSignInAdmin(signInAdmin1);

        return new ResponseVo("签到已发起",signInAdminBo,"0x200");
    }

    /**
     * @author hln 2023-11-01
     *      管理员查看所有签到状态
     * @return
     */
    @Override
    public ResponseVo findAllSignInStatus() {
        List<UserSignInStatusBo> list = userAdminMapper.findAllSignInStatus();

        if(list == null){
            return new ResponseVo("查询失败",null,"0x500");
        }

        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     * @param signInAdminWebSocketBo
     * @param uuid1
     * @return
     * @author hln 2023-11-07
     * 管理员发起签到-WebSocket
     */
    @Override
    public ResponseVo adminSignInWeb(SignInAdminWebSocketBo signInAdminWebSocketBo, String uuid1) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(userIdOfStr);

        if (adminId == null || adminId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        SignInAdminWebSocket signInAdminWebSocket = new SignInAdminWebSocket();

        signInAdminWebSocket.setAdminId(adminId);
        signInAdminWebSocket.setCommunityId(adminId);
        signInAdminWebSocket.setReleaseTime(new Date());
        signInAdminWebSocket.setContent(signInAdminWebSocketBo.getContent());
        signInAdminWebSocket.setSignInTime(signInAdminWebSocketBo.getSignInTime());
        signInAdminWebSocket.setUuid(uuid1);

        userAdminMapper.insertPutSignIn(signInAdminWebSocket);

        return new ResponseVo("签到已发起",signInAdminWebSocketBo,"0x200");
    }

    /**
     * @param signInAdminWebSocketBo
     * @param uuid1
     * @return
     * @author hln 2023-11-07
     * 管理员发起签到-WebSocket
     */
    @Override
    public ResponseVo adminSignInWebNew(SignInAdminWebSocketBo signInAdminWebSocketBo, String uuid1) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(userIdOfStr);

        if (adminId == null || adminId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        SignInAdminWebSocket signInAdminWebSocket = new SignInAdminWebSocket();

        signInAdminWebSocket.setAdminId(adminId);
        signInAdminWebSocket.setCommunityId(adminId);
        signInAdminWebSocket.setReleaseTime(new Date());
        signInAdminWebSocket.setContent(signInAdminWebSocketBo.getContent());
        signInAdminWebSocket.setSignInTime(signInAdminWebSocketBo.getSignInTime());
        signInAdminWebSocket.setUuid(uuid1);

        userAdminMapper.insertPutSignInNew(signInAdminWebSocket);

        return new ResponseVo("签到已发起",signInAdminWebSocketBo,"0x200");
    }

    /**
     * @author hln 2023-11-22
     *      管理员查看实时签到信息
     * @param token
     * @return
     */
    @Override
    public ResponseVo adminCheckInStatusInRealTime(String token) {
        String adminIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(adminIdOfStr);

        if(adminId == null || adminId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long id = noticeMapper.selectByUserIdNotice(adminId);
        //判断通知是否收到
        if(id == null || id == 0L){
            return new ResponseVo("未接受到签到通知",null,"0x500");
        }

        String uuid = noticeMapper.selectToGetUUID(id);

        //封装所有用户签到状态表中的用户id
        Set<Long> set = userAdminMapper.selectToGetIdByAdminId(adminId,uuid);

        //封装该社团所有用户id到List集合中
        List<Long> list = userAdminMapper.selectToGetUserIdByAdminId(adminId);

        List<String> listSignIn = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Long userId = list.get(i);
            String name = userAdminMapper.selectToGetName(userId);

            if (name == null)
                continue;

            if(!set.add(list.get(i))){
                listSignIn.add(name + "已签到");
            }else {
                listSignIn.add(name + "未签到");
            }
        }

        return new ResponseVo("查询成功",listSignIn,"0x200");
    }

    /**
     * @author hln 2023-12-02
     *      管理员查看实时签到信息
     * @param token
     * @return
     */
    @Override
    public ResponseVo adminCheckInStatusInRealTimeNew(String token) {
        String adminIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(adminIdOfStr);

        if(adminId == null || adminId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        //获取通知对应的id编号
        Long id = noticeMapper.selectByUserIdNotice(adminId);
        //判断通知是否收到
        if(id == null || id == 0L){
            return new ResponseVo("未接受到签到通知",null,"0x500");
        }

        String uuid = noticeMapper.selectToGetUUID(id);

        //封装所有用户签到状态表中的用户id
        Set<Long> set = new HashSet<>();
        set = userAdminMapper.selectToGetIdByAdminId(adminId,uuid);

        //封装该社团所有用户id到List集合中
        List<Long> list = new ArrayList<>();
        list = userAdminMapper.selectToGetUserIdByAdminId(adminId);

        List<String> listSignIn = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Long userId = list.get(i);
            String name = userAdminMapper.selectToGetName(userId);
            String name2 = userAdminMapper.selectToGetNameNew(userId);

            if (name == null)
                continue;

            if(!set.add(list.get(i)) && name2 != null){
                listSignIn.add(name + "已签到");
            }else {
                listSignIn.add(name + "未签到");
            }
        }

        return new ResponseVo("查询成功",listSignIn,"0x200");
    }

    /**
     * @author hln 2023-12-02
     *      管理员查看实时签到信息
     * @param id
     * @return
     */
    @Override
    public ResponseVo adminCheckInStatusInRealTimeLast(Long id) {

        //获取通知对应的id编号
        List<Long> listId = noticeMapper.selectByAdminSignIdNotice(id);

        //判断通知是否收到
        if(listId == null){
            return new ResponseVo("未接受到签到通知",null,"0x500");
        }

//        String uuid = noticeMapper.selectToGetUUID(noticeId);

        //封装所有用户签到状态表中的用户id
        Set<String> set1 = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < listId.size(); i++) {
            Long noticeId = listId.get(i);
            set1 = userAdminMapper.selectToIdByAdminId(noticeId);
            if (set1.size() != 0){
                for (String s : set1) {
                    set.add(s);
                }
            }
        }

        //封装该社团所有用户id到List集合中
        Long noticeId = listId.get(listId.size() - 1);
        String uuid = noticeMapper.selectToGetUUID(noticeId);
        List<String> list = noticeMapper.selectToUser(uuid);

        List<String> listSignIn = new ArrayList<>();

        for (int i = 0; i <  list.size(); i++) {

            if(!set.add(list.get(i))){
                listSignIn.add(list.get(i) + "已签到");
            }else {
                listSignIn.add(list.get(i) + "未签到");
            }
        }

        return new ResponseVo("查询成功",listSignIn,"0x200");
    }

    /**
     * @author hln 2023-12-03
     *      管理员查看新发起的签到信息
     * @return
     */
    @Override
    public ResponseVo adminToGetSignInReal(String token) {

        String adminIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(adminIdOfStr);

        if(adminId == null || adminId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        List<SignInAdminWebVo> list =userAdminMapper.selectToGetSignInReal(adminId);

        if (list == null) {
            return new ResponseVo("查询失败",null,"0x500");
        }

        return new ResponseVo("查询成功",list,"0x200");
    }

}
