const webpack = require('webpack');
let proxyMap = {one: 'http://localhost:8111'};
let proxyPath = proxyMap.one;
module.exports = {
    configureWebpack: {
        devtool: 'source-map',
        plugins: [
            new webpack.ProvidePlugin({})
        ]
    },
    devServer: {
        host: 'localhost',
        port: 8081,
        https: false,
        hotOnly: false,
        proxy: {
            '/api': {
                target: proxyPath,
                ws: true,  // proxy websockets
                changeOrigin: true,//允许跨域
                pathRewrite: {'^/api': ''}
            }
        }
    }
}