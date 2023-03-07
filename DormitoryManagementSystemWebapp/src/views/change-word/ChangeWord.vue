<!--
Description:
Created: 2020-05-06 23:27 星期三
Author: DreamSnow·Draco
Company: none
-->
<template>
   <div class="change-word">
      <el-form ref="wordFormRef" :model="wordForm" label-width="82px" :rules="wordFormRules" status-icon>
         <el-form-item label="新密码：" prop="word">
            <el-input type="password" placeholder="新密码" v-model.trim.lazy="wordForm.word"></el-input>
         </el-form-item>
         <el-form-item label="再输一次：" prop="reWord">
            <el-input type="password" placeholder="再输一次" v-model.trim.lazy="wordForm.reWord"></el-input>
         </el-form-item>
      </el-form>
      <div class="buttonGroup">
         <el-button type="primary" round @click="changeWord">提交修改</el-button>
      </div>
   </div>
</template>

<script>
   export default {
      name: 'ChangeWord',
      data () {
         const validatePassWord = (rule, value, callback) => {
            // 空值校验
            if (value === '') {
               callback(new Error('请输入密码！'));
            } else {
               // 密码长度校验
               if (value.length < 8 || value.length > 16) {
                  callback(new Error('密码长度在 8 到 16 个字符！'));
                  // 密码包含的内容校验
               } else if (!/(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,16}/.test(value)) {
                  callback(new Error('密码必须包含大小写字母、数字、特殊字符！'));
               }
               callback();
            }
         };
         const validatePassReWord = (rule, value, callback) => {
            // 空值校验
            if (value === '') {
               callback(new Error('请再输入密码！'));
            } else {
               // 比较前一次输入的密码
               if (value !== this.data().wordForm.word) {
                  callback(new Error('两次输入的密码不一致！'));
               }
               callback();
            }
         };
         return {
            wordForm: {
               word: '',
               reWord: ''
            },
            wordFormRules: {
               word: [
                  {
                     validator: validatePassWord,
                     trigger: 'blur'
                  }
               ],
               reWord: [
                  {
                     validator: validatePassReWord,
                     trigger: 'blur'
                  }
               ]
            }
         };
      },
      methods: {
         async changeWord () {
            const { data: res } = await this.$http.post('/ctrl//changeWord/update', {
               userWord: this.wordForm.word
            });
            if (res.code === 200) {
               return this.$alert('修改成功', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                     this.$message({
                        type: 'info',
                        message: `action: ${action}`
                     });
                  }
               });
            }
         }
      }
   }
</script>

<style scoped lang="less">
   .change-word {
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
