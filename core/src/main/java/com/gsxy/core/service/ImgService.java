package com.gsxy.core.service;


import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 图片业务接口
 */
public interface ImgService {

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      根据id查询数据.
     * @param imgSelectByIdBo
     * @return String.class
     */
    public ResponseVo imgSelectById(ImgSelectByIdBo imgSelectByIdBo);


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除Img数据.
     * @param imgDeleteByIdBo
     * @return String.class
     */
    public ResponseVo imgDeleteById(ImgDeleteByIdBo imgDeleteByIdBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      增加新数据.
     * @param imgAddByBo
     * @return String.class
     */
    public ResponseVo imgAdd(ImgAddByBo imgAddByBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id更新Img数据.
     * @param imgUpdateByIdBo
     * @return String.class
     */
    public ResponseVo imgUpdateById(ImgUpdateByIdBo imgUpdateByIdBo);


    /**
     * @author Oh...Yeah!!! 2023-10-27
     *    分页获取数据
     * @param imgPagingToGetDataBo
     * @return ResponseVo.class
     */
    public ResponseVo imgPagingToGetData(ImgPagingToGetDataBo imgPagingToGetDataBo);
}
