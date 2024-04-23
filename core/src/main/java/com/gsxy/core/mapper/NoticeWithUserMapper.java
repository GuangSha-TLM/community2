package com.gsxy.core.mapper;

import com.gsxy.core.pojo.NoticeWithUser;
import com.gsxy.core.pojo.bo.NoticeWithUserPagingToGetDataBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通知和用户业务持久层
 */
@Mapper
public interface NoticeWithUserMapper {

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      根据id查询数据.
     * @param id
     * @return NoticeWithUser.class
     */
    public NoticeWithUser selectByIdNoticeWithUser(Long id);

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除数据.
     * @param id
     * @return Long.class
     */
    public Long deleteByIdNoticeWithUser(Long id);

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      增加新数据.
     * @param noticeWithUser
     * @return Long.class
     */
    public Long addNoticeWithUser(NoticeWithUser noticeWithUser);

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      通过id更新数据.
     * @param noticeWithUser
     * @return Long.class
     */
    public Long updateByIdNoticeWithUser(NoticeWithUser noticeWithUser);

    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param noticeWithUserPagingToGetDataBo
     * @return List<NoticeWithUser>.class
     */
    public List<NoticeWithUser> noticeWithUserPagingToGetData(NoticeWithUserPagingToGetDataBo noticeWithUserPagingToGetDataBo);


    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    根据通知id来获取历史记录
     * @param noticeId
     * @return NoticeWithUser
     */
    public NoticeWithUser selectByNoticeId(Long noticeId);
}
