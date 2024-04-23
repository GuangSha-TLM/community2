package com.gsxy.core.service.impl;

import com.gsxy.core.pojo.Img;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ImgPagingToGetDataVo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.mapper.ImgMapper;
import com.gsxy.core.service.ImgService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 图片业务接口实现类
 */
@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper imgMapper;


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      根据id查询数据.
     * @param imgSelectByIdBo
     * @return String.class
     */
    @Override
    public ResponseVo imgSelectById(ImgSelectByIdBo imgSelectByIdBo) {

        Img img = imgMapper.selectByIdImg(imgSelectByIdBo.getId());

        if (img == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功", img, "0x200");
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除Img数据.
     * @param imgDeleteByIdBo
     * @return String.class
     */
    @Override
    public ResponseVo imgDeleteById(ImgDeleteByIdBo imgDeleteByIdBo) {

        Long id = imgDeleteByIdBo.getId();
        Long numbersOfOpetion = imgMapper.deleteByIdImg(id);

        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");

    }

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      增加新数据.
     * @param imgAddByBo
     * @return String.class
     */
    @Override
    public ResponseVo imgAdd(ImgAddByBo imgAddByBo) {

        Long aLong = imgMapper.addImg(imgAddByBo.getImg());

        if (aLong.longValue() == 0){
            return new ResponseVo("增加失败",  null, "0x500");
        }
        return new ResponseVo("增加成功", null, "0x200");
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id更新Img数据.
     * @param imgUpdateByIdBo
     * @return String.class
     */
    @Override
    public ResponseVo imgUpdateById(ImgUpdateByIdBo imgUpdateByIdBo) {

        Img img = imgUpdateByIdBo.getImg();
        Long numbersOfOpertion = imgMapper.updateByIdImg(img);

        if (numbersOfOpertion.longValue() == 0L){
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");
    }


    /**
     * @author Oh...Yeah!!! 2023-10-27
     *    分页获取数据
     * @param imgPagingToGetDataBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo imgPagingToGetData(ImgPagingToGetDataBo imgPagingToGetDataBo) {

        List<Img> list = imgMapper.imgPagingToGetData(imgPagingToGetDataBo);
        ImgPagingToGetDataVo imgPagingToGetDataVo = new ImgPagingToGetDataVo();
        imgPagingToGetDataVo.setCount(list.size());
        imgPagingToGetDataVo.setList(list);

        return new ResponseVo<>(null,imgPagingToGetDataVo,"0x200");

    }


}
