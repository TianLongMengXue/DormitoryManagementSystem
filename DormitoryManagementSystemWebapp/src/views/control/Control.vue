<!--
    Description: 控制台
        Created: 2020-04-10 23:41 星期五
         Author: DreamSnow·Draco
        Company: none
-->
<template>
   <el-container class="ctrl-container">
      <!-- 控制台头部区域 -->
      <el-header class="ctrl-header">
         <!-- 控制台的logo区域 -->
         <div class="header-logo">
            <h1>
               高校学生宿舍管理系统
            </h1>
         </div>
         <!-- 控制台的欢迎区域 -->
         <div class="header-welcome" v-text="'欢迎使用！'+name"></div>
      </el-header>
      <!-- 控制台的导航区域 -->
      <div class="ctrl-navigator">
         <ul>
            <li @click="toHome">首页</li>
            <li @click="logoutButton">退出</li>
         </ul>
      </div>
      <!-- 控制台的主体内容区域 -->
      <el-container>
         <!-- 控制台侧边栏 -->
         <el-aside class="ctrl-aside" :width="isCollapse?'64px':'200px'">
            <!-- 控制菜单折叠 -->
            <div class="menu-collapse" @click="changeCollapse">
               |||
            </div>
            <!-- 控制台菜单 -->
            <el-menu
               class="aside-menu"
               :default-active="activeMenu"
               background-color="#333744"
               text-color="#fff"
               active-text-color="#409eff"
               unique-opened
               :collapse="isCollapse"
               router
               :collapse-transition="false">
               <!-- 一级菜单 -->
               <el-submenu v-for="item in menuList" :key="item.id" :index="item.id">
                  <template slot="title">
                     <!-- 图标 -->
                     <i :class="item.icon"></i>
                     <!-- 文本 -->
                     <span v-text="item.name"></span>
                  </template>
                  <!-- 二级菜单 -->
                  <el-menu-item :index="subItem.path" v-for="subItem in item.children" :key="subItem.id">
                     <!-- 图标 -->
                     <i :class="subItem.icon"></i>
                     <!-- 文本 -->
                     <span slot="title" v-text="subItem.name"></span>
                  </el-menu-item>
               </el-submenu>
            </el-menu>
         </el-aside>
         <!-- 控制台主体内容 -->
         <el-main class="ctrl-main">
            <!-- 路由占位符 -->
            <router-view/>
         </el-main>
      </el-container>
   </el-container>
</template>

<script>
   export default {
      name: 'Control',
      data () {
         return {
            name: '',
            menuList: [
               {
                  id: '1',
                  name: '个人中心',
                  icon: 'el-icon-user',
                  children: [
                     {
                        id: '11',
                        name: '基本信息',
                        icon: 'el-icon-menu',
                        path: 'userInfo'
                     },
                     {
                        id: '12',
                        name: '修改密码',
                        icon: 'el-icon-menu',
                        path: 'changeWord'
                     }
                  ]
               },
               {
                  id: '2',
                  name: '意见反馈',
                  icon: 'el-icon-tickets',
                  children: [
                     {
                        id: '21',
                        name: '反馈记录',
                        icon: 'el-icon-menu',
                        path: ''
                     }
                  ]
               },
               {
                  id: '3',
                  name: '宿舍报修',
                  icon: 'el-icon-tickets',
                  children: [
                     {
                        id: '31',
                        name: '基本信息',
                        icon: 'el-icon-menu',
                        path: ''
                     },
                     {
                        id: '32',
                        name: '修改密码',
                        icon: 'el-icon-menu',
                        path: ''
                     }
                  ]
               },
               {
                  id: '4',
                  name: '例检',
                  icon: 'el-icon-tickets',
                  children: [
                     {
                        id: '41',
                        name: '基本信息',
                        icon: 'el-icon-menu',
                        path: ''
                     },
                     {
                        id: '42',
                        name: '修改密码',
                        icon: 'el-icon-menu',
                        path: ''
                     }
                  ]
               },
               {
                  id: '5',
                  name: '抽检',
                  icon: 'el-icon-tickets',
                  children: [
                     {
                        id: '51',
                        name: '基本信息',
                        icon: 'el-icon-menu',
                        path: ''
                     },
                     {
                        id: '52',
                        name: '修改密码',
                        icon: 'el-icon-menu',
                        path: ''
                     }
                  ]
               },
               {
                  id: '6',
                  name: '晚归',
                  icon: 'el-icon-tickets',
                  children: [
                     {
                        id: '61',
                        name: '基本信息',
                        icon: 'el-icon-menu',
                        path: ''
                     },
                     {
                        id: '62',
                        name: '修改密码',
                        icon: 'el-icon-menu',
                        path: ''
                     }
                  ]
               },
               {
                  id: '7',
                  name: '考评',
                  icon: 'el-icon-tickets',
                  children: [
                     {
                        id: '71',
                        name: '基本信息',
                        icon: 'el-icon-menu',
                        path: ''
                     },
                     {
                        id: '72',
                        name: '修改密码',
                        icon: 'el-icon-menu',
                        path: ''
                     }
                  ]
               },
            ],
            activeMenu: 'userInfo',
            isCollapse: false
         };
      },
      created () {
         this.getCtrlMenu();
      },
      methods: {
         toHome () {
            // 跳转至首页
            this.$router.push('/home');
         },
         async logoutButton () {
            // 请求后台执行退出登录
            await this.$http.post('/sys/logout');
            // 清除会话内容
            window.sessionStorage.clear();
            // 返回登录页面
            await this.$router.push('/login');
         },
         async getCtrlMenu () {
            const { data: res } = await this.$http.post('/ctrl/menu');
            if (res.code === 200) {
               this.name = res.data.name;
               this.menuList = res.data.menuList;
            }
         },
         changeCollapse () {
            this.isCollapse = !this.isCollapse;
         },
      }
   }
