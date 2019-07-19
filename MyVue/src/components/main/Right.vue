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
        <Content :style="{margin: '2px 0px 0px 2px', background: comcolor, minHeight: '220px'}">
            <component :is="showcomponent"></component>
        </Content>
    </Layout>
</template>

<script>
    import Test1 from "../page/Test1";
    import Test2 from "../page/Test2";
    import WelcomePage from "../page/WelcomePage";

    export default {
        components: {
            WelcomePage,
            Test2,
            Test1
        },
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
                this.$Modal.confirm({
                    title: '提示', content: '<p>确定退出系统？</p>',
                    onOk: () => {
                        this.tologin();
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