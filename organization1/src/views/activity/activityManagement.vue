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
    <!-- 修改窗口 -->
    <el-dialog v-model="dialogVisible" title="请修改活动内容" width="500">
        <el-form :model="active" label-width="auto" style="max-width: 600px">
            <el-form-item label="活动内容">
                <el-input v-model="active.title" />
            </el-form-item>
        </el-form> <template #footer>
            <div class="dialog-footer">
                <el-button @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click.native="getExitData" @click="dialogVisible = false">
                    确认
                </el-button>
            </div>
        </template>
    </el-dialog>
    <!-- 添加接口 -->
    <el-dialog v-model="dialogVisible" title="请添加活动内容" width="500">
        <el-form :model="addActive" label-width="auto" style="max-width: 600px">
            <el-form-item label="活动标题">
                <el-input v-model="addActive.title" />
            </el-form-item>
            <el-form-item label="活动内容">
                <el-input v-model="addActive.context" />
            </el-form-item>
        </el-form> <template #footer>
            <div class="dialog-footer">
                <el-button @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click.native="getAddData" @click="dialogVisible = false">
                    确认
                </el-button>
            </div>
        </template>
    </el-dialog>
</template>
<script lang="ts" setup>
import { activityAddData, activitySelectById, selectByToken, exitActivity, delectActivity, activityPageByBo } from '@/api/activity'
import { onMounted, ref, onUnmounted, reactive } from 'vue';
import { useCookies } from 'vue3-cookies'
import { ResponseData, activityPageResponseData, activityResponseData, delectActivityResponseData, activityPageData, exitActivityResponseData } from '@/model/activityData'
import { ElNotification } from 'element-plus'
import { Delete, ArrowRight, InfoFilled } from '@element-plus/icons-vue'

import { useRouter } from 'vue-router'
const router = useRouter()


import bus from '@/utils/mitt'
const { cookies } = useCookies()
let tableData = ref<{}>();
let token: string = cookies.get('token')
//添加功能的数据
let addActive = reactive({
    context: '',
    title: '',
    token: token
})
//修改的数据
let active = reactive({
    // context: "",
    id: 0,
    title: "",
    // community: 0,
    // starTime: "",
});
//删除的数据
let deleteId: number;
//修改窗口开启和关闭
const dialogVisible = ref(false)
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
//请求活动数据的接口
const getActivityData = async () => {
    const result: activityResponseData = await selectByToken(token)
    if (result.code = "0x200") {
        tableData.value = result.data;
        // console.log('123', result);
    }
}
//修改的按钮
function handleEdit(index: number, scope: any) {
    dialogVisible.value = true;
    active.id = scope.id;
    active.title = "";

}
function handleClick(row, column, event){
    // console.log(row, column, event);
    // console.log(row.id);
    
    router.push({
        name: 'activity',
        params: {
            id: row.id,
        }
    })
    
}
//修改的接口
async function getExitData() {
    const result: exitActivityResponseData = await exitActivity(active, token)
    if (result.code === "0x200") {
        ElNotification({
            title: 'Success',
            message: '修改成功',
            type: 'success',
        })
        getActivityData();
        // console.log(result);
    } else {
        ElNotification({
            title: 'Error',
            message: '修改失败',
            type: 'error',
        })
    }

}
//删除的按钮
function handleDelete(index: number, scope: any) {
    deleteId = scope.id
    // console.log(deleteId);
}
//删除接口
async function ActivityDelete() {
    const result: delectActivityResponseData = await delectActivity({ id: deleteId, token: token })
    if (result.code === '0x200') {
        ElNotification({
            title: 'Success',
            message: '删除成功',
            type: 'success',
        })
        getActivityData();
    } else {
        ElNotification({
            title: 'Error',
            message: '删除失败',
            type: 'error',
        })
    }
}


//添加按钮
function handleAdd() {
    dialogVisible.value = true;
    addActive.title = "";
    addActive.context = "";
}

//添加活动的接口
async function getAddData() {
    const result: ResponseData = await activityAddData(addActive)
    if (result.code === '0x200') {
        ElNotification({
            title: 'Success',
            message: '添加成功',
            type: 'success',
        })
        getActivityData();
    } else {
        ElNotification({
            title: 'Error',
            message: '添加失败',
            type: 'error',
        })
    }
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
    getActivityData();
    Pagenation();
    //接收Top组件传递过来的查询后的数组
    const changeTableData = bus.on('InputData', (data: any) => {
        tableData.value = data
        // console.log('sdsdd', data);

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