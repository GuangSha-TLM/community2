<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-22 15:36:51
 * @LastEditTime: 2024-04-22 16:12:32
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization/src/App.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
  <router-view/>
</template>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
