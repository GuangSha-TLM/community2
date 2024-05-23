<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-08 15:32:45
 * @LastEditTime: 2024-05-23 08:33:05
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/views/activity/activityManagement.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <el-table :data="tableData" style="width: 100%" @row-click="handleClick">
        <el-table-column type="index" label="ID" width="200" />
        <el-table-column prop="title" label="活动标题" width="200" />
        <el-table-column prop="createTime" label="活动创建时间" width="200" />
        <el-table-column>
            <div class="item_icon"><el-icon>
                    <ArrowRight />
                </el-icon></div>
        </el-table-column>
    </el-table>
    <!-- 分页查询 -->
    <div class="example-pagination-block">
        <div class="example-demonstration"></div>
        <el-pagination @current-change="Pagenation" v-model:current-page="pageData.start"
            v-model:page-size="pageData.size" layout="prev, pager, next,total" :total="pageData.total" />
    </div>

</template>
<script lang="ts" setup>
import { activityPageByBo } from '@/api/activity'
import { onMounted, ref, onUnmounted, reactive } from 'vue';
import { useCookies } from 'vue3-cookies'
import { activityPageResponseData, activityPageData } from '@/model/activityData'
import { Delete, ArrowRight, InfoFilled } from '@element-plus/icons-vue'

import { useRouter } from 'vue-router'
const router = useRouter()


import bus from '@/utils/mitt'
const { cookies } = useCookies()
let tableData = ref<{}>();
let token: string = cookies.get('token')

//分页的数据
let pageData = reactive<activityPageData>({
    delFlag: 0,
    size: 5,
    start: 1,
    status: 0,
    title: "",
    token: '',
    total: 0
});

function handleClick(row, column, event) {
    console.log(row, column, event);
    console.log(row.id);

    router.push({
        name: 'activity',
        params: {
            id: row.id,
        }
    })

}
//分页的接口
async function Pagenation() {
    pageData.token = token;
    const result: activityPageResponseData = await activityPageByBo(pageData)
    if (result.code === '0x200') {
        // console.log('page', result);
        pageData.total = result.data.count;
        tableData.value = result.data.list;
        // console.log('total', result.data.list);

    }
}
onMounted(() => {
    Pagenation();
    //接收Top组件传递过来的查询后的数组
    const changeTableData = bus.on('InputData', (data: any) => {
        tableData.value = data
    })

    onUnmounted(() => {
        changeTableData
    })
})

</script>
<style scoped>
.el-pagination {
    --el-pagination-font-size: 16px;
}

.example-pagination-block+.example-pagination-block {
    margin-top: 10px;
}

.example-pagination-block .example-demonstration {
    margin-bottom: 16px;
}
</style>