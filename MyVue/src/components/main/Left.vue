<template>
    <Menu active-name="" :theme="comtheme" width="auto"  accordion @on-select="setcomponentpath"><!--open-names=""-->
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
</template>

<script>
    export default {
        name: "left",
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
            setcomponentpath: function (menuid) {
                if (!!menuid) {
                    let tmenu = this.comjs.findobjvaldg(this.menu, 'menuid', menuid, '', '');
                    if (!!tmenu) {
                        this.$emit("componentpath", tmenu.component, tmenu.name);
                    }
                }
            },
            getmenu: function () {
                this.axios.post(this.combacksite + "menu/menuget", {'enable': 1}).then(response => {
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