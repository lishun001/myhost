/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.6.38-log : Database - qvod
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qvod` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `qvod`;

/*Table structure for table `qvod_admin_users` */

DROP TABLE IF EXISTS `qvod_admin_users`;

CREATE TABLE `qvod_admin_users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `role` int(11) DEFAULT '0',
  `role_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_users_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_adverts` */

DROP TABLE IF EXISTS `qvod_adverts`;

CREATE TABLE `qvod_adverts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '标题',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '描述',
  `service` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '使用方  ios  android web  h5 ',
  `position` tinyint(2) DEFAULT '1' COMMENT '显示位置  1 会员  2 播放',
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '跳转地址',
  `thumb_img_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '图片地址',
  `type` tinyint(2) DEFAULT '1' COMMENT '分类  1 点播  2 直播',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `rank` int(5) DEFAULT '255' COMMENT '权重排序',
  `status` tinyint(3) DEFAULT '8' COMMENT '状态 0 删除 7 禁用 8 启用',
  `admin_id` int(6) DEFAULT NULL COMMENT '管理员ID',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='广告表';

/*Table structure for table `qvod_banners` */

DROP TABLE IF EXISTS `qvod_banners`;

CREATE TABLE `qvod_banners` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `rank` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `thumb_img_url` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '跳转链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_categories` */

DROP TABLE IF EXISTS `qvod_categories`;

CREATE TABLE `qvod_categories` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `identifier` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL DEFAULT '8',
  `rank` int(11) NOT NULL DEFAULT '255',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `thumb` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_online` tinyint(3) DEFAULT '0' COMMENT '是否启用 0  在线  -1 下线',
  PRIMARY KEY (`id`),
  UNIQUE KEY `categories_identifier_unique` (`identifier`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_channels` */

DROP TABLE IF EXISTS `qvod_channels`;

