<template>
    <el-table :data="tableData" style="width: 100%">
        <el-table-column type="index" label="ID" width="200" />
        <el-table-column prop="title" label="活动标题" width="200" />
        <el-table-column prop="context" label="活动内容" width="200" />
        <el-table-column prop="createTime" label="活动创建时间" width="200" />
        <el-table-column label="操作" width="300">
            <template #default="scope">
                <el-popconfirm @confirm="AssociationDelete" title="你确定要删除吗?">
                    <template #reference>
                        <el-button size="default" type="danger" @click="handleDelete(scope.$index, scope.row)">
                            删除
                        </el-button>
                    </template>
                </el-popconfirm>

            </template>
        </el-table-column>

    </el-table>
</template>
<script lang="ts" setup>
import { AssociationByToken, delectAssociation } from '@/api/association'
import { onMounted, ref, onUnmounted, reactive } from 'vue';
import { useCookies } from 'vue3-cookies'
import { ElNotification } from 'element-plus'
// import {  } from '@/model/activityData'
const { cookies } = useCookies()
let tableData = ref<{}>();
let token: string = cookies.get('token')
//删除的数据
let deleteId: number;
//删除的按钮
function handleDelete(index: number, scope: any) {
    deleteId = scope.id
    // console.log(deleteId);
}
//请求社团人员数据的接口
const getAssociationData = async () => {
    const result: any = await AssociationByToken(token)
    if (result.code = "0x200") {
        tableData.value = result.data;
        // console.log('123', result);
    }
}
//删除接口
async function AssociationDelete() {
    const result: any = await delectAssociation({ id: deleteId, token: token })
    if (result.code === '0x200') {
        ElNotification({
            title: 'Success',
            message: '删除成功',
            type: 'success',
        })
        getAssociationData();
    } else {
        ElNotification({
            title: 'Error',
            message: '删除失败',
            type: 'error',
        })
    }
}

</script>

<style scoped></style>