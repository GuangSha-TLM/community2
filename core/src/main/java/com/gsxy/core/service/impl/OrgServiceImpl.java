package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.OrgMapper;
import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.Org;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.OrgPagingToGetDataVo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.OrgService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhuxinyu 2023-10-23
 *      班级业务实体类接口
 */
@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrgMapper orgMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * @author zhuxinyu 2023-10-23
     *     添加Org
     * @param orgAddByIdBo
     * @return
     */
    @Override
    public ResponseVo orgAdd(OrgAddBo orgAddByIdBo){
        String orgIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long orgId = Long.valueOf(orgIdOfStr);
        orgAddByIdBo.getOrg().setCreateBy(orgId);
        orgAddByIdBo.getOrg().setCreateTime(new Date());
        Long  aLong = orgMapper.addOrg(orgAddByIdBo.getOrg());
        if (aLong.longValue() == 0L) {
            return new ResponseVo("增加失败",  null, "0x500");
        }

        return new ResponseVo("增加成功", orgId, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-23
     *      通过id删除Org
     * @param orgDeleteByIdBo
     * @return
     */

    @Override
    public ResponseVo orgDeleteById(OrgDeleteByIdBo orgDeleteByIdBo){
        String orgIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long orgId = Long.valueOf(orgIdOfStr);
        if(orgId == null || orgId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }
        Long id = orgDeleteByIdBo.getId();
        Long aLong = orgMapper.deleteByIdOrg(id);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",id, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-23
     *      通过id查找Org
     * @param orgSelectByIdBo
     * @return
     */
    @Override
    public ResponseVo orgSelectById(OrgSelectByIdBo orgSelectByIdBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);
        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Org org1 = orgMapper.selectByIdOrg(orgSelectByIdBo.getId());
        if (org1 == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功",org1,"0x200");
    }

    /**
     * @author zhuxinyu 2023-10-25
     *      查找所有信息
     * @return
     */
    @Override
    public ResponseVo orgSelectAll() {
        List <OrgAndUserBo> list = orgMapper.selectAll();
        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     * @author zhuxinyu 2023-10-25
     * 通过Org修改id数据
     * @return
     */
    @Override
    public ResponseVo orgSelectByUser() {
        List <OrgSelectByUserBo> list = orgMapper.selectOrgByUser();
        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     *@author zhuxinyu 2023-10-23
     *      通过id修改Org
     * @param orgUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo orgUpdateById(OrgUpdateByIdBo orgUpdateByIdBo){
        String orgIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long orgId = Long.valueOf(orgIdOfStr);
        orgUpdateByIdBo.getOrg().setUpdateBy(orgId);
        orgUpdateByIdBo.getOrg().setUpdateTime(new Date());
        Long aLong = orgMapper.updateByIdOrg(orgUpdateByIdBo.getOrg());

        if (aLong == null || aLong.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }
        return new ResponseVo("更新成功", orgId , "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-30
     *      分页获取数据
     * @param orgPagingToGetDataBo
     * @return
     */
    @Override
    public ResponseVo orgPagingToGetData(OrgPagingToGetDataBo orgPagingToGetDataBo) {
        List<Org> list = orgMapper.orgPagingToGetData(orgPagingToGetDataBo);
        OrgPagingToGetDataVo orgPagingToGetDataVo = new OrgPagingToGetDataVo();
        orgPagingToGetDataVo.setCount(list.size());
        orgPagingToGetDataVo.setList(list);
        return  new ResponseVo<>(null,orgPagingToGetDataVo,"0x200");
    }

}
