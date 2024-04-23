package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ImgService;
import com.gsxy.core.service.SystemService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  图片板块接口
 */
@CrossOrigin
@Api(value = "图片版块接口",tags = {"图片版块接口"})
@RestController
@RequestMapping("/img")
public class ImgController {

    @Autowired
    private ImgService imgService;
    @Autowired
    private SystemService systemService;

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      根据id查询数据.
     *
     * @param imgSelectByIdBo
     * @return String.class
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询img数据")
    public String imgSelect(@RequestBody ImgSelectByIdBo imgSelectByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(imgService.imgSelectById(imgSelectByIdBo));
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除Img数据.
     * @param imgDeleteByIdBo
     * @return String.class
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除img数据")
    public String imgDeleteById(@RequestBody ImgDeleteByIdBo imgDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(imgService.imgDeleteById(imgDeleteByIdBo));
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      增加新数据.
     * @param imgAddByBo
     * @return String.class
     */
    @PostMapping("/add")
    @ApiOperation("增加img数据")
    public String imgAdd(@RequestBody ImgAddByBo imgAddByBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(imgService.imgAdd(imgAddByBo));
    }



    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id更新Img数据.
     * @param imgUpdateByIdBo
     * @return String.class
     */
    @ApiOperation("通过id修改Img数据")
    @PostMapping("/update")
    public String imgUpdateById(@RequestBody ImgUpdateByIdBo imgUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(imgService.imgUpdateById(imgUpdateByIdBo));
    }


    /**
     * @author Oh...Yeah!!! 2023-10-27
     *    分页获取数据
     * @param imgPagingToGetDataBo
     * @return String.class
     */
    @ApiOperation("分页获取数据")
    @PostMapping("/pagingToGetData")
    public String imgPagingToGetData(@RequestBody ImgPagingToGetDataBo imgPagingToGetDataBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(imgService.imgPagingToGetData(imgPagingToGetDataBo));
    }

    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    上传图片
     * @param token
     * @param file
     * @return String.class
     */
    @ApiOperation("上传图片")
    @RequestMapping(value = "imgUpDown",method = {RequestMethod.POST})
    public String imgUpDown(@RequestParam("file") MultipartFile file, @RequestParam("token")String token) throws IOException {
        return systemService.imgUpDown(file,token);
    }


    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    图片下载
     * @param imgUrl
     * @return byte[]
     */
    @ApiOperation("图片下载")
    @GetMapping(value ="/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@RequestParam("imgUrl") String imgUrl) throws IOException {
        return systemService.getPhoto(imgUrl);
    }






}
