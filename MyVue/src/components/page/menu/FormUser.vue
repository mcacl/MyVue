<template>
    <Form ref="formmodel" :model="formmodel" :rules="ruleValidate" :label-width="100">
        <Row>
            <Col span="11">
            <FormItem label="用户名" prop="name">
                <Input v-model="formmodel.name" :disabled="checkdisable('name')"></Input>
            </FormItem>
            </Col>
            <Col span="7">
            <FormItem label="登录名" prop="loginname">
                <Input v-model="formmodel.loginname" :disabled="!isadd" @on-change="initcheck"></Input>
            </FormItem>
            </Col>
            <Col span="4">
            <Button :type="isuse>0?'error':(isuse<0?'success':null)" v-show="isadd" @click="checkuse">
                {{isuse>0?'被使用':(isuse<0?'可用':'验证')}}
            </Button>
            </Col>
            </Button>
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
            <FormItem label="邮箱" prop="email">
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
                            :disabled="checkdisable('latelogintime')"></DatePicker>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="用户组" prop="groupid" :disabled="checkdisable('groupid')">
                <Select v-model="formmodel.groupid" filterable>
                    <Option v-for="item in usergroup" :value="item.groupid" :key="item.groupid">{{ item.groupname}}
                    </Option>
                </Select>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="用户编号">
                <Input v-model="formmodel.userid" placeholder="用户id" :disabled="checkdisable('userid')"></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="是否启用" :disabled="checkdisable('islogin')">
                <Select v-model="formmodel.islogin">
                    <Option :key="1" :value="1">启用</Option>
                    <Option :key="0" :value="0">禁用</Option>
                </Select>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="操作状态">
                <span style="color: red;font-size: 12px;padding: 10px 12px 10px 0px;">{{!!isadd?"新增":"修改"}}</span>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="">
            <FormItem>
                <Button type="primary" @click="saveform('formmodel')">保存</Button>
                <Button style="margin-left: 20px;" @click="deletedata" :disabled="isadd">删除</Button>
            </FormItem>
            </Col>
        </Row>
    </Form>
</template>
</template>

<script>
    export default {
        name: "FormUser",
        props: {
            modeldata: {type: Object},
            isadd: {
                type: Boolean, default() {
                    return false;
                }
            }
        },
        data: function () {
            return {
                uri: 'user',
                isuse: 0,//是否被用
                ischeck: false,//是否验证
                formmodel: {
                    userid: null,
                    name: null,
                    sex: 0,
                    email: null,
                    latelogintime: null,
                    loginname: null,
                    phone: null,
                    islogin: 1,
                    pas: null,
                    groupid: null
                },
                ruleValidate: {
                    name: [
                        {required: true, message: '请输入用户名称', trigger: 'blur'},
                        {type: "string", max: 15, message: "最大15个字符", trigger: 'blur'}
                    ],
                    loginname: [
                        {required: true, type: 'string', message: '请输入登录名', trigger: 'blur'},
                        {type: "string", max: 10, message: "最大10个字符", trigger: 'blur'}
                    ],
                    email: [
                        {type: 'email', message: '邮箱格式错误', trigger: 'blur'},
                        {type: "string", max: 30, message: "最大30个字符", trigger: 'blur'}
                    ],
                    groupid: [
                        {required: true, type: 'number', message: '请选择用户组', trigger: 'change'}
                    ]
                },
                usergroup: []//用户所在用户组
            }
        },
        watch: {
            modeldata: function (val) {
                if (!!val) {
                    this.formmodel = val;
                }
            }
        },
        mounted: function () {
            this.getgroup();
        },
        methods: {
            saveform: function (name) {
                this.$refs[name].validate((valid) => {
                    if (valid && (this.ischeck && this.isadd && this.isuse < 0 || !this.isadd)) {
                        let url = this.uri + '/updatenonull';
                        if (this.isadd) {
                            url = this.uri + '/add';
                        }
                        this.axiospost(url, this.formmodel, this.comback);
                    } else {
                        this.alerterr('填写格式错误或验证登录名失败!');
                    }
                });
            },
            deletedata: function () {
                let self = this;
                if (!this.formmodel.userid) {
                    this.alertwarn('新增数据未保存时不能删除!');
                    return;
                }
                this.comfirmcom('<p>确定删除？</p>', function () {
                    self.axiosget(self.uri + '/delete', {'id': self.formmodel.userid}, self.comback);
                })
            },
            comback: function (response) {
                if (!!response && !!response.data) {
                    this.alertsuces('操作成功!');
                    this.formmodel = {};
                }
                this.$emit('refresh');
            },
            getgroup: function () {
                let self = this;
                this.axiospost('usergroup/list', {isuse: '1'}, function (response) {
                    if (!!response && !!response.data) {
                        self.usergroup = response.data;
                    }
                });
            },
            checkdisable: function (filed) {
                let disable = ['userid', 'latelogintime'];
                if (disable.indexOf(filed) > -1) {
                    return true;
                }
                return false;
            },
            checkuse: function () {
                let self = this;
                if (!!this.formmodel.loginname && this.isuse == 0) {
                    this.axios.post(this.combacksite + this.uri + "/list", {"loginname": this.formmodel.loginname}).then(response => {
                            if (!!response && !!response.data) {
                                self.ischeck = true;
                                if (response.data.length == 0) {
                                    self.isuse = -1;
                                } else {
                                    self.isuse = 1;
                                }
                            }
                        }
                    ).catch(error => {
                        self.alerterr(error);
                    });
                } else {
                    this.alertwarn(this.isuse == 0 ? '请填写登录名' : '已验证!');
                }
            },
            initcheck: function () {
                this.isuse = 0;
                this.ischeck = false;
            }
        }
    }
</script>

<style scoped>

</style>