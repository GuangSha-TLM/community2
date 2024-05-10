package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.SignInUser;
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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @author hln 2024-4-22
     *      用户注册
     * @param user
     * @return
     */
    @PostMapping("/userReg")
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

    /**
     * @author hln 2024-4-26
     *      用户签到
     * @param userSignInRequestBo
     * @return
     */
    @PostMapping("/userSignIn")
    @ApiOperation("用户签到")
    public String userSignIn(@RequestBody UserSignInRequestBo userSignInRequestBo){

        //获取当前用户id
        Long userId = Long.valueOf((String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id"));
        Long communityId = userSignInRequestBo.getId();

        try {
            //获取固定键名，用于查询管理员发起签到而设置的标识
            String fixedKey = "fixed_key" + communityId;
            String adminSignInKey = (String) redisTemplate.opsForValue().get(fixedKey);

            //判断键是否在redis存在
            if (adminSignInKey != null) {
                String adminContext = adminSignInKey.split("_")[2]; // 从键名中解析管理员发起签到时设置的 context
                Long communityIdR = Long.valueOf(adminSignInKey.split("_")[1]);
                String date = adminSignInKey.split("_")[3];
                DateFormat dateTimeFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                Date dateTime = null;

                try {
                    dateTime = dateTimeFormat.parse(date); // 将字符串转换为日期对象
                    System.out.println("日期时间对象：" + dateTime);
                } catch (ParseException e) {
                    System.out.println("日期时间格式不正确：" + e.getMessage());
                }

                User user = userMapper.selectByUserId(userId);
                String userSignInKey = adminSignInKey;//用于核对管理员签到的key
                SignInUser signInUser = new SignInUser();
                signInUser.setSignInTime(dateTime);
                signInUser.setName(user.getName());
                signInUser.setCommunityId(communityIdR);
                signInUser.setUserId(userId);
                signInUser.setRedisKey(adminSignInKey);

                Boolean exists = redisTemplate.hasKey(userSignInKey);
                if ((exists && exists != null) && adminContext.equals(userSignInRequestBo.getContext())) {
                    redisTemplate.opsForValue().set(userSignInKey,"signed",1, TimeUnit.DAYS);
                    userMapper.insertNoticeSignIn(signInUser);
                    return JSONArray.toJSONString(new ResponseVo<>("签到成功",null,"0x200"));
                } else {
                    return JSONArray.toJSONString(new ResponseVo<>("签到失败：您已经签过到了",null,"0x404"));
                }
            }
            else {
                return JSONArray.toJSONString(new ResponseVo<>("签到失败：当前没有签到活动",null,"0x404"));
            }
        } catch (Exception e){
            e.printStackTrace();
            return JSONArray.toJSONString(new ResponseVo<>("获取签到信息失败",null,"0x500"));
        }
    }

    /**
     * @author hln 2024-4-26
     *      获取签到通知信息
     * @param token
     * @return
     */
    @PostMapping("/noticeUserSignIn")
    @ApiOperation("获取签到通知信息")
    public String noticeUserSignIn(@RequestBody TokenBo token){
        return JSONArray.toJSONString(userService.NoticeUserSignIn());
    }

}

