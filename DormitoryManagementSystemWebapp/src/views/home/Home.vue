<!--
       Filename: Home.vue
    Description: 主页组件
        Version: 1.0
        Created: 2020-04-03 20:14 星期五
       Revision: none
       Compiler: none
         Author: DreamSnow·Draco
        Company: none
-->
<template>
   <div class="home-container">
      <!-- 首页的头部区域 -->
      <header class="home-header">
         <!-- 首页标题区域 -->
         <div class="home-title">
            <!-- 首页的主标题区域 -->
            <div class="main-title">
               <!-- 首页主标题的内容及点击事件 -->
               <a class="main-title-a" @click.prevent="toControl">
                  &nbsp;学&nbsp;生&nbsp;宿&nbsp;舍&nbsp;
                  <span style='color:#99CCFF'>管&nbsp;理&nbsp;</span>
                  中&nbsp;&nbsp;
                  <i class="el-icon-minus"/>
                  <i class="el-icon-minus"/>
                  <i class="el-icon-minus"/>
                  <i class="el-icon-minus"/>
                  <i class="el-icon-minus"/>
                  <i class="el-icon-minus"/>
                  <i class="el-icon-minus"/>
                  <i class="el-icon-arrow-right"/>
                  &nbsp;&nbsp;[&nbsp;&nbsp;
                  <span style='color:green'>管&nbsp;理&nbsp;成&nbsp;功</span>
                  &nbsp;&nbsp;]
               </a>
            </div>
            <!-- 首页的副标题区域和内容 -->
            <div class="subtitle">
               [&nbsp;&nbsp;
               <span style='color:#FF9900'>美&nbsp;丽&nbsp;宿&nbsp;舍</span>
               &nbsp;&nbsp;] &nbsp;&nbsp;
               <span style='color:lightgreen'>Up&nbsp;Up&nbsp;Up</span>
               &nbsp;&nbsp;!
            </div>
         </div>
         <!-- 首页导航区域 -->
         <div class="home-navigator">
            <ul>
               <li @click="toControl">控制台</li>
               <li @click="logoutButton">退出</li>
            </ul>
         </div>
      </header>
      <!-- 首页主体内容区域 -->
      <main class="home-main">
         <!-- 文章区域 -->
         <div class="article-panel">
            <!-- 文档导航菜单区域 -->
            <el-menu mode="horizontal" :default-active="activeIndex" class="article-menu" @select="handleSelect">
               <!-- 文章导航菜单内容 -->
               <el-menu-item v-for="(item,index) in articleMenu" :key="index" :index="item.menuId + ''"
                             v-text="item.menuName"></el-menu-item>
            </el-menu>
            <!-- 文章列表 -->
            <article-list :article="article" v-if="pagination.menuId"/>
            <article-introduce :introduce="introduce" v-else/>
            <!-- 分页查看 -->
            <el-pagination
               hide-on-single-page
               background
               class="article-pagination"
               layout="total, prev, pager, next"
               :total="pagination.pageTotal"
               :current-page.sync="pagination.currentPage"
               :page-size="pagination.pageSize"
               @current-change="handleCurrentChange"
               @next-click="handleNextClick"
               @prev-click="handlePrevClick">
            </el-pagination>
         </div>
         <!-- 首页信息区域 -->
         <div class="info-panel">
            <div class="info-card">
               <!-- 个人信息的标题 -->
               <h3>欢迎使用</h3>
               <!-- 个人信息的内容 -->
               <div class="info-box">
                  <ul>
                     <li v-for="(value,index) in infoName" :key="index" v-text="value"></li>
                  </ul>
                  <ul>
                     <li v-for="(value,index) in info" :key="index" v-text="value"></li>
                  </ul>
               </div>
               <!-- 个人信息区域的按钮组 -->
               <div class="buttons">
                  <el-button type="primary" round @click="toControl">控制台</el-button>
                  <el-button type="info" round @click="logoutButton">退出</el-button>
               </div>
            </div>
            <el-calendar class="info-calendar" v-model="date"></el-calendar>
         </div>
      </main>
      <!-- 首页的底部区域 -->
      <footer class="home-footer">
         Copyright © 2020 荆辞雪
      </footer>
   </div>
