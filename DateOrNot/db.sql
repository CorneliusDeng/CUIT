SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Blog
-- ----------------------------
DROP TABLE IF EXISTS `Blog`;
CREATE TABLE `Blog`  (
  `blog_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `thumbs_up` int NOT NULL DEFAULT 0,
  `release_time` datetime(0) NOT NULL,
  `state` int NOT NULL DEFAULT 1,
  `text_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img_links` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comments_num` int NULL DEFAULT 0,
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Blog
-- ----------------------------
INSERT INTO `Blog` VALUES (5, 1, 0, '2021-05-13 17:02:20', 1, '天气真好', NULL, 0);
INSERT INTO `Blog` VALUES (7, 1, 0, '2021-05-13 18:10:14', 1, '哈哈', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/97671620900613103.jpg', 0);
INSERT INTO `Blog` VALUES (8, 1, 0, '2021-05-13 18:11:38', 1, '哈哈', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/41691620900697286.jpg', 1);
INSERT INTO `Blog` VALUES (9, 1, 0, '2021-05-13 18:12:53', 1, '', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/63971620900772272.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/75291620900772382.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/51811620900772515.jpg', 0);
INSERT INTO `Blog` VALUES (10, 1, 0, '2021-05-15 15:21:55', 1, '测试动态', NULL, 0);
INSERT INTO `Blog` VALUES (11, 1, 0, '2021-05-15 15:24:02', 1, '再来一条测试', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/71471621063442313.jpg', 0);
INSERT INTO `Blog` VALUES (12, 1, 0, '2021-05-15 15:24:46', 1, '再来一条', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/76351621063485850.jpg', 0);
INSERT INTO `Blog` VALUES (13, 1, 0, '2021-05-15 15:36:04', 1, '', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/61731621064163946.jpg', 0);
INSERT INTO `Blog` VALUES (14, 1, 0, '2021-05-15 15:36:54', 1, '', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/90841621064213639.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/24151621064214007.jpg', 0);
INSERT INTO `Blog` VALUES (15, 1, 0, '2021-05-15 15:37:53', 1, '', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/38791621064272519.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/54131621064272919.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/36851621064273002.jpg', 2);
INSERT INTO `Blog` VALUES (16, 1, 0, '2021-05-15 15:55:15', 1, '这是一条新的动态', NULL, 10);
INSERT INTO `Blog` VALUES (17, 1, 2, '2021-05-16 10:46:21', 1, '新鲜的动态', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/48601621133180845.jpg', 1);
INSERT INTO `Blog` VALUES (18, 1, 1, '2021-05-16 10:56:27', 0, '吃吃吃', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/98001621133784331.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/18921621133784484.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/54331621133784713.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/8391621133784864.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/7941621133785000.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/46241621133786177.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/88731621133786320.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/50851621133786428.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/21901621133786578.jpg', 4);
INSERT INTO `Blog` VALUES (34, 3, 1, '2021-05-17 19:22:00', 1, '李四的动态修改后', NULL, 1);
INSERT INTO `Blog` VALUES (35, 1, 1, '2021-05-17 20:31:02', 1, '修改了这条动态3', NULL, 0);
INSERT INTO `Blog` VALUES (38, 1, 1, '2021-05-18 10:28:19', 1, '测试', NULL, 0);
INSERT INTO `Blog` VALUES (40, 1, 1, '2021-05-18 10:28:52', 1, '测试修改2.0', NULL, 0);
INSERT INTO `Blog` VALUES (41, 1, 0, '2021-05-18 11:33:17', 1, '测试', NULL, 0);
INSERT INTO `Blog` VALUES (42, 1, 1, '2021-05-18 11:34:07', 1, 'hh', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/19661621308845540.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/83051621308845804.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/92531621308845945.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/50181621308846119.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/96231621308846255.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/41601621308846383.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/21081621308846524.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/78051621308846661.jpg;https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/76481621308846779.jpg', 0);
INSERT INTO `Blog` VALUES (45, 12, 1, '2021-05-19 12:53:51', 1, 'nice', NULL, 1);
INSERT INTO `Blog` VALUES (48, 12, 0, '2021-05-19 05:43:19', 1, '头秃', 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/58211621402999059.GIF', 0);

-- ----------------------------
-- Table structure for BlogCheck
-- ----------------------------
DROP TABLE IF EXISTS `BlogCheck`;
CREATE TABLE `BlogCheck`  (
  `serial_num` int NOT NULL AUTO_INCREMENT,
  `blog_id` int NOT NULL,
  `status` int NOT NULL,
  `reason` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  PRIMARY KEY (`serial_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of BlogCheck
-- ----------------------------

-- ----------------------------
-- Table structure for BlogImage
-- ----------------------------
DROP TABLE IF EXISTS `BlogImage`;
CREATE TABLE `BlogImage`  (
  `image_id` int NOT NULL AUTO_INCREMENT,
  `blog_id` int NOT NULL,
  `link` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of BlogImage
-- ----------------------------
INSERT INTO `BlogImage` VALUES (1, 8, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/41691620900697286.jpg');
INSERT INTO `BlogImage` VALUES (2, 9, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/63971620900772272.jpg');
INSERT INTO `BlogImage` VALUES (3, 9, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/75291620900772382.jpg');
INSERT INTO `BlogImage` VALUES (4, 9, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/51811620900772515.jpg');
INSERT INTO `BlogImage` VALUES (5, 11, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/71471621063442313.jpg');
INSERT INTO `BlogImage` VALUES (6, 12, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/76351621063485850.jpg');
INSERT INTO `BlogImage` VALUES (7, 13, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/61731621064163946.jpg');
INSERT INTO `BlogImage` VALUES (8, 14, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/90841621064213639.jpg');
INSERT INTO `BlogImage` VALUES (9, 14, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/24151621064214007.jpg');
INSERT INTO `BlogImage` VALUES (10, 15, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/38791621064272519.jpg');
INSERT INTO `BlogImage` VALUES (11, 15, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/54131621064272919.jpg');
INSERT INTO `BlogImage` VALUES (12, 15, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/36851621064273002.jpg');
INSERT INTO `BlogImage` VALUES (13, 17, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/48601621133180845.jpg');
INSERT INTO `BlogImage` VALUES (14, 18, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/98001621133784331.jpg');
INSERT INTO `BlogImage` VALUES (15, 18, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/18921621133784484.jpg');
INSERT INTO `BlogImage` VALUES (16, 18, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/54331621133784713.jpg');
INSERT INTO `BlogImage` VALUES (17, 18, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/8391621133784864.jpg');
INSERT INTO `BlogImage` VALUES (18, 18, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/7941621133785000.jpg');
INSERT INTO `BlogImage` VALUES (19, 18, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/46241621133786177.jpg');
INSERT INTO `BlogImage` VALUES (20, 18, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/88731621133786320.jpg');
INSERT INTO `BlogImage` VALUES (21, 18, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/50851621133786428.jpg');
INSERT INTO `BlogImage` VALUES (22, 18, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/21901621133786578.jpg');
INSERT INTO `BlogImage` VALUES (23, 42, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/19661621308845540.jpg');
INSERT INTO `BlogImage` VALUES (24, 42, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/83051621308845804.jpg');
INSERT INTO `BlogImage` VALUES (25, 42, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/92531621308845945.jpg');
INSERT INTO `BlogImage` VALUES (26, 42, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/50181621308846119.jpg');
INSERT INTO `BlogImage` VALUES (27, 42, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/96231621308846255.jpg');
INSERT INTO `BlogImage` VALUES (28, 42, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/41601621308846383.jpg');
INSERT INTO `BlogImage` VALUES (29, 42, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/21081621308846524.jpg');
INSERT INTO `BlogImage` VALUES (30, 42, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/78051621308846661.jpg');
INSERT INTO `BlogImage` VALUES (31, 42, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/76481621308846779.jpg');
INSERT INTO `BlogImage` VALUES (36, 45, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/16191621402948340.GIF');
INSERT INTO `BlogImage` VALUES (37, 45, 'https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/images/58211621402999059.GIF');

-- ----------------------------
-- Table structure for Comment
-- ----------------------------
DROP TABLE IF EXISTS `Comment`;
CREATE TABLE `Comment`  (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `blog_id` int NOT NULL,
  `user_id` int NOT NULL,
  `comment_content` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_time` datetime(0) NOT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `idx_blog_user_id`(`blog_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Comment
-- ----------------------------
INSERT INTO `Comment` VALUES (10, 16, 1, '测试评论1', '2021-05-15 23:14:08');
INSERT INTO `Comment` VALUES (11, 16, 1, '测试评论2', '2021-05-15 23:14:18');
INSERT INTO `Comment` VALUES (12, 16, 1, '测试评论3', '2021-05-15 23:16:12');
INSERT INTO `Comment` VALUES (13, 16, 1, '测试评论4', '2021-05-15 23:22:55');
INSERT INTO `Comment` VALUES (14, 16, 1, '测试评论5', '2021-05-15 23:23:08');
INSERT INTO `Comment` VALUES (15, 15, 1, '测试评论1', '2021-05-15 23:26:14');
INSERT INTO `Comment` VALUES (16, 16, 1, '测试评论6', '2021-05-15 23:28:00');
INSERT INTO `Comment` VALUES (17, 16, 1, '测试评论7', '2021-05-16 10:20:09');
INSERT INTO `Comment` VALUES (18, 16, 1, '测试评论8', '2021-05-16 10:39:08');
INSERT INTO `Comment` VALUES (19, 16, 1, '测试评论9', '2021-05-16 10:40:05');
INSERT INTO `Comment` VALUES (20, 16, 1, '测试评论10', '2021-05-16 10:40:21');
INSERT INTO `Comment` VALUES (21, 15, 1, '测试评论2', '2021-05-16 10:42:45');
INSERT INTO `Comment` VALUES (22, 17, 1, '真不错', '2021-05-16 10:46:46');
INSERT INTO `Comment` VALUES (23, 18, 1, '测试评论1', '2021-05-16 11:27:35');
INSERT INTO `Comment` VALUES (24, 18, 1, '测试评论2', '2021-05-16 15:49:08');
INSERT INTO `Comment` VALUES (25, 18, 1, '测试评论3', '2021-05-16 15:50:16');
INSERT INTO `Comment` VALUES (26, 18, 1, '测试评论4', '2021-05-16 17:40:17');
INSERT INTO `Comment` VALUES (27, 34, 3, '李四的评论', '2021-05-17 18:15:33');
INSERT INTO `Comment` VALUES (28, 8, 1, 'zzzz', '2021-05-17 20:17:00');
INSERT INTO `Comment` VALUES (30, 45, 1, 'nice', '2021-05-19 13:26:45');

-- ----------------------------
-- Table structure for GroupChat
-- ----------------------------
DROP TABLE IF EXISTS `GroupChat`;
CREATE TABLE `GroupChat`  (
  `group_id` int NOT NULL AUTO_INCREMENT,
  `group_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner_id` int NOT NULL,
  `member_count` int NOT NULL,
  `create_time` date NOT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int NOT NULL,
  `head_image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`group_id`) USING BTREE,
  INDEX `idx_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000042 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of GroupChat
-- ----------------------------
INSERT INTO `GroupChat` VALUES (1000002, '匹配测试群-2', 2, 9, '2021-05-06', '用于群聊匹配测试', 0, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/groupPotraits/2.jpg');
INSERT INTO `GroupChat` VALUES (1000020, '测试测试', 1, 1, '2021-05-13', '123123213123', 0, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/groupPotraits/1undefined03710f4576770d40000012e7e95c044.gif');
INSERT INTO `GroupChat` VALUES (1000021, '“学习资料”分享群', 1, 1, '2021-05-13', '我们分享“学习资料”', 0, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/groupPotraits/1undefinedpotr.gif');
INSERT INTO `GroupChat` VALUES (1000022, '弔图分享群', 1, 1, '2021-05-13', '我们发弔图', 0, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/groupPotraits/1undefinedpotase1.jpg');
INSERT INTO `GroupChat` VALUES (1000039, '匹配测试群1', 2, 1, '2021-05-18', '匹配测试，不要删除！！！', 0, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/groupPotraits/1哈哈哈哈哈1621334927639');
INSERT INTO `GroupChat` VALUES (1000040, '专治脱发', 12, 1, '2021-05-18', '欢迎各位同学加入', 0, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/groupPotraits/1专治脱发1621349314468');
INSERT INTO `GroupChat` VALUES (1000046, 'dummy1的群', 12, 1, '2021-05-19', 'hshshajaj', 0, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/groupPotraits/12dummy1的群1621403251890');
INSERT INTO `GroupChat` VALUES (1000047, '开黑一群', 1, 1, '2021-05-19', 'jdhbebwbbsb', 0, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/groupPotraits/1开黑一群1621403789646');

-- ----------------------------
-- Table structure for GroupCheck
-- ----------------------------
DROP TABLE IF EXISTS `GroupCheck`;
CREATE TABLE `GroupCheck`  (
  `serial_num` int NOT NULL AUTO_INCREMENT,
  `group_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner_id` int NOT NULL,
  `time` datetime(0) NOT NULL,
  `status` int NOT NULL,
  `reason` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `head_image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`serial_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of GroupCheck
-- ----------------------------

-- ----------------------------
-- Table structure for GroupMember
-- ----------------------------
DROP TABLE IF EXISTS `GroupMember`;
CREATE TABLE `GroupMember`  (
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  INDEX `idx_group_id`(`group_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of GroupMember
-- ----------------------------
INSERT INTO `GroupMember` VALUES (12, 1000039);
INSERT INTO `GroupMember` VALUES (13, 1000039);
INSERT INTO `GroupMember` VALUES (14, 1000039);
INSERT INTO `GroupMember` VALUES (15, 1000039);
INSERT INTO `GroupMember` VALUES (16, 1000039);
INSERT INTO `GroupMember` VALUES (17, 1000039);
INSERT INTO `GroupMember` VALUES (18, 1000039);
INSERT INTO `GroupMember` VALUES (19, 1000039);
INSERT INTO `GroupMember` VALUES (20, 1000039);
INSERT INTO `GroupMember` VALUES (12, 1000002);
INSERT INTO `GroupMember` VALUES (13, 1000002);
INSERT INTO `GroupMember` VALUES (14, 1000002);
INSERT INTO `GroupMember` VALUES (15, 1000002);
INSERT INTO `GroupMember` VALUES (16, 1000002);
INSERT INTO `GroupMember` VALUES (17, 1000002);
INSERT INTO `GroupMember` VALUES (18, 1000002);
INSERT INTO `GroupMember` VALUES (19, 1000002);
INSERT INTO `GroupMember` VALUES (20, 1000002);
INSERT INTO `GroupMember` VALUES (21, 1000039);
INSERT INTO `GroupMember` VALUES (21, 1000002);
INSERT INTO `GroupMember` VALUES (1, 1000002);
INSERT INTO `GroupMember` VALUES (2, 1000039);
INSERT INTO `GroupMember` VALUES (2, 1000002);
INSERT INTO `GroupMember` VALUES (2, 1000000);
INSERT INTO `GroupMember` VALUES (1, 1000020);
INSERT INTO `GroupMember` VALUES (1, 1000021);
INSERT INTO `GroupMember` VALUES (1, 1000022);
INSERT INTO `GroupMember` VALUES (1, 1000024);
INSERT INTO `GroupMember` VALUES (1, 1000031);
INSERT INTO `GroupMember` VALUES (1, 1000038);
INSERT INTO `GroupMember` VALUES (12, 1000040);
INSERT INTO `GroupMember` VALUES (12, 1000046);
INSERT INTO `GroupMember` VALUES (1, 1000047);

-- ----------------------------
-- Table structure for GroupTag
-- ----------------------------
DROP TABLE IF EXISTS `GroupTag`;
CREATE TABLE `GroupTag`  (
  `group_id` int NOT NULL,
  `tag_id` int NOT NULL,
  PRIMARY KEY (`group_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of GroupTag
-- ----------------------------
INSERT INTO `GroupTag` VALUES (1000002, 19);
INSERT INTO `GroupTag` VALUES (1000002, 23);
INSERT INTO `GroupTag` VALUES (1000002, 25);
INSERT INTO `GroupTag` VALUES (1000020, 20);
INSERT INTO `GroupTag` VALUES (1000020, 41);
INSERT INTO `GroupTag` VALUES (1000020, 49);
INSERT INTO `GroupTag` VALUES (1000021, 18);
INSERT INTO `GroupTag` VALUES (1000022, 18);
INSERT INTO `GroupTag` VALUES (1000022, 28);
INSERT INTO `GroupTag` VALUES (1000022, 38);
INSERT INTO `GroupTag` VALUES (1000022, 40);
INSERT INTO `GroupTag` VALUES (1000038, 40);
INSERT INTO `GroupTag` VALUES (1000039, 5);
INSERT INTO `GroupTag` VALUES (1000039, 6);
INSERT INTO `GroupTag` VALUES (1000039, 8);
INSERT INTO `GroupTag` VALUES (1000039, 52);
INSERT INTO `GroupTag` VALUES (1000040, 5);
INSERT INTO `GroupTag` VALUES (1000040, 7);
INSERT INTO `GroupTag` VALUES (1000040, 18);
INSERT INTO `GroupTag` VALUES (1000040, 61);
INSERT INTO `GroupTag` VALUES (1000040, 68);
INSERT INTO `GroupTag` VALUES (1000046, 5);
INSERT INTO `GroupTag` VALUES (1000046, 6);
INSERT INTO `GroupTag` VALUES (1000046, 7);
INSERT INTO `GroupTag` VALUES (1000046, 8);
INSERT INTO `GroupTag` VALUES (1000047, 19);
INSERT INTO `GroupTag` VALUES (1000047, 20);
INSERT INTO `GroupTag` VALUES (1000047, 41);

-- ----------------------------
-- Table structure for Likes
-- ----------------------------
DROP TABLE IF EXISTS `Likes`;
CREATE TABLE `Likes`  (
  `user_id` int NOT NULL,
  `blog_id` int NOT NULL,
  PRIMARY KEY (`user_id`, `blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Likes
-- ----------------------------
INSERT INTO `Likes` VALUES (1, 34);
INSERT INTO `Likes` VALUES (1, 35);
INSERT INTO `Likes` VALUES (1, 38);
INSERT INTO `Likes` VALUES (1, 40);
INSERT INTO `Likes` VALUES (12, 42);
INSERT INTO `Likes` VALUES (12, 45);

-- ----------------------------
-- Table structure for Log
-- ----------------------------
DROP TABLE IF EXISTS `Log`;
CREATE TABLE `Log`  (
  `serial_num` int NOT NULL AUTO_INCREMENT,
  `log_id` int NOT NULL,
  `log_type` int NOT NULL,
  `manager_id` int NOT NULL,
  `operation` int NOT NULL,
  `time` datetime(0) NOT NULL,
  PRIMARY KEY (`serial_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Log
-- ----------------------------
INSERT INTO `Log` VALUES (1, 1, 0, 1, 0, '2021-05-10 00:00:00');
INSERT INTO `Log` VALUES (3, 2, 1, 1, 1, '2021-05-13 10:43:24');
INSERT INTO `Log` VALUES (6, 0, 2, 1, 0, '2021-05-16 11:33:44');
INSERT INTO `Log` VALUES (7, 0, 2, 1, 0, '2021-05-16 11:34:01');
INSERT INTO `Log` VALUES (8, 0, 2, 1, 0, '2021-05-16 11:35:35');
INSERT INTO `Log` VALUES (9, 0, 2, 1, 0, '2021-05-16 11:37:02');
INSERT INTO `Log` VALUES (10, 1000001, 2, 1, 0, '2021-05-16 11:39:16');
INSERT INTO `Log` VALUES (11, 1000027, 2, 1, 0, '2021-05-16 21:54:46');
INSERT INTO `Log` VALUES (12, 1000028, 2, 1, 0, '2021-05-16 21:56:56');
INSERT INTO `Log` VALUES (14, 1000030, 2, 1, 0, '2021-05-16 22:02:16');
INSERT INTO `Log` VALUES (16, 3, 1, 1, 0, '2021-05-17 14:40:10');
INSERT INTO `Log` VALUES (17, 3, 1, 1, 1, '2021-05-17 14:41:44');
INSERT INTO `Log` VALUES (18, 2, 0, 1, 0, '2021-05-17 14:44:28');
INSERT INTO `Log` VALUES (19, 24, 0, 1, 0, '2021-05-18 15:39:31');
INSERT INTO `Log` VALUES (20, 18, 1, 1, 0, '2021-05-18 21:31:39');
INSERT INTO `Log` VALUES (21, 1000041, 2, 1, 0, '2021-05-19 11:01:29');
INSERT INTO `Log` VALUES (22, 1024, 2, 1, 1, '2021-05-19 11:16:41');
INSERT INTO `Log` VALUES (23, 2, 1, 1, 0, '2021-05-19 11:22:45');
INSERT INTO `Log` VALUES (24, 4, 1, 1, 0, '2021-05-19 11:22:54');
INSERT INTO `Log` VALUES (25, 1024, 2, 1, 1, '2021-05-19 11:24:27');
INSERT INTO `Log` VALUES (26, 1024, 2, 1, 1, '2021-05-19 11:24:39');
INSERT INTO `Log` VALUES (27, 2, 1, 1, 1, '2021-05-19 11:25:48');
INSERT INTO `Log` VALUES (28, 4, 1, 1, 1, '2021-05-19 11:26:04');
INSERT INTO `Log` VALUES (29, 3, 0, 1, 0, '2021-05-19 11:26:50');
INSERT INTO `Log` VALUES (30, 3, 1, 1, 0, '2021-05-19 11:48:34');
INSERT INTO `Log` VALUES (31, 1, 1, 1, 1, '2021-05-19 11:50:15');
INSERT INTO `Log` VALUES (32, 1024, 2, 1, 1, '2021-05-19 11:50:52');
INSERT INTO `Log` VALUES (33, 4, 0, 1, 0, '2021-05-19 11:52:17');
INSERT INTO `Log` VALUES (34, 5, 0, 1, 0, '2021-05-19 11:53:07');
INSERT INTO `Log` VALUES (35, 25, 0, 1, 0, '2021-05-19 11:54:13');
INSERT INTO `Log` VALUES (36, 2, 1, 1, 0, '2021-05-19 11:56:12');
INSERT INTO `Log` VALUES (37, 1000045, 2, 1, 1, '2021-05-19 12:12:39');
INSERT INTO `Log` VALUES (38, 1000045, 2, 1, 0, '2021-05-19 12:13:25');
INSERT INTO `Log` VALUES (39, 1000020, 2, 1, 1, '2021-05-19 13:29:11');
INSERT INTO `Log` VALUES (40, 1000038, 2, 1, 0, '2021-05-19 13:29:14');

-- ----------------------------
-- Table structure for Manager
-- ----------------------------
DROP TABLE IF EXISTS `Manager`;
CREATE TABLE `Manager`  (
  `manager_id` int NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`manager_id`) USING BTREE,
  UNIQUE INDEX `login_name`(`login_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Manager
-- ----------------------------
INSERT INTO `Manager` VALUES (1, 'King', ' dateornot');

-- ----------------------------
-- Table structure for OfflineMessage
-- ----------------------------
DROP TABLE IF EXISTS `OfflineMessage`;
CREATE TABLE `OfflineMessage`  (
  `msg_id` int NOT NULL AUTO_INCREMENT,
  `sender_id` int NOT NULL,
  `accepter_id` int NOT NULL,
  `sender_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sender_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_group_chat` int NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  PRIMARY KEY (`msg_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 167 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of OfflineMessage
-- ----------------------------
INSERT INTO `OfflineMessage` VALUES (99, 666, 9999, 'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/abiao.jpg', '阿彪', 0, 'text', '你好啊\n', '2021-05-14 15:06:39');
INSERT INTO `OfflineMessage` VALUES (100, 666, 9999, 'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/abiao.jpg', '阿彪', 0, 'text', '66666\n', '2021-05-14 15:06:47');
INSERT INTO `OfflineMessage` VALUES (101, 666, 9999, 'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/abiao.jpg', '阿彪', 0, 'text', '857857857857857\n', '2021-05-14 15:06:56');
INSERT INTO `OfflineMessage` VALUES (120, 666, 9999, 'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/abiao.jpg', '阿彪', 0, 'file', 'https://ylm-1305565335.file.myqcloud.com/file/2021/05/16210704070637286$1621051961262.jpeg', '2021-05-15 09:20:06');
INSERT INTO `OfflineMessage` VALUES (159, 666, 14, 'https://ylm-1305565335.cos.ap-chengdu.myqcloud.com/images/HeadPictures/abiao.jpg', '阿彪', 0, 'phone', '📞 未接电话', '2021-05-18 07:18:16');

-- ----------------------------
-- Table structure for Tag
-- ----------------------------
DROP TABLE IF EXISTS `Tag`;
CREATE TABLE `Tag`  (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE,
  UNIQUE INDEX `content`(`content`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Tag
-- ----------------------------
INSERT INTO `Tag` VALUES (85, '40K');
INSERT INTO `Tag` VALUES (89, '666');
INSERT INTO `Tag` VALUES (65, 'ACG');
INSERT INTO `Tag` VALUES (51, 'DND');
INSERT INTO `Tag` VALUES (31, 'Dota');
INSERT INTO `Tag` VALUES (59, 'IT');
INSERT INTO `Tag` VALUES (78, 'IT民工');
INSERT INTO `Tag` VALUES (68, 'Java');
INSERT INTO `Tag` VALUES (57, 'LOL');
INSERT INTO `Tag` VALUES (22, 'MC');
INSERT INTO `Tag` VALUES (41, 'PS4');
INSERT INTO `Tag` VALUES (23, 'P社');
INSERT INTO `Tag` VALUES (40, 'SB');
INSERT INTO `Tag` VALUES (32, 'Switch');
INSERT INTO `Tag` VALUES (42, 'XBOX');
INSERT INTO `Tag` VALUES (75, '中二病');
INSERT INTO `Tag` VALUES (12, '乒乓球');
INSERT INTO `Tag` VALUES (13, '二次元');
INSERT INTO `Tag` VALUES (60, '互联网');
INSERT INTO `Tag` VALUES (7, '健身');
INSERT INTO `Tag` VALUES (47, '写作');
INSERT INTO `Tag` VALUES (30, '古风');
INSERT INTO `Tag` VALUES (82, '吃货');
INSERT INTO `Tag` VALUES (63, '吃鸡');
INSERT INTO `Tag` VALUES (43, '吉他');
INSERT INTO `Tag` VALUES (6, '四六级');
INSERT INTO `Tag` VALUES (64, '夜跑');
INSERT INTO `Tag` VALUES (27, '大表哥');
INSERT INTO `Tag` VALUES (20, '开黑');
INSERT INTO `Tag` VALUES (84, '忠! 诚!');
INSERT INTO `Tag` VALUES (73, '懒狗');
INSERT INTO `Tag` VALUES (25, '战地V');
INSERT INTO `Tag` VALUES (26, '战地一');
INSERT INTO `Tag` VALUES (86, '战锤');
INSERT INTO `Tag` VALUES (66, '手办');
INSERT INTO `Tag` VALUES (81, '手工');
INSERT INTO `Tag` VALUES (17, '摄影');
INSERT INTO `Tag` VALUES (56, '摇滚');
INSERT INTO `Tag` VALUES (88, '收藏');
INSERT INTO `Tag` VALUES (36, '斗地主');
INSERT INTO `Tag` VALUES (44, '旅游');
INSERT INTO `Tag` VALUES (55, '村上春树');
INSERT INTO `Tag` VALUES (54, '果粉');
INSERT INTO `Tag` VALUES (49, '桌游');
INSERT INTO `Tag` VALUES (67, '汉服');
INSERT INTO `Tag` VALUES (58, '流行');
INSERT INTO `Tag` VALUES (52, '测试');
INSERT INTO `Tag` VALUES (19, '游戏');
INSERT INTO `Tag` VALUES (38, '滑稽');
INSERT INTO `Tag` VALUES (69, '炉石传说');
INSERT INTO `Tag` VALUES (79, '烹饪');
INSERT INTO `Tag` VALUES (14, '电影');
INSERT INTO `Tag` VALUES (46, '电音');
INSERT INTO `Tag` VALUES (61, '程序员');
INSERT INTO `Tag` VALUES (71, '穷游');
INSERT INTO `Tag` VALUES (9, '篮球');
INSERT INTO `Tag` VALUES (28, '绘画');
INSERT INTO `Tag` VALUES (33, '网球');
INSERT INTO `Tag` VALUES (34, '美剧');
INSERT INTO `Tag` VALUES (11, '羽毛球');
INSERT INTO `Tag` VALUES (5, '考研');
INSERT INTO `Tag` VALUES (39, '肝帝');
INSERT INTO `Tag` VALUES (29, '肥宅');
INSERT INTO `Tag` VALUES (80, '茶艺');
INSERT INTO `Tag` VALUES (87, '萌新');
INSERT INTO `Tag` VALUES (62, '萌新求带');
INSERT INTO `Tag` VALUES (16, '读书');
INSERT INTO `Tag` VALUES (18, '资源分享');
INSERT INTO `Tag` VALUES (10, '足球');
INSERT INTO `Tag` VALUES (50, '跑团');
INSERT INTO `Tag` VALUES (8, '跑步');
INSERT INTO `Tag` VALUES (74, '跳舞');
INSERT INTO `Tag` VALUES (37, '轻音乐');
INSERT INTO `Tag` VALUES (83, '逗比');
INSERT INTO `Tag` VALUES (45, '钢琴');
INSERT INTO `Tag` VALUES (48, '铲屎官');
INSERT INTO `Tag` VALUES (77, '非酋');
INSERT INTO `Tag` VALUES (15, '音乐');
INSERT INTO `Tag` VALUES (21, '骑砍');
INSERT INTO `Tag` VALUES (35, '麻将');
INSERT INTO `Tag` VALUES (24, '黑魂');

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` int NOT NULL,
  `head_image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `introduction` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int NOT NULL,
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '成都信息工程大学',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES (1, 'xxj', '12345678', 'XXJAY', 1, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/potraits/1.png', '1999-12-28', '	有趣的灵魂万里挑一', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (6, 'hdj', '12345678', '胡道江', 0, '', '2000-01-01', '...', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (12, 'dummy1', '12345678', 'Dummy-1', 0, 'https://dateornot-1257369645.cos.ap-chengdu.myqcloud.com/potraits/12.png', '1998-01-01', '匹配测试', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (13, 'dummy2', '12345678', 'Dummy-2', 0, '', '1994-01-01', '匹配测试', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (14, 'dummy3', '12345678', 'Dummy-3', 1, '', '1999-01-01', '匹配测试', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (15, 'dummy4', '12345678', 'Dummy-4', 0, '', '2002-01-01', '匹配测试', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (16, 'dummy5', '12345678', 'Dummy-5', 1, '', '1993-01-01', '匹配测试', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (17, 'dummy6', '12345678', 'Dummy-6', 1, '', '2003-01-01', '匹配测试', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (18, 'dummy7', '12345678', 'Dummy-7', 0, '', '1995-01-01', '匹配测试', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (19, 'dummy8', '12345678', 'Dummy-8', 1, '', '1999-01-01', '群成员地理分布测试：广东', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (20, 'dummy9', '12345678', 'Dummy-9', 0, '', '1994-01-01', '群成员地理分布测试：内蒙古', 1, '成都信息工程大学');
INSERT INTO `User` VALUES (21, 'dummy10', '12345678', 'Dummy-10', 1, 'profile.jpg', '1998-01-01', '群成员地理分布测试：台湾', 1, '成都信息工程大学');

-- ----------------------------
-- Table structure for UserTag
-- ----------------------------
DROP TABLE IF EXISTS `UserTag`;
CREATE TABLE `UserTag`  (
  `user_id` int NOT NULL,
  `tag_id` int NOT NULL,
  PRIMARY KEY (`user_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of UserTag
-- ----------------------------
INSERT INTO `UserTag` VALUES (1, 3);
INSERT INTO `UserTag` VALUES (1, 4);
INSERT INTO `UserTag` VALUES (1, 5);
INSERT INTO `UserTag` VALUES (1, 6);
INSERT INTO `UserTag` VALUES (1, 7);
INSERT INTO `UserTag` VALUES (1, 8);
INSERT INTO `UserTag` VALUES (1, 9);
INSERT INTO `UserTag` VALUES (1, 10);
INSERT INTO `UserTag` VALUES (1, 11);
INSERT INTO `UserTag` VALUES (1, 12);
INSERT INTO `UserTag` VALUES (1, 13);
INSERT INTO `UserTag` VALUES (1, 14);
INSERT INTO `UserTag` VALUES (12, 22);
INSERT INTO `UserTag` VALUES (12, 23);
INSERT INTO `UserTag` VALUES (12, 25);
INSERT INTO `UserTag` VALUES (12, 26);
INSERT INTO `UserTag` VALUES (12, 29);
INSERT INTO `UserTag` VALUES (12, 41);
INSERT INTO `UserTag` VALUES (13, 6);
INSERT INTO `UserTag` VALUES (13, 7);
INSERT INTO `UserTag` VALUES (13, 8);
INSERT INTO `UserTag` VALUES (13, 9);
INSERT INTO `UserTag` VALUES (13, 10);
INSERT INTO `UserTag` VALUES (13, 11);
INSERT INTO `UserTag` VALUES (13, 12);
INSERT INTO `UserTag` VALUES (13, 13);
INSERT INTO `UserTag` VALUES (13, 14);
INSERT INTO `UserTag` VALUES (13, 15);
INSERT INTO `UserTag` VALUES (14, 10);
INSERT INTO `UserTag` VALUES (14, 11);
INSERT INTO `UserTag` VALUES (14, 12);
INSERT INTO `UserTag` VALUES (14, 13);
INSERT INTO `UserTag` VALUES (14, 14);
INSERT INTO `UserTag` VALUES (14, 15);
INSERT INTO `UserTag` VALUES (14, 16);
INSERT INTO `UserTag` VALUES (14, 17);
INSERT INTO `UserTag` VALUES (14, 18);
INSERT INTO `UserTag` VALUES (14, 19);
INSERT INTO `UserTag` VALUES (15, 10);
INSERT INTO `UserTag` VALUES (15, 11);
INSERT INTO `UserTag` VALUES (15, 12);
INSERT INTO `UserTag` VALUES (15, 13);
INSERT INTO `UserTag` VALUES (15, 14);
INSERT INTO `UserTag` VALUES (15, 15);
INSERT INTO `UserTag` VALUES (15, 16);
INSERT INTO `UserTag` VALUES (15, 17);
INSERT INTO `UserTag` VALUES (15, 18);
INSERT INTO `UserTag` VALUES (15, 19);
INSERT INTO `UserTag` VALUES (16, 10);
INSERT INTO `UserTag` VALUES (16, 16);
INSERT INTO `UserTag` VALUES (16, 17);
INSERT INTO `UserTag` VALUES (16, 18);
INSERT INTO `UserTag` VALUES (16, 19);
INSERT INTO `UserTag` VALUES (16, 21);
INSERT INTO `UserTag` VALUES (16, 22);
INSERT INTO `UserTag` VALUES (16, 23);
INSERT INTO `UserTag` VALUES (16, 24);
INSERT INTO `UserTag` VALUES (16, 25);

-- ----------------------------
-- Table structure for user_tb
-- ----------------------------
DROP TABLE IF EXISTS `user_tb`;
CREATE TABLE `user_tb`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `profile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'profile.jpg',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` int NOT NULL DEFAULT 0,
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '普通用户',
  `birthday` date NULL DEFAULT '2021-01-06',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_tb
-- ----------------------------
INSERT INTO `user_tb` VALUES (1, '1', '1', '1', '1d6c72ba-9bfe-4e11-ae8c-1d91479611de.jpg', '1', '成信大小飞侠', 1, '0', '2021-01-06');
INSERT INTO `user_tb` VALUES (2, '123456789', '123456789', 'ame@87639998', 'profile.jpg', '1', '有趣的灵魂万里挑，开个玩笑', 1, 'tag', '2025-03-27');
INSERT INTO `user_tb` VALUES (3, 'username1', '2', 'ame1@87983208', 'profile.jpg', '1', '成信大大野猫', 0, '0', '2021-05-20');
INSERT INTO `user_tb` VALUES (4, '741852963', '741852963', '74185@65830324', 'profile.jpg', '0', '成信大大野猫', 0, '0', '2021-05-20');
INSERT INTO `user_tb` VALUES (9, '1234567890', '1234123123', '12345@66759944', 'profile.jpg', '1', '成信大大野猫', 0, '0', '2021-05-03');
INSERT INTO `user_tb` VALUES (10, '794613258', '794613258', '79461@71642981', 'profile.jpg', '0', NULL, 0, '普通用户', NULL);
INSERT INTO `user_tb` VALUES (11, '987654321', '987654321', '98765@72002195', 'profile.jpg', '0', NULL, 0, '普通用户', NULL);
INSERT INTO `user_tb` VALUES (12, '66666666', '66666666', '66666@72266538', 'profile.jpg', '0', NULL, 0, '普通用户', NULL);
INSERT INTO `user_tb` VALUES (13, '88888888', '88888888', '88888@72461731', 'profile.jpg', '0', NULL, 0, '普通用户', NULL);
INSERT INTO `user_tb` VALUES (14, '99999999', '99999999', '99999@72703591', 'profile.jpg', '0', NULL, 0, '普通用户', NULL);
INSERT INTO `user_tb` VALUES (15, '33333333', '33333333', '33333@72757848', 'profile.jpg', '0', NULL, 0, '普通用户', NULL);
INSERT INTO `user_tb` VALUES (16, '11111111', '11111111', '11111@72839990', '123.jpg', '0', NULL, 0, '普通用户', NULL);
INSERT INTO `user_tb` VALUES (17, '12313232231321', '32131313', '12313@37443867', 'profile.jpg', '0', NULL, 0, '普通用户', '2021-01-06');
INSERT INTO `user_tb` VALUES (18, '123456789123', '123456789123', '12345@55349503', 'profile.jpg', '0', NULL, 0, '普通用户', '2021-01-06');

SET FOREIGN_KEY_CHECKS = 1;
