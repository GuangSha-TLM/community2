export interface ResponseData {
    code: string
    message: string
}

export interface signInListResponse extends ResponseData {
    data: signInList
}

export interface signInResponse extends ResponseData {
    
}

export interface userSignInRequestBo{
    token: string,
    context: string,
    id: number,
}

export type signInList = signInItem[]

export interface signInItem {
    communityId: number
    id: number
    noticeContext: string
    signInTime: string
    signKey: string

}