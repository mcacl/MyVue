<template>
    <Layout style="height: 100%;" :style="{'background': comcolor}">
        <Sider hide-trigger :style="{'background': comcolor}">
            <div style="text-align: center;margin-top:2px;">
                <Tooltip placement="bottom" :delay="500">
                    <Button type="primary" shape="circle" size="small" @click="addmenu">新增</Button>
                    <div slot="content" style="width: 160px;">
                        <p>先选中按钮,在添加!</p>
                        <p>选中父菜单则增加父菜单</p>
                        <p>选中子菜单则增加子菜单</p>
                    </div>
                </Tooltip>
            </div>
            <Menu active-name="" :theme="comtheme" width="auto" accordion @on-select="selectmenu"
                  @on-open-change="openmenu">
                <!--open-names=""-->
                <Submenu :name="parent.menuid" v-if="!parent.pid" v-for="parent in menu">
                    <template slot="title">
                        <Icon :type="parent.icon"></Icon>
                        {{parent.name}}
                    </template>
                    <MenuItem :name="child.menuid" v-if="child.pid==parent.menuid" v-for="child in menu">
                        {{child .name}}
                    </MenuItem>
                </Submenu>
            </Menu>
        </Sider>
        <Content :style="{background: comcolor, minHeight: '220px'}" v-show="!!checkmodel" class="comformtop">
            <FormMenu :modeldata="checkmodel" :menutype="menutype" :havechild="havechild" @refresh="getmenu"
                      :isadd="isadd"></FormMenu>
        </Content>
    </Layout>
</template>

<script>
    import FormMenu from "./FormMenu";

    export default {
        components: {FormMenu},
        name: "SysMenu",
        props: {},
        data: function () {
            return {
                uri: 'menu',
                componentname: "",
                menu: [],
                checkmodel: null,
                menutype: null, //选择菜单类型 C 子 P 父
                havechild: true, //是否有子菜单 控制能否删除
                isadd: false //新增菜单?
            }
        },
        computed: {},
        mounted: function () {
            this.getmenu();
        },
        methods: {
            getmenu: function () {
                this.axiospost(this.uri + '/list', {enable: 1}, this.getmenuback);
            },
            getmenuback: function (response) {
                if (!!response.data) {
                    this.menu = response.data;
                }
            },
            selectmenu: function (menuid, menutype) {
                this.isadd = false;
                if (!!menuid) {
                    let tmenu = this.comjs.comfindobjvaldg(this.menu, 'menuid', menuid, '', '');
                    if (!!tmenu) {
                        this.havechild = false;//重置父菜单是否有子菜单
                        this.menutype = !menutype ? "C" : menutype;
                        this.checkmodel = tmenu;
                        if (menutype == "P") {
                            this.havechild = this.checkchild(tmenu.menuid);
                        }
                    }
                }
            },
            openmenu: function (arr) {
                this.selectmenu(arr[0], "P");
            },
            addmenu: function () {
                this.isadd = true;
                if (!!this.checkmodel) {
                    this.checkmodel = {
                        component: null,
                        data: null,
                        enable: 1,
                        icon: null,
                        menuid: null,
                        name: null,
                        pid: this.checkmodel.pid,
                        sort: 20,
                        time: null,
                        userid: this.checkmodel.userid,
                        username: this.checkmodel.username
                    };
                } else {
                    this.alertwarn("请选中添加按钮的类型!选中父菜单则增加父菜单,选中子菜单则增加同级子菜单");
                }
            },
            checkchild: function (pid) {
                let tmenu = this.comjs.comfindobjvaldg(this.menu, 'pid', pid, '', '');//检查是否有子菜单
                if (!!tmenu) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
</script>

<style scoped>

</style>