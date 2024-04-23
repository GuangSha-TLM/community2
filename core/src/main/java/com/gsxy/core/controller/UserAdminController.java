package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;


/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  管理员板块接口
 */
@CrossOrigin
@Api(value = "管理员版块接口",tags = {"管理员版块接口"})
@RestController
@RequestMapping("/userAdmin")
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      根据id查询数据.
     * @param userAdminSelectByIdBo
     * @return String.class
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询UserAdmin数据")
    public String userAdminSelect(@RequestBody UserAdminSelectByIdBo userAdminSelectByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }



        return JSONArray.toJSONString(userAdminService.userAdminSelectById(userAdminSelectByIdBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id删除UserAdmin数据.
     * @param userAdminDeleteByIdBo
     * @return String.class
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除UserAdmin数据")
    public String userAdminDeleteById(@RequestBody UserAdminDeleteByIdBo userAdminDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userAdminService.userAdminDeleteById(userAdminDeleteByIdBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      增加新数据.
     * @param userAdminAddByBo
     * @return String.class
     */
    @PostMapping("/add")
    @ApiOperation("增加UserAdmin数据")
    public String userAdminAdd(@RequestBody UserAdminAddByBo userAdminAddByBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(userAdminService.userAdminAdd(userAdminAddByBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id更新userAdmin数据.
     * @param userAdminUpdateByIdBo
     * @return String.class
     */
    @ApiOperation("通过id修改UserAdmin数据")
    @PostMapping("/update")
    public String userAdminUpdateById(@RequestBody UserAdminUpdateByIdBo userAdminUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(userAdminService.userAdminUpdateById(userAdminUpdateByIdBo));
    }


    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param userAdminPagingToGetDataBo
     * @return String.class
     */
    @ApiOperation("分页获取数据")
    @PostMapping("/pagingToGetData")
    public String userAdminPagingToGetData(@RequestBody UserAdminPagingToGetDataBo userAdminPagingToGetDataBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(userAdminService.pagingToGetUserAdminData(userAdminPagingToGetDataBo));
    }

//    /**
//     * @author hln 2023-10-31
//     *      管理员发起签到
//     * @param signInAdminBo
//     * @return
//     */
//    @PostMapping("/userAdminSignIn")
//    @ApiOperation("管理员发起签到")
//    public String userAdminSignIn(@RequestBody SignInAdminBo signInAdminBo){
//        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
//        if (map.get("error") != null) {
//            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
//        }
//
//        return JSONArray.toJSONString(userAdminService.userAdminSignIn(signInAdminBo));
//    }

    /**
     * @param signInAdminWebSocketBo
     * @param uuid1
     * @return
     * @author hln 2023-11-07
     * 管理员发起签到-WebSocket
     */
    @PostMapping("/adminsigninweb")
    @ApiOperation("管理员发起签到")
    public String userAdminSignInWebSocket(@RequestBody SignInAdminWebSocketBo signInAdminWebSocketBo, String uuid1){
        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userAdminService.adminSignInWeb(signInAdminWebSocketBo,uuid1));
    }

    /**
     * @param signInAdminWebSocketBo
     * @param uuid1
     * @return
     * @author hln 2023-11-07
     * 管理员发起签到-WebSocket
     */
    @PostMapping("/adminSignInWebSocketNew")
    @ApiOperation("管理员发起签到")
    public String userAdminSignInWebSocketNew(@RequestBody SignInAdminWebSocketBo signInAdminWebSocketBo, String uuid1){
        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userAdminService.adminSignInWebNew(signInAdminWebSocketBo,uuid1));
    }

//    /**
//     * @author hln 2023-11-01
//     *      管理员查看所有签到状态
//     * @return
//     */
//    @PostMapping("/userAdminFindAllSignInStatus")
//    @ApiOperation("管理员显示所有签到信息")
//    public String userAdminFindAllSignInStatus(){
//
//        return JSONArray.toJSONString(userAdminService.findAllSignInStatus());
//    }

    /**
     * @author hln 2023-11-22
     *      管理员查看实时签到信息
     * @param token
     * @return
     */
    @PostMapping("/findAllStatusInRealTime")
    @ApiOperation("管理员查看实时签到信息")
    public String adminCheckInStatusInRealTime(@RequestParam String token){
        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userAdminService.adminCheckInStatusInRealTime(token));
    }

    /**
     * @author hln 2023-12-02
     *      管理员查看实时签到信息
     * @param token
     * @return
     */
    @PostMapping("/findAllStatusInRealTimeNew")
    @ApiOperation("管理员查看实时签到信息")
    public String adminCheckInStatusInRealTimeNew(@RequestParam String token){
        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userAdminService.adminCheckInStatusInRealTimeNew(token));
    }

    /**
     * @author hln 2023-12-02
     *      管理员查看实时签到信息
     * @param id
     * @return
     */
    @PostMapping("/findAllStatusInRealTimeLast")
    @ApiOperation("管理员查看实时签到信息")
    public String adminCheckInStatusInRealTimeLast(@RequestParam Long id){

        return JSONArray.toJSONString(userAdminService.adminCheckInStatusInRealTimeLast(id));
    }

    /**
     * @author hln 2023-12-03
     *      管理员查看新发起的签到信息
     * @param token
     * @return
     */
    @PostMapping("/adminToGetSignInReal")
    @ApiOperation("管理员查看新发起的签到信息")
    public String adminToGetSignInReal(@RequestParam String token){
        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userAdminService.adminToGetSignInReal(token));
    }

}


