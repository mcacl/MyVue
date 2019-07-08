import Vue from 'vue'
import VueRouters from 'vue-router';
import Login from './components/login/Login.vue';
import Main from './components/main/Main.vue';

import Error from './components/error/Error.vue';

Vue.use(VueRouters);

const router = new VueRouters({
    mode: 'history',
    routes: [
        {path: '/', redirect: {name: 'urllogin'}},//默认路由 放在第一个
        {path: '/error', name: 'urlerror', component: Error},
        {path: '/login', name: 'urllogin', component: Login},
        {path: '/main', name: 'urlmain', component: Main},

        {path: '**', redirect: 'urlerror'}//这个就是错误路由匹配， vue规定这个必须放在最下面，它必须将上面的路由全找一遍，找不到才用当前这个
    ]
});
export default router