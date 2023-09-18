const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,
  // 配置跨域请求
  devServer: {
    port: 8081,
    host: 'localhost',
    open: true,
    https: false,
    proxy: {
      '/api': {
        target: 'http://localhost:8080/',
        ws: true,
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }

  }
  // devServer:{
  //   proxy:{
  //     '/api':{
  //       target:'http://localhost:8001/',
  //       pathRewrite:{
  //         '^/api':''
  //       }
  //     }
  //   }
  // }
})
