<template>
    <div style="margin-bottom: 10px;">
        <el-text class="mx-1" size="large" type="primary">您的个人信息</el-text>
    </div>
    <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="name" label="用户名" width="200" />
        <el-table-column prop="college" label="学院" width="200" />
        <el-table-column prop="professional" label="专业" width="200" />
        <el-table-column prop="grade" label="年级" width="200" />
        <el-table-column label="操作" width="300">
            <template #default="scope">
                <el-button size="default" @click="handleEdit()">
                    修改
                </el-button>
            </template>
        </el-table-column>
    </el-table>
    <!-- 修改窗口 -->
    <el-dialog v-model="dialogVisible" title="请修改你的个人信息" width="500">
        <el-form class="demo-ruleForm">
            <el-form-item label="用户名:">
                <el-input v-model="userUpData.user.name" />
            </el-form-item>
            <el-form-item label="学院:">
                <el-select v-model="userUpData.user.college" placeholder="请选择你的学院" clearable>
                    <el-option v-for="item in options" :value="item.label" :label="item.label" />
                </el-select>
            </el-form-item>

            <el-form-item label="专业:">
                <el-select v-model="userUpData.user.professional" placeholder="请选择你的专业" clearable>
                    <el-option-group v-for="groups in professionalList[userUpData.user.college - 1]" :key="groups.label"
                        :label="groups.label">
                        <el-option v-for="items in groups.professionalList" :key="items" :label="items"
                            :value="items" />
                    </el-option-group>
                </el-select>
            </el-form-item>


            <el-form-item label="年级:">
                <el-select v-model="userUpData.user.grade" placeholder="请选择你的年级" clearable>
                    <el-option v-for="items in grandList" :key="items" :label="items" :value="items" />
                </el-select>
            </el-form-item>

        </el-form>
        <template #footer>
            <div class="dialog-footer">
                <el-button @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click.native="userFixData" @click="dialogVisible = false">
                    确认
                </el-button>
            </div>
        </template>
    </el-dialog>

</template>
<script lang="ts" setup>
import { onMounted, ref, onUnmounted, reactive } from 'vue';
import { useCookies } from 'vue3-cookies'
import { userData } from '@/model/userData'
import { userCenterData, userChanceData } from '@/api/user'
import qs from 'qs'
import { ElNotification } from 'element-plus'

const { cookies } = useCookies()
let tableData = ref();
const token = ref<string>(cookies.get("token"))
const user = ref<any>(cookies.get('user') ? qs.parse(cookies.get('user')) : '{}')
//获取用户的信息
let userPeopleData: userData = reactive({
    id: user.value.id,
    token: token.value
})

//修改表单时输入的数据
let userUpData: any = reactive({
    user: {
        id: user.value.id,
        name: '',
        college: 0,
        grade: '',
        professional: ''

    },
    token: token.value
})

