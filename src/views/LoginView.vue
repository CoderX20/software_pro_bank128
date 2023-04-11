<template>
    <div id="login-view">
        <LoginCom id="login"></LoginCom>
    </div>
</template>

<script>
import LoginCom from '@/components/LoginCom.vue';
export default {
    name:"loginView",
    components:{
        LoginCom
    }
}
</script>

<style lang="less" scoped>
#login{
    background-color: blue;
    position: relative;
    width: 400px;
    left: 50%;
    margin-left: -200px;
    border: 1px solid black;
}
</style>
