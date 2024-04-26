package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;
import java.util.concurrent.TimeUnit;


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

    @Autowired
    private RedisTemplate redisTemplate;

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

    /**
     * @author hln 2024-4-24
     *      管理员发起签到
     * @param adminSignInRequestBo
     * @return
     */
    @PostMapping("/adminSignInRedis")
    @ApiOperation("管理员发起签到")
    public String adminSignInRedis(@RequestBody AdminSignInRequestBo adminSignInRequestBo){

        try {
            //获取当前时间戳
            long currentTime = System.currentTimeMillis();

            //设置管理员发起签到的键名
            String adminSignInKey = "admin:sign_in" + "_" + adminSignInRequestBo.getCommunityId()  + "_" + adminSignInRequestBo.getContext();

            //设置标识
            String fixedKey = "fixed_key";
            redisTemplate.opsForValue().set(fixedKey,adminSignInKey);

            //将当前信息打入redis
            ZSetOperations<String,String> zSetOperations = redisTemplate.opsForZSet();
            zSetOperations.add(adminSignInKey,Long.toString(currentTime),currentTime);

            //设置签到缓存
            redisTemplate.expire(adminSignInKey,adminSignInRequestBo.getDuration(), TimeUnit.MINUTES);
            System.out.println(adminSignInKey);
            return JSONArray.toJSONString(new ResponseVo<>("签到已发起",null,"0x200"));
        } catch (Exception e){
            e.printStackTrace();
            return JSONArray.toJSONString(new ResponseVo<>("管理员发起签到失败",null,"0x500"));
        }
    }

}


