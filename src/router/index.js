import Vue from 'vue'
import VueRouter from 'vue-router'
import BusinessSelectView from "../views/BusinessSelectView.vue"
import LoginView from "../views/LoginView.vue"
import RegisterView from "../views/RegisterView.vue"

Vue.use(VueRouter)

const routes = [ 
  {
    path:'/',
    name:"BusinessSelect",
    components:{
      showPlace:BusinessSelectView
    }
  },
  {
    path:"/login",
    name:"Login",
    components:{
      showPlace:LoginView
    }
  },
  {
    path:'/register',
    name:"Register",
    components:{
      showPlace:RegisterView
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
