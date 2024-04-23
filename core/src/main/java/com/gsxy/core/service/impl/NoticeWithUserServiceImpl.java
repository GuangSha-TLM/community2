package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.NoticeWithUserMapper;
import com.gsxy.core.pojo.Img;
import com.gsxy.core.pojo.Notice;
import com.gsxy.core.pojo.NoticeWithUser;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.NoticePagingToGetDataVo;
import com.gsxy.core.pojo.vo.NoticeWithUserPagingToGetDataVo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.NoticeWithUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通知和用户业务接口实现类
 */
@Service
public class NoticeWithUserServiceImpl implements NoticeWithUserService {

    @Autowired
    private NoticeWithUserMapper noticeWithUserMapper;

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      根据id查询数据.
     * @param noticeWithUserSelectByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeWithUserSelectById(NoticeWithUserSelectByIdBo noticeWithUserSelectByIdBo) {

        NoticeWithUser noticeWithUser = noticeWithUserMapper.selectByIdNoticeWithUser(noticeWithUserSelectByIdBo.getId());

        if (noticeWithUser == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功", noticeWithUser, "0x200");
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除数据.
     * @param noticeWithUserDeleteByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeWithUserDeleteById(NoticeWithUserDeleteByIdBo noticeWithUserDeleteByIdBo) {

        Long id = noticeWithUserDeleteByIdBo.getId();
        Long numbersOfOpetion = noticeWithUserMapper.deleteByIdNoticeWithUser(id);

        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");

    }


    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      增加新数据.
     * @param noticeWithUserAddByBo
     * @return String.class
     */
    @Override
    public ResponseVo noticeWithUserAdd(NoticeWithUserAddByBo noticeWithUserAddByBo) {

        Long aLong = noticeWithUserMapper.addNoticeWithUser(noticeWithUserAddByBo.getNoticeWithUser());

        if (aLong.longValue() == 0){
            return new ResponseVo("增加失败",  null, "0x500");
        }
        return new ResponseVo("增加成功", null, "0x200");
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      通过id更新数据.
     * @param noticeWithUserUpdateByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeWithUserUpdateById(NoticeWithUserUpdateByIdBo noticeWithUserUpdateByIdBo) {

        Long numbersOfOpertion = noticeWithUserMapper.updateByIdNoticeWithUser(noticeWithUserUpdateByIdBo.getNoticeWithUser());

        if (numbersOfOpertion.longValue() == 0L){
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");

    }


    /**
     * @author Oh...Yeah!!! 2023-10-27
     *    分页获取数据
     * @param noticeWithUserPagingToGetDataBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeWithUserPagingToGetData(NoticeWithUserPagingToGetDataBo noticeWithUserPagingToGetDataBo) {

        List<NoticeWithUser> list = noticeWithUserMapper.noticeWithUserPagingToGetData(noticeWithUserPagingToGetDataBo);
        NoticeWithUserPagingToGetDataVo noticeWithUserPagingToGetDataVo = new NoticeWithUserPagingToGetDataVo();
        noticeWithUserPagingToGetDataVo.setCount(list.size());
        noticeWithUserPagingToGetDataVo.setList(list);

        return new ResponseVo<>(null,noticeWithUserPagingToGetDataVo,"0x200");

    }













}



