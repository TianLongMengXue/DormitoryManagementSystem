# 模块划分
## src-dms
父工程
- 所有的模块都依赖与这个模块
- 所有的非项目子模块依赖均在父工程中导入
## dms-common
公共模块
- entity: 响应实体类
- constant: 常量类
- exception: 自定义异常类
- utils: 工具类
- pojo: 数据库实体类
## dms-common-model
公共模型模块
- shiro
    - config: shiro配置类
    - realm: shiro realm授权类
- controller: 模块通用的控制类
- service: 模块通用的服务接口
    - impl: 模块通用的服务接口实现
- mapper: 持久层接口类
- classpath:mapper/*.xml: 持久层实现类
## dms-system 系统模块启动类
用户的认证
接口: http://url:65534/dms/sys/login
接口: http://url:65534/dms/sys/logout
16478060 Cwq.1998+
16478067 Lyf.1997+ (班长)
16478080 Jcx.1999+ 
16478081 Gpc.1997+ (学生)
16478082 Yl.1997+ ()
## dms-system 主页模块启动类
宿管简介、综合、例检、抽检、晚归、考评、宿管公告、下载、个人信息面板
接口: http://url:65533/dms/home/infoName
接口: http://url:65533/dms/home/articleMenu
接口: http://url:65533/dms/home/articleList
接口: http://url:65533/dms/home/introduce
接口: http://url:65533/dms/home/articleDetail
接口: http://url:65533/dms/home/userInfo

# 数据库
# 数据库 db_dms
```mysql
create database db_dms character set utf8 collate utf8_general_ci;
```
## 用户登录表 sys_login
user_id(学号/职工号),user_word(密码)
```mysql
create table sys_login(
    user_id varchar(16) collate utf8_general_ci not null primary key comment '学号/职工号',
    user_word varchar(32) collate utf8_general_ci not null comment '登录密码'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
```java
@SpringBootTest
public class LoginMapperTest {
    @Autowired
    LoginMapper loginMapper;
    @Test
    public void insertIdWordTest () {
        LoginDomain loginDomain1 = new LoginDomain("16478060", new Md5Hash("Cwq.1998+", "16478060", 3).toBase64());
        LoginDomain loginDomain2 = new LoginDomain("16478067", new Md5Hash("Lyf.1997+", "16478067", 3).toBase64());
        LoginDomain loginDomain3 = new LoginDomain("16478080", new Md5Hash("Jcx.1999+", "16478080", 3).toBase64());
        LoginDomain loginDomain4 = new LoginDomain("16478081", new Md5Hash("Gpc.1997+", "16478081", 3).toBase64());
        LoginDomain loginDomain5 = new LoginDomain("16478082", new Md5Hash("Yl.1997+", "16478082", 3).toBase64());
        loginMapper.insertIdWord(loginDomain1);
        loginMapper.insertIdWord(loginDomain2);
        loginMapper.insertIdWord(loginDomain3);
        loginMapper.insertIdWord(loginDomain4);
        loginMapper.insertIdWord(loginDomain5);
    }
}
```
## 用户信息表 sys_user
user_id(学号/职工号), user_name(姓名), user_tel(电话), user_mail(邮箱), create_time(用户注册时间), collage_id
(学院编号), college_name(学院名称)
```mysql
create table sys_user(
    user_id varchar(16) character set utf8 collate utf8_general_ci not null primary key comment '学号/职工号',
    user_name varchar(255) character set utf8 collate utf8_general_ci not null comment '姓名',
    user_tel char(11) character set utf8 collate utf8_general_ci not null comment '手机号',
    user_mail varchar(320) character set utf8 collate utf8_general_ci not null comment '邮箱',
    create_time datetime collate utf8_general_ci not null comment '注册时间',
    college_id varchar(20) character set utf8 collate utf8_general_ci not null comment '学院编号',
    college_name varchar(255) character set utf8 collate utf8_general_ci not null comment '学院名称'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## 登录时间表 sys_login_time
id(自增的表列名), userId(学号/职工号), last_time(最近一次登录时间)
```mysql
create table sys_login_time(
    id int collate utf8_general_ci not null auto_increment primary key comment '表行号',
    user_id varchar(16) character set utf8 collate utf8_general_ci not null comment '学号/职工号',
    login_time datetime collate utf8_general_ci not null comment '登录时间'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## 角色表 sys_role
role_id(角色编号,雪花算法生成), role_name(角色名)
{学生,宿舍长,班长,寝工部部门成员,秘书部部门成员,考核部部门成员,寝工部部长,秘书部部长,考核部部长,主任,辅导员,老师,班主任,指导老师,系统管理员}
```mysql
create table sys_role(
    role_id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '角色编号',
    role_name varchar(255) character set utf8 collate utf8_general_ci not null comment '角色名称'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## 用户关联角色表 sys_user_role
id(雪花算法生成的表列名), role_id(角色编号),user_id(学号/职工号)
```mysql
create table sys_user_role(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    user_id varchar(16) character set utf8 collate utf8_general_ci not null comment '学号/职工号',
    role_id varchar(20) character set utf8 collate utf8_general_ci not null comment '角色编号'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## 权限表 sys_perm
perm_id(权限编号,雪花算法生成), perm_name(权限名称), perm_desc(权限描述), perm_type(权限类型), par_perm(父权限,无:null,有:perm_id)
```mysql
create table sys_perm(
    perm_id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '权限编号',
    perm_name varchar(255) character set utf8 collate utf8_general_ci not null comment '权限名称',
    perm_desc text character set utf8 collate utf8_general_ci not null comment '权限描述',
    perm_type tinyint(4) collate utf8_general_ci not null comment '权限类型,0菜单,1按钮,2接口',
    par_perm varchar(20) character set utf8 collate utf8_general_ci default null comment '父级权限'
)engine=innodb default charset=utf8 collate utf8_general_ci;
```
## 角色关联权限表 sys_role_perm
id(雪花算法生成的表列名), role_id(角色编号), perm_id(权限编号)
```mysql
create table sys_role_perm(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    role_id varchar(20) character set utf8 collate utf8_general_ci not null comment '角色编号',
    perm_id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '权限编号'
)engine=innodb default charset=utf8 collate utf8_general_ci;
```
## 菜单表 sys_menu
id(雪花算法生成的表列名), perm_id(权限编码), menu_icon(菜单项图标), menu_order(菜单项顺序)
```mysql
create table sys_menu(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    perm_id varchar(20) character set utf8 collate utf8_general_ci not null comment '权限编号',
    menu_icon varchar(40) character set utf8 collate utf8_general_ci not null comment '菜单项图标',
    menu_order int(10) collate utf8_general_ci default null comment '菜单项顺序'
)engine=innodb default charset=utf8 collate utf8_general_ci;
```
## 接口表 sys_apis
id(雪花算法生成的表列名), perm_id(权限编码), api_method(请求方式), api_url(请求地址)
```mysql
create table sys_apis(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    perm_id varchar(20) character set utf8 collate utf8_general_ci not null comment '权限编号',
    api_method varchar(255) character set utf8 collate utf8_general_ci not null comment '请求方式',
    api_url varchar(255) character set utf8 collate utf8_general_ci not null comment '请求路径'
)engine=innodb default charset=utf8 collate utf8_general_ci;
```
## 功能点(按钮)表 sys_point
id(雪花算法生成的表列名), perm_id(权限编码), point_style(按钮样式), point_icon(按钮图标), point_status(按钮状态)
```mysql
create table sys_point(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    perm_id varchar(20) character set utf8 collate utf8_general_ci not null comment '权限编号',
    point_style varchar(20) character set utf8 collate utf8_general_ci comment '功能点(按钮)样式',
    point_icon varchar(20) character set utf8 collate utf8_general_ci comment '功能点(按钮)图标',
    point_status int(11) collate utf8_general_ci not null comment '功能点(按钮)状态'
)engine=innodb default charset=utf8 collate utf8_general_ci;
```
## home_menu
menu_id(雪花算法生成), menu_name(文章菜单名称)
```mysql
create table home_menu (
    menu_id tinyint(4) collate utf8_general_ci not null primary key comment '菜单编号',
    menu_name varchar(255) collate utf8_general_ci not null comment '菜单名称'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## home_article
article_id(文章编号), college_id(学院编号), menu_id(菜单编号), article_time(上传时间), article_title(标题), article_desc(说明), article_post(发布者), check_id(检查时间)
```mysql
create table home_article(
    article_id varchar(20) character set utf8 collate utf8_general_ci primary key not null comment '文章编号',
    college_id varchar(20) character set utf8 collate utf8_general_ci not null comment '学院编号',
    menu_id tinyint(4) collate utf8_general_ci not null comment '菜单编号',
    article_time datetime collate utf8_general_ci not null comment '文章发布时间',
    check_time datetime collate utf8_general_ci not null comment '检查时间',
    article_title varchar(255) character set utf8 collate utf8_general_ci not null comment '文章标题',
    article_desc varchar(255) character set utf8 collate utf8_general_ci not null comment '文章说明',
    article_post varchar(255) character set utf8 collate utf8_general_ci not null comment '文章发布者',
    article_type varchar(255) character set utf8 collate utf8_general_ci not null comment '文章类型'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## home_introduce
title(标题), sub_title(简介一), sub_img(合照一), qin(简介二), qin_img(合照二), mi(简介三), mi_img(合照三), kao(简介四), kao_img(合照四)
```mysql
create table home_introduce(
    menu_id tinyint collate utf8_general_ci not null primary key comment '菜单编号',
    title varchar(255) character set utf8 collate utf8_general_ci not null comment '文章标题',
    sub_title varchar(300) character set utf8 collate utf8_general_ci not null comment '简介一',
    sub_img varchar(300) character set utf8 collate utf8_general_ci not null comment '合照一',
    qin varchar(300) character set utf8 collate utf8_general_ci not null comment '简介二',
    qin_img varchar(300) character set utf8 collate utf8_general_ci not null comment '合照二',
    mi varchar(300) character set utf8 collate utf8_general_ci not null comment '简介三',
    mi_img varchar(300) character set utf8 collate utf8_general_ci not null comment '合照三',
    kao varchar(300) character set utf8 collate utf8_general_ci not null comment '简介四',
    kao_img varchar(300) character set utf8 collate utf8_general_ci not null comment '合照四'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## result_case
id(雪花算法生成的表列名), article_id(文章编号), build_num(栋数), dor_num(宿舍号), class_name(班级名称), score(分数), desc(备注), class_head
(班主任), dor_head(宿舍长)
```mysql
create table result_case(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    article_id varchar(20) character set utf8 collate utf8_general_ci not null comment '文章编号',
    build_num varchar(255) character set utf8 collate utf8_general_ci not null comment '栋数',
    dor_num varchar(255) character set utf8 collate utf8_general_ci not null comment '宿舍',
    class_name varchar(255) character set utf8 collate utf8_general_ci not null comment '班级',
    score double(4,2) collate utf8_general_ci not null comment '卫生情况',
    case_desc varchar(255) character set utf8 collate utf8_general_ci not null comment '备注',
    class_head varchar(255) character set utf8 collate utf8_general_ci not null comment '班主任',
    dor_head varchar(255) character set utf8 collate utf8_general_ci not null comment '宿舍长'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## result_case_col
article_type(文章类型), build_num(栋数), dor_num(宿舍), class_name(班级), score(卫生情况), case_desc(备注), class_head(班主任), dor_head(宿舍长)
## result_night
id(雪花算法生成的表列名), article_id(文章编号), dor_num(宿舍号), class_name(班级名称), user_name(姓名)
```mysql
create table result_night(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    article_id varchar(20) character set utf8 collate utf8_general_ci not null comment '文章编号',
    dor_num varchar(255) character set utf8 collate utf8_general_ci not null comment '宿舍',
    class_name varchar(255) character set utf8 collate utf8_general_ci not null comment '班级',
    user_name varchar(255) character set utf8 collate utf8_general_ci not null comment '姓名'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## result_night_col
article_type(文章类型), dor_num(宿舍), class_name(班级), user_name(姓名)
## result_star
id(雪花算法生成的表列名), article_id(文章编号), dor_num(宿舍号), s1(第一次), s2(第二次), s3(第三次), s4(第四次), s5(第五次), s6(第六次), s7(第七次), s8(第八次), ave_score
(得分), grade(对应星级)
```mysql
create table result_star(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    article_id varchar(20) character set utf8 collate utf8_general_ci not null comment '文章编号',
    dor_num varchar(255) character set utf8 collate utf8_general_ci not null comment '宿舍',
    s1 tinyint collate utf8_general_ci comment '第一次',
    s2 tinyint collate utf8_general_ci comment '第二次',
    s3 tinyint collate utf8_general_ci comment '第三次',
    s4 tinyint collate utf8_general_ci comment '第四次',
    s5 tinyint collate utf8_general_ci comment '第五次',
    s6 tinyint collate utf8_general_ci comment '第六次',
    s7 tinyint collate utf8_general_ci comment '第七次',
    s8 tinyint collate utf8_general_ci comment '第八次',
    ave_score double(5,2) collate utf8_general_ci not null comment '得分',
    grade char(5) character set utf8 collate utf8_general_ci not null comment '对应星级'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## result_star_col
article_type(文章类型), dor_num(宿舍), s1(第一次), s2(第二次), s3(第三次), s4(第四次), s5(第五次), s6(第六次), s7(第七次), s8(第八次), ave_score(得分), grade(对应星级)
## result_civil
id(雪花算法生成的表列名), article_id(文章编号), dor_num(宿舍号), college_name(学院名称), class_head(班主任), assistant(辅导员), grade(等级)
```mysql
create table result_civil(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    article_id varchar(20) character set utf8 collate utf8_general_ci not null comment '文章编号',
    dor_num varchar(255) character set utf8 collate utf8_general_ci not null comment '宿舍',
    college_name varchar(255) character set utf8 collate utf8_general_ci not null comment '学院名称',
    class_head varchar(255) character set utf8 collate utf8_general_ci not null comment '班主任',
    assistant varchar(255) character set utf8 collate utf8_general_ci not null comment '辅导员',
    grade char(4) character set utf8 collate utf8_general_ci not null comment '等级' default '文明寝室'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## result_civil_col
article_type(), dor_num(宿舍), college_name(学院名称), class_head(班主任), assistant(辅导员), grade(文明寝室)
## result_check_class
id(雪花算法生成的表列名), article_id(文章编号), class_head(班主任), class_name(班级名称), dor_count(宿舍总数), check_count(检查次数), good_count(好寝个数), good_score
(好寝得分), bad_count(差寝个数), bad_score(差寝扣分), bed_count(未叠被子人数), bed_score(未叠被子扣分), night_count(晚归缺寝人数), night_score
(晚归缺寝扣分), ban_count
(违禁物品), ban_score(违禁物品扣分), criticize_count(通报批评人数), criticize_score(通报批评扣分), praise_count(通报表扬人数), praise_score
(通报表扬得分), final_score(考评得分)
```mysql
create table result_check_class(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    article_id varchar(20) character set utf8 collate utf8_general_ci not null comment '文章编号',
    class_head varchar(255) character set utf8 collate utf8_general_ci not null comment '班主任',
    class_name varchar(255) character set utf8 collate utf8_general_ci not null comment '班级',
    dor_count tinyint collate utf8_general_ci not null comment '宿舍总数',
    check_count tinyint collate utf8_general_ci not null comment '检查次数',
    good_count tinyint collate utf8_general_ci not null comment '好寝个数',
    good_score double(5,2) collate utf8_general_ci not null comment '好寝得分',
    bad_count tinyint collate utf8_general_ci not null comment '差寝个数',
    bad_score double(5,2) collate utf8_general_ci not null comment '差寝扣分',
    bed_count tinyint collate utf8_general_ci not null comment '未叠被子人数',
    bed_score double(6,2) collate utf8_general_ci not null comment '未叠被子扣分',
    night_count tinyint collate utf8_general_ci not null comment '晚归缺寝人数',
    night_score double(6,2) collate utf8_general_ci not null comment '晚归缺寝扣分',
    ban_count tinyint collate utf8_general_ci not null comment '违禁物品',
    ban_score double(6,2) collate utf8_general_ci not null comment '违禁物品扣分',
    criticize_count tinyint collate utf8_general_ci not null comment '通报批评人数',
    criticize_score double(6,2) collate utf8_general_ci not null comment '通报批评扣分',
    praise_count tinyint collate utf8_general_ci not null comment '通报表扬人数',
    praise_score double(6,2) collate utf8_general_ci not null comment '通报表扬得分',
    final_score double(10,2) collate utf8_general_ci not null comment '考评得分'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## result_check_col
article_type(文章类型), class_head(班主任), class_name(班级), dor_count(宿舍总数), check_count(检查次数), good_count(好寝个数), good_score(好寝得分), bad_count
(差寝个数), bad_score(差寝扣分), bed_count(未叠被子人数), bed_score(未叠被子扣分), night_count(晚归缺寝人数), night_score(晚归缺寝扣分), ban_count(违禁物品), ban_score(违禁物品扣分), criticize_count(通报批评人数), criticize_score(通报批评扣分), praise_count(通报表扬人数), praise_score(通报表扬得分), final_score(考评得分)
## result_criticize
id(雪花算法生成的表列名), article_id(文章编号), class_name(班级名称), user_name(姓名)
```mysql
create table result_criticize(
    id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    article_id varchar(20) character set utf8 collate utf8_general_ci not null comment '文章编号',
    class_name varchar(255) character set utf8 collate utf8_general_ci not null comment '班级',
    user_name varchar(255) character set utf8 collate utf8_general_ci not null comment '姓名'
)engine=innodb default charset=utf8 collate=utf8_general_ci;
```
## result_criticize_col
aricle_type(文章类型), class_name(班级), user_name(姓名)
```mysql
create table result_criticize_col
(
    article_type varchar(20) character set utf8 collate utf8_general_ci  not null primary key comment '文章类型',
    record_name  varchar(255) character set utf8 collate utf8_general_ci not null comment '表列名',
    num          tinyint collate utf8_general_ci                         not null comment '顺序'
) engine = innodb
  default charset = utf8
  collate = utf8_general_ci;
```
## 班级表 ctrl_class
class_id(班级编号,雪花算法生成), class_name(班级名称)
```mysql
create table ctrl_class
(
    class_id   varchar(20) character set utf8 collate utf8_general_ci  not null primary key comment '班级编号',
    class_name varchar(255) character set utf8 collate utf8_general_ci not null comment '班级名称'
) engine = innodb
  default charset = utf8
  collate = utf8_general_ci;
```
## 学生关联班级表 ctrl_stu_class
id(表行号,雪花算法), user_id(学号), class_id(班级编号)
```mysql
create table ctrl_stu_class
(
    id       varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    user_id  varchar(16) character set utf8 collate utf8_general_ci not null comment '学号',
    class_id varchar(20) character set utf8 collate utf8_general_ci not null comment '班级编号'
) engine = innodb
  default charset = utf8
  collate = utf8_general_ci;
```
## 教师关联班级表 ctrl_tea_class
id(表行号,雪花算法), user_id(职工号), class_id(班级编号)
```mysql
create table ctrl_tea_class
(
    id       varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '表行号',
    user_id  varchar(16) character set utf8 collate utf8_general_ci not null comment '职工号',
    class_id varchar(20) character set utf8 collate utf8_general_ci not null comment '班级编号'
) engine = innodb
  default charset = utf8
  collate = utf8_general_ci;
```
## 宿舍表 ctrl_dor
dor_id(宿舍编号,雪花算法生成), build_num(栋数), dor_num(宿舍号)
```mysql
create table ctrl_dor (
    dor_id varchar(20) character set utf8 collate utf8_general_ci not null primary key comment '宿舍编号',
    build_num varchar(10) character set utf8 collate utf8_general_ci not null comment '栋数',
    dor_num varchar(20) character set utf8 collate utf8_general_ci not null comment '宿舍号'
)engine = innodb default charset = utf8 collate = utf8_general_ci;
```
## 学生关联宿舍表 ctrl_stu_dor
user_id(学号), dor_id(宿舍编号), bed_num(床位号)
```mysql
create table ctrl_stu_dor
(
    user_id  varchar(16) character set utf8 collate utf8_general_ci not null comment '学号',
    dor_id varchar(20) character set utf8 collate utf8_general_ci not null comment '寝室号',
    bed_num int collate utf8_general_ci not null comment '床位号'
) engine = innodb
  default charset = utf8
  collate = utf8_general_ci;
```
## 宿舍长关联宿舍表表 ctrl_dor_head
id(表行号,雪花算法), user_id(职工号), dor_id(宿舍编号)
```mysql
create table ctrl_dor_head
(
    user_id  varchar(16) character set utf8 collate utf8_general_ci not null comment '学号',
    dor_id varchar(20) character set utf8 collate utf8_general_ci not null comment '寝室编号'
) engine = innodb
  default charset = utf8
  collate = utf8_general_ci;
```
## 辅导员关联宿舍表 ctrl_dor_assistant
id(表行号,雪花算法), user_id(职工号), dor_id(宿舍编号)
```mysql
create table ctrl_dor_assistant
(
    user_id  varchar(16) character set utf8 collate utf8_general_ci not null comment '职工号',
    dor_id varchar(20) character set utf8 collate utf8_general_ci not null comment '寝室号'
) engine = innodb
  default charset = utf8
  collate = utf8_general_ci;
```
