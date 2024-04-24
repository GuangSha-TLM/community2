<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-22 16:55:02
 * @LastEditTime: 2024-04-24 14:22:43
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/views/user/register.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div class="Register">
        <div>
            <Top></Top>
        </div>

        <!-- Main content -->
        <section>
            <div class="container">
                <!-- Title -->
                <!-- Section title -->
                <div class="row mb-5 justify-content-center text-center">
                    <div class="col-lg-6">

                        <h2 class=" mt-4">注册您的账户</h2>
                        <div class="mt-2">
                            <p class="lead lh-180">Register Your Account</p>
                        </div>

                        <div>
                            <el-form ref="ruleFormRef" :model="userRegisterBo" :rules="rules" label-width="auto"
                                class="demo-ruleForm" status-icon>
                                <el-form-item label="用户名" prop="username">
                                    <el-input v-model="userRegisterBo.username" />
                                </el-form-item>
                                <el-form-item label="密码" prop="password">
                                    <el-input v-model="userRegisterBo.password" @keyup.enter="register(ruleFormRef)" />
                                </el-form-item>
                                <el-form-item label="确认密码" prop="confirmPassword">
                                    <el-input v-model="userRegisterBo.confirmPassword"
                                        @keyup.enter="register(ruleFormRef)" />
                                </el-form-item>

                                <el-form-item label="姓名" prop="name">
                                    <el-input v-model="userRegisterBo.name" />
                                </el-form-item>
                                <el-form-item label="学号" prop="studentId">
                                    <el-input v-model="userRegisterBo.studentId" />
                                </el-form-item>
                                <el-form-item label="选择年级" prop="grade">
                                    <el-select v-model="userRegisterBo.grade" placeholder="选择年级">
                                        <el-option v-for="option in yearOptions" :key="option.value"
                                            :label="option.label" :value="option.value"></el-option>
                                    </el-select>
                                </el-form-item>

                                <el-form-item label="选择学院" prop="college">
                                    <el-select-v2 v-model="userRegisterBo.college" placeholder="选择学院"
                                        :options="options" />
                                </el-form-item>
                                <el-form-item label="选择班级" prop="professional">
                                    <el-select v-model="userRegisterBo.professional" placeholder="请选择班级"
                                        style="width: 100%;">
                                        <el-option-group
                                            v-for="(option, i) in professionalList[(userRegisterBo.college || 0) - 1]"
                                            :label="option.label" :key="i">

                                            <el-option v-for="i in option.professionalList" :key="i" :label="i"
                                                :value="i">
                                            </el-option>
                                        </el-option-group>
                                    </el-select>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" size="large" @click="register(ruleFormRef)"
                                        :disabled="switchbutton">
                                        注册
                                    </el-button>
                                </el-form-item>
                            </el-form>
                        </div>
                    </div>
                </div>

            </div>
        </section>

        <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer>
    </div>
</template>

<script lang="ts" setup>
//引入vue3-cookies
import { useCookies } from "vue3-cookies";
//使用vue3-cookies
const { cookies } = useCookies();
//引用element-Plus
import { ElMessage } from 'element-plus'
import type { FormInstance, FormRules } from 'element-plus'
import { IUserRegister } from '@/model/userData';
import Top from '@/components/fream/LoginTop.vue';
import Foot from '@/components/fream/Foot.vue';
import { reactive, ref, toRefs, computed } from 'vue'

//引用接口
import { userRegister } from '@/api/user'


const ruleFormRef = ref<FormInstance>()
const userRegisterBo: IUserRegister = reactive({
    username: '',
    password: '',
    confirmPassword: '',
    name: '',
    college: undefined,
    grade: undefined,
    org: '',
    studentId: '',
    professional: '',
})

const switchbutton = ref(false)

//学院选择
const options = [
    { value: 1, label: "信息学院" },
    { value: 2, label: "财经学院" },
    { value: 3, label: "艺术学院" },
    { value: 4, label: "通识学院" }
]

//班级选择
const professionalList = [
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
]
//获取前年,去年,今年,来年,后年的年份
const yearOptions = computed(() => {
    const currentYear = new Date().getFullYear();
    return [
        { value: currentYear - 4, label: `${currentYear - 4}` },
        { value: currentYear - 3, label: `${currentYear - 3}` },
        { value: currentYear - 2, label: `${currentYear - 2}` }, 
        { value: currentYear - 1, label: `${currentYear - 1}` },
        { value: currentYear, label: `${currentYear}` },        
        { value: currentYear + 1, label: `${currentYear + 1}` }, 
        { value: currentYear + 2, label: `${currentYear + 2}` } 
    ];
});

//获取当前时间

const rules = reactive<FormRules<IUserRegister>>({
    username: [
        { required: true, message: '请输入你的用户名', trigger: 'blur' },
        { min: 3, max: 20, message: '长度在3-20个字符', trigger: 'blur' },
    ],
    password: [
        { required: true, message: '请输入你的密码', trigger: 'blur' },
        { min: 3, max: 20, message: '长度在3-20个字符', trigger: 'blur' },
    ],
    confirmPassword: [
        { required: true, message: '请输入你的密码', trigger: 'blur' },
        { min: 3, max: 20, message: '长度在3-20个字符', trigger: 'blur' },
        {
            validator: (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入你的密码'));
                } else if (value !== userRegisterBo.password) {
                    callback(new Error('两次输入的密码不一致'));
                } else {
                    callback();
                }
            },
            trigger: 'blur'
        },
    ],
    name: [
        { required: true, message: '请输入您的名字', trigger: 'blur' },
        { min: 2, max: 10, message: '名字长度应在2到10个字符之间', trigger: 'blur' },
        {
            pattern: /^[\u4e00-\u9fa5]+$/, // 仅允许中文字符  
            message: '名字只能包含中文字符',
            trigger: 'blur'
        },
    ],
    college: [
        { required: true, message: '请选择你的学院', trigger: 'blur' },
    ],
    grade: [
        { required: true, message: '请选择你的年级', trigger: 'blur' },
    ],
    studentId: [
        { required: true, message: '请输入你的学号', trigger: 'blur' },
        { type: 'number', message: '学号必须为数字', trigger: 'blur' },
    ],
    professional: [
        { required: true, message: '请选择你的用户名', trigger: 'blur' },
    ],
})



const register = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
            console.log(userRegisterBo);

            switchbutton.value = true
            userRegister(userRegisterBo)
                .then(res => {
                    console.log(res)
                    if (res.code === '0x200') {
                        console.log(res);
                        resetUserRegisterBo()
                        ElMessage({
                            message: res.message,
                            type: 'success',
                        })
                    } else {
                        console.log(res);
                        resetUserRegisterBo()
                        ElMessage({
                            message: res.message,
                            type: 'error',
                        })
                    }
                })
                .catch(err => {
                    console.log(err);
                    ElMessage({
                        message: err.message,
                        type: 'error',
                    })
                })


            switchbutton.value = false
        } else {
            console.log('error submit!', fields)
        }
    })
}

//将userRegisterBo恢复
function resetUserRegisterBo() {
    userRegisterBo.username = '';
    userRegisterBo.password = '';
    userRegisterBo.confirmPassword = '';
    userRegisterBo.name = '';
    userRegisterBo.college = undefined;
    userRegisterBo.grade = undefined;
    userRegisterBo.org = '';
    userRegisterBo.studentId = '';
    userRegisterBo.professional = '';
}

</script>

<style lang="less" scoped></style>