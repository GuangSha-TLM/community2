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
        <el-table-column prop="id" label="ID" width="350" />
        <el-table-column prop="title" label="活动内容" width="350" />
        <el-table-column prop="createTime" label="活动创建时间" width="350" />
        <el-table-column label="Operations" width="240">
            <template #default="scope">
                <el-button size="default" @click="handleEdit(scope.$index, scope.row)">
                    修改
                </el-button>
                <el-popconfirm @confirm="ActivityDelete" title="你确定要删除吗?">
                    <template #reference>
                        <el-button size="default" type="danger" @click="handleDelete(scope.$index, scope.row)">
                            删除
                        </el-button>
                    </template>
                </el-popconfirm>

            </template>
        </el-table-column>
    </el-table>
    <!-- 修改窗口 -->
    <el-dialog v-model="dialogVisible" title="请修改内容" width="500">
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
</template>
<script lang="ts" setup>
import { activitySelectById, selectByToken, exitActivity, delectActivity } from '@/api/activity'
import { onMounted, ref, onUnmounted, reactive } from 'vue';
import { useCookies } from 'vue3-cookies'
import { activityResponseData, delectActivityResponseData, exitActivityResponseData } from '@/model/activityData'
import { ElNotification } from 'element-plus'
import bus from '@/utils/mitt'
const { cookies } = useCookies()
let tableData = ref<{}[]>([]);
let token: string = cookies.get('token')
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
        console.log(result);
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
onMounted(() => {
    getActivityData();
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