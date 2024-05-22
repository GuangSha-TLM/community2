/*
 * @Author: tianleiyu 
 * @Date: 2024-04-22 16:25:23
 * @LastEditTime: 2024-04-23 13:29:18
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/api/user.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import request from '@/utils/request'
import { userResponseData, userData, IUserLogin, IUserRegister } from '@/model/userData'

export const userLogin = (user: IUserLogin) => {
    return request.post('/user/login', user)
}

export const userRegister = (user: IUserRegister) => {
    return request.post('/user/register', user)
}
//用户数据的获取
export const userCenterData = (user: userData) => {
    return request.post<any, userResponseData>('/user/select', user)
}
//用户修改信息接口
export const userChanceData = (user: any) => {
    return request.post<any, any>('/user/update', user)
}

