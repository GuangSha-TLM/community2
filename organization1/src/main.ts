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
//引入中文的饿了么
import zhCn from 'element-plus/es/locale/lang/zh-cn'
//引入全局图标
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(router)
app.use(ElementPlus, {
    locale: zhCn
})

app.use(VueCookies)
app.mount('#app')
