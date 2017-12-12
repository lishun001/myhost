-- MySQL dump 10.13  Distrib 5.6.23, for Linux (x86_64)
--
-- Host: localhost    Database: rshui_charge
-- ------------------------------------------------------
-- Server version	5.6.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acc_account`
--

DROP TABLE IF EXISTS `acc_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acc_account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_pid` int(11) DEFAULT NULL,
  `account_gameid` int(11) DEFAULT NULL,
  `account_areaid` int(11) DEFAULT NULL,
  `account_serverid` int(11) DEFAULT NULL,
  `account_currency` int(11) DEFAULT NULL,
  `account_points` int(11) DEFAULT NULL,
  `account_pointstrial` int(11) DEFAULT NULL,
  `account_deadline` int(11) DEFAULT NULL,
  `account_status` int(11) DEFAULT NULL COMMENT '1 - 正常\r\n            2 - 锁定（玩家自己锁定）\r\n            3 - 冻结（官方暂时冻结）\r\n            4 - 停封（官方永久封号）\r\n            9 - 删除',
  `account_isrmb` int(11) DEFAULT NULL COMMENT '1 - 是人民币充值玩家\r\n            2 - 非人民币玩家\r\n            ',
  `account_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='游戏账户表，由游戏服务器+通行证，形成一个账户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acc_account`
--

