package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.NoticeMapper;
import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.Notice;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.UserAdmin;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.*;
import com.gsxy.core.service.NoticeService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 通知业务实现类
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private UserMapper userMapper;


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      用户查看通知.
     * @param
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeSelectById() {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        List<Notice> list = noticeMapper.selectByIdNotice(userId);

        if (list == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        List<NoticeWithCreateByVo> list2 = new ArrayList<>();

        for (Notice notice : list) {

            User user = userMapper.selectByUserId(notice.getCreateBy());

            if (user != null){

                //有用户数据
              list2.add(new NoticeWithCreateByVo(
                        notice.getId()    ,
                        notice.getName(),
                        notice.getUserEmailId(),
                        notice.getCreateBy(),
                        notice.getContext(),
                        user.getName(),
                        user.getProfessional(),
                        user.getGrade(),
                        notice.getRead(),
                        notice.getDealt(),
                        notice.getKinds(),
                        notice.getCreateTime(),
                        notice.getAdminSignId() == null ? -1 : notice.getAdminSignId()
                )
                );
            }else {

                //没有用户数据
                list2.add(new NoticeWithCreateByVo("这条通知的发送者未找到,这条数据id是："+notice.getId()));
            }


        }

        Long noReadCounts = noticeMapper.selectReadNotice(userId);

        NoticeListCountVo noticeListCountVo = new NoticeListCountVo(list2,noReadCounts);

        return new ResponseVo("查询成功", noticeListCountVo, "0x200");

    }

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id删除数据.
     * @param noticeDeleteByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeDeleteById(NoticeDeleteByIdBo noticeDeleteByIdBo) {

        Long id = noticeDeleteByIdBo.getId();
        Long numbersOfOpetion = noticeMapper.deleteByIdNotice(id);

        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");
    }



    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      增加新数据.
     * @param noticeAddByBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeAdd(NoticeAddByBo noticeAddByBo) {

        Long aLong = noticeMapper.addNotice(noticeAddByBo.getNotice());

        if (aLong.longValue() == 0){
            return new ResponseVo("增加失败",  null, "0x500");
        }
        return new ResponseVo("增加成功", null, "0x200");

    }

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id更新数据.
     * @param noticeUpdateByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminUpdateById(NoticeUpdateByIdBo noticeUpdateByIdBo) {

        Notice notice = noticeUpdateByIdBo.getNotice();
        Long numbersOfOpertion = noticeMapper.updateByIdNotice(notice);

        if (numbersOfOpertion.longValue() == 0L){
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");

    }

    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param noticePagingToGetDataBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo pagingToGetNoticeData(NoticePagingToGetDataBo noticePagingToGetDataBo) {
        List<Notice> list = noticeMapper.noticePagingToGetData(noticePagingToGetDataBo);
        NoticePagingToGetDataVo noticePagingToGetDataVo = new NoticePagingToGetDataVo();
        noticePagingToGetDataVo.setCount(list.size());
        noticePagingToGetDataVo.setList(list);

        return new ResponseVo<>(null,noticePagingToGetDataVo,"0x200");

    }

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      更改通知阅读状态.
     * @param noticeSelectByNoticeIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeSelectByNoticeId(NoticeSelectByNoticeIdBo noticeSelectByNoticeIdBo) {

        //设置阅读状态
        Long  numRead = noticeMapper.updateByIdToRead(noticeSelectByNoticeIdBo.getId());

        if (numRead == null || numRead == 0L) {
            return new ResponseVo("更改的通知不存在", null, "0x500");
        }

        return new ResponseVo("更改通知阅读状态成功", null, "0x200");
    }


}

