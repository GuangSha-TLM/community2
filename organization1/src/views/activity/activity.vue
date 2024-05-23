<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-08 15:32:33
 * @LastEditTime: 2024-05-22 17:20:09
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/views/activity/activity.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
     <div>
        <!-- <div>
            <Top></Top>
        </div> -->

        <div class="content"  v-if="list">
            <div class="title">
                {{ list.activeToGetBo.title }}
            </div>
            <div class="item_list">
                <div class="item">
                    创建时间: {{ list.activeToGetBo.createTime }}
                </div>
                <div class="item">
                    <!-- <router-link :to="{name:'ApplyAddAssociation',
                    params:{id:list.communityInActiveBo.id}}">社团:{{ list.communityInActiveBo.name }}</router-link> -->
                    社团:{{ list.communityInActiveBo.name }}
                </div>
                <div class="item">
                    创建人:{{ list.communityInActiveBo.username }}
                </div>
            </div>
            <div class="context" v-html="list.activeToGetBo.context">

            </div>

        </div>


        <!-- <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer> -->
    </div>
</template>

<script lang="ts" setup> 
import { ref, reactive, onMounted, toRefs, computed } from 'vue';
import { RouterLink ,useRouter,useRoute} from 'vue-router'
//引入vue3-cookies
import { useCookies } from "vue3-cookies";
//使用vue3-cookies
const { cookies } = useCookies();

import {activeSelectByIdBo,activeToGetBoAndCommunityInActiveBo} from '@/model/activityData'

import { activitySelectById } from '@/api/activity'

const token = cookies.get("token");

const router = useRouter();

const route = useRoute();



const list = ref<activeToGetBoAndCommunityInActiveBo>()

const activitySelectByIdBo  =reactive<activeSelectByIdBo>({
    token:token,
    id:route.params.id
})

onMounted(() => {
    getActivityInfo()
    
})

const getActivityInfo = async () => {
    let result = await activitySelectById(activitySelectByIdBo)
    list.value = result.data
    console.log(list.value);
    
}


</script>


<style scoped>
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
    display: flex;
    flex-direction: column;
}
.title{
    font-size: 70px;
    text-align: center;
}
.item_list{
    display: flex;
    justify-content: space-around;
}

.context{
    margin-top: 30px;
}
.context img{
    width: 100%;
    height: auto;
}
</style>
