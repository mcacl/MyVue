import Comjs from "./comjs";
import "./comcss.css";
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
            comtheme: "light",//light 白 dark 黑 primary 蓝
            comcolor: 'white',//"white", //不能用主题的公共背景颜色 黑#515a6e
            combacksite: "/api"//数据请求地址
        }
    },
    methods: {
        //路由
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
        //提示错误
        alerterr: function (msg) {
            this.$Modal.error({title: '错误', content: "<p>" + msg + "</p>"});
        },
        //警告
        alertwarn: function (msg) {
            this.$Modal.warning({title: '警示', content: "<p>" + msg + "</p>"});
        },
        //消息
        alertinfo: function (msg) {
            this.$Modal.info({title: '信息', content: "<p>" + msg + "</p>"});
        },
        //成功
        alertsuces: function (msg) {
            this.$Modal.success({title: '消息', content: "<p>" + msg + "</p>"});
        },
        //请求 post
        /**
         * post请求
         * @param url 请求地址
         * @param data 请求数据 没有 写{}
         * @param callback 成功的回调函数fun(response) response是请求返回值
         * @param head 请求头 默认json {headers: {'Content-Type': 'application/json;charset=utf-8'}}
         */
        axiospost: function (url, data, callback, head) {
            head = !!head ? head : {headers: {'Content-Type': 'application/json;charset=utf-8'}};
            this.axios.post(this.combacksite + url, data, head).then(response => {
                callback(response);
            }).catch(error => {
                this.alerterr(error);
            })
        },
        /**
         * get请求
         * @param url 请求地址
         * @param data 请求数据 没有 写{}
         * @param callback 成功的回调函数fun(response) response是请求返回值
         * @param head 请求头 默认json {headers: {'Content-Type': 'application/json;charset=utf-8'}}
         */
        axiosget: function (url, data, callback, head) {
            head = !!head ? head : {headers: {'Content-Type': 'application/json;charset=utf-8'}};
            this.axios.get(this.combacksite + url, {params: data}, head).then(response => {
                callback(response);
            }).catch(error => {
                this.alerterr(error);
            })
        },
        /**
         *弹出确认提示框
         * @param content 内容 html
         * @param okfun 确定回调
         * @param cancelfun 取消回调 可空
         * @param title 标题 默认 '提示'
         */
        confirmcom: function (content, okfun, cancelfun, title) {
            title = !!title ? title : "提示";
            this.$Modal.confirm({
                title: title,
                content: content,
                onOk: () => {
                    okfun();
                },
                onCancel: () => {
                    if (!!cancelfun)
                        cancelfun();
                }
            });
        },
        /**
         * 获取分页参数
         * @param pagesize 分页大小
         * @param pagenum 当前页码
         * @param model 查询数据的条件实体
         * @returns {{pageSize: *, pageNum: *, model: *}}
         */
        page: function (pagesize, pagenum, model) {
            return {"pageSize": pagesize, "pageNum": pagenum, "model": model};
        }
    }
})

new Vue({
    render: h => h(App),
    router,
    methods: {}
}).$mount('#app')
