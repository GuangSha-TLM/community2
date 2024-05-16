<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-15 16:24:11
 * @LastEditTime: 2024-05-15 16:46:19
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/views/message/notice.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div>
        <div class="content">
            <section>
                <div class="container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">序号</th>
                                <th scope="col">简要</th>
                                <th scope="col">发起时间</th>
                                <th scope="col">操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(obj, index) in messageList" :key="obj.id">

                                <th scope="row"><el-badge style="margin: 0;" :is-dot="obj.read == 0"
                                        class="item"></el-badge>{{ index + 1 }}
                                </th>
                                <td>{{ obj.noticeContext }}</td>
                                <td>{{ obj.signInTime }}</td>
                                <td>

                                    <el-link type="success" @click="open(obj.communityId)">去处理</el-link>
                                </td>

                            </tr>
                        </tbody>
                    </table>

                </div>
            </section>

            <el-dialog title="签到" :visible.sync="dialogVisible" width="30%" @close="close">
                <span slot="footer" class="dialog-footer">
                    <el-input placeholder="请输入签到内容" v-model="communityReplyNoticeBo.context" clearable>
                    </el-input>
                    <el-button class="but" @click="sign()">签到</el-button>

                </span>
            </el-dialog>
        </div>

    </div>
</template>

<script setup lang="ts">
//引入vue3-cookies
import { useCookies } from "vue3-cookies";
//使用vue3-cookies
const { cookies } = useCookies();
import { ref, reactive, onMounted, toRefs, computed } from 'vue';

import { getSignIn } from '@/api/message'

const token = cookies.get('token');
const userSignInRequestBo = reactive({
    token: token,
    context: '',
    id: ''
})
const messageList = ref([])
const dialogVisible = ref(false)

onMounted(()=>{
    getSignInList()
})

const getSignInList=async ()=>{
    let result = await getSignIn(token)
    console.log(result);
    
}

const open = (id: any) => {
    dialogVisible.value = true
    userSignInRequestBo.id = id
}

const close = () => {
    dialogVisible.value = false
    userSignInRequestBo.context = ''
}


</script>
<style lang="less" scoped></style>