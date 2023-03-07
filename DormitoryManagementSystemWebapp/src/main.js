import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './assets/css/global.css'
import axios from 'axios'
import './plugins/element.js'
/* 配置请求的根路径 */
axios.defaults.baseURL = '/api/dms';
/* 为请求头添加跨域访问权限 */
axios.defaults.headers = { 'Access-Control-Allow-Origin': '*' };
/* 为请求头重添加token令牌 */
axios.interceptors.request.use(config => {
   // console.log(config);
   config.headers.Authorization = window.sessionStorage.getItem('token');
   return config;
});
Vue.prototype.$http = axios;
Vue.config.productionTip = false;

new Vue({
   router,
   render: h => h(App)
}).$mount('#app');
