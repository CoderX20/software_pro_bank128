<template>
    <div id="business-select-view">
        <BusinessSelectCom id="view-app"></BusinessSelectCom>
    </div>
</template>

<script>
import BusinessSelectCom from '@/components/BusinessSelectCom.vue'; 
export default {
    name:"business-select-view",
    components:{
        BusinessSelectCom
    }
}
</script>

<style lang="less" scoped>
#view-app{
    background-color: blue;
    position: relative;
    width: 300px;
    left: 50%;
    margin-left: -150px;
    border: 1px solid black;
}
</style>
