/*
 * @Author: tianleiyu 
 * @Date: 2024-05-08 16:19:35
 * @LastEditTime: 2024-05-09 15:21:30
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/model/activityData.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */

import { id } from "element-plus/es/locale"

export interface ResponseData {
    code: string
    message: string
}

export interface activityResponseData extends ResponseData {
    data: IActivityItem[]
}

export interface delectActivityResponseData extends ResponseData {
    data: number
}

export interface activeAddBo{
    community:number
    context:string
    startTime:string
    title:string
}

export interface activeUpdateBo{
    community:number
    context:string
    startTime:string
    title:string
    id:number
}

export interface activeDeleteByIdBo{
    id:number
    token:string
}

export type IActivityList= IActivityItem[]

export interface IActivityItem {
    community :number
    communityList?:string
    context:string
    createBy:number
    createTime?:string
    id:number
    startTime:string
    status:number
    title:string
}