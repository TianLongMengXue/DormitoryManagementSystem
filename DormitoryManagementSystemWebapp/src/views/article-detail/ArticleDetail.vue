<!--
Description: 文章详情页面
Created: 2020-04-19 13:46 星期日
Author: DreamSnow·Draco
Company: none
-->
<template>
   <div class="detail">
      <div class="detail-header">
         <el-page-header @back="goBack" :content="content.title"/>
      </div>
      <div class="detail-content">
         <!--<table>
            <tr>
               <th class="detail-content-title" v-text="content.title" :colspan="content.colspan"></th>
            </tr>
            <tr>
               <th class="detail-content-date" v-text="content.date" :colspan="content.colspan"></th>
            </tr>
            <tbody v-for="(row,index) in content.rows" :key="index">
            <tr v-if="content.buildCol">
               <th v-text="row.build" :colspan="content.colspan" class="detail-content-build"></th>
            </tr>
            <tr>
               <th class="detail-content-item" v-for="(name,index) in row.recordName" :key="index" v-text="name"></th>
            </tr>
            <tr v-for="(value,index) in row.record" :key="index">
               <td class="detail-content-item" v-for="(subVal,index) in value" :key="index" v-text="subVal"></td>
            </tr>
            </tbody>
         </table>-->
         <ul>
            <li class="detail-content-title" v-text="content.title"></li>
            <li class="detail-content-date" v-if="content.dateCol" v-text="content.date"></li>
            <li v-for="(row,index) in content.rows" :key="index">
               <ul>
                  <li class="detail-content-mini-title" v-if="content.miniCol" v-text="row.miniTitle"></li>
                  <li>
                     <el-table
                        :data="row.record"
                        style="width: 100%">
                        <el-table-column
                           v-for="(item,index) in content.recordName"
                           :key="index"
                           :prop="item.value"
                           :label="item.label"
                           min-width="180">
                        </el-table-column>
                     </el-table>
                  </li>
               </ul>
            </li>
            <li class="detail-content-signature" v-for="(item,index) in content.signature" :key="index"
                v-text="item"></li>
         </ul>
      </div>
   </div>
</template>

<script>
   import $ from 'jquery';

   export default {
      name: 'ArticleDetail',
      data () {
         return {
            id: '',
            type: '',
            content: {
               /*title: '信息与计算机工程学院2018年6月文明宿舍',
               dateCol: true,
               date: '2020年4月18日',
               miniCol: true,
               recordName: [
               {
                  label: '宿舍号',
                  value: 'dorNum'
               },
               {
                  label: '班级',
                  value: 'className'
               },
               {
                  label: '卫生情况',
                  value: 'score'
               },
               {
                  label: '备注',
                  value: 'desc'
               },
               {
                  label: '班主任',
                  value: 'classHead'
               },
               {
                  label: '宿舍长',
                  value: 'dorHead'
               },
            ],
            rows: [
               {
                  miniTitle: '2栋',
                  record: [
                     {
                        dorNum: '2-701',
                        className: '17数媒',
                        score: '9.50',
                        desc: '',
                        classHead: '刘琪、刘坚',
                        dorHead: '王永凤'
                     },
                     {
                        dorNum: '2-702',
                        className: '17软件1/17软件2',
                        score: '9.00',
                        desc: '桌面摆放不整齐',
                        classHead: '刘坚、黎元钢',
                        dorHead: '陈芷晴'
                     }
                  ],
               },
               {
                  build: '2栋',
                  record: [
                     {
                        dorNum: '2-701',
                        className: '17数媒',
                        score: '9.50',
                        desc: '',
                        classHead: '刘琪、刘坚',
                        dorHead: '王永凤'
                     },
                     {
                        dorNum: '2-702',
                        className: '17软件1/17软件2',
                        score: '9.00',
                        desc: '桌面摆放不整齐',
                        classHead: '刘坚、黎元钢',
                        dorHead: '陈芷晴'
                     }
                  ],
               }
            ],
            signature: ['信息与计算机工程学院', '2020年4月18日', '宿管委员会考核部'],*/
            },
         };
      },
      created () {
         // 获取会话缓存内容
         this.id = window.sessionStorage.getItem('aid');
         this.type = window.sessionStorage.getItem('atype');
         // 向后台请求页面数据
         this.getContent();
      },
      methods: {
         goBack () {
            // console.log('go back');
            // 清理会话缓存
            window.sessionStorage.removeItem('aid');
            window.sessionStorage.removeItem('atype');
            // 历史页面回退
            this.$router.go(-1);
         },
         async getContent () {
            // 获取文章详情内容
            const { data: res } = await this.$http.post('/home/articleDetail', {
               id: this.id,
               type: this.type
            });
            // 输出获取的内容
            // console.log(res);
            // 将请求到的数据进行页面赋值
            this.content = res.data;
         }
      },
      mounted () {
         // 当 会话缓存内容中 空值时,不显示详情页面,并回退到home页面
         if (this.id === null || this.type === null || this.id.length === 0 || this.type.length === 0 || this.id === '' || this.type === '') {
            this.$router.back();
         }
         $('.el-table__body .el-table__row:hover > td').css({ backgroundColor: '#e3e4e5' });
      }
   }
</script>

<style scoped lang="less">
   .detail {
      width: 100%;
      border-top: 3px solid orange;
      background-color: #fafafa;
      min-width: 1200px;

      .detail-header {
         box-sizing: border-box;
         -moz-box-sizing: border-box;
         -webkit-box-sizing: border-box;
         width: 100%;
         padding: 24px;
      }

      .detail-content {
         max-width: 1200px;
         background-color: #fafafa;
         position: relative;
         left: 50%;
         transform: translateX(-50%);
         margin-top: 20px;
         border-radius: 5px;
         box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
         box-sizing: border-box;
         -moz-box-sizing: border-box;
         -webkit-box-sizing: border-box;
         padding: 24px;
         overflow-x: auto;

         /*table{
            display: table;
            width: 100%;

            tr:hover{
               background-color: #e3e4e5;
            }

            td{
               text-align: center;
            }

            th, td{
               white-space: nowrap;
            }
         }*/

         .detail-content-title {
            font-size: 28px;
            font-weight: 900;
            line-height: 40px;
            padding: 20px 0;
            text-align: center;
         }

         .detail-content-date, .detail-content-mini-title {
            font-size: 20px;
            font-weight: bold;
            line-height: 30px;
            padding: 10px 0;
            text-align: center;
         }

         /*.detail-content-mini-title {
            color: #f10125;
         }*/

         /*.detail-content-item{
            font-size: 16px;
            line-height: 20px;
            padding: 5px 10px;
         }*/

         .detail-content-signature {
            font-size: 16px;
            line-height: 24px;
            text-align: right;
            padding: 5px 0;
         }
      }
   }
</style>
