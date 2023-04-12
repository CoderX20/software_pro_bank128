<template>
  <div id="app">
    <div class="line-title" id="top-title">
      <h2>银行储户管理</h2>
    </div>
    <router-view id="view-place" name="showPlace"></router-view>
    <div class="line-title" id="foot">
      <h2>第十组</h2>
    </div>
  </div>
</template>

<script>
export default {
  name:"app",
  components:{
  },
  // mounted(){
  //   this.$router.replace('/');
  // }
}
</script>

<style lang="less" scoped>
#app{
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  background-color: lightgreen;
  width: 100%;
  margin: 0;
  min-height: 100vh;
  justify-content: center;
}
.line-title{
  background-color: blue;
  text-align: center;
}
.line-title > h2{
  margin: 10px
}
#view-place{
  display: flex;
  align-items: center;
  flex: 1;
}
</style>
