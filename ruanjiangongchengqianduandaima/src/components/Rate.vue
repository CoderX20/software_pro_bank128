<template>
  <div class="rate_part">
    <div class="container">
      <div class="select">
        <span>存储时间：</span>
        <select ref="select" @change="selectChanged">
          <option v-for="(item,index) in rates" :key="index" value="item.type">{{ item.type }}</option>
        </select>
      </div>
      <div class="rate">
        <span>利率：</span>
        <input type="text" v-model="rate">
      </div>
      <div class="btn">
        <el-button type="primary" round  @click="changeRate">修改利率</el-button>
        <el-button type="primary" round  @click="goBack">返回</el-button>
      </div>

    </div>
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
  name: "Rate",
  data() {
    return {
      rate: 0
    }
  },
  methods: {
    async getAllRate() {
      await this.$store.dispatch("getAllRate")
      this.rate = this.rates[0].rate
    },
    selectChanged() {

      this.rate = this.rates[this.$refs.select.selectedIndex].rate

    },
    async changeRate() {
      const result = await this.$store.dispatch("updateRate", {
        type: this.rates[this.$refs.select.selectedIndex].type,
        rate: this.rate
      })
      if (result === true) {
        await this.getAllRate()
        this.$refs.select.selectedIndex = 0
      }
    },
    goBack(){
      this.$router.push("/businessSelectCom")
    }


  },
  computed: {
    ...mapState({
      rates: (state) => {
        return state.rt.rates
      },

    })
  },
  mounted() {
    this.getAllRate()
  },

}
</script>

<style lang="less" scoped>
.rate_part {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #6495E5;

  .container {
    width: 300px;
    height: 200px;
    background-color: white;
    border-radius: 20px;
    padding-top: 25px;
    div{
      margin-top: 20px;
      margin-left: 50px;
      button{
        width: 40%;
        text-align: center;
      }
    }
  }
}
</style>