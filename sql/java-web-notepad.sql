/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : java-web-notepad

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-12-28 16:25:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `note`
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('1', '1', '111修改', '测试1111，6226内容\nQAQ<h1><b>666666</b></h1>', '2019-12-27 16:53:54', '2019-12-28 07:36:20');
INSERT INTO `note` VALUES ('2', '1', '测试22', '测试2222，66内容\r\nQAQ', '2019-12-27 16:54:21', '2019-12-27 16:54:21');
INSERT INTO `note` VALUES ('3', '1', '测试3', '测试333，66内容\r\nQAQ', '2019-12-27 17:33:19', '2019-12-27 17:33:19');
INSERT INTO `note` VALUES ('4', '1', '我是新增的啦啦啦啦啦啦啦啦绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿', '<p>啦啦啦啦啦啦啦啦啦啦啦啦</p><ol><li>123</li><li>31</li><li>ergeee</li><li>g人</li><li>g 个</li><li>个</li><li>任何人挺好r工作</li></ol><p>个在</p><p>hgfd</p>', '2019-12-28 07:38:21', '2019-12-28 08:24:24');
INSERT INTO `note` VALUES ('5', '1', '啦啦啦啦啦啦啦啦', '<p><i>​快乐</i><br></p>', '2019-12-28 07:46:59', '2019-12-28 07:46:59');
INSERT INTO `note` VALUES ('6', '1', '321', '<p>123</p>', '2019-12-28 07:52:13', '2019-12-28 07:52:13');
INSERT INTO `note` VALUES ('7', '1', '888', '<p>1111</p><p>3435</p><p>777777777777</p>', '2019-12-28 08:10:22', '2019-12-28 08:21:47');
INSERT INTO `note` VALUES ('8', '1', '555', '<p>52f</p>', '2019-12-28 08:10:40', '2019-12-28 08:10:40');
INSERT INTO `note` VALUES ('9', '1', 'hfaasdfg', '<p>gtgdfsda一环套谷朊粉发送到发现丰富的</p>', '2019-12-28 08:10:54', '2019-12-28 08:10:54');
INSERT INTO `note` VALUES ('10', '1', '1', '<p>2355</p>', '2019-12-28 08:11:01', '2019-12-28 08:11:01');
INSERT INTO `note` VALUES ('11', '1', '5432', '<p>2413</p><p>555555555</p>', '2019-12-28 08:11:06', '2019-12-28 08:22:15');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'demo', 'e10adc3949ba59abbe56e057f20f883e', 'demoQAQ');
INSERT INTO `user` VALUES ('2', 'demo2', 'e10adc3949ba59abbe56e057f20f883e', 'demoQAQ');
