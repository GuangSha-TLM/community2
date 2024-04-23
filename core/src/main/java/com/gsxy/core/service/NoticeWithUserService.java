package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通知和用户业务接口
 */
public interface NoticeWithUserService {

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      根据id查询数据.
     * @param noticeWithUserSelectByIdBo
     * @return String.class
     */
    public ResponseVo noticeWithUserSelectById(NoticeWithUserSelectByIdBo noticeWithUserSelectByIdBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除数据.
     * @param noticeWithUserDeleteByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo noticeWithUserDeleteById(NoticeWithUserDeleteByIdBo noticeWithUserDeleteByIdBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      增加新数据.
     * @param noticeWithUserAddByBo
     * @return String.class
     */
    public ResponseVo noticeWithUserAdd(NoticeWithUserAddByBo noticeWithUserAddByBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      通过id更新数据.
     * @param noticeWithUserUpdateByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo noticeWithUserUpdateById(NoticeWithUserUpdateByIdBo noticeWithUserUpdateByIdBo);

    /**
     * @author Oh...Yeah!!! 2023-10-27
     *    分页获取数据
     * @param noticeWithUserPagingToGetDataBo
     * @return ResponseVo.class
     */
    public ResponseVo noticeWithUserPagingToGetData(NoticeWithUserPagingToGetDataBo noticeWithUserPagingToGetDataBo);
}
