<template>
    <div id="register-view">
        <registerCom id="register"></registerCom>
    </div>
</template>

<script>
import registerCom from '@/components/registerCom.vue';
export default {
    name:"registerView",
    components:{
        registerCom
    }
}
</script>

<style lang="less" scoped>
#register{
    background-color: blue;
    position: relative;
    width: 400px;
    left: 50%;
    margin-left: -200px;
    border: 1px solid black;
}
</style>
