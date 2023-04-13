<template>
  <div id="app">
    <router-view></router-view>
    <DepositCom></DepositCom>
<!--    <LoginCom></LoginCom>-->
<!--    <business-select-com></business-select-com>-->
  </div>
</template>

<script>
import LoginCom from "@/components/LoginCom";
import DepositCom from "./components/DepositCom.vue";
import BusinessSelectCom from "@/components/BusinessSelectCom";
export default {
  name: 'App',
  components: {
    LoginCom,
    BusinessSelectCom,
    DepositCom
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;*/
  color: #2c3e50;
}
</style>
