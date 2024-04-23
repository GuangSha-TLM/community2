package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.ResponseAddByBo;
import com.gsxy.core.pojo.bo.ResponseDeleteByIdBo;
import com.gsxy.core.pojo.bo.ResponseSelectByIdBo;
import com.gsxy.core.pojo.bo.ResponseUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;

public interface ResponseService {

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      根据id查询数据.
     * @param responseSelectByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo responseSelectById(ResponseSelectByIdBo responseSelectByIdBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除数据.
     * @param responseDeleteByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo responseDeleteById(ResponseDeleteByIdBo responseDeleteByIdBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      增加新数据.
     * @param responseAddByBo
     * @return ResponseVo.class
     */
    public ResponseVo ResponseAdd(ResponseAddByBo responseAddByBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      通过id更新数据.
     * @param responseUpdateByIdBo
     * @return String.class
     */
    public ResponseVo responseUpdateById(ResponseUpdateByIdBo responseUpdateByIdBo);
}
