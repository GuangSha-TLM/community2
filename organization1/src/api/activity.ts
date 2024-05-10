/*
 * @Author: tianleiyu 
 * @Date: 2024-05-08 15:49:49
 * @LastEditTime: 2024-05-10 17:17:27
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/api/activity.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import  request from '@/utils/request'
import { activityResponseData ,imgUpDown, addActivityResponseData,activeAdd,activeDeleteByIdBo ,delectActivityResponseData} from '@/model/activityData'


//获取所属社团的活动列表
export const selectByToken = (token:String)=>{
    // const params = { token }; 
    // return request.post(`/activity/selectByToken?token=${token}`)
    return request.post<any,activityResponseData>(`/activity/selectByToken?token=${token}`)

}

//删除所属社团的活动
export const delectActivity = (activeDeleteByIdBo:activeDeleteByIdBo)=>{
    return request.post<any,delectActivityResponseData>('/activity/delete',activeDeleteByIdBo)
}

//富文本上传图片
export const uploadImg = (formData:FormData)=>{
    return request.post<any,imgUpDown>('/img/imgUpDown',formData)
}
//上传活动
export const addActivity = (activeAdd:activeAdd)=>{
    return request.post<any,addActivityResponseData>('/activity/add',activeAdd)
}