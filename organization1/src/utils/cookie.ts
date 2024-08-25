//引入vue3-cookies
import { useCookies } from "vue3-cookies";
//使用vue3-cookies
const { cookies } = useCookies();
//封装token本地存储的方法
export const SET_TOKEN = (token: string) => {
    cookies.set("TOKEN", JSON.stringify(token))
}
export const GET_TOKEN = () => {
    return JSON.parse(cookies.get('TOKEN'))
}
export const REMOVE_TOKEN = () => {
    return cookies.remove('TOKEN')
}
//封装user的信息user
export const SET_USER = (user: any) => {
    cookies.set("USER", JSON.stringify(user))
}
export const GET_USER = () => {
    return JSON.parse(cookies.get('USER'))
}
export const REMOVE_USER = () => {
    return cookies.remove('USER')
}