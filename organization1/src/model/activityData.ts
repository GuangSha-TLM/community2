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
//Top组件的搜索框参数返回的ts类型
export interface activityResponseData extends ResponseData {
    data: IActivityList
}
//Top组件搜索框参数传递的ts类型
export interface activitySearchData {
    token: string
    delFlag: number
    status: number
    title: string
}
//分页的参数的ts类型
export interface activityPageData {
    token: string
    delFlag: number
    status: number
    title?: string
    start: number
    total: number
    size: number

}
//分页返回的参数的ts类型
export interface PageData {
    count: number
    list: IActivityItem
}

export interface activityPageResponseData {
    code: string
    data: PageData
}


export interface imgUpDown extends ResponseData {
    data: string
}
export interface addActivityResponseData extends ResponseData {
    count: number
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
//修改接口传递参数
export interface activeUpdateBo {
    community?: number
    context?: string
    startTime?: string
    title: string
    id: number
}
//修改接口返回的参数ts类型
export interface exitActivityResponseData extends ResponseData {
    data: IActivityList[]
}
//删除接口传递参数的ts类型
export interface activeDeleteByIdBo {
    id: number
    token: string
}
//删除接口返回的参数ts类型
export interface delectActivityResponseData extends ResponseData {
    data: number
}
export interface activeToGetBo {
    context: string
    id: number
    title: string
    createTime: string
}


