/*
 Navicat Premium Data Transfer

 Source Server         : 工程实践
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 120.79.147.29:3306
 Source Schema         : fvs

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 17/06/2019 22:27:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advertising
-- ----------------------------
DROP TABLE IF EXISTS `advertising`;
CREATE TABLE `advertising`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adSrc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告视频来源',
  `length` int(11) NULL DEFAULT NULL COMMENT '广告时长',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告基本信息',
  `validTime` datetime(0) NOT NULL COMMENT '广告有效期',
  `del` int(1) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `video_id`(`length`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advertising
-- ----------------------------
INSERT INTO `advertising` VALUES (1, '/D/aa', 2, '123', '2019-06-05 20:06:46', 2);
INSERT INTO `advertising` VALUES (2, 'D/aa', 2, '33', '2019-06-22 20:24:31', 1);
INSERT INTO `advertising` VALUES (3, '/D', 12, '基本信息', '2019-06-09 00:00:00', 1);

-- ----------------------------
-- Table structure for banned
-- ----------------------------
DROP TABLE IF EXISTS `banned`;
CREATE TABLE `banned`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `startTime` datetime(0) NULL DEFAULT NULL COMMENT '默认当前时间',
  `endTime` datetime(0) NULL DEFAULT NULL COMMENT '禁言结束时间',
  `days` int(11) NULL DEFAULT NULL COMMENT '禁言天数',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '禁言原因',
  `del` int(1) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userID`(`userId`) USING BTREE,
  CONSTRAINT `userID` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banned
-- ----------------------------
INSERT INTO `banned` VALUES (1, 10, '2019-06-04 15:14:15', '2019-06-12 15:14:18', 8, '不良发展', 1);

-- ----------------------------
-- Table structure for bulletscreen
-- ----------------------------
DROP TABLE IF EXISTS `bulletscreen`;
CREATE TABLE `bulletscreen`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色代码',
  `position` int(1) NULL DEFAULT NULL COMMENT '1.滚动 2.顶部 3.底部',
  `size` int(1) NULL DEFAULT NULL COMMENT '1.正常大小 2. 小',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bulletTime` datetime(0) NULL DEFAULT NULL COMMENT '默认当前时间',
  `videoId` int(11) NULL DEFAULT NULL,
  `del` int(1) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  `type` int(1) NULL DEFAULT NULL COMMENT '弹幕所属视频类型，1.普通视频 2.番剧',
  `time` int(255) NULL DEFAULT NULL COMMENT '弹幕出现的时间，视频播放的时刻 单位秒',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `video_id2`(`videoId`) USING BTREE,
  CONSTRAINT `video_id2` FOREIGN KEY (`videoId`) REFERENCES `video` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bulletscreen
-- ----------------------------
INSERT INTO `bulletscreen` VALUES (3, 'green', 1, 1, 'test弹幕', '2019-05-25 18:41:04', 1, 1, 1, 2);
INSERT INTO `bulletscreen` VALUES (15, 'green', 1, 1, '弹幕内容', NULL, 1, 1, 1, 2);
INSERT INTO `bulletscreen` VALUES (20, '#ffffff', 1, 1, '123', NULL, 1, 1, 1, 53);
INSERT INTO `bulletscreen` VALUES (21, '#7a327a', 1, 1, '13123', NULL, 1, 1, 1, 88);
INSERT INTO `bulletscreen` VALUES (22, '#ffffff', 1, 1, '123213123', NULL, 1, 1, 1, 232);
INSERT INTO `bulletscreen` VALUES (23, '#ffffff', 3, 1, 'awsl', NULL, 1, 1, 1, 210);
INSERT INTO `bulletscreen` VALUES (24, '#f51426', 1, 1, 'awsl', NULL, 1, 1, 1, 366);
INSERT INTO `bulletscreen` VALUES (25, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 463);
INSERT INTO `bulletscreen` VALUES (26, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 463);
INSERT INTO `bulletscreen` VALUES (27, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 463);
INSERT INTO `bulletscreen` VALUES (28, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (29, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (30, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (31, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (32, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (33, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (34, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (35, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (36, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (37, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (38, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (39, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (40, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (41, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (42, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (43, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (44, '#f51426', 2, 1, 'awsl', NULL, 1, 1, 1, 3);
INSERT INTO `bulletscreen` VALUES (45, '#ffffff', 1, 1, 'fasddsaf', NULL, 1, 1, 1, 84);
INSERT INTO `bulletscreen` VALUES (46, '#ffffff', 1, 1, 'dasfasdf ', NULL, 1, 1, 1, 222);
INSERT INTO `bulletscreen` VALUES (47, '#ffffff', 1, 1, '高凤飞飞', NULL, 1, 1, 1, 69);
INSERT INTO `bulletscreen` VALUES (48, '#ffffff', 1, 1, '非人防', NULL, 1, 1, 1, 1390);
INSERT INTO `bulletscreen` VALUES (49, '#ffffff', 1, 1, '我是陈才行', NULL, 1, 1, 1, 133);
INSERT INTO `bulletscreen` VALUES (50, '#ffffff', 1, 1, '我是陈', NULL, 1, 1, 1, 80);
INSERT INTO `bulletscreen` VALUES (51, '#ffffff', 1, 1, '士大夫', NULL, 1, 1, 1, 858);
INSERT INTO `bulletscreen` VALUES (52, '#ffffff', 1, 1, 'sstsd', NULL, 1, 1, 1, 53);

-- ----------------------------
-- Table structure for chatmessage
-- ----------------------------
DROP TABLE IF EXISTS `chatmessage`;
CREATE TABLE `chatmessage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mesId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统自动生成，一份聊天就一个标识',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sendTime` datetime(0) NULL DEFAULT NULL COMMENT '默认当前时间',
  `receiveId` int(11) NULL DEFAULT NULL,
  `sendId` int(11) NULL DEFAULT NULL,
  `del` int(1) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  `sendChatStatus` int(1) NULL DEFAULT NULL COMMENT '发送者聊天框的状态，是已关闭还是未关闭 1 未关闭 2 已关闭',
  `receiveChatStatus` int(1) NULL DEFAULT NULL COMMENT '接收者聊天框的状态，是已关闭还是未关闭 1 未关闭 2 已关闭',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `receive_id`(`receiveId`) USING BTREE,
  INDEX `send_id`(`sendId`) USING BTREE,
  CONSTRAINT `receive_id` FOREIGN KEY (`receiveId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `send_id` FOREIGN KEY (`sendId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chatmessage
-- ----------------------------
INSERT INTO `chatmessage` VALUES (9, '3_1', 'test', '2019-06-02 17:29:35', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (10, '3_1', 'test', '2019-06-02 17:30:26', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (11, '3_1', '1111', '2019-06-02 19:18:35', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (12, '3_1', '123', '2019-06-02 19:22:00', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (13, '3_1', '123123', '2019-06-02 19:22:55', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (14, '1_3', '123123123', '2019-06-02 19:23:30', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (15, '1_3', '特色图', '2019-06-02 19:28:18', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (16, '3_1', '特色图   色弱所', '2019-06-02 19:36:06', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (17, '3_1', '124231', '2019-06-02 19:39:18', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (18, '1_3', '123213', '2019-06-02 19:39:44', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (19, '4_1', '1232131231231', '2019-06-03 12:34:53', 1, 4, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (20, '4_1', '正常的\n', '2019-06-03 12:35:42', 1, 4, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (21, '1_3', '这是一个很长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长的消息', '2019-06-03 20:35:30', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (22, '1_3', '这是一个很长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长的消息', '2019-06-03 20:40:02', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (23, '1_3', '12213123', '2019-06-03 20:48:23', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (24, '1_3', '45678999', '2019-06-03 20:49:13', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (25, '1_3', '53453453', '2019-06-03 20:49:56', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (26, '1_3', '566565', '2019-06-03 20:51:43', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (27, '1_3', '1232131231231231', '2019-06-03 20:52:30', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (28, '1_3', '24578387', '2019-06-03 20:53:25', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (29, '1_3', '12312313', '2019-06-03 21:08:13', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (30, '1_3', '测试', '2019-06-03 21:09:23', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (31, '1_3', '再测试', '2019-06-03 21:10:41', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (32, '1_3', '123', '2019-06-03 21:12:36', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (33, '1_3', '123', '2019-06-03 21:14:15', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (34, '1_3', '123123', '2019-06-03 21:15:34', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (35, '1_3', '123123', '2019-06-03 21:16:42', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (36, '1_3', '213123', '2019-06-03 21:22:54', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (37, '1_3', '123123', '2019-06-03 21:25:13', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (38, '1_3', '12312312', '2019-06-03 22:00:12', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (39, '1_3', '1212121', '2019-06-03 22:50:54', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (40, '1_3', 'newUser发消息', '2019-06-03 23:55:49', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (41, '1_3', 'newUser又发消息', '2019-06-03 23:58:14', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (42, '1_3', '又来了', '2019-06-04 00:04:37', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (43, '3_1', '我自己回一个', '2019-06-04 00:04:52', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (44, '1_3', '发给12的信息', '2019-06-04 00:05:42', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (45, '3_1', '发给newUser的信息', '2019-06-04 00:05:58', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (46, '4_1', '发给newUser', '2019-06-04 10:34:01', 1, 4, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (47, '1_3', '发给12的消息', '2019-06-04 12:35:38', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (48, '1_4', '发给id为4的', '2019-06-04 14:09:28', 4, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (49, '4_1', '发给id为1的', '2019-06-04 14:09:40', 1, 4, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (50, '3_1', 'id为3的发给id为1的', '2019-06-04 14:09:59', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (51, '3_1', 'id为3的发给id为1的2', '2019-06-04 14:16:16', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (52, '1_3', 'id为1的发给id为3的', '2019-06-04 14:25:22', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (53, '1_4', '发给test的', '2019-06-04 14:42:44', 4, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (54, '4_1', '发给newUser的', '2019-06-04 14:43:05', 1, 4, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (55, '4_1', '胜多负少大', '2019-06-04 14:48:41', 1, 4, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (56, '3_1', '132123', '2019-06-04 14:52:02', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (57, '3_1', '213132', '2019-06-04 14:52:09', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (58, '3_1', '13123', '2019-06-04 14:53:24', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (59, '3_1', '123123', '2019-06-04 14:53:26', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (60, '3_1', '123123', '2019-06-04 14:53:28', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (61, '3_1', '123123', '2019-06-04 14:54:49', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (62, '3_1', '12231', '2019-06-04 14:58:38', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (63, '3_1', '123123', '2019-06-04 14:58:49', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (64, '3_1', '12213123', '2019-06-04 14:59:49', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (65, '3_1', '123123123', '2019-06-04 15:00:58', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (66, '3_1', '123123', '2019-06-04 15:01:05', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (67, '3_1', '123123', '2019-06-04 15:04:10', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (68, '3_1', '123123', '2019-06-04 15:04:12', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (69, '3_1', '123123', '2019-06-04 15:04:23', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (70, '1_3', 'stop', '2019-06-04 15:08:31', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (71, '1_3', '发电', '2019-06-04 15:11:30', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (72, '1_12', '终于test', '2019-06-04 15:58:37', 12, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (73, '1_3', '用爱发电', '2019-06-04 17:16:12', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (74, '1_3', '框框', '2019-06-04 17:17:28', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (75, '1_3', '别人的', '2019-06-04 17:17:36', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (76, '3_1', '阿士大夫撒', '2019-06-04 17:18:21', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (77, '1_4', 'fasong', '2019-06-04 18:03:47', 4, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (78, '1_30', 'geinifaxiaoxi l ', '2019-06-04 18:07:15', 30, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (79, '1_30', '头像咋一样呢', '2019-06-04 18:07:23', 30, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (80, '1_30', '你的也是一样的', '2019-06-04 18:07:34', 30, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (81, '1_30', '怎么改啊', '2019-06-04 18:07:40', 30, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (82, '3_30', '给你发消息了', '2019-06-04 18:09:25', 30, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (83, '1_3', '沙发撒地方', '2019-06-04 18:11:07', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (84, '30_3', '发个球', '2019-06-04 18:54:02', 3, 30, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (85, '3_1', '55', '2019-06-08 23:23:25', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (86, '3_1', '123123123', '2019-06-10 14:13:01', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (87, '1_3', '2222', '2019-06-10 14:14:25', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (88, '3_1', '1111', '2019-06-10 14:14:30', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (89, '3_1', '666', '2019-06-11 10:38:18', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (90, '3_1', '发送消息测试', '2019-06-12 12:28:49', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (91, '1_3', 'hello', '2019-06-12 16:25:34', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (92, '1_3', '在吗美女', '2019-06-12 16:26:03', 3, 1, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (93, '3_1', '滚滚滚', '2019-06-12 17:52:38', 1, 3, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (94, '30_3', '发消息', '2019-06-17 14:37:47', 3, 30, 1, 1, 1);
INSERT INTO `chatmessage` VALUES (95, '3_30', 'test', '2019-06-17 14:54:11', 30, 3, 1, 1, 1);

-- ----------------------------
-- Table structure for collectvideo
-- ----------------------------
DROP TABLE IF EXISTS `collectvideo`;
CREATE TABLE `collectvideo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `typeId` int(11) NOT NULL,
  `collectUserid` int(11) NOT NULL,
  `collectTime` datetime(0) NULL DEFAULT NULL,
  `vv` int(255) NULL DEFAULT NULL,
  `videoSrc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `simpleIntroduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `firstImagePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `collectUserid`(`collectUserid`) USING BTREE,
  CONSTRAINT `collectUserid` FOREIGN KEY (`collectUserid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collectvideo
-- ----------------------------
INSERT INTO `collectvideo` VALUES (4, '叽叽叽叽叽叽叽叽寂静', 1, 1, '2019-06-11 22:20:57', 11, '/test/test.mp4', '111111111', '/static/resources/image/7.png');
INSERT INTO `collectvideo` VALUES (5, '三只小猪', 1, 1, '2019-06-01 22:40:36', 25, '/test/test.mp4', '小猪好好看啊', '/static/resources/image/7.png');
INSERT INTO `collectvideo` VALUES (6, '阿萨苏打水发到付的法国队', 2, 1, '2019-06-05 22:21:32', 213123, '/test/test.mp4', '违法的共和国和', '/static/resources/image/7.png');

-- ----------------------------
-- Table structure for commentreply
-- ----------------------------
DROP TABLE IF EXISTS `commentreply`;
CREATE TABLE `commentreply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `replyTime` datetime(0) NULL DEFAULT NULL COMMENT '默认当前时间',
  `replyId` int(11) NULL DEFAULT NULL,
  `beReplyId` int(11) NULL DEFAULT NULL,
  `commentId` int(11) NULL DEFAULT NULL,
  `del` int(1) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  `myContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '针对哪个内容进行的回复',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `reply_id`(`replyId`) USING BTREE,
  INDEX `be_reply_id`(`beReplyId`) USING BTREE,
  INDEX `comment_id`(`commentId`) USING BTREE,
  CONSTRAINT `be_reply_id` FOREIGN KEY (`beReplyId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_id` FOREIGN KEY (`commentId`) REFERENCES `videocomment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `reply_id` FOREIGN KEY (`replyId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commentreply
-- ----------------------------
INSERT INTO `commentreply` VALUES (12, '442552', '2019-05-25 14:42:25', 1, 3, 1, 2, 'awsl');
INSERT INTO `commentreply` VALUES (13, 'test', '2019-05-25 15:29:28', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (15, 'test中文', '2019-05-25 15:32:45', 1, 3, 2, 1, 'awsl');
INSERT INTO `commentreply` VALUES (16, 'test中文', '2019-05-25 15:32:45', 1, 3, 2, 1, 'awsl');
INSERT INTO `commentreply` VALUES (17, 'test中文', '2019-05-25 15:32:45', 1, 3, 2, 1, 'awsl');
INSERT INTO `commentreply` VALUES (18, 'test中文', '2019-05-25 15:32:45', 1, 3, 2, 1, 'awsl');
INSERT INTO `commentreply` VALUES (19, 'test中文', '2019-05-25 15:32:45', 1, 3, 2, 1, 'awsl');
INSERT INTO `commentreply` VALUES (20, 'test中文', '2019-05-25 15:32:45', 1, 3, 2, 1, 'awsl');
INSERT INTO `commentreply` VALUES (21, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (22, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (23, 'test中文', '2019-05-25 15:32:45', 1, 3, 3, 1, 'awsl');
INSERT INTO `commentreply` VALUES (24, 'test中文', '2019-05-25 15:32:45', 1, 3, 3, 1, 'awsl');
INSERT INTO `commentreply` VALUES (25, 'test中文', '2019-05-25 15:32:45', 1, 3, 3, 1, 'awsl');
INSERT INTO `commentreply` VALUES (26, 'test中文', '2019-05-25 15:32:45', 1, 3, 3, 1, 'awsl');
INSERT INTO `commentreply` VALUES (27, 'test中文', '2019-05-25 15:32:45', 1, 3, 3, 1, 'awsl');
INSERT INTO `commentreply` VALUES (28, 'test中文', '2019-05-25 15:32:45', 1, 3, 3, 1, 'awsl');
INSERT INTO `commentreply` VALUES (29, 'test中文', '2019-05-25 15:32:45', 1, 3, 3, 1, 'awsl');
INSERT INTO `commentreply` VALUES (30, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (31, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (32, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (33, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (34, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (35, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (36, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (37, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (38, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (39, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (40, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (41, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (42, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (43, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (44, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (45, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (46, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (47, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (48, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (49, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (50, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (51, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (52, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (53, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (54, 'test中文', '2019-05-25 15:32:45', 1, 3, 1, 1, 'awsl');
INSERT INTO `commentreply` VALUES (55, 'asd', '2019-06-10 16:23:16', 3, 12, 2, 1, 'testcontent');
INSERT INTO `commentreply` VALUES (56, 'asd', '2019-06-10 16:26:20', 3, 1, 1, 1, 'testcontent');
INSERT INTO `commentreply` VALUES (57, '暗示的覅哦哦if还打算盘', '2019-06-10 16:37:20', 3, 12, 2, 1, 'testcontent');
INSERT INTO `commentreply` VALUES (58, '回复neweruser的', '2019-06-10 16:53:10', 3, 1, 1, 1, 'testcontent');
INSERT INTO `commentreply` VALUES (59, '123sda', '2019-06-11 10:27:54', 3, 3, 11, 1, 'fasdfsadfsadf');
INSERT INTO `commentreply` VALUES (60, '第二次测试', '2019-06-12 20:34:42', 3, 1, 1, 1, '第一条评论');
INSERT INTO `commentreply` VALUES (61, '回复12的', '2019-06-12 20:36:01', 3, 3, 1, 1, '第二次测试');
INSERT INTO `commentreply` VALUES (62, '又来测试', '2019-06-12 20:36:52', 3, 1, 1, 1, '第一条评论');
INSERT INTO `commentreply` VALUES (63, '那是真的好   ', '2019-06-14 19:42:28', NULL, 10, 7, 1, '答辩完了真好');
INSERT INTO `commentreply` VALUES (64, '那是真的好   ', '2019-06-14 19:42:33', NULL, 10, 7, 1, '答辩完了真好');
INSERT INTO `commentreply` VALUES (65, 'testsaetaste', '2019-06-17 14:56:46', 3, 1, 1, 1, '第一条评论');

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL,
  `fansId` int(11) NULL DEFAULT NULL,
  `del` int(1) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fans_id`(`fansId`) USING BTREE,
  INDEX `user_id1`(`userId`) USING BTREE,
  CONSTRAINT `fans_id` FOREIGN KEY (`fansId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of focus
-- ----------------------------
INSERT INTO `focus` VALUES (1, 1, 11, 1);
INSERT INTO `focus` VALUES (2, 1, 3, 2);
INSERT INTO `focus` VALUES (3, 1, 10, 1);
INSERT INTO `focus` VALUES (4, 1, 23, 1);
INSERT INTO `focus` VALUES (5, 1, 32, 1);
INSERT INTO `focus` VALUES (6, 1, 2, 2);
INSERT INTO `focus` VALUES (7, 1, 21, 1);
INSERT INTO `focus` VALUES (8, 2, 3, 2);
INSERT INTO `focus` VALUES (9, 3, 2, 1);
INSERT INTO `focus` VALUES (10, 10, 3, 1);
INSERT INTO `focus` VALUES (11, 21, 23, 2);
INSERT INTO `focus` VALUES (12, 13, 1, 2);
INSERT INTO `focus` VALUES (13, 31, 1, 2);
INSERT INTO `focus` VALUES (14, 21, 1, 2);
INSERT INTO `focus` VALUES (15, 31, 4, 1);
INSERT INTO `focus` VALUES (16, 1, 1, 2);
INSERT INTO `focus` VALUES (18, 11, 1, 2);
INSERT INTO `focus` VALUES (19, 3, 1, 2);
INSERT INTO `focus` VALUES (20, 10, 1, 2);
INSERT INTO `focus` VALUES (21, 11, 1, 2);
INSERT INTO `focus` VALUES (22, 3, 1, 2);
INSERT INTO `focus` VALUES (23, 10, 1, 2);
INSERT INTO `focus` VALUES (24, 32, 1, 2);
INSERT INTO `focus` VALUES (25, 23, 1, 2);
INSERT INTO `focus` VALUES (26, 21, 1, 2);
INSERT INTO `focus` VALUES (27, 11, 1, 2);
INSERT INTO `focus` VALUES (28, 3, 1, 2);
INSERT INTO `focus` VALUES (29, 10, 1, 2);
INSERT INTO `focus` VALUES (30, 23, 1, 2);
INSERT INTO `focus` VALUES (31, 11, 1, 2);
INSERT INTO `focus` VALUES (32, 3, 1, 2);
INSERT INTO `focus` VALUES (33, 10, 1, 2);
INSERT INTO `focus` VALUES (34, 11, 1, 2);
INSERT INTO `focus` VALUES (35, 3, 1, 2);
INSERT INTO `focus` VALUES (36, 10, 1, 2);
INSERT INTO `focus` VALUES (37, 23, 1, 2);
INSERT INTO `focus` VALUES (38, 32, 1, 2);
INSERT INTO `focus` VALUES (39, 11, 1, 2);
INSERT INTO `focus` VALUES (40, 3, 1, 2);
INSERT INTO `focus` VALUES (41, 10, 1, 2);
INSERT INTO `focus` VALUES (42, 23, 1, 2);
INSERT INTO `focus` VALUES (43, 21, 1, 1);
INSERT INTO `focus` VALUES (44, 3, NULL, 1);
INSERT INTO `focus` VALUES (45, 11, 1, 1);
INSERT INTO `focus` VALUES (46, 3, 1, 1);
INSERT INTO `focus` VALUES (47, 10, 1, 1);
INSERT INTO `focus` VALUES (48, 1, 3, 2);
INSERT INTO `focus` VALUES (49, 1, 3, 2);
INSERT INTO `focus` VALUES (50, 1, 1, 1);
INSERT INTO `focus` VALUES (51, 1, NULL, 1);
INSERT INTO `focus` VALUES (52, 1, 3, 2);
INSERT INTO `focus` VALUES (53, 2, 3, 1);

-- ----------------------------
-- Table structure for hisplay
-- ----------------------------
DROP TABLE IF EXISTS `hisplay`;
CREATE TABLE `hisplay`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '番剧名称',
  `playNumber` int(11) NULL DEFAULT NULL COMMENT '番剧总共播放量',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `status` int(1) NOT NULL COMMENT '1.更新中2.已下架3.已完结',
  `del` int(11) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hisplay
-- ----------------------------
INSERT INTO `hisplay` VALUES (1, '刀剑神域', 0, '没有', 1, 1, '2019-06-06 23:34:26');
INSERT INTO `hisplay` VALUES (2, '雷神', 0, '0', 1, 1, '2019-06-04 23:34:32');
INSERT INTO `hisplay` VALUES (3, '命运之门', 0, '0', 1, 1, '2019-06-01 23:34:35');
INSERT INTO `hisplay` VALUES (4, '领域', 0, '没有', 1, 1, '2019-06-08 00:00:00');
INSERT INTO `hisplay` VALUES (5, '花下', 20, '没有', 1, 1, '2019-06-08 00:00:00');
INSERT INTO `hisplay` VALUES (6, '紫罗兰的永恒花园', 0, '0', 1, 1, '2019-06-10 12:22:23');
INSERT INTO `hisplay` VALUES (7, '红小豆', 0, '0', 1, 1, '2019-06-29 12:22:43');
INSERT INTO `hisplay` VALUES (8, '从前有座灵剑山', 0, '0', 1, 1, '2019-06-29 12:23:09');
INSERT INTO `hisplay` VALUES (9, '你的名字', 0, '0', 1, 1, '2019-06-28 12:23:27');

-- ----------------------------
-- Table structure for systemmessage
-- ----------------------------
DROP TABLE IF EXISTS `systemmessage`;
CREATE TABLE `systemmessage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sendType` tinyint(1) NULL DEFAULT 2 COMMENT '1.单发2.群发（默认）',
  `sendTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '默认当前时间',
  `receiveId` int(11) NULL DEFAULT NULL COMMENT '0，群发  单发 userId',
  `del` tinyint(1) NULL DEFAULT 1 COMMENT '1 未删除，2 已删除',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统通知题目',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of systemmessage
-- ----------------------------
INSERT INTO `systemmessage` VALUES (1, '“BILIBILI POWER UP 2018”今日登陆深圳卫视！下午13：30分，锁定深圳卫视，在电视上看你喜爱的UP主。', 1, '2019-05-23 22:47:23', NULL, 2, 'c站建成了');
INSERT INTO `systemmessage` VALUES (2, '“BILIBILI POWER UP 2018”今日登陆深圳卫视！下午13：30分，锁定深圳卫视，在电视上看你喜爱的UP主。', 2, '2019-05-23 22:48:10', 4, 2, 'c站建成了');
INSERT INTO `systemmessage` VALUES (3, '“BILIBILI POWER UP 2018”今日登陆深圳卫视！下午13：30分，锁定深圳卫视，在电视上看你喜爱的UP主。', 1, '2019-05-23 23:06:45', NULL, 2, 'c站建成了');
INSERT INTO `systemmessage` VALUES (4, '“BILIBILI POWER UP 2018”今日登陆深圳卫视！下午13：30分，锁定深圳卫视，在电视上看你喜爱的UP主。', 1, '2019-05-23 23:06:57', NULL, 2, 'c站建成了');
INSERT INTO `systemmessage` VALUES (5, '“BILIBILI POWER UP 2018”今日登陆深圳卫视！下午13：30分，锁定深圳卫视，在电视上看你喜爱的UP主。', 1, '2019-05-23 23:07:06', NULL, 2, 'c站建成了');
INSERT INTO `systemmessage` VALUES (6, '“BILIBILI POWER UP 2018”今日登陆深圳卫视！下午13：30分，锁定深圳卫视，在电视上看你喜爱的UP主。', 1, '2019-05-23 23:07:22', NULL, 2, 'c站建成了');
INSERT INTO `systemmessage` VALUES (7, '“BILIBILI POWER UP 2018”今日登陆深圳卫视！下午13：30分，锁定深圳卫视，在电视上看你喜爱的UP主', 1, '2019-05-08 23:17:27', NULL, 1, 'c站建成了');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类的名字',
  `del` int(1) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '动画', 1);
INSERT INTO `type` VALUES (2, '国创', 1);
INSERT INTO `type` VALUES (3, '音乐', 1);
INSERT INTO `type` VALUES (4, '舞蹈', 1);
INSERT INTO `type` VALUES (5, '游戏', 1);
INSERT INTO `type` VALUES (6, '科技', 1);
INSERT INTO `type` VALUES (7, '数码', 1);
INSERT INTO `type` VALUES (8, '生活', 1);
INSERT INTO `type` VALUES (9, '鬼畜', 1);
INSERT INTO `type` VALUES (10, '时尚', 1);
INSERT INTO `type` VALUES (11, '广告', 1);
INSERT INTO `type` VALUES (12, '娱乐', 1);
INSERT INTO `type` VALUES (13, '影视', 1);
INSERT INTO `type` VALUES (14, '放映厅', 1);
INSERT INTO `type` VALUES (15, '番剧', 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '默认头像路径',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '默认女',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '默认”这家伙很懒，什么都没留下“',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '当天日期',
  `roleId` int(11) NULL DEFAULT NULL COMMENT '默认为普通用户，2',
  `del` int(1) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'newUser', '123456', '/static/resources/image/2.png', NULL, '123123', '2019-05-16 10:49:30', 2, 1);
INSERT INTO `user` VALUES (2, '测试', '12', '/static/resources/image/2.png', '女', '测试用', '2019-05-01 15:59:28', 2, 2);
INSERT INTO `user` VALUES (3, '123123', '123123', '/static/resources/image/3.png', NULL, '12123123', '2019-05-31 10:49:34', 2, 1);
INSERT INTO `user` VALUES (4, '12123', '123445', '/static/resources/image/4.png', NULL, '啊啊啊啊啊啊啊啊', '2019-05-01 16:07:23', 2, 1);
INSERT INTO `user` VALUES (10, 'realme', '123456', '/static/resources/image/4.png', '男', '全面屏敢越级', '2019-06-08 16:15:27', 2, 1);
INSERT INTO `user` VALUES (11, 'test2', '111111', '/static/resources/image/5.png', '男', '这个家伙很懒快来关注我！！', '2019-05-23 16:44:32', 2, 1);
INSERT INTO `user` VALUES (12, 'test22', '123', '/static/resources/image/6.png', '男', '这个家伙很懒', '2019-05-23 22:12:45', 2, 1);
INSERT INTO `user` VALUES (13, 'test222', '1111', '/static/resources/image/7.png', '男', '这个家伙很懒快来关注我！！', '2019-05-23 22:19:04', 2, 1);
INSERT INTO `user` VALUES (21, 'test27', '1111', '/static/resources/image/8.png', '男', '这个家伙很懒', '2019-05-24 17:30:25', 2, 1);
INSERT INTO `user` VALUES (22, 'hejiang', '12346', '/static/resources/image/1.png', NULL, '快来关注我！！', '2019-06-04 18:58:30', 2, 1);
INSERT INTO `user` VALUES (23, 'zz', '12346', '/static/resources/image/1.png', NULL, '快来关注我！！', '2019-06-06 18:58:33', 2, 1);
INSERT INTO `user` VALUES (29, 'zjfei', '12346', '/static/resources/image/1.png', NULL, '快来关注我！！', '2019-05-27 18:58:36', 2, 1);
INSERT INTO `user` VALUES (30, 'icon', 'icon', '/static/resources/image/1.png', '男', '这个家伙很懒，什么都没有留下', '2019-06-04 17:41:26', 2, 1);
INSERT INTO `user` VALUES (31, 'xxxxx', '123456', '/static/resources/image/5.png', '男', '这个家伙很懒，什么都没有留下快来关注我！！', '2019-06-04 19:01:18', 2, 1);
INSERT INTO `user` VALUES (32, '1', '11', '/static/resources/image/1.png', '男', '这个家伙很懒，什么都没有留下', '2019-06-11 10:29:04', 2, 1);
INSERT INTO `user` VALUES (33, '111', '111', '/static/resources/image/2.png', '男', '这个家伙很懒，什么都没有留下', '2019-06-11 18:17:10', 2, 1);
INSERT INTO `user` VALUES (34, 'admin', 'admin', '/static/resources/image/2.png', NULL, NULL, '2019-06-12 20:57:40', 1, 1);
INSERT INTO `user` VALUES (35, '123', '123', '/static/resources/image/2.png', '男', '这个家伙很懒，什么都没有留下', '2019-06-12 22:12:09', 1, 1);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `typeId` int(11) NOT NULL COMMENT '分类的ID',
  `userId` int(11) NULL DEFAULT NULL,
  `upTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '默认当前时间',
  `vv` int(255) NULL DEFAULT NULL COMMENT '默认为0',
  `videoSrc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '默认为视频存放位置',
  `simpleIntroduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `collectNumber` int(11) NULL DEFAULT NULL COMMENT '视频说藏量，默认为0',
  `shareNumber` int(11) NULL DEFAULT NULL COMMENT '视频的分享数',
  `praiseNumber` int(11) NULL DEFAULT NULL COMMENT '视频的点赞数',
  `status` int(1) NULL DEFAULT NULL COMMENT '默认为未审核 1.审核中 2.审核通过 3.审核失败',
  `del` int(1) NULL DEFAULT NULL COMMENT '1 未删除，2 已删除',
  `firstImagePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频封面地址',
  `videoLength` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`userId`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, 'good个屁', 1, 1, '2019-06-17 15:23:27', 318, '/test/test.mp4', '小撒胡的覅撒花豆腐ID啥开发大厦会计法', 2, 0, 1, 2, 2, '/static/resources/image/1.png', NULL);
INSERT INTO `video` VALUES (2, 'jij', 2, 3, '2019-06-17 15:09:08', 200, '/test/test.mp4', 'niadsa', 0, 0, 0, 2, 2, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (3, 'tiander', 1, 3, '2019-06-17 15:09:12', 855, '/test/test.mp4', 'sd', 0, 0, 0, 2, 2, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (4, 'gouder', 1, 1, '2019-06-16 22:14:16', 200, '/test/test.mp4', 'happy', 0, 0, 0, 2, 1, '/static/resources/image/8.png', NULL);
INSERT INTO `video` VALUES (5, '两只小猪', 1, 1, '2019-06-17 13:06:34', 201, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/7.png', NULL);
INSERT INTO `video` VALUES (6, '两只xiaom', 1, 1, '2019-06-16 22:05:33', 200, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (7, 'xiaom1', 2, 1, '2019-06-15 01:01:11', 445, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/1.jpg', NULL);
INSERT INTO `video` VALUES (8, 'xiaom', 1, 1, '2019-06-17 15:22:46', 46, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (9, 'xiaom123', 1, 1, '2019-06-16 22:05:39', 566, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 3, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (10, 'xiaom12', 1, 1, '2019-06-16 22:05:39', 566, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 3, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (11, 'xiaom15', 1, 1, '2019-06-16 22:05:39', 566, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 3, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (12, 'xiaom13 ', 1, 1, '2019-06-16 22:05:39', 566, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 3, 2, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (13, 'jiajia是我的15', 1, 1, '2019-06-17 15:22:56', 566, '/test/test.mp4', '看信息', 0, 0, 0, 3, 2, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (14, 'xiaom', 1, 1, '2019-06-16 22:05:40', 566, '/test/test.mp4', '小猪好好看呀', 0, NULL, 0, 2, 2, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (15, '合15计', 1, 3, '2019-06-16 22:05:40', 566, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (16, 'xiaom2', 1, 3, '2019-06-16 22:05:40', 566, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 3, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (17, 'xiao551m2', 1, 3, '2019-06-17 14:33:09', 568, '/test/test.mp4', '小猪好好看呀', 0, NULL, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (18, '152', 1, 3, '2019-06-15 01:03:59', 443, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (19, 'xia11111om2', 1, 3, '2019-06-16 22:05:45', 88, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (20, '伞兵99一号', 1, 3, '2019-06-14 17:27:55', 577, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (21, 'xia221om2', 1, 4, '2019-06-16 22:05:59', 888, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 2, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (22, 'xiao111m2', 1, 4, '2019-06-16 22:05:59', 888, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (23, 'xia111om2', 1, 4, '2019-06-16 22:06:00', 888, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (24, 'xiaom2', 1, 4, '2019-06-16 23:33:31', 888, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (25, 'xiaom2', 1, 4, '2019-06-16 23:33:33', 888, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 3, 2, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (26, '4446', 1, 3, '2019-06-16 22:06:00', 888, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 1, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (27, '8321', 1, 4, '2019-06-13 14:11:56', 444, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 1, 1, '/static/resources/image/4.png', '35:05:14');
INSERT INTO `video` VALUES (28, '887', 1, 4, '2019-06-12 21:55:56', 8, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', '35:05:14');
INSERT INTO `video` VALUES (29, '989', 1, 4, '2019-06-13 14:11:46', 999, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 1, 1, '/static/resources/image/4.png', '35:05:14');
INSERT INTO `video` VALUES (30, '555', 1, 4, '2019-06-13 14:11:49', 888, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 1, 1, '/static/resources/image/4.png', '35:05:14');
INSERT INTO `video` VALUES (31, '444', 1, 4, '2019-06-16 20:54:44', 777, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 2, 1, '/static/resources/image/4.png', '35:05:14');
INSERT INTO `video` VALUES (32, '999', 1, 13, '2019-06-16 01:16:34', 8890, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', '35:05:14');
INSERT INTO `video` VALUES (33, '888', 1, 4, '2019-06-16 22:06:09', 1, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', '35:05:14');
INSERT INTO `video` VALUES (34, 'xiaom2', 1, 1, '2019-06-16 22:05:52', 893, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 1, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (35, 'xiaom2', 1, 22, '2019-06-16 22:05:52', 893, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 1, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (36, 'xiaom2', 1, 12, '2019-06-16 22:05:53', 893, '/test/test.mp4', '小猪好好看呀', NULL, NULL, NULL, 1, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (37, 'xiaom2', 1, 13, '2019-06-16 22:05:53', 893, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (38, 'xiaom2', 1, 12, '2019-06-16 22:05:53', 893, '/test/test.mp4', '小猪好好看呀', 0, 0, 0, 2, 1, '/static/resources/image/4.png', NULL);
INSERT INTO `video` VALUES (39, '1', 2, 1, '2019-06-15 01:02:03', 9999, '/test/test.mp4', '哈哈哈', 0, 0, 0, 2, 2, '/static/resources/image/4.png', NULL);

-- ----------------------------
-- Table structure for video_play_list
-- ----------------------------
DROP TABLE IF EXISTS `video_play_list`;
CREATE TABLE `video_play_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `video_id` int(11) NULL DEFAULT NULL COMMENT '视频id',
  `watch_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '视频观看的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 373 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_play_list
-- ----------------------------
INSERT INTO `video_play_list` VALUES (1, 2, '2019-06-14 17:09:30');
INSERT INTO `video_play_list` VALUES (2, 1, '2019-06-11 21:21:34');
INSERT INTO `video_play_list` VALUES (3, 2, '2019-06-14 21:23:39');
INSERT INTO `video_play_list` VALUES (4, 2, '2019-05-23 21:23:55');
INSERT INTO `video_play_list` VALUES (5, 2, '2019-06-20 21:27:52');
INSERT INTO `video_play_list` VALUES (6, 1, '2019-06-02 15:23:58');
INSERT INTO `video_play_list` VALUES (7, 3, '2019-06-02 16:05:20');
INSERT INTO `video_play_list` VALUES (8, 3, '2019-06-02 16:05:33');
INSERT INTO `video_play_list` VALUES (9, 4, '2019-06-13 16:05:37');
INSERT INTO `video_play_list` VALUES (10, 4, '2019-03-20 16:05:40');
INSERT INTO `video_play_list` VALUES (11, 2, '2019-04-17 16:05:43');
INSERT INTO `video_play_list` VALUES (12, 1, '2019-05-13 16:05:48');
INSERT INTO `video_play_list` VALUES (13, 1, '2019-06-12 20:11:41');
INSERT INTO `video_play_list` VALUES (14, 4, '2019-06-10 20:11:59');
INSERT INTO `video_play_list` VALUES (15, 4, '2019-06-12 00:00:33');
INSERT INTO `video_play_list` VALUES (16, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (17, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (18, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (19, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (20, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (21, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (22, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (23, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (24, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (25, 6, '2019-06-11 22:02:32');
INSERT INTO `video_play_list` VALUES (26, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (27, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (28, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (29, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (30, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (31, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (32, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (33, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (34, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (35, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (36, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (37, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (38, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (39, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (40, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (41, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (42, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (43, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (44, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (45, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (46, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (47, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (48, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (49, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (50, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (51, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (52, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (53, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (54, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (55, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (56, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (57, 18, '2019-06-12 22:02:32');
INSERT INTO `video_play_list` VALUES (58, 15, '2019-06-12 22:02:32');
INSERT INTO `video_play_list` VALUES (59, 1, '2019-06-11 22:02:32');
INSERT INTO `video_play_list` VALUES (60, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (61, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (62, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (63, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (64, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (65, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (66, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (67, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (68, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (69, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (70, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (71, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (72, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (73, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (74, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (75, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (76, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (77, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (78, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (79, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (80, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (81, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (82, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (83, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (84, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (85, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (86, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (87, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (88, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (89, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (90, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (91, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (92, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (93, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (94, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (95, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (96, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (97, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (98, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (99, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (100, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (101, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (102, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (103, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (104, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (105, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (106, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (107, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (108, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (109, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (110, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (111, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (112, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (113, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (114, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (115, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (116, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (117, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (118, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (119, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (120, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (121, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (122, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (123, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (124, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (125, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (126, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (127, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (128, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (129, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (130, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (131, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (132, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (133, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (134, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (135, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (136, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (137, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (138, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (139, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (140, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (141, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (142, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (143, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (144, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (145, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (146, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (147, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (148, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (149, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (150, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (151, 1, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (152, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (153, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (154, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (155, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (156, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (157, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (158, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (159, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (160, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (161, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (162, 8, '2019-06-14 22:02:32');
INSERT INTO `video_play_list` VALUES (163, 9, '2019-06-11 10:36:43');
INSERT INTO `video_play_list` VALUES (164, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (165, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (166, 10, '2019-06-13 10:36:12');
INSERT INTO `video_play_list` VALUES (167, 7, '2019-06-15 22:02:32');
INSERT INTO `video_play_list` VALUES (168, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (169, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (170, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (171, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (172, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (173, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (174, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (175, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (176, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (177, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (178, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (179, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (180, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (181, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (182, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (183, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (184, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (185, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (186, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (187, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (188, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (189, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (190, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (191, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (192, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (193, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (194, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (195, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (196, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (197, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (198, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (199, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (200, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (201, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (202, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (203, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (204, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (205, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (206, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (207, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (208, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (209, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (210, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (211, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (212, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (213, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (214, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (215, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (216, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (217, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (218, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (219, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (220, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (221, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (222, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (223, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (224, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (225, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (226, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (227, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (228, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (229, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (230, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (231, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (232, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (233, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (234, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (235, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (236, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (237, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (238, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (239, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (240, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (241, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (242, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (243, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (244, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (245, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (246, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (247, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (248, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (249, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (250, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (251, 3, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (252, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (253, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (254, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (255, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (256, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (257, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (258, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (259, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (260, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (261, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (262, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (263, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (264, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (265, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (266, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (267, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (268, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (269, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (270, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (271, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (272, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (273, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (274, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (275, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (276, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (277, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (278, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (279, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (280, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (281, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (282, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (283, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (284, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (285, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (286, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (287, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (288, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (289, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (290, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (291, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (292, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (293, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (294, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (295, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (296, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (297, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (298, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (299, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (300, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (301, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (302, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (303, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (304, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (305, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (306, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (307, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (308, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (309, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (310, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (311, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (312, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (313, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (314, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (315, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (316, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (317, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (318, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (319, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (320, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (321, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (322, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (323, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (324, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (325, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (326, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (327, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (328, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (329, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (330, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (331, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (332, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (333, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (334, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (335, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (336, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (337, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (338, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (339, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (340, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (341, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (342, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (343, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (344, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (345, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (346, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (347, 5, '2019-06-16 22:02:32');
INSERT INTO `video_play_list` VALUES (348, 5, '2019-06-14 22:02:32');
INSERT INTO `video_play_list` VALUES (349, 5, '2019-06-20 22:02:32');
INSERT INTO `video_play_list` VALUES (350, 5, '2019-06-20 22:02:32');
INSERT INTO `video_play_list` VALUES (351, 5, '2019-06-13 22:02:32');
INSERT INTO `video_play_list` VALUES (352, 1, '2019-06-16 22:25:41');
INSERT INTO `video_play_list` VALUES (353, 1, '2019-06-16 22:25:58');
INSERT INTO `video_play_list` VALUES (354, 1, '2019-06-16 23:46:13');
INSERT INTO `video_play_list` VALUES (355, 1, '2019-06-16 23:46:18');
INSERT INTO `video_play_list` VALUES (356, 1, '2019-06-16 23:47:01');
INSERT INTO `video_play_list` VALUES (357, 1, '2019-06-16 23:49:29');
INSERT INTO `video_play_list` VALUES (358, 23, '2019-06-13 23:50:08');
INSERT INTO `video_play_list` VALUES (359, 24, '2019-06-12 10:38:38');
INSERT INTO `video_play_list` VALUES (360, 5, '2019-06-17 13:06:34');
INSERT INTO `video_play_list` VALUES (361, 1, '2019-06-17 13:06:40');
INSERT INTO `video_play_list` VALUES (362, 17, '2019-06-17 14:31:33');
INSERT INTO `video_play_list` VALUES (363, 1, '2019-06-17 14:32:29');
INSERT INTO `video_play_list` VALUES (364, 1, '2019-06-17 14:32:44');
INSERT INTO `video_play_list` VALUES (365, 1, '2019-06-17 14:33:04');
INSERT INTO `video_play_list` VALUES (366, 17, '2019-06-17 14:33:09');
INSERT INTO `video_play_list` VALUES (367, 1, '2019-06-17 14:34:20');
INSERT INTO `video_play_list` VALUES (368, 1, '2019-06-17 14:34:32');
INSERT INTO `video_play_list` VALUES (369, 1, '2019-06-17 14:34:53');
INSERT INTO `video_play_list` VALUES (370, 1, '2019-06-17 14:38:05');
INSERT INTO `video_play_list` VALUES (371, 1, '2019-06-17 14:44:53');
INSERT INTO `video_play_list` VALUES (372, 1, '2019-06-17 14:45:25');

-- ----------------------------
-- Table structure for videocomment
-- ----------------------------
DROP TABLE IF EXISTS `videocomment`;
CREATE TABLE `videocomment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` datetime(0) NOT NULL,
  `userId` int(11) NULL DEFAULT NULL,
  `videoId` int(11) NULL DEFAULT NULL,
  `praiseNumber` int(11) NULL DEFAULT NULL COMMENT '该条评论的点赞数',
  `type` int(1) NULL DEFAULT NULL COMMENT '1.普通视频 2.番剧',
  `del` int(1) NULL DEFAULT NULL COMMENT '删除标志 1 未删除，2 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id3`(`userId`) USING BTREE,
  INDEX `video_id1`(`videoId`) USING BTREE,
  CONSTRAINT `user_id3` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `video_id1` FOREIGN KEY (`videoId`) REFERENCES `video` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of videocomment
-- ----------------------------
INSERT INTO `videocomment` VALUES (1, '第一条评论', '2019-05-24 12:35:36', 1, 1, 1, 1, 2);
INSERT INTO `videocomment` VALUES (2, '第二条评论', '2019-05-24 12:36:54', 12, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (3, '第三条评论', '2019-05-25 14:59:13', 11, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (4, '第四条评论', '2019-05-25 19:13:48', 4, 3, 0, 1, 1);
INSERT INTO `videocomment` VALUES (5, 'binary双子星', '2019-06-07 14:41:04', 10, 27, 0, 1, 1);
INSERT INTO `videocomment` VALUES (6, 'phenomenon现象', '2019-06-07 14:42:00', 23, 27, 0, 1, 1);
INSERT INTO `videocomment` VALUES (7, '答辩完了真好', '2019-06-08 16:03:29', 10, 2, 0, 1, 1);
INSERT INTO `videocomment` VALUES (8, 'upupandup', '2019-06-08 16:11:22', 10, 2, 0, 1, 1);
INSERT INTO `videocomment` VALUES (9, 'yzhyzhyzh', '2019-06-08 16:11:40', 10, 3, 0, 1, 1);
INSERT INTO `videocomment` VALUES (10, '我不想评论', '2019-06-08 16:12:14', 10, 5, 0, 1, 1);
INSERT INTO `videocomment` VALUES (11, '大吉大利', '2019-06-09 11:51:00', 3, 1, 1, 1, 1);
INSERT INTO `videocomment` VALUES (12, '晚上吃鸡', '2019-06-09 12:36:17', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (13, '你赢了', '2019-06-09 12:37:57', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (14, 'glory King', '2019-06-09 12:38:39', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (15, 'original', '2019-06-09 12:39:29', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (16, '原创领军', '2019-06-09 12:40:03', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (17, 'honey', '2019-06-09 12:41:15', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (18, '殿堂级', '2019-06-09 12:41:36', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (19, 'realme真香', '2019-06-09 12:42:17', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (20, '哈哈哈哈哈哈哈哈', '2019-06-09 13:09:05', 3, 4, 0, 1, 1);
INSERT INTO `videocomment` VALUES (21, '哇哇哇哇', '2019-06-09 13:09:13', 3, 4, 0, 1, 1);
INSERT INTO `videocomment` VALUES (22, '嘻嘻嘻嘻嘻', '2019-06-09 13:13:24', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (23, '第三方代码', '2019-06-09 13:53:32', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (24, '是是', '2019-06-10 14:29:37', 3, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (29, '5555', '2019-06-10 16:29:17', 23, 27, 0, 1, 1);
INSERT INTO `videocomment` VALUES (30, '测试', '2019-06-10 21:18:30', 10, 1, 0, 1, 1);
INSERT INTO `videocomment` VALUES (31, '哈卵张', '2019-06-16 01:15:48', 3, 32, 0, 1, 1);
INSERT INTO `videocomment` VALUES (32, 'tsetsest', '2019-06-17 14:55:59', 3, 1, 0, 1, 1);

-- ----------------------------
-- Table structure for videoforhisplay
-- ----------------------------
DROP TABLE IF EXISTS `videoforhisplay`;
CREATE TABLE `videoforhisplay`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hisPlayId` int(11) NOT NULL COMMENT '所属番剧的id',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该视频的存储地址',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该集的名字',
  `sort` int(5) NULL DEFAULT NULL COMMENT '系统自动生成对应的集数',
  `commentNumber` int(11) NULL DEFAULT NULL COMMENT '评论数',
  `del` int(1) NULL DEFAULT NULL COMMENT '删除标志 1 未删除，2 已删除',
  `firstImagePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频封面地址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `hisPlayID`(`hisPlayId`) USING BTREE,
  CONSTRAINT `hisPlayID` FOREIGN KEY (`hisPlayId`) REFERENCES `hisplay` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of videoforhisplay
-- ----------------------------
INSERT INTO `videoforhisplay` VALUES (1, 1, NULL, '第一话', 1, 5, 2, NULL);
INSERT INTO `videoforhisplay` VALUES (2, 1, NULL, '第二话', 2, 43, 1, NULL);
INSERT INTO `videoforhisplay` VALUES (3, 1, NULL, '第三话', 3, 434, 1, NULL);
INSERT INTO `videoforhisplay` VALUES (4, 1, NULL, '第四话', 4, 111, 1, NULL);
INSERT INTO `videoforhisplay` VALUES (5, 2, NULL, '第一话', 1, 11, 1, NULL);
INSERT INTO `videoforhisplay` VALUES (6, 2, NULL, '第二话', 2, 654, 1, NULL);
INSERT INTO `videoforhisplay` VALUES (7, 2, NULL, '第三话', 3, 65, 1, NULL);
INSERT INTO `videoforhisplay` VALUES (8, 1, '无', '第五话', 5, 0, 1, '无');

-- ----------------------------
-- Table structure for videooprecord
-- ----------------------------
DROP TABLE IF EXISTS `videooprecord`;
CREATE TABLE `videooprecord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `type` int(1) NULL DEFAULT NULL COMMENT '1 视频，2 番剧 3 评论（因为评论也有点赞的功能）',
  `del` int(1) NULL DEFAULT NULL COMMENT '删除标志 1 未删除，2 已删除',
  `opType` int(1) NULL DEFAULT NULL COMMENT '操作类型 1 点赞 2 分享 3 收藏',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `commentId` int(11) NULL DEFAULT NULL COMMENT '点赞评论的id',
  `videoId` int(11) NULL DEFAULT NULL COMMENT '点赞视频的id',
  `hisplayId` int(11) NULL DEFAULT NULL COMMENT '点赞番剧的id',
  `beUserId` int(11) NULL DEFAULT NULL COMMENT '被操作对象的id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 133 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of videooprecord
-- ----------------------------
INSERT INTO `videooprecord` VALUES (85, 3, 3, 2, 1, '2019-06-14 23:39:34', 1, NULL, NULL, 1);
INSERT INTO `videooprecord` VALUES (86, 3, 3, 2, 1, '2019-06-14 23:39:38', 1, NULL, NULL, 1);
INSERT INTO `videooprecord` VALUES (87, 3, 3, 2, 1, '2019-06-14 23:46:54', 2, NULL, NULL, 12);
INSERT INTO `videooprecord` VALUES (88, 3, 3, 2, 1, '2019-06-14 23:48:20', 1, NULL, NULL, 1);
INSERT INTO `videooprecord` VALUES (89, 3, 3, 2, 1, '2019-06-14 23:51:48', 1, NULL, NULL, 1);
INSERT INTO `videooprecord` VALUES (90, 3, 3, 2, 1, '2019-06-14 23:51:49', 2, NULL, NULL, 12);
INSERT INTO `videooprecord` VALUES (91, 3, 3, 2, 1, '2019-06-14 23:51:51', 2, NULL, NULL, 12);
INSERT INTO `videooprecord` VALUES (92, 3, 3, 2, 1, '2019-06-14 23:51:52', 3, NULL, NULL, 11);
INSERT INTO `videooprecord` VALUES (93, 3, 3, 2, 1, '2019-06-15 11:43:24', 2, NULL, NULL, 12);
INSERT INTO `videooprecord` VALUES (94, 3, 3, 1, 1, '2019-06-15 11:43:44', 11, NULL, NULL, 3);
INSERT INTO `videooprecord` VALUES (95, 3, 3, 2, 1, '2019-06-15 11:44:46', 1, NULL, NULL, 1);
INSERT INTO `videooprecord` VALUES (96, 3, 3, 2, 1, '2019-06-15 11:44:49', 1, NULL, NULL, 1);
INSERT INTO `videooprecord` VALUES (97, 3, 3, 1, 1, '2019-06-15 11:45:09', 1, NULL, NULL, 1);
INSERT INTO `videooprecord` VALUES (98, 3, 3, 2, 1, '2019-06-15 11:47:19', 3, NULL, NULL, 11);
INSERT INTO `videooprecord` VALUES (99, 3, 1, 2, 1, '2019-06-15 13:54:20', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (100, 3, 1, 2, 1, '2019-06-15 13:55:16', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (101, 3, 1, 2, 1, '2019-06-15 14:00:12', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (102, 3, 1, 2, 1, '2019-06-15 14:02:47', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (103, 3, 1, 2, 1, '2019-06-15 14:02:48', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (104, 3, 1, 2, 1, '2019-06-15 14:02:50', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (105, 3, 1, 2, 1, '2019-06-15 14:02:51', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (106, 3, 1, 2, 1, '2019-06-15 14:02:52', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (107, 3, 1, 2, 1, '2019-06-15 14:02:52', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (108, 3, 1, 2, 1, '2019-06-15 14:02:53', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (109, 3, 1, 2, 1, '2019-06-15 14:02:55', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (110, 3, 1, 2, 1, '2019-06-15 14:02:56', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (111, 3, 1, 2, 1, '2019-06-15 14:02:57', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (112, 3, 1, 2, 1, '2019-06-15 14:02:58', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (113, 3, 1, 2, 1, '2019-06-15 14:02:59', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (114, 3, 1, 2, 1, '2019-06-15 14:02:59', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (115, 3, 1, 2, 1, '2019-06-15 14:03:00', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (116, 3, 1, 2, 1, '2019-06-15 14:03:01', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (117, 3, 1, 2, 1, '2019-06-15 14:08:29', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (118, 3, 1, 2, 3, '2019-06-15 14:12:39', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (119, 3, 1, 2, 3, '2019-06-15 14:18:00', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (120, 3, 1, 2, 3, '2019-06-15 14:18:02', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (121, 3, 1, 2, 3, '2019-06-15 14:18:03', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (122, 3, 1, 2, 3, '2019-06-15 14:19:23', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (123, 3, 1, 2, 3, '2019-06-15 14:19:24', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (124, 3, 1, 1, 3, '2019-06-15 14:20:17', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (125, 11, 1, 2, 3, '2019-06-15 14:20:50', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (126, 11, 1, 1, 3, '2019-06-15 14:20:52', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (127, 11, 1, 2, 1, '2019-06-15 14:20:53', NULL, 1, NULL, 1);
INSERT INTO `videooprecord` VALUES (128, 11, 3, 2, 1, '2019-06-15 14:20:58', 1, NULL, NULL, 1);
INSERT INTO `videooprecord` VALUES (129, 3, 1, 2, 1, '2019-06-16 01:15:26', NULL, 32, NULL, 13);
INSERT INTO `videooprecord` VALUES (130, 3, 1, 2, 1, '2019-06-16 01:15:28', NULL, 32, NULL, 13);
INSERT INTO `videooprecord` VALUES (131, 3, 3, 2, 1, '2019-06-16 01:15:53', 31, NULL, NULL, 3);
INSERT INTO `videooprecord` VALUES (132, 3, 1, 1, 1, '2019-06-17 14:55:45', NULL, 1, NULL, 1);

-- ----------------------------
-- Table structure for web_status
-- ----------------------------
DROP TABLE IF EXISTS `web_status`;
CREATE TABLE `web_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visit_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '默认当前时间',
  `user_id` int(11) NULL DEFAULT NULL,
  `is_deleted` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '删除标志 0 未删除，1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `web_and_user_key`(`user_id`) USING BTREE,
  CONSTRAINT `web_and_user_key` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_status
-- ----------------------------
INSERT INTO `web_status` VALUES (1, '2019-05-24 15:47:50', 1, 1);
INSERT INTO `web_status` VALUES (2, '2019-05-31 15:52:54', 1, 1);
INSERT INTO `web_status` VALUES (3, '2019-05-29 22:39:38', 3, 0);
INSERT INTO `web_status` VALUES (4, '2019-06-11 22:39:41', 3, 0);
INSERT INTO `web_status` VALUES (5, '2019-04-09 22:39:43', 3, 0);
INSERT INTO `web_status` VALUES (6, '2018-06-01 22:39:46', 4, 0);
INSERT INTO `web_status` VALUES (7, '2019-04-08 22:40:06', 11, 0);
INSERT INTO `web_status` VALUES (8, '2019-04-16 22:40:08', 4, 0);
INSERT INTO `web_status` VALUES (9, '2019-03-27 22:40:10', 4, 0);
INSERT INTO `web_status` VALUES (10, '2019-06-05 22:40:13', 4, 0);
INSERT INTO `web_status` VALUES (11, '2019-05-15 22:40:15', 4, 0);
INSERT INTO `web_status` VALUES (12, '2018-06-21 22:40:17', 4, 0);
INSERT INTO `web_status` VALUES (13, '2019-07-01 22:40:19', 4, 0);
INSERT INTO `web_status` VALUES (14, '2019-05-23 22:40:21', 4, 0);
INSERT INTO `web_status` VALUES (15, '2019-06-01 22:44:03', 13, 0);
INSERT INTO `web_status` VALUES (17, '2019-04-16 20:00:26', 13, 0);
INSERT INTO `web_status` VALUES (18, '2019-06-08 17:02:37', 13, 0);
INSERT INTO `web_status` VALUES (19, '2019-06-08 15:02:40', 13, 0);
INSERT INTO `web_status` VALUES (20, '2019-06-12 19:13:19', 13, 0);
INSERT INTO `web_status` VALUES (21, '2019-06-12 17:13:34', 13, 0);
INSERT INTO `web_status` VALUES (22, '2019-06-14 21:30:53', 4, 0);
INSERT INTO `web_status` VALUES (23, '2019-06-12 20:14:06', 13, 0);
INSERT INTO `web_status` VALUES (24, '2019-06-12 21:14:07', 13, 0);
INSERT INTO `web_status` VALUES (25, '2019-06-12 21:14:07', 13, 0);
INSERT INTO `web_status` VALUES (26, '2019-06-13 21:31:04', 4, 0);
INSERT INTO `web_status` VALUES (27, '2019-06-14 21:31:41', 4, 0);
INSERT INTO `web_status` VALUES (28, '2019-06-14 21:44:56', 32, 0);
INSERT INTO `web_status` VALUES (29, '2019-06-14 21:46:06', 32, 0);
INSERT INTO `web_status` VALUES (30, '2019-06-14 21:50:10', 32, 0);
INSERT INTO `web_status` VALUES (31, '2019-06-14 21:51:27', 32, 0);
INSERT INTO `web_status` VALUES (32, '2019-06-14 21:51:57', 32, 0);
INSERT INTO `web_status` VALUES (33, '2019-06-14 21:52:37', 32, 0);
INSERT INTO `web_status` VALUES (34, '2019-06-14 21:56:54', 32, 0);
INSERT INTO `web_status` VALUES (35, '2019-06-14 22:00:29', 32, 0);
INSERT INTO `web_status` VALUES (36, '2019-06-16 20:54:17', 34, 0);
INSERT INTO `web_status` VALUES (37, '2019-06-16 21:12:15', 34, 0);
INSERT INTO `web_status` VALUES (38, '2019-06-16 21:53:41', 1, 0);
INSERT INTO `web_status` VALUES (39, '2019-06-16 22:13:38', 3, 0);
INSERT INTO `web_status` VALUES (40, '2019-06-16 22:19:24', 1, 0);
INSERT INTO `web_status` VALUES (41, '2019-06-16 22:19:49', 3, 0);
INSERT INTO `web_status` VALUES (42, '2019-06-16 22:33:25', 3, 0);
INSERT INTO `web_status` VALUES (43, '2019-06-16 22:43:03', 3, 0);
INSERT INTO `web_status` VALUES (44, '2019-06-17 00:16:30', 34, 0);
INSERT INTO `web_status` VALUES (45, '2019-06-17 00:28:51', 3, 0);
INSERT INTO `web_status` VALUES (46, '2019-06-17 10:57:14', 32, 0);
INSERT INTO `web_status` VALUES (47, '2019-06-17 11:17:49', 32, 0);
INSERT INTO `web_status` VALUES (48, '2019-06-17 11:25:45', 32, 0);
INSERT INTO `web_status` VALUES (49, '2019-06-17 11:36:13', 32, 0);
INSERT INTO `web_status` VALUES (50, '2019-06-17 11:39:05', 3, 0);
INSERT INTO `web_status` VALUES (51, '2019-06-17 11:55:22', 32, 0);
INSERT INTO `web_status` VALUES (52, '2019-06-17 11:57:31', 32, 0);
INSERT INTO `web_status` VALUES (53, '2019-06-17 12:00:28', 32, 0);
INSERT INTO `web_status` VALUES (54, '2019-06-17 12:02:18', 32, 0);
INSERT INTO `web_status` VALUES (55, '2019-06-17 12:02:28', 3, 0);
INSERT INTO `web_status` VALUES (56, '2019-06-17 12:17:41', 3, 0);
INSERT INTO `web_status` VALUES (57, '2019-06-17 12:58:14', 3, 0);
INSERT INTO `web_status` VALUES (58, '2019-06-17 12:59:30', 34, 0);
INSERT INTO `web_status` VALUES (59, '2019-06-17 12:59:35', 32, 0);
INSERT INTO `web_status` VALUES (60, '2019-06-17 13:00:40', 3, 0);
INSERT INTO `web_status` VALUES (61, '2019-06-17 14:10:21', 34, 0);
INSERT INTO `web_status` VALUES (62, '2019-06-17 14:13:59', 3, 0);
INSERT INTO `web_status` VALUES (63, '2019-06-17 14:27:33', 34, 0);
INSERT INTO `web_status` VALUES (64, '2019-06-17 14:37:07', 30, 0);
INSERT INTO `web_status` VALUES (65, '2019-06-17 14:52:10', 1, 0);
INSERT INTO `web_status` VALUES (66, '2019-06-17 14:53:48', 3, 0);

SET FOREIGN_KEY_CHECKS = 1;
