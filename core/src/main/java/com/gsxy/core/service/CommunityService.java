package com.gsxy.core.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;

/**
 * @author zhuxinyu 2023-10-24
 * 社团业务接口
 *
 */
public interface CommunityService {
    /**
     * @author zhuxinyu 2023-10-24
     *      添加社团
     * @param communityAddByIdBo
     * @return
     */
    public ResponseVo addCommunity(CommunityAddBo communityAddByIdBo);

    /**
     * @author zhuxinyu 2023-10-24
     *      删除社团
     * @param communityDeleteByIdBo
     * @return
     */
    public ResponseVo deleteByIdCommunity(CommunityDeleteByIdBo communityDeleteByIdBo);

    /**
     * @author zhuxinyu 2023-10-24
     *      查找社团
     * @param communitySelectByIdBo
     * @return
     */
    public ResponseVo selectByIdCommunity(CommunitySelectByIdBo communitySelectByIdBo);

    /**
     *@author zhuxinyu 2023-10-24
     *      修改社团
     * @param communityUpdateByIdBo
     * @return
     */
    public ResponseVo updateByIdCommunity(CommunityUpdateByIdBo communityUpdateByIdBo);
    /**
     * @author zhuxinyu 2023-10-28
     *    分页获取数据
     * @param communityPagingToGetDataBo
     * @return ResponseVo.class
     */
    public ResponseVo communityPagingToGetData(CommunityPagingToGetDataBo communityPagingToGetDataBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-30
     *       用户向社长发送通知，加入社团
     * @param communitySendNoticeBo
     * @return String.class
     */
    public ResponseVo userSendNoticeToAdmin(CommunitySendNoticeBo communitySendNoticeBo);


    /**
     * @author Oh… Yeah!!!, 2023-10-30
     *       社长向用户发送回复通知
     * @param communityReplyNoticeBo
     * @return String.class
     */
    public ResponseVo adminReplyNoticeToUser(CommunityReplyNoticeBo communityReplyNoticeBo);

    /**
     * @author zhuxinyu 2023-10-30
     *      查询该社团的所有用户数据
     * @return
     */
    public ResponseVo communityAndUser();

    /**
     * @author  zhuxinyu 2023-11-02
     *      根据社团Id查询社团的所有活动
     * @param communityAndActiveBo
     * @return
     */
    public ResponseVo communityAndActive(CommunityAndActiveBo communityAndActiveBo);

    /**
     * @author zhuxinyu 2023-11-02
     *      查询所有的社团
     * @return
     */
    public ResponseVo communityAllname();

    /**
     * @author hln 2023-11-13
     *      社长（管理员）向社团成员发起签到通知
     * @param sendNotificationBo
     * @return
     */
    ResponseVo adminSendNotification(SendNotificationBo sendNotificationBo);

    /**
     * @author hln 2023-11-13
     *      社长（管理员）向社团成员发起签到通知
     * @param sendNotificationBo
     * @return
     */
    ResponseVo adminSendNotificationNew(SendNotificationBo sendNotificationBo);

}




