<template>
  <div id="register-com">
    <div class="container">
      <div class="content">
        <h1>REGISTER</h1>
        <div class="name">
          <h4>Name</h4>
            <input type="text" placeholder="输入姓名" v-model="userInfo.name">
        </div>
        <div class="card_number">
          <h4>CardNumber</h4>
            <input type="text" placeholder="输入身份证号" v-model="userInfo.card_number">
        </div>
        <div class="address">
          <h4>Address</h4>
            <input type="text" placeholder="输入地址" v-model="userInfo.address">
        </div>
        <div class="phone_number">
          <h4>PhoneNumber</h4>
            <input type="text" placeholder="输入电话" v-model="userInfo.phone_number">
        </div>
        <div class="password">
          <h4>Password</h4>
            <input type="password" placeholder="输入密码" v-model="password">
        </div>
        <div class="repassword">
          <h4>RePassword</h4>
            <input type="password" placeholder="再次输入密码" v-model="password_second">
        </div>
        <div class="password">
          <h4 style="color: red;text-align: center;">{{ inputTipStr }}</h4>
        </div>
        <div class="bottom">
          <button @click="register">注册</button>
          <button @click="back">返回登录</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "RegisterCom",
  data(){
    return{
      password:"",
      password_second:"",
      inputTipStr:"",
      userInfo:{
        name:"",
        password:"",
        card_number:"",
        phone_number:"",
        address:""
        
      }
    }
  },
  methods:{
    back(){
      this.$router.push('/login')
    },
    async register(){
      if(this.check()){
        const result =await this.$store.dispatch("getRegister",this.userInfo)
        if(result){
          this.$router.replace("/login")
        }
      }
    },
    check(){
      this.userInfo.password=this.password
      for (let userInfoKey in this.userInfo) {
        if(this.userInfo[userInfoKey]===""){
          alert("请将信息填写完整")
          return false
        }
      }
      return true
    }
  },
  watch:{
    password(newPwd,oldPwd){
      if(newPwd!=this.password_second){
        this.inputTipStr="两次密码不同"
      }
      else{
        this.inputTipStr=""
      }
    },
    password_second(newPwd,oldPwd){
      if(newPwd!=this.password){
        this.inputTipStr="两次密码不同"
      }
      else{
        this.inputTipStr=""
      }
    }
  }
}
</script>

<style scoped lang="less">
#register-com{
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #6495E5;
  .container{
    width: 500px;
    height: 700px;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: white;
    border-radius: 20px;
    .content{

      width: 80%;
      h1{
        text-align: center;
      }
      div{
        margin-bottom: 15px;
      }
      input{
        height: 40px;
        width: 100%;
        margin-top: 10px;
        border: none;
        font-size: 15px;
        font-weight: 500;
        padding-left:20px;
        border-radius: 10px;
        background-color: #5F8BD6;
        filter: drop-shadow(2px 2px 1px rgba(0,0,0,.2));
        &:focus{
          outline: none;
          box-shadow: 0px 0px 10px 1px #FFF031;
          background-color: #79A2E8;
        }
        &::-webkit-input-placeholder{
          color: rgba(255, 255, 255, .5);
        }

      }
      .bottom{
        margin-top: 30px;
        text-align: center;
        button{
          height: 40px;
          width: 140px;
          margin: 10px 20px 0 0;
          border-radius: 20px;
          border: 0px solid red;
          font-size: 20px;
          font-weight: 600;
          letter-spacing: 5px;
          background-color: #8BB7FF;
          filter: drop-shadow(2px 2px 1px rgba(0,0,0,.2));
          &:active{
            background-color: #76AAFF;
          }

        }
      }
    }
  }
}
</style>