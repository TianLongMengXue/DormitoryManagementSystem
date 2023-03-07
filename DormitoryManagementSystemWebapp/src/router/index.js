import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login/Login.vue'
import Home from '../views/home/Home.vue'
import Control from '../views/control/Control.vue'
import UserInfo from '../views/user-info/UserInfo.vue'
import Detail from '../views/article-detail/ArticleDetail.vue'
import ChangeWord from '../views/change-word/ChangeWord';

Vue.use(VueRouter);

const routes = [
   {
      /* 当访问 / 路径,自动跳转到 /login 路径 */
      path: '/',
      redirect: '/login'
   },
   {
      /* 当访问 /login 路径时,将 Login 组件渲染到页面中 */
      path: '/login',
      component: Login
   },
   {
      /* 当访问 /home 路径时将 Home 组件渲染到页面中 */
      path: '/home',
      component: Home
   },
   {
      /* 当访问 /control 路径时,,自动重定向到 /home/member 路径下,将 Control 和 Member  组件渲染到页面中 */
      path: '/control',
      component: Control,
      redirect: '/userInfo',
      children: [
         {
            path: '/userInfo',
            component: UserInfo
         },
         {
            path: '/changeWord',
            component: ChangeWord
         }
      ]
   },
   {
      /* 当访问 /detail 路径时将 Detail 组件渲染到页面中 */
      path: '/detail',
      component: Detail
   }
];

const router = new VueRouter({
   routes
});

// 挂载路由守卫
router.beforeEach((to, from, next) => {
   // to 表示要访问的页面
   // from 表示从哪个路径跳转过来
   // next 一个函数,表示放行 next() 表示放行, next('/login') 表示强制跳转到 /login 路径下
   // 当访问的页面是 /login 时,直接放行
   if (to.path === '/login') return next();
   // 获取 session 对象中的 token 属性值
   const tokenString = window.sessionStorage.getItem('token');
   // 当 token 属性值不存在时,强制跳转到 /login 路径下
   if (!tokenString) return next('/login');
   // 当 token 属性值存在时,自动放行访问
   next();
});

export default router
