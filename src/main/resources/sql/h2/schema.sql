-- --------------------------------------------------------
-- 应用表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `CA_APP`;
CREATE TABLE IF NOT EXISTS `CA_APP` (
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
DROP TABLE IF EXISTS `CA_NODES`;
CREATE TABLE IF NOT EXISTS `CA_NODES` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `left_sibling` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);


-- -----------------------------------------------------
-- 目录邻接矩阵表       ADJACENCIES
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CA_NODES_ADJ`;
CREATE  TABLE IF NOT EXISTS `CA_NODES_ADJ` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `p_id` int(11) NOT NULL ,
  `c_id` int(11) NOT NULL ,
  `p_len` int(11) NOT NULL ,
  PRIMARY KEY (`id`)
);


-- --------------------------------------------------------
-- 文件表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `CA_FILE`;
CREATE TABLE IF NOT EXISTS `CA_FILE` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `custom_name` varchar(50) NOT NULL,
  `virtual_name` varchar(50) NOT NULL,
  `size` int(11) NOT NULL,
  `md5` varchar(32) NOT NULL,
  `CRC` varchar(8) NOT NULL,
  `shared` tinyint(1) NOT NULL DEFAULT 0,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `last_modified_date` TIMESTAMP NOT NULL DEFAULT 0,
  `created_date` TIMESTAMP NOT NULL DEFAULT 0,
  `deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);












