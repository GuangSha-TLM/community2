package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;

public interface ActiveService {

    /**
     * @param activityAddBo
     * @param context
     * @return
     * @auhtor hln 2023-10-24
     * 添加活动功能
     */
    ResponseVo addActive(ActiveAddBo activityAddBo, String context);

    /**
     * @author hln 2023-10-25
     *      查询所有活动功能
     * @return
     */
    ResponseVo findAll();

    /**
     * @author hln 2023-10-26
     *      根据id删除活动
     * @param activeDeleteByIdBo
     * @return
     */
    ResponseVo deleteActive(ActiveDeleteByIdBo activeDeleteByIdBo);

    /**
     * @author hln 2023-10-26
     *      根据id查询活动
     * @param activeSelectByIdBo
     * @return
     */
    ResponseVo selectActive(ActiveSelectByIdBo activeSelectByIdBo);

    /**
     * @author hln 2023-10-26
     *      根据id修改活动
     * @param activeUpdateByIdBo
     * @return
     */
    ResponseVo updateActive(ActiveUpdateByIdBo activeUpdateByIdBo);

    /**
     * @author hln 2023-10-27
     *      根据title进行模糊查询
     * @param activeLikeToGetByTitleBo
     * @return
     */
    ResponseVo activeLikeToGetByTitle(ActiveLikeToGetByTitleBo activeLikeToGetByTitleBo);

    /**
     * @author hln 2023-10-27
     *      根据title进行分页查询
     * @param pagingToGetActiveDataBo
     * @return
     */
    ResponseVo pagingToGetActiveData(PagingToGetActiveDataBo pagingToGetActiveDataBo);

    /**
     * @auhtor hln 2023-11-09
     *      根据前端传入的token返回数据 - 查询该社团的所有活动
     * @return
     */
    ResponseVo selectByToken();
}
