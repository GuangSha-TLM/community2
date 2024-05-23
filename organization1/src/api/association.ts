
import request from '@/utils/request'
// import {  } from '@/model/association'


//用户数据的获取
export const AssociationByToken = (user: any) => {
    return request.post<any, any>('/user/select', user)
}
//用户删除信息接口
export const delectAssociation = (user: any) => {
    return request.post<any, any>('/user/update', user)
}

