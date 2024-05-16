/*
 * @Author: tianleiyu 
 * @Date: 2024-05-15 16:44:04
 * @LastEditTime: 2024-05-15 17:30:40
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/api/message.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import  request from '@/utils/request'
import {signInListResponse,signInResponse,userSignInRequestBo} from '@/model/messageData'

export const getSignIn = (token:string)=>{
    // .post('/user/noticeUserSignIn',token,{"httpAgent"})
    return request<any,signInListResponse>({
        url:'/user/noticeUserSignIn',
        method:'post',
        data:token,
        headers:{
            'Content-Type':'application/json'
        }
    })
}

export const signIn =(userSignInRequestBo:userSignInRequestBo)=>{
    return request<any,signInResponse>({
        url:'/user/userSignIn',
        method:'post',
        data:userSignInRequestBo
    })
}