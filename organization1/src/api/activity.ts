/*
 * @Author: tianleiyu 
 * @Date: 2024-05-08 15:49:49
 * @LastEditTime: 2024-05-09 14:54:20
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/api/activity.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import  request from '@/utils/request'
import { activityResponseData , activeDeleteByIdBo ,delectActivityResponseData} from '@/model/activityData'
export const selectByToken = (token:String)=>{
    // const params = { token }; 
    // return request.post(`/activity/selectByToken?token=${token}`)
    return request.post<any,activityResponseData>(`/activity/selectByToken?token=${token}`)

}

export const delectActivity = (activeDeleteByIdBo:activeDeleteByIdBo)=>{
    return request.post<any,delectActivityResponseData>('/activity/delete',activeDeleteByIdBo)
}