/*
 Navicat Premium Data Transfer

 Source Server         : Cornelius
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : graduation_project

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 07/05/2022 13:19:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `admin_user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `login_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆名称',
  `login_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员显示昵称',
  `locked` tinyint(4) NULL DEFAULT 0 COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
  PRIMARY KEY (`admin_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', 0);
INSERT INTO `admin_user` VALUES (2, 'test', 'e10adc3949ba59abbe56e057f20f883e', '测试01', 0);
INSERT INTO `admin_user` VALUES (3, 'test', 'e10adc3949ba59abbe56e057f20f883e', '测试02', 0);

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`  (
  `carousel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '首页轮播图主键id',
  `carousel_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '轮播图',
  `redirect_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '\'##\'' COMMENT '点击后的跳转地址(默认不跳转)',
  `carousel_rank` int(11) NOT NULL DEFAULT 0 COMMENT '排序值(字段越大越靠前)',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_user` int(11) NOT NULL DEFAULT 0 COMMENT '创建者id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '修改者id',
  PRIMARY KEY (`carousel_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES (1, 'http://localhost:8080/upload/20200321_12062537.jpg', '##', 0, 1, '2022-02-22 12:06:28', 0, '2022-02-22 12:06:56', 0);
INSERT INTO `carousel` VALUES (2, 'http://localhost:8080/upload/20220305_21374612.jpg', '##', 3, 1, '2022-02-22 12:07:14', 0, '2022-03-05 22:41:47', 0);
INSERT INTO `carousel` VALUES (3, 'http://localhost:8080/upload/20200321_12100112.jpg', '##', 0, 1, '2022-02-22 12:07:28', 0, '2022-02-22 12:12:32', 0);
INSERT INTO `carousel` VALUES (4, 'http://localhost:8080/upload/20220305_21380013.jpg', '##', 2, 1, '2022-02-22 12:12:19', 0, '2022-03-05 22:41:47', 0);
INSERT INTO `carousel` VALUES (5, 'http://localhost:8080/upload/20220305_21381186.jpg', '##', 1, 1, '2022-02-27 21:52:58', 0, '2022-03-05 22:41:47', 0);
INSERT INTO `carousel` VALUES (6, 'http://localhost:8080/upload/20220305_22415680.jpg', '##', 0, 0, '2022-03-05 22:41:57', 0, '2022-03-05 22:41:57', 0);
INSERT INTO `carousel` VALUES (7, 'http://localhost:8080/upload/20220305_22420426.jpg', '##', 0, 0, '2022-03-05 22:42:05', 0, '2022-03-05 22:42:05', 0);
INSERT INTO `carousel` VALUES (8, 'http://localhost:8080/upload/20220305_22422451.jpg', '##', 0, 0, '2022-03-05 22:42:11', 0, '2022-03-05 22:42:26', 0);
INSERT INTO `carousel` VALUES (9, 'http://localhost:8080/admin/dist/img/img-upload.png', '##', 0, 1, '2022-03-22 23:00:58', 0, '2022-03-22 23:01:03', 0);

-- ----------------------------
-- Table structure for goods_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category`  (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `category_level` tinyint(4) NOT NULL DEFAULT 0 COMMENT '分类级别(1-一级分类 2-二级分类 3-三级分类)',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父分类id',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分类名称',
  `category_rank` int(11) NOT NULL DEFAULT 0 COMMENT '排序值(字段越大越靠前)',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_user` int(11) NOT NULL DEFAULT 0 COMMENT '创建者id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '修改者id',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_category
-- ----------------------------
INSERT INTO `goods_category` VALUES (1, 1, 0, '新  鲜  水  果', 100, 0, '2022-02-25 11:40:39', 0, '2022-02-25 11:41:43', 0);
INSERT INTO `goods_category` VALUES (2, 2, 1, '新鲜水果', 0, 0, '2022-02-25 11:40:53', 0, '2022-02-25 11:40:53', 0);
INSERT INTO `goods_category` VALUES (3, 3, 2, '苹果', 0, 0, '2022-02-25 11:41:25', 0, '2022-02-25 11:41:25', 0);
INSERT INTO `goods_category` VALUES (4, 3, 2, '柑桔橙柚', 0, 0, '2022-02-25 11:44:05', 0, '2022-02-25 11:44:05', 0);
INSERT INTO `goods_category` VALUES (5, 3, 2, '蓝莓莓类', 0, 0, '2022-02-25 11:44:23', 0, '2022-02-25 11:44:23', 0);
INSERT INTO `goods_category` VALUES (6, 3, 2, '奇异果猕猴桃', 0, 0, '2022-02-25 11:44:35', 0, '2022-02-25 11:44:35', 0);
INSERT INTO `goods_category` VALUES (7, 1, 0, '精 选 肉 类', 90, 0, '2022-02-25 11:45:06', 0, '2022-02-25 11:58:37', 0);
INSERT INTO `goods_category` VALUES (8, 2, 7, '精选肉类', 0, 0, '2022-02-25 11:45:18', 0, '2022-02-25 11:45:18', 0);
INSERT INTO `goods_category` VALUES (9, 3, 8, '蛋类', 0, 0, '2022-02-25 11:45:49', 0, '2022-02-25 11:45:49', 0);
INSERT INTO `goods_category` VALUES (10, 3, 8, '牛排', 0, 0, '2022-02-25 11:45:59', 0, '2022-02-25 11:45:59', 0);
INSERT INTO `goods_category` VALUES (11, 3, 8, '禽类', 0, 0, '2022-02-25 11:46:07', 0, '2022-02-25 11:46:07', 0);
INSERT INTO `goods_category` VALUES (12, 3, 8, '进口牛肉', 0, 0, '2022-02-25 11:46:15', 0, '2022-02-25 11:46:15', 0);
INSERT INTO `goods_category` VALUES (13, 3, 8, '猪肉', 0, 0, '2022-02-25 11:46:23', 0, '2022-02-25 11:46:23', 0);
INSERT INTO `goods_category` VALUES (14, 3, 8, '羊肉', 0, 0, '2022-02-25 11:46:29', 0, '2022-02-25 11:46:29', 0);
INSERT INTO `goods_category` VALUES (15, 3, 8, '其他肉类', 0, 0, '2022-02-25 11:46:34', 0, '2022-02-25 11:46:34', 0);
INSERT INTO `goods_category` VALUES (16, 1, 0, '海 鲜 水 产', 80, 0, '2022-02-25 11:48:14', 0, '2022-02-25 22:55:55', 0);
INSERT INTO `goods_category` VALUES (17, 2, 16, '海鲜水产', 0, 0, '2022-02-25 11:48:20', 0, '2022-02-25 11:48:20', 0);
INSERT INTO `goods_category` VALUES (18, 3, 17, '鳕鱼', 0, 0, '2022-02-25 11:48:35', 0, '2022-02-25 11:48:35', 0);
INSERT INTO `goods_category` VALUES (19, 3, 17, '虾仁', 0, 0, '2022-02-25 11:48:43', 0, '2022-02-25 11:48:43', 0);
INSERT INTO `goods_category` VALUES (20, 3, 17, '海鲜礼盒', 0, 0, '2022-02-25 11:48:47', 0, '2022-02-25 11:48:47', 0);
INSERT INTO `goods_category` VALUES (21, 3, 17, '鱼类', 0, 0, '2022-02-25 11:48:58', 0, '2022-02-25 11:48:58', 0);
INSERT INTO `goods_category` VALUES (22, 3, 17, '三文鱼', 0, 0, '2022-02-25 11:49:08', 0, '2022-02-25 11:49:08', 0);
INSERT INTO `goods_category` VALUES (23, 3, 17, '虾类', 0, 0, '2022-02-25 11:49:16', 0, '2022-02-25 11:49:16', 0);
INSERT INTO `goods_category` VALUES (24, 3, 17, '蟹类', 0, 0, '2022-02-25 11:49:26', 0, '2022-02-25 11:49:26', 0);
INSERT INTO `goods_category` VALUES (25, 3, 17, '贝类', 0, 0, '2022-02-25 11:49:40', 0, '2022-02-25 11:49:40', 0);
INSERT INTO `goods_category` VALUES (26, 3, 17, '海参', 0, 0, '2022-02-25 11:49:44', 0, '2022-02-25 11:49:44', 0);
INSERT INTO `goods_category` VALUES (27, 3, 17, '加工水产', 0, 0, '2022-02-25 11:49:48', 0, '2022-02-25 11:49:48', 0);
INSERT INTO `goods_category` VALUES (28, 1, 0, '乳品糕点', 55, 0, '2022-02-25 11:56:09', 0, '2022-04-01 18:00:34', 0);
INSERT INTO `goods_category` VALUES (29, 2, 28, '乳品糕点', 0, 0, '2022-02-25 11:56:14', 0, '2022-02-25 11:56:14', 0);
INSERT INTO `goods_category` VALUES (30, 3, 29, '乳品', 0, 0, '2022-02-25 11:56:26', 0, '2022-02-25 11:56:26', 0);
INSERT INTO `goods_category` VALUES (31, 3, 29, '蛋糕', 0, 0, '2022-02-25 11:56:35', 0, '2022-02-25 11:56:35', 0);
INSERT INTO `goods_category` VALUES (32, 3, 29, '面包', 0, 0, '2022-02-25 11:56:38', 0, '2022-02-25 11:56:38', 0);
INSERT INTO `goods_category` VALUES (33, 1, 0, '新 鲜 蔬 菜', 98, 0, '2022-02-25 11:56:59', 0, '2022-02-25 11:59:02', 0);
INSERT INTO `goods_category` VALUES (34, 2, 33, '新鲜蔬菜', 0, 0, '2022-02-25 11:57:04', 0, '2022-02-25 11:57:04', 0);
INSERT INTO `goods_category` VALUES (35, 3, 34, '叶菜类', 0, 0, '2022-02-25 11:57:17', 0, '2022-02-25 11:57:17', 0);
INSERT INTO `goods_category` VALUES (36, 3, 34, '冷冻蔬菜', 0, 0, '2022-02-25 11:57:22', 0, '2022-02-25 11:57:41', 0);
INSERT INTO `goods_category` VALUES (37, 3, 34, '瓜果类', 0, 0, '2022-02-25 11:57:53', 0, '2022-02-25 11:58:06', 0);
INSERT INTO `goods_category` VALUES (38, 3, 34, '茄果', 0, 0, '2022-02-25 11:57:58', 0, '2022-02-25 11:57:58', 0);
INSERT INTO `goods_category` VALUES (39, 1, 0, '方 便 速 食', 60, 0, '2022-02-25 11:59:18', 0, '2022-02-25 11:59:24', 0);
INSERT INTO `goods_category` VALUES (40, 2, 39, '方便速食', 0, 0, '2022-02-25 11:59:31', 0, '2022-02-25 11:59:31', 0);
INSERT INTO `goods_category` VALUES (41, 3, 40, '冷冻点心', 0, 0, '2022-02-25 11:59:46', 0, '2022-02-25 11:59:46', 0);
INSERT INTO `goods_category` VALUES (42, 3, 40, '半成品菜', 0, 0, '2022-02-25 11:59:49', 0, '2022-02-25 11:59:49', 0);
INSERT INTO `goods_category` VALUES (43, 1, 0, '粮 油 杂 货', 50, 0, '2022-02-25 11:59:59', 0, '2022-02-25 12:00:40', 0);
INSERT INTO `goods_category` VALUES (44, 2, 43, '粮油杂货', 0, 0, '2022-02-25 12:00:05', 0, '2022-02-25 12:00:05', 0);
INSERT INTO `goods_category` VALUES (45, 3, 44, '米面主食', 0, 0, '2022-02-25 12:00:18', 0, '2022-02-25 12:00:18', 0);
INSERT INTO `goods_category` VALUES (46, 3, 44, '油盐调料', 0, 0, '2022-02-25 12:00:22', 0, '2022-02-25 12:00:22', 0);
INSERT INTO `goods_category` VALUES (47, 3, 44, '杂粮干货', 0, 0, '2022-02-25 12:00:26', 0, '2022-02-25 12:00:26', 0);
INSERT INTO `goods_category` VALUES (48, 3, 44, '坚果零食', 0, 0, '2022-02-25 12:00:29', 0, '2022-02-25 12:00:29', 0);
INSERT INTO `goods_category` VALUES (49, 1, 0, '食 品 饮 料', 40, 0, '2022-02-25 12:00:49', 0, '2022-02-25 12:03:20', 0);
INSERT INTO `goods_category` VALUES (50, 2, 49, '食品饮料', 0, 0, '2022-02-25 12:00:54', 0, '2022-02-25 12:00:54', 0);
INSERT INTO `goods_category` VALUES (51, 3, 50, '水类', 0, 0, '2022-02-25 12:01:19', 0, '2022-02-25 12:01:19', 0);
INSERT INTO `goods_category` VALUES (52, 3, 50, '冲调茶饮', 0, 0, '2022-02-25 12:01:23', 0, '2022-02-25 12:01:23', 0);
INSERT INTO `goods_category` VALUES (53, 3, 50, '葡萄酒', 0, 0, '2022-02-25 12:01:33', 0, '2022-02-25 12:01:33', 0);
INSERT INTO `goods_category` VALUES (54, 3, 50, '休闲食品', 0, 0, '2022-02-25 12:01:37', 0, '2022-02-25 12:01:37', 0);
INSERT INTO `goods_category` VALUES (55, 1, 0, '生 活 日 用', 30, 0, '2022-02-25 12:01:51', 0, '2022-02-25 12:03:25', 0);
INSERT INTO `goods_category` VALUES (56, 2, 55, '生活日用', 0, 0, '2022-02-25 12:01:55', 0, '2022-02-25 12:01:55', 0);
INSERT INTO `goods_category` VALUES (57, 3, 56, '锅具', 0, 0, '2022-02-25 12:02:03', 0, '2022-02-25 22:56:20', 0);
INSERT INTO `goods_category` VALUES (58, 3, 56, '厨房小帮手', 0, 0, '2022-02-25 12:02:06', 0, '2022-02-25 12:02:06', 0);
INSERT INTO `goods_category` VALUES (59, 1, 0, 'dsa', 0, 1, '2022-03-13 18:41:58', 0, '2022-03-13 18:41:58', 0);
INSERT INTO `goods_category` VALUES (60, 1, 0, '熟 食 工 坊', 35, 0, '2022-03-22 12:35:12', 0, '2022-04-01 17:45:17', 0);
INSERT INTO `goods_category` VALUES (61, 2, 60, '卤味熟食', 30, 1, '2022-03-22 12:36:05', 0, '2022-03-22 12:36:05', 0);
INSERT INTO `goods_category` VALUES (62, 2, 60, '炸物烧烤', 20, 1, '2022-03-22 12:36:19', 0, '2022-03-22 12:36:19', 0);
INSERT INTO `goods_category` VALUES (63, 2, 60, '泡菜酱菜', 10, 1, '2022-03-22 12:36:38', 0, '2022-03-22 12:36:38', 0);
INSERT INTO `goods_category` VALUES (64, 2, 60, '熟食工坊', 0, 0, '2022-04-01 17:46:50', 0, '2022-04-01 17:46:50', 0);
INSERT INTO `goods_category` VALUES (65, 3, 64, '卤味熟食', 0, 0, '2022-04-01 17:47:00', 0, '2022-04-01 17:47:00', 0);
INSERT INTO `goods_category` VALUES (66, 3, 64, '酱菜泡菜', 0, 0, '2022-04-01 17:47:08', 0, '2022-04-01 17:47:08', 0);
INSERT INTO `goods_category` VALUES (67, 3, 64, '炸物烧烤', 0, 0, '2022-04-01 17:47:18', 0, '2022-04-01 17:47:18', 0);

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `goods_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品表主键id',
  `goods_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品名',
  `goods_intro` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品简介',
  `goods_category_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联分类id',
  `goods_cover_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '/admin/dist/img/no-img.png' COMMENT '商品主图',
  `goods_carousel` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '/admin/dist/img/no-img.png' COMMENT '商品轮播图',
  `goods_detail_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品详情',
  `original_price` int(11) NOT NULL DEFAULT 1 COMMENT '商品价格',
  `selling_price` int(11) NOT NULL DEFAULT 1 COMMENT '商品实际售价',
  `stock_num` int(11) NOT NULL DEFAULT 0 COMMENT '商品库存数量',
  `tag` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品标签',
  `goods_sell_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '商品上架状态 0-上架 1-下架',
  `create_user` int(11) NOT NULL DEFAULT 0 COMMENT '添加者主键id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '商品添加时间',
  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '修改者主键id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '商品修改时间',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES (15, '鲜活 俄罗斯帝王蟹', '鲜活 俄罗斯帝王蟹 1.5-2kg/只', 24, 'http://localhost:8080/upload/20220305_22443173.JPG', 'http://localhost:8080/upload/20220305_22443173.JPG', '<img src=\"http://localhost:8080/upload/20220305_22442166.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22442236.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22442232.JPG\" alt=\"\" />', 1537, 1498, 0, '蟹', 0, 0, '2022-03-05 22:44:32', 0, '2022-05-06 11:28:08');
INSERT INTO `goods_info` VALUES (16, '冻整只熟棕蟹', '冻整只熟棕蟹 400-600g/只', 24, 'http://localhost:8080/upload/20220305_22465349.JPG', 'http://localhost:8080/upload/20220305_22465349.JPG', '<img src=\"http://localhost:8080/upload/20220305_22464556.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22464593.JPG\" alt=\"\" />', 99, 88, 35, '蟹', 0, 0, '2022-03-05 22:46:53', 0, '2022-03-05 22:46:53');
INSERT INTO `goods_info` VALUES (17, '四川红心猕猴桃', '四川红心猕猴桃4粒装 300g/盒', 6, 'http://localhost:8080/upload/20220305_22502345.JPG', 'http://localhost:8080/upload/20220305_22502345.JPG', '<img src=\"http://localhost:8080/upload/20220305_22493312.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22493395.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22493429.JPG\" alt=\"\" />', 9, 6, 89, '猕猴桃', 0, 0, '2022-03-05 22:50:23', 0, '2022-03-05 22:50:23');
INSERT INTO `goods_info` VALUES (18, '国产蓝莓', '国产蓝莓125g（果茎14mm+）', 5, 'http://localhost:8080/upload/20220305_22525914.JPG', 'http://localhost:8080/upload/20220305_22525914.JPG', '<img src=\"http://localhost:8080/upload/20220305_22521426.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_2252147.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22521459.JPG\" alt=\"\" />', 19, 16, 55, '蓝莓', 0, 0, '2022-03-05 22:53:00', 0, '2022-03-05 22:53:00');
INSERT INTO `goods_info` VALUES (19, '生菜', '生菜500g', 35, 'http://localhost:8080/upload/20220305_22544160.JPG', 'http://localhost:8080/upload/20220305_22544160.JPG', '<img src=\"http://localhost:8080/upload/20220305_22541443.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_2254140.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22541483.JPG\" alt=\"\" />', 3, 2, 8998, '生菜', 0, 0, '2022-03-05 22:54:42', 0, '2022-05-02 10:29:04');
INSERT INTO `goods_info` VALUES (20, '农家散养玉米黄柴鸡蛋', '农家散养玉米黄柴鸡蛋 30枚', 9, 'http://localhost:8080/upload/20220305_22572037.JPG', 'http://localhost:8080/upload/20220305_22572037.JPG', '<img src=\"http://localhost:8080/upload/20220305_22562851.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22562838.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22562855.JPG\" alt=\"\" />', 19, 13, 456, '鸡蛋', 0, 0, '2022-03-05 22:57:21', 0, '2022-03-05 22:57:21');
INSERT INTO `goods_info` VALUES (21, '恋尚牛 澳洲谷饲M3眼肉牛排', '恋尚牛 澳洲谷饲M3眼肉牛排 200g', 10, 'http://localhost:8080/upload/20220305_22593366.PNG', 'http://localhost:8080/upload/20220305_22593366.PNG', '<img src=\"http://localhost:8080/upload/20220305_22582897.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22582868.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_22582864.JPG\" alt=\"\" />', 115, 100, 367, '牛排', 0, 0, '2022-03-05 22:59:34', 0, '2022-03-05 22:59:34');
INSERT INTO `goods_info` VALUES (22, '恒都 澳洲去骨羊后腿肉', '恒都 澳洲去骨羊后腿肉 1kg', 14, 'http://localhost:8080/upload/20220305_23020996.JPG', 'http://localhost:8080/upload/20220305_23020996.JPG', '<img src=\"http://localhost:8080/upload/20220305_23012855.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23012810.JPG\" alt=\"\" />', 128, 109, 886, '羊肉', 0, 0, '2022-03-05 23:02:09', 0, '2022-03-05 23:02:09');
INSERT INTO `goods_info` VALUES (23, 'TRF 活冻黑虎虾', 'TRF 活冻黑虎虾 300g（12-18条）', 23, 'http://localhost:8080/upload/20220305_23042689.JPG', 'http://localhost:8080/upload/20220305_23042689.JPG', '<img src=\"http://localhost:8080/upload/20220305_23033666.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23033638.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23033667.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23033645.JPG\" alt=\"\" />', 39, 30, 734, '黑虎虾', 0, 0, '2022-03-05 23:04:27', 0, '2022-03-05 23:04:27');
INSERT INTO `goods_info` VALUES (24, '鲜活 波士顿龙虾', '鲜活 波士顿龙虾 400-500g/只', 23, 'http://localhost:8080/upload/20220305_23071650.JPG', 'http://localhost:8080/upload/20220305_23071650.JPG', '<img src=\"http://localhost:8080/upload/20220305_23063373.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23063392.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_2306332.PNG\" alt=\"\" />', 189, 169, 751, '波士顿龙虾', 0, 0, '2022-03-05 23:06:42', 0, '2022-03-05 23:07:17');
INSERT INTO `goods_info` VALUES (25, '菊乐有机 有机鲜牛奶', '菊乐有机 有机鲜牛奶 900ml', 30, 'http://localhost:8080/upload/20220305_23094566.JPG', 'http://localhost:8080/upload/20220305_23094566.JPG', '<img src=\"http://localhost:8080/upload/20220305_23093815.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23093899.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23093893.JPG\" alt=\"\" />', 23, 20, 886, '有机鲜牛奶', 0, 0, '2022-03-05 23:09:45', 0, '2022-03-05 23:09:45');
INSERT INTO `goods_info` VALUES (26, '提拉米苏', '提拉米苏蛋糕（6英寸）360g', 31, 'http://localhost:8080/upload/20220305_23114288.JPG', 'http://localhost:8080/upload/20220305_23114288.JPG', '<img src=\"http://localhost:8080/upload/20220305_2311060.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23110655.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23110698.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23110695.JPG\" alt=\"\" />', 55, 50, 22, '提拉米苏', 0, 0, '2022-03-05 23:11:43', 0, '2022-03-05 23:11:43');
INSERT INTO `goods_info` VALUES (27, '思念 灌汤水饺', '思念 灌汤水饺三鲜（家庭装）1kg', 41, 'http://localhost:8080/upload/20220305_23140632.JPG', 'http://localhost:8080/upload/20220305_23140632.JPG', '<img src=\"http://localhost:8080/upload/20220305_23132185.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_2313217.JPG\" alt=\"\" />', 19, 16, 876, '水饺', 0, 0, '2022-03-05 23:14:07', 0, '2022-03-05 23:14:07');
INSERT INTO `goods_info` VALUES (28, '君稻 五常长粒香米', '君稻 五常长粒香米 5kg', 45, 'http://localhost:8080/upload/20220305_23163113.JPG', 'http://localhost:8080/upload/20220305_23163113.JPG', '<img src=\"http://localhost:8080/upload/20220305_23162448.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23162586.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23162553.JPG\" alt=\"\" />', 43, 36, 538, '香米', 0, 0, '2022-03-05 23:16:31', 0, '2022-03-05 23:16:31');
INSERT INTO `goods_info` VALUES (29, '初有 干木耳', '初有 干木耳 200g', 47, 'http://localhost:8080/upload/20220305_23183479.JPG', 'http://localhost:8080/upload/20220305_23183479.JPG', '<img src=\"http://localhost:8080/upload/20220305_23182598.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23182546.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23182556.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23182565.JPG\" alt=\"\" />', 45, 42, 831, '干木耳', 0, 0, '2022-03-05 23:18:35', 0, '2022-03-05 23:18:35');
INSERT INTO `goods_info` VALUES (30, '张裕 干红葡萄酒', '张裕 干红葡萄酒（彩龙） 750ml*6', 53, 'http://localhost:8080/upload/20220305_23204679.JPG', 'http://localhost:8080/upload/20220305_23204679.JPG', '<p>\n	<img src=\"http://localhost:8080/upload/20220305_23203713.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23203776.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23203710.JPG\" alt=\"\" />\n</p>\n<p>\n	<br />\n</p>\n<p>\n	、\n</p>', 199, 188, 9324, '干红葡萄酒', 0, 0, '2022-03-05 23:20:47', 0, '2022-03-05 23:20:47');
INSERT INTO `goods_info` VALUES (31, '雀巢 即溶咖啡', '雀巢 1+2原味 微研磨条装 即溶咖啡 15g*36', 52, 'http://localhost:8080/upload/20220305_23231446.JPG', 'http://localhost:8080/upload/20220305_23231446.JPG', '<img src=\"http://localhost:8080/upload/20220305_23230598.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23230675.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23230634.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220305_23230643.JPG\" alt=\"\" />', 40, 32, 654, '咖啡', 0, 0, '2022-03-05 23:23:14', 0, '2022-03-05 23:23:14');
INSERT INTO `goods_info` VALUES (33, '谷优 奇亚籽咸香小饼干', '谷优 奇亚籽咸香小饼干 250g 西班牙进口', 54, 'http://localhost:8080/upload/20220306_11323911.JPG', 'http://localhost:8080/upload/20220306_11323911.JPG', '<img src=\"http://localhost:8080/upload/20220306_11314799.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220306_1131478.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220306_11314715.JPG\" alt=\"\" />', 35, 31, 85, '饼干', 0, 0, '2022-03-06 11:32:40', 0, '2022-03-06 11:32:40');
INSERT INTO `goods_info` VALUES (34, 'SIRONI 炒锅', 'SIRONI 匠心复底系列 炒锅 32cm 意大利进口', 57, 'http://localhost:8080/upload/20220306_11353381.JPG', 'http://localhost:8080/upload/20220306_11353381.JPG', '<img src=\"http://localhost:8080/upload/20220306_11342831.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220306_11342855.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220306_11342839.JPG\" alt=\"\" />', 327, 299, 65, '炒锅', 0, 0, '2022-03-06 11:35:34', 0, '2022-03-06 11:35:34');
INSERT INTO `goods_info` VALUES (35, '立白 洗洁精', '立白 青柠洗洁精 1.45kg', 58, 'http://localhost:8080/upload/20220306_11383863.JPG', 'http://localhost:8080/upload/20220306_11383863.JPG', '<img src=\"http://localhost:8080/upload/20220306_11373162.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220306_11373132.JPG\" alt=\"\" /><img src=\"http://localhost:8080/upload/20220306_11373126.JPG\" alt=\"\" />', 15, 13, 9999, '洗洁精', 0, 0, '2022-03-06 11:38:39', 0, '2022-04-24 21:41:47');

-- ----------------------------
-- Table structure for index_config
-- ----------------------------
DROP TABLE IF EXISTS `index_config`;
CREATE TABLE `index_config`  (
  `config_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '首页配置项主键id',
  `config_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '显示字符(配置搜索时不可为空，其他可为空)',
  `config_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热销商品 4-(首页)新品上线 5-(首页)为你推荐',
  `goods_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品id 默认为0',
  `redirect_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '##' COMMENT '点击后的跳转地址(默认不跳转)',
  `config_rank` int(11) NOT NULL DEFAULT 0 COMMENT '排序值(字段越大越靠前)',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_user` int(11) NOT NULL DEFAULT 0 COMMENT '创建者id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最新修改时间',
  `update_user` int(11) NULL DEFAULT 0 COMMENT '修改者id',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index_config
-- ----------------------------
INSERT INTO `index_config` VALUES (1, 'Driscolls云南蓝莓2盒', 3, 1, '##', 1, 1, '2022-02-25 17:30:43', 0, '2022-03-06 11:39:18', 0);
INSERT INTO `index_config` VALUES (2, '原膳东海鲳鱼250g', 3, 7, '##', 0, 1, '2022-02-25 17:32:25', 0, '2022-03-06 11:39:18', 0);
INSERT INTO `index_config` VALUES (3, '熟冻爱尔兰面包蟹', 3, 8, '##', 0, 1, '2022-02-25 17:32:37', 0, '2022-03-06 11:39:18', 0);
INSERT INTO `index_config` VALUES (4, '迷你胡萝卜200g', 3, 5, '##', 0, 1, '2022-02-25 17:32:49', 0, '2022-03-03 23:00:05', 0);
INSERT INTO `index_config` VALUES (5, '绿甘蓝', 4, 13, '##', 0, 1, '2022-02-25 17:34:22', 0, '2022-03-06 11:41:14', 0);
INSERT INTO `index_config` VALUES (6, 'KONO冷冻青口贝454g', 4, 9, '##', 0, 1, '2022-02-25 17:34:38', 0, '2022-03-06 11:41:14', 0);
INSERT INTO `index_config` VALUES (7, '熟冻爱尔兰面包蟹1只', 4, 8, '##', 0, 1, '2022-02-25 17:34:48', 0, '2022-03-06 11:41:14', 0);
INSERT INTO `index_config` VALUES (8, '原膳东海鲳鱼250g', 4, 7, '##', 0, 1, '2022-02-25 17:35:00', 0, '2022-03-06 11:41:14', 0);
INSERT INTO `index_config` VALUES (9, '湾仔码头鲜美虾三鲜小云吞', 5, 6, '##', 0, 1, '2022-02-25 17:35:47', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (10, '元宝岛即食海参', 5, 4, '##', 0, 1, '2022-02-25 17:36:01', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (11, '原膳澳洲和牛西冷牛排', 5, 3, '##', 0, 1, '2022-02-25 17:36:11', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (12, '脐橙4kg礼盒装', 5, 2, '##', 0, 1, '2022-02-25 17:36:29', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (13, 'Driscolls云南蓝莓2盒', 5, 1, '##', 0, 1, '2022-02-25 17:36:39', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (14, '迷你胡萝卜200g', 5, 5, '##', 0, 1, '2022-02-25 17:37:04', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (15, '原膳东海鲳鱼250g', 5, 7, '##', 0, 1, '2022-02-25 17:37:15', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (16, '熟冻爱尔兰面包蟹1只', 5, 8, '##', 0, 1, '2022-02-25 17:37:25', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (17, '鲜活 净化花蛤', 5, 9, '##', 0, 1, '2022-02-25 17:37:35', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (18, '绿甘蓝', 5, 13, '##', 0, 1, '2022-02-25 17:37:48', 0, '2022-03-06 11:44:27', 0);
INSERT INTO `index_config` VALUES (19, 'ceshi', 4, 3, '##', 0, 1, '2022-02-27 22:45:18', 0, '2022-02-27 22:46:03', 0);
INSERT INTO `index_config` VALUES (20, 'test', 3, 12, '##', 0, 1, '2022-03-03 22:59:34', 0, '2022-03-03 23:00:16', 0);
INSERT INTO `index_config` VALUES (21, '原膳澳洲和牛西冷牛排', 3, 3, '##', 0, 1, '2022-03-03 23:00:33', 0, '2022-03-06 11:39:18', 0);
INSERT INTO `index_config` VALUES (22, '鲜活 俄罗斯帝王蟹', 3, 15, '##', 3, 0, '2022-03-06 11:39:27', 0, '2022-03-06 11:39:27', 0);
INSERT INTO `index_config` VALUES (23, '恋尚牛 澳洲谷饲M3眼肉牛排', 3, 21, '##', 1, 0, '2022-03-06 11:39:50', 0, '2022-03-06 11:39:50', 0);
INSERT INTO `index_config` VALUES (24, '国产蓝莓', 3, 18, '##', 4, 0, '2022-03-06 11:40:21', 0, '2022-03-06 11:40:21', 0);
INSERT INTO `index_config` VALUES (25, '君稻 五常长粒香米', 3, 28, '##', 2, 0, '2022-03-06 11:40:57', 0, '2022-03-06 11:40:57', 0);
INSERT INTO `index_config` VALUES (26, '鲜活 波士顿龙虾', 4, 24, '##', 0, 0, '2022-03-06 11:41:27', 0, '2022-03-06 11:41:27', 0);
INSERT INTO `index_config` VALUES (27, 'TRF 活冻黑虎虾', 4, 23, '##', 0, 0, '2022-03-06 11:41:41', 0, '2022-03-06 11:41:41', 0);
INSERT INTO `index_config` VALUES (28, '恒都 澳洲去骨羊后腿肉', 4, 22, '##', 0, 0, '2022-03-06 11:42:10', 0, '2022-03-06 11:42:10', 0);
INSERT INTO `index_config` VALUES (29, '冻整只熟棕蟹', 4, 16, '##', 0, 0, '2022-03-06 11:42:22', 0, '2022-03-06 11:42:22', 0);
INSERT INTO `index_config` VALUES (30, '谷优 奇亚籽咸香小饼干', 5, 33, '##', 0, 0, '2022-03-06 11:44:38', 0, '2022-03-06 11:44:38', 0);
INSERT INTO `index_config` VALUES (31, '张裕 干红葡萄酒', 5, 30, '##', 0, 0, '2022-03-06 11:44:49', 0, '2022-03-06 11:44:49', 0);
INSERT INTO `index_config` VALUES (32, '提拉米苏', 5, 26, '##', 0, 0, '2022-03-06 11:45:01', 0, '2022-03-06 11:45:01', 0);
INSERT INTO `index_config` VALUES (33, '菊乐有机 有机鲜牛奶', 5, 25, '##', 0, 0, '2022-03-06 11:45:19', 0, '2022-03-06 11:45:19', 0);
INSERT INTO `index_config` VALUES (34, '农家散养玉米黄柴鸡蛋', 5, 20, '##', 0, 0, '2022-03-06 11:45:34', 0, '2022-03-06 11:45:34', 0);
INSERT INTO `index_config` VALUES (35, '四川红心猕猴桃', 5, 17, '##', 0, 0, '2022-03-06 11:45:47', 0, '2022-03-06 11:45:47', 0);
INSERT INTO `index_config` VALUES (36, '雀巢 即溶咖啡', 5, 31, '##', 0, 0, '2022-03-06 11:46:03', 0, '2022-03-06 11:46:03', 0);
INSERT INTO `index_config` VALUES (37, '生菜', 5, 19, '##', 0, 0, '2022-03-06 11:46:28', 0, '2022-03-06 11:46:28', 0);
INSERT INTO `index_config` VALUES (38, '鲜活 俄罗斯帝王蟹', 5, 15, '##', 0, 0, '2022-03-06 11:46:56', 0, '2022-03-06 11:46:56', 0);
INSERT INTO `index_config` VALUES (39, '鲜活 波士顿龙虾', 5, 24, '##', 0, 0, '2022-03-06 11:47:10', 0, '2022-03-06 11:47:10', 0);
INSERT INTO `index_config` VALUES (40, 'SIRONI 炒锅', 5, 34, '##', 0, 0, '2022-03-06 11:47:38', 0, '2022-03-06 11:47:38', 0);
INSERT INTO `index_config` VALUES (41, 'SIRONI 炒锅', 5, 34, '##', 0, 0, '2022-03-06 11:47:50', 0, '2022-03-06 11:47:50', 0);
INSERT INTO `index_config` VALUES (42, 'dsa', 3, 0, '##', 0, 1, '2022-03-22 23:01:43', 0, '2022-03-22 23:01:51', 0);

-- ----------------------------
-- Table structure for order_general
-- ----------------------------
DROP TABLE IF EXISTS `order_general`;
CREATE TABLE `order_general`  (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单表主键id',
  `order_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户主键id',
  `total_price` int(11) NOT NULL DEFAULT 1 COMMENT '订单总价',
  `pay_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '支付状态:0.未支付,1.支付成功,-1:支付失败',
  `pay_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '0.无 1.支付宝支付 2.微信支付',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态:0.待支付 1.已支付 2.配货完成 3:出库成功 4.交易成功 -1.手动关闭 -2.超时关闭 -3.商家关闭',
  `extra_info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单body',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货人姓名',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货人手机号',
  `user_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货人收货地址',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最新修改时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_general
-- ----------------------------
INSERT INTO `order_general` VALUES (8, '202203067845100483', 2, 3508, 1, 2, '2022-03-06 11:53:10', 4, '', '', '', '成都信息工程大学学生公寓3栋2033', 0, '2022-03-06 11:53:04', '2022-03-06 11:54:07');
INSERT INTO `order_general` VALUES (9, '202203098721902353', 4, 1514, 1, 1, '2022-03-09 21:18:08', 4, '', '', '', '成信大学生公寓三栋2033', 0, '2022-03-09 21:17:52', '2022-03-09 21:20:11');
INSERT INTO `order_general` VALUES (10, '202203105323143741', 4, 7490, 1, 1, '2022-03-10 14:09:31', 4, '', '', '', '成信大学生公寓三栋2033', 0, '2022-03-10 14:08:52', '2022-03-10 14:10:29');
INSERT INTO `order_general` VALUES (11, '202203131859626588', 4, 50, 1, 1, '2022-03-13 22:21:30', -1, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-03-13 22:19:45', '2022-03-13 22:23:40');
INSERT INTO `order_general` VALUES (12, '202203192706596700', 4, 1643, 0, 0, NULL, -3, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-03-19 12:47:50', '2022-03-22 23:05:29');
INSERT INTO `order_general` VALUES (13, '202204017638686312', 4, 8, 1, 1, '2022-04-01 20:56:09', 4, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-04-01 20:56:03', '2022-04-01 20:56:28');
INSERT INTO `order_general` VALUES (14, '202204019772271246', 4, 4, 1, 2, '2022-04-01 20:59:58', 4, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-04-01 20:59:37', '2022-04-01 21:14:41');
INSERT INTO `order_general` VALUES (15, '202204024138701218', 4, 4494, 1, 2, '2022-04-02 09:03:50', -3, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-04-02 09:03:33', '2022-04-23 23:12:07');
INSERT INTO `order_general` VALUES (16, '202204235741836573', 4, 29800, 1, 2, '2022-04-23 22:04:53', -1, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-04-23 22:02:54', '2022-04-23 22:06:35');
INSERT INTO `order_general` VALUES (17, '202204249149546657', 4, 80, 1, 2, '2022-05-06 11:23:27', 4, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-04-24 15:55:14', '2022-05-06 11:24:12');
INSERT INTO `order_general` VALUES (18, '202204242014274408', 5, 1534, 1, 2, '2022-04-24 21:17:50', -3, '', '', '', '邓棋 17780540513 成信大3-2033', 0, '2022-04-24 21:16:41', '2022-04-24 21:31:46');
INSERT INTO `order_general` VALUES (19, '202204244720104473', 5, 109, 1, 2, '2022-04-24 23:02:23', -3, '', '', '', '邓棋 17780540513 成信大3-2033', 0, '2022-04-24 23:01:12', '2022-05-06 11:42:20');
INSERT INTO `order_general` VALUES (20, '202205025518549060', 4, 84, 0, 0, NULL, -3, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-05-02 10:29:11', '2022-05-06 11:41:37');
INSERT INTO `order_general` VALUES (21, '202205065561433560', 4, 108, 0, 0, NULL, -3, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-05-06 10:52:36', '2022-05-06 11:39:41');
INSERT INTO `order_general` VALUES (22, '202205062978328193', 4, 109, 0, 0, NULL, -3, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-05-06 11:21:37', '2022-05-06 11:24:42');
INSERT INTO `order_general` VALUES (23, '202205065595014641', 4, 1498, 1, 2, '2022-05-06 11:42:43', 4, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-05-06 11:42:39', '2022-05-06 11:42:57');
INSERT INTO `order_general` VALUES (24, '202205065950321209', 4, 88, 1, 2, '2022-05-06 11:43:17', -3, '', '', '', '邓棋 17780540513 成信大学生公寓三栋2033', 0, '2022-05-06 11:43:15', '2022-05-06 11:43:29');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单关联购物项主键id',
  `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单主键id',
  `goods_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联商品id',
  `goods_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '下单时商品的名称(订单快照)',
  `goods_cover_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '下单时商品的主图(订单快照)',
  `selling_price` int(11) NOT NULL DEFAULT 1 COMMENT '下单时商品的价格(订单快照)',
  `goods_count` int(11) NOT NULL DEFAULT 1 COMMENT '数量(订单快照)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`order_item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (9, 8, 15, '鲜活 俄罗斯帝王蟹', 'http://localhost:8080/upload/20220305_22443173.JPG', 1498, 2, '2022-03-06 11:53:04');
INSERT INTO `order_item` VALUES (10, 8, 24, '鲜活 波士顿龙虾', 'http://localhost:8080/upload/20220305_23071650.JPG', 169, 1, '2022-03-06 11:53:04');
INSERT INTO `order_item` VALUES (11, 8, 33, '谷优 奇亚籽咸香小饼干', 'http://localhost:8080/upload/20220306_11323911.JPG', 31, 5, '2022-03-06 11:53:04');
INSERT INTO `order_item` VALUES (12, 8, 30, '张裕 干红葡萄酒', 'http://localhost:8080/upload/20220305_23204679.JPG', 188, 1, '2022-03-06 11:53:04');
INSERT INTO `order_item` VALUES (13, 9, 18, '国产蓝莓', 'http://localhost:8080/upload/20220305_22525914.JPG', 16, 1, '2022-03-09 21:17:52');
INSERT INTO `order_item` VALUES (14, 9, 15, '鲜活 俄罗斯帝王蟹', 'http://localhost:8080/upload/20220305_22443173.JPG', 1498, 1, '2022-03-09 21:17:52');
INSERT INTO `order_item` VALUES (15, 10, 15, '鲜活 俄罗斯帝王蟹', 'http://localhost:8080/upload/20220305_22443173.JPG', 1498, 5, '2022-03-10 14:08:52');
INSERT INTO `order_item` VALUES (16, 11, 26, '提拉米苏', 'http://localhost:8080/upload/20220305_23114288.JPG', 50, 1, '2022-03-13 22:19:45');
INSERT INTO `order_item` VALUES (17, 12, 15, '鲜活 俄罗斯帝王蟹', 'http://localhost:8080/upload/20220305_22443173.JPG', 1498, 1, '2022-03-19 12:47:50');
INSERT INTO `order_item` VALUES (18, 12, 28, '君稻 五常长粒香米', 'http://localhost:8080/upload/20220305_23163113.JPG', 36, 1, '2022-03-19 12:47:50');
INSERT INTO `order_item` VALUES (19, 12, 22, '恒都 澳洲去骨羊后腿肉', 'http://localhost:8080/upload/20220305_23020996.JPG', 109, 1, '2022-03-19 12:47:50');
INSERT INTO `order_item` VALUES (20, 13, 19, '生菜', 'http://localhost:8080/upload/20220305_22544160.JPG', 2, 4, '2022-04-01 20:56:03');
INSERT INTO `order_item` VALUES (21, 14, 19, '生菜', 'http://localhost:8080/upload/20220305_22544160.JPG', 2, 2, '2022-04-01 20:59:37');
INSERT INTO `order_item` VALUES (22, 15, 15, '鲜活 俄罗斯帝王蟹', 'http://localhost:8080/upload/20220305_22443173.JPG', 1498, 3, '2022-04-02 09:03:33');
INSERT INTO `order_item` VALUES (23, 16, 25, '菊乐有机 有机鲜牛奶', 'http://localhost:8080/upload/20220305_23094566.JPG', 20, 1, '2022-04-23 22:02:54');
INSERT INTO `order_item` VALUES (24, 16, 24, '鲜活 波士顿龙虾', 'http://localhost:8080/upload/20220305_23071650.JPG', 169, 1, '2022-04-23 22:02:54');
INSERT INTO `order_item` VALUES (25, 16, 22, '恒都 澳洲去骨羊后腿肉', 'http://localhost:8080/upload/20220305_23020996.JPG', 109, 1, '2022-04-23 22:02:54');
INSERT INTO `order_item` VALUES (26, 17, 25, '菊乐有机 有机鲜牛奶', 'http://localhost:8080/upload/20220305_23094566.JPG', 20, 4, '2022-04-24 15:55:14');
INSERT INTO `order_item` VALUES (27, 18, 28, '君稻 五常长粒香米', 'http://localhost:8080/upload/20220305_23163113.JPG', 36, 1, '2022-04-24 21:16:41');
INSERT INTO `order_item` VALUES (28, 18, 15, '鲜活 俄罗斯帝王蟹', 'http://localhost:8080/upload/20220305_22443173.JPG', 1498, 1, '2022-04-24 21:16:41');
INSERT INTO `order_item` VALUES (29, 19, 22, '恒都 澳洲去骨羊后腿肉', 'http://localhost:8080/upload/20220305_23020996.JPG', 109, 1, '2022-04-24 23:01:12');
INSERT INTO `order_item` VALUES (30, 20, 25, '菊乐有机 有机鲜牛奶', 'http://localhost:8080/upload/20220305_23094566.JPG', 20, 4, '2022-05-02 10:29:11');
INSERT INTO `order_item` VALUES (31, 20, 19, '生菜', 'http://localhost:8080/upload/20220305_22544160.JPG', 2, 2, '2022-05-02 10:29:11');
INSERT INTO `order_item` VALUES (32, 21, 28, '君稻 五常长粒香米', 'http://localhost:8080/upload/20220305_23163113.JPG', 36, 3, '2022-05-06 10:52:36');
INSERT INTO `order_item` VALUES (33, 22, 22, '恒都 澳洲去骨羊后腿肉', 'http://localhost:8080/upload/20220305_23020996.JPG', 109, 1, '2022-05-06 11:21:37');
INSERT INTO `order_item` VALUES (34, 23, 15, '鲜活 俄罗斯帝王蟹', 'http://localhost:8080/upload/20220305_22443173.JPG', 1498, 1, '2022-05-06 11:42:39');
INSERT INTO `order_item` VALUES (35, 24, 16, '冻整只熟棕蟹', 'http://localhost:8080/upload/20220305_22465349.JPG', 88, 1, '2022-05-06 11:43:15');

-- ----------------------------
-- Table structure for ordinary_user
-- ----------------------------
DROP TABLE IF EXISTS `ordinary_user`;
CREATE TABLE `ordinary_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键id',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
  `login_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '登陆名称(默认为手机号)',
  `password_md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'MD5加密后的密码',
  `introduce_sign` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '个性签名',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货地址',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '注销标识字段(0-正常 1-已注销)',
  `locked_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '锁定标识字段(0-未锁定 1-已锁定)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ordinary_user
-- ----------------------------
INSERT INTO `ordinary_user` VALUES (2, 'Cornelius', '17780540513', '8a14bdd1d461759e774fbbcdf22397a5', 'TEST', '成都信息工程大学学生公寓3栋2033', 0, 0, '2022-02-22 15:17:53');
INSERT INTO `ordinary_user` VALUES (4, '邓棋', '17780540517', 'e10adc3949ba59abbe56e057f20f883e', 'test', '邓棋 17780540513 成信大学生公寓三栋2033', 0, 0, '2022-03-07 22:13:42');
INSERT INTO `ordinary_user` VALUES (5, '邓棋_GD_Test', '17780540577', 'e10adc3949ba59abbe56e057f20f883e', 'UESTC_CS_Master', '邓棋 17780540513 成信大3-2033', 0, 0, '2022-04-24 20:32:07');

-- ----------------------------
-- Table structure for shopping_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart_item`;
CREATE TABLE `shopping_cart_item`  (
  `cart_item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物项主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  `goods_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联商品id',
  `goods_count` int(11) NOT NULL DEFAULT 1 COMMENT '数量(最大为5)',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最新修改时间',
  PRIMARY KEY (`cart_item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_cart_item
-- ----------------------------
INSERT INTO `shopping_cart_item` VALUES (19, 2, 15, 2, 1, '2022-03-06 11:51:36', '2022-03-06 11:52:16');
INSERT INTO `shopping_cart_item` VALUES (20, 2, 24, 1, 1, '2022-03-06 11:51:42', '2022-03-06 11:51:42');
INSERT INTO `shopping_cart_item` VALUES (21, 2, 33, 5, 1, '2022-03-06 11:52:05', '2022-03-06 11:52:22');
INSERT INTO `shopping_cart_item` VALUES (22, 2, 30, 1, 1, '2022-03-06 11:52:10', '2022-03-06 11:52:10');
INSERT INTO `shopping_cart_item` VALUES (23, 4, 18, 1, 1, '2022-03-09 21:17:07', '2022-03-09 21:17:07');
INSERT INTO `shopping_cart_item` VALUES (24, 4, 15, 1, 1, '2022-03-09 21:17:34', '2022-03-09 21:17:34');
INSERT INTO `shopping_cart_item` VALUES (25, 4, 15, 5, 1, '2022-03-10 14:06:35', '2022-03-10 14:07:04');
INSERT INTO `shopping_cart_item` VALUES (26, 4, 26, 1, 1, '2022-03-13 22:13:48', '2022-03-13 22:13:48');
INSERT INTO `shopping_cart_item` VALUES (27, 4, 15, 1, 1, '2022-03-19 11:59:16', '2022-03-19 12:47:46');
INSERT INTO `shopping_cart_item` VALUES (28, 4, 28, 1, 1, '2022-03-19 12:34:43', '2022-03-19 12:34:53');
INSERT INTO `shopping_cart_item` VALUES (29, 4, 22, 1, 1, '2022-03-19 12:42:50', '2022-03-19 12:43:29');
INSERT INTO `shopping_cart_item` VALUES (30, 4, 28, 1, 1, '2022-03-19 12:48:32', '2022-03-22 23:03:00');
INSERT INTO `shopping_cart_item` VALUES (31, 4, 19, 1, 1, '2022-03-19 13:02:18', '2022-04-01 18:01:30');
INSERT INTO `shopping_cart_item` VALUES (32, 4, 18, 1, 1, '2022-03-19 13:29:46', '2022-04-01 18:05:54');
INSERT INTO `shopping_cart_item` VALUES (33, 4, 26, 1, 1, '2022-03-19 13:38:51', '2022-03-19 13:40:57');
INSERT INTO `shopping_cart_item` VALUES (34, 4, 21, 1, 1, '2022-03-20 10:15:58', '2022-03-20 10:17:20');
INSERT INTO `shopping_cart_item` VALUES (35, 4, 15, 1, 1, '2022-04-01 18:08:17', '2022-04-01 18:15:56');
INSERT INTO `shopping_cart_item` VALUES (36, 4, 28, 1, 1, '2022-04-01 18:09:25', '2022-04-01 18:09:25');
INSERT INTO `shopping_cart_item` VALUES (37, 4, 22, 1, 1, '2022-04-01 18:16:03', '2022-04-01 18:16:03');
INSERT INTO `shopping_cart_item` VALUES (38, 4, 28, 1, 1, '2022-04-01 18:18:33', '2022-04-01 18:19:52');
INSERT INTO `shopping_cart_item` VALUES (39, 4, 19, 1, 1, '2022-04-01 20:55:24', '2022-04-01 20:55:24');
INSERT INTO `shopping_cart_item` VALUES (40, 4, 19, 4, 1, '2022-04-01 20:55:50', '2022-04-01 20:55:57');
INSERT INTO `shopping_cart_item` VALUES (41, 4, 19, 2, 1, '2022-04-01 20:57:17', '2022-04-01 20:59:03');
INSERT INTO `shopping_cart_item` VALUES (42, 4, 19, 5, 1, '2022-04-01 21:14:49', '2022-04-02 08:59:39');
INSERT INTO `shopping_cart_item` VALUES (43, 4, 21, 1, 1, '2022-04-01 21:15:23', '2022-04-01 21:28:50');
INSERT INTO `shopping_cart_item` VALUES (44, 4, 28, 1, 1, '2022-04-01 21:27:09', '2022-04-01 21:36:29');
INSERT INTO `shopping_cart_item` VALUES (45, 4, 15, 3, 1, '2022-04-02 09:00:56', '2022-04-02 09:01:02');
INSERT INTO `shopping_cart_item` VALUES (46, 4, 25, 1, 1, '2022-04-02 09:38:34', '2022-04-02 09:38:34');
INSERT INTO `shopping_cart_item` VALUES (47, 4, 24, 1, 1, '2022-04-02 09:38:38', '2022-04-02 09:38:38');
INSERT INTO `shopping_cart_item` VALUES (48, 4, 22, 1, 1, '2022-04-02 09:38:44', '2022-04-23 21:59:54');
INSERT INTO `shopping_cart_item` VALUES (49, 4, 25, 4, 1, '2022-04-24 15:21:25', '2022-04-24 15:21:53');
INSERT INTO `shopping_cart_item` VALUES (50, 4, 19, 2, 1, '2022-04-24 15:21:29', '2022-04-24 15:21:48');
INSERT INTO `shopping_cart_item` VALUES (51, 5, 28, 5, 1, '2022-04-24 20:55:01', '2022-04-24 20:57:04');
INSERT INTO `shopping_cart_item` VALUES (52, 5, 28, 1, 1, '2022-04-24 21:01:36', '2022-04-24 21:01:36');
INSERT INTO `shopping_cart_item` VALUES (53, 5, 15, 1, 1, '2022-04-24 21:16:22', '2022-04-24 21:16:22');
INSERT INTO `shopping_cart_item` VALUES (54, 5, 22, 1, 1, '2022-04-24 23:01:09', '2022-04-24 23:01:09');
INSERT INTO `shopping_cart_item` VALUES (55, 4, 25, 4, 1, '2022-05-02 10:27:40', '2022-05-02 10:28:00');
INSERT INTO `shopping_cart_item` VALUES (56, 4, 19, 2, 1, '2022-05-02 10:27:45', '2022-05-02 10:28:02');
INSERT INTO `shopping_cart_item` VALUES (57, 4, 28, 3, 1, '2022-05-06 10:44:43', '2022-05-06 10:47:29');
INSERT INTO `shopping_cart_item` VALUES (58, 4, 26, 1, 1, '2022-05-06 10:44:47', '2022-05-06 10:44:47');
INSERT INTO `shopping_cart_item` VALUES (59, 4, 22, 1, 1, '2022-05-06 11:20:45', '2022-05-06 11:20:45');
INSERT INTO `shopping_cart_item` VALUES (60, 4, 15, 1, 1, '2022-05-06 11:28:15', '2022-05-06 11:42:35');
INSERT INTO `shopping_cart_item` VALUES (61, 4, 16, 1, 1, '2022-05-06 11:43:11', '2022-05-06 11:43:11');

SET FOREIGN_KEY_CHECKS = 1;
