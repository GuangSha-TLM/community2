/*
 * @Author: tianleiyu 
 * @Date: 2024-04-22 16:37:55
 * @LastEditTime: 2024-04-24 13:42:28
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/model/userData.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
export interface IUserLogin{
    username:string,
    password:string,
}
export interface IUserRegister{
    username:string,
    password:string,
    confirmPassword:string,
    name:string,
    college?:number,
    grade?:number,
    org:string,
    studentId:string,
    professional:string,
}