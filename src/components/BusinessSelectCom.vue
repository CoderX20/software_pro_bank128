<template>
    <div id="business-select">
        <div class="but-row" id="business-title">
            <strong>请选择业务</strong>
        </div>
        <div class="but-row">
            <input type="button" value="存款" class="but" @click="deposit"><br>
            <input type="button" value="取款" class="but" @click="withdrawMoney">
        </div>
    </div>
</template>

<script>
export default {
    name:"businessSelect",
    methods:{
        deposit(){
            this.$store.state.business=1
            // console.log(this.$store.state.business)
            this.$router.push('/login')
        },
        withdrawMoney(){
            this.$store.state.business=-1
            // console.log(this.$store.state.business)
            this.$router.push('/login')
        }
    }
}
</script>

<style lang="less" scoped>
.but-row{
    position: relative;
    width: 300px;
    left: 50%;
    margin-left: -50%;
    padding: 10px
}
#business-title{
    text-align: center;
    font-size: 16px;
}
.but{
    position: relative;
    width: 250px;
    height: 30px;
    left: 50%;
    margin-left: -125px;
    margin-top: 10px;
    margin-bottom: 10px;
}
</style>
