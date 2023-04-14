<template>
    <div id="deposit-com">
        <div id="container">
            <div class="entry-row">
                <el-table :data="personal_data" @row-click="clicked" style="font-size: 17px;">
                <el-table-column label="ID" property="id" width="100"></el-table-column>
                <el-table-column label="卡号" property="card_number" width="200"></el-table-column>
                <el-table-column label="存款金额" property="money" width="200"></el-table-column>
                <el-table-column label="存款时间" property="period" width="200"></el-table-column>
                <el-table-column label="存款类型" property="deposit_class" width="200"></el-table-column>
                </el-table>
            </div>
            <div class="entry-row">
                <!-- <input type="button" value="选择存款" class="but" @click="select_deposit">
                <input type="button" value="取消选择" class="but" @click="select_deposit_cancel"> -->
                <input type="button" value="新增存款" class="but" @click="create_new_deposit">
            </div>
            <div class="entry-row" v-show="isNew">
                <el-select v-model="deposit_class_new" @change="deposit_class_change" class="entry">
                    <el-option
                    v-for="item in deposit_class_list"
                    :key="item.value"
                    :label="item.label"
                    :value="item.label"></el-option>
                </el-select>
            </div>
            <div class="entry-row" v-show="isNew && isRegular">
                <el-select v-model="deposit_period" class="entry">
                    <el-option
                    v-for="item in deposit_period_list"
                    :key="item.value"
                    :label="item.label"
                    :value="item.label"></el-option>
                </el-select>
            </div>
            <div class="entry-row">
                <h4 style="text-align: center;">存款余额:{{ restMoney }}</h4>
            </div>
            <div class="entry-row">
                <a>输入存款金额</a><input type="number" class="entry" id="money-entry" v-model="money">
            </div>
            <div class="entry-row">
                <h4 style="color:red;text-align: center;">{{ inputTipStr }}</h4>
            </div>
            <div class="entry-row">
                <input type="button" value="提交" class="but" @click="sub_new_deposit">
                <input type="button" value="返回" class="but" @click="back">
            </div>
        </div>
    </div>
</template>

<script>
import {mapState} from "vuex"
export default {
    name:"depositCom",
    data(){
        return{
            personal_data:[
                // {
                //     id:1,
                //     card_number:"1233",
                //     money:'3445',
                //     period:"3 Year",
                //     deposit_class:"定期"
                // },
                // {
                //     id:2,
                //     card_number:"1233",
                //     money:'35',
                //     period:"3 Year",
                //     deposit_class:"定期"
                // }
            ],
            // 是否为新增的业务
            isNew:false,
            // 是否为定期
            isRegular:false,
            deposit_class_new:"",
            deposit_class_list:[
                {
                    value:1,
                    label:"活期"
                },
                {
                    value:2,
                    label:"定期"
                }
            ],
            deposit_period:"",
            deposit_period_list:[
                {
                    value:1,
                    label:"3个月"
                },
                {
                    value:2,
                    label:"6个月"
                },
                {
                    value:3,
                    label:"1年"
                },
                {
                    value:4,
                    label:"3年"
                },
                {
                    value:5,
                    label:"5年"
                }
            ],
            selected_row:null,
            money:0,
            restMoney:0,
            inputTipStr:"",
        }
    },
    methods:{
        clicked(row,event,column){
            // console.log(row)
            // console.log(event)
            // console.log(column)
            this.selected_row=row
            this.isNew=false
            this.isRegular=false
            this.restMoney=Number(this.selected_row.money)
        },
        deposit_class_change(){
            if(this.deposit_class_new=="定期"){
                this.isRegular=true
            }
            else{
                this.isRegular=false
            }
            // console.log(this.isNew,this.isRegular,this.deposit_class_new)
        },
        create_new_deposit(){
            this.isNew=true
        },
        select_deposit(){
            this.isNew=false
            this.isRegular=false
            this.restMoney=Number(this.selected_row.money)
        },
        select_deposit_cancel(){
            // 取消选择
            this.money=0
            this.selected_row=null
        },
        sub_new_deposit(){
            // 提交新的存款
            if(this.isNew==false){
                // 提交旧信息
                this.$store.dispatch('update_deposit_current',{id:this.selected_row.id,money:this.money})
            }
            else{
                // 提交新存款
                if(this.isRegular==true){
                    // 定期
                    this.$store.dispatch('sub_new_deposit_regular',{card_number:this.$store.state.gx.user_information.card_number,money:this.money,period:this.deposit_period})
                }
                else{
                    // 活期
                    console.log(this.$store)
                    this.$store.dispatch('sub_new_deposit_current',{cardNumber:this.$store.state.gx.user_information.card_number,money:this.money})
                }
            }
            this.$store.state.gx.personal_deposit_data=[]
            setTimeout(this.get_data,10)
        },
        back(){
            this.$router.push('/login')
        },
        get_data(){
            this.$store.dispatch('get_regular_all', {card_number: this.userInfo.card_number})
            this.$store.dispatch('get_current_all', {card_number: this.userInfo.card_number})
            this.personal_data=[]
            this.personal_data = this.$store.state.gx.personal_deposit_data
        }
    },
    watch:{
        money(newValue,oldValue){
            if(Number(newValue)<0){
                this.inputTipStr="金额输入错误"
            }
            else{
                this.inputTipStr=""
            }
        }
    },
    mounted(){
        this.$store.state.gx.personal_deposit_data=[]
        this.get_data()
    },
    computed:{
    ...mapState({
      userInfo:(state)=>{
        if(JSON.stringify(state.gx.user_information)==="{}"){
          state.gx.user_information=JSON.parse(sessionStorage.getItem("userInfo"))
        }
        return state.gx.user_information
      }
    })
  },
}
</script>

<style lang="less" scoped>
#container{
    position: relative;
    left: 50%;
    margin-left: -500px;
    display: flex;
    width: 1000px;
    background-color: #6495E5;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
}
.entry-row{
    width: 950px;
    margin: 10px;
    display: flex;
    justify-content: center;
}
.but{
    width: 150px;
    height: 30px;
    margin: 20px;
}
.entry{
    width: 400px;
    height: 30px;
}
</style>
