
import {requestRegister} from "@/api/rt"
const state={}
const actions={
    async getRegister({commit},params){
        const result = await requestRegister(params)
        if(result.data.status===200){
            alert("注册成功")
            return true
        }else{
            if(result.data.message===""){
                alert("注册失败")
            }else{
                alert(result.data.message)
            }
            return false
        }
    }
}
const mutations={}
const getters={}
export default {state,actions,mutations,getters}