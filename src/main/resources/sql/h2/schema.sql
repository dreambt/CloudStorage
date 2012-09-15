-- --------------------------------------------------------
-- 应用表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `CS_APP`;
CREATE TABLE IF NOT EXISTS `CS_APP` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `short_name` varchar(50) NOT NULL,
  `app_type` varchar(20) NOT NULL,
  `app_key` varchar(20) NOT NULL,
  `app_secret` varchar(32) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `last_modified_date` TIMESTAMP NOT NULL DEFAULT 0,
  `created_date` TIMESTAMP NOT NULL DEFAULT 0,
  `deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);


-- --------------------------------------------------------
-- 目录表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `CS_NODE`;
CREATE TABLE IF NOT EXISTS `CS_NODE` (
  `id` int(11) unsigned DEFAULT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `left_sibling` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `display_order` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);


-- -----------------------------------------------------
-- 目录邻接矩阵表       ADJACENCIES
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CS_NODE_ADJ`;
CREATE  TABLE IF NOT EXISTS `CS_NODE_ADJ` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `p_id` int(11) NOT NULL ,
  `c_id` int(11) NOT NULL ,
  `p_len` int(11) NOT NULL ,
  PRIMARY KEY (`id`)
);


-- --------------------------------------------------------
-- 文件表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `CS_FILE`;
CREATE TABLE IF NOT EXISTS `CS_FILE` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `node_id` int(11) NOT NULL,
  `file_key` varchar(50) NOT NULL,
  `custom_name` varchar(50) NOT NULL,
  `real_name` varchar(50) NOT NULL,
  `suffix` varchar(5) NOT NULL,
  `size` int(11) NOT NULL,
  `md5` varchar(32) NOT NULL,
  `CRC` varchar(8) NOT NULL,
  `download_count` int(8) NOT NULL,
  `shared` tinyint(1) NOT NULL DEFAULT 0,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `last_modified_date` TIMESTAMP DEFAULT null,
  `created_date` TIMESTAMP DEFAULT null,
  `deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);


--
-- 表的结构 `CS_FTP_USER`
--
DROP TABLE IF EXISTS `CS_FTP_USER`;
CREATE TABLE IF NOT EXISTS `CS_FTP_USER` (
  `id` int(11) default NULL  AUTO_INCREMENT,
  `user_name` varchar(64) default NULL,
  `user_password` varchar(64) DEFAULT NULL,
  `home_directory` varchar(128) DEFAULT NULL,
  `enable_flag` tinyint(1) DEFAULT '1',
  `write_permission` tinyint(1) DEFAULT '0',
  `idle_time` int(11) DEFAULT '0',
  `upload_rate` int(11) DEFAULT '0',
  `download_rate` int(11) DEFAULT '0',
  `max_login_number` int(11) DEFAULT '0',
  `max_login_per_ip` int(11) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `last_modified_date` TIMESTAMP DEFAULT null,
  `created_date` TIMESTAMP DEFAULT null,
  PRIMARY KEY (`id`)
);

-- -----------------------------------------------------
-- 用户组 `CS_GROUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CS_GROUP` ;
CREATE  TABLE IF NOT EXISTS `CS_GROUP` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT ,
  `group_name` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`id`)
);

-- -----------------------------------------------------
-- 用户组权限 `CS_GROUP_PERMISSION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CS_GROUP_PERMISSION` ;
CREATE  TABLE IF NOT EXISTS `CS_GROUP_PERMISSION` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT ,
  `group_id` int(11) unsigned NOT NULL ,
  `permission` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`id`)
);

--
-- 用户信息 `CS_USER`
--
DROP TABLE IF EXISTS `CS_USER` ;
CREATE  TABLE IF NOT EXISTS `CS_USER` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `group_id` int(11) UNSIGNED NOT NULL ,
  `email` VARCHAR(40) NOT NULL ,
  `username` VARCHAR(40) NOT NULL,
  `password` VARCHAR(40) NOT NULL ,
  `salt` VARCHAR(16) NOT NULL ,
  `status` TINYINT(1) NOT NULL DEFAULT 0,
  `email_status` TINYINT(1) NOT NULL DEFAULT 0,
  `avatar_status` TINYINT(1) NOT NULL DEFAULT 0,
  `photo_url` VARCHAR(40) NOT NULL DEFAULT '/default.jpg' ,
  `time_offset` VARCHAR(4) NOT NULL DEFAULT '0800',
  `deleted` TINYINT(1) NOT NULL ,
  `last_ip` INT(10) unsigned NOT NULL ,
  `last_time` DATETIME DEFAULT NULL,
  `last_act_time` DATETIME DEFAULT NULL,
  `last_modified_date` TIMESTAMP DEFAULT NULL,
  `created_date` TIMESTAMP DEFAULT NULL,
  PRIMARY KEY (`id`)
);


--
-- 文件分享 `CS_SHARE`
--
DROP TABLE IF EXISTS `CS_SHARE` ;
CREATE  TABLE IF NOT EXISTS `CS_SHARE` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `share_key` int(11) UNSIGNED NOT NULL,
  `share_secret` VARCHAR(40) NOT NULL,
  `file_key` VARCHAR(40) NOT NULL,
  `last_modified_date` TIMESTAMP DEFAULT NULL,
  `created_date` TIMESTAMP DEFAULT NULL,
  `expired_date` TIMESTAMP DEFAULT NULL,
  PRIMARY KEY (`id`)
);





