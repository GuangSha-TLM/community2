<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-08 15:32:45
 * @LastEditTime: 2024-05-08 15:36:08
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/views/activity/activityManagement.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="ID" width="400" />
        <el-table-column prop="title" label="活动内容" width="400" />
        <el-table-column prop="createTime" label="活动创建时间" width="400" />
    </el-table>
</template>
<script lang="ts" setup>
import { selectByToken } from '@/api/activity'
import { onMounted, ref } from 'vue';
import { useCookies } from 'vue3-cookies'
import { activityResponseData } from '@/model/activityData'
const { cookies } = useCookies()
let tableData = ref<any>([]);
let token: string = cookies.get('token')

//请求活动数据的接口
const getActivityData = async () => {
    const result: activityResponseData = await selectByToken(token)
    if (result.code = "0x200") {
        tableData.value = result.data;
        console.log(tableData.value);

    }


}
onMounted(() => {
    getActivityData();
})
</script>