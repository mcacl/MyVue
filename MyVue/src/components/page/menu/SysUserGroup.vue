<template>
    <Layout style="height: 100%;" :style="{'background': comcolor}">
        <Sider hide-trigger :style="{'background': comcolor}"
               style="width: 450px;height: 100%;max-width: 450px;flex: auto;">
            <Input search enter-button placeholder="输入用户组名" v-model="searchform.name" @on-search="search"/>
            <div class="comtool">
                <ButtonGroup shape="circle">
                    <Button type="primary" @click="add">新增</Button>
                </ButtonGroup>
            </div>
            <div style="overflow: auto;height: 88%">
                <Table border size="small" :loading="loading" :columns="columns" :data="griddata"
                       @on-row-dblclick="select"></Table>
            </div>
            <Page :total="pagetotal" :page-size="pagesize" :page-size-opts="[20,80,120,200]" @on-change="pagechange"
                  @on-page-size-change="pagesizechange" show-sizer show-total style="text-align: right;"/>
        </Sider>
        <Content :style="{background: comcolor, minHeight: '220px'}" class="comformtop">
            <FormUserGroup :modeldata="checkmodel" :isadd="isadd" v-show="!!checkmodel"
                           @refresh="getlist"></FormUserGroup>
        </Content>
    </Layout>
</template>

<script>
    import FormUserGroup from "./FormUserGroup";

    export default {
        components: {FormUserGroup},
        name: "SysUserGroup",
        data: function () {
            return {
                uri: 'usergroup',
                loading: false,
                searchform: {
                    groupname: ""
                },
                columns: [
                    //{type: 'selection', width: 60, align: 'center'},//多选框
                    {type: 'index', width: 50, align: 'center'},
                    {title: '用户组名', key: 'groupname', fixed: 'left', sortable: true},
                    {title: '权限id', key: 'menuid', ellipsis: true},//ellipsis:多余数据现势为··
                    {
                        title: '状态', key: "isuse", width: 85, sortable: true, render: (r, params) => {
                            const row = params.row;
                            const color = row.isuse === 1 ? 'success' : 'default';
                            const text = row.isuse === 1 ? '启用' : '禁用';
                            return r('Tag', {
                                props: {
                                    color: color
                                }
                            }, text);
                        }
                    }
                ],
                griddata: [],
                checkmodel: null,//选中的数据
                isadd: false,//新增数据
                pagetotal: 0,
                pagesize: 20,
                pagenum: 1
            }
        },
        mounted: function () {
            this.getlist();
        }
        ,
        methods: {
            getlist: function () {
                this.loading = true;
                this.axiospost(this.uri + "/page", this.page(this.pagesize, this.pagenum, this.searchform), this.getlistback);
            }
            ,
            getlistback: function (response) {
                if (!!response.data) {
                    this.griddata = response.data.list;
                    this.pagetotal = response.data.total;
                }
                this.loading = false;
            }
            ,
            pagechange: function (pagenum) {
                this.pagenum = pagenum;
                this.getlist();
            }
            ,
            pagesizechange: function (pagesize) {
                this.pagesize = pagesize;
                if (this.pagetotal >= pagesize) {
                    this.getlist();//当总数据大于当前页才刷新，否则没必要刷新
                }
            }
            ,
            search: function (val) {
                this.getlist();
            }
            ,
            select: function (row, index) {
                this.isadd = false;
                this.checkmodel = row;
            }
            ,
            add: function () {
                this.isadd = true;
                this.checkmodel = {
                    groupid: null,
                    groupname: null,
                    menuid: null,
                    createtime: null,
                    isuse: 1
                };
            }
        }
    }
</script>

<style scoped>
    .toolrow {
        margin: 2px 0px;
    }
</style>