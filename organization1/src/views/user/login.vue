<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-22 16:54:57
 * @LastEditTime: 2024-04-23 14:28:19
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/views/user/login.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
  <div class="hello">
    <Top />


    <!-- Main content -->
    <section>
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
              <el-form ref="ruleFormRef" :model="userLoginBo" :rules="rules" label-width="auto" class="demo-ruleForm"
                status-icon>
                <el-form-item label="用户名" prop="username">
                  <el-input v-model="userLoginBo.username" />
                </el-form-item>
                <el-form-item label="密码" prop="password">
                  <el-input v-model="userLoginBo.password" @keyup.enter="login(ruleFormRef)" />
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" size="large" @click="login(ruleFormRef)" :disabled="switchbutton">
                    登录
                  </el-button>
                </el-form-item>
              </el-form>

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
import Top from '@/components/fream/LoginTop.vue';
import Foot from '@/components/fream/Foot.vue';
import { reactive, ref, toRefs } from 'vue'
//引入vue3-cookies
import { useCookies } from "vue3-cookies";
//使用vue3-cookies
const { cookies } = useCookies();
//引用element-Plus
import { ElMessage } from 'element-plus'
import type { FormInstance, FormRules } from 'element-plus'
//引用类型
import { IUser } from '@/model/userData';
//引用接口
import { userLogin } from '@/api/user'
import { el } from 'element-plus/es/locale';


const userLoginBo: IUser = reactive({
  username: '',
  password: ''
})

const switchbutton = ref(false)

const rules = reactive<FormRules<IUser>>({
  username: [
    { required: true, message: '请输入你的用户名', trigger: 'blur' },
    { min: 3, max: 20, message: '长度在3-20个字符', trigger: 'blur' },
  ],
  password: [
    { required: true, message: '请输入你的密码', trigger: 'blur' },
    { min: 3, max: 20, message: '长度在3-20个字符', trigger: 'blur' },
  ],
})
const ruleFormRef = ref<FormInstance>()

const login = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      switchbutton.value = true
      userLogin(userLoginBo)
        .then(res => {
          console.log(res)
          if (res.code === '0x200') {
            cookies.set('token', res.data.token)
            cookies.set('user', res.data.userAndUserAdminBo)
            userLoginBo.username = ''
            userLoginBo.password = ''
            console.log(res);
            
            ElMessage({
              message: res.message,
              type: 'success',
            })
          }else{
            console.log(res);
            
            userLoginBo.username = ''
            userLoginBo.password = ''
            ElMessage({
              message: res.message,
              type: 'error',
            })
          }
        })
        .catch(err => {
          console.log(err);
          
          ElMessage({
              message: err.message,
              type: 'error',
            })
        })


      switchbutton.value = false
    } else {
      console.log('error submit!', fields)
    }
  })
}


</script>

<style lang="less" scoped></style>