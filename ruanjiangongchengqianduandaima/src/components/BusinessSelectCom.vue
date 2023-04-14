<template>
  <div id="business-select">
    <div class="container">
      <div class="but-row" id="business-title">
        <h2>请选择业务</h2>
      </div>
      <div class="but-row">
        <input type="button" value="存款" class="but" @click="deposit"><br>
        <input type="button" value="取款" class="but" @click="withdrawMoney">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BusinessSelectCom",
  methods:{
    deposit(){
      this.$store.state.business=1
      // console.log(this.$store.state.business)
      this.$router.push('/login')
    },
    withdrawMoney(){
      this.$store.state.gx.business=-1
      // console.log(this.$store.state.business)
      this.$router.push('/login')
    }
  }
}
</script>

<style lang="less" scoped>
#business-select{
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #6495E5;
  .container{
    width: 300px;
    height: 300px;
    background-color: white;
    border-radius: 20px;
    h2{
      margin: 30px 0 40px 0;
    }
  }
}

.but-row{
  position: relative;
  width: 300px;
  left: 50%;
  margin-left: -50%;
  padding: 10px;
  input{
    margin-top: 20px;
  }
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