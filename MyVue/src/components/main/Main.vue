<template>
    <div class="layout" style="height: 100%">
        <Header :style="{'background': comcolor,height:'10%'}">
            <top></top>
        </Header>
        <Layout style="height: 86%;margin-top: 4px;">
            <Sider hide-trigger :style="{background: comcolor}">
                <left @componentpath="changecomponent"></left>
            </Sider>
            <right :showcomponent="showcomponent" :showmenu="showmenu"></right>
        </Layout>
        <Footer style="height: 3%;margin-top: 2px;padding: 0px 0px;text-align: center;">
            <bottom></bottom>
        </Footer>
    </div>
    <!-- <div>
         <div class="ui vertical segment">
             <Title></Title>
         </div>
         <div class="ui vertical segment">
             <div class="ui grid">
                 <div class="menu" style="overflow: auto">
                     <Menu @componentpath="changecomponent"></Menu>
                 </div>
                 <div>
                     <component :is="showcomponent"></component>
                 </div>
             </div>
         </div>
         <div class="ui vertical segment">
             <div class="ui grid">foot</div>
         </div>
     </div>-->
</template>

<script>
    import Top from "./Top";
    import Bottom from './Bottom';
    import Left from "./Left";
    import Right from "./Right";

    export default {
        name: "Main",
        components: {
            Right,
            Left,
            Bottom,
            Top
        },
        props: {},
        data: function () {
            return {
                showcomponent: "WelcomePage",
                showmenu: "欢迎页"
            }
        },
        computed: {},
        methods: {
            changecomponent: function (componentname, menuname) {
                this.showcomponent = componentname;
                this.showmenu = menuname;
            }
        }
    }
</script>

<style scoped>
    .layout {
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        position: relative;
        border-radius: 4px;
        overflow: hidden;
    }


</style>