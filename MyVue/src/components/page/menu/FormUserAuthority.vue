<template>
    <Layout style="height: 100%;" :style="{'background': comcolor}">
        <Sider hide-trigger :style="{'background': comcolor}">
            <Tree ref='tree' :data="treemenu" show-checkbox></Tree>
        </Sider>
        <Content style=" background-color: #f9fafb;">
            <Form ref="formmodel" :model="formmodel" :label-width="80">
                <Row>
                    <Col span="11">
                    <FormItem label="分组名">
                        <Input v-model="formmodel.groupname" :disabled="checkdisable('groupname')"></Input>
                    </FormItem>
                    </Col>
                    <Col span="11">
                    <FormItem label="权限编号">
                        <Input v-model="formmodel.authorid" :disabled="checkdisable('authorid')"></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="22">
                    <FormItem label="操作状态">
                        <span style="color: red;font-size: 12px;padding: 10px 12px 10px 0px;">编辑权限</span>
                        <span style="color: red;font-size: 12px;padding: 10px 12px 10px 0px;"
                              v-show="!formmodel.authorid">该用户没有赋予任何菜单权限!</span>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="11">
                    <FormItem>
                        <Button type="primary" @click="saveform">保存</Button>
                    </FormItem>
                    </Col>
                </Row>
            </Form>
        </Content>
    </Layout>

</template>

<script>
    export default {
        name: "FormUserAuthority",
        props: {
            modeldata: {type: Object}
        },
        data: function () {
            return {
                uri: 'userauthor',
                isadd: false,//新增？
                formmodel: {
                    groupid: null,
                    groupname: null,
                    menuid: null,
                    createtime: null,
                    isuse: 1,
                    authorid: null
                },
                menudata: [],
                treemenu: [],
                authorobj: {id: null}
            };
        },
        watch: {
            modeldata: function (val) {
                if (!!val) {
                    this.formmodel = val;
                    this.getauthor();
                }
            },
            authorobj: function (val) {
                this.getmenutree();
            }
        },
        mounted: function () {
            this.getmenu();
        },
        methods: {
            saveform: function () {
                let nodes = this.$refs['tree'].getCheckedAndIndeterminateNodes();
                let ids = [];
                for (let index in nodes) {
                    let menuid = nodes[index].data["menuid"];
                    if (!!menuid) {
                        ids.push(menuid);
                    }
                }
                if (!!this.formmodel.groupid) {
                    let url = this.uri + '/updatenonull';
                    let param = this.authorobj;
                    if (!!this.authorobj.id) {
                        this.isadd = false;
                    } else {
                        this.isadd = false;
                    }
                    let idstr = ids.join(",");
                    if (!!this.authorobj && idstr == this.authorobj.menuid) {
                        this.alertsuces('无需保存!');
                        return;
                    }
                    if (this.isadd) {
                        url = this.uri + '/add';
                        param = {id: null, menuid: "", groupid: this.formmodel.groupid};
                    }
                    param.menuid = idstr;
                    this.axiospost(url, param, this.comback);
                } else {
                    this.alerterr('未获取到赋予权限的分组');
                }
            },
            comback: function (response) {
                if (!!response && !!response.data) {
                    this.alertsuces('操作成功!');
                    this.formmodel = {};
                }
            },
            checkdisable: function (filed) {
                let disable = ['authorid', 'groupname'];
                if (disable.indexOf(filed) > -1) {
                    return true;
                }
                return false;
            },
            getmenu: function () {
                let self = this;
                this.axiospost('menu/list', {}, function (response) {
                        if (!!response && !!response.data) {
                            self.menudata = response.data;
                        }
                    }
                );
            },
            getmenutree: function () {
                let tmenu = this.comjs.comcopy(this.menudata);
                let authstr = this.authorobj["menuid"];
                if (!!authstr && authstr.length > 0) {
                    let autharr = authstr.split(",");
                    for (let mid in autharr) {
                        for (let index in tmenu) {
                            if (tmenu[index].menuid == autharr[mid]) {
                                tmenu[index].check = true;
                                break;
                            }
                        }
                    }
                }
                let tree = this.treebuild(null, tmenu, "pid", null, "menuid", "name");
                this.treemenu = tree;
            },
            getauthor: function () {
                let self = this;
                this.axiospost(this.uri + '/list', {"groupid": self.formmodel.groupid},
                    function (response) {
                        if (!!response && !!response.data) {
                            if (response.data.length > 0) {
                                self.authorobj = response.data[0];
                                self.formmodel.authorid = self.authorobj.id;
                            } else {
                                self.authorobj = {id: null, menuid: "", groupid: self.formmodel.groupid}
                            }
                        }
                    });
            }
        }
    }
</script>

<style scoped>

</style>