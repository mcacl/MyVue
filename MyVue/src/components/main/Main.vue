<template>
    <div>
        <div class="ui container">
            <Title></Title>
        </div>
        <div class="ui container">
            <Menu @componentpath="changecomponent"></Menu>
        </div>
        <div class="ui container">
            <component :is="showcomponent"></component>
        </div>
    </div>
</template>

<script>
    import Title from "./Title";
    import Menu from "./Menu";
    import WelcomePage from '../page/WelcomePage';

    export default {
        name: "Main",
        components: {
            Menu,
            Title,
            WelcomePage
        },
        props: {},
        data: function () {
            return {
                showcomponent: "WelcomePage"
            }
        },
        computed: {},
        methods: {
            changecomponent: function (componentname) {
                this.showcomponent = componentname;
            }
        }
    }
</script>

<style scoped>

</style>