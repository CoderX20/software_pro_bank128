<template>
  <div id="login-com">
    <div class="container">
      <div class="left"></div>
      <div class="right">
        <div class="content">
          <h1>LOGIN</h1>
          <div class="input_part">
            <div class="account">
              <h4>Account</h4>
              <input type="text" placeholder="输入身份证号" v-model="card_number">
            </div>
            <div class="password">
              <h4>Password</h4>
              <input type="password" placeholder="输入密码" v-model="password">
            </div>
          </div>
          <div class="bottom">
<!--            <a href="">立即注册</a>-->
            <router-link to="/register" class="to_register">立即注册</router-link>
            <button @click="login">登录</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginCom",
  data() {
    return {
      card_number: "",
      password: ""
    }
  },
  methods:{
   async login(){
      var login_res=await this.$store.dispatch("login_check",{card_number:this.card_number,password:this.password})
      if(login_res&&this.$store.state.gx.business==1){
        this.$router.push('/deposit')
      }
      else if(login_res&&this.$store.state.gx.business==-1){
        // 取款
        this.$router.push('/withdraw')
      }
    }
  }
}
</script>

<style scoped lang="less">
#login-com {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #6495E5;
}

.container {
  width: 50vw;
  min-width: 700px;
  height: 60vh;
  min-height: 400px;
  display: flex;
  background-color: white;
  border-radius: 20px;
  overflow: hidden;
  box-shadow: 5px 5px 10px rgba(0, 0, 0, .4);

  .left {
    flex: 5;
    background-image: url("../assets/image/pic_01.png");
    background-position: center;
    background-repeat: no-repeat;
  }

  .right {
    flex: 4;
    display: flex;
    justify-content: center;
    align-items: center;

    .content {
      width: 250px;
      height: 70%;

      h1 {
        margin-bottom: 90px;
        letter-spacing: 7px;
        filter: drop-shadow(3px 3px 1px rgba(0, 0, 0, .2));
      }

      div {
        margin-bottom: 20px;
      }

      h4 {
        font-weight: 600;
      }

      input {
        height: 40px;
        width: 100%;
        margin-top: 10px;
        border: none;
        font-size: 15px;
        font-weight: 500;
        padding-left: 20px;
        border-radius: 10px;
        background-color: #5F8BD6;
        filter: drop-shadow(2px 2px 1px rgba(0, 0, 0, .2));

        &:focus {
          outline: none;
          box-shadow: 0px 0px 10px 1px #FFF031;
          background-color: #79A2E8;
        }

        &::-webkit-input-placeholder {
          color: rgba(255, 255, 255, .5);
        }

      }

      .bottom {
        margin-top: 40px;
        text-align: center;

        .to_register {
          text-decoration: none;
          color: #5F8BD6;
        }

        button {
          height: 50px;
          width: 170px;
          display: block;
          margin: 10px auto;
          border-radius: 20px;
          border: 0px solid red;
          font-size: 20px;
          font-weight: 600;
          letter-spacing: 5px;
          background-color: #8BB7FF;
          filter: drop-shadow(2px 2px 1px rgba(0, 0, 0, .2));

          &:active {
            background-color: #76AAFF;
          }
        }
      }
    }
  }
}

</style>