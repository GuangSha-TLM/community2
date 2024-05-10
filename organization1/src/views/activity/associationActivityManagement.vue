<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-08 15:38:30
 * @LastEditTime: 2024-05-10 09:01:59
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


            <div v-if="dialogFormVisible">
                <EditorTinymce v-model="htmlContent" @editor="receiveEditor" placeholder="placeholder"/>

            </div>


            <!-- <el-dialog title="新增活动" v-model="dialogFormVisible" width="100%" top="0">
                <el-form :model="activeAddBo">
                    <el-form-item label="活动标题" :label-width="formLabelWidth">
                        <el-input v-model="activeAddBo.title" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="活动详细" :label-width="formLabelWidth">
                        <EditorTinymce v-model="htmlContent" @editor="receiveEditor" placeholder="placeholder"/>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="close">取 消</el-button>
                    <el-button type="primary" @click="addActive">确 定</el-button>
                </div>
            </el-dialog> -->
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

import EditorTinymce from '@/components/editor'

//接收tinymce编辑器的editor,用来获取右下角字符统计
let _editor = null
const receiveEditor = (editor)=>{
  _editor = editor
}

const htmlContent = ref('')

/* 贴上的是代码片段，自己放在需要的位置去
//获取右下角字符数
  const elements = _editor.getContainer().getElementsByClassName('tox-statusbar__wordcount')
  const wordcountButton = elements[0]
  const wordcount = parseInt(wordcountButton.innerHTML)
  */



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
