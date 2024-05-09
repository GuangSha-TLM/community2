<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-08 15:38:30
 * @LastEditTime: 2024-05-09 15:32:45
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/views/activity/associationActivityManagement.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div>
        <div class="content">

            <el-button type="primary" @click="dialogFormVisible = true">新增活动</el-button>

            <div v-for="(item, index) in list" :key="item.id" class="item">
                <router-link :to="{ name: 'activity', params: { id: item.id } }" class="item_link">
                    <div class="item_id">{{ index + 1 }}</div>
                    <div class="item_title">{{ item.title }}</div>
                    <div class="item_time">{{ item.startTime }}</div>
                </router-link>
                <div class="item_but">
                    <!-- 删除按钮 -->
                    <el-popconfirm confirm-button-text="Yes" cancel-button-text="No" :icon="InfoFilled"
                        icon-color="#626AEF" title="Are you sure to delete this?" @confirm="delActive(item.id)">
                        <template #reference>
                            <el-button type="danger" :icon="Delete" circle />
                        </template>
                    </el-popconfirm>

                    <div class="item_icon"><el-icon>
                            <ArrowRight />
                        </el-icon></div>
                </div>
            </div>


            <el-dialog title="新增活动" :visible.sync="dialogFormVisible" width="100%" top="0">
                <el-form :model="activeAddBo">
                    <el-form-item label="活动标题" :label-width="formLabelWidth">
                        <el-input v-model="activeAddBo.title" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="活动详细" :label-width="formLabelWidth">
                        <!-- <quill-editor v-model="context" ref="myTextEditor" :options="editorOptions" /> -->

                        <!-- <el-upload class="upload-demo" action="#" drag :file-list="fileList" style="display: none;"
                            :on-change="handleChange" :http-request="confirmUpload">
                            <i class="el-icon-upload"></i>
                            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                            <div class="el-upload__tip" slot="tip">上传Excel格式文件</div>
                        </el-upload> -->
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="close">取 消</el-button>
                    <el-button type="primary" @click="addActive">确 定</el-button>
                </div>
            </el-dialog>
        </div>
    </div>
</template>

<script lang="ts" setup>
import { Delete, ArrowRight, InfoFilled } from '@element-plus/icons-vue'
//引入vue3-cookies
import { useCookies } from "vue3-cookies";
//使用vue3-cookies
const { cookies } = useCookies();
import { ref, reactive, onMounted, toRefs, computed } from 'vue';
import { selectByToken, delectActivity } from '@/api/activity'

import { IActivityList, activityResponseData, activeDeleteByIdBo } from '@/model/activityData'
import { ElMessage } from 'element-plus';

const token = cookies.get('token')
let list = ref<IActivityList>([])
const dialogFormVisible = ref(false)
const context = ref('')
const formLabelWidth = '140px'
const fileList = ref([])
const activeAddBo = ref({
    title: '',
    context: '',
    file: ''
})
const activeDeleteByIdBo = ref<activeDeleteByIdBo>({
    token: token,
    id: -1
})

onMounted(() => {
    getList()
})

const getList = async () => {

    const result: activityResponseData = await selectByToken(token)

    console.log(result.data);

    if (result.code === '0x200') {
        list.value = result.data
    }
    console.log(list.value);

}

const delActive = async (id: number) => {
    activeDeleteByIdBo.value.token = token
    activeDeleteByIdBo.value.id = id
    const result = await delectActivity(activeDeleteByIdBo.value)
    if (result.code === '0x200') {
        getList()
        ElMessage({
            message: result.message,
            type: 'success',
        })

    } else {
        ElMessage({
            message: result.message,
            type: 'error',
        })
    }

}
const close = () => {
    dialogFormVisible.value = false
    activeAddBo.value.title = ''
    activeAddBo.value.context = ''
}



</script>


<style scoped lang="less">
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
    color: black;
}

.content {
    width: 70%;
    margin: 0 15%;
}

.item {
    width: 100%;
    display: flex;
    justify-content: space-between;
    margin: 20px 0;
}

.item_link {
    width: 60%;
    display: flex;
    justify-content: space-between;
    margin: 20px 0;
}

.item_but {
    width: 15%;
    display: flex;
    justify-content: space-between;
    margin: 20px 0;
}

.item_del {
    color: #67C23A;
}
</style>