CREATE TABLE `qvod_channels` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `profit` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `comment` varchar(2000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `idlist` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `profit_amount` decimal(10,2) DEFAULT NULL COMMENT '分成起始金额',
  `divided` int(5) NOT NULL COMMENT '分成比例',
  PRIMARY KEY (`id`),
  UNIQUE KEY `channels_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_configs` */

DROP TABLE IF EXISTS `qvod_configs`;

CREATE TABLE `qvod_configs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `alias_name` varchar(255) DEFAULT NULL COMMENT '别名大写英文',
  `description` text COMMENT '描述',
  `content` text COMMENT '内容',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人',
  `modifier_id` int(11) DEFAULT NULL COMMENT '修改人',
  `rank` int(11) DEFAULT NULL COMMENT '权重排序',
  `status` tinyint(3) DEFAULT '8' COMMENT '状态 0 删除  7关闭  8 正常',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='配置表';

/*Table structure for table `qvod_constellation` */

DROP TABLE IF EXISTS `qvod_constellation`;

CREATE TABLE `qvod_constellation` (
  `id` smallint(3) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` char(6) DEFAULT NULL COMMENT '星座名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='星座表';

/*Table structure for table `qvod_install_logs` */

DROP TABLE IF EXISTS `qvod_install_logs`;

CREATE TABLE `qvod_install_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifier` varchar(255) DEFAULT NULL COMMENT '设备号',
  `os` varchar(32) DEFAULT NULL COMMENT '来源 IOS 安卓',
  `channel` varchar(128) DEFAULT NULL COMMENT '渠道来源',
  `created_at` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `times` (`created_at`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10277 DEFAULT CHARSET=latin1 COMMENT='安装记录表';

/*Table structure for table `qvod_menus` */

DROP TABLE IF EXISTS `qvod_menus`;

CREATE TABLE `qvod_menus` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `group` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sort` smallint(6) NOT NULL DEFAULT '255',
  `perm_id` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_migrations` */

DROP TABLE IF EXISTS `qvod_migrations`;

CREATE TABLE `qvod_migrations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_news` */

DROP TABLE IF EXISTS `qvod_news`;

CREATE TABLE `qvod_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增ID',
  `title` varchar(255) DEFAULT NULL COMMENT '消息标题',
  `url` varchar(128) DEFAULT NULL COMMENT '跳转链接',
  `admin_id` int(6) DEFAULT NULL COMMENT '创建人',
  `rank` int(3) NOT NULL DEFAULT '255' COMMENT '排序权重',
  `status` tinyint(2) DEFAULT '8' COMMENT '0 删除   8 正常',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='广播新闻表';

/*Table structure for table `qvod_orders` */

DROP TABLE IF EXISTS `qvod_orders`;

CREATE TABLE `qvod_orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `title` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `out_trade_no` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pay_info` varchar(4096) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pay_method` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `item_id` int(11) NOT NULL DEFAULT '0',
  `item_info` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `channel` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '使用支付渠道 ',
  `pay_channel` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付渠道',
  PRIMARY KEY (`id`),
  KEY `o_no` (`out_trade_no`),
  KEY `orders_user_id_index` (`user_id`),
  KEY `times` (`created_at`),
  KEY `order_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=122190 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_pays` */

DROP TABLE IF EXISTS `qvod_pays`;

CREATE TABLE `qvod_pays` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '支付名称',
  `alias_name` varchar(255) DEFAULT NULL COMMENT '服务名称（开发填写）',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `pid` int(11) DEFAULT '0' COMMENT '父类ID',
  `service` varchar(25) DEFAULT NULL COMMENT '服务方',
  `channel` varchar(25) DEFAULT '' COMMENT '使用支付渠道 ',
  `method` varchar(10) DEFAULT NULL COMMENT '支付方式  qr 扫码  wap  手机跳转 ',
  `rank` int(5) DEFAULT '255' COMMENT '权重排序',
  `status` tinyint(2) DEFAULT '8' COMMENT '状态 0 删除 7 禁用 8 启用',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_jump` tinyint(2) DEFAULT '0' COMMENT '是否使用本域跳转  0  否  1 是',
  `use_drawal` tinyint(2) DEFAULT '0' COMMENT '状态 0 未使用 1 使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

/*Table structure for table `qvod_permission_role` */

DROP TABLE IF EXISTS `qvod_permission_role`;

CREATE TABLE `qvod_permission_role` (
  `permission_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`permission_id`,`role_id`),
  KEY `permission_role_permission_id_index` (`permission_id`),
  KEY `permission_role_role_id_index` (`role_id`),
  CONSTRAINT `permission_role_permission_id_foreign` FOREIGN KEY (`permission_id`) REFERENCES `qvod_permissions` (`id`) ON DELETE CASCADE,
  CONSTRAINT `permission_role_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `qvod_roles` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_permissions` */

DROP TABLE IF EXISTS `qvod_permissions`;

CREATE TABLE `qvod_permissions` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `desc` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `method` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `uri` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_delete` smallint(6) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_pictures` */

DROP TABLE IF EXISTS `qvod_pictures`;

CREATE TABLE `qvod_pictures` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thumb` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  `content` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `preview_num` int(11) NOT NULL DEFAULT '1',
  `category_id` int(11) NOT NULL DEFAULT '0',
  `rank` int(11) NOT NULL DEFAULT '255',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `view_times` int(11) DEFAULT '0' COMMENT '查看次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_recharge` */

DROP TABLE IF EXISTS `qvod_recharge`;

CREATE TABLE `qvod_recharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '原价',
  `dis_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠价',
  `level_limit` smallint(3) NOT NULL DEFAULT '0' COMMENT '充值限制   等级大于多少才显示',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='充值金额列表';

/*Table structure for table `qvod_roles` */

DROP TABLE IF EXISTS `qvod_roles`;

CREATE TABLE `qvod_roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `display_name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roles_name_unique` (`name`),
  UNIQUE KEY `roles_display_name_unique` (`display_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_tags_bnk` */

DROP TABLE IF EXISTS `qvod_tags_bnk`;

CREATE TABLE `qvod_tags_bnk` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '标签名称',
  `rank` int(3) DEFAULT NULL COMMENT '权重排序',
  `status` tinyint(2) DEFAULT '8' COMMENT '0 删除  8 正常',
  `admin_id` int(11) DEFAULT NULL COMMENT '管理员ID',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='标签表';

/*Table structure for table `qvod_uc_users` */

DROP TABLE IF EXISTS `qvod_uc_users`;

CREATE TABLE `qvod_uc_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `deposit` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '存款（星钻 ）',
  `phone` char(11) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '手机',
  `birthday` date NOT NULL DEFAULT '1970-01-01' COMMENT '生日',
  `signature` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '个性签名',
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '头像',
  `constellation` smallint(3) NOT NULL DEFAULT '0' COMMENT '星座ID',
  `location` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '位置',
  `level` smallint(3) NOT NULL DEFAULT '1' COMMENT '用户等级',
  `sex` smallint(3) NOT NULL DEFAULT '0' COMMENT '性别 0  未知  1 男  2 女',
  `vip` smallint(3) NOT NULL DEFAULT '0' COMMENT 'vip等级',
  `ex_vip_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:01' COMMENT '会员过期时间',
  `signage` char(11) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '推广标识号',
  `points` decimal(10,2) DEFAULT '0.00' COMMENT '推广积分(星票)',
  `re_signage` int(11) DEFAULT '0' COMMENT '推广员ID',
  `is_mute` int(11) DEFAULT '0' COMMENT '是否禁止用户评论',
  `salt` char(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '加密参数',
  `status` tinyint(3) DEFAULT '8' COMMENT '用户状态 0 删除  8 正常',
  `exp` bigint(20) DEFAULT '0' COMMENT '经验值',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户中心 用户表';

/*Table structure for table `qvod_user_collects` */

DROP TABLE IF EXISTS `qvod_user_collects`;

CREATE TABLE `qvod_user_collects` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `video_id` int(11) NOT NULL COMMENT '视频id',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_video` (`user_id`,`video_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';

/*Table structure for table `qvod_user_consumption_log` */

DROP TABLE IF EXISTS `qvod_user_consumption_log`;

CREATE TABLE `qvod_user_consumption_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `use_porint` int(8) DEFAULT NULL COMMENT '消费积分',
  `unit` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '换购单位',
  `type` tinyint(3) DEFAULT NULL COMMENT '消费类型   1 红利   2 钻石  3 元宝',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费记录表';

/*Table structure for table `qvod_user_gifts` */

DROP TABLE IF EXISTS `qvod_user_gifts`;

CREATE TABLE `qvod_user_gifts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(3) DEFAULT '0' COMMENT '礼金类型   1  红利   2 钻石  3 元宝',
  `title` varchar(128) DEFAULT NULL COMMENT '礼金名称',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `gift` decimal(10,2) DEFAULT NULL COMMENT '礼金金额',
  `before_gift` decimal(10,2) DEFAULT '0.00',
  `after_gift` decimal(10,2) DEFAULT '0.00',
  `status` tinyint(3) DEFAULT '0' COMMENT '完成状态   0 未完成  1 进行中  8 已完成',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `type` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户礼金表';

/*Table structure for table `qvod_user_identifiers` */

DROP TABLE IF EXISTS `qvod_user_identifiers`;

CREATE TABLE `qvod_user_identifiers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `identifier` varchar(255) DEFAULT NULL COMMENT '识别码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unid` (`user_id`,`identifier`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 COMMENT='用户设备关联表';

/*Table structure for table `qvod_user_logins` */

DROP TABLE IF EXISTS `qvod_user_logins`;

CREATE TABLE `qvod_user_logins` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `ip` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `os` tinyint(3) NOT NULL DEFAULT '2' COMMENT '来源  1 ios  2 android',
  PRIMARY KEY (`id`),
  KEY `user_logins_user_id_index` (`user_id`),
  KEY `times` (`created_at`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_user_phone_history` */

DROP TABLE IF EXISTS `qvod_user_phone_history`;

CREATE TABLE `qvod_user_phone_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `phone` char(11) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户手机历史记录（解绑操作后插入）';

/*Table structure for table `qvod_users` */

DROP TABLE IF EXISTS `qvod_users`;

CREATE TABLE `qvod_users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `api_token` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `vip_type` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `channel` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `os` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `uc_id` int(11) DEFAULT NULL COMMENT '用户主表关联ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_api_token_unique` (`api_token`),
  KEY `times` (`created_at`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_users_vips` */

DROP TABLE IF EXISTS `qvod_users_vips`;

CREATE TABLE `qvod_users_vips` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `expire_at` timestamp NULL DEFAULT NULL,
  `out_trade_no` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` tinyint(3) DEFAULT '1' COMMENT '状态  1 购买  2 兑换',
  PRIMARY KEY (`id`),
  KEY `users_vips_user_id_index` (`user_id`),
  KEY `users_vips_out_trade_no_index` (`out_trade_no`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_versions` */

DROP TABLE IF EXISTS `qvod_versions`;

CREATE TABLE `qvod_versions` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `version_code` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `version_name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `download_url` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(3000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `status` tinyint(3) DEFAULT '0' COMMENT '状态 0 不启用  1 启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_video_assess_logs` */

DROP TABLE IF EXISTS `qvod_video_assess_logs`;

CREATE TABLE `qvod_video_assess_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `video_id` int(11) DEFAULT NULL,
  `assess_type` tinyint(3) DEFAULT NULL COMMENT '状态  1 好评  2 差评',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='视频评价日志表';

/*Table structure for table `qvod_video_reviews` */

DROP TABLE IF EXISTS `qvod_video_reviews`;

CREATE TABLE `qvod_video_reviews` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `video_id` int(10) unsigned NOT NULL COMMENT '关联的视频id',
  `user_id` int(10) unsigned NOT NULL COMMENT '评论的用户id',
  `content` char(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '评论内容,最多20字',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  KEY `videoid` (`video_id`),
  KEY `userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户评论表';

/*Table structure for table `qvod_videos` */

DROP TABLE IF EXISTS `qvod_videos`;

CREATE TABLE `qvod_videos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thumb_img_url` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  `video_url` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  `video_preview_url` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `category_id` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '-1',
  `rank` int(11) NOT NULL DEFAULT '255',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `likes` int(11) DEFAULT '0' COMMENT '好评次数',
  `dislikes` int(11) DEFAULT '0' COMMENT '差评次数',
  `view_times` int(11) DEFAULT '0' COMMENT '点击次数',
  `collect_times` int(11) DEFAULT '0' COMMENT '收藏次数',
  `description` text COLLATE utf8mb4_unicode_ci COMMENT '详情',
  `contents` text COLLATE utf8mb4_unicode_ci COMMENT '精彩片段',
  `tags` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '精彩片段',
  `real_view_times` int(11) DEFAULT '0' COMMENT '真实查看详情次数',
  `play_times` int(11) DEFAULT '0' COMMENT '播放次数',
  PRIMARY KEY (`id`),
  KEY `videos_category_id_index` (`category_id`),
  KEY `videos_status_index` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_vips` */

DROP TABLE IF EXISTS `qvod_vips`;

CREATE TABLE `qvod_vips` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `price` decimal(10,2) NOT NULL COMMENT '原价',
  `dis_price` decimal(10,2) DEFAULT NULL COMMENT '优惠价格',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `period` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '有效期',
  `thumb_img_url` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '二维码图片',
  `description` text COLLATE utf8mb4_unicode_ci COMMENT '描述',
  `level` smallint(3) NOT NULL DEFAULT '0' COMMENT '会员等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='VIP 等级表';

/*Table structure for table `qvod_vips_categories` */

DROP TABLE IF EXISTS `qvod_vips_categories`;

CREATE TABLE `qvod_vips_categories` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vip_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `qvod_zb_t_appy` */

DROP TABLE IF EXISTS `qvod_zb_t_appy`;

CREATE TABLE `qvod_zb_t_appy` (
  `appy_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '申请人',
  `appy_context` varchar(300) DEFAULT NULL,
  `appy_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `appy_status` int(10) DEFAULT NULL COMMENT '1=申请中，2=申请通过，3=申请失败',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注原因',
  PRIMARY KEY (`appy_id`),
  KEY `FK_Reference_44` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主播申请表';

/*Table structure for table `qvod_zb_t_consume_logs` */

DROP TABLE IF EXISTS `qvod_zb_t_consume_logs`;

CREATE TABLE `qvod_zb_t_consume_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `send_uid` int(11) NOT NULL DEFAULT '0' COMMENT '发送者ID',
  `rec_uid` int(11) NOT NULL DEFAULT '0' COMMENT '接受者ID',
  `gid` int(11) NOT NULL DEFAULT '0' COMMENT '礼物ID',
  `gnum` int(11) NOT NULL DEFAULT '0' COMMENT '消费数量',
  `gname` varchar(255) NOT NULL DEFAULT '' COMMENT '礼物名称（枚举值=飞屏内容、礼物名称、购买会员等级）',
  `rid` int(11) NOT NULL DEFAULT '0' COMMENT '房间ID',
  `plan_id` int(11) NOT NULL DEFAULT '0' COMMENT '场次ID',
  `points` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '消费金额',
  `type` smallint(3) NOT NULL DEFAULT '0' COMMENT '消费类型  1 礼物  2 门票  3飞屏  4 预约  5 时长  6 购买会员  7 视频  8 图片',
  `rate` smallint(3) NOT NULL DEFAULT '0' COMMENT '分成比例',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=266 DEFAULT CHARSET=utf8 COMMENT='用户消费记录表';

/*Table structure for table `qvod_zb_t_exchange_logs` */

DROP TABLE IF EXISTS `qvod_zb_t_exchange_logs`;

CREATE TABLE `qvod_zb_t_exchange_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `points` double(10,2) NOT NULL COMMENT '兑换星票数量',
  `money` double(10,2) NOT NULL COMMENT '兑换金额   type 1 钻石   type 2 RMB',
  `type` smallint(3) NOT NULL COMMENT '兑换类型  1 星钻  2 RMB',
  `status` smallint(3) NOT NULL DEFAULT '0' COMMENT '兑换状态  0  申请中   7 审核失败 8 已完成 ',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户兑换记录表';

/*Table structure for table `qvod_zb_t_gift_list` */

DROP TABLE IF EXISTS `qvod_zb_t_gift_list`;

CREATE TABLE `qvod_zb_t_gift_list` (
  `gift_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '礼物id',
  `gift_name` varchar(100) DEFAULT NULL COMMENT '礼物名称',
  `gift_img` varchar(100) DEFAULT NULL COMMENT '礼物图片',
  `gift_price` double DEFAULT NULL COMMENT '礼物价格',
  `special_style` varchar(100) DEFAULT NULL COMMENT '特效方式',
  `order_field` int(10) DEFAULT NULL COMMENT '排序字段',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`gift_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='直播礼物列表';

/*Table structure for table `qvod_zb_t_index_banner` */

DROP TABLE IF EXISTS `qvod_zb_t_index_banner`;

CREATE TABLE `qvod_zb_t_index_banner` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `thumb_img_url` varchar(50) DEFAULT NULL,
  `type` enum('normal','ticket','time','personal','game') DEFAULT NULL COMMENT '枚举值=''普通房间'',''门票房间'',''时常房间'',''私密房间'',''游戏房间''\n            ''normal=普通房间'',''ticket=门票房间'',''time=时常房间'',''personal=私密房间'',''game=游戏房间''',
  `url` varchar(50) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='直播Banner列表';

/*Table structure for table `qvod_zb_t_lv_tactics` */

DROP TABLE IF EXISTS `qvod_zb_t_lv_tactics`;

CREATE TABLE `qvod_zb_t_lv_tactics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lv` int(11) NOT NULL COMMENT '级别',
  `experience` bigint(20) NOT NULL COMMENT '经验值',
  `minutes_five` int(11) NOT NULL COMMENT '主播五分钟增加的经验值',
  `gift` int(11) NOT NULL COMMENT '礼物发送一次的经验值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

/*Table structure for table `qvod_zb_t_msg_notification` */

DROP TABLE IF EXISTS `qvod_zb_t_msg_notification`;

CREATE TABLE `qvod_zb_t_msg_notification` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `type` enum('normal','ticket','time','personal','game') DEFAULT NULL COMMENT '枚举值=''普通房间'',''门票房间'',''时常房间'',''私密房间'',''游戏房间''\n            ''normal=普通房间'',''ticket=门票房间'',''time=时常房间'',''personal=私密房间'',''game=游戏房间''',
  `url` varchar(50) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='公告消息列表';

/*Table structure for table `qvod_zb_t_recrecords_logs` */

DROP TABLE IF EXISTS `qvod_zb_t_recrecords_logs`;

CREATE TABLE `qvod_zb_t_recrecords_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zb_id` int(11) NOT NULL COMMENT '主播ID（userId）',
  `plan_id` int(11) NOT NULL COMMENT '场次ID',
  `title` varchar(64) NOT NULL DEFAULT '' COMMENT '回放标题',
  `play_url` varchar(128) NOT NULL DEFAULT '' COMMENT '播放地址',
  `thumb_img_url` varchar(128) NOT NULL DEFAULT '' COMMENT '封面地址',
  `price` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `views` int(11) NOT NULL DEFAULT '0' COMMENT '播放次数',
  `rank` smallint(3) NOT NULL DEFAULT '0' COMMENT '位置',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='主播录播回放记录表';

/*Table structure for table `qvod_zb_t_room` */

DROP TABLE IF EXISTS `qvod_zb_t_room`;

CREATE TABLE `qvod_zb_t_room` (
  `room_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '房间id',
  `zb_id` int(10) DEFAULT NULL COMMENT '主播id',
  `room_title` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房间标题（UI现在8字符）',
  `room_info` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房间信息=开播信息',
  `room_bg_pic` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '房间封面',
  `room_watermark` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '房间水印',
  `room_status` int(10) DEFAULT '0' COMMENT '0=创建，1=直播中，2=未开播，3=回放中',
  `is_video` int(10) DEFAULT '0' COMMENT '0=不启用，1=启用',
  `order_field` int(10) DEFAULT NULL COMMENT '房间排序',
  `total_activity_time` int(10) DEFAULT NULL COMMENT '累计直播时长',
  `create_Time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`room_id`),
  KEY `FK_Reference_43` (`zb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='直播房间表';

/*Table structure for table `qvod_zb_t_room_attribute` */

DROP TABLE IF EXISTS `qvod_zb_t_room_attribute`;

CREATE TABLE `qvod_zb_t_room_attribute` (
  `attribute_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '属性id',
  `attribute_key` varchar(50) DEFAULT NULL COMMENT '属性名',
  `attribute_value` varchar(100) DEFAULT NULL COMMENT '属性值(多个值用,隔开)',
  `remark` varchar(100) DEFAULT NULL COMMENT '属性描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`attribute_id`),
  UNIQUE KEY `attributeKey_unique` (`attribute_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='房间类型属性表';

/*Table structure for table `qvod_zb_t_room_media_delete_log` */

DROP TABLE IF EXISTS `qvod_zb_t_room_media_delete_log`;

CREATE TABLE `qvod_zb_t_room_media_delete_log` (
  `log_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `zb_id` int(10) DEFAULT NULL COMMENT '主播id',
  `rmtp_url` varchar(100) DEFAULT NULL COMMENT '流地址',
  `delete_api` varchar(100) DEFAULT NULL COMMENT '删除接口',
  `result` text COMMENT '返回结果',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='直播删除日志表';

/*Table structure for table `qvod_zb_t_room_plan_stat` */

DROP TABLE IF EXISTS `qvod_zb_t_room_plan_stat`;

CREATE TABLE `qvod_zb_t_room_plan_stat` (
  `record_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '开播记录id',
  `plan_id` int(11) DEFAULT NULL COMMENT '直播场次id',
  `room_id` int(10) DEFAULT NULL COMMENT '房间id',
  `zb_id` int(10) DEFAULT NULL COMMENT '主播id',
  `room_title` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房间标题（UI现在8字符）',
  `room_type` enum('normal','ticket','time','personal','game') CHARACTER SET utf8 DEFAULT NULL COMMENT '枚举值=''普通房间'',''门票房间'',''时常房间'',''私密房间'',''游戏房间''\n            ''normal=普通房间'',''ticket=门票房间'',''time=时常房间'',''personal=私密房间'',''game=游戏房间''',
  `zb_room_conf` text CHARACTER SET utf8 COMMENT '开播配置表信息',
  `open_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开播时间',
  `close_time` timestamp NULL DEFAULT NULL COMMENT '关播时间',
  `is_video` int(10) DEFAULT '0' COMMENT '1=启用回放，0=不启用回放',
  `record_status` int(10) DEFAULT NULL COMMENT '1=正常结束，2=异常结束',
  `activity_time` int(10) DEFAULT NULL COMMENT '累计直播时长',
  `income_amount` int(10) DEFAULT NULL COMMENT '累计收益',
  `view_count` int(10) DEFAULT NULL COMMENT '累计观看',
  `gift_count` int(10) DEFAULT NULL COMMENT '累计收礼',
  `bomb_screen_count` int(10) DEFAULT NULL COMMENT '累计飞屏',
  `create_Time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`record_id`),
  UNIQUE KEY `plan_id_unique` (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='当前场次统计';

/*Table structure for table `qvod_zb_t_room_type_set` */

DROP TABLE IF EXISTS `qvod_zb_t_room_type_set`;

CREATE TABLE `qvod_zb_t_room_type_set` (
  `type_set_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '房间类型设置',
  `room_type` enum('ticket','time','personal') DEFAULT NULL COMMENT '枚举值=''普通房间'',''门票房间'',''时常房间'',''私密房间'',''游戏房间''\n            ''normal=普通房间'',''ticket=门票房间'',''time=时常房间'',''personal=私密房间'',''game=游戏房间''',
  `price01` int(10) DEFAULT '0' COMMENT '价格1',
  `price02` int(10) DEFAULT '0' COMMENT '价格2',
  `price03` int(10) DEFAULT '0' COMMENT '价格3',
  `price04` int(10) DEFAULT '0' COMMENT '价格4',
  `price05` int(10) DEFAULT '0' COMMENT '价格5',
  `time_interval` int(10) DEFAULT '0' COMMENT '时间间隔(针对时常房间，单位分钟)',
  `time01` int(10) DEFAULT '0' COMMENT '时常1',
  `time02` int(10) DEFAULT '0' COMMENT '时常2',
  `time03` int(10) DEFAULT '0' COMMENT '时常3',
  `time04` int(10) DEFAULT '0' COMMENT '时常4',
  `time05` int(10) DEFAULT '0' COMMENT '时常5',
  `opt_user` varchar(50) DEFAULT NULL COMMENT '操作人',
  `opt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`type_set_id`),
  UNIQUE KEY `roomTypeUnique` (`room_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='房间设置表';

/*Table structure for table `qvod_zb_t_user_attention` */

DROP TABLE IF EXISTS `qvod_zb_t_user_attention`;

CREATE TABLE `qvod_zb_t_user_attention` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `a_id` int(10) DEFAULT NULL COMMENT 'attention ID 关注者ID',
  `f_id` int(10) DEFAULT NULL COMMENT 'followed ID  被关注者ID',
  `attention_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '关注时间',
  `channel` int(10) DEFAULT NULL COMMENT '关注渠道（1=房间、2=个人中心、3=私信）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='用户关注表';

/*Table structure for table `qvod_zb_t_user_blacklist` */

DROP TABLE IF EXISTS `qvod_zb_t_user_blacklist`;

CREATE TABLE `qvod_zb_t_user_blacklist` (
  `blacklist_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '名单id',
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `blacklist_user_id` int(10) DEFAULT NULL COMMENT '黑名单用户',
  `black_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '拉黑时间',
  `channel` int(10) DEFAULT NULL COMMENT '拉黑渠道（1=房间、2=个人中心、3=私信）',
  PRIMARY KEY (`blacklist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='黑名单';

/*Table structure for table `qvod_zb_t_user_lv_tactics` */

DROP TABLE IF EXISTS `qvod_zb_t_user_lv_tactics`;

CREATE TABLE `qvod_zb_t_user_lv_tactics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lv` int(11) NOT NULL COMMENT '级别',
  `experience` bigint(20) NOT NULL COMMENT '经验值',
  `minutes_five` int(11) NOT NULL COMMENT '观看五分钟增加的经验值',
  `comment` int(11) NOT NULL COMMENT '评论一次的经验值',
  `gift` int(11) NOT NULL COMMENT '礼物发送一次的经验值',
  `max_minutes` int(11) NOT NULL COMMENT '当天观看最多增加的经验值',
  `max_comment` int(11) NOT NULL COMMENT '当天评论最多增加的经验值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qvod_zb_t_user_personal` */

DROP TABLE IF EXISTS `qvod_zb_t_user_personal`;

CREATE TABLE `qvod_zb_t_user_personal` (
  `user_personal_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '门票用户id',
  `plan_id` varchar(100) NOT NULL COMMENT '直播场次id',
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `activity_time` varchar(50) DEFAULT NULL COMMENT '持续时间',
  `over_time` timestamp NULL DEFAULT NULL COMMENT '结束时间',
  `status` int(10) DEFAULT NULL COMMENT '0=未预约，1=已预约',
  `buy_time` timestamp NULL DEFAULT NULL COMMENT '预约时间',
  `used_time` timestamp NULL DEFAULT NULL COMMENT '使用时间',
  PRIMARY KEY (`user_personal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='私密用户表';

/*Table structure for table `qvod_zb_t_user_report` */

DROP TABLE IF EXISTS `qvod_zb_t_user_report`;

CREATE TABLE `qvod_zb_t_user_report` (
  `report_id` int(10) NOT NULL COMMENT '举报id',
  `user_id` int(10) DEFAULT NULL COMMENT '举报人',
  `report_info` varchar(100) DEFAULT NULL COMMENT '举报信息',
  `zb_id` int(10) DEFAULT NULL COMMENT '被举报人',
  `auth_img` varchar(100) DEFAULT NULL COMMENT '截图凭证',
  `report_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '举报时间',
  `deal_user` varchar(100) DEFAULT NULL COMMENT '处理人账号',
  `deal_time` timestamp NULL DEFAULT NULL COMMENT '处理时间',
  `status` int(10) DEFAULT NULL COMMENT '1=举报中，2=处理中，3=已处理',
  `result` varchar(500) DEFAULT NULL COMMENT '处理结果',
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户举报表';

/*Table structure for table `qvod_zb_t_user_ticket` */

DROP TABLE IF EXISTS `qvod_zb_t_user_ticket`;

CREATE TABLE `qvod_zb_t_user_ticket` (
  `user_ticket_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '门票用户id',
  `plan_id` varchar(100) NOT NULL COMMENT '直播场次id',
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `activity_time` varchar(50) DEFAULT NULL COMMENT '持续时间',
  `over_time` timestamp NULL DEFAULT NULL COMMENT '结束时间',
  `price` double DEFAULT NULL COMMENT '门票价格',
  `status` int(10) DEFAULT NULL COMMENT '1=已购买，2=使用中，3=已使用，4=已过期',
  `buy_time` timestamp NULL DEFAULT NULL COMMENT '购买时间',
  `used_time` timestamp NULL DEFAULT NULL COMMENT '使用时间',
  `invalid_time` timestamp NULL DEFAULT NULL COMMENT '废弃时间',
  PRIMARY KEY (`user_ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门票用户表';

/*Table structure for table `qvod_zb_t_user_time` */

DROP TABLE IF EXISTS `qvod_zb_t_user_time`;

CREATE TABLE `qvod_zb_t_user_time` (
  `user_time_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '时长用户id',
  `plan_id` varchar(100) NOT NULL COMMENT '直播场次id',
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `activity_time` varchar(50) DEFAULT NULL COMMENT '持续时间',
  `over_time` timestamp NULL DEFAULT NULL COMMENT '结束时间',
  `price` double DEFAULT NULL COMMENT '消费砖石',
  `cost_count` int(10) DEFAULT NULL COMMENT '消费计时',
  `used_count` int(10) DEFAULT NULL COMMENT '消费时长',
  PRIMARY KEY (`user_time_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='时长用户表';

/*Table structure for table `qvod_zb_t_zhubo` */

DROP TABLE IF EXISTS `qvod_zb_t_zhubo`;

CREATE TABLE `qvod_zb_t_zhubo` (
  `zb_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主播id',
  `user_id` int(10) DEFAULT NULL COMMENT '用户id（直播）',
  `vip_level` int(10) DEFAULT NULL COMMENT '主播VIP等级',
  `zb_status` int(10) DEFAULT NULL COMMENT '主播状态\n            1=正常，2=禁播',
  `billing_cycle` smallint(3) NOT NULL DEFAULT '1' COMMENT '结算周期    1 月结  2 周结  3 日结',
  `gain_sharing` smallint(3) NOT NULL DEFAULT '0' COMMENT '收入分成',
  `max_withdraw` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '最大提款金额',
  `min_hours` double(8,1) NOT NULL DEFAULT '0.0' COMMENT '最低时长',
  `valid_hours` double(8,1) NOT NULL DEFAULT '0.0' COMMENT '有效时长',
  `min_income` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '最低收入',
  `time_state` smallint(3) NOT NULL DEFAULT '0' COMMENT '时长房间状态   0 关闭   1 开启',
  `ticket_state` smallint(3) NOT NULL DEFAULT '0' COMMENT '门票房间状态  0 关闭  1 开启',
  `personal_state` smallint(3) NOT NULL DEFAULT '0' COMMENT '私密房间状态  0 关闭   1 开启',
  `game_state` smallint(3) NOT NULL DEFAULT '0' COMMENT '游戏房间状态   0  关闭   1 开启',
  PRIMARY KEY (`zb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='主播表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
