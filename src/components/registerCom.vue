<template>
    <div id="register-com">
        <div class="entry-row">
            <a class="entry-label">用户名</a><input type="text" class="entry" v-model="username"><br>
        </div>        
        <div class="entry-row">
            <a class="entry-label">身份证号</a><input type="text" class="entry" v-model="card_number"><br>
        </div>
        <div class="entry-row">
            <a class="entry-label">电话号码</a><input type="text" class="entry" v-model="phone_number"><br>
        </div>
        <div class="entry-row">
            <a class="entry-label">住址</a><input type="text" class="entry" v-model="address"><br>
        </div>
        <div class="entry-row">
            <a class="entry-label">密码</a><input type="text" class="entry" v-model="password_first"><br>
        </div>
        <div class="entry-row">
            <a class="entry-label">密码(重复)</a><input type="text" class="entry" v-model="password_second"><br>
        </div>
        <div class="entry-row" id="input-tip">
            <a>{{ inputTipStr }}</a>
        </div>
        <div class="entry-row" id="buts-row">
            <input type="button" value="注册" class="but" @click="register_user">
            <input type="button" value="返回" class="but" @click="back">
        </div>
    </div>
</template>

<script>
export default {
    name:"registerCom",
    data(){
        return{
            username:"",
            card_number:"",
            phone_number:"",
            address:"",
            password_first:"",
            password_second:"",
            inputTipStr:""
        }
    },
    methods:{
        register_user(){
            if(this.username==""){
                alert("用户名不能为空")
            }
            else if(this.card_number==""){
                alert("身份证号不能为空")
            }
            else if(this.phone_number==""){
                alert("电话号码不能为空")
            }
            else if(this.address==""){
                alert("住址不能为空")
            }
            else if(this.password_first==""||this.password_second==""){
                alert("密码输入错误")
            }
            else{
                //注册
            }
        },
        back(){
            this.$router.push("/")
        }
    },
    watch:{
        password_first(newPwd,oldPwd){
            if(newPwd!=password_second){
                this.inputTipStr="两次密码不同"
            }
            else{
                this.inputTipStr=""
            }
        },
        password_second(newPwd,oldPwd){
            if(newPwd!=this.password_first){
                this.inputTipStr="两次密码不同"
            }
            else{
                this.inputTipStr=""
            }
        }
    }
}
</script>

<style lang="less" scoped>
.entry-row{
    position: relative;
    width: 300px;
    margin: 3px;
    left: 50%;
    margin-left: -150px;
}
.entry-label{
    display: inline-block;
    width: 80px;
    margin: 5px;
}
.entry{
    width: 200px;
    margin: 5px;
}
#input-tip{
    text-align: center;
    font-size: 14px;
    color: red;
}
#buts-row{
    display: flex;
    justify-content: space-around;
}
.but{
    width: 60px;
    height: 30px;
}
</style>