</script>

<style scoped lang="less">
   .ctrl-container {
      width: 100%;
      min-width: 1240px;
      height: 100%;
      background-color: #fafafa;
      border-top: 3px solid orange;
      position: relative;
      overflow: hidden;

      .ctrl-header {
         min-width: 1240px;
         display: flex;
         display: -webkit-flex;
         display: -ms-flex;
         align-items: center;
         justify-content: space-between;
         background-color: #373d41;

         .header-logo::before {
            display: inline-block;
            content: "";
            width: 62px;
            height: 60px;
            background: url("../../assets/images/logo_w.png") top center no-repeat;
            background-size: 62px 60px;
         }

         .header-logo {
            display: flex;
            display: -webkit-flex;
            display: -ms-flex;
            align-items: center;

            > h1 {
               padding-left: 15px;
               color: #fafafa;
               font-size: 28px;
               text-indent: -9999px;
               overflow: hidden;
               width: 400px;
               height: 40px;
               background: url("../../assets/images/title.png") top center no-repeat;
               background-size: 400px 40px;
            }
         }

         .header-welcome {
            font-size: 16px;
            color: #fafafa;
            padding-right: 80px;
         }
      }

      .ctrl-navigator {
         position: absolute;
         top: -100px;
         right: 10px;
         background-color: #fff;
         transition: top 0.5s cubic-bezier(0, 0.63, 0.32, 1.28) 0s;
         width: 80px;
         z-index: 1;

         ul {
            display: block;

            li {
               background-color: #7f9bc0;
               height: 49px;
               line-height: 49px;
               list-style: outside none none;
               margin-top: 1px;
               text-align: center;
               width: 100%;
               color: #fafafa;
               cursor: pointer;
               font-size: 14px;
            }

            li:hover {
               color: #7f9bc0;
               background-color: #fafafa;
            }
         }
      }

      .ctrl-navigator::after {
         border-left: 40px solid transparent;
         border-right: 40px solid transparent;
         border-top: 40px solid #d9534f;
         content: "";
         cursor: pointer;
         display: block;
         height: 0;
         right: 0;
         position: absolute;
         top: 100%;
         width: 0;
      }

      .ctrl-navigator:hover {
         top: 0;
      }

      .ctrl-aside {
         background-color: #333744;

         .menu-collapse {
            width: 100%;
            line-height: 28px;
            cursor: pointer;
            text-align: center;
            font-size: 10px;
            letter-spacing: 0.2em;
            color: #fafafa;
            font-weight: 900;
         }

         .aside-menu {
            border-right: none;
         }
      }

      .ctrl-main {
         background-color: #e3e4e5;
      }
   }
</style>
