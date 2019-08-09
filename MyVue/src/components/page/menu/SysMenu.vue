<template>
    <Layout style="height: 100%;" :style="{'background': comcolor}">
        <Sider hide-trigger :style="{'background': comcolor}">
            <Menu active-name="" :theme="comtheme" width="auto" accordion @on-select="selectmenu">
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
        <Content style="margin-right: 15px;" v-show="!!menucheck">
            <MenuForm :modeldata="menucheck"></MenuForm>
        </Content>
    </Layout>
</template>

<script>
    import MenuForm from "./MenuForm";

    export default {
        components: {MenuForm},
        name: "SysMenu",
        props: {},
        data: function () {
            return {
                componentname: "",
                menu: [],
                menucheck: null
            }
        },
        computed: {},
        mounted: function () {
            this.getmenu();
        },
        methods: {
            getmenu: function () {
                this.axiospost('menu/menuget', {enable: 1}, this.getmenuback);
            },
            getmenuback: function (response) {
                if (!!response.data) {
                    this.menu = response.data;
                }
            },
            selectmenu: function (menuid) {
                if (!!menuid) {
                    let tmenu = this.comjs.findobjvaldg(this.menu, 'menuid', menuid, '', '');
                    if (!!tmenu) {
                        this.menucheck = tmenu;
                    }
                }
            }
        }
    }
</script>

<style scoped>

</style>