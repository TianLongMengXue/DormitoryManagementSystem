# eslintrc.js 配置
```javascript
module.exports = {
  rules: {
    'indent': 'off', // 关闭缩进检查
    'no-new': 'off', // 关闭文件末尾没有空的新行检查
    'next-line': 'off', // 关闭换行检查
    'no-trailing-spaces': 'off', // 关闭多余空格检查
    'func-call-spacing': 'off', // 关闭子函数预父函数之间需要使用空行分隔检查
    'semi': "off", // 关闭代码结尾不使用 ; 结束的检查
    'comma-dangle': "off", // 关闭代码结尾处使用 , 结尾的检查
    'spaced-comment': "off", // 关闭注释内容时 '/*' 后需要一个空格与 '*/' 前需要一个空格的检查
    'vue/no-use-v-if-with-v-for': 'off', // 关闭v-for和v-if写为同一标签属性时报错
  }
}
```
# .editorconfig 配置
```
.editorconfig 中定义了 indent_size = 3 缩进为 3 个空格,若是代码换行的缩进不是 3 个空格就会报错
关闭这项检查 'indent': 'off'
```
# vue.config.js 配置
```javascript
module.exports = {
  devServer: {
    open: true, // 项目启动时自动开启浏览器浏览页面渲染效果
    port: 8888, // 项目启动时端口号
    host: '127.0.0.1', // 项目启动时的 url 地址
    // 配置API接口路径分配重写
    proxy: {
      // 所有访问路径为 /api/dms/sys/* 重写为 http://localhost:65534/dms/sys/*
      '/api/dms/sys': {
      target: 'http://localhost:65534/dms/sys',
      changeOrigin: true, // 开启跨域访问
      ws: true, // 开启websocket
      pathRewrite: {
        '^/api/dms/sys': ''
        }
      },
    }
  }
}
```
# less 支持
依赖 - 安装依赖 - 开发依赖 less
依赖 - 安装依赖 - 开发依赖 less-loader
# element-ui 支持
插件 - 安装插件 
# axios 支持
依赖 - 安装依赖 - 开发依赖 axios
# JQuery 支持
依赖 - 安装依赖 - 开发依赖 jquery
