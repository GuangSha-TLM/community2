package com.gsxy.core.mapper;

import com.gsxy.core.pojo.CommunityUser;
import com.gsxy.core.pojo.vo.CommunityUserAndUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityUserMapper {
    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户添加
     * @param communityUser
     * @return
     */
    public Long communityUseAdd(CommunityUser communityUser);

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户删除
     * @param id
     * @return
     */
    public Long communityUserDeleteById(Long id);

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户查询
     * @param id
     * @return
     */
    public CommunityUser communityUserSelectById(Long id);

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户修改
     * @param communityUser
     * @return
     */
    public Long communityUserUpdateById(CommunityUser communityUser);

    /**
     * @return
     * @author zhuxinyu 2023-10-30
     * 查询社团所有用户
     */
    public List<CommunityUserAndUserVO> communityUserAndUser();

    /**
     * @author zhuxinyu 2023-11-03
     *      删除社员
     * @param communityId
     * @param userId
     * @return
     */
    public void communityUserdeleteUser(@Param("communityId") Long communityId, @Param("userId") Long userId);
    /**
     * @author Oh… Yeah!!!, 2023-10-30
     *       查看该用户是否已经在这个社团
     * @param id
     * @param communityId
     * @return
     */
    public CommunityUser communityUserSelectByUserId(Long id, Long communityId);

}
