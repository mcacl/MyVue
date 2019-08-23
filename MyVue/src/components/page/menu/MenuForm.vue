<template>
    <Form ref="formmodel" :model="formmodel" :rules="ruleValidate" :label-width="100">
        <Row>
            <Col span="11">
            <FormItem label="菜单id">
                <Input v-model="formmodel.menuid" :disabled="checkdisable('menuid')"></Input>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="父菜单id">
                <Input v-model="formmodel.pid" :disabled="checkdisable('pid')"></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="菜单名称" prop="name">
                <Input v-model="formmodel.name" placeholder="菜单名称" :disabled="checkdisable('name')"></Input>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="跳转页">
                <Input v-model="formmodel.component" placeholder="菜单跳转页" :disabled="checkdisable('component')"></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="图标" prop="">
                <Input v-model="formmodel.icon" placeholder="菜单图标名称" :disabled="checkdisable('time')"></Input>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="菜单顺序" prop="">
                <InputNumber :max="50" :min="1" :step="1" v-model="formmodel.sort" style="width: 200px;"
                             :disabled="checkdisable('sort')"></InputNumber>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="创建人id" prop="">
                <Input v-model="formmodel.userid" :disabled="checkdisable('userid')"></Input>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="创建人" prop="">
                <Input v-model="formmodel.username" :disabled="checkdisable('username')"></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="11">
            <FormItem label="是否启用" prop="" :disabled="checkdisable('enable')">
                <Select v-model="formmodel.enable">
                    <Option :key="1" :value="1">启用</Option>
                    <Option :key="0" :value="0">禁用</Option>
                </Select>
            </FormItem>
            </Col>
            <Col span="11">
            <FormItem label="创建时间" prop="">
                <DatePicker type="datetime" v-model="formmodel.time" style="width: 200px;"
                            :disabled="checkdisable('time')"></DatePicker>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="17">
            <FormItem label="扩展数据" prop="data">
                <Input v-model="formmodel.data" placeholder="菜单扩展数据" :disabled="checkdisable('data')"></Input>
            </FormItem>
            </Col>
            <Col span="5">
            <FormItem label="菜单状态">
                <span style="color: red;font-size: 12px;padding: 10px 12px 10px 0px;">{{!!isadd?"新增":"修改"}}{{menutype=='P'?'父菜单':'子菜单'}}</span>
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
        <!--<FormItem label="E-mail" prop="mail">
            <Input v-model="formmodel.mail" placeholder="Enter your e-mail"></Input>
        </FormItem>
        <FormItem label="City" prop="city">
            <Select v-model="formmodel.city" placeholder="Select your city">
                <Option value="beijing">New York</Option>
                <Option value="shanghai">London</Option>
                <Option value="shenzhen">Sydney</Option>
            </Select>
        </FormItem>
        <FormItem label="Date">
            <Row>
                <Col span="11">
                <FormItem prop="date">
                    <DatePicker type="date" placeholder="Select date" v-model="formmodel.date"></DatePicker>
                </FormItem>
                </Col>
                <Col span="2" style="text-align: center"></Col>
                <Col span="11">
                <FormItem prop="time">
                    <TimePicker type="time" placeholder="Select time" v-model="formmodel.time"></TimePicker>
                </FormItem>
                </Col>
            </Row>
        </FormItem>
        <FormItem label="Gender" prop="gender">
            <RadioGroup v-model="formmodel.gender">
                <Radio label="male">Male</Radio>
                <Radio label="female">Female</Radio>
            </RadioGroup>
        </FormItem>
        <FormItem label="Hobby" prop="interest">
            <CheckboxGroup v-model="formmodel.interest">
                <Checkbox label="Eat"></Checkbox>
                <Checkbox label="Sleep"></Checkbox>
                <Checkbox label="Run"></Checkbox>
                <Checkbox label="Movie"></Checkbox>
            </CheckboxGroup>
        </FormItem>
        <FormItem label="Desc" prop="desc">
            <Input v-model="formmodel.desc" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="Enter something..."></Input>
        </FormItem>
        <FormItem>
            <Button type="primary" @click="savemenu('formmodel')">Submit</Button>
            <Button @click="handleReset('formmodel')" style="margin-left: 8px">Reset</Button>
        </FormItem>-->
    </Form>
