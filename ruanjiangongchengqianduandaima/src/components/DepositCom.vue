<template>
    <div id="deposit-com">
        <div class="row">
            <el-table :data="table_data">
                <el-table-column property="id" label="ID" width="50"></el-table-column>
                <el-table-column property="card_number" label="卡号" width="100"></el-table-column>
                <el-table-column property="money" label="存款" width="100"></el-table-column>
                <el-table-column property="period" label="存款时间" width="100"></el-table-column>
                <el-table-column property="deposit_class" label="存款类型" width="100"></el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
export default {
    name:"depositCom",
    components:{
    },
    data(){
        return{
            table_data:[]
        }
    },
    mounted(){}
}
</script>

<style lang="less" scoped>

</style>