LOCK TABLES `acc_account` WRITE;
/*!40000 ALTER TABLE `acc_account` DISABLE KEYS */;
INSERT INTO `acc_account` VALUES (63,23423,8,3,3,2,11000,NULL,NULL,1,2,1425953465),(72,21,8,3,3,2,24000,NULL,NULL,1,2,1425868081);
/*!40000 ALTER TABLE `acc_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(50) DEFAULT NULL,
  `admin_pwd` varchar(50) DEFAULT NULL,
  `admin_status` int(11) DEFAULT NULL COMMENT '1 - 正常\r\n            2 - 锁定\r\n            9 - 删除',
  `admin_per1` varchar(100) DEFAULT NULL,
  `admin_per2` varchar(200) DEFAULT NULL,
  `admin_per3` varchar(300) DEFAULT NULL,
  `admin_realname` varchar(20) DEFAULT NULL,
  `admin_createtime` int(11) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','a24676a269f6bfa53827470c4ea8cf24',1,'2,3,5,6,8,7','2-1,3-1,3-2,5-1,5-2,6-1,6-2,8-1,8-2,8-3,8-4,7-1','2-1-1,2-1-2,3-1-1,3-1-2,3-1-3,3-1-4,3-1-5,3-1-6,3-2-1,3-2-2,3-2-3,3-2-4,5-1-1,5-2-1,6-1-1,6-1-2,6-1-3,6-1-4,6-2-1,8-1-1,8-1-2,8-2-1,8-2-2,8-3-1,8-3-2,8-4-1,8-4-2,7-1-1,7-1-2','管理员',1406186833);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(20) DEFAULT NULL,
  `game_des` varchar(200) DEFAULT NULL,
  `game_pic_url` varchar(100) DEFAULT NULL,
  `game_logo_url` varchar(100) DEFAULT NULL,
  `game_status` varchar(1) DEFAULT '1' COMMENT '1 - 正常\r\n            2 - 关闭（游戏下线）\r\n            3 - 冻结（官方暂时冻结）\r\n            9 - 删除',
  `game_key` varchar(32) DEFAULT NULL,
  `game_type` varchar(1) DEFAULT NULL COMMENT '1 - MMORPG\r\n            2 - 休闲游戏\r\n            3 - 网页游戏',
  `game_website` varchar(100) DEFAULT NULL,
  `game_currencyid` int(11) DEFAULT NULL COMMENT '详见币种表',
  `game_platform` varchar(100) DEFAULT NULL COMMENT '多个充值平台,以逗号分隔',
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='游戏信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (8,'盛唐剑侠录','123456789','../public/upload_images/game/20150210/fe6dffa1fe0fab4101faa3464abbc97b.png','../public/upload_images/game/20150210/2ffe70f92b97b4c460557ee4759b2a1d.png','1','--','1','http://sthero.com',NULL,'11,10,9,8,7,6');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_act`
--

DROP TABLE IF EXISTS `game_act`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_act` (
  `act_id` int(11) NOT NULL AUTO_INCREMENT,
  `act_pid` int(11) DEFAULT NULL,
  `act_gameid` int(11) DEFAULT NULL,
  `act_areaid` int(11) DEFAULT NULL,
  `act_serverid` int(11) DEFAULT NULL,
  `act_cardgift` int(11) DEFAULT NULL,
  `act_trialpoints` int(11) DEFAULT NULL,
  PRIMARY KEY (`act_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='激活记录表，每个通行证每款游戏只能有一次激活试用的机会';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_act`
--

LOCK TABLES `game_act` WRITE;
/*!40000 ALTER TABLE `game_act` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_act` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_actcode`
--

DROP TABLE IF EXISTS `game_actcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_actcode` (
  `actcode_id` int(11) NOT NULL AUTO_INCREMENT,
  `actcode_num` varchar(10) DEFAULT NULL,
  `actcode_pid` int(11) DEFAULT NULL,
  `actcode_gameid` int(11) DEFAULT '0',
  `actcode_status` int(11) DEFAULT '0' COMMENT '1 - 已激活\r\n            2 - 未激活',
  `actcode_account` varchar(20) DEFAULT NULL,
  `actcode_pwd` varchar(20) DEFAULT NULL,
  `actcode_out_status` int(11) DEFAULT '0' COMMENT '1 - 已发布\r\n            2 - 未发布',
  PRIMARY KEY (`actcode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='封测激活码';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_actcode`
--

LOCK TABLES `game_actcode` WRITE;
/*!40000 ALTER TABLE `game_actcode` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_actcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_area`
--

DROP TABLE IF EXISTS `game_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(20) DEFAULT NULL,
  `area_gameid` int(11) DEFAULT NULL,
  `area_status` int(11) DEFAULT NULL COMMENT '1 - 正常\r\n            2 - 关闭（分区下线）\r\n            3 - 冻结（官方暂时冻结）\r\n            4 - 维护中\r\n            9 - 删除',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='游戏分区';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_area`
--

LOCK TABLES `game_area` WRITE;
/*!40000 ALTER TABLE `game_area` DISABLE KEYS */;
INSERT INTO `game_area` VALUES (3,'分区1',8,1);
/*!40000 ALTER TABLE `game_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_login`
--

DROP TABLE IF EXISTS `game_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_userid` int(11) DEFAULT NULL,
  `login_gameid` int(11) DEFAULT NULL,
  `login_areaid` int(11) DEFAULT NULL,
  `login_serverid` int(11) DEFAULT NULL,
  `login_time` int(11) DEFAULT NULL,
  `login_type` int(11) DEFAULT NULL COMMENT '1 - 登录\r\n            2 - 登出',
  `login_sessionkey` varchar(32) DEFAULT NULL,
  `login_clientip` varchar(25) DEFAULT NULL,
  `login_clientport` int(11) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏登录日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_login`
--

LOCK TABLES `game_login` WRITE;
/*!40000 ALTER TABLE `game_login` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_loginsession`
--

DROP TABLE IF EXISTS `game_loginsession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_loginsession` (
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `session_key` varchar(32) NOT NULL,
  `session_pid` int(11) DEFAULT NULL,
  `session_serverid` int(11) DEFAULT NULL,
  `session_awake` int(11) DEFAULT NULL,
  `session_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏内通行证登录session记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_loginsession`
--

LOCK TABLES `game_loginsession` WRITE;
/*!40000 ALTER TABLE `game_loginsession` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_loginsession` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_role`
--

DROP TABLE IF EXISTS `game_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_role` (
  `role_id` int(11) NOT NULL COMMENT '与游戏中角色的ID一致',
  `role_pid` int(11) DEFAULT NULL,
  `role_gameid` int(11) DEFAULT NULL,
  `role_areaid` int(11) DEFAULT NULL,
  `role_serverid` int(11) DEFAULT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `role_area` varchar(1) DEFAULT NULL,
  `role_sex` varchar(1) DEFAULT NULL COMMENT '1 - 男\r\n            2 - 女',
  `role_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏中创建角色，同步一条消息到计费中心';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_role`
--

LOCK TABLES `game_role` WRITE;
/*!40000 ALTER TABLE `game_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_server`
--

DROP TABLE IF EXISTS `game_server`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_server` (
  `server_id` int(11) NOT NULL AUTO_INCREMENT,
  `server_sid` int(11) DEFAULT NULL,
  `server_name` varchar(20) DEFAULT NULL,
  `server_ip` varchar(15) DEFAULT NULL COMMENT '[限制服务器IP]\r\n            若有值则限制游戏服务器向\r\n            计费应用注册时的IP必须是此IP;\r\n            若为空则不限制',
  `server_areaid` int(11) DEFAULT NULL,
  `server_gameid` int(11) DEFAULT NULL,
  `server_status` int(11) DEFAULT NULL COMMENT '1 - 正常\r\n            2 - 关闭（服务器下线）\r\n            3 - 冻结（官方暂时冻结）\r\n            4 - 维护中\r\n            5 - 已合服\r\n            9 - 删除',
  `server_opentime` int(11) DEFAULT NULL,
  PRIMARY KEY (`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='游戏服务器';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_server`
--

LOCK TABLES `game_server` WRITE;
/*!40000 ALTER TABLE `game_server` DISABLE KEYS */;
INSERT INTO `game_server` VALUES (3,123,'服务器1','172.1.1.1',3,8,1,2015);
/*!40000 ALTER TABLE `game_server` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_cardtype`
--

DROP TABLE IF EXISTS `pay_cardtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_cardtype` (
  `cardtype_id` int(11) NOT NULL AUTO_INCREMENT,
  `cardtype_name` varchar(20) DEFAULT NULL,
  `cardtype_rmb` int(11) DEFAULT NULL,
  `cardtype_currencyid` int(11) DEFAULT NULL,
  `cardtype_points` int(11) DEFAULT NULL COMMENT '卡中所含此币种的金额\r\n            例: 币种为传奇点, 则2000表示2000传奇点',
  `cardtype_pfid` int(11) DEFAULT NULL,
  `cardtype_gameid` int(11) DEFAULT NULL,
  `cardtype_comment` varchar(255) DEFAULT NULL,
  `cardtype_status` int(11) DEFAULT NULL COMMENT '1 - 正常\r\n            2 - 锁定',
  `cardtype_ctime` int(11) DEFAULT NULL,
  PRIMARY KEY (`cardtype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='充值卡类型表详细';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_cardtype`
--

LOCK TABLES `pay_cardtype` WRITE;
/*!40000 ALTER TABLE `pay_cardtype` DISABLE KEYS */;
INSERT INTO `pay_cardtype` VALUES (4,'盛唐3000点30元',30,2,3000,6,8,'',1,1423532625),(5,'盛唐3000点30元',30,2,3000,9,8,'',1,1423532642),(6,'盛唐3000点30元',30,2,3000,8,8,'',1,1423532673),(7,'盛唐1000点10元',10,2,1000,6,8,'',1,1423532692),(8,'盛唐3000点30元',30,2,3000,7,8,'',1,1423795832),(9,'盛唐1000点10元',10,2,1000,10,8,'',1,1425867881),(10,'盛唐1000点10元',10,2,1000,11,8,'',1,1425893653);
/*!40000 ALTER TABLE `pay_cardtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_currency`
--

DROP TABLE IF EXISTS `pay_currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_currency` (
  `currency_id` int(11) NOT NULL AUTO_INCREMENT,
  `currency_code` varchar(1) DEFAULT NULL COMMENT '1 - 若水币\r\n            S - 传奇点',
  `currency_name` varchar(18) DEFAULT NULL COMMENT '如：\r\n            若水币\r\n            传奇点',
  `currency_units` varchar(15) DEFAULT NULL COMMENT '如：\r\n            100若水币\r\n            2000传奇点',
  `currency_type` int(11) DEFAULT NULL COMMENT '1 - 通用币种\r\n            2 - 游戏币种',
  `currency_status` int(11) DEFAULT NULL COMMENT '1 - 启用\r\n            2 - 禁用',
  `currency_note` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`currency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='计费货币定义';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_currency`
--

LOCK TABLES `pay_currency` WRITE;
/*!40000 ALTER TABLE `pay_currency` DISABLE KEYS */;
INSERT INTO `pay_currency` VALUES (2,'S','盛唐','点',2,1,'123456789123456789');
/*!40000 ALTER TABLE `pay_currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_log`
--

DROP TABLE IF EXISTS `pay_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_orderno` varchar(50) DEFAULT NULL,
  `log_pid` int(11) DEFAULT NULL,
  `log_accid` int(11) DEFAULT NULL,
  `log_pfid` int(11) DEFAULT NULL,
  `log_cardtypeid` int(11) DEFAULT NULL,
  `log_cardcount` int(11) DEFAULT NULL,
  `log_currencyid` int(11) DEFAULT NULL,
  `log_points` int(11) DEFAULT NULL,
  `log_rmb` int(11) DEFAULT NULL,
  `log_gameid` int(11) DEFAULT NULL,
  `log_areaid` int(11) DEFAULT NULL,
  `log_serverid` int(11) DEFAULT NULL,
  `log_clientip` varchar(15) DEFAULT NULL,
  `log_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='充值日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_log`
--

LOCK TABLES `pay_log` WRITE;
/*!40000 ALTER TABLE `pay_log` DISABLE KEYS */;
INSERT INTO `pay_log` VALUES (1,'100fc9da60f9ae9d6488451decdc0742',21,1,9,5,1,2,3000,0,8,3,3,'222.92.129.130',1425868081),(2,'0a6ba2015b149d525d80696217b5d2af',23423,8,10,9,1,NULL,1000,100,8,3,3,'222.92.129.130',1425953465),(3,'1d40fa75e6dbc9e8e5acc5f93d86f786',23423,9,9,5,1,NULL,3000,0,8,3,3,'222.92.129.130',1425953606),(4,'f7fbc4bafcc80cbf690acbef25f2ce1c',21,18,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1425974121),(5,'b4efd32afc6b7061329b4e82625789b9',21,19,6,4,1,NULL,3000,0,8,3,3,'222.92.129.130',1425975838),(6,'dfb50dda782963a0987410924c0553cc',21,16,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1425976984),(7,'c98831cde22c0529955a2218a2ed66bc',21,20,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1425977104),(8,'6bfc10d77ac1ba1ba5d25c409f1e4446',21,21,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1425977637),(9,'918d58be2384bacb0c9bfc0481364d1a',21,24,10,9,1,NULL,1000,100,8,3,3,'222.92.129.130',1425978897),(10,'7bbadfd20ac20bf891e24f1e16eb4eca',21,30,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1425981027),(11,'1c1d4df596d01da60385f0bb17a4a9e0',21,32,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1425981417),(12,'07811dc6c422334ce36a09ff5cd6fe71',21,31,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1425982095),(13,'83ef7034f70988833d42619038c03638',21,33,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1425982304),(14,'fb4d66331c887d230d709259df335c48',21,40,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1425995401),(15,'b97f138920c54acf5eb77d23bc318b12',21,41,6,7,1,NULL,1000,0,8,3,3,'222.92.129.130',1426036602),(16,'cdcd8f28ccc4334ee689906332eb2d65',21,47,10,9,1,NULL,1000,100,8,3,3,'222.92.129.130',1426039728),(17,'4ddb79b7e161290e9ba79795e7575d2c',23423,48,6,4,1,NULL,3000,0,8,3,3,'222.92.129.130',1426040380),(18,'59de94365f4ef7f0b91362ae9afe4932',23423,49,10,9,1,NULL,1000,0,8,3,3,'222.92.129.130',1426040484),(19,'423891b0faa1bd883c88dbfaf1e22b6d',21,62,8,6,1,NULL,3000,0,8,3,3,'222.92.129.130',1426044318),(20,'9b919c23d10644f99c0313a41316e90e',23423,63,8,6,1,NULL,3000,0,8,3,3,'222.92.129.130',1426044452),(21,'04afba9bf35b9da73ad272f6fe9f0e5f',21,70,11,10,1,NULL,1000,100,8,3,3,'222.92.129.130',1426050989),(22,'00c7bd7f87376706365f2e2c94f58e4a',21,71,11,10,1,NULL,1000,100,8,3,3,'222.92.129.130',1426051125),(23,'8d9aa1e40909b42b758c822003c4b983',21,72,11,10,1,NULL,1000,100,8,3,3,'222.92.129.130',1426053655);
/*!40000 ALTER TABLE `pay_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_order`
--

DROP TABLE IF EXISTS `pay_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(50) DEFAULT NULL,
  `order_pid` int(11) DEFAULT NULL,
  `order_pfid` int(11) DEFAULT NULL,
  `order_no_other` varchar(50) DEFAULT NULL,
  `order_cardtypeid` int(11) DEFAULT NULL,
  `order_cardcount` int(11) DEFAULT NULL,
  `order_currencyid` int(11) DEFAULT NULL,
  `order_points` int(11) DEFAULT NULL COMMENT '订单点数= 充值卡类型点数* 充值数量',
  `order_rmb` int(11) DEFAULT NULL COMMENT '订单人民币价格 = 充值卡类型单价 * 充值数量',
  `order_gameid` int(11) DEFAULT NULL COMMENT '如果充入中心，此处为0；\r\n            如果充入游戏，则存储的是游戏ID',
  `order_areaid` int(11) DEFAULT NULL COMMENT '如果充入中心，此处为0；\r\n            如果充入分区，则存储的是分区ID',
  `order_serverid` int(11) DEFAULT NULL COMMENT '如果充入中心，此处为0；\r\n            如果充入服务器，则存储的是服务器ID',
  `order_clientip` varchar(15) DEFAULT NULL,
  `order_paystatus` int(11) DEFAULT NULL COMMENT '1 - 支付成功\r\n            2 - 支付失败\r\n            3 - 未支付',
  `order_notifystatus` int(11) DEFAULT NULL COMMENT '1 - 已回调\r\n            2 - 未回调',
  `order_notifymsg` varchar(50) DEFAULT NULL COMMENT '充值失败，回调时提示的错误信息记录在这里',
  `order_chargestatus` int(11) DEFAULT NULL COMMENT '1 - 充值成功\r\n            2  -充值失败',
  `order_ctime` int(11) DEFAULT NULL,
  `order_etime` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COMMENT='充值订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_order`
--

LOCK TABLES `pay_order` WRITE;
/*!40000 ALTER TABLE `pay_order` DISABLE KEYS */;
INSERT INTO `pay_order` VALUES (1,'100fc9da60f9ae9d6488451decdc0742',21,9,'H1503098958721AO',5,1,2,3000,0,8,3,3,'222.92.129.130',1,1,NULL,1,1425868004,1425868081),(2,'5604c82ce88f84958ff32d850f4edeb0',21,8,'316261290633803I',6,1,2,3000,0,8,3,3,'222.92.129.130',2,1,'1425870109',2,1425870028,1425878635),(3,'ad01564d8f0f4da5627726cc96f717d6',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425893693,NULL),(4,'b7cf1dbb51db462f3ad750d65d42a3a6',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425893716,NULL),(5,'f2169fa8be6ba030c53e9f81c47c1d99',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425951519,NULL),(6,'c28cccd4486efb636bd7d753ca52d487',23423,6,NULL,4,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425953307,NULL),(7,'3fd7d338bed9d331284813efc8c1a11f',23423,7,NULL,8,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425953349,NULL),(8,'0a6ba2015b149d525d80696217b5d2af',23423,10,'1828784132',9,1,2,1000,100,8,3,3,'222.92.129.130',1,1,NULL,1,1425953414,1425953465),(9,'1d40fa75e6dbc9e8e5acc5f93d86f786',23423,9,'H1503109076734AP',5,1,2,3000,0,8,3,3,'222.92.129.130',1,1,NULL,1,1425953565,1425953606),(10,'0125141592fa9ededc665c55d9958f69',23423,8,NULL,6,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425954527,NULL),(11,'fde23969ce435f4c01abd70ef3bd8459',21,6,NULL,7,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425963998,NULL),(12,'e81833b12b59583bc368427e683902c8',21,6,NULL,4,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425964087,NULL),(13,'e4e9251ca67cd942c5dc96d3e41328ec',21,6,NULL,7,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425966083,NULL),(14,'68e67b29a124ed34cb6cbf12a5761626',21,6,'2015031000001000490049436825',7,1,2,1000,0,8,3,3,'222.92.129.130',2,1,'TRADE_SUCCESS',2,1425967713,1425972938),(15,'91e1fea50842570d5b4bd4bc2d23364b',21,6,NULL,7,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425971877,NULL),(16,'dfb50dda782963a0987410924c0553cc',21,6,'2015031000001000490049442388',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425971953,1425976984),(17,'a1f9513519c13d552200e7f1e735552a',21,6,NULL,7,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425973855,NULL),(18,'f7fbc4bafcc80cbf690acbef25f2ce1c',21,6,'2015031000001000490049445053',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425973881,1425974121),(19,'b4efd32afc6b7061329b4e82625789b9',21,6,'2015031000001000490049447969',4,1,2,3000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425975802,1425975838),(20,'c98831cde22c0529955a2218a2ed66bc',21,6,'2015031000001000490049450001',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425977061,1425977104),(21,'6bfc10d77ac1ba1ba5d25c409f1e4446',21,6,'2015031000001000490049450434',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425977348,1425977637),(22,'1094c88c1ac5183d7c3504af182ec7d4',21,8,NULL,6,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425978515,NULL),(23,'ceba9dbb88494fa1153e10fda8a3534e',21,8,NULL,6,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425978573,NULL),(24,'918d58be2384bacb0c9bfc0481364d1a',21,10,'1829420485',9,1,2,1000,100,8,3,3,'222.92.129.130',1,1,NULL,1,1425978767,1425978897),(25,'97f7ffc895cd5ec8e787e65de72a17db',21,10,NULL,9,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425979119,NULL),(26,'4e900c079b0e63b9eb75a8200b5b7bc8',21,10,NULL,9,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425979160,NULL),(27,'30b9da0acd32a31d856d3c3dc0be7bbc',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425979538,NULL),(28,'1ae8c2042444fcdd73f3db27ed2e0088',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425979577,NULL),(29,'005f4666bf5b2ac98530f20c67b5ab52',21,10,NULL,9,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425980324,NULL),(30,'7bbadfd20ac20bf891e24f1e16eb4eca',21,6,'2015031000001000490049456479',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425980992,1425981027),(31,'07811dc6c422334ce36a09ff5cd6fe71',21,6,'2015031000001000490049456875',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425981207,1425982095),(32,'1c1d4df596d01da60385f0bb17a4a9e0',21,6,'2015031000001000490049457141',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425981387,1425981417),(33,'83ef7034f70988833d42619038c03638',21,6,'2015031000001000490049458710',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425982265,1425982303),(34,'f2a58d530f82792e08c9ffb0e7f0ee1f',21,6,NULL,4,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425982367,NULL),(35,'a562fd35af2738ce6d88f785ef4eb134',21,6,NULL,4,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425982508,NULL),(36,'56eebbaa467fa788a76627771be06ecd',21,6,NULL,4,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425982542,NULL),(37,'9d5951f159af474d003c9fc6f35af462',21,6,NULL,7,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425982749,NULL),(38,'cf8377e918bc9ca5e173d0226382e338',21,6,NULL,4,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425983107,NULL),(39,'bf67344c13760af0965e04a76c3b8b33',21,6,NULL,7,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1425983119,NULL),(40,'fb4d66331c887d230d709259df335c48',21,6,'2015031000001000490049460116',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1425983182,1425995401),(41,'b97f138920c54acf5eb77d23bc318b12',21,6,'2015031100001000490049498190',7,1,2,1000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1426036568,1426036602),(42,'b3c547f27742cb371687bbbc75083be9',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426036836,NULL),(43,'bbcbff5c1f1ded46c25d28119a85c6c2',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426036865,NULL),(44,'3f0a0342bb2d3754e3ecc229e65613fa',21,10,NULL,9,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426038556,NULL),(45,'e1508a958e7df0833ae54777d6475b9e',21,10,NULL,9,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426038576,NULL),(46,'aa34ac274b2e734f35fe9a94b813ba3d',21,10,NULL,9,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426039454,NULL),(47,'cdcd8f28ccc4334ee689906332eb2d65',21,10,'1829963678',9,1,2,1000,100,8,3,3,'222.92.129.130',1,1,NULL,1,1426039543,1426039728),(48,'4ddb79b7e161290e9ba79795e7575d2c',23423,6,'2015031100001000140045564931',4,1,2,3000,0,8,3,3,'222.92.129.130',1,1,'TRADE_SUCCESS',1,1426040340,1426040380),(49,'59de94365f4ef7f0b91362ae9afe4932',23423,10,'1829980601',9,1,2,1000,0,8,3,3,'222.92.129.130',1,1,NULL,1,1426040429,1426040484),(50,'47690b8effa8edb37dae4deca8d62625',23423,8,NULL,6,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426040567,NULL),(51,'fa14d4fe2f19414de3ebd9f63d5c0169',21,8,NULL,6,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426040737,NULL),(52,'b8c2fd56055d3121265f85174035d0b8',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426041235,NULL),(53,'cd59de82b4cc82041ee8eb1b43549ba9',21,10,NULL,9,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426041306,NULL),(54,'e4fe67535fb25d774b08d9e867bb7ab9',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426041325,NULL),(55,'7cf95027b7c8588914945e2b5e066a44',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426041656,NULL),(56,'ebed2b72dc9f9f860648bdf933150755',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426041969,NULL),(57,'ac0071f018d6ac7568394853c44cef1f',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426042209,NULL),(58,'1c306af2c60ae2b7285feeacb7afb1e1',21,8,NULL,6,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426042682,NULL),(59,'5686481c8ce0beb89dd17fed45e5eddf',21,8,NULL,6,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426042725,NULL),(60,'0c5255109ec058ea67a4141fe5f99efb',21,8,NULL,6,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426042760,NULL),(61,'0fe47dbb289a999610c8c5ab9aeb2107',21,8,NULL,6,1,2,3000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426043284,NULL),(62,'423891b0faa1bd883c88dbfaf1e22b6d',21,8,'818183878972452E',6,1,2,3000,0,8,3,3,'222.92.129.130',1,1,NULL,1,1426044065,1426044318),(63,'9b919c23d10644f99c0313a41316e90e',23423,8,'868527912442162I',6,1,2,3000,0,8,3,3,'222.92.129.130',1,1,NULL,1,1426044407,1426044452),(64,'624be6e34355719afee744791897d442',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426044603,NULL),(65,'05d111949b45d683e499e7bdfb3e1e92',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426044629,NULL),(66,'3b6fe2dc98ceed6e1608e7cfc662ab11',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426044710,NULL),(67,'21b1a8129e987682b9ee28f6eaf36a0f',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426044764,NULL),(68,'dd24bf1f94c244e91a4a783a50f36b6f',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426050345,NULL),(69,'b56ef98bf183188e1fbd8e57904a54f9',21,11,NULL,10,1,2,1000,0,8,3,3,'222.92.129.130',3,2,NULL,NULL,1426050688,NULL),(70,'04afba9bf35b9da73ad272f6fe9f0e5f',21,11,'313686',10,1,2,1000,100,8,3,3,'222.92.129.130',1,1,'Success!',1,1426050972,1426050989),(71,'00c7bd7f87376706365f2e2c94f58e4a',21,11,'313687',10,1,2,1000,100,8,3,3,'222.92.129.130',1,1,'Success!',1,1426051105,1426051125),(72,'8d9aa1e40909b42b758c822003c4b983',21,11,'313772',10,1,2,1000,100,8,3,3,'222.92.129.130',1,1,'Success!',1,1426053635,1426053655);
/*!40000 ALTER TABLE `pay_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_platform`
--

DROP TABLE IF EXISTS `pay_platform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_platform` (
  `platform_id` int(11) NOT NULL AUTO_INCREMENT,
  `platform_name` varchar(20) DEFAULT NULL,
  `platform_classname` varchar(20) DEFAULT NULL,
  `platform_type` int(11) DEFAULT NULL COMMENT '0 - 官方直充\r\n            1 - 网银支付\r\n            2 - 代理直充\r\n            3 - 移动联通代理\r\n            4 - 手机短信\r\n            5 - 电话充值',
  `platform_pwd` varchar(50) DEFAULT NULL,
  `platform_key` varchar(100) DEFAULT NULL,
  `platform_payurl` varchar(150) DEFAULT NULL,
  `platform_returnurl` varchar(150) DEFAULT NULL COMMENT '同步返回地址（前端显示）',
  `platform_notifyurl` varchar(150) DEFAULT NULL COMMENT '异步回调地址（后端处理）',
  `platform_checkurl` varchar(150) DEFAULT NULL COMMENT '用于我方程序传入订单号\r\n            验证订单是否支付成功。\r\n            (当支付成功且发意外时用)',
  `platform_limitip` varchar(300) DEFAULT NULL COMMENT '限制对方请求调用的IP地址\r\n            可以为空，即不限制；\r\n            限制多个时候，以英文逗号分隔',
  `platform_status` int(11) DEFAULT NULL COMMENT '1 - 正常\r\n            2 - 锁定\r\n            9 - 删除',
  `platform_ctime` int(11) DEFAULT NULL,
  `platform_note` varchar(255) DEFAULT NULL,
  `platform_userid` varchar(20) DEFAULT NULL,
  `platform_passwd` varchar(50) DEFAULT NULL,
  `platform_msgurl` varchar(150) DEFAULT NULL,
  `platform_msguser` varchar(50) DEFAULT NULL,
  `platform_msgpwd` varchar(50) DEFAULT NULL,
  `platform_logo` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`platform_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='充值平台表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_platform`
--

LOCK TABLES `pay_platform` WRITE;
/*!40000 ALTER TABLE `pay_platform` DISABLE KEYS */;
INSERT INTO `pay_platform` VALUES (6,'支付宝','zfb',3,'C4E01984E6E0C43B2E12B08E9EE74C63','192lji5p5tov519ixupkuxph3fs80ey9','https://mapi.alipay.com/gateway.do?','zfb/callback','zfb/notify','--','',1,1423531968,'','2088411970822321','WANGhaiqiu1129.','https://mapi.alipay.com','suzhouruoshui@163.com','ZUOzilong17089.','../public/upload_images/platform/20150210/a8532a0603e2cc6995f7c4b456d683d7.png'),(7,'财付通','cft',3,'C4E01984E6E0C43B2E12B08E9EE74C63','85bfb11ce7544d03f6f79a0d200d5b02','https://gw.tenpay.com/gateway/pay.htm','cft/callback','cft/notify','https://gw.tenpay.com/gateway/simpleverifynotifyid.xml','',1,1423532059,'','1219527401','','http://mch.tenpay.com/','1219527401','ZUOzilong17089.','../public/upload_images/platform/20150303/ab3d09fb828406b380ba21b21aac043d.png'),(8,'易宝','yb',3,'C4E01984E6E0C43B2E12B08E9EE74C63','69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl','https://www.yeepay.com/app-merchant-proxy/node','yb','yb','--','',1,1423532199,'','10001126856','','http://www.yeepay.com','suzhouruoshui@163.com','2013ruoshuikeji','../public/upload_images/platform/20150210/3eade24cdfc3e6ae5b8ef58af753e248.png'),(9,'汇付宝','hfb',3,'C4E01984E6E0C43B2E12B08E9EE74C63','3C7522C5301C437580A5A85E','https://pay.heepay.com/Payment/Index.aspx','hfb/callback','hfb/notify','','',1,1423532334,'','1761805','2014RSkeji','http://www.heepay.com','suzhouruoshui@163.com','2013ruoshuikeji','../public/upload_images/platform/20150210/6b2593ec764fad8fd0fab28d8841c53e.png'),(10,'快钱','kq',3,'3C7522C5301C437580A5A85E','','https://www.99bill.com/gateway/recvMerchantInfoAction.htm','kq/callback','kq/notify','','',1,1423532392,'','1002362643601','','http://www.99bill.com','suzhouruoshui@163.com','2013ruoshuikeji','../public/upload_images/platform/20150309/3ac4b729e30590a7f5ca2ae29ff41c3a.png'),(11,'银联','yl',3,'3C7522C5301C437580A5A85E','88888888','https://www.epay.lxdns.com/UpopWeb/api/Pay.action','yl/callback','yl/notify','','',1,1425893642,'','898320548160151','','https://online.unionpay.com/omer/','admin','111111','../public/upload_images/platform/20150310/3c49b4a3b727711e70a1acb6ff93472b.png');
/*!40000 ALTER TABLE `pay_platform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pf_faq`
--

DROP TABLE IF EXISTS `pf_faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pf_faq` (
  `faq_id` int(11) NOT NULL AUTO_INCREMENT,
  `faq_title` varchar(50) DEFAULT NULL,
  `faq_content` text,
  `faq_caid` int(11) DEFAULT NULL COMMENT '1 - 游戏问题\r\n            2 - 平台问题',
  `faq_subcaid` int(11) DEFAULT NULL COMMENT '1 - 为技术支持\r\n            2 - 为充值相关\r\n            3 - 为账号安全',
  `faq_gameid` int(11) DEFAULT NULL,
  `faq_adminid` int(11) DEFAULT NULL,
  `faq_time` int(11) DEFAULT NULL,
  `faq_status` int(11) DEFAULT NULL COMMENT '1 - 正常\r\n            2 - 锁定\r\n            9 - 删除',
  `faq_ifelite` int(11) DEFAULT NULL COMMENT '1 - hot',
  PRIMARY KEY (`faq_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='通行证平台常见问题';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pf_faq`
--

LOCK TABLES `pf_faq` WRITE;
/*!40000 ALTER TABLE `pf_faq` DISABLE KEYS */;
INSERT INTO `pf_faq` VALUES (5,'如何注册通行证','如何注册通行证如何注册通行证如何注册通行证如何注册通行证如何注册通行证',1,NULL,8,1,1423531391,1,1),(6,'在哪下载盛唐剑侠','在哪下载盛唐剑侠在哪下载盛唐剑侠在哪下载盛唐剑侠在哪下载盛唐剑侠',1,NULL,8,1,1423531419,1,1),(7,'盛唐','盛唐盛唐盛唐盛唐盛唐',1,NULL,8,1,1423531432,1,NULL),(8,'通行证使用','通行证使用通行证使用通行证使用通行证使用',2,1,NULL,1,1423531451,1,NULL),(9,'平台好不好','平台好不好平台好不好平台好不好平台好不好平台好不好',2,1,NULL,1,1423531472,1,NULL),(10,'如何充值','如何充值如何充值如何充值如何充值',2,2,NULL,1,1423531487,1,1),(11,'充值成功','充值成功充值成功充值成功',2,2,NULL,1,1423531504,1,NULL),(12,'找回通行证','找回通行证找回通行证找回通行证找回通行证',2,3,NULL,1,1423531518,1,1);
/*!40000 ALTER TABLE `pf_faq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pf_feedback`
--

DROP TABLE IF EXISTS `pf_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pf_feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_type` int(11) NOT NULL,
  `feedback_gameid` int(11) DEFAULT NULL,
  `feedback_title` varchar(50) DEFAULT NULL,
  `feedback_pic` varchar(50) DEFAULT NULL,
  `feedback_content` varchar(200) DEFAULT NULL,
  `feedback_uname` varchar(20) DEFAULT NULL,
  `feedback_uemail` varchar(20) DEFAULT NULL,
  `feedback_time` int(11) DEFAULT NULL,
  `feedback_phone` varchar(11) DEFAULT NULL,
  `feedback_areaid` int(11) DEFAULT NULL,
  `feedback_serverid` int(11) DEFAULT NULL,
  `feedback_rolename` varchar(20) DEFAULT NULL,
  `feedback_create_time` int(11) DEFAULT NULL,
  `feedback_status` int(11) NOT NULL DEFAULT '0' COMMENT '1 - 正常\r\n            9 - 删除\r\n            ',
  `feedback_note` varchar(200) DEFAULT NULL,
  `feedback_dispose` int(11) NOT NULL DEFAULT '0' COMMENT '1 - 已处理\r\n            2 - 处理中\r\n            3 - 未处理',
  `feedback_disposer` varchar(20) NOT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='通行证平台问题反馈';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pf_feedback`
--

LOCK TABLES `pf_feedback` WRITE;
/*!40000 ALTER TABLE `pf_feedback` DISABLE KEYS */;
INSERT INTO `pf_feedback` VALUES (2,1,NULL,'平台问题',NULL,'平台问题平台问题平台问题','平台问题','844596330@qq.com',1423497600,'13012345678',NULL,NULL,'',1423548844,1,NULL,3,''),(3,2,NULL,'游戏问题',NULL,'逗逼逗逼逗逼逗逼逗逼逗逼','逗逼','844596330@qq.com',1423497600,'13012345678',NULL,NULL,'逗逼',1423548882,1,NULL,3,'');
/*!40000 ALTER TABLE `pf_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pf_news`
--

DROP TABLE IF EXISTS `pf_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pf_news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(50) DEFAULT NULL,
  `news_des` varchar(300) DEFAULT NULL,
  `news_content` text,
  `news_time` int(11) DEFAULT NULL,
  `news_adminid` int(11) DEFAULT NULL,
  `news_gameid` int(11) DEFAULT NULL,
  `news_caid` int(11) DEFAULT NULL,
  `news_status` int(11) DEFAULT '1' COMMENT '1 - 正常\r\n            2 - 锁定\r\n            9 - 删除',
  `news_publishtime` int(11) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='通行证平台新闻';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pf_news`
--

LOCK TABLES `pf_news` WRITE;
/*!40000 ALTER TABLE `pf_news` DISABLE KEYS */;
INSERT INTO `pf_news` VALUES (8,'盛唐剑侠录开启封测','盛唐剑侠录开启封测盛唐剑侠录开启封测盛唐剑侠录开启封测盛唐剑侠录开启封测盛唐剑侠录开启封测','盛唐剑侠录开启封测盛唐剑侠录开启封测盛唐剑侠录开启封测',1423531346,1,8,NULL,1,1423497600);
/*!40000 ALTER TABLE `pf_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pp_fcm_totaltime`
--

DROP TABLE IF EXISTS `pp_fcm_totaltime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pp_fcm_totaltime` (
  `fcm_id` int(11) NOT NULL AUTO_INCREMENT,
  `fcm_pid` int(11) DEFAULT NULL,
  `fcm_gameid` int(11) DEFAULT NULL,
  `fcm_onlinetime` int(11) DEFAULT NULL,
  `fcm_offlinetime` int(11) DEFAULT NULL,
  `fcm_logintime` int(11) DEFAULT NULL,
  `fcm_logouttime` int(11) DEFAULT NULL,
  PRIMARY KEY (`fcm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='防沉迷累计时间记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pp_fcm_totaltime`
--

LOCK TABLES `pp_fcm_totaltime` WRITE;
/*!40000 ALTER TABLE `pp_fcm_totaltime` DISABLE KEYS */;
/*!40000 ALTER TABLE `pp_fcm_totaltime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pp_passport`
--

DROP TABLE IF EXISTS `pp_passport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pp_passport` (
  `passport_pid` int(11) NOT NULL AUTO_INCREMENT,
  `passport_name` varchar(20) DEFAULT NULL,
  `passport_email` varchar(30) DEFAULT NULL,
  `passport_phone` varchar(11) DEFAULT NULL,
  `passport_pwd` varchar(32) DEFAULT NULL,
  `passport_flag` varchar(1) DEFAULT NULL COMMENT '1 - 已成年\r\n            2 - 未成年',
  `passport_identity` varchar(20) DEFAULT NULL,
  `passport_gmlevel` varchar(2) DEFAULT NULL COMMENT '0 - 普通账号\r\n            >0 - GM账号（等级）',
  `passport_status` varchar(1) DEFAULT NULL COMMENT '1 - 正常\r\n            2 - 锁定（玩家自己锁定）\r\n            3 - 冻结（官方暂时冻结）\r\n            4 - 停封（官方永久封号）\r\n            9 - 删除',
  PRIMARY KEY (`passport_pid`)
) ENGINE=InnoDB AUTO_INCREMENT=23424 DEFAULT CHARSET=utf8 COMMENT='通行证账号用户名密码验证';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pp_passport`
--

LOCK TABLES `pp_passport` WRITE;
/*!40000 ALTER TABLE `pp_passport` DISABLE KEYS */;
INSERT INTO `pp_passport` VALUES (15,'ceshi01','2533037475@qq.com',NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,NULL,'0','1'),(21,'了缺','844596330@qq.com',NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,NULL,'0','1'),(23423,'王艺强','wangyq@126.com',NULL,'25f9e794323b453885f5181f1b624d0b',NULL,NULL,'0','1');
/*!40000 ALTER TABLE `pp_passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pp_security`
--

DROP TABLE IF EXISTS `pp_security`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pp_security` (
  `security_pid` int(11) NOT NULL,
  `security_mb1` int(11) DEFAULT NULL COMMENT '密保问题id（通过配置文件设置）',
  `security_ans1` varchar(50) DEFAULT NULL,
  `security_mb2` int(11) DEFAULT NULL,
  `security_ans2` varchar(50) DEFAULT NULL,
  `security_mb3` int(11) DEFAULT NULL,
  `security_ans3` varchar(50) DEFAULT NULL,
  `security_phoneauthed` varchar(1) DEFAULT NULL COMMENT '1 - 通过\r\n            2 - 未通过',
  `security_lasttime` int(11) DEFAULT NULL,
  PRIMARY KEY (`security_pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='密保相关';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pp_security`
--

LOCK TABLES `pp_security` WRITE;
/*!40000 ALTER TABLE `pp_security` DISABLE KEYS */;
INSERT INTO `pp_security` VALUES (21,8,'1',9,'2',10,'3',NULL,1423547678);
/*!40000 ALTER TABLE `pp_security` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pp_user`
--

DROP TABLE IF EXISTS `pp_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pp_user` (
  `user_pid` int(11) NOT NULL,
  `user_realname` varchar(20) DEFAULT NULL,
  `user_idcardnum` varchar(20) DEFAULT NULL,
  `user_address` varchar(50) DEFAULT NULL,
  `user_birth` varchar(10) DEFAULT NULL,
  `user_income` int(11) DEFAULT NULL COMMENT '（通过配置文件设置）',
  `user_profession` int(11) DEFAULT NULL,
  `user_sex` int(11) DEFAULT NULL,
  `user_edu` int(11) DEFAULT NULL,
  `user_balance` int(11) DEFAULT NULL,
  `user_time` int(11) DEFAULT NULL,
  `user_lasttime` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号资料';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pp_user`
--

LOCK TABLES `pp_user` WRITE;
/*!40000 ALTER TABLE `pp_user` DISABLE KEYS */;
INSERT INTO `pp_user` VALUES (8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423534287,1423534287),(9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423537725,1423537725),(10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423538538,1423538538),(11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423538659,1423538659),(12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423538882,1423538882),(13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423539022,1423539022),(14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423539110,1423539110),(15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423544915,1423544915),(16,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423546816,1423546816),(17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423546965,1423546965),(18,'','','','',NULL,NULL,NULL,NULL,NULL,1423547070,1423547070),(19,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423547283,1423547283),(20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1423547429,1423547429),(21,'马祖强','320522198610313917','123456789','2015-02-21',1,16,1,4,NULL,1423547526,1423547638),(23423,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1425431106,1425431106);
/*!40000 ALTER TABLE `pp_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pp_userreg`
--

DROP TABLE IF EXISTS `pp_userreg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pp_userreg` (
  `userreg_id` int(11) NOT NULL AUTO_INCREMENT,
  `userreg_name` varchar(20) DEFAULT NULL,
  `userreg_email` varchar(30) DEFAULT NULL,
  `userreg_pwd` varchar(50) DEFAULT NULL,
  `userreg_key` varchar(50) DEFAULT NULL,
  `userreg_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`userreg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='注册账号，激活之前存入该表\r\n激活之后或超时则删除相应记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pp_userreg`
--

LOCK TABLES `pp_userreg` WRITE;
/*!40000 ALTER TABLE `pp_userreg` DISABLE KEYS */;
/*!40000 ALTER TABLE `pp_userreg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-17 13:58:50
