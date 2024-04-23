package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.NoticeService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Oh...Yeah!!! 2023-10-28
 *  通知板块接口
 */
@CrossOrigin
@Api(value = "通知版块接口",tags = {"通知版块接口"})
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      用户查看通知.
     * @param
     * @return String.class
     */
    @PostMapping("/select")
    @ApiOperation("用户查看通知")
    public String noticeSelectById(@RequestParam String token){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(noticeService.noticeSelectById());
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      更改通知阅读状态.
     * @param
     * @return String.class
     */
    @PostMapping("/select_id")
    @ApiOperation("更改通知阅读状态")
    public String noticeSelectByNoticeId(@RequestBody NoticeSelectByNoticeIdBo noticeSelectByNoticeIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(noticeService.noticeSelectByNoticeId(noticeSelectByNoticeIdBo));
    }






    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id删除数据.
     * @param noticeDeleteByIdBo
     * @return String.class
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除数据.")
    public String noticeDeleteById(@RequestBody NoticeDeleteByIdBo noticeDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(noticeService.noticeDeleteById(noticeDeleteByIdBo));
    }



    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      发布通知鉴权
     * @param noticeAddByBo
     * @return String.class
     */
    @PostMapping("/add")
    @ApiOperation("增加数据")
    public String noticeAdd(@RequestBody NoticeAddByBo noticeAddByBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(noticeService.noticeAdd(noticeAddByBo));
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id更新数据.
     * @param noticeUpdateByIdBo
     * @return String.class
     */
    @ApiOperation("通过id修改数据")
    @PostMapping("/update")
    public String noticeUpdateById(@RequestBody NoticeUpdateByIdBo noticeUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(noticeService.userAdminUpdateById(noticeUpdateByIdBo));
    }


    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param noticePagingToGetDataBo
     * @return String.class
     */
    @ApiOperation("分页获取数据")
    @PostMapping("/pagingToGetData")
    public String noticePagingToGetData(@RequestBody NoticePagingToGetDataBo noticePagingToGetDataBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(noticeService.pagingToGetNoticeData(noticePagingToGetDataBo));
    }


}
