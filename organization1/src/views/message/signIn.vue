<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-15 16:24:11
 * @LastEditTime: 2024-05-16 15:47:27
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/views/message/signIn.vue
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

                                <th scope="row">{{ index + 1 }}
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

            <el-dialog title="签到" v-model="dialogVisible" width="30%" @close="close">
                <span slot="footer" class="dialog-footer">
                    <el-input placeholder="请输入签到内容" v-model="userSignInRequestBo.context" clearable>
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

import { signInList ,userSignInRequestBo,signInResponse,signInListResponse} from '@/model/messageData';
import { ElMessage } from 'element-plus';
import { getSignIn ,signIn} from '@/api/message'

const token = cookies.get('token');
const userSignInRequestBo = reactive<userSignInRequestBo>({
    token: token,
    context: '',
    id: -1
})
const messageList = ref<signInList>([])
const dialogVisible = ref(false)

onMounted(()=>{
    getSignInList()
})

const getSignInList=async ()=>{
    
    let result:signInListResponse = await getSignIn(token)
    
    if (result.code == '0x200') {
        messageList.value = result.data
        ElMessage({
            message: result.message,
            type: 'success',
        })
    }else{
        ElMessage({
            message: result.message,
            type: 'error',
        })

    }
    
}

const sign=async ()=>{
    let result:signInResponse = await signIn(userSignInRequestBo)
    if(result.code=='0x200'){
        dialogVisible.value = false
        userSignInRequestBo.context = ''
        getSignInList()
        ElMessage({
            message: result.message,
            type: 'success',
        })
    }else{
        ElMessage({
            message: result.message,
            type: 'error',
        })

    }
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
<style lang="less" scoped>

h1,
h2 {
    font-weight: normal;
}

ul {
    list-style-type: none;
    padding: 0;
}

li {
    display: inline-block;
    margin: 0 10px;
}

a {
    color: #67C23A;
}

.content {
    width: 100%;
    margin: 15px 0;
}

.item {
    width: 100%;
    display: flex;
    justify-content: space-between;
    margin: 20px 0;
}

.active {
    background-color: #42b983;
}

.but{
    margin: 10px 0;
}
</style>