</template>

<script>
    export default {
        name: "MenuForm",
        props: {
            modeldata: {
                type: Object, default() {
                    return null;
                }
            },
            menutype: String,
            isadd: Boolean,
            havechild: {
                type: Boolean, default() {
                    return true;
                }
            }
        },
        data: function () {
            return {
                uri: 'menu',
                formmodel: {
                    component: "",
                    data: "",
                    enable: 1,
                    icon: "",
                    menuid: "",
                    name: "",
                    pid: "",
                    sort: 20,
                    time: "",
                    userid: "",
                    username: ""
                },
                ruleValidate: {
                    name: [
                        {required: true, message: '请输入菜单名称', trigger: 'blur'}
                    ],
                    data: [
                        {type: "string", max: 500, message: "最大500个字符", trigger: 'blur'}
                    ]
                    /* mail: [
                         {required: true, message: 'Mailbox cannot be empty', trigger: 'blur'},
                         {type: 'email', message: 'Incorrect email format', trigger: 'blur'}
                     ],
                     city: [
                         {required: true, message: 'Please select the city', trigger: 'change'}
                     ],
                     gender: [
                         {required: true, message: 'Please select gender', trigger: 'change'}
                     ],
                     interest: [
                         {
                             required: true,
                             type: 'array',
                             min: 1,
                             message: 'Choose at least one hobby',
                             trigger: 'change'
                         },
                         {type: 'array', max: 2, message: 'Choose two hobbies at best', trigger: 'change'}
                     ],
                     date: [
                         {required: true, type: 'date', message: 'Please select the date', trigger: 'change'}
                     ],
                     time: [
                         {required: true, type: 'string', message: 'Please select time', trigger: 'change'}
                     ],
                     desc: [
                         {required: true, message: 'Please enter a personal introduction', trigger: 'blur'},
                         {type: 'string', min: 20, message: 'Introduce no less than 20 words', trigger: 'blur'}
                     ]*/
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
        computed: {},
        mounted: function () {
        },
        methods: {
            savemenu: function (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        let url = this.uri+'/updatenonull';
                        if (this.isadd) {
                            url = this.uri+'/add';
                        }
                        this.axiospost(url, this.formmodel, this.commenuback);
                    } else {
                        this.alerterr('请按要求填写!');
                    }
                });
            },
            isdelete: function () {
                if (this.menutype == "P" && !this.havechild && !this.isadd) {//是父菜单且无子且不是新增
                    return false;
                } else if (this.menutype == "C" && !this.isadd) {//子菜单且不是新增
                    return false;
                }
                else {
                    return true;
                }
            },
            deletemenu: function () {
                let self = this;
                if (!this.formmodel.menuid) {
                    this.alertwarn('新增数据未保存时不能删除!')
                    return;
                }
                this.confirmcom('<p>确定删除？</p>', function () {
                    self.axiospost(self.uri+'/delete', self.formmodel, self.commenuback);
                })
            },
            commenuback: function (response) {
                if (!!response && !!response.data) {
                    this.alertsuces('操作成功!');
                }
                this.$emit('refresh');
            },
            checkdisable: function (filed) {
                let pdisable = ['component', 'menuid', 'pid', 'time', 'userid', 'username'];
                let cdisable = ['menuid', 'time', 'userid', 'username'];
                if ("P" == this.menutype) {
                    if (pdisable.indexOf(filed) > -1) {
                        return true;
                    }
                } else {
                    if (cdisable.indexOf(filed) > -1) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
</script>

<style scoped>

</style>