import Vue from 'vue'
import App from './App'
import websocket from '@/commons/js/websocket.js'
 
Vue.prototype.$websocket = websocket;
Vue.config.productionTip = false
App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()

export default app

