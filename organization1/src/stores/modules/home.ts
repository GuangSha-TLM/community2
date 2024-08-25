import { defineStore } from "pinia"
//引入vue3-cookies封装的方法
import { GET_TOKEN, GET_USER } from '@/utils/cookie'
export const homeInfoStore = defineStore('home', {
    // defineStore('userInfo',{})  userInfo就是这个仓库的名称name
    state: () => {
        return {
            userData: JSON.parse(GET_USER())

        }
    },

})

