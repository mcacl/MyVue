<template>
    <Layout style="height: 100%;" :style="{'background': comcolor}">
        <div style="text-align: center;margin-top:2px;">
            <Button type="primary" shape="circle" size="small" @click="getmenu">刷新</Button>
        </div>
        <Menu active-name="" :theme="comtheme" width="auto" accordion @on-select="setcomponentpath"><!--open-names=""-->
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
    </Layout>
</template>

<script>
    export default {
        name: "left",
        props: {},
        data: function () {
            return {
                uri: 'menu',
                componentname: "",
                menu: [],
            }
        },
        computed: {},
        mounted: function () {
            this.getmenu();
        },
        methods: {
            setcomponentpath: function (menuid) {
                if (!!menuid) {
                    let tmenu = this.comjs.findobjvaldg(this.menu, 'menuid', menuid, '', '');
                    if (!!tmenu) {
                        this.$emit("componentpath", tmenu.component, tmenu.name);
                    }
                }
            },
            getmenu: function () {
                this.axiospost(this.uri + '/list', {enable: 1}, this.getmenuback);
            },
            getmenuback: function (response) {
                if (!!response.data) {
                    this.menu = response.data;
                }
            },
        }
    }
</script>

<style scoped>

</style>