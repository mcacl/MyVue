<template>
    <Form ref="formmodel" :model="formmodel" :rules="ruleValidate" :label-width="100">
        <Row>
            <Col span="12">
            <FormItem label="菜单id">
                <Input v-model="formmodel.menuid" disabled></Input>
            </FormItem>
            </Col>
            <Col span="12">
            <FormItem label="父菜单id">
                <Input v-model="formmodel.pid" disabled></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="12">
            <FormItem label="菜单名称" prop="name">
                <Input v-model="formmodel.name" placeholder="菜单名称"></Input>
            </FormItem>
            </Col>
            <Col span="12">
            <FormItem label="跳转页">
                <Input v-model="formmodel.component" placeholder="菜单跳转页"></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="12">
            <FormItem label="图标" prop="">
                <Input v-model="formmodel.icon" placeholder="菜单图标名称"></Input>
            </FormItem>
            </Col>
            <Col span="12">
            <FormItem label="菜单顺序" prop="">
                <InputNumber :max="50" :min="1" :step="1" v-model="formmodel.sort" style="width: 200px;"></InputNumber>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="12">
            <FormItem label="创建人id" prop="">
                <Input v-model="formmodel.userid" disabled></Input>
            </FormItem>
            </Col>
            <Col span="12">
            <FormItem label="创建人" prop="">
                <Input v-model="formmodel.username" disabled></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="12">
            <FormItem label="是否启用" prop="">
                <Select v-model="formmodel.enable">
                    <Option :key="1" :value="1">启用</Option>
                    <Option :key="0" :value="0">禁用</Option>
                </Select>
            </FormItem>
            </Col>
            <Col span="12">
            <FormItem label="创建时间" prop="">
                <DatePicker type="datetime" v-model="formmodel.time" style="width: 200px;" disabled></DatePicker>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="24">
            <FormItem label="扩展数据">
                <Input v-model="formmodel.data" placeholder="菜单扩展数据"></Input>
            </FormItem>
            </Col>
        </Row>
        <Row>
            <Col span="24">
            <FormItem>
                <Button type="primary" @click="savemenu('formmodel')">保存</Button>
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
            }
        },
        data: function () {
            return {
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
                        {type: "string", max: 5, message: "最大500个字符", trigger: 'blur'}
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
                        this.axiospost('menu/menuget', {}, this.savemenuback);
                    } else {
                        this.alerterr('请按要求填写!');
                    }
                })
            },
            savemenuback: function (response) {
                if (!!response && !!response.data) {
                    console.log(response.data);
                    this.alertsuces('保存成功!');
                }
            }
        }
    }
</script>

<style scoped>

</style>