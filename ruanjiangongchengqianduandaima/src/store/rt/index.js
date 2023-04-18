
import {requestRegister,requestGetAllRate,requestUpdateRate,requestOneDingqi,requestOneHuoqi} from "@/api/rt"
const state={
    rates:[],
    huoqi:{},
    dingqi:{}
}
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
    },
    async getAllRate({commit}){
      const result = await requestGetAllRate()
        if(result.status===200&&result.data.status===200&&result.data.data.length!==0){
            commit("GETALLRATE",result.data.data)
        }else{
            alert("利率获取失败")
        }
    },
    async updateRate({commit},params){
        const result = await requestUpdateRate(params)
        if(result.status===200&&result.data.status===200){
            alert(result.data.data)
            return true
        }
        else{
            alert("更新失败")
            return false
        }
    },
    async getOneDingqi({commit},params){
        const result = await requestOneDingqi(params)
        if(result.data.status===200){
            commit("GETONEDINGQI",result.data.data)
            return true
        }
        else{
            alert(result.data.message)
            return false
        }
    },
    async getOneHuoqi({commit},params){
        const result = await requestOneHuoqi(params)
        if(result.data.status===200){
                commit("GETONEHUOQI",result.data.data)
            return true
        }
        else{
            alert(result.data.message)
            return false
        }
    }
}
const mutations={
    GETALLRATE(state,data){
        state.rates=data
    },
    GETONEDINGQI(state,data){
        state.dingqi=data;
        console.log(state.dingqi)
    },
    GETONEHUOQI(state,data){
        state.huoqi=data

    }
}
const getters={}
export default {state,actions,mutations,getters}