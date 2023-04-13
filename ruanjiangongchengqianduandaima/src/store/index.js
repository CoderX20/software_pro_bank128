import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

import rt from "./rt"
import gx from "./gx"

export default new Vuex.Store({modules:{rt,gx}})