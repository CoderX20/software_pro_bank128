const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  publicPath:'./',
  assetsDir:'static',
  lintOnSave:true,
  outputDir: "dist",
  indexPath:"index.html"
})
