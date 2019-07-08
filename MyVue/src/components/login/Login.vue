<template>
    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <h2 class="ui teal image header">
                <img src="../../assets/ico/logo.png" class="image">
                <div class="content">

                </div>
            </h2>
            <form class="ui large form ">
                <div class="ui stacked segment">
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="user icon"></i>
                            <input type="text" name="user" placeholder="邮箱或手机号码" v-model="user"
                                   v-verify.login="user">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="lock icon"></i>
                            <input type="password" name="pas" placeholder="密码" v-model="pas"
                                   v-verify.login="pas">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui checkbox">
                            <input type="checkbox" class="" name="rememb" v-model="rememb">
                            <label @click="">记住密码？</label>
                        </div>
                    </div>
                    <div class="ui fluid large teal submit button" @click.prevent="login">登 录</div>
                </div>
                <div class="ui" style="background-color: #e0b4b4">
                    <ul class="list">
                        <li v-remind="user"></li>
                        <li v-remind="pas"></li>
                    </ul>
                </div>
                <ul></ul>
            </form>
            <div class="ui message">
                已有账号? <a href="#">登 录</a>
            </div>
        </div>
    </div>
</template>

<script>
    import Vue from "vue";
    import verify from "vue-verify-plugin";

    Vue.use(verify, {rules: {}, blur: true});//rules:{}//自定义验证方法 blur:Bool //失去焦点时 是否开启验证
    export default {
        name: "Login",
        data: function () {
            return {
                user: '',
                pas: '',
                rememb: false,
            }
        },
        verify: {
            user: ["required", {minLength: 6, message: "用户名必需≥6位！"}, {maxLength: 20, message: "用户名必需≤20位！"}],
            pas: ["required", {minLength: 6, message: "密码必需≥5位！"}, {maxLength: 15, message: "密码必需≤15位！"}]
        },
        mounted: function () {
            let ut = this.comjs.getcookie('vu');
            if (!!ut) {
                let u = JSON.parse(ut);
                this.user = u.u;
                this.pas = u.p;
                this.rememb = u.r;
            }
        },
        methods: {
            login: function () {
                if (this.$verify.check()) {
                    if (this.rememb) {
                        let u = {u: this.user, p: this.pas, r: this.rememb};
                        this.comjs.setcookie("vu", JSON.stringify(u), "d3");
                    } else {
                        this.comjs.delcookie('vu');
                    }
                    this.$router.push({name: "urlmain"});  //跳转到指定组件
                }
            }
        }
    }
</script>

<style scoped>
    body > .grid {
        height: 100%;
    }

    .image {
        margin-top: -100px;
    }

    .column {
        max-width: 450px;
    }

</style>