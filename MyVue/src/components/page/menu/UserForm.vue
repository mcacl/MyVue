<template>
    <Form ref="formmodel" :model="formmodel" :rules="ruleValidate" :label-width="100">
        <Row>
            <Col span="11">
            <FormItem label="用户名" prop="name">
                <Input v-model="formmodel.name" :disabled="checkdisable('name')"></Input>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="登录名" prop="loginname">
                <Input v-model="formmodel.loginname" :disabled="checkdisable('loginname')"></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="性别" :disabled="checkdisable('sex')">
                <Select v-model="formmodel.sex">
                    <Option :key="0" :value="0">女</Option>
                    <Option :key="1" :value="1">男</Option>
                </Select>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="邮箱">
                <Input v-model="formmodel.email" placeholder="邮箱" :disabled="checkdisable('email')"></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="电话" prop="phone">
                <Input v-model="formmodel.phone" placeholder="电话" :disabled="checkdisable('phone')"></Input>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="最近登录" prop="">
                <DatePicker type="datetime" v-model="formmodel.latelogintime" style="width: 200px;"
                            :disabled="checkdisable('time')"></DatePicker>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="是否可用" :disabled="checkdisable('islogin')">
                <Select v-model="formmodel.islogin">
                    <Option :key="1" :value="1">启用</Option>
                    <Option :key="0" :value="0">禁用</Option>
                </Select>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="用户id">
                <Input v-model="formmodel.userid" placeholder="用户id" :disabled="checkdisable('userid')"></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="">
            <FormItem>
                <Button type="primary" @click="savemenu('formmodel')">保存菜单</Button>
                <Button style="margin-left: 20px;" @click="deletemenu" :disabled="isdelete()">删除菜单</Button>
            </FormItem>
            </Col>
        </Row>
    </Form>
</template>

<script>
    export default {
        name: "UserForm",
        props: {
            modeldata: {},
            isadd: Boolean
        },
        data: function () {
            return {
                uri: 'user/',
                formmodel: {
                    userid: null,
                    name: null,
                    sex: 0,
                    email: null,
                    latelogintime: null,
                    loginname: null,
                    phone: null,
                    islogin: 1,
                    pas: ""
                },
                ruleValidate: {
                    name: [
                        {required: true, message: '请输入用户名称', trigger: 'blur'},
                        {type: "string", max: 15, message: "最大15个字符", trigger: 'blur'}
                    ],
                    loginname: [
                        {required: true, message: '请输入登录名', trigger: 'blur'},
                        {type: "string", max: 10, message: "最大10个字符", trigger: 'blur'}
                    ],
                    email: [
                        {type: 'email', message: '邮箱格式错误', trigger: 'blur'},
                        {type: "string", max: 30, message: "最大30个字符", trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            saveform: function (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        let url = this.uri + 'updatenonull';
                        if (this.isadd) {
                            url = this.uri + '/add';
                        }
                        this.axiospost(url, this.formmodel, this.commenuback);
                    } else {
                        this.alerterr('请按要求填写!');
                    }
                });
            },
            delete: function () {
                let self = this;
                if (!this.formmodel.menuid) {
                    this.alertwarn('新增数据未保存时不能删除!')
                    return;
                }
                this.confirmcom('<p>确定删除？</p>', function () {
                    self.axiospost(self.uri + '/delete', self.formmodel, self.commenuback);
                })
            },
            comback: function (response) {
                if (!!response && !!response.data) {
                    this.alertsuces('操作成功!');
                }
                this.$emit('refresh');
            },
            checkdisable: function (filed) {
                let disable = ['userid', 'latelogintime'];
                if (disable.indexOf(filed) > -1) {
                    return true;
                }
                return false;
            }
        }
    }
</script>

<style scoped>

</style>