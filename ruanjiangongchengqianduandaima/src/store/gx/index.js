//编写vuex
import {loginCheck,updateDeposit_current,subNewDeposit_current,subNewDeposit_Regular,getRegular_all,getCurrent_all} from "@/api/gx"//导入请求axios请求
const state={
    user_information:{
        // 用户信息
    },
    personal_deposit_data:[],
}
const actions={
    async login_check({commit},params){
        var result=await loginCheck(params)

        // console.log(result)
        if(result.data.status==200){
            //登陆成功
            commit('set_user_information',result.data.data)
            return true
        }
        else if(result.data.status==5002){
            alert(result.data.message)
        }
        else{
            // 失败
            alert("登陆失败")
        }
        return false
    },
    // 更新旧的活期存款
    async update_deposit_current({commit},params){
        var result=await updateDeposit_current(params)
        if(result.data.status==200){
            // 操作成功
            alert("操作成功")
        }
        else{
            alert(result.data.message)
        }
    },
    // 新建新的活期存款
    async sub_new_deposit_current({commit},params){
        var result=await subNewDeposit_current(params)
        if(result.data.status==200){
            // 操作成功
            alert("操作成功")
        }
        else{
            alert(result.data.message)
        }
    },
    // 新建新的定期存款
    async sub_new_deposit_regular({commit},params){
        var result=await subNewDeposit_Regular(params)
        if(result.data.status==200){
            // 操作成功
            alert("操作成功")
        }
        else{
            alert(result.data.message)
        }
    },
    // 获取所有定期数据
    async get_regular_all({commit},params){
        var result=await getRegular_all(params)
        if(result.data.status==200){
            // 操作成功
            commit('add_personal_deposit_data_regular',result.data.data)
        }
        else{
            alert(result.data.message)
        }
    },
    // 获取所有活期数据
    async get_current_all({commit},params){
        var result=await getCurrent_all(params)

        if(result.data.status==200){
            // 操作成功
            commit('add_personal_deposit_data_current',result.data.data)
        }
        else{
            alert(result.data.message)
        }
    }
}
const mutations={
    set_user_information(state,params){
        const data = JSON.stringify(params)
        //将数据先保存到sessionStorage中
        sessionStorage.setItem("userInfo",data)

        state.user_information=params
    },
    // 活期存款信息录入
    add_personal_deposit_data_current(state,params){
        // console.log(params)
        for(var el in params){
            // console.log(el)
            state.personal_deposit_data.push({
                id:params[el].id,
                card_number:params[el].card_number,
                money:params[el].money,
                period:"",
                deposit_class:""
            })
        }
    },
    // 定期存款信息录入
    add_personal_deposit_data_regular(state,params){
        for(var el in params){
            state.personal_deposit_data.push({
                id:params[el].id,
                card_number:params[el].card_number,
                money:params[el].money,
                period:params[el].period,
                deposit_class:"定期"
            })
        }
    }
}
const getters={}
export default {state,actions,mutations,getters}