module.exports = {
   root: true,
   env: {
      node: true
   },
   extends: [
      'plugin:vue/essential',
      '@vue/standard'
   ],
   parserOptions: {
      parser: 'babel-eslint'
   },
   rules: {
      'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
      'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
      'indent': 'off', // 关闭缩进检查
      'no-new': 'off', // 关闭文件末尾没有空的新行检查
      'next-line': 'off', // 关闭换行检查
      'no-trailing-spaces': 'off', // 关闭多余空格检查
      'func-call-spacing': 'off', // 关闭子函数预父函数之间需要使用空行分隔检查
      'semi': 'off', // 关闭代码结尾不使用 ; 结束的检查
      'comma-dangle': 'off', // 关闭代码结尾处使用 , 结尾的检查
      'spaced-comment': 'off', // 关闭注释内容时 '/*'后需要一个空格与'*/'前需要一个空格的检查
      'vue/no-use-v-if-with-v-for': 'off', // 关闭v-for和v-if写为同一标签属性时报错
  }
};
