<template>
    <div style="width: 300px;margin: 18% auto;text-align: center;">
        <Content style="min-height: 200px;">
            <Form ref="us" :model="us" :rules="usrule"
                  style="padding: 35px 20px 10px;" :style="comcolor">
                <FormItem prop="user">
                    <Input type="text" v-model="us.user" placeholder="用户名">
                    <Icon type="ios-person-outline" slot="prepend"></Icon>
                    </Input>
                </FormItem>
                <FormItem prop="pas">
                    <Input type="password" v-model="us.pas" placeholder="密码">
                    <Icon type="ios-lock-outline" slot="prepend"></Icon>
                    </Input>
                </FormItem>
                <FormItem>
                    <CheckboxGroup v-model="us.rememb">
                        <Checkbox label="记住密码？"></Checkbox>
                    </CheckboxGroup>
                </FormItem>
                <FormItem>
                    <Button type="primary" @click.prevent="login" v-on:keyup.enter="login">登 录</Button>
                </FormItem>
            </Form>
        </Content>
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
                us: {
                    user: '',
                    pas: '',
                    rememb: [],
                },
                usrule: {
                    user: [
                        {required: true, message: '请输入用户名!', trigger: 'blur'},
                        {type: 'string', min: 4, message: '用户名最少4位!', trigger: 'blur'},
                        {type: 'string', max: 10, message: '用户名最多10位!', trigger: 'blur'}
                    ],
                    pas: [
                        {required: true, message: '请输入密码!', trigger: 'blur'},
                        {type: 'string', min: 6, message: '密码最少6位!', trigger: 'blur'},
                        {type: 'string', max: 10, message: '密码最多10位!', trigger: 'blur'}
                    ]
                }
            }
        },
        mounted: function () {
            let ut = this.comjs.getcookie('vu');
            if (!!ut) {
                let u = JSON.parse(ut);
                this.us.user = u.u;
                this.us.pas = u.p;
                this.us.rememb = u.r;
            }
        },
        methods: {
            login: function () {
                /*if (this.$verify.check()) {
                    if (this.rememb) {
                        let u = {u: this.user, p: this.pas, r: this.rememb};
                        this.comjs.setcookie("vu", JSON.stringify(u), "d3");
                    } else {
                        this.comjs.delcookie('vu');
                    }
                    this.$router.push({name: "urlmain"});  //跳转到指定组件
                }*/
                this.$refs["us"].validate((valid) => {
                    if (valid) {
                        let u = {u: this.us.user, p: this.us.pas, r: this.us.rememb};
                        this.comjs.setcookie("vu", JSON.stringify(u), "d3");
                        this.$router.push({name: "urlmain"});  //跳转到指定组件
                    } else {
                        this.$Message.error('用户名或密码错误！');
                        this.comjs.delcookie('vu');
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>