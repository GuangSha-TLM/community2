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
import { activitySelectById, selectByToken } from '@/api/activity'
import { onMounted, ref, onUnmounted } from 'vue';
import { useCookies } from 'vue3-cookies'
import { activityResponseData, } from '@/model/activityData'
import bus from '@/utils/mitt'
const { cookies } = useCookies()
let tableData = ref([]);
let token: string = cookies.get('token')

//请求活动数据的接口
const getActivityData = async () => {
    const result: activityResponseData = await selectByToken(token)
    if (result.code = "0x200") {
        tableData.value = result.data;
        // console.log('123', tableData);
    }
}

onMounted(() => {

    //接收Top组件传递过来的查询后的数组
    const changeTableData = bus.on('InputData', (data) => {
        tableData.value = data
        console.log('sdsdd', tableData.value);

    })
    onUnmounted(() => {
        changeTableData
    })
    getActivityData();
})

</script>