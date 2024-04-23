/*
 * @Author: tianleiyu 
 * @Date: 2024-04-22 15:36:51
 * @LastEditTime: 2024-04-23 13:41:11
 * @LastEditors: tianleiyu
 * @Description: 
 * 
 * @FilePath: /organization1/src/main.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import { createApp } from 'vue'
import App from './App.vue'
//引用路由
import router from './router'
//引用element-plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
//引用vue3-cookies
import VueCookies from 'vue3-cookies'

const app = createApp(App)
app.use(router)
app.use(ElementPlus)
app.use(VueCookies)
app.mount('#app')
