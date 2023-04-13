import axios from "axios";

let requests = axios.create({
    baseURL:'http://localhost:8181',
    timeout:5000
})

requests.interceptors.request.use((config)=> {
    return config
})
requests.interceptors.response.use((res)=>{
    return res
},(error)=>{
    return Promise.reject(error)
})
export default requests