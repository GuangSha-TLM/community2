package com.gsxy.core.service;

import com.gsxy.core.pojo.vo.ResponseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
/**
 * 系统接口
 */
public interface SystemService {
    /**
     * is amdin
     * @param token
     * @param leave
     * @return
     */
    public ResponseVo isAdmin(String token,Integer leave);
    /**
     * @author zhuxinyu 2023-10-24
     * 鉴权
     * @param token
     * @return
     */
    public ResponseVo auth(String token);

    /**
     * @author zhuxinyu 2023-10-24
     * 幂等性处理
     * @return String.class
     */
    public String getNonPower();

    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    图片上传
     * @param token
     * @param file
     * @return String.class
     */
    public String imgUpDown(@RequestParam("file") MultipartFile file, @RequestParam("token")String token) throws IOException;

    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    图片下载
     * @param imgUrl
     * @return byte[]
     */
    @ApiOperation("图片下载")
    @GetMapping(value ="/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@RequestParam("imgUrl") String imgUrl) throws IOException;

}
