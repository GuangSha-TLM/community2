<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-22 15:36:51
 * @LastEditTime: 2024-04-22 16:12:14
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization/src/views/HomeView.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
   <div class="hello">
        <div class="top">
            <Top></Top>
        </div>
        <div class="content">
            <!-- <div class="left">
            </div> -->
            <div class="rigth">
                <router-view />
            </div>
        </div>

        <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer>
    </div>
</template>

<script lang="ts" setup>
import Top from '@/components/fream/LoginTop.vue'
import Foot from '@/components/fream/Foot.vue'

</script>
<style scoped lang="less">
.content {
    display: flex;

}
/* 
.left {
    height: 90%;
    width: 10%;
} */

.rigth {
    height: 90%;
    width: 90%;
    margin: 0 auto;

}

.tab {
    margin: 30px;
}

a {
    color: black;
}
</style>
