package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Active;
import com.gsxy.core.pojo.bo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActiveMapper {

    /**
     * @auhtor hln 2023-10-24
     *      添加活动功能
     * @param active
     * @return
     */
    Long addActive(Active active);

    /**
     * @author hln 2023-10-25
     *      查询所有活动功能
     * @return
     */
    List<Active> findAll();

    /**
     * @author hln 2023-10-26
     *      根据id删除活动
     * @param id
     * @return
     */
    Long deleteActiveById(Long id);

    /**
     * @author hln 2023-10-26
     *      根据id查询活动
     * @param activeSelectByIdBo
     * @return
     */
    Long selectActiveById(ActiveSelectByIdBo activeSelectByIdBo);

    /**
     * @author hln 2023-10-26
     *      根据id修改活动
     * @param active
     * @return
     */
    Long updateActiveById(Active active);

    /**
     * @author hln 2023-10-27
     *      根据title进行模糊查询
     * @param activeLikeToGetByTitleBo
     * @return
     */
    List<Active> activeLikeToGetByTitle(ActiveLikeToGetByTitleBo activeLikeToGetByTitleBo);

    /**
     * @author hln 2023-10-27
     *      获取所有活动的数据
     * @param pagingToGetActiveDataBo
     * @return
     */
    List<Active> pagingToGetActiveData(PagingToGetActiveDataBo pagingToGetActiveDataBo);

    /**
     * @author hln 2023-10-27
     *      获取活动总数
     * @param pagingToGetActiveDataBo
     * @return
     */
    Long pagingToGetCountOfActiveData(PagingToGetActiveDataBo pagingToGetActiveDataBo);

    /**
     * @author hln 2023-10-29
     *      获取前端指定活动相关字段实体类
     * @param communityInActiveBo
     * @return
     */
    CommunityInActiveBo selectCommunityByCreateBy(CommunityInActiveBo communityInActiveBo);

    /**
     * @author hln 2023-10-29
     *      获取前端指定活动相关字段实体类
     * @param activeToGetBo
     * @return
     */
    ActiveToGetBo selectActiveToGetById(ActiveToGetBo activeToGetBo);

    /**
     * @author hln 2023-10-29
     *      获取前端指定社团相关字段实体类
     * @param activeSelectByIdBo
     * @return
     */
    Long selectActiveToGetCreateByById(ActiveSelectByIdBo activeSelectByIdBo);

    /**
     * @author hln 2023-11-10
     *      查询该社团所有活动
     * @param adminId
     * @return
     */
    List<Active> findAllByCommunityId(Long adminId);

    /**
     * @author hln 2023-11-10
     *      获取对应的社团ID
     * @param userId
     * @return
     */
    Long selectToGetCommunityId(Long userId);

    /**
     * @author hln 2023-11-10
     *      根据userId查询数据
     * @param userId
     * @return
     */
    Long selectToGetByUserId(Long userId);
}
