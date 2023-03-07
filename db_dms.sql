/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.6
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 192.168.1.6:3306
 Source Schema         : db_dms

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 07/05/2020 19:36:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ctrl_class
-- ----------------------------
DROP TABLE IF EXISTS `ctrl_class`;
CREATE TABLE `ctrl_class`  (
  `class_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级编号',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ctrl_class
-- ----------------------------
INSERT INTO `ctrl_class` VALUES ('1258272291221946368', '软件工程1602');

-- ----------------------------
-- Table structure for ctrl_dor
-- ----------------------------
DROP TABLE IF EXISTS `ctrl_dor`;
CREATE TABLE `ctrl_dor`  (
  `dor_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍编号',
  `build_num` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栋数',
  `dor_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍号',
  PRIMARY KEY (`dor_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ctrl_dor
-- ----------------------------
INSERT INTO `ctrl_dor` VALUES ('1258288267741130752', '13栋', '13-210');
INSERT INTO `ctrl_dor` VALUES ('1258288271209820160', '12栋', '12-220');
INSERT INTO `ctrl_dor` VALUES ('1258288274984693760', '12栋', '12-301');

-- ----------------------------
-- Table structure for ctrl_dor_assistant
-- ----------------------------
DROP TABLE IF EXISTS `ctrl_dor_assistant`;
CREATE TABLE `ctrl_dor_assistant`  (
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职工号',
  `dor_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '寝室号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ctrl_dor_head
-- ----------------------------
DROP TABLE IF EXISTS `ctrl_dor_head`;
CREATE TABLE `ctrl_dor_head`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `dor_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '寝室号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ctrl_dor_head
-- ----------------------------
INSERT INTO `ctrl_dor_head` VALUES ('1258288282073067520', '16478080', '1258288271209820160');

-- ----------------------------
-- Table structure for ctrl_stu_class
-- ----------------------------
DROP TABLE IF EXISTS `ctrl_stu_class`;
CREATE TABLE `ctrl_stu_class`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `class_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ctrl_stu_class
-- ----------------------------
INSERT INTO `ctrl_stu_class` VALUES ('1258272300789153792', '16478060', '1258272291221946368');
INSERT INTO `ctrl_stu_class` VALUES ('1258272304085876736', '16478067', '1258272291221946368');
INSERT INTO `ctrl_stu_class` VALUES ('1258272307395182592', '16478080', '1258272291221946368');
INSERT INTO `ctrl_stu_class` VALUES ('1258272310763208704', '16478081', '1258272291221946368');
INSERT INTO `ctrl_stu_class` VALUES ('1258272314307395584', '16478082', '1258272291221946368');

-- ----------------------------
-- Table structure for ctrl_stu_dor
-- ----------------------------
DROP TABLE IF EXISTS `ctrl_stu_dor`;
CREATE TABLE `ctrl_stu_dor`  (
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `dor_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '寝室号',
  `bed_num` int(11) NOT NULL COMMENT '床位号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ctrl_stu_dor
-- ----------------------------
INSERT INTO `ctrl_stu_dor` VALUES ('16478060', '1258288271209820160', 6);
INSERT INTO `ctrl_stu_dor` VALUES ('16478067', '1258288267741130752', 3);
INSERT INTO `ctrl_stu_dor` VALUES ('16478080', '1258288271209820160', 1);
INSERT INTO `ctrl_stu_dor` VALUES ('16478081', '1258288274984693760', 2);
INSERT INTO `ctrl_stu_dor` VALUES ('16478082', '1258288267741130752', 4);

-- ----------------------------
-- Table structure for ctrl_tea_class
-- ----------------------------
DROP TABLE IF EXISTS `ctrl_tea_class`;
CREATE TABLE `ctrl_tea_class`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职工号',
  `class_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for home_article
-- ----------------------------
DROP TABLE IF EXISTS `home_article`;
CREATE TABLE `home_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表行号',
  `article_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章编号',
  `college_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院编号',
  `menu_id` tinyint(4) NOT NULL COMMENT '菜单编号',
  `article_time` datetime(0) NOT NULL COMMENT '文章发布时间',
  `check_time` datetime(0) NULL DEFAULT NULL COMMENT '检查时间',
  `article_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `article_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章说明',
  `article_post` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章发布者',
  `article_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_article
-- ----------------------------
INSERT INTO `home_article` VALUES (1, '1251470520445083651', '1250317154721492992', 2, '2020-04-18 19:19:59', '2018-06-04 00:00:00', '信息与计算机工程学院寝室例检卫生结果通报', '2018年6月4日周三下午16点30分学院例检，本次例检检查结果共计60个好寝，2个差寝', '宿管委员会寝工部', '1252111655584735232');
INSERT INTO `home_article` VALUES (2, '1251470520445083652', '1250317154721492992', 2, '2020-04-18 19:19:59', '2018-06-06 00:00:00', '信息与计算机工程学院寝室例检卫生结果通报', '2018年6月6日周三下午16点30分学院例检，本次例检检查结果共计63个好寝，0个差寝', '宿管委员会寝工部', '1252111655584735232');
INSERT INTO `home_article` VALUES (3, '1251470520445083648', '1250317154721492992', 2, '2020-04-18 19:19:58', NULL, '信息与计算机工程学院第十四周通报批评', '第十四周例检中，共计7位未叠被子、2个差寝', '宿管委员会考核部', '1252111665160331264');
INSERT INTO `home_article` VALUES (4, '1251470520445083653', '1250317154721492992', 2, '2020-04-18 19:19:59', '2018-06-11 00:00:00', '信息与计算机工程学院寝室例检卫生结果通报', '2018年6月11日周三下午16点30分学院例检，本次例检检查结果共计53个好寝，0个差寝', '宿管委员会寝工部', '1252111655584735232');
INSERT INTO `home_article` VALUES (5, '1251470520445083654', '1250317154721492992', 2, '2020-04-18 19:19:59', '2018-06-13 00:00:00', '信息与计算机工程学院寝室例检卫生结果通报', '2018年6月13日周三下午16点30分学院例检，本次例检检查结果共计53个好寝，0个差寝', '宿管委员会寝工部', '1252111655584735232');
INSERT INTO `home_article` VALUES (6, '1251470520445083649', '1250317154721492992', 2, '2020-04-18 19:19:59', NULL, '信息与计算机工程学院第十五周通报批评', '第十五周例检中，共计12位未叠被子', '宿管委员会考核部', '1252111665160331264');
INSERT INTO `home_article` VALUES (7, '1251470520445083659', '1250317154721492992', 4, '2020-04-18 19:19:59', '2018-06-21 00:00:00', '信息与计算机工程学院第十六周晚归抽查通报批评', '第十六周晚归抽查中共计3位缺寝晚归', '宿管委员会考核部', '1252111661351903232');
INSERT INTO `home_article` VALUES (8, '1251470520445083655', '1250317154721492992', 3, '2020-04-18 19:19:59', NULL, '信息与计算机工程学院第十六周通报批评', '第十六周抽检中，共计4位未叠被子', '宿管委员会考核部', '1252111665160331264');
INSERT INTO `home_article` VALUES (9, '1251470520445083650', '1250317154721492992', 2, '2020-04-18 19:19:59', NULL, '信息与计算机工程学院第十六周通报批评', '第十六周例检中，共计1位未叠被子', '宿管委员会考核部', '1252111665160331264');
INSERT INTO `home_article` VALUES (10, '1251470520445083656', '1250317154721492992', 5, '2020-04-18 19:19:59', NULL, '信息与计算机工程学院2018年6月文明宿舍', '信息与计算机工程学院2018年6月共计评选23个文明宿舍', '宿管委员会考核部', '1252111671279820800');
INSERT INTO `home_article` VALUES (11, '1251470520445083657', '1250317154721492992', 5, '2020-04-18 19:19:59', NULL, '信息与计算机工程学院2018年6月星级寝室', '信息与计算机工程学院2018年6月共计评选76个三星级、13个二星级、2个一星级宿舍', '宿管委员会考核部', '1252111668083761152');
INSERT INTO `home_article` VALUES (12, '1251470520445083658', '1250317154721492992', 5, '2020-04-18 19:19:59', NULL, '信息与计算机工程学院2018年6月班级月度考评表', '信息与计算机工程学院2018年6月班级月度考评', '宿管委员会考核部', '1252111674438131712');

-- ----------------------------
-- Table structure for home_article_type
-- ----------------------------
DROP TABLE IF EXISTS `home_article_type`;
CREATE TABLE `home_article_type`  (
  `article_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章类型',
  `article_api` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后台接口',
  PRIMARY KEY (`article_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_article_type
-- ----------------------------
INSERT INTO `home_article_type` VALUES ('1252111655584735232', 'case');
INSERT INTO `home_article_type` VALUES ('1252111661351903232', 'night');
INSERT INTO `home_article_type` VALUES ('1252111665160331264', 'criticize');
INSERT INTO `home_article_type` VALUES ('1252111668083761152', 'star');
INSERT INTO `home_article_type` VALUES ('1252111671279820800', 'civil');
INSERT INTO `home_article_type` VALUES ('1252111674438131712', 'checkClass');

-- ----------------------------
-- Table structure for home_introduce
-- ----------------------------
DROP TABLE IF EXISTS `home_introduce`;
CREATE TABLE `home_introduce`  (
  `menu_id` tinyint(4) NOT NULL COMMENT '菜单编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `sub_title` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介一',
  `sub_img` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合照一',
  `qin` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介二',
  `qin_img` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合照二',
  `mi` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介三',
  `mi_img` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合照三',
  `kao` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介四',
  `kao_img` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合照四',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_introduce
-- ----------------------------
INSERT INTO `home_introduce` VALUES (0, '信息与计算机工程学院宿管委员会简介', '信息与计算机工程学院宿管委员会成立于2017年11月11日,前身为信息与计算机工程学院团总支学生分会宿管部;宿管委员会下设寝工部、秘书部、考核部三个部门,由指导老师、主任、部长及部门成员组成。', '../../assets/images/img_00.jpg', '寝工部负责例检、抽检及相关工作。', '../../assets/images/img_01.jpg', '秘书部负责反馈、报修、宿管日常工作记录及相关工作。', '../../assets/images/img_02.jpg', '考核部负责通报、晚归、考评及相关工作。', '../../assets/images/img_03.jpg');

-- ----------------------------
-- Table structure for home_menu
-- ----------------------------
DROP TABLE IF EXISTS `home_menu`;
CREATE TABLE `home_menu`  (
  `menu_id` tinyint(4) NOT NULL COMMENT '菜单编号',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_menu
-- ----------------------------
INSERT INTO `home_menu` VALUES (0, '宿管简介');
INSERT INTO `home_menu` VALUES (1, '综合');
INSERT INTO `home_menu` VALUES (2, '例检');
INSERT INTO `home_menu` VALUES (3, '抽检');
INSERT INTO `home_menu` VALUES (4, '晚归');
INSERT INTO `home_menu` VALUES (5, '考评');
INSERT INTO `home_menu` VALUES (6, '宿管公告');
INSERT INTO `home_menu` VALUES (7, '下载');

-- ----------------------------
-- Table structure for result_case
-- ----------------------------
DROP TABLE IF EXISTS `result_case`;
CREATE TABLE `result_case`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `article_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章编号',
  `build_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栋数',
  `dor_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `score` double(4, 2) NULL DEFAULT NULL COMMENT '卫生情况',
  `case_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `class_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班主任',
  `dor_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍长',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_case
-- ----------------------------
INSERT INTO `result_case` VALUES ('1251470524781993984', '1251470520445083651', '1栋', '1-201', '17数媒', 9.50, NULL, '刘琪', '师溱明');
INSERT INTO `result_case` VALUES ('1251470524844908544', '1251470520445083651', '1栋', '1-202', '17数媒', 9.00, '物品摆放不整齐', '刘琪', '杨珍');
INSERT INTO `result_case` VALUES ('1251470524865880064', '1251470520445083651', '1栋', '1-203', '17数媒', 9.00, '物品摆放不整齐', '刘琪', '李蕊');
INSERT INTO `result_case` VALUES ('1251470524907823104', '1251470520445083651', '1栋', '1-204', '17数媒', 9.50, NULL, '刘琪', '李娇');
INSERT INTO `result_case` VALUES ('1251470525004292096', '1251470520445083652', '2栋', '2-701', '17数媒', 9.50, NULL, '刘琪、刘坚', '王永凤');
INSERT INTO `result_case` VALUES ('1251470525021069312', '1251470520445083652', '2栋', '2-702', '17软件1/17软件2', 9.00, '桌面摆放不整齐', '刘坚、黎元钢', '陈芷晴');
INSERT INTO `result_case` VALUES ('1251470525054623744', '1251470520445083653', '11栋', '11-701', '17数媒(本)', 9.50, NULL, '孙正广', '张莹');
INSERT INTO `result_case` VALUES ('1251470525071400960', '1251470520445083653', '11栋', '11-702', '17数媒(本)', 9.50, NULL, '孙正广', '祝悦');
INSERT INTO `result_case` VALUES ('1251470525083983872', '1251470520445083653', '11栋', '11-703', '17数媒(本)/17软件2', 9.50, NULL, '孙正广、黎元钢', '傅思梦');
INSERT INTO `result_case` VALUES ('1251470525096566784', '1251470520445083653', '11栋', '11-704', '17软件2', 9.50, NULL, '黎元钢', '曾诗雅');
INSERT INTO `result_case` VALUES ('1251470525142704128', '1251470520445083654', '19栋(一单元)', '19-1-901', '16信管', 8.50, '物品摆放不整齐，整体形象较差', '刘坚', '张正义');
INSERT INTO `result_case` VALUES ('1251470525155287040', '1251470520445083654', '19栋(一单元)', '19-1-902', '16信管', 8.00, '地面脏乱，物品摆放不整齐，整体形象较差', '刘坚', '王天旭');
INSERT INTO `result_case` VALUES ('1251470525167869952', '1251470520445083654', '19栋(一单元)', '19-1-903', '16信管/16软件2', 8.50, '物品摆放不整齐，整体形象较差', '刘坚、吴新华', '江国洲');
INSERT INTO `result_case` VALUES ('1251470525176258560', '1251470520445083654', '19栋(一单元)', '19-1-904', '17数媒(本)', 8.50, '物品摆放不整齐，整体形象较差', '孙正广', '高勇');
INSERT INTO `result_case` VALUES ('1251470525193035776', '1251470520445083654', '19栋(一单元)', '19-1-1001', '16软件2', 8.00, '①号床廖志成被子未叠，地面脏乱，整体形象较差', '吴新华', '蔡杭');
INSERT INTO `result_case` VALUES ('1251470525209812992', '1251470520445083654', '19栋(一单元)', '19-1-1002', '16软件1', 8.00, '物品摆放不整齐，垃圾未倒，整体形象较差', '肖咪咪', '李国胜');
INSERT INTO `result_case` VALUES ('1251470525230784512', '1251470520445083654', '19栋(一单元)', '19-1-1003', '16软件1', 8.00, '物品摆放不整齐，垃圾未倒，整体形象较差', '肖咪咪', '叶春晖');
INSERT INTO `result_case` VALUES ('1251470525243367424', '1251470520445083654', '19栋(一单元)', '19-1-1004', '16软件1', 8.00, '物品摆放不整齐，垃圾未倒，整体形象较差', '肖咪咪', '马志强');

-- ----------------------------
-- Table structure for result_case_col
-- ----------------------------
DROP TABLE IF EXISTS `result_case_col`;
CREATE TABLE `result_case_col`  (
  `record_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_CN',
  `col_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_EN',
  `col_order` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '列序号',
  PRIMARY KEY (`col_order`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_case_col
-- ----------------------------
INSERT INTO `result_case_col` VALUES ('宿舍', 'dorNum', 1);
INSERT INTO `result_case_col` VALUES ('班级', 'className', 2);
INSERT INTO `result_case_col` VALUES ('卫生情况', 'score', 3);
INSERT INTO `result_case_col` VALUES ('备注', 'caseDesc', 4);
INSERT INTO `result_case_col` VALUES ('班主任', 'classHead', 5);
INSERT INTO `result_case_col` VALUES ('宿舍长', 'dorHead', 6);

-- ----------------------------
-- Table structure for result_check_class
-- ----------------------------
DROP TABLE IF EXISTS `result_check_class`;
CREATE TABLE `result_check_class`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `article_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章编号',
  `class_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班主任',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `dor_count` tinyint(4) NOT NULL COMMENT '宿舍总数',
  `check_count` tinyint(4) NOT NULL COMMENT '检查次数',
  `good_count` tinyint(4) NOT NULL COMMENT '好寝个数',
  `good_score` double(5, 2) NOT NULL COMMENT '好寝得分',
  `bad_count` tinyint(4) NOT NULL COMMENT '差寝个数',
  `bad_score` double(5, 2) NOT NULL COMMENT '差寝扣分',
  `bed_count` tinyint(4) NOT NULL COMMENT '未叠被子人数',
  `bed_score` double(6, 2) NOT NULL COMMENT '未叠被子扣分',
  `night_count` tinyint(4) NOT NULL COMMENT '晚归缺寝人数',
  `night_score` double(6, 2) NOT NULL COMMENT '晚归缺寝扣分',
  `ban_count` tinyint(4) NOT NULL COMMENT '违禁物品',
  `ban_score` double(6, 2) NOT NULL COMMENT '违禁物品扣分',
  `criticize_count` tinyint(4) NOT NULL COMMENT '通报批评人数',
  `criticize_score` double(6, 2) NOT NULL COMMENT '通报批评扣分',
  `praise_count` tinyint(4) NOT NULL COMMENT '通报表扬人数',
  `praise_score` double(6, 2) NOT NULL COMMENT '通报表扬得分',
  `final_score` double(10, 2) NOT NULL COMMENT '考评得分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_check_class
-- ----------------------------
INSERT INTO `result_check_class` VALUES ('1251470525922844672', '1251470520445083658', '李希勇', '15软工1班', 8, 3, 12, 10.00, 1, 0.83, 0, 0.00, 1, 2.00, 0, 0.00, 0, 0.00, 0, 0.00, 7.17);
INSERT INTO `result_check_class` VALUES ('1251470525939621888', '1251470520445083658', '刘熹', '15软工2班', 8, 3, 9, 7.50, 2, 1.67, 9, 27.00, 1, 2.00, 0, 0.00, 0, 0.00, 0, 0.00, -23.17);
INSERT INTO `result_check_class` VALUES ('1251470525952204800', '1251470520445083658', '彭新平', '16软工1班', 7, 5, 23, 13.14, 0, 0.00, 4, 12.00, 0, 0.00, 0, 0.00, 0, 0.00, 0, 0.00, 1.14);
INSERT INTO `result_check_class` VALUES ('1251470525968982016', '1251470520445083658', '蔡方萍', '16软工2班', 8, 3, 15, 12.50, 0, 0.00, 2, 6.00, 0, 0.00, 0, 0.00, 0, 0.00, 0, 0.00, 6.50);
INSERT INTO `result_check_class` VALUES ('1251470525989953536', '1251470520445083658', '肖咪咪', '16软件1班', 5, 3, 11, 14.67, 0, 0.00, 0, 0.00, 0, 0.00, 0, 0.00, 0, 0.00, 0, 0.00, 14.67);
INSERT INTO `result_check_class` VALUES ('1251470525998342144', '1251470520445083658', '吴新华', '16软件2班', 5, 2, 5, 10.00, 0, 0.00, 3, 9.00, 0, 0.00, 0, 0.00, 0, 0.00, 0, 0.00, 1.00);

-- ----------------------------
-- Table structure for result_check_col
-- ----------------------------
DROP TABLE IF EXISTS `result_check_col`;
CREATE TABLE `result_check_col`  (
  `record_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_CN',
  `col_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_EN',
  `col_order` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '列顺序',
  PRIMARY KEY (`col_order`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_check_col
-- ----------------------------
INSERT INTO `result_check_col` VALUES ('班主任', 'classHead', 1);
INSERT INTO `result_check_col` VALUES ('班级', 'className', 2);
INSERT INTO `result_check_col` VALUES ('宿舍总数', 'dorCount', 3);
INSERT INTO `result_check_col` VALUES ('检查次数', 'checkCount', 4);
INSERT INTO `result_check_col` VALUES ('好寝个数', 'goodCount', 5);
INSERT INTO `result_check_col` VALUES ('好寝得分', 'goodScore', 6);
INSERT INTO `result_check_col` VALUES ('差寝个数', 'badCount', 7);
INSERT INTO `result_check_col` VALUES ('差寝扣分', 'badScore', 8);
INSERT INTO `result_check_col` VALUES ('未叠被子人数', 'bedCount', 9);
INSERT INTO `result_check_col` VALUES ('未叠被子扣分', 'bedScore', 10);
INSERT INTO `result_check_col` VALUES ('晚归缺寝人数', 'nightCount', 11);
INSERT INTO `result_check_col` VALUES ('晚归缺寝扣分', 'nightScore', 12);
INSERT INTO `result_check_col` VALUES ('违禁物品', 'banCount', 13);
INSERT INTO `result_check_col` VALUES ('违禁物品扣分', 'banScore', 14);
INSERT INTO `result_check_col` VALUES ('通报批评人数', 'criticizeCount', 15);
INSERT INTO `result_check_col` VALUES ('通报批评扣分', 'criticizeScore', 16);
INSERT INTO `result_check_col` VALUES ('通报表扬人数', 'praiseCount', 17);
INSERT INTO `result_check_col` VALUES ('通报表扬得分', 'praiseScore', 18);
INSERT INTO `result_check_col` VALUES ('考评得分', 'finalScore', 19);

-- ----------------------------
-- Table structure for result_civil
-- ----------------------------
DROP TABLE IF EXISTS `result_civil`;
CREATE TABLE `result_civil`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `article_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章编号',
  `dor_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍',
  `college_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院名称',
  `class_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班主任',
  `assistant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '辅导员',
  `grade` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '文明寝室' COMMENT '等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_civil
-- ----------------------------
INSERT INTO `result_civil` VALUES ('1251470525306281984', '1251470520445083656', '1-203', '信息与计算机工程学院', '刘琪', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525318864896', '1251470520445083656', '1-204', '信息与计算机工程学院', '刘琪', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525339836416', '1251470520445083656', '2-701', '信息与计算机工程学院', '刘琪、刘坚', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525352419328', '1251470520445083656', '11-702', '信息与计算机工程学院', '孙正广', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525360807936', '1251470520445083656', '11-703', '信息与计算机工程学院', '孙正广、黎元钢', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525373390848', '1251470520445083656', '11-704', '信息与计算机工程学院', '黎元钢', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525381779456', '1251470520445083656', '13-121', '信息与计算机工程学院', '黄检文、刘坚', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525402750976', '1251470520445083656', '13-122', '信息与计算机工程学院', '黄检文', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525415333888', '1251470520445083656', '13-207', '信息与计算机工程学院', '肖咪咪', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525427916800', '1251470520445083656', '13-210', '信息与计算机工程学院', '蔡方萍', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525436305408', '1251470520445083656', '13-211', '信息与计算机工程学院', '刘熹、蔡方萍', '肖咪咪、黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525448888320', '1251470520445083656', '13-212', '信息与计算机工程学院', '刘坚', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525465665536', '1251470520445083656', '6-416', '信息与计算机工程学院', '刘琪', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525478248448', '1251470520445083656', '6-510', '信息与计算机工程学院', '刘坚', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525490831360', '1251470520445083656', '6-512', '信息与计算机工程学院', '刘坚', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525499219968', '1251470520445083656', '6-513', '信息与计算机工程学院', '刘坚', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525520191488', '1251470520445083656', '6-515', '信息与计算机工程学院', '刘坚、黎元钢', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525532774400', '1251470520445083656', '19-3-912', '信息与计算机工程学院', '蔡方萍、刘琪', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525557940224', '1251470520445083656', '20-4-516', '信息与计算机工程学院', '彭新平', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525574717440', '1251470520445083656', '20-4-613', '信息与计算机工程学院', '彭新平', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525612466176', '1251470520445083656', '20-4-614', '信息与计算机工程学院', '彭新平', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525629243392', '1251470520445083656', '20-4-615', '信息与计算机工程学院', '彭新平', '黎元钢', '文明寝室');
INSERT INTO `result_civil` VALUES ('1251470525641826304', '1251470520445083656', '20-4-1015', '信息与计算机工程学院', '黎元钢', '黎元钢', '文明寝室');

-- ----------------------------
-- Table structure for result_civil_col
-- ----------------------------
DROP TABLE IF EXISTS `result_civil_col`;
CREATE TABLE `result_civil_col`  (
  `record_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_CN',
  `col_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_EN',
  `col_order` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '列顺序',
  PRIMARY KEY (`col_order`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_civil_col
-- ----------------------------
INSERT INTO `result_civil_col` VALUES ('宿舍号', 'dorNum', 1);
INSERT INTO `result_civil_col` VALUES ('学院名称', 'collegeName', 2);
INSERT INTO `result_civil_col` VALUES ('班主任', 'classHead', 3);
INSERT INTO `result_civil_col` VALUES ('辅导员', 'assistant', 4);
INSERT INTO `result_civil_col` VALUES ('等级', 'grade', 5);

-- ----------------------------
-- Table structure for result_criticize
-- ----------------------------
DROP TABLE IF EXISTS `result_criticize`;
CREATE TABLE `result_criticize`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `article_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章编号',
  `check_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '检查时间',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_criticize
-- ----------------------------
INSERT INTO `result_criticize` VALUES ('1251470524190597120', '1251470520445083648', '2018年6月4日周一例检:', '15软工2班', '未叠被子:杨燕峻、林高翔、蒋明宏、廖先斌、施晓东');
INSERT INTO `result_criticize` VALUES ('1251470524228345856', '1251470520445083648', '2018年6月4日周一例检:', '17数媒班', '未叠被子:李翔、杨政立');
INSERT INTO `result_criticize` VALUES ('1251470524450643968', '1251470520445083648', '2018年6月4日周一例检:', '15软工2班', '寝室差寝(6-311):罗家苗、杨文龙、杨燕峻、林高翔、龚俊霖、蒋明宏');
INSERT INTO `result_criticize` VALUES ('1251470524513558528', '1251470520445083648', '2018年6月4日周一例检:', '15软工2/15软工1/17数媒班', '寝室差寝(6-314):廖先斌、施晓东、邹忠诚、樊照辉、易道鑫、李翔');
INSERT INTO `result_criticize` VALUES ('1251470524559695872', '1251470520445083649', '2018年6月11日周一例检:', '15软工2班', '未叠被子:况永锋、廖阳阳、施晓东');
INSERT INTO `result_criticize` VALUES ('1251470524572278784', '1251470520445083649', '2018年6月11日周一例检:', '16软件2班', '未叠被子:廖志成、郭伦钰、肖斌');
INSERT INTO `result_criticize` VALUES ('1251470524589056000', '1251470520445083649', '2018年6月11日周一例检:', '16软工1班', '未叠被子:黄中平');
INSERT INTO `result_criticize` VALUES ('1251470524605833216', '1251470520445083649', '2018年6月13日周三例检:', '15软工2班', '未叠被子:林高翔');
INSERT INTO `result_criticize` VALUES ('1251470524630999040', '1251470520445083649', '2018年6月13日周三例检:', '16软工1班', '未叠被子:孙立鑫、高飞');
INSERT INTO `result_criticize` VALUES ('1251470524651970560', '1251470520445083649', '2018年6月13日周三例检:', '16软工2班', '未叠被子:万少波、吴彬');
INSERT INTO `result_criticize` VALUES ('1251470524727468032', '1251470520445083650', '2018年6月20日周一例检:', '16软工1班', '未叠被子：王小杰');
INSERT INTO `result_criticize` VALUES ('1251470525268533248', '1251470520445083655', '2017年12月17日抽检情况：', '15软工2班', '未叠被子:刘花朵');
INSERT INTO `result_criticize` VALUES ('1251470525281116160', '1251470520445083655', '2017年12月18日抽检情况：', '16信管班', '未叠被子:曹阮香、易心茹、钟萍红');

-- ----------------------------
-- Table structure for result_criticize_col
-- ----------------------------
DROP TABLE IF EXISTS `result_criticize_col`;
CREATE TABLE `result_criticize_col`  (
  `record_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_CN',
  `col_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_EN',
  `col_order` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '列顺序',
  PRIMARY KEY (`col_order`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_criticize_col
-- ----------------------------
INSERT INTO `result_criticize_col` VALUES ('班级', 'className', 1);
INSERT INTO `result_criticize_col` VALUES ('通报原因', 'userName', 2);

-- ----------------------------
-- Table structure for result_night
-- ----------------------------
DROP TABLE IF EXISTS `result_night`;
CREATE TABLE `result_night`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `article_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章编号',
  `dor_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_night
-- ----------------------------
INSERT INTO `result_night` VALUES ('1251470526031896576', '1251470520445083659', '13-216', '15软工1班', '刘向花');
INSERT INTO `result_night` VALUES ('1251470526044479488', '1251470520445083659', '13-216', '15软工2班', '汤露茹');
INSERT INTO `result_night` VALUES ('1251470526057062400', '1251470520445083659', '19-1-902', '16信管班', '李志波');

-- ----------------------------
-- Table structure for result_night_col
-- ----------------------------
DROP TABLE IF EXISTS `result_night_col`;
CREATE TABLE `result_night_col`  (
  `record_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_CN',
  `col_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_EN',
  `col_order` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '列顺序',
  PRIMARY KEY (`col_order`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_night_col
-- ----------------------------
INSERT INTO `result_night_col` VALUES ('宿舍', 'dorNum', 1);
INSERT INTO `result_night_col` VALUES ('班级', 'className', 2);
INSERT INTO `result_night_col` VALUES ('姓名', 'userName', 3);

-- ----------------------------
-- Table structure for result_star
-- ----------------------------
DROP TABLE IF EXISTS `result_star`;
CREATE TABLE `result_star`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `article_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章编号',
  `dor_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍',
  `s1` tinyint(4) NULL DEFAULT NULL COMMENT '第一次',
  `s2` tinyint(4) NULL DEFAULT NULL COMMENT '第二次',
  `s3` tinyint(4) NULL DEFAULT NULL COMMENT '第三次',
  `s4` tinyint(4) NULL DEFAULT NULL COMMENT '第四次',
  `s5` tinyint(4) NULL DEFAULT NULL COMMENT '第五次',
  `s6` tinyint(4) NULL DEFAULT NULL COMMENT '第六次',
  `s7` tinyint(4) NULL DEFAULT NULL COMMENT '第七次',
  `s8` tinyint(4) NULL DEFAULT NULL COMMENT '第八次',
  `hygiene_score` double(5, 2) NULL DEFAULT NULL COMMENT '卫生得分',
  `rule_score` double(5, 2) NULL DEFAULT NULL COMMENT '纪律得分',
  `ave_score` double(5, 2) NOT NULL COMMENT '得分',
  `grade` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '对应星级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_star
-- ----------------------------
INSERT INTO `result_star` VALUES ('1251470525700546560', '1251470520445083657', '1-201', 95, 90, 95, 95, 90, NULL, NULL, NULL, 65.10, 30.00, 95.10, '三星级寝室');
INSERT INTO `result_star` VALUES ('1251470525742489600', '1251470520445083657', '1-202', 90, 85, 95, 90, 85, NULL, NULL, NULL, 63.20, 30.00, 92.30, '三星级寝室');
INSERT INTO `result_star` VALUES ('1251470525759266816', '1251470520445083657', '1-203', 90, 85, 90, 90, 85, NULL, NULL, NULL, 61.60, 30.00, 91.60, '三星级寝室');
INSERT INTO `result_star` VALUES ('1251470525776044032', '1251470520445083657', '1-204', 95, 95, 95, 95, 95, NULL, NULL, NULL, 66.50, 30.00, 96.50, '三星级寝室');
INSERT INTO `result_star` VALUES ('1251470525792821248', '1251470520445083657', '2-701', 95, 95, 90, 95, 85, NULL, NULL, NULL, 64.40, 30.00, 94.40, '三星级寝室');
INSERT INTO `result_star` VALUES ('1251470525809598464', '1251470520445083657', '2-702', 95, 90, 95, 90, 90, NULL, NULL, NULL, 64.40, 30.00, 94.40, '三星级寝室');
INSERT INTO `result_star` VALUES ('1251470525826375680', '1251470520445083657', '11-701', 95, 95, 95, 95, 95, NULL, NULL, NULL, 66.50, 30.00, 96.50, '三星级寝室');
INSERT INTO `result_star` VALUES ('1251470525843152896', '1251470520445083657', '11-702', 95, 95, 95, 95, 95, NULL, NULL, NULL, 66.50, 30.00, 96.50, '三星级寝室');
INSERT INTO `result_star` VALUES ('1251470525876707328', '1251470520445083657', '11-703', 95, 95, 95, 95, 95, NULL, NULL, NULL, 66.50, 30.00, 96.50, '三星级寝室');
INSERT INTO `result_star` VALUES ('1251470525893484544', '1251470520445083657', '11-704', 95, 95, 95, 95, 95, NULL, NULL, NULL, 66.50, 30.00, 96.50, '三星级寝室');

-- ----------------------------
-- Table structure for result_star_col
-- ----------------------------
DROP TABLE IF EXISTS `result_star_col`;
CREATE TABLE `result_star_col`  (
  `record_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_CN',
  `col_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表列名_EN',
  `col_order` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '列顺序',
  PRIMARY KEY (`col_order`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result_star_col
-- ----------------------------
INSERT INTO `result_star_col` VALUES ('宿舍', 'dorNum', 1);
INSERT INTO `result_star_col` VALUES ('第一次', 's1', 2);
INSERT INTO `result_star_col` VALUES ('第二次', 's2', 3);
INSERT INTO `result_star_col` VALUES ('第三次', 's3', 4);
INSERT INTO `result_star_col` VALUES ('第四次', 's4', 5);
INSERT INTO `result_star_col` VALUES ('第五次', 's5', 6);
INSERT INTO `result_star_col` VALUES ('第六次', 's6', 7);
INSERT INTO `result_star_col` VALUES ('第七次', 's7', 8);
INSERT INTO `result_star_col` VALUES ('第八次', 's8', 9);
INSERT INTO `result_star_col` VALUES ('卫生得分', 'hygieneScore', 10);
INSERT INTO `result_star_col` VALUES ('纪律得分', 'ruleScore', 11);
INSERT INTO `result_star_col` VALUES ('得分', 'aveScore', 12);
INSERT INTO `result_star_col` VALUES ('对应星级', 'grade', 13);

-- ----------------------------
-- Table structure for sys_apis
-- ----------------------------
DROP TABLE IF EXISTS `sys_apis`;
CREATE TABLE `sys_apis`  (
  `perm_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编号',
  `api_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求方式',
  `api_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求路径',
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_apis
-- ----------------------------
INSERT INTO `sys_apis` VALUES ('1257958649024794624', 'get', '/ctrl/userInfo/select');
INSERT INTO `sys_apis` VALUES ('1257958649163206656', 'post', '/ctrl/userInfo/update');
INSERT INTO `sys_apis` VALUES ('1257958649721049088', 'post', '/ctrl/changeWord/update');
INSERT INTO `sys_apis` VALUES ('1257958650090147840', 'post', '/ctrl/restWord/update');

-- ----------------------------
-- Table structure for sys_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_login`;
CREATE TABLE `sys_login`  (
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号/职工号',
  `user_word` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_login
-- ----------------------------
INSERT INTO `sys_login` VALUES ('16478060', 'DxHe4PJXgr/goIgn3gIlxg==');
INSERT INTO `sys_login` VALUES ('16478067', 'T/+5RO5WPHfbtYZAGCQQ2Q==');
INSERT INTO `sys_login` VALUES ('16478080', 'iBgjWdje6GV6BZuB3UcKBw==');
INSERT INTO `sys_login` VALUES ('16478081', 'KM+AV6enMZWxhd7INC5/sA==');
INSERT INTO `sys_login` VALUES ('16478082', 'QGTPMQqO0IbWp656lx5S3A==');

-- ----------------------------
-- Table structure for sys_login_time
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_time`;
CREATE TABLE `sys_login_time`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表行号',
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号/职工号',
  `login_time` datetime(0) NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_login_time
-- ----------------------------
INSERT INTO `sys_login_time` VALUES (1, '16478080', '2020-04-15 14:56:54');
INSERT INTO `sys_login_time` VALUES (2, '16478060', '2020-04-15 14:56:54');
INSERT INTO `sys_login_time` VALUES (3, '16478067', '2020-04-15 14:56:54');
INSERT INTO `sys_login_time` VALUES (4, '16478081', '2020-04-15 14:56:54');
INSERT INTO `sys_login_time` VALUES (5, '16478082', '2020-04-15 14:56:54');
INSERT INTO `sys_login_time` VALUES (6, '16478082', '2020-04-16 12:53:56');
INSERT INTO `sys_login_time` VALUES (7, '16478082', '2020-04-16 14:40:49');
INSERT INTO `sys_login_time` VALUES (8, '16478082', '2020-04-17 00:11:55');
INSERT INTO `sys_login_time` VALUES (9, '16478082', '2020-04-17 10:48:55');
INSERT INTO `sys_login_time` VALUES (10, '16478082', '2020-04-17 10:59:16');
INSERT INTO `sys_login_time` VALUES (11, '16478082', '2020-04-17 11:57:59');
INSERT INTO `sys_login_time` VALUES (12, '16478082', '2020-04-18 21:00:02');
INSERT INTO `sys_login_time` VALUES (13, '16478060', '2020-04-18 22:15:06');
INSERT INTO `sys_login_time` VALUES (14, '16478082', '2020-04-18 23:43:26');
INSERT INTO `sys_login_time` VALUES (15, '16478080', '2020-04-19 12:24:12');
INSERT INTO `sys_login_time` VALUES (16, '16478081', '2020-04-19 13:16:43');
INSERT INTO `sys_login_time` VALUES (17, '16478067', '2020-04-19 15:07:18');
INSERT INTO `sys_login_time` VALUES (18, '16478082', '2020-04-19 15:40:31');
INSERT INTO `sys_login_time` VALUES (19, '16478080', '2020-04-19 17:45:57');
INSERT INTO `sys_login_time` VALUES (20, '16478060', '2020-04-19 21:50:03');
INSERT INTO `sys_login_time` VALUES (21, '16478060', '2020-04-19 23:37:05');
INSERT INTO `sys_login_time` VALUES (22, '16478082', '2020-04-20 11:40:14');
INSERT INTO `sys_login_time` VALUES (23, '16478082', '2020-04-20 12:35:59');
INSERT INTO `sys_login_time` VALUES (24, '16478082', '2020-04-21 11:52:51');
INSERT INTO `sys_login_time` VALUES (25, '16478080', '2020-04-21 12:12:22');
INSERT INTO `sys_login_time` VALUES (26, '16478082', '2020-04-21 16:31:49');
INSERT INTO `sys_login_time` VALUES (27, '16478080', '2020-04-22 00:17:50');
INSERT INTO `sys_login_time` VALUES (28, '16478082', '2020-04-22 12:08:30');
INSERT INTO `sys_login_time` VALUES (29, '16478060', '2020-04-22 12:14:23');
INSERT INTO `sys_login_time` VALUES (30, '16478082', '2020-04-22 16:40:55');
INSERT INTO `sys_login_time` VALUES (31, '16478082', '2020-04-22 20:13:11');
INSERT INTO `sys_login_time` VALUES (32, '16478082', '2020-04-27 16:38:25');
INSERT INTO `sys_login_time` VALUES (33, '16478082', '2020-05-06 23:20:45');
INSERT INTO `sys_login_time` VALUES (34, '16478082', '2020-05-07 16:40:59');
INSERT INTO `sys_login_time` VALUES (35, '16478082', '2020-05-07 19:23:46');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `perm_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编号',
  `menu_icon` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单项图标',
  `menu_order` int(10) NOT NULL COMMENT '菜单项顺序',
  `menu_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由路径',
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1257958648789913600', 'el-icon-user', 1, NULL);
INSERT INTO `sys_menu` VALUES ('1257958649024794624', 'el-icon-menu', 1, 'userInfo');
INSERT INTO `sys_menu` VALUES ('1257958649486168064', 'el-icon-menu', 2, 'changeWord');
INSERT INTO `sys_menu` VALUES ('1257958649976901632', 'el-icon-menu', 3, 'restWord');

-- ----------------------------
-- Table structure for sys_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm`  (
  `perm_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编号',
  `perm_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `perm_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限描述',
  `perm_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编码',
  `perm_type` tinyint(4) NOT NULL COMMENT '权限类型,0菜单,1按钮,2接口',
  `par_perm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级权限',
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_perm
-- ----------------------------
INSERT INTO `sys_perm` VALUES ('1257958648789913600', '个人中心', '个人中心菜单', 'menu-member', 0, NULL);
INSERT INTO `sys_perm` VALUES ('1257958649024794624', '基本信息', '用户基本信息菜单', 'menu-userInfo', 1, '1257958648789913600');
INSERT INTO `sys_perm` VALUES ('1257958649163206656', '修改用户信息', '修改用户信息接口', 'api-userInfo-update', 2, '1257958649024794624');
INSERT INTO `sys_perm` VALUES ('1257958649486168064', '修改密码', '修改密码菜单', 'menu-changeWord', 0, '1257958648789913600');
INSERT INTO `sys_perm` VALUES ('1257958649721049088', '修改密码', '修改密码接口', 'api-userWord-update', 2, '1257958649486168064');
INSERT INTO `sys_perm` VALUES ('1257958649976901632', '重置密码', '重置密码菜单', 'menu-restWord', 0, '1257958648789913600');
INSERT INTO `sys_perm` VALUES ('1257958650090147840', '重置密码', '重置密码接口', 'api-userWord-rest', 2, '1257958649976901632');

-- ----------------------------
-- Table structure for sys_point
-- ----------------------------
DROP TABLE IF EXISTS `sys_point`;
CREATE TABLE `sys_point`  (
  `perm_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编号',
  `point_style` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能点(按钮)样式',
  `point_icon` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能点(按钮)图标',
  `point_status` tinyint(2) NOT NULL COMMENT '功能点(按钮)状态',
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_point
-- ----------------------------
INSERT INTO `sys_point` VALUES ('1257958649163206656', 'primary', '保存修改', 1);
INSERT INTO `sys_point` VALUES ('1257958649721049088', 'primary', '修改密码', 1);
INSERT INTO `sys_point` VALUES ('1257958650090147840', 'primary', '重置密码', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1253885033299607552', '学生');
INSERT INTO `sys_role` VALUES ('1253885038093697024', '老师');
INSERT INTO `sys_role` VALUES ('1253885041939873792', '辅导员');
INSERT INTO `sys_role` VALUES ('1253885044599062528', '宿舍长');
INSERT INTO `sys_role` VALUES ('1253885047170170880', '班长');
INSERT INTO `sys_role` VALUES ('1253885049795805184', '班主任');
INSERT INTO `sys_role` VALUES ('1253885052463382528', '寝工部部门成员');
INSERT INTO `sys_role` VALUES ('1253885055055462400', '秘书部部门成员');
INSERT INTO `sys_role` VALUES ('1253885057911783424', '考核部部门成员');
INSERT INTO `sys_role` VALUES ('1253885060612915200', '寝工部部长');
INSERT INTO `sys_role` VALUES ('1253885063272103936', '秘书部部长');
INSERT INTO `sys_role` VALUES ('1253885065956458496', '考核部部长');
INSERT INTO `sys_role` VALUES ('1253885068636618752', '主任');
INSERT INTO `sys_role` VALUES ('1253885071245475840', '指导老师');
INSERT INTO `sys_role` VALUES ('1253885073812389888', '系统管理员');

-- ----------------------------
-- Table structure for sys_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `role_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号',
  `perm_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_perm
-- ----------------------------
INSERT INTO `sys_role_perm` VALUES ('1257958648789913601', '1253885033299607552', '1257958648789913600');
INSERT INTO `sys_role_perm` VALUES ('1257958648836050944', '1253885038093697024', '1257958648789913600');
INSERT INTO `sys_role_perm` VALUES ('1257958648852828160', '1253885041939873792', '1257958648789913600');
INSERT INTO `sys_role_perm` VALUES ('1257958648873799680', '1253885073812389888', '1257958648789913600');
INSERT INTO `sys_role_perm` VALUES ('1257958649024794625', '1253885033299607552', '1257958649024794624');
INSERT INTO `sys_role_perm` VALUES ('1257958649041571840', '1253885038093697024', '1257958649024794624');
INSERT INTO `sys_role_perm` VALUES ('1257958649058349056', '1253885041939873792', '1257958649024794624');
INSERT INTO `sys_role_perm` VALUES ('1257958649163206657', '1253885033299607552', '1257958649163206656');
INSERT INTO `sys_role_perm` VALUES ('1257958649188372480', '1253885038093697024', '1257958649163206656');
INSERT INTO `sys_role_perm` VALUES ('1257958649234509824', '1253885041939873792', '1257958649163206656');
INSERT INTO `sys_role_perm` VALUES ('1257958649486168065', '1253885033299607552', '1257958649486168064');
INSERT INTO `sys_role_perm` VALUES ('1257958649523916800', '1253885038093697024', '1257958649486168064');
INSERT INTO `sys_role_perm` VALUES ('1257958649544888320', '1253885041939873792', '1257958649486168064');
INSERT INTO `sys_role_perm` VALUES ('1257958649624580096', '1253885073812389888', '1257958649486168064');
INSERT INTO `sys_role_perm` VALUES ('1257958649721049089', '1253885033299607552', '1257958649721049088');
INSERT INTO `sys_role_perm` VALUES ('1257958649792352256', '1253885038093697024', '1257958649721049088');
INSERT INTO `sys_role_perm` VALUES ('1257958649825906688', '1253885041939873792', '1257958649721049088');
INSERT INTO `sys_role_perm` VALUES ('1257958649859461120', '1253885073812389888', '1257958649721049088');
INSERT INTO `sys_role_perm` VALUES ('1257958649976901633', '1253885071245475840', '1257958649976901632');
INSERT INTO `sys_role_perm` VALUES ('1257958650018844672', '1253885073812389888', '1257958649976901632');
INSERT INTO `sys_role_perm` VALUES ('1257958650090147841', '1253885071245475840', '1257958650090147840');
INSERT INTO `sys_role_perm` VALUES ('1257958650102730752', '1253885073812389888', '1257958650090147840');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号/职工号',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `user_tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `user_mail` varchar(320) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `create_time` datetime(0) NOT NULL COMMENT '注册时间',
  `college_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院编号',
  `college_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('16478060', '车伟奇', '13657948659', '1263220125@qq.com', '2020-04-15 14:56:54', '1250317154721492992', '信息与计算机工程学院');
INSERT INTO `sys_user` VALUES ('16478067', '李云飞', '18779922797', '1908407747@qq.com', '2020-04-15 14:56:55', '1250317154721492992', '信息与计算机工程学院');
INSERT INTO `sys_user` VALUES ('16478080', '荆辞雪', '18779916319', '844049178@qq.com', '2020-04-15 14:56:55', '1250317154721492992', '信息与计算机工程学院');
INSERT INTO `sys_user` VALUES ('16478081', '郭鹏程', '18779920015', '2376306355@qq.com', '2020-04-15 14:56:55', '1250317154721492992', '信息与计算机工程学院');
INSERT INTO `sys_user` VALUES ('16478082', '余丽', '17379207923', '1305284627@qq.com', '2020-04-15 14:56:55', '1250317154721492992', '信息与计算机工程学院');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表行号',
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号/职工号',
  `role_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1257958643781914624', '16478082', '1253885033299607552');
INSERT INTO `sys_user_role` VALUES ('1258231226838360064', '16478060', '1253885033299607552');
INSERT INTO `sys_user_role` VALUES ('1258231233394057216', '16478067', '1253885033299607552');
INSERT INTO `sys_user_role` VALUES ('1258231236762083328', '16478080', '1253885033299607552');
INSERT INTO `sys_user_role` VALUES ('1258231239484186624', '16478081', '1253885033299607552');
INSERT INTO `sys_user_role` VALUES ('1258231242202095616', '16478080', '1253885044599062528');
INSERT INTO `sys_user_role` VALUES ('1258231244924198912', '16478067', '1253885047170170880');

SET FOREIGN_KEY_CHECKS = 1;
