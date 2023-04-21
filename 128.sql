/*
 Navicat Premium Data Transfer

 Source Server         : rt
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : localhost:3306
 Source Schema         : 128

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 20/04/2023 20:28:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `card_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  PRIMARY KEY (`card_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('rt', '123', '123456789', '123', '成都市');
INSERT INTO `account` VALUES ('tt', '147', '123654789', '147', '新都');
INSERT INTO `account` VALUES ('cy', '258', '213654987', '258', '西南石油');
INSERT INTO `account` VALUES ('mz', '321', '413654987', '321', '北半球');
INSERT INTO `account` VALUES ('xxj', '369', '313654987', '369', '亚洲');
INSERT INTO `account` VALUES ('gx', '456', '987654321', '456', '四川省');
INSERT INTO `account` VALUES ('xrh', '654', '513654987', '654', '地球');
INSERT INTO `account` VALUES ('wyx', '741', '713654987', '741', '未知');
INSERT INTO `account` VALUES ('zbj', '789', '123789456', '789', '中国');
INSERT INTO `account` VALUES ('yym', '987', '613654987', '987', '银河系');

-- ----------------------------
-- Table structure for dingqi
-- ----------------------------
DROP TABLE IF EXISTS `dingqi`;
CREATE TABLE `dingqi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `money` double(255, 0) NOT NULL COMMENT '本金',
  `period` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存款时间',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dingqi
-- ----------------------------
INSERT INTO `dingqi` VALUES (8, '123', 100, '3个月', '2023-04-14 16:06:56');
INSERT INTO `dingqi` VALUES (9, '123', 1000, '6个月', '2023-04-14 16:07:20');
INSERT INTO `dingqi` VALUES (10, '123', 10000, '1年', '2023-04-14 16:07:46');
INSERT INTO `dingqi` VALUES (11, '321', 10000, '1年', '2023-04-14 16:07:57');
INSERT INTO `dingqi` VALUES (12, '321', 10000, '5年', '2023-04-14 16:08:03');
INSERT INTO `dingqi` VALUES (13, '321', 10, '5年', '2023-04-14 16:08:10');
INSERT INTO `dingqi` VALUES (14, '456', 100, '3年', '2023-04-14 16:08:42');
INSERT INTO `dingqi` VALUES (15, '258', 100, '3年', '2023-04-14 16:08:49');
INSERT INTO `dingqi` VALUES (16, '654', 1000, '3年', '2023-04-14 16:09:13');
INSERT INTO `dingqi` VALUES (17, '987', 1000, '1年', '2023-04-14 16:09:28');
INSERT INTO `dingqi` VALUES (18, '123', 1000, '3个月', '2023-04-14 21:28:08');
INSERT INTO `dingqi` VALUES (19, '123', 1000, '1年', '2023-04-15 14:42:24');
INSERT INTO `dingqi` VALUES (20, '123', 10, '3个月', '2023-04-18 14:59:11');
INSERT INTO `dingqi` VALUES (21, '123', 1000, '6个月', '2023-04-18 14:59:43');

-- ----------------------------
-- Table structure for huoqi
-- ----------------------------
DROP TABLE IF EXISTS `huoqi`;
CREATE TABLE `huoqi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `money` double(255, 0) NOT NULL COMMENT '金额',
  `create_time` date NOT NULL COMMENT '创建时间',
  `last_time` datetime(0) NOT NULL COMMENT '最近一次操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of huoqi
-- ----------------------------
INSERT INTO `huoqi` VALUES (9, '987', 1000, '2023-04-14', '2023-04-14 16:13:51');
INSERT INTO `huoqi` VALUES (10, '123', 900, '2023-04-14', '2023-04-14 19:55:45');
INSERT INTO `huoqi` VALUES (11, '123', 10000, '2023-04-14', '2023-04-14 16:14:28');
INSERT INTO `huoqi` VALUES (12, '123', 14700, '2023-04-14', '2023-04-14 21:30:01');
INSERT INTO `huoqi` VALUES (13, '321', 15000, '2023-04-14', '2023-04-14 16:14:48');
INSERT INTO `huoqi` VALUES (14, '321', 1800, '2023-04-14', '2023-04-14 16:14:56');
INSERT INTO `huoqi` VALUES (15, '456', 180, '2023-04-14', '2023-04-14 16:15:08');
INSERT INTO `huoqi` VALUES (16, '456', 1500, '2023-04-14', '2023-04-14 16:15:14');
INSERT INTO `huoqi` VALUES (17, '789', 1500, '2023-04-14', '2023-04-14 16:15:21');
INSERT INTO `huoqi` VALUES (18, '789', 100, '2023-04-14', '2023-04-14 16:15:27');
INSERT INTO `huoqi` VALUES (19, '123', 1000, '2023-04-14', '2023-04-14 21:27:18');
INSERT INTO `huoqi` VALUES (20, '123', 1001, '2023-04-14', '2023-04-14 21:28:30');

-- ----------------------------
-- Table structure for rate
-- ----------------------------
DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate`  (
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存款时间',
  `rate` double(255, 5) NOT NULL COMMENT '利率',
  PRIMARY KEY (`type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rate
-- ----------------------------
INSERT INTO `rate` VALUES ('1年', 0.00100);
INSERT INTO `rate` VALUES ('3个月', 100.00000);
INSERT INTO `rate` VALUES ('3年', 0.03000);
INSERT INTO `rate` VALUES ('5年', 0.50000);
INSERT INTO `rate` VALUES ('6个月', 0.00060);
INSERT INTO `rate` VALUES ('活期', 0.10000);

SET FOREIGN_KEY_CHECKS = 1;
