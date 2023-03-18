/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : zinfos

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2023-03-18 18:54:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zk_user_t
-- ----------------------------
DROP TABLE IF EXISTS `zk_user_t`;
CREATE TABLE `zk_user_t` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `userName` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_date` datetime NOT NULL,
  `last_update_by` varchar(64) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of zk_user_t
-- ----------------------------
INSERT INTO `zk_user_t` VALUES ('1', 'zhouwei', '123456', '17688916888', 'zw', '2023-03-18 15:58:50', 'zw', '2023-03-18 15:58:55');
