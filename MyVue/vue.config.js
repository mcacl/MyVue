const webpack = require('webpack');
module.exports = {
    configureWebpack: {
        devtool: 'source-map',
        plugins: [
            new webpack.ProvidePlugin({
                $: "jquery",
                jQuery: "jquery",
                "windows.jQuery": "jquery",
                Popper: ['popper.js', 'default']
            })
        ]
    }
}