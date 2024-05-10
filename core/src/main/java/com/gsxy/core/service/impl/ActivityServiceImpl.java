package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.ActiveMapper;
import com.gsxy.core.pojo.Active;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.PagingToGetActiveDataVO;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ActiveService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActiveService {

    @Autowired
    private ActiveMapper activeMapper;

    /**
     * @param activeAddBo
     * @return
     * @auhtor hln 2023-10-24
     * 添加活动功能
     */
    @Override
    public ResponseVo addActive(ActiveAddBo activeAddBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);//用户id

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Active active = new Active();
        Long createBy = activeMapper.selectToGetByUserId(userId);
        Long communityId = activeMapper.selectToGetCommunityId(userId);

        active.setContext(activeAddBo.getContext());
        active.setCommunityList(activeAddBo.getContext());
        active.setCreateBy(createBy);
        active.setCommunity(communityId);
        active.setTitle(activeAddBo.getTitle());
        active.setCreateTime(new Date());
        active.setStartTime(new Date());

        //在数据库表中插入数据
        Long aLong = activeMapper.addActive(active);

        if (aLong == null){
            return new ResponseVo("增加失败",null,"0x500");
        }

        return new ResponseVo("增加成功",null,"0x200");
    }

    /**
     * @author hln 2023-10-25
     *      查询所有活动功能
     * @return
     */
    @Override
    public ResponseVo findAll() {

        List<Active> list = activeMapper.findAll();

        if (list == null){
            return new ResponseVo("查询失败",null,"0x500");
        }

        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     * @author hln 2023-10-26
     *      根据id删除活动
     * @param activeDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo deleteActive(ActiveDeleteByIdBo activeDeleteByIdBo) {

        Long aLong = activeMapper.deleteActiveById(activeDeleteByIdBo.getId());

        if(aLong == null || aLong == 0L){
            return new ResponseVo("删除失败",null,"0x500");
        }

        return new ResponseVo("删除成功",aLong,"0x200");
    }

    /**
     * @author hln 2023-10-26
     *      根据id查询活动
     * @param activeSelectByIdBo
     * @return
     */
    @Override
    public ResponseVo selectActive(ActiveSelectByIdBo activeSelectByIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long aLong = activeMapper.selectActiveById(activeSelectByIdBo);

        if(aLong == null || aLong == 0L){
            return new ResponseVo("查询失败",null,"0x500");
        }

        Long createBY = activeMapper.selectActiveToGetCreateByById(activeSelectByIdBo);
        CommunityInActiveBo communityInActiveBo = new CommunityInActiveBo();
        communityInActiveBo.setCreateBy(createBY);

        CommunityInActiveBo communityInActiveBo1 = activeMapper.selectCommunityByCreateBy(communityInActiveBo);

        ActiveToGetBo activeToGetBo = new ActiveToGetBo();
        activeToGetBo.setId(aLong);
        ActiveToGetBo activeToGetBo1 = activeMapper.selectActiveToGetById(activeToGetBo);

        ActiveSelectToGetBo activeSelectToGetBo = new ActiveSelectToGetBo();
        activeSelectToGetBo.setActiveToGetBo(activeToGetBo1);
        activeSelectToGetBo.setCommunityInActiveBo(communityInActiveBo1);

        return new ResponseVo("查询成功",activeSelectToGetBo,"0x200");
    }

    /**
     * @author hln 2023-10-26
     *      根据id修改活动
     * @param activeUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo updateActive(ActiveUpdateByIdBo activeUpdateByIdBo) {

        activeUpdateByIdBo.getActive().setUpdateBy(activeUpdateByIdBo.getActive().getId());
        activeUpdateByIdBo.getActive().setUpdateTime(new Date());
        Active active = activeUpdateByIdBo.getActive();
        Long aLong = activeMapper.updateActiveById(active);

        if (aLong == null || aLong == 0L) {
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",active.getId(),"0x200");
    }

    /**
     * @author hln 2023-10-27
     *      根据title进行模糊查询
     * @param activeLikeToGetByTitleBo
     * @return
     */
    @Override
    public ResponseVo activeLikeToGetByTitle(ActiveLikeToGetByTitleBo activeLikeToGetByTitleBo) {

        //调用数据库查询出所有符合条件的数据
        List<Active> list = activeMapper.activeLikeToGetByTitle(activeLikeToGetByTitleBo);

        //判断集合是否为空，若为空则查询失败
        if(list == null){
            return new ResponseVo("查询失败",null,"0x500");
        }

        //若list不为空，返回结果
        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     * @author hln 2023-10-27
     *      分页查询
     * @param pagingToGetActiveDataBo
     * @return
     */
    @Override
    public ResponseVo pagingToGetActiveData(PagingToGetActiveDataBo pagingToGetActiveDataBo) {

        //获取所有活动的数据
        List<Active> activeList = activeMapper.pagingToGetActiveData(pagingToGetActiveDataBo);

        //获取活动总数
        Long count = activeMapper.pagingToGetCountOfActiveData(pagingToGetActiveDataBo);

        PagingToGetActiveDataVO pagingToGetActiveDataVO = new PagingToGetActiveDataVO();
        pagingToGetActiveDataVO.setCount(count);
        pagingToGetActiveDataVO.setList(activeList);

        return new ResponseVo(null,pagingToGetActiveDataVO,"0x200");
    }

    /**
     * @auhtor hln 2023-11-09
     *      根据前端传入的token返回数据 - 查询该社团的所有活动
     *      注：是该社团内的所有成员都可以进行的操作（仅限于该社团的成员）
     * @return
     */
    @Override
    public ResponseVo selectByToken() {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long communityId = activeMapper.selectToGetCommunityId(userId);

        List<Active> activeList = activeMapper.findAllByCommunityId(communityId);

        if(activeList == null){
            return new ResponseVo("查询无数据",null,"0x500");
        }

        return new ResponseVo("查询成功",activeList,"0x200");
    }

}
