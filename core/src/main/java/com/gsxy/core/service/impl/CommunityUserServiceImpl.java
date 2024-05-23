package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.*;
import com.gsxy.core.pojo.*;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.CommunityUserAndUserVO;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.CommunityUserService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CommunityUserServiceImpl implements CommunityUserService {
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
    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户添加
     * @param communityUserAddBo
     * @return
     */
    @Override
    public ResponseVo communityUseradd(CommunityUserAddBo communityUserAddBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        communityUserAddBo.getCommunityUser().setCommunityId(communityUserId);
        communityUserAddBo.getCommunityUser().setCreateBy(communityUserId);
        communityUserAddBo.getCommunityUser().setCreateTime(new Date());
        Long aLong = communityUserMapper.communityUseAdd(communityUserAddBo.getCommunityUser());
        if (aLong.longValue() == 0L) {
            return new ResponseVo("增加失败",  null, "0x500");
        }
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        //获取该社团的信息
        Community community = communityMapper.selectByCommunityId(userId);

        //发送通知
        Notice notice = new Notice();
        notice.setContext(community.getName()+"的社长已成功将你拉取到该社团");
        notice.setUserEmailId(communityUserAddBo.getCommunityUser().getUserId());

        notice.setCreateBy(userId);
        notice.setCreateTime(new Date());
        notice.setStatus(0);
        notice.setDelFlag(0);
        notice.setAdminSignId(0L);

        UUID uuid = UUID.randomUUID();
        notice.setUuid(uuid.toString());

        //发送通知
        noticeMapper.addNotice(notice);

        //获取最新的通知的id
        Notice notice2 =noticeMapper.seleByUUID(uuid.toString());

        //设置历史记录信息
        NoticeWithUser noticeWithUser = new NoticeWithUser();
        noticeWithUser.setReceiveUserId(communityUserAddBo.getCommunityUser().getUserId());
        noticeWithUser.setSendUserId(userId);
        noticeWithUser.setNoticeId(notice2.getId());
        noticeWithUser.setCreateBy(userId);
        noticeWithUser.setCreateTime(new Date());
        noticeWithUser.setStatus(0);
        noticeWithUser.setDelFlag(0);
        noticeWithUserMapper.addNoticeWithUser(noticeWithUser);

        communityUserAddBo.getCommunityUser().setCommunityId(communityUserId);
        communityUserAddBo.getCommunityUser().setCreateBy(communityUserId);
        communityUserAddBo.getCommunityUser().setCreateTime(new Date());
        communityUserAddBo.getCommunityUser().getUserId();
        return new ResponseVo("增加成功", userId, "0x200");
    }



    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户删除
     * @param communityUserDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo communityUserDeleteById(CommunityUserDeleteByIdBo communityUserDeleteByIdBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        if(communityUserId == null || communityUserId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }
        //获取该社团的信息
        Community community = communityMapper.selectByCommunityId(communityUserId);

        //发送通知
        Notice notice = new Notice();
        notice.setContext(community.getName()+"的社长已将你移除该社团");
        notice.setUserEmailId(communityUserDeleteByIdBo.getUserId());

        notice.setCreateBy(communityUserId);
        notice.setCreateTime(new Date());
        notice.setStatus(0);
        notice.setDelFlag(0);
        notice.setAdminSignId(0L);

        UUID uuid = UUID.randomUUID();
        notice.setUuid(uuid.toString());

        //发送通知
        noticeMapper.addNotice(notice);

        //获取最新的通知的id
        Notice notice2 =noticeMapper.seleByUUID(uuid.toString());

        //设置历史记录信息
        NoticeWithUser noticeWithUser = new NoticeWithUser();
        noticeWithUser.setReceiveUserId(communityUserDeleteByIdBo.getUserId());
        noticeWithUser.setSendUserId(communityUserId);
        noticeWithUser.setNoticeId(notice2.getId());
        noticeWithUser.setCreateBy(communityUserId);
        noticeWithUser.setCreateTime(new Date());
        noticeWithUser.setStatus(0);
        noticeWithUser.setDelFlag(0);
        noticeWithUserMapper.addNoticeWithUser(noticeWithUser);
        Long userId = communityUserDeleteByIdBo.getUserId();
        Long aLong = communityUserMapper.communityUserDeleteById(userId);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",userId, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户查询
     * @param communityUserSelectByIdBo
     * @return
     */
    @Override
    public ResponseVo communityUserSelectById(CommunityUserSelectByIdBo communityUserSelectByIdBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        Long id = communityUserSelectByIdBo.getId();
        CommunityUser communityUser = communityUserMapper.communityUserSelectById(id);
        if (communityUser == null) {
            return new ResponseVo("查询的数据不存在,", communityUserId, "0x500");
        }

        return new ResponseVo("查询成功",communityUser,"0x200");

    }

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户修改
     * @param communityUserUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo communityUserUpdateById(CommunityUserUpdateByIdBo communityUserUpdateByIdBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        communityUserUpdateByIdBo.getCommunityUser().setUserId(communityUserId);
        communityUserUpdateByIdBo.getCommunityUser().setUpdateBy(communityUserId);
        communityUserUpdateByIdBo.getCommunityUser().setUpdateTime(new Date());
        CommunityUser communityUser = communityUserUpdateByIdBo.getCommunityUser();
        Long aLong = communityUserMapper.communityUserUpdateById(communityUser);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }
        return new ResponseVo("更新成功", communityUser.getId(), "0x200");
    }

    /**
     * @author zhuxinyu 2023-11-03
     *      删除社员
     * @param communityUserdeleteUserBo
     * @return
     */
    @Override
    public ResponseVo communityUserdeleteUser(CommunityUserdeleteUserBo communityUserdeleteUserBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        if(communityUserId == null || communityUserId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Community community = communityMapper.selectByCommunityId(communityUserId);
        communityUserMapper.communityUserdeleteUser(community.getCommunityId(),communityUserdeleteUserBo.getUserId());
        //发送通知
        Notice notice = new Notice();
        notice.setContext(community.getName()+"的社长已将你移除该社团");
        notice.setUserEmailId(communityUserdeleteUserBo.getUserId());

        notice.setCreateBy(communityUserId);
        notice.setCreateTime(new Date());
        notice.setStatus(0);
        notice.setDelFlag(0);
        notice.setAdminSignId(0L);

        UUID uuid = UUID.randomUUID();
        notice.setUuid(uuid.toString());

        //发送通知
        noticeMapper.addNotice(notice);

        //获取最新的通知的id
        Notice notice2 =noticeMapper.seleByUUID(uuid.toString());

        //设置历史记录信息
        NoticeWithUser noticeWithUser = new NoticeWithUser();
        noticeWithUser.setReceiveUserId(communityUserdeleteUserBo.getUserId());
        noticeWithUser.setSendUserId(communityUserId);
        noticeWithUser.setNoticeId(notice2.getId());
        noticeWithUser.setCreateBy(communityUserId);
        noticeWithUser.setCreateTime(new Date());
        noticeWithUser.setStatus(0);
        noticeWithUser.setDelFlag(0);
        noticeWithUserMapper.addNoticeWithUser(noticeWithUser);
        Long userId = communityUserdeleteUserBo.getUserId();
        if (userId == 0L ) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",userId, "0x200");
    }

    /**
     * @author zhuxinyu 2023-11-06
     *      社长向用户发送已加入通知
     * @param communityUserAndUserNoticeBo
     * @return
     */
    @Override
    public ResponseVo communityToUserNotice(CommunityUserAndUserNoticeBo communityUserAndUserNoticeBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        //获取该社团的信息
        Community community = communityMapper.selectByCommunityId(userId);

        //发送通知
        Notice notice = new Notice();
        notice.setContext(community.getName()+"的社长已成功将你拉取到该社团");
//        notice.setContext(communityUserAndUserNoticeBo.getContext());
        notice.setUserEmailId(communityUserAndUserNoticeBo.getUserId());

        notice.setCreateBy(userId);
        notice.setStatus(0);
        notice.setDelFlag(0);

        UUID uuid = UUID.randomUUID();
        notice.setUuid(uuid.toString());

        //发送通知
        noticeMapper.addNotice(notice);

        //获取最新的通知的id
        Notice notice2 =noticeMapper.seleByUUID(uuid.toString());

        //设置历史记录信息
        NoticeWithUser noticeWithUser = new NoticeWithUser();
        noticeWithUser.setReceiveUserId(communityUserAndUserNoticeBo.getUserId());
        noticeWithUser.setSendUserId(userId);
        noticeWithUser.setNoticeId(notice2.getId());
        noticeWithUser.setCreateBy(userId);
        noticeWithUser.setStatus(0);
        noticeWithUser.setDelFlag(0);
        noticeWithUserMapper.addNoticeWithUser(noticeWithUser);
        return new ResponseVo("信息发送成功",   null, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-30
     * 查询社团所有用户
     * @return
     */
    @Override
    public ResponseVo communityUserAndUser(CommunityUserAndUserqueryBo communityUserAndUserBo) {
        List <CommunityUserAndUserVO> list = communityUserMapper.communityUserAndUser(communityUserAndUserBo);
        return new ResponseVo("查询成功",list,"0x200");
    }
}
