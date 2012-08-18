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
  `deleted` tinyint(1) NOT NULL DEFAULT 0,
  `last_modified_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_date` TIMESTAMP NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


-- --------------------------------------------------------
-- 目录表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `CA_NODES`;
CREATE TABLE IF NOT EXISTS `CA_NODES` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,          --指定该文件夹下文件类型（决定文件展示方式）
  `left_sibling` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


-- -----------------------------------------------------
-- 目录邻接矩阵表       ADJACENCIES
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CA_NODES_ADJ`;
CREATE  TABLE IF NOT EXISTS `CA_NODES_ADJ` (
  `p_id` int(11) NOT NULL ,              --父级id
  `c_id` int(11) NOT NULL ,              --当前id
  `p_len` int(11) NOT NULL ,             --深度
  INDEX (`p_id`)
)ENGINE = InnoDB DEFAULT CHARSET=UTF8;


-- --------------------------------------------------------
-- 文件表
-- --------------------------------------------------------
DROP TABLE IF EXISTS `CA_FILE`;
CREATE TABLE IF NOT EXISTS `CA_FILE` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `custom_name` varchar(50) NOT NULL,    -- 用户自定义文件名，如果用户没有自定义就使用上传前的文件名
  `virtual_name` varchar(50) NOT NULL,   -- 随机40位hash值
  `size` int(11) NOT NULL,
  `md5` varchar(32) NOT NULL,
  `CRC` varchar(8) NOT NULL,
  `shared` tinyint(1) NOT NULL DEFAULT 0,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `last_modified_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_date` TIMESTAMP NOT NULL DEFAULT 0,
  `deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;












