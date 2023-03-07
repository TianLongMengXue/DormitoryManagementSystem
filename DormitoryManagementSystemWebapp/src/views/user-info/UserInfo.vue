<!--
    Description: 个人信息组件
        Created: 2020-04-13 23:33 星期一
         Author: DreamSnow·Draco
        Company: none
-->
<template>
   <div class="user-info">
      <el-form ref="userInfoRef" :rules="userInfoRules" :model="userInfo" label-width="82px">
         <el-form-item label="学号：">
            <el-input v-model="userInfo.id" disabled></el-input>
         </el-form-item>
         <el-form-item label="姓名：" prop="name">
            <el-input type="text" placeholder="姓名" v-model.trim.lazy="userInfo.name"></el-input>
         </el-form-item>
         <el-form-item label="手机号：" prop="tel">
            <el-input type="text" placeholder="手机号" v-model.trim.lazy="userInfo.tel"></el-input>
         </el-form-item>
         <el-form-item label="邮箱：" prop="mail">
            <el-input type="text" placeholder="邮箱" v-model.trim.lazy="userInfo.mail"></el-input>
         </el-form-item>
         <el-form-item label="上次登录：">
            <el-input v-model="userInfo.lastTime" disabled></el-input>
         </el-form-item>
         <el-form-item label="学院：">
            <el-input v-model="userInfo.college" disabled></el-input>
         </el-form-item>
         <el-form-item label="班级：">
            <el-input v-model="userInfo.class" disabled></el-input>
         </el-form-item>
         <el-form-item label="宿舍号：">
            <el-input v-model="userInfo.dor" disabled></el-input>
         </el-form-item>
      </el-form>
      <div class="buttonGroup">
         <el-button type="primary" round @click="alterUserInfo">提交修改</el-button>
      </div>
   </div>
</template>

<script>
   export default {
      name: 'UserInfo',
      data () {
         // 校验手机号是否合法
         const validatePassTel = (rule, value, callback) => {
            // 空值校验
            if (value === '') {
               callback(new Error('请输入手机号！'));
            } else {
               if (!/^1(3|4|5|6|7|8|9)\d{9}$/.test(value)) {
                  callback(new Error('手机号不合法'));
               }
               callback();
            }
         };
         // 校验邮箱是否合法
         const validatePassMail = (rule, value, callback) => {
            // 空值校验
            if (value === '') {
               callback(new Error('请输入邮箱！'));
            } else {
               // 比较前一次输入的密码
               if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/.test(value)) {
                  callback(new Error('邮箱不合法'));
               }
               callback();
            }
         };
         return {
            userInfo: {
               id: '',
               name: '',
               tel: '',
               mail: '',
               lastTime: '',
               college: '',
               class: '',
               dor: '',
            },
            userInfoRules: {
               name: [
                  {
                     required: true,
                     message: '请输入姓名！',
                     trigger: 'blur'
                  }
               ],
               tel: [
                  {
                     required: true,
                     message: '请输入姓名！',
                     trigger: 'blur'
                  },
                  {
                     validator: validatePassTel,
                     trigger: 'blur'
                  }
               ],
               mail: [
                  {
                     required: true,
                     message: '请输入姓名！',
                     trigger: 'blur'
                  },
                  {
                     validator: validatePassMail,
                     trigger: 'blur'
                  }
               ],
            }
         };
      },
      created () {
         this.getUserInfo();
      },
      methods: {
         async getUserInfo () {
            const { data: res } = await this.$http.get('/ctrl/userInfo/select');
            if (res.code === 200) {
               this.userInfo = res.data;
            }
         },
         async alterUserInfo () {
            const { data: res } = await this.$http.post('/ctrl/userInfo/update', {
               userName: this.userInfo.name,
               userTel: this.userInfo.tel,
               userMail: this.userInfo.mail
            });
            if (res.code === 200) {
               this.getUserInfo();
               return this.$alert('修改成功', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                     this.$message({
                        type: 'info',
                        message: `action: ${action}`
                     })
                  }
               });
            }
         }
      }
   }
</script>

<style scoped lang="less">
   .user-info {
      width: 100%;
      overflow-x: hidden;
      overflow-y: auto;
      display: flex;
      justify-content: center;
      background-color: #fafafa;
      border-radius: 5px;
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
      padding: 20px 50px;
      box-sizing: border-box;
      flex-direction: column;

      .el-form {
         width: 100%;
      }

      .buttonGroup {
         text-align: center;
      }
   }
</style>
