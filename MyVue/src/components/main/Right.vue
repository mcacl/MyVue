<template>
    <Layout>
        <Header style="height:30px;line-height: 30px;padding: 0px 20px;font-size: larger;"
                :style="{background: comcolor}">
            <Row>
                <Col span="23">
                <span>{{showmenu}}</span>
                </Col>
                <Col span="1">
                <Button shape="circle" size="small" @click="loginout">退出</Button>
                </Col>
            </Row>
        </Header>
        <Content :style="{ 'margin-top':'3px',background: comcolor, minHeight: '220px'}">
            <component :is="showcomponent"></component>
        </Content>
    </Layout>
</template>

<script>
    import SysMenu from "../page/menu/SysMenu";
    import SysUser from "../page/menu/SysUser";
    import WelcomePage from "../page/WelcomePage";
    import SysUserGroup from "../page/menu/SysUserGroup";
    import SysUserAuthority from "../page/menu/SysUserAuthority"

    export default {
        components: {
            WelcomePage,
            SysUser,
            SysMenu,
            SysUserGroup,
            SysUserAuthority
        },
        uri: "loginout",
        name: "right",
        props: {
            showcomponent: String,
            showmenu: String
        },
        data: function () {
            return {}
        },
        methods: {
            loginout: function () {
                let self = this;
                this.$Modal.confirm({
                    title: '提示', content: '<p>确定退出系统？</p>',
                    onOk: () => {
                        self.axiospost(self.uri, {}, function (response) {
                            this.tologin();
                        })
                    },
                    onCancel: () => {
                    }
                });
            }
        }
    }
</script>

<style scoped>

</style>