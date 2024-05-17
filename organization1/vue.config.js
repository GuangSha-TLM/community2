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
    //解决组件重新绘制大小时dev环境出现报错提示
    client: {
      overlay: false
    },
    proxy: {
      "/api": {
        target: "http://127.0.0.1:8005",
        ws: false,
        pathRewrite: {
          '^/api': '/'
        }
      },

    },
  },
  publicPath: '/',
  outputDir: "dist",
  assetsDir: "static",
  chainWebpack: (config) => {
    config.plugin('define').tap((definitions) => {
      Object.assign(definitions[0], {
        __VUE_OPTIONS_API__: 'true',
        __VUE_PROD_DEVTOOLS__: 'false',
        __VUE_PROD_HYDRATION_MISMATCH_DETAILS__: 'false'
      })
      return definitions
    })
  },

})
