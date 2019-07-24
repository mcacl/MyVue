<template>
    <Menu active-name="1-2" :theme="comtheme" width="auto" :open-names="['1']" accordion @on-select="setcomponentpath">
        <!--<Submenu name="1">
            <template slot="title">
                <Icon type="ios-navigate"></Icon>
                Item 1
            </template>
            <MenuItem name="1-1">Option 1</MenuItem>
            <MenuItem name="1-2">Option 2</MenuItem>
            <MenuItem name="1-3">Option 3</MenuItem>
        </Submenu>
        <Submenu name="2">
            <template slot="title">
                <Icon type="ios-keypad"></Icon>
                Item 2
            </template>
            <MenuItem name="2-1">Option 1</MenuItem>
            <MenuItem name="2-2">Option 2</MenuItem>
        </Submenu>-->
        <Submenu :name="parent.menuid" v-if="!parent.pid" v-for="parent in menu">
            <template slot="title">
                <Icon :type="parent.icon"></Icon>
                {{parent.name}}
            </template>
            <MenuItem :name="child.menuid" v-if="child.pid==parent.menuid" v-for="child in menu"
                      @on-select="setcomponentpath('')">
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