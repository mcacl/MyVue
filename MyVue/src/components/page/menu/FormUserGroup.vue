<template>
    <Form ref="formmodel" :model="formmodel" :rules="ruleValidate" :label-width="100">
        <Row>
            <Col span="11">
            <FormItem label="分组编号">
                <Input v-model="formmodel.groupid" :disabled="checkdisable('groupid')"></Input>
            </FormItem>
            </Col>
            <Col span="7">
            <FormItem label="分组名" prop="groupname">
                <Input v-model="formmodel.groupname" :disabled="checkdisable('groupname')"
                       @on-change="initcheck"></Input>
            </FormItem>
            </Col>
            <Col span="4">
            <Button :type="isuse>0?'error':(isuse<0?'success':null)" v-show="isadd" @click="checkuse">
                {{isuse>0?'被使用':(isuse<0?'可用':'验证')}}
            </Button>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="是否启用" :disabled="checkdisable('isuse')">
                <Select v-model="formmodel.isuse">
                    <Option :key="1" :value="1">启用</Option>
                    <Option :key="0" :value="0">禁用</Option>
                </Select>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="创建时间" prop="">
                <DatePicker type="datetime" v-model="formmodel.createtime" style="width: 200px;"
                            :disabled="checkdisable('createtime')"></DatePicker>
            </FormItem>
            </Col>
        </Row>
        <Row>
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
        name: "FormUserGroup",
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
                uri: 'usergroup',
                isuse: 0,//是否被用
                ischeck: false,//是否验证
                formmodel: {
                    groupid: null,
                    groupname: null,
                    menuid: null,
                    createtime: null,
                    isuse: 1
                },
                ruleValidate: {
                    groupname: [
                        {required: true, message: '请输入用户组名称', trigger: 'blur'},
                        {type: "string", max: 10, message: "最大10个字符", trigger: 'blur'}
                    ]
                }
            }
        },
        watch: {
            modeldata: function (val) {
                if (!!val) {
                    this.formmodel = val;
                }
            }
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
                        this.alerterr('填写格式错误或验证失败!');
                    }
                });
            },
            deletedata: function () {
                let self = this;
                if (!this.formmodel.groupid) {
                    this.alertwarn('新增数据未保存时不能删除!');
                    return;
                }
                this.confirmcom('<p>确定删除？</p>', function () {
                    self.axiosget(self.uri + '/delete', {'id': self.formmodel.groupid}, self.comback);
                })
            },
            comback: function (response) {
                if (!!response && !!response.data) {
                    this.alertsuces('操作成功!');
                    this.formmodel = {};
                }
                this.$emit('refresh');
            },
            checkdisable: function (filed) {
                let disable = ['groupid', 'menuid', 'createtime'];
                if (disable.indexOf(filed) > -1) {
                    return true;
                }
                return false;
            },
            checkuse: function () {
                let self = this;
                if (!!this.formmodel.groupname && this.isuse == 0) {
                    this.axios.post(this.combacksite + this.uri + "/list", {"groupname": this.formmodel.groupname}).then(response => {
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
                    this.alertwarn(this.isuse == 0 ? '请填写分组名' : '已验证!');
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