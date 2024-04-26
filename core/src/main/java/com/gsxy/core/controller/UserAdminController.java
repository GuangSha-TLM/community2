package com.gsxy.core.controller;

import java.util.*;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.CommunityUser;
import com.gsxy.core.pojo.SignInAdminR;
import com.gsxy.core.pojo.SignInUser;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.pojo.vo.SignInListVo;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;


/**
 * @author Oh...Yeah!!! 2023-10-28
 * 管理员板块接口
 */
@CrossOrigin
@Api(value = "管理员版块接口", tags = {"管理员版块接口"})
@RestController
@RequestMapping("/userAdmin")
public class UserAdminController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAdminMapper userAdminMapper;

    @Autowired
    private UserAdminService userAdminService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param userAdminSelectByIdBo
     * @return String.class
     * @author Oh… Yeah!!!, 2023-10-24
     * 根据id查询数据.
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询UserAdmin数据")
    public String userAdminSelect(@RequestBody UserAdminSelectByIdBo userAdminSelectByIdBo) {
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"), null, map.get("code")));
        }


        return JSONArray.toJSONString(userAdminService.userAdminSelectById(userAdminSelectByIdBo));
    }

    /**
     * @param userAdminDeleteByIdBo
     * @return String.class
     * @author Oh… Yeah!!!, 2023-10-24
     * 通过id删除UserAdmin数据.
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除UserAdmin数据")
    public String userAdminDeleteById(@RequestBody UserAdminDeleteByIdBo userAdminDeleteByIdBo) {
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"), null, map.get("code")));
        }

        return JSONArray.toJSONString(userAdminService.userAdminDeleteById(userAdminDeleteByIdBo));
    }

    /**
     * @param userAdminAddByBo
     * @return String.class
     * @author Oh… Yeah!!!, 2023-10-24
     * 增加新数据.
     */
    @PostMapping("/add")
    @ApiOperation("增加UserAdmin数据")
    public String userAdminAdd(@RequestBody UserAdminAddByBo userAdminAddByBo) {
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"), null, map.get("code")));
        }
        return JSONArray.toJSONString(userAdminService.userAdminAdd(userAdminAddByBo));
    }

    /**
     * @param userAdminUpdateByIdBo
     * @return String.class
     * @author Oh… Yeah!!!, 2023-10-24
     * 通过id更新userAdmin数据.
     */
    @ApiOperation("通过id修改UserAdmin数据")
    @PostMapping("/update")
    public String userAdminUpdateById(@RequestBody UserAdminUpdateByIdBo userAdminUpdateByIdBo) {
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"), null, map.get("code")));
        }
        return JSONArray.toJSONString(userAdminService.userAdminUpdateById(userAdminUpdateByIdBo));
    }


    /**
     * @param userAdminPagingToGetDataBo
     * @return String.class
     * @author Oh...Yeah!!! 2023-10-28
     * 分页获取数据
     */
    @ApiOperation("分页获取数据")
    @PostMapping("/pagingToGetData")
    public String userAdminPagingToGetData(@RequestBody UserAdminPagingToGetDataBo userAdminPagingToGetDataBo) {
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"), null, map.get("code")));
        }
        return JSONArray.toJSONString(userAdminService.pagingToGetUserAdminData(userAdminPagingToGetDataBo));
    }

    /**
     * @param token
     * @return
     * @author hln 2023-12-03
     * 管理员查看新发起的签到信息
     */
    @PostMapping("/adminToGetSignInReal")
    @ApiOperation("管理员查看新发起的签到信息")
    public String adminToGetSignInReal(@RequestParam String token) {
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"), null, map.get("code")));
        }

        return JSONArray.toJSONString(userAdminService.adminToGetSignInReal(token));
    }

    /**
     * @param adminSignInRequestBo
     * @return
     * @author hln 2024-4-24
     * 管理员发起签到
     */
    @PostMapping("/adminSignInRedis")
    @ApiOperation("管理员发起签到")
    public String adminSignInRedis(@RequestBody AdminSignInRequestBo adminSignInRequestBo) {

        //管理员的id <=> community_id
        Long userId = Long.valueOf((String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id"));

        try {
            //获取当前时间戳
            long currentTime = System.currentTimeMillis();
            Date date = new Date();

            //设置管理员发起签到的键名
            String adminSignInKey = "admin:signIn" + "_" + userId + "_" + adminSignInRequestBo.getContext() + "_" + date;

            //设置标识
            String fixedKey = "fixed_key" + userId;
            redisTemplate.opsForValue().set(fixedKey, adminSignInKey);

            //将当前信息打入redis
            ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
            zSetOperations.add(adminSignInKey, Long.toString(currentTime), currentTime);

            //设置签到缓存
            redisTemplate.expire(adminSignInKey, adminSignInRequestBo.getDuration(), TimeUnit.MINUTES);
            System.out.println(adminSignInKey);

            //将签到信息存入mysql
            SignInAdminR signInAdminR = new SignInAdminR();
            signInAdminR.setContext(adminSignInRequestBo.getContext());
            signInAdminR.setDuration(adminSignInRequestBo.getDuration());
            signInAdminR.setKey(adminSignInKey);
            signInAdminR.setSignUserId(userId);
            signInAdminR.setSignInTime(date);
            userAdminMapper.insertSignInAdminR(signInAdminR);
            AdminSignInNoticeBo adminSignInNoticeBo = new AdminSignInNoticeBo();
            adminSignInNoticeBo.setSignKey(adminSignInKey);
            adminSignInNoticeBo.setDuration(adminSignInRequestBo.getDuration());
            adminSignInNoticeBo.setCommunityId(userId);
            adminSignInNoticeBo.setNoticeContext("您有新的签到, 签到时长为 " + adminSignInNoticeBo.getDuration() + " 分钟");
            adminSignInNoticeBo.setSignInTime(date);
            userAdminMapper.insertNotice(adminSignInNoticeBo);

            return JSONArray.toJSONString(new ResponseVo<>("签到已发起", userId, "0x200"));
        } catch (Exception e) {
            e.printStackTrace();
            return JSONArray.toJSONString(new ResponseVo<>("管理员发起签到失败", null, "0x500"));
        }
    }

    /**
     * @param tokenBo
     * @return
     * @author hln 2024-4-26
     * 实时查看签到信息
     */
    @PostMapping("/querySignInUser")
    public String querySignInUser(@RequestBody TokenBo tokenBo) {

        Long userId = Long.valueOf((String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id"));
        SignInUser signInUser = new SignInUser();
        signInUser.setCommunityId(userId);
        List<SignInUser> list = userAdminMapper.queryByCommunityId(userId);
        ArrayList<String> list3 = new ArrayList<>();
        List<CommunityUser> list1 =  userAdminMapper.queryUser(userId);
        HashSet<Long> set = new HashSet<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (SignInUser signInUser1 : list) {
            set.add(signInUser1.getUserId());
        }

        for (CommunityUser inUser : list1) {
            if(set.add(inUser.getUserId())){
                User user = userMapper.selectByUserId(inUser.getUserId());
                if (user != null) {
                    list2.add(user.getName() + "未签到");
                }
            }
        }

        for (SignInUser inUser : list) {
            list3.add(inUser.getName() + "已签到");
        }
        return JSONArray.toJSONString(new ResponseVo<>("签到人员列表", new SignInListVo(list3,list2), "0x200"));
    }

    @PostMapping("/findAll")
    public String findAll(@RequestBody TokenBo tokenBo){
        return JSONArray.toJSONString(new ResponseVo<>("查询成功",userAdminMapper.queryAll(),"0x200"));
    }

    /**
     * @param tokenBo
     * @return
     * @author hln 2024-4-26
     * 实时查看签到信息（没签到的）
     */
    public String querySignInUserNo(@RequestBody TokenBo tokenBo) {

        Long userId = Long.valueOf((String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id"));
        SignInUser signInUser = new SignInUser();
        signInUser.setCommunityId(userId);
        List<SignInUser> list = userAdminMapper.queryByCommunityId(userId);
        List<CommunityUser> list1 =  userAdminMapper.queryUser(userId);
        HashSet<Long> set = new HashSet<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (SignInUser signInUser1 : list) {
            set.add(signInUser1.getUserId());
        }

        for (CommunityUser inUser : list1) {
            if(set.add(inUser.getUserId())){
                User user = userMapper.selectByUserId(inUser.getUserId());
                list2.add(user.getName() + "未签到");
            }
        }
        return JSONArray.toJSONString(new ResponseVo<>("未签到人员列表", list1, "0x200"));
    }

}


