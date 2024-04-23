package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;

public interface CommunityUserService {
    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户添加
     * @param communityUserAddBo
     * @return
     */
    public ResponseVo communityUseradd(CommunityUserAddBo communityUserAddBo);

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户删除
     * @param communityUserDeleteByIdBo
     * @return
     */
    public ResponseVo communityUserDeleteById(CommunityUserDeleteByIdBo communityUserDeleteByIdBo);

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户查询
     * @param communityUserSelectByIdBo
     * @return
     */
    public ResponseVo communityUserSelectById(CommunityUserSelectByIdBo communityUserSelectByIdBo);

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户修改
     * @param communityUserUpdateByIdBo
     * @return
     */
    public ResponseVo communityUserUpdateById(CommunityUserUpdateByIdBo communityUserUpdateByIdBo);

    /**
     * @author zhuxinyu 2023-11-03
     *      删除社员
     * @param communityUserdeleteUserBo
     * @return
     */
    public ResponseVo communityUserdeleteUser(CommunityUserdeleteUserBo communityUserdeleteUserBo);

    /**
     * @author zhuxinyu 2023-11-06
     *      社长向用户发送已加入通知
     * @param communityUserAndUserNoticeBo
     * @return
     */
    public ResponseVo communityToUserNotice(CommunityUserAndUserNoticeBo communityUserAndUserNoticeBo);

    /**
     * @author zhuxinyu 2023-10-30
     * 查询社团所有用户
     * @return
     */
    public ResponseVo communityUserAndUser();
}
