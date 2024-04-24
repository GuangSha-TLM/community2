/*
 * @Author: tianleiyu 
 * @Date: 2024-04-22 16:25:23
 * @LastEditTime: 2024-04-23 13:29:18
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/api/user.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import  request from '@/utils/request'
import { IUserLogin , IUserRegister} from '@/model/userData'
export const userLogin = (user:IUserLogin)=>{
    return request.post('/user/login',user)
}

export const userRegister = (user:IUserRegister)=>{
    return request.post('/user/register',user)
}