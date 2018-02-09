/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : solo

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-11-29 18:47:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `solo_user`
-- ----------------------------
DROP TABLE IF EXISTS `solo_user`;
CREATE TABLE `solo_user` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `userId` varchar(20) DEFAULT NULL COMMENT '用户账号',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `passWord` varchar(20) DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of solo_user
-- ----------------------------
INSERT INTO `solo_user` VALUES ('1', 'test', 'test', 'test');