//自定义用户选择的数据
let options = ref([
    { id: 1, label: '信息学院' },
    { id: 2, label: '财经学院' },
    { id: 3, label: '艺术学院' },
    { id: 4, label: '通识学院' }
])
let professionalList = ref([
    //信息学院
    [
        {
            value: 1,
            label: '软件工程',
            professionalList: ['软件工程1班', '软件工程2班', '软件工程3班', '软件工程4班', '软件工程5班', '软件工程6班']
        }, {
            value: 2,
            label: '计算机科学与技术',
            professionalList: ['计算机科学与技术1班', '计算机科学与技术2班', '计算机科学与技术3班',
                '计算机科学与技术4班', '计算机科学与技术5班', '计算机科学与技术6班']
        }, {
            value: 3,
            label: '电子商务',
            professionalList: ['电子商务1班', '电子商务2班', '电子商务3班', '电子商务4班', '电子商务5班', '电子商务6班']
        },

    ],
    //财经学院
    [
        {
            value: 1,
            label: '审计学',
            professionalList: ['审计学1班', '审计学2班', '审计学3班', '审计学4班', '审计学5班', '审计学6班']
        }, {
            value: 2,
            label: '会计学',
            professionalList: ['会计学1班', '会计学2班', '会计学3班', '会计学4班', '会计学5班', '会计学6班']
        }, {
            value: 3,
            label: '国际经济与贸易',
            professionalList: ['国际经济与贸易1班', '国际经济与贸易2班', '国际经济与贸易3班',
                '国际经济与贸易4班', '国际经济与贸易5班', '国际经济与贸易6班']
        }, {
            value: 4,
            label: '财务管理',
            professionalList: ['财务管理1班', '财务管理2班', '财务管理3班', '财务管理4班', '财务管理5班', '财务管理6班']
        }, {
            value: 5,
            label: '工商管理',
            professionalList: ['工商管理1班', '工商管理2班', '工商管理3班', '工商管理4班', '工商管理5班', '工商管理6班']
        }, {
            value: 6,
            label: '人力资源管理',
            professionalList: ['人力资源管理1班', '人力资源管理2班', '人力资源管理3班',
                '人力资源管理4班', '人力资源管理5班', '人力资源管理6班']
        },

    ],
    //艺术学院
    [
        {
            value: 1,
            label: '视觉传达设计',
            professionalList: ['视觉传达设计1班', '视觉传达设计2班', '视觉传达设计3班',
                '视觉传达设计4班', '视觉传达设计5班', '视觉传达设计6班']
        }, {
            value: 2,
            label: '环境设计',
            professionalList: ['环境设计1班', '环境设计2班', '环境设计3班', '环境设计4班', '环境设计5班', '环境设计6班']
        }, {
            value: 3,
            label: '影视摄影与制作',
            professionalList: ['影视摄影与制作1班', '影视摄影与制作2班', '影视摄影与制作3班',
                '影视摄影与制作4班', '影视摄影与制作5班', '影视摄影与制作6班']
        },

    ],
    //通识学院
    [
        {
            value: 1,
            label: '汉语言文学',
            professionalList: ['汉语言文学1班', '汉语言文学2班', '汉语言文学3班',
                '汉语言文学4班', '汉语言文学5班', '汉语言文学6班']
        }, {
            value: 2,
            label: '应用心理学',
            professionalList: ['应用心理学1班', '应用心理学2班', '应用心理学3班',
                '应用心理学4班', '应用心理学5班', '应用心理学6班']
        }, {
            value: 3,
            label: '学前教育 (师范类)',
            professionalList: ['学前教育 (师范类)1班', '学前教育 (师范类)2班', '学前教育 (师范类)3班',
                '学前教育 (师范类)4班', '学前教育 (师范类)5班', '学前教育 (师范类)6班']

        },

    ]
])
let grandList = ref([2019, 2020, 2021, 2022, 2023, 2024, 2025])

//表单显示和隐藏
let dialogVisible = ref(false)

//修改的按钮
const handleEdit = () => {
    dialogVisible.value = true;
    userUpData.user.name = user.value.name
    userUpData.user.college = user.value.college
    userUpData.user.grade = user.value.grade
    userUpData.user.professional = user.value.professional
}

//修改表格的接口
const userFixData = async () => {
    const result: any = await userChanceData(userUpData)
    if (result.code = "0x200") {
        ElNotification({
            title: 'Success',
            message: '修改成功',
            type: 'success',
        })
        getUserData();
        console.log(result, 'sdsd');
    } else {
        ElNotification({
            title: 'Error',
            message: '修改失败',
            type: 'error',
        })
    }

}

//请求用户数据的接口
const getUserData = async () => {
    const result: any = await userCenterData(userPeopleData)
    if (result.code = "0x200") {
        let arrObj = result.data;
        let arr = [];
        arr.push(arrObj)
        tableData.value = arr

        // console.log(tableData, 'sdsd');
    }
}
onMounted(() => {
    getUserData();

})


</script>

<style scoped>
.demo-form-inline .el-input {
    --el-input-width: 220px;
}

.demo-form-inline .el-select {
    --el-select-width: 220px;
}

.el-form {
    padding: 10px;
}
</style>