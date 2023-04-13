import requests from "@/api/requests";

export const requestRegister=(params)=>{
    return requests({
        url:"/user",
        method:"post",
        params
    })
}