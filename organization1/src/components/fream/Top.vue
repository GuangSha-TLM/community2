<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-26 08:33:35
 * @LastEditTime: 2024-05-23 08:34:40
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/components/fream/Top.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
  <div class="box">
    <div class="modal fade" tabindex="-1" role="dialog" id="modal-cookies" data-backdrop="false"
      aria-labelledby="modal-cookies" aria-hidden="true">
      <div class="modal-dialog modal-dialog-aside left-4 right-4 bottom-4">
        <div class="modal-content bg-dark-dark">
          <div class="modal-body">
            <!-- Text -->
            <p class="text-sm text-white mb-3">
              We use cookies so that our themes work for you. By using our
              website, you agree to our use of cookies.
            </p>
            <!-- Buttons -->
            <a class="btn btn-sm btn-white" target="_blank">Learn more</a>
            <button type="button" class="btn btn-sm btn-primary mr-2" data-dismiss="modal">
              OK
            </button>
          </div>
        </div>
      </div>
    </div>

    <a class="btn btn-block btn-dark text-truncate rounded-0 py-2 d-none d-lg-block"
      style="z-index: 1000; color: aliceblue" target="_blank">
      <strong>哈尔滨广厦学院</strong> 社团管理系统 V0.2 By TLM Team
    </a>
    <!-- 头栏目 -->
    <header>
      <div class="navbor">
        <div class="logo">
          <router-link to="/"><img src="../../assets/gs_xy_logo.png" alt=""></router-link>
        </div>
        <!-- 活动面板的模糊查询 -->
        <div v-if="shouInput" class="mt-4">
          <el-input size="large" v-model="inputData.title" style="width: 460px" placeholder="Please input"
            class="input-with-select" @keydown.enter="activeSelect">
            <template #prepend>
              <el-button @click="activeSelect" :icon="Search" />
            </template>
          </el-input>
        </div>
        <ul class="links">
          <div v-if="token">
            <li><router-link to="/">Home</router-link></li>
            <li><el-dropdown>
                <span style="font-size: large">{{ user.username }}</span>
                <template #dropdown>
                  <el-dropdown-menu>
                    <el-dropdown-item><router-link to="/notice">消息</router-link></el-dropdown-item>
                    <el-dropdown-item><router-link to="/signIn">签到</router-link></el-dropdown-item>
                    <el-dropdown-item><a @click="loginOut()">退出</a></el-dropdown-item>
                  </el-dropdown-menu>
                </template>
              </el-dropdown>
            </li>
          </div>
          <div v-else>
            <li><router-link to="/login">Login</router-link></li>
            <li><router-link to="/register">Register</router-link></li>
          </div>
        </ul>
        <!-- <a href="#" class="action_btn">Get Started</a> -->
        <div class="toggle_btn" @click="updateTopMenu">
          <i class="fa-solid fa-bars fa-beat fa-xl"></i>
        </div>
      </div>
      <!-- 点击面包屑后的展示 -->
      <div class="dropdown_menu" v-if="top_btn">
        <li><a href="Home">Home</a></li>
        <li><router-link to="/login">Login</router-link></li>
        <li><router-link to="/register">Register</router-link></li>
        <li><a href="Countact">Countact</a></li>
        <!-- <li><a href="#" class="action_btn">Get Started</a></li> -->
      </div>
    </header>

    <!-- 按钮 -->
  </div>
</template>

<script lang="ts" setup>
//引入vue3-cookies
import { useCookies } from "vue3-cookies";
//搜索框图标
import { Search } from '@element-plus/icons-vue'
import { activitySearchBytitle } from '@/api/activity'
import { activityResponseData, } from '@/model/activityData'
//引入mitt实现兄弟组件通信
import bus from '@/utils/mitt'
//使用vue3-cookies
const { cookies } = useCookies();
import { ref, reactive, onMounted, toRefs, computed } from 'vue';
// import { RouterLink } from 'vue-router'
import { useRouter, useRoute } from 'vue-router';
const router = useRouter();
const route = useRoute();
// 控制头部导航栏
const top_btn = ref(false);
function updateTopMenu() {
  top_btn.value = !top_btn.value
  console.log(top_btn);
}

const left_btn = ref(false);
function updateLeftMenu() {
  left_btn.value = !left_btn.value
  console.log(left_btn);
}
//搜索框的信息
let inputData = reactive<any>({
  token: '',
  title: '',
  status: 0,
  delFlag: 0
});
let sendInputData: {}[];
const token = ref<string>(cookies.get("token"))
const user = ref<string>(cookies.get("user"))
//搜索框的接口
const activeSelect = async () => {
  inputData.token = token;
  const result: activityResponseData = await activitySearchBytitle(inputData)
  if (result.code === "0x200") {
    sendInputData = result.data;
    // console.log(sendInputData, '123');

    //发送数组给activityManagement
    bus.emit('InputData', sendInputData)
    sendInputData = []
  }
  // console.log('456', result);

}
//控制搜索框的显示和隐藏
let shouInput = computed(() => {
  if (token && route.name === 'activityManagement') {
    return true
  } else {
    return false
  }
})
//退出登录
const loginOut = () => {
  cookies.remove("token");
  cookies.remove("user");
  user.value = '';
  router.push('/login');
}
onMounted(() => {
  // console.log(route.name);

})
</script>

