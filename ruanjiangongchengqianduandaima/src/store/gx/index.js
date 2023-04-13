//编写vuex
import {loginCheck} from "@/api/gx"//导入请求axios请求
const state={}
const actions={
    async login_check({commit},params){
        var result=await loginCheck(params)
        console.log(result)
        if(result.status==200){
            //登陆成功
        }
        else{
            // 失败
            alert("登陆失败")
        }
    }
}
const mutations={}
const getters={}
export default {state,actions,mutations,getters}