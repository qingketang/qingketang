CREATE TABLE `class` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `no` varchar(32) NOT NULL DEFAULT '' COMMENT '课程编号',
  `name` varchar(256) NOT NULL COMMENT '课程名称',
  `user_num` varchar(48) NOT NULL COMMENT '成员数量',
  `created_at` bigint(20) unsigned NOT NULL,
  `updated_at` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_no` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程';

CREATE TABLE `class_work` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `class_id` bigint(20) unsigned NOT NULL COMMENT '课程ID',
  `type` varchar(16) NOT NULL COMMENT '课业类型(lesson: 课时, assignment: 作业, quiz: 测验, material: 资料)',
  `name` varchar(256) NOT NULL COMMENT '课业标题',
  `created_at` bigint(20) unsigned NOT NULL,
  `updated_at` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课业';

CREATE TABLE `class_activity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `class_id` bigint(20) unsigned NOT NULL COMMENT '课程ID',
  `work_id` bigint(20) unsigned NOT NULL COMMENT '课业ID',
  `type` varchar(16) NOT NULL COMMENT '活动类型',
  `name` varchar(256) NOT NULL COMMENT '活动名称',
  `created_at` bigint(20) unsigned NOT NULL,
  `updated_at` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课业教学活动';
