/*
 * @Author: tianleiyu 
 * @Date: 2024-04-22 15:36:51
 * @LastEditTime: 2024-05-08 15:37:57
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/router/index.ts
 * 可以输入预定的版权声明、个性签名、空行等
 */
import { createRouter, createWebHistory, createWebHashHistory, RouteRecordRaw } from 'vue-router'
// import Home from '../views/home/Home.vue'
import HomeView from './../views/HomeView.vue'
const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    redirect: '/activityManagement',
    component: HomeView,
    children: [
      {
        path: '/activityManagement',
        name: 'activityManagement',
        component: () => import(/* webpackChunkName: "about" */ '../views/activity/activityManagement.vue'),
        meta: {
          requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        }
      },
      {
        path: '/activity/:id',
        name: 'activity',
        component: () => import(/* webpackChunkName: "about" */ '../views/activity/activity.vue'),
        meta: {
          requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        }
      },
      {
        path: '/associationActivityManagement',
        name: 'associationActivityManagement',
        component: () => import(/* webpackChunkName: "about" */ '../views/activity/associationActivityManagement.vue'),
        meta: {
          requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        }
      },
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
  {
    path: '/HelloWorld',
    name: 'HelloWorld',
    component: () => import(/* webpackChunkName: "about" */ '@/components/HelloWorld.vue')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
