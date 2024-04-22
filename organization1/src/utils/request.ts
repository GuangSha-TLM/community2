/*
 * @Author: tianleiyu 
 * @Date: 2024-04-22 16:21:40
 * @LastEditTime: 2024-04-22 16:39:05
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization/src/utils/request.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import axios from 'axios'
const request = axios.create({
    baseURL:'/api',
    timeout:20000,
})

request.interceptors.request.use(
    (config)=>{
        return config

    }
)

request.interceptors.response.use(
    (response)=>{
        if (response.data.code === 200) {
            return response.data.data
        }else{

            return Promise.reject(response.data)
        }
    },
    (error)=>{
        return Promise.reject(error)
    }
)

export default request;