<style lang="less" scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

li {
  list-style: none;
}

a {
  text-decoration: none;
  color: rgb(0, 195, 255);
  font-style: 1rem;
}

a:hover {
  color: orange;
}

header {
  position: relative;
  padding: 0 2rem;
  height: 70px;
}

.navbor {
  width: 100%;
  height: 100%;
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

/* 修饰Web Creative */
.navbor .logo a {
  font-size: 1.5rem;
  font-weight: bold;
}

/* 修饰ul */
.navbor .links div {
  display: flex;
  gap: 2rem;
  align-items: center;
  color: #00c3ff;
  /* 定义一个间隔，单位为rem */
}

/* 修饰Get started */
.navbor .toggle_btn {
  /* color: #fff; */
  font-style: 1.5rem;
  /* 光标cursor */
  cursor: pointer;
  display: none;
}

/* 修饰面包版 */
.action_btn {
  background-color: orange;
  color: #fff;
  padding: 0.5rem 1rem;
  border: none;
  outline: none;
  overflow: none;
  border-radius: 30px;
  font-size: 0.8rem;
  font-weight: bold;
  cursor: pointer;
  transition: scale 0.2 ease;
}

.action_btn:hover {
  scale: 1.05;
  color: #fff;
}

.action_btn:active {
  scale: 0.95;
}

/* 面包屑的展示框 */
.dropdown_menu {
  position: absolute;
  right: 2rem;
  top: 60px;
  width: 300px;
  background: rgba(155, 235, 198, 0.977);
  border-radius: 10px;
  overflow: hidden;
  transition: height 0.2s cubic-bezier(0.175, 0.885, 0.32, 1.275);
  z-index: 1;
}


.dropdown_menu li {
  padding: 0.7rem;
  display: flex;
  align-items: center;
  justify-content: center;
}


.dropdown_menu .action_btn {
  width: 100%;
  display: flex;
  justify-content: center;
}

/* 随页面的大小缩放显示面包板 */
@media (max-width: 992px) {

  .navbor .links,
  .navbor .action_btn {
    display: none;
  }

  .navbor .toggle_btn {
    display: block;
  }

  .dropdown_menu {
    display: block;
  }
}

/* 面包屑展示框背景 */
@media (max-width: 576px) {
  .dropdown_menu {
    width: 90%;
  }

  /* .dropdown_menu {
        left: 2rem;
        width: unset;
    } */
}
</style>

<!-- 以下是侧边导航栏样式 -->
<style scoped lang="less">
/* ======================================== */
/* 侧边栏 */

.left_navbor {
  /* display: none; */
  display: flex;
  justify-content: center;
  width: 60px;
  margin-left: 47px;
}

.left_navbor.open {
  /* display: none; */
  width: 200px !important;
  background-color: rgb(244, 247, 51);
  /* margin-left: 47px; */
}

/* 侧边框的头栏目 */
.left_navbor .left_logo {
  text-align: left;
  background-color: rgb(244, 247, 51);
  height: 59px;
}

/* 面包屑修饰 */
.left_navbor .left_logo .left_toggle_btn {

  position: fixed;
  top: 79px;
  left: 70px;
  cursor: pointer;
}

.left_toggle_btn.open {
  left: 137px !important;
}

/* ul列表 */
.left_navbor ul {
  display: flex;
  justify-content: center;
  flex-direction: column;
}

.left_navbor ul li {
  text-align: center;
  margin-top: 50px;
}

/* 修饰侧边框的Get Started */
.left_navbor .action_btn {
  position: fixed;
  top: 500px;
  left: 92px;
}

/* 实现按钮功能js */
.left_links.open {
  display: block;
  height: 439px;
}
</style>



<style scoped lang="less">
//搜索框的样式
.mt-4 {
  margin-top: 0 !important;
}

.box {
  width: 100%;
  height: 100%;

  header {
    width: 100%;

    .navbor {
      width: 100%;

      .logo {
        width: 30%;

        a {
          img {
            width: 77%;
          }
        }
      }

      .links {
        li {
          a {}
        }

        li {
          a {}
        }

        li {
          a {}
        }

        li {
          a {}
        }
      }

      .action_btn {}

      .toggle_btn {
        .fa-solid {}

        .fa-bars {}

        .fa-beat {}

        .fa-xl {}
      }
    }

    .dropdown_menu {
      li {
        a {}
      }

      li {
        a {}
      }

      li {
        a {}
      }

      li {
        a {}
      }

      .action_btn {}
    }
  }

  .content {
    display: flex;
    width: 100%;

    .left_block {
      width: 20%;

      .left_navbor {
        .left_logo {
          .left_toggle_btn {
            .fa-solid {}

            .fa-bars {}

            .fa-beat {}

            .fa-lg {}
          }
        }

        .left_links {
          li {
            a {}
          }

          li {
            a {}
          }

          li {
            a {}
          }

          li {
            a {}
          }

          .action_btn {}
        }
      }
    }

    .right {
      width: 80%;
    }
  }
}
</style>