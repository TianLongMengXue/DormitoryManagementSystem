<!--
       Filename: Login.vue
    Description: 登录组件
        Version: 1.0
        Created: 2020-04-01 23:20 星期三
       Revision: none
       Compiler: none
         Author: DreamSnow·Draco
        Company: none
-->
<template>
   <div class="login_container">
      <!-- 登录面板 -->
      <div class="login_panel">
         <!-- 登录标题 -->
         <div class="login_header"><h1>高校学生宿舍管理系统</h1></div>
         <!-- 登录默认头像 -->
         <div class="login_avatar">
            <svg class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" width="200"
                 height="200">
               <path
                  d="M848.64 929.57h-667.2c-34.33 0-61.39-30.58-55.83-64.45 30.77-187.31 193.41-330.21 389.43-330.21s358.66 142.9 389.43 330.21c5.56 33.87-21.5 64.45-55.83 64.45z"
                  fill="#ffffff"/>
               <path d="M515.04 287.1m-214.72 0a214.72 214.72 0 1 0 429.44 0 214.72 214.72 0 1 0-429.44 0Z"
                     fill="#ffffff"/>
               <path
                  d="M377.49 317.07c-10.53 0-19.36-8.23-19.96-18.87-2.23-38.99 10.86-76.52 36.85-105.66s61.78-46.43 100.77-48.66c11.05-0.63 20.49 7.8 21.13 18.84 0.63 11.04-7.8 20.49-18.84 21.13-28.32 1.62-54.31 14.17-73.18 35.34-18.88 21.17-28.38 48.42-26.76 76.73 0.63 11.04-7.8 20.49-18.84 21.13-0.4 0.01-0.79 0.02-1.17 0.02z"
                  fill="#ffffff"/>
            </svg>
         </div>
         <!-- 登录表单 -->
         <div class="login_form">
            <el-form label-width="0px" :model="loginForm" :rules="loginFormRules" status-icon ref="loginFormRef">
               <!-- 用户名输入框 -->
               <el-form-item prop="userId">
                  <el-input type="text" prefix-icon="el-icon-user" placeholder="学号 / 职工号"
                            v-model.trim.lazy="loginForm.userId"></el-input>
                  <!-- 用户名验证信息 -->
               </el-form-item>
               <!-- 用户密码输入框 -->
               <el-form-item prop="userWord">
                  <el-input type="password" prefix-icon="el-icon-lock" placeholder="密码" v-model.trim.lazy="loginForm.userWord"></el-input>
                  <!-- 密码验证信息 -->
               </el-form-item>
               <!-- 忘记密码链接 -->
               <el-form-item class="forget_link">
                  <el-link type="info">忘记密码</el-link>
               </el-form-item>
               <!-- 登录按钮 -->
               <el-form-item class="buttons">
                  <el-button type="primary" round @click="loginButton">登录</el-button>
               </el-form-item>
            </el-form>
         </div>
      </div>
   </div>
</template>

<script>
   export default {
      name: 'Login',
      data () {
         // 定义密码校验规则
         const validatePass = (rule, value, callback) => {
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
         return {
            loginForm: {
               userId: '',
               userWord: '',
            },
            // 登录表单校验
            loginFormRules: {
               // 学号/职工号的校验
               userId: [
                  {
                     required: true,
                     message: '请输入学号/职工号！',
                     trigger: 'blur'
                  },
                  {
                     min: 8,
                     max: 10,
                     message: '学号/职工号长度在 8 到 10 个字符！',
                     trigger: 'blur'
                  },
               ],
               userWord: [
                  {
                     validator: validatePass,
                     trigger: 'blur'
                  },
               ]
            }
         }
      },
      methods: {
         // 登录按钮的点击事件
         loginButton () {
            // 对登录表的校验的结果进行判断,只有通过了校验才能向后端发出登录请求
            this.$refs.loginFormRef.validate(async valid => {
               // console.log(valid); 登录表的校验是否通过 valid 是一个boolean值
               // 登录表单未通过校验终止登录事件
               if (!valid) {
                  // 对密码输入框置空
                  this.loginForm.userWord = '';
                  // 终止登录事件
                  return;
               }
               // 通过了登录表单校验之后向后端发出登录请求,获取返回值
               /*this.$http({
                  method: 'post',
                  url: '/login',
                  data: this.loginForm
               }).then(res => {
                  console.log(res);
               });*/
               const { data: res } = await this.$http.post('/sys/login', this.loginForm);
               // console.log(res);
               // 当后台的响应内容中,状态码的为200即登录成功,不是200则弹窗报错
               if (res.code !== 200) {
                  // 对密码输入框置空
                  this.loginForm.userWord = '';
                  return /*this.$message.error('登录失败！')*/this.$alert(res.message, '警告', {
                     confirmButtonText: '确定',
                     callback: action => {
                        this.$message({
                           type: 'info',
                           message: `action: ${action}`
                        })
                     }
                  });
                  // eslint-disable-next-line brace-style
               }
               /*this.$message.success('登录成功！');*/
               else {
                  /*this.$alert(res.info, '正常', {
                     confirmButtonText: '确定',
                     callback: action => {
                        this.$message({
                           type: 'info',
                           message: `action: ${action}`
                        })
                     }
                  });*/
                  // 1. 将登录之后的 token 保存到客户端的 sessionStorage 中
                  // 1.1 项目中除了登录的其他 API 接口,只有在登陆之后才能访问
                  // 1.2 token 只有在当前网站打开生效,所以将 token 保存在sessionStorage 中
                  window.sessionStorage.setItem('token', res.data.token);
                  // sessionStorage.setItem('token', res.data.token);
                  // console.log(res.data.token);
                  // 2. 置空登录表单并移除登录表单的校验结果
                  this.$refs.loginFormRef.resetFields();
                  // 3. 通过编程式导航跳转到后台页面
                  await this.$router.push('/home');
               }
            });
         }
      }
   }
</script>

<style lang="less" scoped>
   .login_container {
      background-color: rgba(0, 0, 0, .2);
      width: 100%;
      height: 100%;
      position: absolute;
      top: 0;
      left: 0;

      .login_panel {
         width: 400px;
         height: 460px;
         background-color: #fafafa;
         border-radius: 16px;
         position: absolute;
         overflow: hidden;
         top: 50%;
         left: 50%;
         transform: translate(-50%, -50%);

         .login_header {
            width: 100%;
            margin-bottom: 32px;

            h1 {
               font-size: 28px;
               color: #393b3d;
               text-align: center;
               padding: 10px 0;
            }
         }

         .login_avatar {
            width: 60px;
            height: 60px;
            border-radius: 50%;
            background-color: orange;
            position: absolute;
            left: 50%;
            transform: translateX(-50%);

            svg {
               width: 48px;
               height: 48px;
               position: absolute;
               top: 50%;
               left: 50%;
               transform: translate(-50%, -50%);
            }
         }

         .login_form {
            width: calc(100% - 40px);
            height: 300px;
            padding: 0 20px;
            transform: translateY(120px);

            .forget_link {
               display: flex;
               justify-content: flex-end;
            }

            .buttons {
               display: flex;
               display: -webkit-flex;
               display: -ms-flex;
               justify-content: center;
               -webkit-justify-content: center;
            }
         }
      }
   }
</style>
