<template>
    <Form ref="formmodel" :model="formmodel" :rules="ruleValidate" :label-width="100">
        <Row>
            <Col span="11">
            <FormItem label="权限编号">
                <Input v-model="formmodel.id" :disabled="checkdisable('id')"></Input>
            </FormItem>
            </Col>
            <Col span="7">
            <FormItem label="分组名" prop="groupname">
                <Input v-model="formmodel.groupname" :disabled="checkdisable('groupname')"
                       @on-change="initcheck"></Input>
            </FormItem>
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
        <Button @click='click'>获取</Button>
        </Button>
        <Tree ref='tree' :data="data4" show-checkbox></Tree>
    </Form>

</template>

<script>
    export default {
        name: "FormUserAuthority",
        props: {
            modeldata: {type: Object}
        },
        data: function () {
            return {
                uri: 'usergroup',
                isadd: false,//新增？
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
                },
                data4: [
                    {
                        data: 1,
                        title: 'parent 1',
                        expand: true,
                        children: [
                            {
                                data: 11,
                                title: 'parent 1-1',
                                expand: true,
                                children: [
                                    {
                                        data: 111,
                                        title: 'leaf 1-1-1',
                                        //disabled: true
                                    },
                                    {
                                        data: 112,
                                        title: 'leaf 1-1-2'
                                    }
                                ]
                            },
                            {
                                data: 12,
                                title: 'parent 1-2',
                                expand: true,
                                children: [
                                    {
                                        data: 121,
                                        title: 'leaf 1-2-1',
                                        checked: true
                                    },
                                    {
                                        data: 122,
                                        title: 'leaf 1-2-1'
                                    }
                                ]
                            }
                        ]
                    }
                ]
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
            },
            click: function () {
                let node = this.$refs['tree'].getCheckedAndIndeterminateNodes();
                console.log(node);
            }
        }
    }
</script>

<style scoped>

</style>