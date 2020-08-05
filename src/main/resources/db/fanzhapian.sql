/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : fanzhapian

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2020-08-05 09:01:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_apply`
-- ----------------------------
DROP TABLE IF EXISTS `t_apply`;
CREATE TABLE `t_apply` (
  `id` varchar(32) NOT NULL COMMENT '申请表编号',
  `applyid` varchar(32) DEFAULT NULL COMMENT '申请人id',
  `replyid` varchar(32) DEFAULT NULL COMMENT '接收人id',
  `message` varchar(300) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`),
  KEY `applyid` (`applyid`),
  KEY `replyid` (`replyid`),
  CONSTRAINT `t_apply_ibfk_1` FOREIGN KEY (`applyid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_apply_ibfk_2` FOREIGN KEY (`replyid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='申请表';

-- ----------------------------
-- Records of t_apply
-- ----------------------------
INSERT INTO `t_apply` VALUES ('0', '1', '1', '1');
INSERT INTO `t_apply` VALUES ('1', '1', '3', 'adadad');

-- ----------------------------
-- Table structure for `t_blackstorage`
-- ----------------------------
DROP TABLE IF EXISTS `t_blackstorage`;
CREATE TABLE `t_blackstorage` (
  `id` varchar(32) NOT NULL COMMENT '黑库编号',
  `message` varchar(32) NOT NULL COMMENT '黑库嫌疑信息',
  `typecontent` varchar(32) NOT NULL COMMENT '黑库类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='黑库表';

-- ----------------------------
-- Records of t_blackstorage
-- ----------------------------
INSERT INTO `t_blackstorage` VALUES ('1', '网址诈骗', 'www.baidu.com');
INSERT INTO `t_blackstorage` VALUES ('12', '12', '15');
INSERT INTO `t_blackstorage` VALUES ('13', 'asd', 'asd');

-- ----------------------------
-- Table structure for `t_check`
-- ----------------------------
DROP TABLE IF EXISTS `t_check`;
CREATE TABLE `t_check` (
  `id` varchar(32) NOT NULL COMMENT '审核编号',
  `checkpeople` varchar(32) DEFAULT NULL COMMENT '审核人',
  `type` int NOT NULL COMMENT '审核类型',
  `statu` int DEFAULT '0' COMMENT '审核状态',
  `result` int DEFAULT '0' COMMENT '审核结果',
  `contentid` varchar(32) NOT NULL COMMENT '审核内容编号',
  `userid` varchar(32) NOT NULL COMMENT '发起人',
  `checktime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '审核时间',
  PRIMARY KEY (`id`),
  KEY `checkpeople` (`checkpeople`),
  KEY `userid` (`userid`),
  KEY `contentid` (`contentid`),
  CONSTRAINT `t_check_ibfk_1` FOREIGN KEY (`checkpeople`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_check_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_check_ibfk_3` FOREIGN KEY (`contentid`) REFERENCES `t_essay` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='审核表 ';

-- ----------------------------
-- Records of t_check
-- ----------------------------
INSERT INTO `t_check` VALUES ('1594862147333358000', '0', '1', '1', '2', '1594347669889661809', '0', '2020-07-16 15:54:43');
INSERT INTO `t_check` VALUES ('1594885487482144118', '0', '1', '1', '2', '1594794040961335290', '1', '2020-07-16 15:54:37');
INSERT INTO `t_check` VALUES ('1594888664435945273', '1', '0', '1', '2', '1594888664410867769', '1', '2020-07-16 16:38:23');
INSERT INTO `t_check` VALUES ('1594947910360747952', '0', '0', '1', '2', '1594947910031582353', '0', '2020-07-22 11:32:32');
INSERT INTO `t_check` VALUES ('1594948289978222612', '1', '0', '0', '0', '1594948289963655956', '0', '2020-07-17 09:18:23');
INSERT INTO `t_check` VALUES ('1594948750421142438', '1', '0', '1', '2', '1594948750410984143', '0', '2020-07-17 09:55:51');

-- ----------------------------
-- Table structure for `t_essay`
-- ----------------------------
DROP TABLE IF EXISTS `t_essay`;
CREATE TABLE `t_essay` (
  `id` varchar(32) NOT NULL COMMENT '文章编号',
  `userid` varchar(32) NOT NULL COMMENT '发表人',
  `title` varchar(32) NOT NULL COMMENT '文章标题',
  `content` varchar(255) NOT NULL COMMENT '文章内容',
  `statu` int DEFAULT '0' COMMENT '文章状态',
  `createtime` datetime DEFAULT NULL COMMENT '发表时间',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `t_essay_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表 ';

-- ----------------------------
-- Records of t_essay
-- ----------------------------
INSERT INTO `t_essay` VALUES ('1', '1', '诈骗被骗上万？', '张楚岚', '1', '2020-07-10 09:22:25');
INSERT INTO `t_essay` VALUES ('1594347669889661809', '0', '如何提防新型诈骗方式', '诸葛青', '1', '2020-07-15 10:11:50');
INSERT INTO `t_essay` VALUES ('1594794040501915287', '0', '5555', 'aaa', '1', null);
INSERT INTO `t_essay` VALUES ('1594794040881138115', '0', '5555', 'aaa', '1', null);
INSERT INTO `t_essay` VALUES ('1594794040889313740', '0', '5555', 'aaa', '1', null);
INSERT INTO `t_essay` VALUES ('1594794040896117766', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794040903438992', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794040910557667', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794040919855135', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794040926419498', '0', '5555', 'aaa', '1', null);
INSERT INTO `t_essay` VALUES ('1594794040937817495', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794040943939140', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794040954250717', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794040961335290', '0', '5555', 'aaa', '1', null);
INSERT INTO `t_essay` VALUES ('1594794040969205817', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794040976287637', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794040984488388', '0', '5555', 'aaa', '1', null);
INSERT INTO `t_essay` VALUES ('1594794040992211900', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041005181600', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041011498245', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041019255102', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041029281544', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041036916139', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041042958729', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041049780475', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041055140851', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041061139559', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041066593455', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041072837080', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041078883842', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594794041084157140', '0', '5555', 'aaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594802525603769126', '1', 'afdf', '42425212', '0', null);
INSERT INTO `t_essay` VALUES ('1594888664410867769', '1', '我是李白', ' dadad', '0', null);
INSERT INTO `t_essay` VALUES ('1594890173955583647', '0', '我是aaaaaaaaaa', ' aaaaaaaaaaaaaaaaaaaaaa', '0', null);
INSERT INTO `t_essay` VALUES ('1594947910031582353', '0', '我是root', ' 我是root', '1', null);
INSERT INTO `t_essay` VALUES ('1594948289963655956', '0', '我不是root', ' 我不是root', '0', null);
INSERT INTO `t_essay` VALUES ('1594948750410984143', '0', 'sdadasdsadasdadadad', ' sadadasdasdadasd', '1', null);
INSERT INTO `t_essay` VALUES ('2', '1594263718243991425', '牢记这些让你远离诈骗', '法海', '0', '2020-07-10 09:24:08');
INSERT INTO `t_essay` VALUES ('3', '1', '啊啊啊啊啊啊啊', '啊啊啊啊啊', '0', '2020-07-15 10:34:58');

-- ----------------------------
-- Table structure for `t_friend`
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend` (
  `id` varchar(32) NOT NULL COMMENT '朋友表编号',
  `friendid` varchar(32) DEFAULT NULL COMMENT '好友id',
  `userid` varchar(32) DEFAULT NULL COMMENT '用户id',
  `type` char(1) DEFAULT NULL COMMENT '好友类型',
  PRIMARY KEY (`id`),
  KEY `friendid` (`friendid`),
  KEY `userid` (`userid`),
  CONSTRAINT `t_friend_ibfk_1` FOREIGN KEY (`friendid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_friend_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友表';

-- ----------------------------
-- Records of t_friend
-- ----------------------------
INSERT INTO `t_friend` VALUES ('1', '0', '0', '1');
INSERT INTO `t_friend` VALUES ('2', '3', '1', '1');

-- ----------------------------
-- Table structure for `t_history`
-- ----------------------------
DROP TABLE IF EXISTS `t_history`;
CREATE TABLE `t_history` (
  `id` varchar(32) NOT NULL COMMENT '浏览编号',
  `userid` varchar(32) NOT NULL COMMENT '浏览人',
  `essayid` varchar(32) NOT NULL COMMENT '浏览文章编号',
  `statu` int NOT NULL DEFAULT '1' COMMENT '浏览状态',
  `starttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '浏览时间',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `essayid` (`essayid`),
  CONSTRAINT `t_history_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_history_ibfk_2` FOREIGN KEY (`essayid`) REFERENCES `t_essay` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='浏览记录表';

-- ----------------------------
-- Records of t_history
-- ----------------------------
INSERT INTO `t_history` VALUES ('1595402290233619134', '1', '1594347669889661809', '1', '2020-07-22 15:18:10');
INSERT INTO `t_history` VALUES ('1595403247681365739', '1', '1594347669889661809', '1', '2020-07-22 15:34:07');
INSERT INTO `t_history` VALUES ('1595918992421903359', '3', '1594794040501915287', '1', '2020-07-28 14:49:52');

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` varchar(32) NOT NULL COMMENT '内容编号',
  `typeid` varchar(32) NOT NULL COMMENT '内容类型',
  `content` varchar(255) NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`),
  KEY `typeid` (`typeid`),
  CONSTRAINT `t_message_ibfk_1` FOREIGN KEY (`typeid`) REFERENCES `t_messagetype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容表';

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for `t_messagetype`
-- ----------------------------
DROP TABLE IF EXISTS `t_messagetype`;
CREATE TABLE `t_messagetype` (
  `id` varchar(32) NOT NULL COMMENT '类型编号',
  `name` varchar(32) NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `messagetypename` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容类型表';

-- ----------------------------
-- Records of t_messagetype
-- ----------------------------

-- ----------------------------
-- Table structure for `t_modul`
-- ----------------------------
DROP TABLE IF EXISTS `t_modul`;
CREATE TABLE `t_modul` (
  `id` varchar(32) NOT NULL COMMENT '模板编号',
  `name` varchar(64) NOT NULL COMMENT '模板名称',
  `url` varchar(32) NOT NULL COMMENT '模板路径',
  PRIMARY KEY (`id`),
  UNIQUE KEY `modulname` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板表';

-- ----------------------------
-- Records of t_modul
-- ----------------------------
INSERT INTO `t_modul` VALUES ('1', '用户管理', 'http://www.sss.com');
INSERT INTO `t_modul` VALUES ('2', '题库管理', 'http://www.xxx.com');

-- ----------------------------
-- Table structure for `t_project`
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` varchar(32) NOT NULL COMMENT '项目编号',
  `name` varchar(32) NOT NULL COMMENT '项目名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES ('1', '蚂蚁森林');
INSERT INTO `t_project` VALUES ('2', '花呗');
INSERT INTO `t_project` VALUES ('3', '淘宝');
INSERT INTO `t_project` VALUES ('4', '支付宝');
INSERT INTO `t_project` VALUES ('5', '拼兮兮');
INSERT INTO `t_project` VALUES ('6', '借呗');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` varchar(32) NOT NULL COMMENT '角色编号',
  `rolename` varchar(64) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `rolename` (`rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin');
INSERT INTO `t_role` VALUES ('2', 'people');

-- ----------------------------
-- Table structure for `t_role_modul`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_modul`;
CREATE TABLE `t_role_modul` (
  `roleid` varchar(32) NOT NULL COMMENT '角色编号',
  `modulid` varchar(32) NOT NULL COMMENT '模板编号',
  KEY `roleid` (`roleid`),
  KEY `modulid` (`modulid`),
  CONSTRAINT `t_role_modul_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `t_role` (`id`),
  CONSTRAINT `t_role_modul_ibfk_2` FOREIGN KEY (`modulid`) REFERENCES `t_modul` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色模板表';

-- ----------------------------
-- Records of t_role_modul
-- ----------------------------
INSERT INTO `t_role_modul` VALUES ('1', '1');
INSERT INTO `t_role_modul` VALUES ('1', '2');
INSERT INTO `t_role_modul` VALUES ('2', '1');

-- ----------------------------
-- Table structure for `t_team`
-- ----------------------------
DROP TABLE IF EXISTS `t_team`;
CREATE TABLE `t_team` (
  `id` varchar(32) NOT NULL COMMENT '团队表编号',
  `name` varchar(32) NOT NULL COMMENT '队伍名',
  `userid` varchar(32) NOT NULL COMMENT '创建人',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `t_team_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队表';

-- ----------------------------
-- Records of t_team
-- ----------------------------
INSERT INTO `t_team` VALUES ('1', '天天向上', '0', '2020-07-21 10:37:11');
INSERT INTO `t_team` VALUES ('2', '王牌家族', '1', '2020-07-21 10:37:36');
INSERT INTO `t_team` VALUES ('3', '咯咯咯', '1594263718243991425', '2020-07-21 10:37:58');
INSERT INTO `t_team` VALUES ('4', '鹅鹅鹅', '2', '2020-07-21 10:38:12');

-- ----------------------------
-- Table structure for `t_teampeople`
-- ----------------------------
DROP TABLE IF EXISTS `t_teampeople`;
CREATE TABLE `t_teampeople` (
  `teamid` varchar(32) NOT NULL COMMENT '团队表编号',
  `userid` varchar(32) NOT NULL COMMENT '成员',
  KEY `teamid` (`teamid`),
  KEY `userid` (`userid`),
  CONSTRAINT `t_teampeople_ibfk_1` FOREIGN KEY (`teamid`) REFERENCES `t_team` (`id`),
  CONSTRAINT `t_teampeople_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团员表';

-- ----------------------------
-- Records of t_teampeople
-- ----------------------------
INSERT INTO `t_teampeople` VALUES ('1', '0');
INSERT INTO `t_teampeople` VALUES ('1', '1');
INSERT INTO `t_teampeople` VALUES ('1', '2');
INSERT INTO `t_teampeople` VALUES ('2', '0');
INSERT INTO `t_teampeople` VALUES ('2', '1594263718243991425');
INSERT INTO `t_teampeople` VALUES ('2', '1');
INSERT INTO `t_teampeople` VALUES ('4', '2');
INSERT INTO `t_teampeople` VALUES ('3', '1594263718243991425');

-- ----------------------------
-- Table structure for `t_teamproject`
-- ----------------------------
DROP TABLE IF EXISTS `t_teamproject`;
CREATE TABLE `t_teamproject` (
  `teamid` varchar(32) NOT NULL COMMENT '团队编号',
  `projectid` varchar(32) NOT NULL COMMENT '项目编号',
  KEY `teamid` (`teamid`),
  KEY `projectid` (`projectid`),
  CONSTRAINT `t_teamproject_ibfk_1` FOREIGN KEY (`teamid`) REFERENCES `t_team` (`id`),
  CONSTRAINT `t_teamproject_ibfk_2` FOREIGN KEY (`projectid`) REFERENCES `t_project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队项目表';

-- ----------------------------
-- Records of t_teamproject
-- ----------------------------
INSERT INTO `t_teamproject` VALUES ('3', '4');
INSERT INTO `t_teamproject` VALUES ('4', '5');
INSERT INTO `t_teamproject` VALUES ('2', '1');
INSERT INTO `t_teamproject` VALUES ('2', '2');
INSERT INTO `t_teamproject` VALUES ('2', '4');
INSERT INTO `t_teamproject` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `t_test`
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test` (
  `id` varchar(32) NOT NULL COMMENT '题目表编号',
  `userid` varchar(32) NOT NULL COMMENT '答题人',
  `grade` varchar(32) NOT NULL COMMENT '得分',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `t_test_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题目表';

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES ('1594710763530576178', '0', '80');
INSERT INTO `t_test` VALUES ('1594711032918734999', '0', '50');
INSERT INTO `t_test` VALUES ('1594778659866388188', '0', '70');
INSERT INTO `t_test` VALUES ('1594884599945843469', '0', '20');
INSERT INTO `t_test` VALUES ('1594954811628238051', '1', '20');
INSERT INTO `t_test` VALUES ('1594954811668760207', '1', '20');
INSERT INTO `t_test` VALUES ('1595236363363626522', '0', '40');
INSERT INTO `t_test` VALUES ('1595236668832383463', '0', '40');
INSERT INTO `t_test` VALUES ('1595236773467652581', '1', '20');
INSERT INTO `t_test` VALUES ('1595236873198219635', '1', '80');
INSERT INTO `t_test` VALUES ('1595237041832457148', '1', '50');

-- ----------------------------
-- Table structure for `t_teststorage`
-- ----------------------------
DROP TABLE IF EXISTS `t_teststorage`;
CREATE TABLE `t_teststorage` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '题目编号',
  `question` varchar(32) NOT NULL COMMENT '题目',
  `answer` varchar(32) NOT NULL COMMENT '答案',
  `analysis` varchar(255) NOT NULL COMMENT '解析',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库表';

-- ----------------------------
-- Records of t_teststorage
-- ----------------------------
INSERT INTO `t_teststorage` VALUES ('10', '陌生电话转账，可信吗11', '错', '这是假的11');
INSERT INTO `t_teststorage` VALUES ('100', '陌生电话转账，可信吗101', '错', '这是假的101');
INSERT INTO `t_teststorage` VALUES ('101', '陌生电话转账，可信吗102', '对', '这是假的102');
INSERT INTO `t_teststorage` VALUES ('102', '陌生电话转账，可信吗103', '错', '这是假的103');
INSERT INTO `t_teststorage` VALUES ('103', '陌生电话转账，可信吗104', '对', '这是假的104');
INSERT INTO `t_teststorage` VALUES ('104', '陌生电话转账，可信吗105', '错', '这是假的105');
INSERT INTO `t_teststorage` VALUES ('105', '陌生电话转账，可信吗106', '对', '这是假的106');
INSERT INTO `t_teststorage` VALUES ('106', '陌生电话转账，可信吗107', '错', '这是假的107');
INSERT INTO `t_teststorage` VALUES ('107', '陌生电话转账，可信吗108', '对', '这是假的108');
INSERT INTO `t_teststorage` VALUES ('108', '陌生电话转账，可信吗109', '错', '这是假的109');
INSERT INTO `t_teststorage` VALUES ('109', '陌生电话转账，可信吗110', '对', '这是假的110');
INSERT INTO `t_teststorage` VALUES ('11', '陌生电话转账，可信吗12', '对', '这是假的12');
INSERT INTO `t_teststorage` VALUES ('110', '陌生电话转账，可信吗111', '错', '这是假的111');
INSERT INTO `t_teststorage` VALUES ('111', '陌生电话转账，可信吗112', '对', '这是假的112');
INSERT INTO `t_teststorage` VALUES ('112', '陌生电话转账，可信吗113', '错', '这是假的113');
INSERT INTO `t_teststorage` VALUES ('113', '陌生电话转账，可信吗114', '对', '这是假的114');
INSERT INTO `t_teststorage` VALUES ('114', '陌生电话转账，可信吗115', '错', '这是假的115');
INSERT INTO `t_teststorage` VALUES ('115', '陌生电话转账，可信吗116', '对', '这是假的116');
INSERT INTO `t_teststorage` VALUES ('116', '陌生电话转账，可信吗117', '错', '这是假的117');
INSERT INTO `t_teststorage` VALUES ('117', '陌生电话转账，可信吗118', '对', '这是假的118');
INSERT INTO `t_teststorage` VALUES ('118', '陌生电话转账，可信吗119', '错', '这是假的119');
INSERT INTO `t_teststorage` VALUES ('119', 'nihs', '对', 'aa');
INSERT INTO `t_teststorage` VALUES ('12', '陌生电话转账，可信吗13', '错', '这是假的13');
INSERT INTO `t_teststorage` VALUES ('120', 'aaaaaaaaavvvvvvv', '对', 'aaaaaaaaaaaav');
INSERT INTO `t_teststorage` VALUES ('13', '陌生电话转账，可信吗14', '对', '这是假的14');
INSERT INTO `t_teststorage` VALUES ('14', '陌生电话转账，可信吗15', '错', '这是假的15');
INSERT INTO `t_teststorage` VALUES ('15', '陌生电话转账，可信吗16', '对', '这是假的16');
INSERT INTO `t_teststorage` VALUES ('16', '陌生电话转账，可信吗17', '错', '这是假的17');
INSERT INTO `t_teststorage` VALUES ('17', '陌生电话转账，可信吗18', '对', '这是假的18');
INSERT INTO `t_teststorage` VALUES ('18', '陌生电话转账，可信吗19', '错', '这是假的19');
INSERT INTO `t_teststorage` VALUES ('19', '陌生电话转账，可信吗20', '对', '这是假的20');
INSERT INTO `t_teststorage` VALUES ('2', '陌生电话转账，可信吗3', '错', '这是假的3');
INSERT INTO `t_teststorage` VALUES ('20', '陌生电话转账，可信吗21', '错', '这是假的21');
INSERT INTO `t_teststorage` VALUES ('21', '陌生电话转账，可信吗22', '对', '这是假的22');
INSERT INTO `t_teststorage` VALUES ('22', '陌生电话转账，可信吗23', '错', '这是假的23');
INSERT INTO `t_teststorage` VALUES ('23', '陌生电话转账，可信吗24', '对', '这是假的24');
INSERT INTO `t_teststorage` VALUES ('24', '陌生电话转账，可信吗25', '错', '这是假的25');
INSERT INTO `t_teststorage` VALUES ('25', '陌生电话转账，可信吗26', '对', '这是假的26');
INSERT INTO `t_teststorage` VALUES ('26', '陌生电话转账，可信吗27', '错', '这是假的27');
INSERT INTO `t_teststorage` VALUES ('27', '陌生电话转账，可信吗28', '对', '这是假的28');
INSERT INTO `t_teststorage` VALUES ('28', '陌生电话转账，可信吗29', '错', '这是假的29');
INSERT INTO `t_teststorage` VALUES ('29', '陌生电话转账，可信吗30', '对', '这是假的30');
INSERT INTO `t_teststorage` VALUES ('3', '陌生电话转账，可信吗4', '对', '这是假的4');
INSERT INTO `t_teststorage` VALUES ('30', '陌生电话转账，可信吗31', '错', '这是假的31');
INSERT INTO `t_teststorage` VALUES ('31', '陌生电话转账，可信吗32', '对', '这是假的32');
INSERT INTO `t_teststorage` VALUES ('32', '陌生电话转账，可信吗33', '错', '这是假的33');
INSERT INTO `t_teststorage` VALUES ('33', '陌生电话转账，可信吗34', '对', '这是假的34');
INSERT INTO `t_teststorage` VALUES ('34', '陌生电话转账，可信吗35', '错', '这是假的35');
INSERT INTO `t_teststorage` VALUES ('35', '陌生电话转账，可信吗36', '对', '这是假的36');
INSERT INTO `t_teststorage` VALUES ('36', '陌生电话转账，可信吗37', '错', '这是假的37');
INSERT INTO `t_teststorage` VALUES ('37', '陌生电话转账，可信吗38', '对', '这是假的38');
INSERT INTO `t_teststorage` VALUES ('38', '陌生电话转账，可信吗39', '错', '这是假的39');
INSERT INTO `t_teststorage` VALUES ('39', '陌生电话转账，可信吗40', '对', '这是假的40');
INSERT INTO `t_teststorage` VALUES ('4', '陌生电话转账，可信吗5', '错', '这是假的5');
INSERT INTO `t_teststorage` VALUES ('40', '陌生电话转账，可信吗41', '错', '这是假的41');
INSERT INTO `t_teststorage` VALUES ('41', '陌生电话转账，可信吗42', '对', '这是假的42');
INSERT INTO `t_teststorage` VALUES ('42', '陌生电话转账，可信吗43', '错', '这是假的43');
INSERT INTO `t_teststorage` VALUES ('43', '陌生电话转账，可信吗44', '对', '这是假的44');
INSERT INTO `t_teststorage` VALUES ('44', '陌生电话转账，可信吗45', '错', '这是假的45');
INSERT INTO `t_teststorage` VALUES ('45', '陌生电话转账，可信吗46', '对', '这是假的46');
INSERT INTO `t_teststorage` VALUES ('46', '陌生电话转账，可信吗47', '错', '这是假的47');
INSERT INTO `t_teststorage` VALUES ('47', '陌生电话转账，可信吗48', '对', '这是假的48');
INSERT INTO `t_teststorage` VALUES ('48', '陌生电话转账，可信吗49', '错', '这是假的49');
INSERT INTO `t_teststorage` VALUES ('49', '陌生电话转账，可信吗50', '对', '这是假的50');
INSERT INTO `t_teststorage` VALUES ('5', '陌生电话转账，可信吗6', '对', '这是假的6');
INSERT INTO `t_teststorage` VALUES ('50', '陌生电话转账，可信吗51', '错', '这是假的51');
INSERT INTO `t_teststorage` VALUES ('51', '陌生电话转账，可信吗52', '对', '这是假的52');
INSERT INTO `t_teststorage` VALUES ('52', '陌生电话转账，可信吗53', '错', '这是假的53');
INSERT INTO `t_teststorage` VALUES ('53', '陌生电话转账，可信吗54', '对', '这是假的54');
INSERT INTO `t_teststorage` VALUES ('54', '陌生电话转账，可信吗55', '错', '这是假的55');
INSERT INTO `t_teststorage` VALUES ('55', '陌生电话转账，可信吗56', '对', '这是假的56');
INSERT INTO `t_teststorage` VALUES ('56', '陌生电话转账，可信吗57', '错', '这是假的57');
INSERT INTO `t_teststorage` VALUES ('57', '陌生电话转账，可信吗58', '对', '这是假的58');
INSERT INTO `t_teststorage` VALUES ('58', '陌生电话转账，可信吗59', '错', '这是假的59');
INSERT INTO `t_teststorage` VALUES ('59', '陌生电话转账，可信吗60', '对', '这是假的60');
INSERT INTO `t_teststorage` VALUES ('6', '陌生电话转账，可信吗7', '错', '这是假的7');
INSERT INTO `t_teststorage` VALUES ('60', '陌生电话转账，可信吗61', '错', '这是假的61');
INSERT INTO `t_teststorage` VALUES ('61', '陌生电话转账，可信吗62', '对', '这是假的62');
INSERT INTO `t_teststorage` VALUES ('62', '陌生电话转账，可信吗63', '错', '这是假的63');
INSERT INTO `t_teststorage` VALUES ('63', '陌生电话转账，可信吗64', '对', '这是假的64');
INSERT INTO `t_teststorage` VALUES ('64', '陌生电话转账，可信吗65', '错', '这是假的65');
INSERT INTO `t_teststorage` VALUES ('65', '陌生电话转账，可信吗66', '对', '这是假的66');
INSERT INTO `t_teststorage` VALUES ('66', '陌生电话转账，可信吗67', '错', '这是假的67');
INSERT INTO `t_teststorage` VALUES ('67', '陌生电话转账，可信吗68', '对', '这是假的68');
INSERT INTO `t_teststorage` VALUES ('68', '陌生电话转账，可信吗69', '错', '这是假的69');
INSERT INTO `t_teststorage` VALUES ('69', '陌生电话转账，可信吗70', '对', '这是假的70');
INSERT INTO `t_teststorage` VALUES ('7', '陌生电话转账，可信吗8', '对', '这是假的8');
INSERT INTO `t_teststorage` VALUES ('70', '陌生电话转账，可信吗71', '错', '这是假的71');
INSERT INTO `t_teststorage` VALUES ('71', '陌生电话转账，可信吗72', '对', '这是假的72');
INSERT INTO `t_teststorage` VALUES ('72', '陌生电话转账，可信吗73', '错', '这是假的73');
INSERT INTO `t_teststorage` VALUES ('73', '陌生电话转账，可信吗74', '对', '这是假的74');
INSERT INTO `t_teststorage` VALUES ('74', '陌生电话转账，可信吗75', '错', '这是假的75');
INSERT INTO `t_teststorage` VALUES ('75', '陌生电话转账，可信吗76', '对', '这是假的76');
INSERT INTO `t_teststorage` VALUES ('76', '陌生电话转账，可信吗77', '错', '这是假的77');
INSERT INTO `t_teststorage` VALUES ('77', '陌生电话转账，可信吗78', '对', '这是假的78');
INSERT INTO `t_teststorage` VALUES ('78', '陌生电话转账，可信吗79', '错', '这是假的79');
INSERT INTO `t_teststorage` VALUES ('79', '陌生电话转账，可信吗80', '对', '这是假的80');
INSERT INTO `t_teststorage` VALUES ('8', '陌生电话转账，可信吗9', '错', '这是假的9');
INSERT INTO `t_teststorage` VALUES ('80', '陌生电话转账，可信吗81', '错', '这是假的81');
INSERT INTO `t_teststorage` VALUES ('81', '陌生电话转账，可信吗82', '对', '这是假的82');
INSERT INTO `t_teststorage` VALUES ('82', '陌生电话转账，可信吗83', '错', '这是假的83');
INSERT INTO `t_teststorage` VALUES ('83', '陌生电话转账，可信吗84', '对', '这是假的84');
INSERT INTO `t_teststorage` VALUES ('84', '陌生电话转账，可信吗85', '错', '这是假的85');
INSERT INTO `t_teststorage` VALUES ('85', '陌生电话转账，可信吗86', '对', '这是假的86');
INSERT INTO `t_teststorage` VALUES ('86', '陌生电话转账，可信吗87', '错', '这是假的87');
INSERT INTO `t_teststorage` VALUES ('87', '陌生电话转账，可信吗88', '对', '这是假的88');
INSERT INTO `t_teststorage` VALUES ('88', '陌生电话转账，可信吗89', '错', '这是假的89');
INSERT INTO `t_teststorage` VALUES ('89', '陌生电话转账，可信吗90', '对', '这是假的90');
INSERT INTO `t_teststorage` VALUES ('9', '陌生电话转账，可信吗10', '对', '这是假的10');
INSERT INTO `t_teststorage` VALUES ('90', '陌生电话转账，可信吗91', '错', '这是假的91');
INSERT INTO `t_teststorage` VALUES ('91', '陌生电话转账，可信吗92', '对', '这是假的92');
INSERT INTO `t_teststorage` VALUES ('92', '陌生电话转账，可信吗93', '错', '这是假的93');
INSERT INTO `t_teststorage` VALUES ('93', '陌生电话转账，可信吗94', '对', '这是假的94');
INSERT INTO `t_teststorage` VALUES ('94', '陌生电话转账，可信吗95', '错', '这是假的95');
INSERT INTO `t_teststorage` VALUES ('95', '陌生电话转账，可信吗96', '对', '这是假的96');
INSERT INTO `t_teststorage` VALUES ('96', '陌生电话转账，可信吗97', '错', '这是假的97');
INSERT INTO `t_teststorage` VALUES ('97', '陌生电话转账，可信吗98', '对', '这是假的98');
INSERT INTO `t_teststorage` VALUES ('98', '陌生电话转账，可信吗99', '错', '这是假的99');
INSERT INTO `t_teststorage` VALUES ('99', '陌生电话转账，可信吗100', '对', '这是假的100');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL COMMENT '用户编号',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `loginname` varchar(32) NOT NULL COMMENT '登陆账号',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `phone` varchar(64) NOT NULL COMMENT '电话',
  `sex` int NOT NULL COMMENT '性别',
  `birthday` varchar(64) NOT NULL COMMENT '出生日期',
  `statu` int DEFAULT '1' COMMENT '用户状态',
  `startTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `endTime` datetime DEFAULT NULL COMMENT '注销时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `loginname` (`loginname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('0', 'aaaa', 'root', '123456', '13575287979', '0', '2020-1-1', '1', '2020-07-09 10:51:31', null);
INSERT INTO `t_user` VALUES ('1', '李白', 'admin', 'admin', '987654321', '1', '2000-11-11', '1', '2020-07-08 17:01:13', null);
INSERT INTO `t_user` VALUES ('1594263718243991425', 'root1', 'root1', 'root', '13575287979', '1', '2020-12-2', '1', '2020-07-09 11:01:58', null);
INSERT INTO `t_user` VALUES ('2', 'zxc', 'zxc', '123456', '156494561', '1', '2020-11-11', '1', '2020-07-17 11:01:38', null);
INSERT INTO `t_user` VALUES ('3', '2', '2', '2', '2', '2', '2000-2-5', '1', '2020-07-22 10:35:46', null);
INSERT INTO `t_user` VALUES ('4', '4', '4', '4', '4', '4', '2002-5-02', '1', '2020-07-27 16:08:05', null);

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `userid` varchar(32) NOT NULL COMMENT '用户编号',
  `roleid` varchar(32) NOT NULL COMMENT '角色编号',
  KEY `userid` (`userid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `t_user_role_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_user_role_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('0', '2');

-- ----------------------------
-- Table structure for `t_vip`
-- ----------------------------
DROP TABLE IF EXISTS `t_vip`;
CREATE TABLE `t_vip` (
  `id` varchar(32) NOT NULL COMMENT '会员编号',
  `userid` varchar(32) NOT NULL COMMENT '用户编号',
  `score` varchar(32) DEFAULT '0' COMMENT '积分',
  PRIMARY KEY (`id`),
  UNIQUE KEY `vipuserid` (`userid`),
  CONSTRAINT `t_vip_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of t_vip
-- ----------------------------
INSERT INTO `t_vip` VALUES ('1', '0', '78');
INSERT INTO `t_vip` VALUES ('2', '1', '35');
INSERT INTO `t_vip` VALUES ('3', '1594263718243991425', '0');
