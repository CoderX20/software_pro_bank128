import LoginCom from "@/components/LoginCom";
import BusinessSelectCom from "@/components/BusinessSelectCom";
import RegisterCom from "@/components/RegisterCom";

export default[
    {
        path:'/login',
        name:"Login",
        component:LoginCom
    },
    {
        path:'/businessSelectCom',
        name:"BusinessSelectCom",
        component:BusinessSelectCom
    },
    {
        path:'/register',
        name:"Register",
        component:RegisterCom
    },
    {
        path:'/*',
        redirect:'/businessSelectCom'
    },

]