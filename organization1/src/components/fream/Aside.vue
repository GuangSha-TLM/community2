<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-16 13:07:00
 * @LastEditTime: 2024-05-22 17:18:02
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/components/fream/Aside.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <el-row class="tac">
        <el-col :span="12">
            <h5 class="mb-2">社团管理主页</h5>
            <el-menu :router="true" default-active="/home" class="el-menu-vertical-demo">
                <el-menu-item index="/home">
                    <template #title>
                        <el-icon>
                            <HomeFilled />
                        </el-icon>
                        <span>主页</span>
                    </template>
                </el-menu-item>

                <el-sub-menu index="2">
                    <template #title>
                        <el-icon>
                            <Menu />
                        </el-icon>
                        <span>活动管理面板</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="/activityManagement">活动信息</el-menu-item>
                    </el-menu-item-group>
                </el-sub-menu>

                <el-sub-menu index="3">
                    <template #title>
                        <el-icon>
                            <UserFilled />
                        </el-icon>
                        <span>社团人员面板</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="userInfo">社团人员信息</el-menu-item>
                    </el-menu-item-group>
                </el-sub-menu>

                <el-sub-menu index="4">
                    <template #title>
                        <el-icon>
                            <Avatar />
                        </el-icon>
                        <span>社团人员管理面板</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="/userManage">社团人员管理</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group>
                        <el-menu-item index="/associationActivityManagement">社团活动管理</el-menu-item>
                    </el-menu-item-group>
                </el-sub-menu>

            </el-menu>
        </el-col>
        <el-card style="width: 80%;">
            <RouterView></RouterView>
        </el-card>
    </el-row>
</template>

<script lang="ts" setup>
//引入onMount
import { ref, onMounted } from 'vue'

//测试代码
onMounted(() => {

})



</script>
<style lang="less" scoped>
.el-col-12 {
    margin-left: 25px;
    max-width: 15% !important;
}

/*.el-col-12,
.el-col-12.is-guttered {
    background-color: #171347;
}*/

.el-card.is-always-shadow {
    margin-left: 10px;
}

/*.mb-2 {
    color: #fff
}*/
.el-menu {
    border-right: 1px solid #fff !important;
}
</style>