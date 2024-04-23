package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ResponseService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@Api(value = "回复版块接口",tags = {"回复版块接口"})
@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      根据id查询数据.
     * @param responseSelectByIdBo
     * @return String.class
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询数据")
    public String responseSelect(@RequestBody ResponseSelectByIdBo responseSelectByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(responseService.responseSelectById(responseSelectByIdBo));
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除数据.
     * @param responseDeleteByIdBo
     * @return String.class
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除数据")
    public String responseDeleteById(@RequestBody ResponseDeleteByIdBo responseDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(responseService.responseDeleteById(responseDeleteByIdBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      增加新数据.
     * @param responseAddByBo
     * @return String.class
     */
    @PostMapping("/add")
    @ApiOperation("增加数据")
    public String responseAdd(@RequestBody ResponseAddByBo responseAddByBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(responseService.ResponseAdd(responseAddByBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      通过id更新数据.
     * @param responseUpdateByIdBo
     * @return String.class
     */
    @ApiOperation("通过id修改数据")
    @PostMapping("/update")
    public String responseUpdateById(@RequestBody ResponseUpdateByIdBo responseUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(responseService.responseUpdateById(responseUpdateByIdBo));
    }






}



