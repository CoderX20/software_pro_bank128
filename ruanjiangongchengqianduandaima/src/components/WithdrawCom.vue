<template>
    <div id="withdraw-com">
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
                <input type="button" value="注销账户" class="but" @click="del_account">
            </div>
            <div class="entry-row">
                <a class="entry" style="text-align: center;">余额:{{ restMoney }}</a><br>
            </div>
            <div class="entry-row">
                <a>输入取款金额：</a><input type="number" class="entry" v-model="withdrawMoney">
            </div>
            <div class="entry-row">
                <h4 style="color: red;text-align: center;">{{ inputTipStr }}</h4>
            </div>
            <div class="entry-row">
                <input type="button" value="提交" class="but" @click="withdraw_money">
                <input type="button" value="返回" class="but" @click="back">
            </div>
        </div>
    </div>
</template>

<script>
import {mapState} from "vuex"

export default {
    name: 'withdrawCom',
    data() {
        return {
            personal_data: [],
            restMoney: 0,
            withdrawMoney: 0,
            inputTipStr: "",
            selected_row: null,
        }
    },
    methods: {
        clicked(row, event, column) {
            // 点击事件
            this.restMoney = Number(row.money)
            this.selected_row = row
        },
        del_account() {
            if (this.selected_row == null) {
                alert("没有选择账户")
            }
            else {
                // 删除账户，定期或活期
                if (this.selected_row.deposit_class == "定期") {
                    this.$store.dispatch("del_account_regular", { id: this.selected_row.id })
                }
                else {
                    this.$store.dispatch("del_account_current", { id: this.selected_row.id })
                }

            }
            setTimeout(this.get_data,10)
        },
        get_data() {
            this.$store.state.gx.personal_deposit_data=[]
            this.$store.dispatch('get_regular_all', { card_number: this.userInfo.card_number })
            this.$store.dispatch('get_current_all', { card_number: this.userInfo.card_number })
            this.personal_data = []
            this.personal_data = this.$store.state.gx.personal_deposit_data
        },
        withdraw_money(){
            if(this.selected_row==null){
                alert("未选择存款")
                return
            }
            if(this.selected_row.deposit_class=="定期"){
                // 定期取钱删除账户
                this.$store.dispatch("del_account_regular", { id: this.selected_row.id })
            }
            else{
                // 活期取钱
                this.$store.dispatch("withdraw_money_current",{id:this.selected_row.id,money:this.withdrawMoney})
            }
            setTimeout(this.get_data,10)
            this.selected_row=null;
            this.restMoney=0;
            this.withdrawMoney=0;
        },
        back(){
            this.$router.push('/')
        }
    },
    watch: {
        withdrawMoney(newValue, oldValue) {
            if (Number(newValue) > this.restMoney || Number(newValue) < 0) {
                this.inputTipStr = "输入金额错误"
            }
            else {
                this.inputTipStr = ""
            }
        }
    },
    computed: {
        ...mapState({
            userInfo: (state) => {
                if (JSON.stringify(state.gx.user_information) === "{}") {
                    state.gx.user_information = JSON.parse(sessionStorage.getItem("userInfo"))
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
    font-size: 17px;
}
.entry{
    width: 400px;
    height: 30px;
    font-size: 17px;
}
</style>
