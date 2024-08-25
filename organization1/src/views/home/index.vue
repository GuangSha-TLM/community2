<!--
 * @Author: 陈志祥
 * @Date: 2024-04-22 15:36:51
 * @LastEditTime: 2024-05-08 15:01:30
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/App.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div class="header_home">
        <h3 class="title">{{ getTime() }}好呀 {{ homeStore.userData.name }}</h3>
        <p class="subtitle">社团公告栏</p>
    </div>

</template>
<script lang="ts" setup>
//引入时间的变化提醒信息
import { getTime } from "@/utils/time";
// 引入ref
import { ref, onMounted } from "vue";
//引入home的小仓库
import { homeInfoStore } from "@/stores/modules/home";
//使用home的小仓库
const homeStore = homeInfoStore()

</script>

<style lang="less">
.header_home {
    // background-color: skyblue;
    height: 90px;
    margin-left: 10px;
    border-bottom: 1px solid #8b8a8a;

    .title {
        font-size: 30px;
        font-weight: 900;
        // margin-bottom: 30px;
    }

    .subtitle {
        font-style: italic;
        color: skyblue;
    }
}
</style>
@/store/modules/home