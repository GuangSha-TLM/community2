package com.gsxy.core.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.mapper.ImgMapper;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.pojo.Img;
import com.gsxy.core.pojo.UserAdmin;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.SystemService;

import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import static com.gsxy.core.util.JwtUtil.*;
/**
 * @author zhuxinyu 2023-10-24
 * 系统接口实现类
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Value("${filePath}")
    private String path;
    @Value("${projecturl}")
    private String projecturl;
    @Autowired
    private UserAdminMapper userAdminMapper;
    @Autowired
    private ImgMapper imgMapper;

    /**
     * 鉴权
     * @param token
     * @return
     */
    @Override
    public ResponseVo auth(String token) {
        try {
            Map<String, Object> map = analysis(token);
//            String id = (String) analysis.get("id");
//            Long userId = Long.valueOf(id);
//            User user = userMapper.findById(userId);
            ThreadLocalUtil.mapThreadLocalOfJWT.get().put("userinfo",map);
//            System.out.println(ThreadLocalUtil.mapThreadLocalOfJWT);
            return new ResponseVo(null,map,"0x200");
        } catch (Exception e) {
            //e.printStackTrace();
            ThreadLocalUtil.mapThreadLocal.get().put("error","身份验证过期");
            ThreadLocalUtil.mapThreadLocal.get().put("code", "0x600");
            return new ResponseVo("身份登入验证过期",null,"0x203");
        }
    }

    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    图片下载
     * @param imgUrl
     * @return byte[]
     */
    @Override
    @ApiOperation("图片下载")
    @GetMapping(value ="/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@RequestParam("imgUrl") String imgUrl) throws IOException{

        File file = new File(path+"/"+imgUrl);

        FileInputStream inputStream = new FileInputStream(file);

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes, 0, inputStream.available());

        return bytes;
    }

    /**
     * @author zhuxinyu 2023-10-24
     * 非幂等性处理
     * @return
     */
    @Override
    public String getNonPower() {
        return "";
    }

    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    图片上传
     * @param token
     * @param file
     * @return String.class
     */
    @Override
    public String imgUpDown(@RequestParam("file") MultipartFile file, @RequestParam("token")String token) throws IOException{
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;

        //获取username
        Map<String, Object> analysis = analysis(token);
        String id = (String) analysis.get("id");

        File saveFilePath = new File(path+""+id+"/");
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if (!saveFilePath.exists()){
            saveFilePath.mkdirs();
        }

        String imgUrl = id+"/"+fileName;

        file.transferTo(new File(path+imgUrl));

 //       System.out.println("/"+id+"/"+fileName);

        Img img = new Img();
        img.setUrl("/"+imgUrl);
        Long byId = Long.valueOf(id);
        img.setCreateBy(byId);
        img.setCreateTime(new Date());
        img.setUpdateBy(byId);
        img.setUpdateTime(new Date());
        img.setDelFlag(0);
        img.setStatus(0);

        imgMapper.addImg(img);

 //       System.err.println("??");
        return JSONArray.toJSONString(new ResponseVo<>("success",projecturl+"/img/getimage?imgUrl="+id+"%2F"+fileName,"0x200"));
    }


    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    图片上传
     * @param token
     * @return String.class
     */
    @Override
    public ResponseVo isAdmin(String token,Integer leave){
        //身份鉴权
        ResponseVo auth = this.auth(token);
        if (auth.getData() == null) {
            return null;
        }

        String strUserId = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(strUserId);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        UserAdmin userAdmin = userAdminMapper.queryByUserId(userId);

        if (userAdmin == null || userAdmin.getRole() < leave){
            ThreadLocalUtil.mapThreadLocal.get().put("error","权限不足");
            ThreadLocalUtil.mapThreadLocal.get().put("code", "0x600");
            return new ResponseVo("权限不足",null,"0x404");
        }

        return null;
    }

}
