/*
 * @Author: tianleiyu 
 * @Date: 2024-04-22 15:36:51
 * @LastEditTime: 2024-04-23 13:23:21
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/router/index.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import { createRouter, createWebHistory, createWebHashHistory,RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    children: [
      // {
      //   path: '/home',
      //   name: 'home',
      //   component: () => import(/* webpackChunkName: "about" */ '../views/ActivityManagement.vue')
      // }
    ]
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  //用户登录界面
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/user/login.vue')
  },
  //用户注册界面
  {
    path: '/register',
    name: 'register',
    component: () => import(/* webpackChunkName: "about" */ '../views/user/register.vue')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
