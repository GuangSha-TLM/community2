package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ImgService;
import com.gsxy.core.service.NoticeWithUserService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通知和用户板块接口
 */
@CrossOrigin
@Api(value = "通知和用户版块接口",tags = {"通知和用户版块接口"})
@RestController
@RequestMapping("/noticeWithUser")
public class NoticeWithUserController {

    @Autowired
    private NoticeWithUserService noticeWithUserService;


    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      根据id查询数据.
     * @param noticeWithUserSelectByIdBo
     * @return String.class
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询数据")
    public String noticeWithUserSelect(@RequestBody NoticeWithUserSelectByIdBo noticeWithUserSelectByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(noticeWithUserService.noticeWithUserSelectById(noticeWithUserSelectByIdBo));
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除数据.
     * @param noticeWithUserDeleteByIdBo
     * @return String.class
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除数据")
    public String noticeWithUserDeleteById(@RequestBody NoticeWithUserDeleteByIdBo noticeWithUserDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(noticeWithUserService.noticeWithUserDeleteById(noticeWithUserDeleteByIdBo));
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      增加新数据.
     * @param noticeWithUserAddByBo
     * @return String.class
     */
    @PostMapping("/add")
    @ApiOperation("增加数据")
    public String noticeWithUserAdd(@RequestBody NoticeWithUserAddByBo noticeWithUserAddByBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(noticeWithUserService.noticeWithUserAdd(noticeWithUserAddByBo));
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      通过id更新数据.
     * @param noticeWithUserUpdateByIdBo
     * @return String.class
     */
    @ApiOperation("通过id修改数据")
    @PostMapping("/update")
    public String noticeWithUserUpdateById(@RequestBody NoticeWithUserUpdateByIdBo noticeWithUserUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(noticeWithUserService.noticeWithUserUpdateById(noticeWithUserUpdateByIdBo));
    }

    /**
     * @author Oh...Yeah!!! 2023-10-27
     *    分页获取数据
     * @param noticeWithUserPagingToGetDataBo
     * @return String.class
     */
    @ApiOperation("分页获取数据")
    @PostMapping("/pagingToGetData")
    public String noticeWithUserPagingToGetData(@RequestBody NoticeWithUserPagingToGetDataBo noticeWithUserPagingToGetDataBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(noticeWithUserService.noticeWithUserPagingToGetData(noticeWithUserPagingToGetDataBo));
    }

}
