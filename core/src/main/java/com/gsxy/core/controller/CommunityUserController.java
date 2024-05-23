package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.CommunityUserService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhuxinyu 2023-10-30
 *      社团用户板块控制器
 */
@CrossOrigin
@Api(value = "社团用户板块接口" , tags = {"社团用户板块接口"})
@RequestMapping("/communityUser")
@RestController
public class CommunityUserController {
    @Autowired
    private CommunityUserService communityUserService;

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户添加
     * @param communityUserAddBo
     * @return
     */
    @PostMapping("/communityUserAdd")
    @ApiOperation("社团用户添加数据")
    public String CommunityUserAdd(@RequestBody CommunityUserAddBo communityUserAddBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityUseradd(communityUserAddBo));
    }

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户删除
     * @param communityUserDeleteByIdBo
     * @return
     */
    @PostMapping("/communityUserDeleteById")
    @ApiOperation("社团用户删除数据")
    public String CommunityUserDeleteById(@RequestBody CommunityUserDeleteByIdBo communityUserDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityUserDeleteById(communityUserDeleteByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户查找数据
     * @param communityUserSelectByIdBo
     * @return
     */
    @PostMapping("/communityUserSelectById")
    @ApiOperation("社团用户查找数据")
    public String CommunityUserSelectById(@RequestBody CommunityUserSelectByIdBo communityUserSelectByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityUserSelectById(communityUserSelectByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户修改数据
     * @param communityUserUpdateByIdBo
     * @return
     */
    @PostMapping("/communityUserUpdateById")
    @ApiOperation("社团用户修改数据")
    public String CommunityUserUpdateById(@RequestBody CommunityUserUpdateByIdBo communityUserUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityUserUpdateById(communityUserUpdateByIdBo));
    }

    /**
     * @author zhuxinyu 2023-11-03
     *      删除社员
     * @param communityUserdeleteUserBo
     * @return
     */
    @PostMapping("/communityUserdeleteUser")
    @ApiOperation("删除社员")
    public String CommunityUserdeleteUser(@RequestBody CommunityUserdeleteUserBo communityUserdeleteUserBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityUserdeleteUser(communityUserdeleteUserBo));
    }
    /**
     * @author zhuxinyu 2023-10-30
     *      查询社团所有用户数据
     * @return
     */
    @PostMapping("/communityUserAndUser")
    @ApiOperation("查看社团内所有用户")
    public String CommunityUserAndUser(@RequestBody CommunityUserAndUserqueryBo communityUserAndUserqueryBo){
       return JSONArray.toJSONString(communityUserService.communityUserAndUser(communityUserAndUserqueryBo));
    }

    /**
     * @author zhuxinyu 2023-11-07
     *       用户发送通知
     * @param communityUserAndUserNoticeBo
     * @return String.class
     */
    @PostMapping("/communityToUserNotice")
    @ApiOperation("社长向用户发送拉取入团的通知")
    public String CommunityToUserNotice(@RequestBody CommunityUserAndUserNoticeBo communityUserAndUserNoticeBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityToUserNotice(communityUserAndUserNoticeBo));
    }
}
