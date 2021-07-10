CREATE TABLE `user`
(
    `id`           int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`         varchar(64) DEFAULT NULL COMMENT '用户名称',
    `avatar`       varchar(255) DEFAULT NULL COMMENT '用户头像',
    `created_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
    `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
