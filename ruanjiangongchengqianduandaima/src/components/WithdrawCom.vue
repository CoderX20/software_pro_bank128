<template>
    <div id="withdraw-com">
        <div id="container">
            <div class="entry-row">
                <elt-table :data="personal_data" @row-click="clicked">
                    <el-table-column label="ID" property="id" width="100"></el-table-column>
                    <el-table-column label="卡号" property="card_number" width="200"></el-table-column>
                    <el-table-column label="存款金额" property="money" width="200"></el-table-column>
                    <el-table-column label="存款时间" property="period" width="200"></el-table-column>
                    <el-table-column label="存款类型" property="deposit_class" width="200"></el-table-column>
                </elt-table>
            </div>
            <div class="entry-row">
                <input type="button" value="取款" class="but">
            </div>
            <div class="entry-row">
                <a class="entry">余额:{{ restMoney }}</a><br>
                <input type="number" class="entry" v-model="withdrawMoney">
            </div>
            <div class="entry-row">
                <h4 style="color: red;text-align: center;">{{ inputTipStr }}</h4>
            </div>
            <div class="entry-row">
                <input type="button" value="提交" class="but">
                <input type="button" value="返回" class="but">
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name:'withdrawCom',
    data(){
        return{
            personal_data:[],
            restMoney:0,
            withdrawMoney:0,
            inputTipStr:""
        }
    },
    methods:{
        clicked(row,event,column){
            // 点击事件
        },
    }
}
</script>

<style lang="less" scoped>

</style>
