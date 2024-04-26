package com.gsxy.core.service.impl;

import com.gsxy.core.controller.UserAdminController;
import com.gsxy.core.controller.UserController;
import com.gsxy.core.mapper.*;
import com.gsxy.core.pojo.*;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.*;
import com.gsxy.core.service.CommunityService;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.service.UserService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zhuxinyu 2023-10-24
 *    社团业务实体类接口
 */
@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticeWithUserMapper noticeWithUserMapper;
    @Autowired
    private UserAdminMapper userAdminMapper;
    @Autowired
    private CommunityUserMapper communityUserMapper;
    @Autowired
    private UserAdminController userAdminController;
    @Autowired
    private UserController userController;

    /**
     * @author zhuxinyu 2023-10-24
     *      添加社团
     * @param communityAddByIdBo
     * @return
     */
    @Override
    public ResponseVo addCommunity(CommunityAddBo communityAddByIdBo) {
        String communityIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityId = Long.valueOf(communityIdOfStr);
        communityAddByIdBo.getCommunity().setCommunityId(communityId);
        communityAddByIdBo.getCommunity().setCreateBy(communityId);
        communityAddByIdBo.getCommunity().setCreateTime(new Date());
        Long aLong = communityMapper.addcommunity(communityAddByIdBo.getCommunity());
        if (aLong.longValue() == 0L) {
            return new ResponseVo("增加失败",  null, "0x500");
        }

        return new ResponseVo("增加成功", communityId, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id删除社团数据
     * @param communityDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo deleteByIdCommunity(CommunityDeleteByIdBo communityDeleteByIdBo) {
        String communityIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityId = Long.valueOf(communityIdOfStr);
        if(communityId == null || communityId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long id = communityDeleteByIdBo.getId();
        Long aLong = communityMapper.deleteByIdcommunity(id);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",id, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id查找社团数据
     * @param communitySelectByIdBo
     * @return
     */
    @Override
    public ResponseVo selectByIdCommunity(CommunitySelectByIdBo communitySelectByIdBo) {
        String communityIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityId = Long.valueOf(communityIdOfStr);
        Long id = communitySelectByIdBo.getId();
        Community community = communityMapper.selectByIdcommunity(id);
        if (community == null) {
            return new ResponseVo("查询的数据不存在,", communityId, "0x500");
        }

        return new ResponseVo("查询成功",community,"0x200");
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id更新社团数据
     * @param communityUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo updateByIdCommunity(CommunityUpdateByIdBo communityUpdateByIdBo) {
        String communityIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityId = Long.valueOf(communityIdOfStr);
        communityUpdateByIdBo.getCommunity().setCommunityId(communityId);
        communityUpdateByIdBo.getCommunity().setUpdateBy(communityId);
        communityUpdateByIdBo.getCommunity().setUpdateTime(new Date());
        Community community = communityUpdateByIdBo.getCommunity();
        Long aLong = communityMapper.updateByIdcommunity(community);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }
        return new ResponseVo("更新成功", community.getId(), "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-30
     *      查询社团所有用户数据
     * @return
     */
    @Override
    public ResponseVo communityAndUser() {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);
        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        UserAdmin userAdmin = userAdminMapper.selectByIdUserAdmin(userId);

        //找到所有该社团的用户的id
        List<CommunityAndUserVo> userList = communityMapper.communityAndUser(userAdmin.getCommunityId());

        return new ResponseVo<>("查询成功",userList,"0x200");
    }

    /**
     * @author  zhuxinyu 2023-11-02
     *      根据社团Id查询社团的所有活动
     * @param communityAndActiveBo
     * @return
     */
    @Override
    public ResponseVo communityAndActive(CommunityAndActiveBo communityAndActiveBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);
        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }
        Long communtiyId = communityAndActiveBo.getCommuntiyId();
        List<CommunityAndActiveVo> community = communityMapper.communityAndActive(communtiyId);
        if (community == null) {
            return new ResponseVo<>("查询失败",communtiyId,"0x500");
        }
        return new ResponseVo<>("查询成功",community,"0x200");
    }

    /**
     * @author zhuxinyu 2023-11-02
     *      查询所有的社团
     * @return
     */
    @Override
    public ResponseVo communityAllname(){
        List<CommunityAllname> list = communityMapper.communityAllname();
        return new ResponseVo<>("查询成功",list,"0x200");
    }

    /**
     * @author hln 2023-11-13
     *      社长（管理员）向社团成员发起签到通知
     * @param sendNotificationBo
     * @return
     */
    @Override
    public ResponseVo adminSendNotification(SendNotificationBo sendNotificationBo) {
        String adminIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(adminIdOfStr);

        if(adminId == 0L || adminId == null){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        //获取该社团内所有用户的id
        List<Long> list = communityMapper.selectToGetUserId(adminId);

        String name = userMapper.selectToGetNameByUserId(adminId);

        //随机生成UUID编号
        UUID uuid = UUID.randomUUID();
        String uuid1 = uuid.toString().replace("-", "").toLowerCase();

        int l = 0;
        while (l < list.size()) {
            if(list.get(l) == adminId){
                l++;
                continue;
            }
            SendNotification sendNotification = new SendNotification();
            sendNotification.setCreateBy(adminId);
            sendNotification.setCreateTime(new Date());
            sendNotification.setUserId(list.get(l++));
            sendNotification.setName(name);
            sendNotification.setUuid(uuid1);

            //将通知内容注入到数据库中
            Long notice = noticeMapper.insertNotice(sendNotification);

            if (notice == null || notice == 0L) {
                return new ResponseVo("通知发起失败", null, "0x500");
            }
        }

        //创建发起签到功能的传入类实体对象
        SignInAdminWebSocketBo signInAdminWebSocketBo = new SignInAdminWebSocketBo();
        signInAdminWebSocketBo.setToken(sendNotificationBo.getToken());
        signInAdminWebSocketBo.setContent(sendNotificationBo.getContent());
        signInAdminWebSocketBo.setSignInTime(sendNotificationBo.getSignInTime());

        return new ResponseVo("通知已发起",null,"0x200");
    }

    /**
     * @author hln 2023-12-02
     *      社长（管理员）向社团成员发起签到通知
     * @param sendNotificationBo
     * @return
     */
    @Override
    public ResponseVo adminSendNotificationNew(SendNotificationBo sendNotificationBo) {
        String adminIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(adminIdOfStr);

        if(adminId == 0L || adminId == null){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        //获取该社团内所有用户的id
        List<Long> list = communityMapper.selectToGetUserId(adminId);

        String name = userMapper.selectToGetNameByUserId(adminId);

        //随机生成UUID编号
        UUID uuid = UUID.randomUUID();
        String uuid1 = uuid.toString().replace("-", "").toLowerCase();

        int l = 0;
        while (l < list.size()) {
            if(list.get(l) == adminId){
                l++;
                continue;
            }
            SendNotification sendNotification = new SendNotification();
            sendNotification.setCreateBy(adminId);
            sendNotification.setCreateTime(new Date());
            sendNotification.setUserId(list.get(l++));
            sendNotification.setName(name);
            sendNotification.setUuid(uuid1);

            //将通知内容注入到数据库中
            Long notice = noticeMapper.insertNotice(sendNotification);

            if (notice == null || notice == 0L) {
                return new ResponseVo("通知发起失败", null, "0x500");
            }
        }

        //创建发起签到功能的传入类实体对象
        SignInAdminWebSocketBo signInAdminWebSocketBo = new SignInAdminWebSocketBo();
        signInAdminWebSocketBo.setToken(sendNotificationBo.getToken());
        signInAdminWebSocketBo.setContent(sendNotificationBo.getContent());
        signInAdminWebSocketBo.setSignInTime(sendNotificationBo.getSignInTime());

        Long id = userAdminMapper.selectToGetId();
        noticeMapper.updateByUUIDAddAdminSignId(uuid1,id);

        return new ResponseVo("通知已发起",id,"0x200");
    }

    /**
     * @author zhuxinyu 2023-10-29
     *    分页获取数据
     * @param communityPagingToGetDataBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo communityPagingToGetData(CommunityPagingToGetDataBo communityPagingToGetDataBo) {
        List <Community> list = communityMapper.communityPagingToGetData(communityPagingToGetDataBo);
        CommunityPagingToGetDataVo communityPagingToGetDataVo = new CommunityPagingToGetDataVo();
        communityPagingToGetDataVo.setList(list);
        communityPagingToGetDataVo.setCount(list.size());
        return null;
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-30
     *       用户向社长发送通知，加入社团
     * @param communitySendNoticeBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userSendNoticeToAdmin(CommunitySendNoticeBo communitySendNoticeBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        //获取发送信息的用户数据
        User user = userMapper.selectByUserId(userId);

        //封装用户信息和回复内容
        UserSendMessageVo userSendMessageVo = new UserSendMessageVo(user.getUsername(),user.getProfessional(),user.getGrade(),communitySendNoticeBo.getApplyContext());

        //创建通知
        Notice  notice= new Notice();
        notice.setContext(userSendMessageVo.getApplyContext()+"");

        //查找对应社团
        Community community = communityMapper.selectByCommunityId(communitySendNoticeBo.getCommunityId());

        //获取社长信息
        Long createBy = communityMapper.selectByCommunityId(communitySendNoticeBo.getCommunityId()).getCreateBy();

        //设置通知信息
        notice.setName(user.getName() +"申请加入"+ community.getName() +"社团");
        notice.setUserEmailId(createBy);
        notice.setCreateBy(userId);
        notice.setRead(0);
        notice.setDealt(0);
        notice.setKinds(1);
        notice.setCreateTime(new Date());
        UUID uuid = UUID.randomUUID();
        notice.setUuid(uuid.toString());
        notice.setAdminSignId(0L);

        //发送通知
        noticeMapper.addNotice(notice);

        //获取最新的通知的id
        Notice notice2 =noticeMapper.seleByUUID(uuid.toString());


        //设置历史记录信息
        NoticeWithUser noticeWithUser = new NoticeWithUser();
        noticeWithUser.setReceiveUserId(createBy);
        noticeWithUser.setSendUserId(userId);
        noticeWithUser.setCreateBy(userId);
        noticeWithUser.setNoticeId(notice2.getId());
        noticeWithUser.setCreateTime(new Date());



        //增添历史记录
        noticeWithUserMapper.addNoticeWithUser(noticeWithUser);

        return new ResponseVo("信息发送成功",   null, "0x200");

    }



    /**
     * @author Oh… Yeah!!!, 2023-10-30
     *       社长向用户发送回复通知
     * @param communityReplyNoticeBo
     * @return String.class
     */
    @Override
    public ResponseVo adminReplyNoticeToUser(CommunityReplyNoticeBo communityReplyNoticeBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        //设置通知的处理状态
        noticeMapper.updateByIdToDealt(communityReplyNoticeBo.getNoticeId());

        //获取目标通知
        NoticeWithUser noticeWithUser1 = noticeWithUserMapper.selectByNoticeId(communityReplyNoticeBo.getNoticeId());

        //获取曾经发送信息的用户
        User user = userMapper.selectByUserId(noticeWithUser1.getSendUserId());

        //根据社长的id获取社团的id
        UserAdmin userAdmin = userAdminMapper.selectByIdUserAdmin(userId);

        //社长决定是否让该用户进入社团
        if (communityReplyNoticeBo.getResult() == 1){

            //获取该社团的信息
            Community community = communityMapper.selectByCommunityId(userAdmin.getCommunityId());

            //发送拒绝通知
            Notice notice = new Notice();
            notice.setContext(community.getName()+"的社长拒绝你加入");
            notice.setUserEmailId(user.getId());
            notice.setName(community.getName() + "拒绝了" + user.getName());
            UUID uuid = UUID.randomUUID();
            notice.setUuid(uuid.toString());
            notice.setCreateBy(userId);
            notice.setStatus(0);
            notice.setDelFlag(0);
            notice.setRead(0);
            notice.setDealt(1);
            notice.setKinds(0);
            notice.setCreateTime(new Date());
            notice.setAdminSignId(0L);

            //发送通知
            noticeMapper.addNotice(notice);

            //获取最新的通知的id
            Notice notice2 =noticeMapper.seleByUUID(uuid.toString());

            NoticeWithUser noticeWithUser = new NoticeWithUser();
            noticeWithUser.setReceiveUserId(user.getId());
            noticeWithUser.setSendUserId(userId);
            noticeWithUser.setNoticeId(notice2.getId());
            noticeWithUser.setCreateBy(userId);
            noticeWithUser.setStatus(0);
            noticeWithUser.setDelFlag(0);
            noticeWithUser.setCreateTime(new Date());

            noticeWithUserMapper.addNoticeWithUser(noticeWithUser);

            return  new ResponseVo("社长已拒绝了" + user.getName() + "的加入",   null, "0x200");
        }



        //查看该用户是否已经在这个社团
        CommunityUser communityUser = communityUserMapper.communityUserSelectByUserId(user.getId(),userAdmin.getCommunityId());
        if (communityUser != null){
            return  new ResponseVo("该用户已经存在这个社团中",   null, "0x206");
        }

        //将该用户加入到此社团
        CommunityUser communityUser2 = new CommunityUser();
        communityUser2.setCommunityId(userAdmin.getCommunityId());
        communityUser2.setUserId(user.getId());
        communityUser2.setCreateBy(userAdmin.getUserId());

        communityUserMapper.communityUseAdd(communityUser2);

        //设置通知信息
        Notice notice = new Notice();
        notice.setName("社长回复"+user.getName() + communityReplyNoticeBo.getContext() +"加入此社团");
        notice.setUserEmailId(noticeWithUser1.getSendUserId());
        notice.setCreateBy(userId);
        notice.setContext(communityReplyNoticeBo.getContext());
        notice.setStatus(0);
        notice.setDelFlag(0);
        notice.setRead(0);
        notice.setDealt(1);
        notice.setKinds(0);
        notice.setCreateTime(new Date());
        notice.setAdminSignId(0L);

        noticeMapper.addNotice(notice);


        //设置历史记录信息
        NoticeWithUser noticeWithUser2 = new NoticeWithUser();
        noticeWithUser2.setReceiveUserId(user.getId());
        noticeWithUser2.setSendUserId(userId);
        noticeWithUser2.setCreateBy(userId);
        noticeWithUser2.setStatus(0);
        noticeWithUser2.setDelFlag(0);
        noticeWithUser2.setCreateTime(new Date());
        //增添历史记录
        noticeWithUserMapper.addNoticeWithUser(noticeWithUser2);

        return new ResponseVo("社长消息回复成功",   communityReplyNoticeBo.getContext(), "0x200");
    }



}


