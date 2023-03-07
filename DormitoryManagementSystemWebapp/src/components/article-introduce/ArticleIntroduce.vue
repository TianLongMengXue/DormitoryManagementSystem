<!--
Description:
Created: 2020-04-18 23:41 星期六
Author: DreamSnow·Draco
Company: none
-->
<template>
   <div class="article-introduce">
      <!-- 文章标题 -->
      <div class="article-introduce-title" v-text="introduce.title"></div>
      <!-- 副标题 -->
      <div class="article-introduce-subTitle" v-text="introduce.subTitle"></div>
      <!-- 合照 -->
      <!--<el-image :src="introduce.subImg" class="article-introduce-subImg"/>-->
      <div class="article-introduce-imgCover">
         <img src="../../assets/images/img_00.jpg" alt="图片加载失败"/>
      </div>
      <!-- 寝工部 -->
      <div class="article-introduce-subTitle" v-text="introduce.qin"></div>
      <!-- 合照 -->
      <!--<el-image :src="introduce.qinImg" class="article-introduce-qinImg"/>-->
      <div class="article-introduce-imgCover">
         <img src="../../assets/images/img_01.jpg" alt="图片加载失败"/>
      </div>
      <!-- 秘书部 -->
      <div class="article-introduce-subTitle" v-text="introduce.mi"></div>
      <!-- 合照 -->
      <!--<el-image :src="introduce.miImg" class="article-introduce-miImg"/>-->
      <div class="article-introduce-imgCover">
         <img src="../../assets/images/img_02.jpg" alt="图片加载失败"/>
      </div>
      <!-- 考核部 -->
      <div class="article-introduce-subTitle" v-text="introduce.kao"></div>
      <!-- 合照 -->
      <!--<el-image :src="introduce.kaoImg" class="article-introduce-kao"/>-->
      <div class="article-introduce-imgCover">
         <img src="../../assets/images/img_03.jpg" alt="图片加载失败"/>
      </div>
   </div>
</template>

<script>
   export default {
      name: 'ArticleIntroduce',
      props: ['introduce'],
   }
</script>

<style scoped lang="less">
.article-introduce{
   width: calc(100% - 50px);
   background-color: #fafafa;
   border-radius: 10px;
   box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
   padding: 10px 25px;
   margin-top: 50px;
   text-align: center;

   .article-introduce-title{
      font-size: 36px;
      font-weight: 900;
      line-height: 60px;
   }

   .article-introduce-subTitle{
      background-color: #f4f4f4;
      border-top: 1px solid #dee1e0;
      color: #4d4d4d;
      font-size: 16px;
      padding: 20px;
      word-wrap: break-word;
      word-break: break-all;
      overflow: hidden;
      line-height: 1.5;
      text-align: left;
   }

   .article-introduce-imgCover{
      position: relative;
      width: 600px;
      height: 400px;
      left: 50%;
      transform: translateX(-50%);

      img{
         width: 100%;
         height: 100%;
         display: block;
      }
   }

   .article-introduce-imgCover::after{
      position: absolute;
      content: '';
      width: 100%;
      height: 100%;
      top: 0;
      left: 0;
      box-shadow:0 0 50px 40px #ffffff inset;
   }
}
</style>
