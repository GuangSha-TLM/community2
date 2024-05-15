/*
 * @Author: tianleiyu 
 * @Date: 2024-05-08 16:19:35
 * @LastEditTime: 2024-05-11 09:10:06
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/model/activityData.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */

//务必写注释！！！！！！！！！！！！

export interface ResponseData {
    code: string
    message: string
}
//activityManagement的接口ts类型
export type IActivityList = IActivityItem[]

export interface IActivityItem {
    community: number
    communityList?: string
    context: string
    createBy: number
    createTime?: string
    id: number
    startTime: string
    status: number
    title: string
}
export interface activityResponseData extends ResponseData {
    data: IActivityList[]
}

export interface delectActivityResponseData extends ResponseData {
    data: number
}

export interface imgUpDown extends ResponseData {
    data: string
}
export interface addActivityResponseData extends ResponseData {

}
export interface activeAdd {
    title: string
    context: string
    token: string
}

export interface activityByIdResponseData extends ResponseData {
    data: activeToGetBoAndCommunityInActiveBo
}

export interface activeToGetBoAndCommunityInActiveBo {
    activeToGetBo: activeToGetBo
    communityInActiveBo: communityInActiveBo
}

export interface communityInActiveBo {
    createBy: number
    id: number
    name: string
    username: string
}

export interface activeSelectByIdBo {
    id: string | string[]
    token: string
}

export interface activeAddBo {
    community: number
    context: string
    startTime: string
    title: string
}

export interface activeUpdateBo {
    community: number
    context: string
    startTime: string
    title: string
    id: number
}

export interface activeDeleteByIdBo {
    id: number
    token: string
}

export interface activeToGetBo {
    context: string
    id: number
    title: string
    createTime: string
}


