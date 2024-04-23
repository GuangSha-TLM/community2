package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Org;
import com.gsxy.core.pojo.bo.OrgAndUserBo;
import com.gsxy.core.pojo.bo.OrgPagingToGetDataBo;
import com.gsxy.core.pojo.bo.OrgSelectByUserBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhuxinyu 2023-10-23
 *      班级持久层
 */
@Mapper
public interface OrgMapper {
    /**
     * @author zhuxinyu 2023-10-23
     *      添加Org
     * @param org
     * @return
     */
    public Long addOrg(Org org);

    /**
     *  @author zhuxinyu 2023-10-23
     *      删除Org
     * @param id
     * @return
     */
    public Long deleteByIdOrg(Long id);

    /**
     * @author zhuxinyu 2023-10-23
     *      查找Org
     * @param id
     * @return
     */
    public Org selectByIdOrg(Long id);

    /**
     * @@author zhuxinyu 2023-10-25
     *      查询所有用户信息
     * @return
     */
    public List<OrgAndUserBo> selectAll();

    /**
     * @author zhuxinyu 2023-10-23
     *      更新Org
     * @param org
     * @return
     */
    public Long updateByIdOrg(Org org);

    /**
     * @author zhuxinyu 2023-10-25
     *      根据Org查找User
     * @return
     */
    public List<OrgSelectByUserBo> selectOrgByUser();

    /**
     * @author zhuxinyu 2023-10-30
     *      分页获取查询数据
     * @param orgPagingToGetDataBo
     * @return
     */
    public List<Org> orgPagingToGetData(OrgPagingToGetDataBo orgPagingToGetDataBo);

}
