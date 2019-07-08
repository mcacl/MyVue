import $ from 'jquery/dist/jquery.min';
import 'semantic-ui-css/semantic.min.css';
import 'semantic-ui-css/semantic.min';
import Comjs from "./comjs";
import Vue from 'vue';
import router from './router.js';
import App from './App.vue';

Vue.config.performance = false;//是否生产环境
Vue.config.productionTip = false;//是否阻止启东市生成提示
Vue.config.devtools = true;//允许dev-tool检查代码
Vue.prototype.$ = $;
Vue.prototype.comjs = Comjs;
new Vue({
    render: h => h(App),
    router,
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
        }
    }
}).$mount('#app')
