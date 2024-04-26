package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.NoticeMapper;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.SignInAdminR;
import com.gsxy.core.pojo.User;
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
 * @author Oh...Yeah!!! 2023-10-28
 * 管理员业务接口实现类
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
     * @param userAdminSelectByIdBo
     * @return ResponseVo.class
     * @author Oh… Yeah!!!, 2023-10-24
     * 根据id查询数据.
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
     * @param userAdminDeleteByIdBo
     * @return ResponseVo.class
     * @author Oh… Yeah!!!, 2023-10-24
     * 通过id删除UserAdmin数据.
     */
    @Override
    public ResponseVo userAdminDeleteById(UserAdminDeleteByIdBo userAdminDeleteByIdBo) {

        Long id = userAdminDeleteByIdBo.getId();
        Long numbersOfOpetion = userAdminMapper.deleteByIdUserAdmin(id);
        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功", null, "0x200");

    }


    /**
     * @param userAdminAddByBo
     * @return ResponseVo.class
     * @author Oh… Yeah!!!, 2023-10-24
     * 增加新数据.
     */
    @Override
    public ResponseVo userAdminAdd(UserAdminAddByBo userAdminAddByBo) {

        Long aLong = userAdminMapper.addUserAdmin(userAdminAddByBo.getUserAdmin());
        if (aLong.longValue() == 0) {
            return new ResponseVo("增加失败", null, "0x500");
        }
        return new ResponseVo("增加成功", null, "0x200");
    }


    /**
     * @param userAdminUpdateByIdBo
     * @return ResponseVo.class
     * @author Oh… Yeah!!!, 2023-10-24
     * 通过id更新userAdmin数据.
     */
    @Override
    public ResponseVo userAdminUpdateById(UserAdminUpdateByIdBo userAdminUpdateByIdBo) {

        UserAdmin userAdmin = userAdminUpdateByIdBo.getUserAdmin();
        Long numbersOfOpertion = userAdminMapper.updateByIdUserAdmin(userAdmin);
        if (numbersOfOpertion.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");

    }

    /**
     * @param userAdminPagingToGetDataBo
     * @return String.class
     * @author Oh...Yeah!!! 2023-10-28
     * 分页获取数据
     */
    @Override
    public Object pagingToGetUserAdminData(UserAdminPagingToGetDataBo userAdminPagingToGetDataBo) {

        List<UserAdmin> list = userAdminMapper.userAdminPagingToGetData(userAdminPagingToGetDataBo);
        UserAdminPagingToGetDataVo userAdminPagingToGetDataVo = new UserAdminPagingToGetDataVo();
        userAdminPagingToGetDataVo.setCount(list.size());
        userAdminPagingToGetDataVo.setList(list);

        return new ResponseVo<>(null, userAdminPagingToGetDataVo, "0x200");

    }

    /**
     * @return
     * @author hln 2023-11-01
     * 管理员查看所有签到状态
     */
    @Override
    public ResponseVo findAllSignInStatus() {
        List<UserSignInStatusBo> list = userAdminMapper.findAllSignInStatus();

        if (list == null) {
            return new ResponseVo("查询失败", null, "0x500");
        }

        return new ResponseVo("查询成功", list, "0x200");
    }

    /**
     * @return
     * @author hln 2023-12-03
     * 管理员查看新发起的签到信息
     */
    @Override
    public ResponseVo adminToGetSignInReal(String token) {

        String adminIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(adminIdOfStr);

        if (adminId == null || adminId == 0L) {
            return new ResponseVo("token解析失败", null, "0x501");
        }

        List<SignInAdminWebVo> list = userAdminMapper.selectToGetSignInReal(adminId);

        if (list == null) {
            return new ResponseVo("查询失败", null, "0x500");
        }

        return new ResponseVo("查询成功", list, "0x200");
    }

    /**
     * @param
     * @param id
     * @return
     * @author hln 2023-12-02
     * 管理员查看实时签到信息
     */
    @Override
    public ResponseVo queryAll(Long id) {

        //获取通知对应的id编号
        List<SignInAdminR> signInAdminR = userAdminMapper.querySignInNoticeListById(id);
        List<String> returnList = new ArrayList<>();

        //判断通知是否收到
        if (signInAdminR == null) {
            return new ResponseVo("未接受到签到通知", null, "0x500");
        }

        for (SignInAdminR inAdminR : signInAdminR) {
            Long adminId = inAdminR.getSignUserId();
            Set<Long> set = new HashSet<>();

            //社团内所有用户id
            List<Long> listUserAll = userAdminMapper.queryCommunityUserAll(adminId);
            //该社团内签到了的用户
            List<Long> listSignUser = userAdminMapper.querySignUserAll(inAdminR.getKey());

            for (Long i : listSignUser) {
                set.add(i);
            }

            for (Long i : listUserAll) {
                User user = userMapper.selectByUserId(i);
                if (!set.add(i)) {
                    returnList.add(user.getName() + "已签到");
                } else {
                    returnList.add(user.getName() + "未签到");
                }
            }
        }

        return new ResponseVo("查询成功", returnList, "0x200");
    }

    @Override
    public ResponseVo querySignInAdmin(String token) {
        Long userId = Long.valueOf((String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id"));
        List<SignInAdminR> signInAdminR = userAdminMapper.querySignInNoticeList(userId);
        return new ResponseVo("查询成功", signInAdminR, "0x200");
    }

//    /**
//     * @author hln 2024-4-26
//     *      管理员发起签到通知相关社团成员
//     * @param adminSignInNoticeBo
//     * @return
//     */
//    @Override
//    public ResponseVo adminSignInNotice(AdminSignInNoticeBo adminSignInNoticeBo) {
//
//        adminSignInNoticeBo.setNoticeContext("您有新的签到, 签到时长为 " + adminSignInNoticeBo.getDuration() + " 分钟");
//        userAdminMapper.insertNotice(adminSignInNoticeBo);
//
//        return new ResponseVo("已通知",null,"0x200");
//    }

}
