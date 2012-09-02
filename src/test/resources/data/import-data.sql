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
INSERT INTO `CS_FILE` (`id`, `node_id`, `custom_name`, `virtual_name`, `real_name`, `size`, `md5`, `CRC`, `shared`, `status`, `last_modified_date`, `created_date`, `deleted`) VALUES
(1, 2, 'aaa.jpg', 'ASKFAGERDFASDSDFAF', 'aaa.jpg', 10, 'ASDFASDFASDF', 'ASDFDF', 1, 1, '2012-04-16 10:46:32', '1987-05-31 15:00:00', 0),
(2, 2, 'CCC.jpg', 'ASKFAGERDFASDSDFAF', 'aaa.jpg', 13, 'ASDFASDFASDF', 'ASDFAS', 1, 1, '2012-04-16 10:46:32', '1987-05-31 15:00:00', 0);
--
-- 转存表中的数据 `FTP_USER`
--
INSERT INTO `CS_FTP_USER` (`id`, `user_name`, `user_password`, `home_directory`, `enable_flag`, `write_permission`, `idle_time`, `upload_rate`, `download_rate`, `max_login_number`, `max_login_per_ip`, `deleted`, `last_modified_date`, `created_date`) VALUES
('1', 'admin', '21232F297A57A5A743894A0E4A801FC3', '.', 1, 1, 0, 0, 0, 0, 0, 0, '2012-04-16 10:46:32', '1987-05-31 15:00:00'),
('2', 'admin1', '21232F297A57A5A743894A0E4A801FC3', '.', 1, 1, 0, 0, 0, 0, 0, 0, '2012-04-16 10:46:32', '1987-05-31 15:00:00');

-- -----------------------------------------------------
-- 用户组测试数据
-- -----------------------------------------------------
INSERT INTO `CS_GROUP`(`id`, `group_name`) VALUES (1,'后台管理员');
INSERT INTO `CS_GROUP`(`id`, `group_name`) VALUES (2,'前台管理员');
INSERT INTO `CS_GROUP`(`id`, `group_name`) VALUES (3,'自由撰稿人');


-- -----------------------------------------------------
-- 用户组权限测试数据
-- -----------------------------------------------------
-- 后台管理员
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (1,1,"user:create");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (2,1,"user:edit");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (3,1,"user:save");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (4,1,"user:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (6,1,"group:create");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (7,1,"group:edit");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (8,1,"group:save");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (9,1,"group:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (11,1,"article:create");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (12,1,"article:edit");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (13,1,"article:save");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (14,1,"article:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (16,1,"comment:save");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (17,1,"comment:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (21,1,"category:list");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (22,1,"link:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (26,1,"gallery:create");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (27,1,"gallery:edit");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (28,1,"gallery:save");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (30,1,"gallery:list");
-- 前台管理员
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (51,2,"user:create");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (52,2,"user:edit");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (53,2,"user:save");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (54,2,"user:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (56,2,"article:create");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (57,2,"article:edit");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (58,2,"article:save");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (59,2,"article:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (61,2,"comment:save");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (62,2,"comment:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (63,2,"link:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (66,2,"gallery:create");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (67,2,"gallery:edit");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (68,2,"gallery:save");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (69,2,"gallery:list");

-- 自由撰稿人
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (101,3,"user:edit");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (106,3,"article:create");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (107,3,"article:edit");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (108,3,"article:list");

INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (111,3,"gallery:create");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (112,3,"gallery:edit");
INSERT INTO `CS_GROUP_PERMISSION`(`id`, `group_id`, `permission`) VALUES (113,3,"gallery:list");


-- -----------------------------------------------------
-- 用户测试数据
-- -----------------------------------------------------
INSERT INTO `CS_USER`(`id`, `group_id`, `email`, `username`, `password`, `salt`, `status`, `email_status`, `avatar_status`, `photo_url`, `time_offset`, `last_ip`, `last_time`, `last_act_time`, `last_modified_date`, `created_date`, `deleted`) VALUES
(1, 1, 'dreambt@qq.com', '纪柏涛', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 1, 1, 0, 'male.gif', '0800', 134744072, '1987-06-01 00:00:00', '1987-06-01 00:00:00', '2012-04-16 10:46:32', '1987-05-31 15:00:00', 0),
(2, 2, '710218922@qq.com', '赵鹏飞', 'e0187004dc8922474e31615e0f081215770d33d8', '7b804c22dd500387', 1, 0, 0, 'default.jpg', '0800', 134744072, '2012-04-16 18:00:06', '2012-04-16 18:00:06', '2012-04-16 11:20:12', '2012-04-16 10:00:19', 0),
(3, 1, 'dpf@126.com', '董鹏飞', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 1, 0, 0, 'default.jpg', '0800', 134744072, '2012-04-16 18:47:40', '2012-04-16 18:47:40', '2012-04-16 11:22:07', '2012-04-16 10:47:44', 0),
(4, 1, 'dxl@126.com', '邓小兰', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 1, 0, 0, 'default.jpg', '0800', 134744072, '2012-04-16 18:47:40', '2012-04-16 18:47:40', '2012-04-16 11:22:07', '2012-04-16 10:47:44', 0),
(5, 1, 'hm@126.com', '何梦', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 1, 0, 0, 'default.jpg', '0800', 134744072, '2012-04-16 18:47:40', '2012-04-16 18:47:40', '2012-04-16 11:22:07', '2012-04-16 10:47:44', 0),
(6, 1, 'slr@126.com', '宋丽荣', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', 1, 0, 0, 'default.jpg', '0800', 134744072, '2012-04-16 18:49:05', '2012-04-16 18:49:05', '2012-04-16 11:22:05', '2012-04-16 10:49:04', 0);












