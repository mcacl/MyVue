import Comjs from "./comjs";
import Vue from 'vue';
import router from './router.js';
import App from './App.vue';
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import axios from 'axios';

Vue.use(iView);

Vue.config.performance = false;//是否生产环境
Vue.config.productionTip = false;//是否阻止启东市生成提示
Vue.config.devtools = true;//允许dev-tool检查代码

Vue.prototype.comjs = Comjs;
Vue.prototype.axios = axios;

Vue.mixin({
    created: function () {
    },
    data: function () {
        return {
            comtheme: "primary",//light 白 dark 黑 primary 蓝
            comcolor: "white", //不能用主题的公共背景颜色
            combacksite: "/api"//数据请求地址
        }
    },
    methods: {
        tologin: function () {
            this.$router.push({name: "urllogin"});  //跳转到指定组件 登录
        },
        tomain: function () {
            this.$router.push({name: "urlmain"});  //跳转到指定组件
        },
        //使用路由返回上一级
        toback: function () {
            window.history.length > 1 ? this.$router.go(-1) : this.$router.push({name: "urlmain"});
        },
        alerterr: function (msg) {
            this.$Modal.error({title: '错误', content: "<p>" + msg + "</p>"});
        },
        alertwarn: function (msg) {
            this.$Modal.warning({title: '警示', content: "<p>" + msg + "</p>"});
        },
        alertinfo: function (msg) {
            this.$Modal.info({title: '信息', content: "<p>" + msg + "</p>"});
        },
        alertsuces: function (msg) {
            this.$Modal.success({title: '消息', content: "<p>" + msg + "</p>"});
        }
    }
})

new Vue({
    render: h => h(App),
    router,
    methods: {}
}).$mount('#app')
