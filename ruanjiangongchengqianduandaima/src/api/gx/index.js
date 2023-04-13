//写请求
import requests from "@/api/requests";
export const loginCheck=(params)=>{
    return requests({
        url:"/user",
        method:"GET",
        params
    })
}