// /$$
//  $ @Author: tianleiyu 
//  $ @Date: 2024-04-22 15:36:51
//  $ @LastEditTime: 2024-04-23 13:08:45
//  $ @LastEditors: tianleiyu
//  $ @Description: 
//  $ @FilePath: /organization1/vue.config.js
//  $ @可以输入预定的版权声明、个性签名、空行等
//  $/
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  devServer: {
    proxy: {
      "/api": {
        target: "http://127.0.0.1:8004",
        ws:false,
        pathRewrite: {
          '^/api': '/'
        }
      },
      
    },
  },
  publicPath:'/',
  outputDir: "dist",
  assetsDir:"static",
  
})
