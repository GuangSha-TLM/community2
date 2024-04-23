package com.gsxy.core.mapper;

import com.gsxy.core.pojo.NoticeWithUser;
import com.gsxy.core.pojo.Response;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResponseMapper {

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      根据id查询数据.
     * @param id
     * @return Response.class
     */
    public Response selectByIdResponse(Long id);

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除数据.
     * @param id
     * @return Long.class
     */
    public Long deleteByIdResponse(Long id);

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      增加新数据.
     * @param response
     * @return Long.class
     */
    public Long addResponse(Response response);

    /**
     * @author Oh… Yeah!!!, 2023-10-28
     *      通过id更新数据.
     * @param response
     * @return Long.class
     */
    public Long updateByIdResponse(Response response);


}



