package com.gsxy.core.controller;


import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.CommunityService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhuxinyu 2023-10-24
 *      社团板块控制器
 */
@CrossOrigin
@Api(value = "社团板块接口" , tags = {"社团板块接口"})
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    /**
     * @author zhuxinyu 2023-10-24
     *      添加社团数据
     * @param communityAddByIdBo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加社团数据")
    public String Communityadd(@RequestBody CommunityAddBo communityAddByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(communityService.addCommunity(communityAddByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id删除社团数据
     * @param communityDeleteByIdBo
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除社团数据")
    public String CommunityDeleteById(@RequestBody CommunityDeleteByIdBo communityDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.deleteByIdCommunity(communityDeleteByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id查找社团数据
     * @param communitySelectByIdBo
     * @return
     */
    @PostMapping("/select")
    @ApiOperation("通过id查找社团数据")
    public String CommunitySelectById(@RequestBody CommunitySelectByIdBo communitySelectByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.selectByIdCommunity(communitySelectByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-30
     *      查询该社团的所有用户数据
     * @return
     */
    @PostMapping("/communityAndUser")
    @ApiOperation("查询该社团的所有用户数据")
    public String CommunityAndUser(@RequestParam String token){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.communityAndUser());
    }

    /**
     * @author  zhuxinyu 2023-11-02
     *      根据社团Id查询社团的所有活动
     * @param communityAndActiveBo
     * @return
     */
    @PostMapping("/communityAndActive")
    @ApiOperation("根据社团Id查询社团的所有活动信息")
    public String CommuntiyAndActive(@RequestBody CommunityAndActiveBo communityAndActiveBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.communityAndActive(communityAndActiveBo));
    }

    /**
     * @author  zhuxinyu 2023-11-02
     *      查询所有社团
     * @return
     */
    @PostMapping("/communityAllname")
    @ApiOperation("查询所有社团")
    public String CommnuityAllname(){
        return JSONArray.toJSONString(communityService.communityAllname());
    }
    /**
     * @author zhuxinyu 2023-10-24
     *      通过id修改社团数据
     * @param communityUpdateByIdBo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("通过id修改社团数据")
    public String CommunityUpdateById(@RequestBody CommunityUpdateByIdBo communityUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.updateByIdCommunity(communityUpdateByIdBo));
    }



    /**
     * @author zhuxinyu 2023-10-28
     *    分页获取数据
     * @param communityPagingToGetDataBo
     * @return
     */
    @ApiOperation("分页获取数据")
    @PostMapping("/communitypagingToGetData")
    public String commuityPagingToGetData(@RequestBody CommunityPagingToGetDataBo communityPagingToGetDataBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.communityPagingToGetData(communityPagingToGetDataBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-30
     *       用户向社长发送通知，加入社团
     * @param communitySendNoticeBo
     * @return String.class
     */
    @PostMapping("/send_notice")
    @ApiOperation("用户向社长发送通知，加入社团")
    public String userSendNoticeToAdmin(@RequestBody CommunitySendNoticeBo communitySendNoticeBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.userSendNoticeToAdmin(communitySendNoticeBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-30
     *       社长向用户发送回复通知
     * @param communityReplyNoticeBo
     * @return String.class
     */
    @PostMapping("/reply_notice")
    @ApiOperation("社长向用户发送回复通知")
    public String adminReplyNoticeToUser(@RequestBody CommunityReplyNoticeBo communityReplyNoticeBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.adminReplyNoticeToUser(communityReplyNoticeBo));
    }

    /**
     * @author hln 2023-11-13
     *      社长（管理员）向社团成员发起签到通知
     * @param sendNotificationBo
     * @return
     */
    @PostMapping("/sendNotification")
    @ApiOperation("社长向社团成员发起签到通知")
    public String adminSendNotification(@RequestBody SendNotificationBo sendNotificationBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(communityService.adminSendNotification(sendNotificationBo));
    }

    /**
     * @author hln 2023-11-13
     *      社长（管理员）向社团成员发起签到通知
     * @param sendNotificationBo
     * @return
     */
    @PostMapping("/sendNotificationNew")
    @ApiOperation("社长向社团成员发起签到通知")
    public String adminSendNotificationNew(@RequestBody SendNotificationBo sendNotificationBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(communityService.adminSendNotificationNew(sendNotificationBo));
    }


    /**
     * @author hln 2023-11-14
     *      社团成员接受签到通知
     * @param receiveNotificationsBo
     * @return
     */
    @PostMapping("/receiveNotifications")
    @ApiOperation("社团成员接受通知")
    public String userReceiveNotifications(@RequestBody ReceiveNotificationsBo receiveNotificationsBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(communityService.userReceiveNotifications(receiveNotificationsBo));
    }

    /**
     * @author hln 2023-11-14
     *      社团成员接受签到通知
     * @param receiveNotificationsBo
     * @return
     */
    @PostMapping("/receiveNotificationsNew")
    @ApiOperation("社团成员接受通知")
    public String userReceiveNotificationsNew(@RequestBody ReceiveNotificationsBo receiveNotificationsBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(communityService.userReceiveNotificationsNew(receiveNotificationsBo));
    }

    /**
     * @author hln 2023-12-03
     *      社团成员接受签到通知
     * @param receiveNotificationsBo
     * @return
     */
    @PostMapping("/receiveNotificationsLast")
    @ApiOperation("社团成员接受通知")
    public String userReceiveNotificationsLast(@RequestBody ReceiveNotificationsBo receiveNotificationsBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(communityService.userReceiveNotificationsNew(receiveNotificationsBo));
    }

}
