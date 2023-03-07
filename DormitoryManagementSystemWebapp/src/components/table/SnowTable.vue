<!--
Description: 自定义table标签
Created: 2020-04-20 22:36 星期一
Author: DreamSnow·Draco
Company: none
-->
<template>
   <div class="snow-table">
      <div class="snow-thead">
         <div class="snow-table-title" v-text="content.title"></div>
         <div class="snow-table-sub-title" v-text="content.date"></div>
      </div>
      <div class="snow-tbody" v-for="(row,index) in content.rows" :key="index">
         <div class="snow-table-mini-title" v-if="content.buildCol" v-text="row.build"></div>
         <div class="snow-table-row">
            <div class="snow-table-column" v-for="(item,index) in row.record" :key="index">
               <div class="snow-table-item" v-text="item"></div>
            </div>
         </div>
      </div>
   </div>
</template>

<script>
   export default {
      name: 'SnowTable',
      data () {
         return {
            content: {
               title: '信息与计算机工程学院2018年6月文明宿舍',
               date: '2020年4月18日',
               buildCol: false,
               rows: [
                  {
                     record: [
                        ['宿舍号', '1-203', '1-204'],
                        ['学院名称', '信息与计算机工程学院', '信息与计算机工程学院'],
                        ['班主任', '刘琪', '刘琪'],
                        ['辅导员', '黎元钢', '黎元钢'],
                        ['等级', '文明寝室', '文明寝室']
                     ]
                  },
                  {
                     build: '2栋',
                     recordName: ['宿舍号', '班级', '卫生情况', '备注', '班主任', '宿舍长'],
                     record: [
                        ['2-701', '17数媒', '9.50', '', '刘琪、刘坚', '王永凤'],
                        ['2-702', '17软件1/17软件2', '9.00', '桌面摆放不整齐', '刘坚、黎元钢', '陈芷晴'],
                     ]
                  }
               ],
            }
         };
      },
   }
</script>

<style scoped lang="less">
.snow-table{
   /* 最小宽度 */
   max-width: 1080px;
   /* 背景色 */
   background-color: #fafafa;
   /* 页面居中 */
   position: relative;
   left: 50%;
   transform: translateX(-50%);
   /* 顶部间隙 */
   margin-top: 20px;
   /* 微圆边角 */
   border-radius: 5px;
   /* 盒子阴影 */
   box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
   /* 盒子模型为边框对齐 */
   box-sizing: border-box;
   -moz-box-sizing: border-box;
   -webkit-box-sizing: border-box;
   /* 内边距离 */
   padding: 24px;
   /* 水平开启滚动条 */
   overflow-x: auto;

   .snow-table-thead{
      width: 100%;

      .snow-table-title{
         color: #000;
         font-size: 28px;
         font-weight: 900;
         line-height: 40px;
         padding: 20px 0;
         text-align: center;
      }

      .snow-table-sub-title{
         color: #000;
         font-size: 20px;
         font-weight: bold;
         line-height: 30px;
         padding: 10px 0;
         text-align: center;
      }
   }

   .snow-table-tbody{
      width: 100%;

      .snow-table-mini-title{
         color: #f10125;
         font-size: 20px;
         font-weight: bold;
         line-height: 30px;
         padding: 10px 0;
         text-align: center;
      }

      .snow-table-row{
         width: 100%;

         .snow-table-column{
            float: left;

            .snow-table-item{
               font-size: 16px;
               line-height: 20px;
               padding: 5px 10px;
               white-space: nowrap;
               text-align: center;
            }

            :hover{
               background-color: #e3e4e5;
            }
         }
      }
   }
}
</style>
