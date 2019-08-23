<template>
    <Layout style="height: 100%;" :style="{'background': comcolor}">
        <Sider hide-trigger :style="{'background': comcolor}"
               style="width: 450px;height: 100%;max-width: 450px;flex: auto;">
            <Input search enter-button placeholder="输入用户名或登录名" v-model="searchform.name" @on-search="search"/>
            <Table border :columns="columns" :data="griddata" :loading="loading" @on-row-dblclick="select"></Table>
            <Page :total="pagetotal" :page-size="pagesize" :page-size-opts="[20,80,120,200]" @on-change="pagechange"
                  @on-page-size-change="pagesizechange" show-sizer show-total style="text-align: right;"/>
        </Sider>
        <Content :style="{background: comcolor, minHeight: '220px'}">
            6
        </Content>
    </Layout>
</template>

<script>
    export default {
        name: "SysUser",
        data: function () {
            return {
                uri: 'user',
                loading: false,
                searchform: {
                    name: ""
                },
                columns: [
                    {title: '用户名', key: 'name'},
                    {title: '登录名', key: 'loginname'},
                    {title: '最近登录', key: 'latelogintime'},
                    {title: '用户状态', key: "islogin"}
                ],
                griddata: [],
                pagetotal: 0,
                pagesize: 20,
                pagenum: 1
            }
        },
        mounted: function () {
            this.getuser();
        },
        methods: {
            getuser: function () {
                loading = true;
                this.axiospost(this.uri + "/page", this.page(this.pagesize, this.pagenum, this.searchform), this.getuserback);
                loading = false;
            },
            getuserback: function (response) {
                if (!!response.data) {
                    this.griddata = response.data.list;
                    this.pagetotal = response.data.total;
                }
            },
            pagechange: function (pagenum) {
                this.pagenum = pagenum;
                this.getuser();
            },
            pagesizechange: function (pagesize) {
                this.pagesize = pagesize;
                if (this.pagetotal >= pagesize) {
                    this.getuser();//当总数据大于当前页才刷新，否则没必要刷新
                }
            },
            search: function (val) {
                if (!!this.formmodel.name) {
                    this.getuser();
                }
            },
            select: function (row, index) {
            }
        }
    }
</script>

<style scoped>

</style>