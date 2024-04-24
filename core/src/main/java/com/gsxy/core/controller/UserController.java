package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.SignInWebSocket;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.pojo.vo.UserSelectToGetVo;
import com.gsxy.core.service.UserService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 2023-10-23
 *  用户控制器
 */
@CrossOrigin
@Api(value = "用户板块接口",tags = {"用户板块接口"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @author hln 2024-4-22
     *      用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public String userReg(@RequestBody User user){
        if(user == null){
            JSONArray.toJSONString(new ResponseVo("参数为null",null,"0x455"));
        }

        return JSONArray.toJSONString(userService.userReg(user));
    }

    /**
     * @author hln 2023-10-23
     *      用户登录
     * @param userLoginBo
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public String userLogin(@RequestBody UserLoginBo userLoginBo){
        if(userLoginBo == null){
            JSONArray.toJSONString(new ResponseVo("参数为null",null,"0x455"));
        }

        return JSONArray.toJSONString(userService.userLogin(userLoginBo));
    }

    /**
     * @author hln 2023-10-23
     *      通过id查找用户
     * @param userSelectByUserIdBo
     * @return
     */
    @PostMapping("/select")
    @ApiOperation("通过id查找用户")
    public String selectByUserId(@RequestBody UserSelectByUserIdBo userSelectByUserIdBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.selectByUserId(userSelectByUserIdBo));
    }

    /**
     * @author hln 2023-10-23
     *      通过id删除用户
     * @param userDeleteByIdBo
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除用户")
    public String deleteByUserId(@RequestBody UserDeleteByIdBo userDeleteByIdBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.deleteByUserId(userDeleteByIdBo));
    }

    /**
     * @author hln 2023-10-23
     *      通过id修改用户
     * @param userUpdateByUserIdBo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("通过id修改用户")
    public String updateByUserId(@RequestBody UserUpdateByUserIdBo userUpdateByUserIdBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.updateByUserId(userUpdateByUserIdBo));
    }

    /**
     * @author hln 2023-10-27
     *      分页查询
     * @param pagingToGetUserDataBo
     * @return
     */
    @PostMapping("/pagingQuery")
    @ApiOperation("分页查询")
    public String pagingToGetUserData(@RequestBody PagingToGetUserDataBo pagingToGetUserDataBo){

        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        if (pagingToGetUserDataBo == null){
            return JSONArray.toJSONString(new ResponseVo<>("参数为null",null,"0x455"));
        }

        return JSONArray.toJSONString(userService.pagingToGetUserData(pagingToGetUserDataBo));
    }

    /**
     * @author hln 2023-10-23
     *      查找所有信息
     * @return
     */
    @PostMapping("/userFindAll")
    @ApiOperation("查询所有用户信息")
    public String userFindAll(){
        return JSONArray.toJSONString(userService.userFindAll());
    }

//    /**
//     * @quthor hln 2023-10-30
//     *      用户签到
//     * @param userSignInBo
//     * @return
//     */
//    @PostMapping("/userSignIn")
//    @ApiOperation("用户签到")
//    public String userSignIn(@RequestBody UserSignInBo userSignInBo){
//
//        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
//        ThreadLocalUtil.mapThreadLocal.remove();
//        if(map.get("error") != null){
//            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
//        }
//
//        return JSONArray.toJSONString(userService.userSignIn(userSignInBo));
//    }

    /**
     * @quthor hln 2023-10-30
     *      用户签到-WebSocket
     * @param signInWebSocketBo
     * @return
     */
    @PostMapping("/usersignweb")
    @ApiOperation("用户签到")
    public String userSignInWebSocket(@RequestBody SignInWebSocketBo signInWebSocketBo){
        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.userSignInWebSocket(signInWebSocketBo));
    }

    /**
     * @quthor hln 2023-10-30
     *      用户签到-WebSocket
     * @param signInWebSocketBo
     * @return
     */
    @PostMapping("/userSignInWebSocketNew")
    @ApiOperation("用户签到")
    public String userSignInWebSocketNew(@RequestBody SignInWebSocketBo signInWebSocketBo){
        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.userSignInWebSocketNew(signInWebSocketBo));
    }

//    /**
//     * @quthor hln 2023-12-03
//     *      用户签到-WebSocket
//     * @param signInWebSocketBo
//     * @return
//     */
//    @PostMapping("/userSignInWebSocketLast")
//    @ApiOperation("用户签到")
//    public String userSignInWebSocketLast(@RequestBody SignInWebSocketBo signInWebSocketBo){
//        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
//        ThreadLocalUtil.mapThreadLocal.remove();
//        if(map.get("error") != null){
//            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
//        }
//
//        return JSONArray.toJSONString(userService.userSignInWebSocketNew(signInWebSocketBo));
//    }

    /**
     * @author hln 2023-11-03
     *      根据前端指定字段返回User信息
     * @param userSelectToGetBo
     * @return
     */
    @PostMapping("/selectToGetUser")
    @ApiOperation("根据前端指定字段返回User信息")
    public String selectToGetUser(@RequestBody UserSelectToGetBo userSelectToGetBo){
        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.selectToGetUser(userSelectToGetBo));
    }

    /**
     * @author hln 2023-11-03
     *      查询所有信息
     * @param findAllBo
     * @return
     */
    @PostMapping("/findAll")
    @ApiOperation("查询所有信息")
    public String findAllByPaging(@RequestBody FindAllBo findAllBo) {
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();

        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.findAll(findAllBo));
    }

}

