<template>
    <div id="deposit-com">
        <div id="container">
          <h1>存款</h1>
            <div class="entry-row">
                <el-table :data="personal_data"
                          @row-click="clicked"
                          max-height="340px"
                          :row-style="clickClass"
                          style="font-size: 17px;">
<!--                <el-table-column label="ID" property="id" width="100"></el-table-column>-->
                <el-table-column label="卡号" property="card_number" align="center" width="100px"></el-table-column>
                <el-table-column label="存款金额" property="money" align="center" width="150px"></el-table-column>
                <el-table-column label="存款时间" property="period" align="center" width="150px"></el-table-column>
                <el-table-column label="存款类型" property="deposit_class" align="center" width="150px"></el-table-column>
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
                <span>输入存款金额</span><input type="number" class="entry" id="money-entry" v-model="money">
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

            ],
          selectRowID:"-1",
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
            // console.log(event ,"event")
            // console.log(column)
          this.personal_data.map((item,index)=>{
            if(JSON.stringify(item)===JSON.stringify(row)){
              this.selectRowID=index
            }
          })
          // console.log(this.selectRowID)
            this.selected_row=row
            this.isNew=false
            this.isRegular=false
            this.restMoney=Number(this.selected_row.money)
        },
      clickClass({row,rowIndex}){
        if(rowIndex===this.selectRowID){

          return {"background-color": "#dcdcdc"}
        }

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
            this.$router.push('/businessSelectCom')
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
    mounted(){
        this.$store.state.gx.personal_deposit_data=[]
        this.get_data()
    },


}
</script>

<style lang="less" scoped>
#deposit-com{
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  //background-color: #FFF031;
  background-color: #6495E5;

}
#container{
  padding-top: 20px;
    width: 1000px;
  border-radius: 20px;

  h1{
    text-align: center;
    color: white;
    letter-spacing: 10px;
    margin-bottom: 50px;
    font-size: 40px;
  }
}
.entry-row{
    width: 950px;
    margin: 10px;
    display: flex;
    justify-content: center;
  span{
    color: white;
    line-height: 30px;
    margin-right: 10px;
  }
  input{
    padding-left: 10px;
  }
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
.el-table{
  flex: none;
  width: 70%;
  border-radius: 15px;
}
.selectStyle{
  background-color: #ac2c2c;
}
</style>

