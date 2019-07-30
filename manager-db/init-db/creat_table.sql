
/*
Navicat MySQL Data Transfer

Source Server         : 本地3306
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-07-29 11:41:44
*/

/*创建数据库*/
CREATE DATABASE test;

SET FOREIGN_KEY_CHECKS=0;

/*创建表*/
-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `S_No` varchar(10) DEFAULT NULL,
  `S_name` varchar(10) DEFAULT NULL,
  `S_age` datetime DEFAULT NULL,
  `S_sex` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('01', '赵雷', '1990-01-01 00:00:00', '男');
INSERT INTO `stu` VALUES ('02', '钱电', '1990-12-21 00:00:00', '男');
INSERT INTO `stu` VALUES ('03', '孙风', '1990-05-20 00:00:00', '男');
INSERT INTO `stu` VALUES ('04', '李云', '1990-08-06 00:00:00', '男');
INSERT INTO `stu` VALUES ('05', '周梅', '1991-12-01 00:00:00', '女');
INSERT INTO `stu` VALUES ('06', '吴兰', '1992-03-01 00:00:00', '女');
INSERT INTO `stu` VALUES ('07', '郑竹', '1989-07-01 00:00:00', '女');
INSERT INTO `stu` VALUES ('08', '王菊', '1990-01-20 00:00:00', '女');
INSERT INTO `stu` VALUES (null, '赵雷', '2019-05-21 11:52:57', '女');

