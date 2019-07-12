<template>
    <div class="ui middle aligned animated list">
        <div class="item" @click="setcomponentpath('Title')">
            <img class="ui avatar image" src="/images/avatar/small/christian.jpg">
            <div class="content">
                <div class="header">Christian</div>
            </div>
        </div>
        <div class="item" @click="setcomponentpath('Menu')">
            <img class="ui avatar image" src="/images/avatar/small/daniel.jpg">
            <div class="content">
                <div class="header">丹尼尔</div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Menu",
        props: {},
        data: function () {
            return {
                component: ""
            }
        },
        computed: {},
        methods: {
            setcomponentpath: function (componentname) {
                this.component = componentname;
                this.$emit("componentpath", this.component);
            }
        }
    }
</script>

<style scoped>

</style>