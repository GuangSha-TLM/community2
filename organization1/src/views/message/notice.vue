<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-15 16:24:11
 * @LastEditTime: 2024-05-16 15:48:15
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
                                <th scope="col">申请原因</th>
                                <th scope="col">操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(obj, index) in messageList" :key="obj.id">

                                <th scope="row"><el-badge style="margin: 0;" :is-dot="obj.read == 0"
                                        class="item"></el-badge>{{ index + 1 }}
                                </th>
                                <td>{{ obj.noticeName }}</td>
                                <td>{{ obj.createTime }}</td>
                                <td>{{ obj.context }}</td>
                                <td>
                                    <el-link v-if="obj.kinds == 0" type="success" @click="read(index)">标为已读</el-link>
                                    <el-link v-else type="success" @click="manage(index)">去处理</el-link>
                                </td>

                            </tr>
                        </tbody>
                    </table>

                </div>
            </section>

            <el-dialog :title="title" :visible.sync="dialogVisible" width="30%" @close="close">
                <span slot="footer" class="dialog-footer">
                    <el-input placeholder="请输入内容" v-model="communityReplyNoticeBo.content" clearable>
                    </el-input>
                    <div class="but">
                        <el-button @click="applyForCommunity(1)">拒绝</el-button>
                        <el-button type="primary" @click="applyForCommunity(0)">同意</el-button>
                    </div>

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