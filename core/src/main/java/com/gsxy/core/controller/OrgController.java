package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.OrgService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhuxinyu 2023-10-23
 *      班级板块控制器
 */
@CrossOrigin
@Api(value = "班级版块接口", tags = {"班级板块接口"})
@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    /**
     * @author zhuxinyu 2023-10-23
     *      添加Org
     * @param orgAddByIdbo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加Org数据")
    public String orgAdd(@RequestBody OrgAddBo orgAddByIdbo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(orgService.orgAdd(orgAddByIdbo));
    }

    /**
     * @author zhuxinyu 2023-10-23
     *      通过id删除Org
     * @param orgDeleteByIdBo
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除Org数据")
    public String orgDeleteById(@RequestBody OrgDeleteByIdBo orgDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(orgService.orgDeleteById(orgDeleteByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-23
     *      通过id查询Org
     * @param orgSelectByIdBo
     * @return
     */
    @PostMapping("/select")
    @ApiOperation("根据Id查询Org数据")
    public String orgSelectById(@RequestBody OrgSelectByIdBo orgSelectByIdBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(orgService.orgSelectById(orgSelectByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-25
     *      查询所有信息
     * @return
     */
    @PostMapping("/selectall")
    @ApiOperation("查询所有数据")
    public String orgselectall(){
        return JSONArray.toJSONString(orgService.orgSelectAll());
    }

    /**
     * @author zhuxinyu 2023-10-23
     *      通过id修改Org
     * @param orgUpdateByIdBo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("通过id修改Org数据")
    public String orgUpdateById(@RequestBody OrgUpdateByIdBo orgUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(orgService.orgUpdateById(orgUpdateByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-25
     *      通过Org查找user数据
     * @return
     */
    @PostMapping("/orgselectuser")
    @ApiOperation("通过Org查找user数据")
    public String orgSelectByUser(){
        return JSONArray.toJSONString(orgService.orgSelectByUser());
    }

    /**
     * @author zhuxinyu 2023-10-30
     *      分页查询获取数据
     * @param orgPagingToGetDataBo
     * @return
     */
    @PostMapping("/pagingToGetData")
    @ApiOperation("分页获取数据")
    public String orgPagingToGetData(@RequestBody OrgPagingToGetDataBo orgPagingToGetDataBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(orgService.orgPagingToGetData(orgPagingToGetDataBo));
    }
}
