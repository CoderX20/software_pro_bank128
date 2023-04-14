//编写路由
import DepositCom from "../../components/DepositCom.vue"
import WithdrawCom from "../../components/WithdrawCom.vue"
export default[
{
    path:"/deposit",
    name:"Deposit",
    component:DepositCom

},
{
    path:"/withdraw",
    name:"Withdraw",
    component:WithdrawCom
}
]