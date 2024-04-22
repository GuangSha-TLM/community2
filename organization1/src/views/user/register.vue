<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-22 16:55:02
 * @LastEditTime: 2024-04-22 16:57:22
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization/src/views/user/register.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
   <div class="hello">
            <Top/>


        <!-- Main content -->
        <section >
            <div class="container">
                <!-- Title -->
                <!-- Section title -->
                <div class="row mb-5 justify-content-center text-center">
                    <div class="col-lg-6">

                 <h2 class=" mt-4">登入您的账户</h2>
                        <div class="mt-2">
                            <p class="lead lh-180">Login Your Account</p>
                        </div>

                        <div>
                                <div class="form-group">
                                  <label for="exampleInputEmail1">Username</label>
                                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" v-model="userLoginBo.username">
                                  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                  <label for="exampleInputPassword1">Password</label>
                                  <input type="password" class="form-control" id="exampleInputPassword1" v-model="userLoginBo.password" @keyup.enter="submit()">
                                </div>
                                <div class="form-group form-check">

                                </div>
                                <button  class="btn btn-primary" style="width:100%" @click="submit()"   :disabled="switchbutton">Submit</button>

                        </div>
                    </div>
                </div>

            </div>
        </section>

        <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer>
    </div>
  </template>
  
  <script lang="ts" setup>
  import { IUser } from '@/model/userData';
import { reactive, ref, toRefs } from 'vue'
  const userLoginBo:IUser = reactive({
      username: '',
      password: ''
  })
  const switchbutton = ref(false)
  const submit = () => {
      switchbutton.value = true
      setTimeout(() => {
          switchbutton.value = false
      }, 2000)
  }
  </script>
  
  <style lang="less" scoped>
  
  </style>