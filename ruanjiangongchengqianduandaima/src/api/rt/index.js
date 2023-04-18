import requests from "@/api/requests";

export const requestRegister=(params)=>{
    return requests({
        url:"/user",
        method:"post",
        params
    })
}
export const requestGetAllRate=()=>{
    return requests({
        url:"/rate/getAll",
        method:"get"

    })
}
export const requestUpdateRate=(params)=>{
    return requests({
        url:"/rate/update",
        method:"post",
        params
    })
}
export const requestOneDingqi=(params)=>{
    return requests({
        url:"/dingqi/getOne",
        method:"get",
        params
    })
}
export const requestOneHuoqi=(params)=>{
    return requests({
        url:"/huoqi/getOne",
        method:"get",
        params
    })
}
