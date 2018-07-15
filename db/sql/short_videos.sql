/*
Navicat MySQL Data Transfer

Source Server         : short-video
Source Server Version : 50722
Source Host           : 192.168.236.128:3306
Source Database       : short_videos

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-16 00:16:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bgm
-- ----------------------------
DROP TABLE IF EXISTS `bgm`;
CREATE TABLE `bgm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `author` varchar(64) DEFAULT NULL,
  `poster` varchar(256) DEFAULT NULL,
  `url` varchar(256) NOT NULL,
  `type` int(11) NOT NULL,
  `ref_cnt` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bgm_type
-- ----------------------------
DROP TABLE IF EXISTS `bgm_type`;
CREATE TABLE `bgm_type` (
  `id` int(11) NOT NULL,
  `type_name` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for constellation
-- ----------------------------
DROP TABLE IF EXISTS `constellation`;
CREATE TABLE `constellation` (
  `id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `start_date` varchar(4) NOT NULL,
  `end_date` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `face_image` varchar(255) DEFAULT NULL,
  `nickname` varchar(32) NOT NULL,
  `fans_count` int(11) NOT NULL,
  `follow_count` int(11) NOT NULL,
  `receive_like_count` int(11) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `constellation_id` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
