<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-22 16:54:57
 * @LastEditTime: 2024-05-11 08:11:47
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/views/user/login.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
  <div class="hello">
    <Top />


    <!-- Main content -->
    <div>
      <div class="contence-out">
        <!-- Title -->
        <!-- Section title -->
        <el-card class="contence" body-style="padding:0">
          <div class="header-btn">
            <div class="header-btn-left"><el-button class="left-btn">点我做百年</el-button></div>
            <div class="header-btn-right"><el-button class="right-btn">点我右边</el-button></div>
          </div>
          <div class="header-login">

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
        </el-card>

      </div>
    </div>

    <footer class="position-relative" id="footer-main">
      <Foot></Foot>
    </footer>
  </div>
</template>

<script lang="ts" setup>
import Top from '@/components/fream/Top.vue';
import Foot from '@/components/fream/Foot.vue';
import { reactive, ref, toRefs } from 'vue'

//引入vue3-cookies封装的方法
import { SET_TOKEN, SET_USER } from '@/utils/cookie'
//引用element-Plus
import { ElNotification } from 'element-plus'
import type { FormInstance, FormRules } from 'element-plus'
//引用类型
import { IUserLogin, loginResponseData } from '@/model/userData';
//引用接口
import { userLogin } from '@/api/user'
import { useRouter } from 'vue-router';
//引入时间的变化提醒信息
import { getTime } from "@/utils/time";

let router = useRouter();
const userLoginBo: IUserLogin = reactive({
  username: '',
  password: ''
})

const switchbutton = ref(false)

const rules = reactive<FormRules<IUserLogin>>({
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
  await formEl.validate(async (valid, fields) => {
    if (valid) {
      switchbutton.value = true
      const result: loginResponseData = await userLogin(userLoginBo)

      if (result.code === '0x200') {
        SET_TOKEN(result.data.token)
        SET_USER(JSON.stringify(result.data.userAndUserAdminBo))
        userLoginBo.username = ''
        userLoginBo.password = ''

        ElNotification({
          message: result.message,
          title: `Hi,${getTime()}好`,
          type: 'success',
        })
        router.push('/')
      } else {
        userLoginBo.username = ''
        userLoginBo.password = ''
        ElNotification({
          message: result.message,
          title: `Hi,${getTime()}好`,
          type: 'error',
        })
      }

      switchbutton.value = false
    } else {
      console.log('error submit!', fields)
    }
  })
}


</script>

<style lang="less" scoped>
.contence-out {
  display: flex;
  align-items: center;
  justify-content: center;

  .contence {
    width: 555px;



    .header-btn {
      display: flex;
      justify-content: space-between;
      height: 50px;


      /*设置透明度，0为完全透明，1为不透明*/
      // opacity: 0.75;
      .left-btn {
        border: none;
        width: 100%;
        height: 100%;
      }

      .right-btn {
        border: none;
        width: 100%;
        height: 100%;
      }

      .header-btn-left {
        width: 100%;
        background-color: pink;
      }

      .header-btn-right {
        width: 100%;
        background-color: skyblue;
      }
    }

    .header-login {
      padding: var(--el-card-padding);
    }

    .mt-4,
    .mt-2 {
      text-align: center;
    }

    .mt-4 {
      margin-top: 0 !important;
    }
  }
}
</style>