const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,
  devServer: {
    // history模式下的url会请求到服务器端，但是服务器端并没有这一个资源文件，就会返回404，所以需要配置这一项
    historyApiFallback: {
      index: '/index.html'
      //与output的publicPath有关(HTMLplugin生成的html默认为index.html)
    },
    // proxy: {
    //         '/api': {
    //           target: 'http://localhost:8088',    // 你自己的api接口地址
    //           changeOrigin: true,
    //           pathRewrite: {'^/api': ''}
    //         }
    //       }
  }


})
