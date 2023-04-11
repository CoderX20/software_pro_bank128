<template>
    <div id="login-com">
        <div class="sub-row" id="entry-row">
            <a class="entry-label">用户名</a><input type="text" class="entry-input" v-model="username"><br>
            <a class="entry-label">密码</a><input type="password" class="entry-input" v-model="password">
        </div>
        <div class="sub-row" id="but-row">
            <input type="button" value="登陆" class="but" @click="loginCheck">
            <input type="button" value="注册" class="but" @click="registerUser">
            <input type="button" value="返回" class="but" @click="back">
        </div>
    </div>
</template>

<script>
import axios from "axios"
export default {
    name:"loginCom",
    data(){
        return{
            username:"",
            password:""
        }
    },
    methods:{
        loginCheck(){
            axios.post('/loginCheck',null,{
                params:{
                    username:this.username,
                    password:this.password
                }
            }).then(response=>{
                if(response.data.result==1){
                    // 登陆成功
                }
            })
        },
        registerUser(){
            this.$router.push('/register')
        },
        back(){
            this.$store.state.business=0
            this.$router.push('/')
        }
    }
}
</script>

<style lang="less" scoped>
.sub-row{
    position: relative;
    width: 300px;
    height: 50px;
    left: 50%;
    margin-left: -150px;
    margin-top: 20px;
    margin-bottom: 20px;
}
.entry-label{
    position: relative;
    display: inline-block;
    width: 50px;
    margin: 3px;
}
.entry-input{
    position: relative;
    display: inline-block;
    width: 220px;
    margin: 3px;
}
#but-row{
    display: flex;
    justify-content: space-around
}
.but{
    position: relative;
    width: 60px;
    height: 30px;
    margin-top: 3px;
    margin-bottom: 3px;
}
</style>
