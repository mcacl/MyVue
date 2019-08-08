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
        <Content>
            <MenuForm></MenuForm>
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
            }
        },
        computed: {},
        mounted: function () {
            this.getmenu();
        },
        methods: {
            selectmenu: function (menuid) {
                if (!!menuid) {
                    let tmenu = this.comjs.findobjvaldg(this.menu, 'menuid', menuid, '', '');
                    if (!!tmenu) {
                        console.log(tmenu);
                    }
                }
            },
            getmenu: function () {
                this.axios.post(this.combacksite + "menu/menuget").then(response => {
                    var data = response.data;
                    if (!!data) {
                        this.menu = data;
                    }
                }).catch(error => {
                    this.alerterr(error);
                });
            }
        }
    }
</script>

<style scoped>

</style>