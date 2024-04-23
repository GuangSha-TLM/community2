package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.ResponseMapper;
import com.gsxy.core.pojo.NoticeWithUser;
import com.gsxy.core.pojo.Response;
import com.gsxy.core.pojo.bo.ResponseAddByBo;
import com.gsxy.core.pojo.bo.ResponseDeleteByIdBo;
import com.gsxy.core.pojo.bo.ResponseSelectByIdBo;
import com.gsxy.core.pojo.bo.ResponseUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseMapper responseMapper;

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      根据id查询数据.
     * @param responseSelectByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo responseSelectById(ResponseSelectByIdBo responseSelectByIdBo) {

        Response response = responseMapper.selectByIdResponse(responseSelectByIdBo.getId());

        if (response == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功", response, "0x200");
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除数据.
     * @param responseDeleteByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo responseDeleteById(ResponseDeleteByIdBo responseDeleteByIdBo) {

        Long numbersOfOpetion = responseMapper.deleteByIdResponse(responseDeleteByIdBo.getId());

        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      增加新数据.
     * @param responseAddByBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo ResponseAdd(ResponseAddByBo responseAddByBo) {
        Long aLong = responseMapper.addResponse(responseAddByBo.getResponse());

        if (aLong.longValue() == 0){
            return new ResponseVo("增加失败",  null, "0x500");
        }
        return new ResponseVo("增加成功", null, "0x200");
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      通过id更新数据.
     * @param responseUpdateByIdBo
     * @return String.class
     */
    @Override
    public ResponseVo responseUpdateById(ResponseUpdateByIdBo responseUpdateByIdBo) {

        Long numbersOfOpertion = responseMapper.updateByIdResponse(responseUpdateByIdBo.getResponse());

        if (numbersOfOpertion.longValue() == 0L){
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");

    }

}