</template>

<script>
   import $ from 'jquery';
   import ArticleList from '../../components/article-list/ArticleList';
   import ArticleIntroduce from '../../components/article-introduce/ArticleIntroduce';

   export default {
      components: {
         'article-list': ArticleList,
         'article-introduce': ArticleIntroduce
      },
      name: 'Home',
      data () {
         return {
            infoName: {
               id: '学号：',
               name: '姓名：',
               college: '学院：',
               lastTime: '上次登录：'
            },
            info: {
               id: '16478080',
               name: '荆辞雪',
               college: '信息与计算机工程学院',
               lastTime: '2020-4-14 00:00:00'
            },
            articleMenu: [
               {
                  menuId: 0,
                  menuName: '宿管简介'
               },
               {
                  menuId: 1,
                  menuName: '综合'
               },
               {
                  menuId: 2,
                  menuName: '例检'
               },
               {
                  menuId: 3,
                  menuName: '抽检'
               },
               {
                  menuId: 4,
                  menuName: '晚归'
               },
               {
                  menuId: 5,
                  menuName: '考评'
               },
               {
                  menuId: 6,
                  menuName: '宿管公告'
               },
               {
                  menuId: 7,
                  menuName: '下载'
               },
            ],
            article: [
               {
                  id: '',
                  type: '',
                  date: '2018年6月11日',
                  title: '信息与计算机工程学院抽检卫生结果通报',
                  desc: '2018年6月11日周一下午16点30分学院抽检，本次抽检检查结果共计53个好寝、0个差寝。',
                  post: 'posted @ 2018-6-13 21:17 宿管委员会寝工部',
               },
               {
                  date: '2018年6月13日',
                  title: '信息与计算机工程学院例检卫生结果通报',
                  desc: '2018年6月13日周三下午16点30分学院例检，本次例检检查结果共计59个好寝、0个差寝。',
                  post: 'posted @ 2018-6-13 21:20 宿管委员会寝工部'
               },
               {
                  date: '2018年6月20日',
                  title: '信息与计算机工程学院例检卫生结果通报',
                  desc: '2018年6月20日周三下午16点30分学院例检，本次例检检查结果共计58个好寝，0个差寝。',
                  post: 'posted @ 2018-6-20 21:06 宿管委员会寝工部'
               },
               {
                  date: '2018年6月22日',
                  title: '信息与计算机工程学院晚归检查结果通报',
                  desc: '2018年6月21日周四晚上22点学院晚归检查，本次晚归检查结果共计3位缺寝。',
                  post: 'posted @ 2018-6-22 8:00 宿管委员会考核部'
               }
            ],
            activeIndex: '1',
            introduce: {
               title: '信息与计算机工程学院宿管委员会简介',
               subTitle:
                  '信息与计算机工程学院宿管委员会成立于2017年11月11日,前身为信息与计算机工程学院团总支学生分会宿管部;宿管委员会下设寝工部、秘书部、考核部三个部门,由指导老师、主任、部长及部门成员组成。',
               subImg: '../../assets/images/img_00.jpg',
               qin: '寝工部负责例检、抽检及相关工作。',
               qinImg: '../../assets/images/img_01.jpg',
               mi: '秘书部负责反馈、报修、宿管日常工作记录及相关工作。',
               miImg: '../../assets/images/img_02.jpg',
               kao: '考核部负责通报、晚归、考评及相关工作。',
               kaoImg: '../../assets/images/img_03.jpg'
            },
            date: new Date(),
            pagination: {
               /* 需要进行改进 前端应该传递当前页面和每页的可显示的数量 后端返回总的文章简介条数和对应页码的文章简介 */
               // 当前页
               currentPage: 1,
               // 每页显示的数量
               pageSize: 8,
               // 总页数
               pageTotal: 8,
               // 当前显示的是第几个菜单项
               menuId: 1,
               // 当前页显示的第一条文章简介在总的文章简介中是第几条
               index: 0,
               // 每页显示的文章条数
               total: 8
            }
         };
      },
      created () {
         this.getInfoName();
         this.getInfo();
         this.getArticleMenu();
         this.getArticle();
         this.getIntroduce();
      },
      methods: {
         toControl () {
            // 跳转至控制台页面
            this.$router.push('/control');
         },
         async logoutButton () {
            // 请求后台执行退出登录
            // const res = await this.$http.post('/sys/logout');
            await this.$http.post('/sys/logout');
            // 输出回调信息
            // console.log('logout....' + res);
            // 清除会话内容
            window.sessionStorage.clear();
            // 返回登录页面
            await this.$router.push('/login');
         },
         handleCurrentChange (val) {
            // 处理翻页操作
            // console.log(val);
         },
         handleNextClick (val) {
            // console.log('next' + val);
            // 改变页码和每页的文章数量
            this.pagination.index += 8;
            this.pagination.total += 8;
            // 获取文章列列表内容
            this.getArticle();
         },
         handlePrevClick (val) {
            // console.log('prev' + val);
            // 改变页码和每页的文章数量
            this.pagination.index -= 8;
            this.pagination.total -= 8;
            // 获取文章列列表内容
            this.getArticle();
         },
         handleSelect (key, keyPath) {
            // 点击文章菜单后,控制显示的文章信息
            // console.log(key);
            // console.log(keyPath);
            // 修改文章的种类
            this.pagination.menuId = parseInt(key);
            // 显示当前获取的menuId的类型
            // console.log(typeof this.pagination.menuId);
            // 初始化显示页码和每一页的文章数量
            this.pagination.index = 0;
            this.pagination.total = 8;
            this.pagination.pageSize = 8;
            if (parseInt(key) === 0) {
               // 设置页码和页面文章数
               this.pagination.pageSize = 1;
               this.pagination.pageTotal = 1;
            } else {
               // 获取文章列列表内容
               this.getArticle();
            }
         },
         async getInfoName () {
            // 获取信息面板的内容
            const { data: res } = await this.$http.post('/home/infoName');
            // 输出获取的信息
            // console.log(res);
            // 为信息赋值
            if (res.code === 200) {
               this.infoName.id = res.data.id;
               this.infoName.name = res.data.name;
               this.infoName.college = res.data.college;
               this.infoName.lastTime = res.data.lastTime;
            }
         },
         async getInfo () {
            // 获取信息面板的内容
            const { data: res } = await this.$http.post('/home/userInfo');
            // 输出获取的信息
            // console.log(res);
            // 为信息赋值
            if (res.code === 200) {
               this.info.id = res.data.id;
               this.info.name = res.data.name;
               this.info.college = res.data.college;
               this.info.lastTime = res.data.lastTime;
            }
         },
         async getArticleMenu () {
            // 获取文章分类菜单
            const { data: res } = await this.$http.post('/home/articleMenu');
            // 输出文章菜单项
            // console.log(res);
            // 为文章菜单项赋值
            if (res.code === 200) {
               this.articleMenu = res.data;
            }
         },
         async getArticle () {
            // 获取文章列列表内容
            // 将其他类型转为 字符串类型
            var menuId = this.pagination.menuId + '';
            var index = this.pagination.index + '';
            var total = this.pagination.total + '';
            // 向后端发出请求
            const { data: res } = await this.$http.post('/home/articleList', [menuId, index, total]);
            // 输出返回值
            // console.log(res);
            // 为文章列表赋值
            if (res.code === 200) {
               this.pagination.pageTotal = res.data.total;
               this.article = res.data.rows;
            }
         },
         async getIntroduce () {
            // 获取宿管简介
            const { data: res } = await this.$http.post('/home/introduce');
            // 输出获取的内容
            // console.log(res);
            if (res.code === 200) {
               this.introduce = res.data;
            }
         },
      },
      mounted () {
         // 为 element-ui 的日历组件修改样式
         $('.el-calendar__header').css({
            padding: '20px 0',
            display: 'block'
         });
         $('.el-calendar-day').css({ height: 'auto' });
         $('.el-calendar__button-group').css({ display: 'none' });
         $('.el-calendar__title').css({
            textAlign: 'center',
            fontSize: '16px',
            fontWeight: '900'
         });
      }
   };
