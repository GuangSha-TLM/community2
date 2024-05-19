/*
 * @Author: tianleiyu 
 * @Date: 2024-05-08 15:49:49
 * @LastEditTime: 2024-05-11 08:58:30
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/api/activity.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import request from '@/utils/request'
import { activityPageData, activityPageResponseData, activitySearchData, activeUpdateBo, activityResponseData, imgUpDown, activityByIdResponseData, activeSelectByIdBo, addActivityResponseData, activeAdd, activeDeleteByIdBo, delectActivityResponseData } from '@/model/activityData'


//获取所属社团的活动列表
export const selectByToken = (token: String) => {
    // const params = { token }; 
    // return request.post(`/activity/selectByToken?token=${token}`)
    return request.post<any, activityResponseData>(`/activity/selectByToken?token=${token}`)

}

//删除所属社团的活动
export const delectActivity = (activeDeleteByIdBo: activeDeleteByIdBo) => {
    return request.post<any, delectActivityResponseData>('/activity/delete', activeDeleteByIdBo)
}
//修改社团活动
export const exitActivity = (active: activeUpdateBo, token: any) => {
    return request.post<any, any>('/activity/update', { active, token })
}

//富文本上传图片
export const uploadImg = (formData: FormData) => {
    return request.post<any, imgUpDown>('/img/imgUpDown', formData)
}
//上传活动
export const addActivity = (activeAdd: activeAdd) => {
    return request.post<any, addActivityResponseData>('/activity/add', activeAdd)
}

//获取活动列表
export const activitySelectById = (activeSelectByIdBo: activeSelectByIdBo) => {
    return request.post<any, activityByIdResponseData>('/activity/select', activeSelectByIdBo)
}
//通过title来获取数据
export const activitySearchBytitle = (activitySearchBytitle: activitySearchData) => {
    return request.post<any, activityResponseData>('/activity/likeToGet', activitySearchBytitle)
}
//分页查询
export const activityPageByBo = (activityPage: activityPageData) => {
    return request.post<any, activityPageResponseData>('/activity/pagingQuery', activityPage)
}