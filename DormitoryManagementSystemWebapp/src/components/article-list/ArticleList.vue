<!--
Description:
Created: 2020-04-17 11:50 星期五
Author: DreamSnow·Draco
Company: none
-->
<template>
   <div class="article-list">
      <!-- 文章内容 -->
      <div class="article-list-item" v-for="item in article" :key="item.id">
         <!-- 文章发布时间 -->
         <div class="article-date">
            <span v-text="item.date"></span>
         </div>
         <!-- 文章标题 -->
         <div class="article-title">
            <a @click.prevent="goDetail(item.id,item.type)" v-text="item.title"></a>
         </div>
         <!-- 文章的描述 -->
         <div class="article-desc" v-text="item.desc"></div>
         <!-- 文章的发布 时间+部门 -->
         <div class="article-post" v-text="item.post"></div>
      </div>
   </div>
</template>

<script>
   export default {
      name: 'ArticleList',
      data () {
         return {};
      },
      props: ['article'],
      methods: {
         goDetail (id, type) {
            window.sessionStorage.setItem('aid', id);
            window.sessionStorage.setItem('atype', type)
            this.$router.push('/detail');
         }
      }
   }
</script>

<style scoped lang="less">
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
</style>
