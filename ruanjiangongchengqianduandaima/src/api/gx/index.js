//写请求
import requests from "@/api/requests";
export const loginCheck=(params)=>{
    return requests({
        url:"/user",
        method:"GET",
        params
    })
}
// 更新活期存款
export const updateDeposit_current=(params)=>{
    return requests({
        url:"/huoqi/deposit",
        method:"POST",
        params
    })
}
// 提交新的活期存款
export const subNewDeposit_current=(params)=>{
    return requests({
        url:"/huoqi/createNew",
        method:"POST",
        params
    })
}
// 提交新的定期存款
export const subNewDeposit_Regular=(params)=>{
    return requests({
        url:"/dingqi/create",
        method:"POST",
        params
    })
}
// 获取所有定期数据
export const getRegular_all=(params)=>{
    return requests({
        url:"/dingqi/getAll",
        method:"GET",
        params
    })
}
// 获取所有活期数据
export const getCurrent_all=(params)=>{
    return requests({
        url:"/huoqi/getAll",
        method:"GET",
        params
    })
}
// 删除定期账户
export const delAccount_regular=(params)=>{
    return requests({
        url:"/dingqi/delete",
        method:"POST",
        params
    })
}
// 删除活期账户
export const delAccount_current=(params)=>{
    return requests({
        url:"/huoqi/delete",
        method:"POST",
        params
    })
}
// 活期取钱
export const withdrawMoney_current=(params)=>{
    return requests({
        url:"/huoqi/withdrawal",
        method:"POST",
        params
    })
}