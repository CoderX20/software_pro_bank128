<template>
  <div id="business-select">
    <div class="container">
      <div class="but-row" id="business-title">
        <h2>请选择业务</h2>
      </div>
      <div class="but-row">
        <input type="button" value="存款" class="but" @click="deposit"><br>
        <input type="button" value="取款" class="but" @click="withdrawMoney">
        <input type="button" value="修改利率" class="but" @click="changToRate">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BusinessSelectCom",
  methods:{
    deposit(){
      this.$store.state.gx.business=1
      // console.log(this.$store.state.business)
      if(sessionStorage.getItem("userInfo")!==null){
        this.$router.push("/deposit")
      }else{
        this.$router.push('/login')
      }

    },
    withdrawMoney(){
      this.$store.state.gx.business=-1
      if(sessionStorage.getItem("userInfo")!==null){
        this.$router.push("/withdraw")
      }else{
        this.$router.push('/login')
      }
      // console.log(this.$store.state.business)

    },
    changToRate(){
      this.$router.push("/rate")
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
      margin: 30px 0 20px 0;
    }
    .but-row{
      position: relative;
      width: 300px;
      padding: 10px;
      text-align: center;
      input{
        position: relative;
        width: 250px;
        height: 30px;
        margin-top: 20px;
      }

    }
  }
}


#business-title{
  text-align: center;
  font-size: 16px;
}

</style>