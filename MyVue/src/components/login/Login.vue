<template>
    <div style="width: 300px;margin: 18% auto;text-align: center;">
        <Content style="min-height: 200px;">
            <Form ref="us" :model="us" :rules="usrule" action="/login"
                  style="padding: 35px 20px 10px;" :style="comcolor">
                <FormItem prop="loginname">
                    <Input type="text" v-model="us.loginname" placeholder="登录名">
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
                    <!--<Button type="primary" @click.prevent="login" v-on:keyup.enter="login">登 录</Button>-->
                    <Button type="submit" @click.prevent="login" v-on:keyup.enter="login">登 录</Button>
                </FormItem>
            </Form>
        </Content>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data: function () {
            return {
                uri: "login",
                us: {
                    loginname: null,
                    pas: null,
                    rememb: [],
                },
                usrule: {
                    loginname: [
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
            let ut = this.comjs.comgetcookie('vu');
            if (!!ut) {
                let u = JSON.parse(ut);
                this.us.loginname = u.u;
                this.us.pas = u.p;
                this.us.rememb = u.r;
            }
        },
        methods: {
            login: function () {
                let self = this;
                this.$refs["us"].validate((valid) => {
                    if (valid) {
                        let u = {u: this.us.loginname, p: this.us.pas, r: this.us.rememb};
                        self.axiospost(self.uri + "/in", self.us, function (response) {
                            if (!!response && response.data != null) {
                                self.comjs.comsetcookie("vu", JSON.stringify(u), "d3");
                                self.$router.push({name: "urlmain"});  //跳转到指定组件
                            } else {
                                self.$Message.error('用户名或密码错误！');
                                self.comjs.comdelcookie('vu');
                            }
                        });
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>