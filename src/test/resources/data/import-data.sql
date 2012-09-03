-- -----------------------------------------------------
-- 目录表测试数据
-- -----------------------------------------------------
INSERT INTO `CS_NODE` (`id`, `name`, `type`, `left_sibling`, `parent_id`) VALUES
(1, 'node 1', 'OTHER', 0, 0),
(2, 'node 1.1', 'OTHER', 0, 1),
(3, 'node 2', 'OTHER', 1, 0),
(4, 'node 1.1.1', 'OTHER', 0, 2),
(5, 'node 2.1', 'TXT', 0, 3),
(6, 'node 1.2', 'MOVIE', 2, 1),
(7, 'node 1.3', 'PIC', 6, 1);


-- -----------------------------------------------------
-- 目录邻接矩阵表测试数据
-- -----------------------------------------------------
INSERT INTO `CS_NODE_ADJ`(`c_id`, `p_id`, `p_len`) VALUES
(1, 1, 0),
(1, 0, 1),
(2, 2, 0),
(2, 1, 1),
(2, 0, 2),
(3, 3, 0),
(3, 0, 1),
(4, 4, 0),
(4, 2, 1),
(4, 1, 2),
(4, 0, 3),
(5, 5, 0),
(5, 3, 1),
(5, 0, 2),
(6, 6, 0),
(6, 1, 1),
(6, 0, 2),
(7, 7, 0),
(7, 1, 1),
(7, 0, 2);

-- -----------------------------------------------------
-- 文件表测试数据
-- -----------------------------------------------------
INSERT INTO `CS_FILE` (`id`, `node_id`, `custom_name`, `file_key`, `real_name`, `size`, `md5`, `CRC`, `shared`, `status`, `last_modified_date`, `created_date`, `deleted`) VALUES
(1, 2, 'aaa.jpg', 'ASKFAGERDFASDSDFAF', 'aaa.jpg', 10, 'ASDFASDFASDF', 'ASDFDF', 1, 1, '2012-04-16 10:46:32', '1987-05-31 15:00:00', 0),
(2, 2, 'CCC.jpg', 'ASKFAGERDFASDSDFAF', 'aaa.jpg', 13, 'ASDFASDFASDF', 'ASDFAS', 1, 1, '2012-04-16 10:46:32', '1987-05-31 15:00:00', 0);
--
-- 转存表中的数据 `FTP_USER`
--
INSERT INTO `CS_FTP_USER` (`id`, `user_name`, `user_password`, `home_directory`, `enable_flag`, `write_permission`, `idle_time`, `upload_rate`, `download_rate`, `max_login_number`, `max_login_per_ip`, `deleted`, `last_modified_date`, `created_date`) VALUES
('1', 'admin', '21232F297A57A5A743894A0E4A801FC3', '.', 1, 1, 0, 0, 0, 0, 0, 0, '2012-04-16 10:46:32', '1987-05-31 15:00:00'),
('2', 'admin1', '21232F297A57A5A743894A0E4A801FC3', '.', 1, 1, 0, 0, 0, 0, 0, 1, '2012-04-16 10:46:32', '1987-05-31 15:00:00');

-- -----------------------------------------------------
-- 用户组测试数据
-- -----------------------------------------------------
INSERT INTO `CS_GROUP`(`id`, `group_name`) VALUES (1,'后台管理员');
INSERT INTO `CS_GROUP`(`id`, `group_name`) VALUES (2,'前台管理员');
INSERT INTO `CS_GROUP`(`id`, `group_name`) VALUES (3,'自由撰稿人');


-- -----------------------------------------------------
-- 用户组权限测试数据
-- -----------------------------------------------------
-- 系统管理员
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (1,1,'app:create');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (2,1,'app:delete');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (3,1,'app:update');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (4,1,'app:list');

-- 应用管理员
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (10,2,'user:create');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (11,2,'user:delete');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (12,2,'user:update');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (13,2,'user:list');

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (16,2,'group:create');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (17,2,'group:delete');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (18,2,'group:update');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (19,2,'group:list');

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (21,2,'file:create');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (22,2,'file:delete');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (23,2,'file:update');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (24,2,'file:list');

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (26,2,'node:create');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (27,2,'node:delete');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (28,2,'node:update');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (29,2,'node:list');

-- 用户
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (50,3,'user:create');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (51,3,'user:delete');
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (52,3,'user:update');

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (59,3,'group:list');

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (64,3,'file:list');

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (69,3,'node:list');


-- -----------------------------------------------------
-- 用户测试数据
-- -----------------------------------------------------
INSERT INTO `CS_USER`(`id`, `group_id`, `email`, `username`, `password`, `salt`, `status`, `email_status`, `avatar_status`, `photo_url`, `time_offset`, `last_ip`, `last_time`, `last_act_time`, `last_modified_date`, `created_date`, `deleted`) VALUES
(1, 1, 'dreambt@qq.com', '纪柏涛', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 1, 1, 0, 'male.gif', '0800', 134744072, '1987-06-01 00:00:00', '1987-06-01 00:00:00', '2012-04-16 10:46:32', '1987-05-31 15:00:00', 0),
(2, 1, '826323891@qq.com', '董鹏飞', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 1, 0, 0, 'default.jpg', '0800', 134744072, '2012-04-16 18:47:40', '2012-04-16 18:47:40', '2012-04-16 11:22:07', '2012-04-16 10:47:44', 0),
(3, 1, 'zn@126.com', '张楠', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 1, 0, 0, 'default.jpg', '0800', 134744072, '2012-04-16 18:47:40', '2012-04-16 18:47:40', '2012-04-16 11:22:07', '2012-04-16 10:47:44', 1);
