/*
Navicat MySQL Data Transfer

Source Server         : Yang
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-11-16 13:25:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `type` set('S','E','W','L','O') NOT NULL DEFAULT 'O',
  `author` varchar(20) NOT NULL,
  `discount` double(2,1) NOT NULL,
  `price` double(10,2) NOT NULL,
  `amount` int(11) NOT NULL,
  `profile` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='S(科学);E(教育);W(文学);L(生活);O(其它)';

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '张杰', 'W', '张杰', '0.9', '55.00', '9', '张杰简介');
INSERT INTO `book` VALUES ('2', '张杰', 'W', '张杰', '0.9', '55.00', '9', '张杰简介');
INSERT INTO `book` VALUES ('3', '郭德纲相声', 'W', '郭德纲', '0.9', '434.00', '3', '郭德纲相声大全');
INSERT INTO `book` VALUES ('5', 'Html5', 'E', '杨延彬', '0.9', '80.00', '10', 'html5技术');
INSERT INTO `book` VALUES ('7', '三国演义', 'W', '罗贯中', '1.0', '29.00', '5', '三国演义');
INSERT INTO `book` VALUES ('9', 'java', 'S', 'java', '1.0', '55.00', '6', '5');