</script>

<style scoped lang="less">
   .home-container {
      background-color: #fafafa;
      height: 100%;
      border-top: 3px solid orange;
      min-width: 1260px;

      .home-header::before {
         background-image: url("../../assets/images/logo_w.png");
         background-size: contain;
         border: 0 solid #fff;
         border-radius: 50%;
         box-shadow: 0 -1px 12px -4px #000;
         content: "";
         display: block;
         width: 100px;
         height: 100px;
         margin-bottom: 40px;
         margin-left: 50%;
         position: relative;
         top: 6%;
         transform: translate3d(-50%, 20%, 0px);
      }

      .home-header {
         display: block;
         width: 100%;
         min-width: 1260px;
         height: 263px;
         background-color: #21292f;
         position: relative;
         overflow: hidden;

         h1 {
            width: 100%;
            line-height: 1.5;
            text-align: center;
            color: #ccc;
            font-size: 28px;
            font-weight: normal;
            text-indent: -9999px;
            overflow: hidden;
            background-size: auto 42px;
         }

         .home-title {
            width: 100%;
            text-align: center;

            .main-title {
               width: 100%;
               margin-bottom: 15px;

               .main-title-a {
                  text-decoration: none;
                  font-size: 28px;
                  color: #ccc;
                  cursor: pointer;
               }
            }

            .subtitle {
               font-size: 18px;
               color: #ccc;
            }
         }

         .home-navigator {
            position: absolute;
            top: -100px;
            right: 10px;
            background-color: #fff;
            transition: top 0.5s cubic-bezier(0, 0.63, 0.32, 1.28) 0s;
            width: 80px;

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

         .home-navigator::after {
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

         .home-navigator:hover {
            top: 0;
         }
      }

      .home-main {
         /* 声明布局为 flex 布局 */
         display: flex;
         /* webkit内核的浏览器(Google, Safari)需要添加 -webkit 前缀  */
         display: -webkit-flex;
         /* ie edg 的微软浏览器需要加 -ms 前缀 */
         display: -ms-flex;
         /* 容器内容组件的排列方向 */
         /*flex-direction: row;
         -ms-flex-direction: row;
         -webkit-flex-direction: row;*/
         /* 容器内组件的一行装不下时是否要换行 */
         /*flex-wrap: nowrap;
         -ms-flex-wrap: nowrap;
         -webkit-flex-wrap: nowrap;*/
         /* flex-flow === flex-direction + flex-warp */
         flex-flow: row nowrap;
         -webkit-flex-flow: row nowrap;
         box-sizing: border-box;
         -webkit-box-sizing: border-box;
         /* firefox 浏览器需要添加 -moz 前缀 */
         -moz-box-sizing: border-box;
         padding: 20px;
         min-width: 1260px;
         background-color: #e3e4e5;

         .article-panel {
            flex-grow: 4;
            -webkit-flex-grow: 4;
            min-width: 930px;
            padding-right: 30px;

            .article-menu {
               background-color: #e3e4e5;
               display: flex;
               display: -webkit-flex;
               display: -ms-flex;
               justify-content: space-between;

               .is-active {
                  color: #ef4625;
                  background-color: #e3e4e5;
                  border-bottom: 3px solid #ef4625;
               }
            }

            .article-list {
               width: 100%;

               .article-list-item {
                  background-color: #fafafa;
                  border-radius: 5px;
                  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
                  padding: 10px 25px;
                  margin-top: 50px;
                  position: relative;

                  .article-date::before {
                     content: "";
                     display: block;
                     width: 0;
                     height: 0;
                     border-color: #eb374b blue yellow transparent;
                     border-style: solid;
                     border-width: 20px 0 0 40px;
                     position: absolute;
                     top: 100%;
                     left: 0;
                  }

                  .article-date {
                     background-color: #eb374b;
                     display: block;
                     min-width: 140px;
                     padding: 6px 10px;
                     color: #fff;
                     font-family: Arvo, Cambria, Georgia, Times, serif;
                     font-size: 18px;
                     vertical-align: middle;
                     position: absolute;
                     text-align: center;
                     top: -30px;
                     left: -10px;
                  }

                  .article-title {
                     border-left: 5px solid #e84c3d;
                     font-weight: 500;
                     margin: 10px auto;
                     overflow: hidden;
                     padding: 0 2em 0 20px;
                     text-overflow: ellipsis;
                     white-space: nowrap;

                     a {
                        color: #333;
                        font-size: 24px;
                        transition: color 0.3s ease 0s;
                        cursor: pointer;
                     }

                     a:hover {
                        color: #e84c3d;
                     }
                  }

                  .article-desc {
                     background-color: #f4f4f4;
                     border-top: 1px solid #dee1e0;
                     color: #4d4d4d;
                     font-size: 16px;
                     padding: 20px;
                     word-wrap: break-word;
                     word-break: break-all;
                     overflow: hidden;
                     line-height: 1.5;
                  }

                  .article-post {
                     border-top: 1px solid #dee1e0;
                     color: #bfbfbf;
                     line-height: 50px;
                     min-height: 50px;
                     padding: 0 110px 0 10px;
                     font-size: 18px;
                  }
               }
            }

            .article-pagination {
               text-align: center;
               margin-top: 60px;
            }
         }

         .info-panel {
            max-width: 300px;
            min-width: 260px;
            overflow: hidden;
            flex-grow: 1;
            -webkit-flex-grow: 1;
            display: flex;
            display: -webkit-flex;
            display: -ms-flex;
            justify-content: flex-start;
            -webkit-justify-content: flex-start;
            flex-direction: column;
            -webkit-flex-direction: column;
            -ms-flex-direction: column;
            flex-wrap: nowrap;
            -webkit-flex-wrap: nowrap;
            -ms-flex-wrap: nowrap;

            .info-card {
               height: 300px;
               background-color: #fafafa;
               border-radius: 20px;
               box-shadow: 0 0 3px rgba(0, 0, 0, 0.2);

               h3 {
                  background-color: #404a58;
                  color: #fff;
                  font-size: 20px;
                  margin-top: 0;
                  padding: 10px 0;
                  text-align: center;
                  border-top-left-radius: 20px;
                  border-top-right-radius: 20px;
               }

               .info-box {
                  display: flex;
                  display: -webkit-flex;
                  display: -ms-flex;
                  margin-top: 20px;

                  ul:nth-of-type(1) {
                     flex-grow: 1;
                     -webkit-flex-grow: 1;

                     li {
                        text-align: right;
                        font-size: 16px;
                        font-weight: bold;
                        line-height: 2;
                     }
                  }

                  ul:nth-of-type(2) {
                     flex-grow: 2;
                     -webkit-flex-grow: 2;

                     li {
                        text-align: left;
                        font-size: 16px;
                        font-weight: bold;
                        line-height: 2;
                     }
                  }
               }

               .buttons {
                  display: flex;
                  display: -webkit-flex;
                  display: -ms-flex;
                  justify-content: space-around;
                  -webkit-justify-content: space-around;
                  margin-top: 40px;
               }
            }

            .info-calendar {
               margin-top: 20px;
               border-radius: 20px;
               overflow: hidden;
            }
         }
      }

      .home-footer {
         width: 100%;
         min-width: 1260px;
         height: 60px;
         background-color: #21292f;
         color: #fff;
         font-size: 1.3em;
         line-height: 60px;
         text-align: center;
      }
   }
</style>
