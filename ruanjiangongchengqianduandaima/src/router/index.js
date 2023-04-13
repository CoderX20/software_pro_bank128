import Vue from 'vue'
import VueRouter from "vue-router"
Vue.use(VueRouter)
let originPush=VueRouter.prototype.push;
let originReplace = VueRouter.prototype.replace;
VueRouter.prototype.push=function (location,resolve,reject){
    if(resolve&&reject){
        originPush.call(this,location,resolve,reject)
    }
    else{
        originPush.call(this,location,()=>{},(error)=>{})
    }
}
VueRouter.prototype.replace=function (location,resolve,reject){
    if(resolve&&reject){
        originReplace.call(this,location,resolve,reject)
    }else{
        originReplace.call(this,location,()=>{},(error)=>{})
    }
}


import rt from "./rt"
import gx from "./gx"


export default new VueRouter({
    mode:"history",
    routes:[].concat(gx,rt)
})
