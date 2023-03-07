/*
* Description:
* Created: 2020-04-01 23:14 星期三
* Author: DreamSnow·Draco
* Company: none
* */
module.exports = {
   devServer: {
      // open: true, // 项目启动时自动开启浏览器浏览页面渲染效果
      port: 65535, // 项目启动时端口号
      host: 'localhost', // 项目启动时的 url 地址

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
         '/api/dms/home': {
            target: 'http://localhost:65533/dms/home',
            changeOrigin: true,
            ws: true,
            pathRewrite: {
               '^/api/dms/home': ''
            }
         },
         '/api/dms/ctrl': {
            target: 'http://localhost:65532/dms/ctrl',
            changeOrigin: true,
            ws: true,
            pathRewrite: {
               '^/api/dms/ctrl': ''
            }
         }
      }
   },
};
