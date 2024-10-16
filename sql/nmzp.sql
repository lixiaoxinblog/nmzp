CREATE TABLE `nmzp_collect`  (
  `id` bigint NOT NULL COMMENT 'id主键',
  `user_id` bigint NULL COMMENT '用户ID',
  `job_id` bigint NULL COMMENT '工作ID',
  `create_time` datetime NULL COMMENT '创建时间',
  `create_user` bigint NULL COMMENT '创建用户',
  PRIMARY KEY (`id`)
);

CREATE TABLE `nmzp_company`  (
  `company_id` bigint NOT NULL COMMENT 'id 主键',
  `name` varchar(255) NULL COMMENT '公司名称',
  `address` varchar(255) NULL COMMENT '地址',
  `phone` varchar(20) NULL COMMENT '电话',
  `email` varchar(255) NULL COMMENT '邮箱',
  `logo` varchar(255) NULL COMMENT '公司logo',
  `boss` bigint NULL COMMENT '公司老总ID',
  `create_time` datetime NULL COMMENT '创建时间',
  `create_user` varchar(255) NULL COMMENT '创建用户',
  `update_time` datetime NULL COMMENT '更新时间',
  `is_del` tinyint NULL DEFAULT 0 COMMENT '删除标识（0默认1删除）',
  `status` tinyint NULL COMMENT '状态（0为审核，1已审核）',
  PRIMARY KEY (`company_id`)
);

CREATE TABLE `nmzp_feedback`  (
  `feedback_id` bigint NOT NULL COMMENT '意见反馈表ID',
  `question` varchar(500) NULL COMMENT '问题',
  `file` varchar(255) NULL COMMENT '问题图片描述',
  `phone` varchar(20) NULL COMMENT '电话号码',
  `create_time` datetime NULL COMMENT '创建时间',
  `create_user` bigint NULL COMMENT '创建用户',
  PRIMARY KEY (`feedback_id`)
);

CREATE TABLE `nmzp_greeting`  (
  `id` bigint NOT NULL COMMENT 'id',
  `msg` varchar(255) NULL COMMENT '招呼信息',
  `user_id` bigint NULL COMMENT '用户ID',
  `create_time` datetime NULL COMMENT '创建时间',
  `update_time` datetime NULL COMMENT '更新时间',
  `create_user` bigint NULL COMMENT '创建用户',
  PRIMARY KEY (`id`)
);

CREATE TABLE `nmzp_job`  (
  `job_id` bigint NOT NULL COMMENT 'id',
  `job_name` varchar(255) NULL COMMENT '工作名称',
  `position_name` varchar(255) NULL COMMENT '简介',
  `job_ask` varchar(255) NULL COMMENT '工作要求',
  `job_budget` varchar(255) NULL COMMENT '大概薪资，（不写就为面谈）',
  `address` tinyint NULL COMMENT '工作地点(枚举类写死)',
  `company_id` bigint NULL COMMENT '公司',
  `publish_user_id` bigint NULL COMMENT '发布工作人员',
  `job_description` varchar(255) NULL COMMENT '工作描述，比如vue，java',
  `create_time` datetime NULL COMMENT '创建时间',
  `update_time` datetime NULL COMMENT '更新时间',
  `create_user` tinyint NULL COMMENT '创建user',
  `job_type` int NULL COMMENT '职位类型',
  `resume_id` varchar(2000) NULL COMMENT '简历ID集合',
  `id_del` tinyint NULL DEFAULT 0 COMMENT '删除标识（0默认 1删除）',
  PRIMARY KEY (`job_id`)
);

CREATE TABLE `nmzp_message`  (
  `message_id` bigint NOT NULL COMMENT 'id',
  `sender_id` bigint NOT NULL COMMENT '用户ID',
  `recipient_id` bigint NOT NULL COMMENT '接受者ID',
  `msg` varchar(255) NULL COMMENT '消息内容',
  `create_time` datetime NULL COMMENT '创建时间',
  PRIMARY KEY (`message_id`)
);

CREATE TABLE `nmzp_resume`  (
  `resume_id` bigint NOT NULL COMMENT 'id主键',
  `user_id` bigint NULL COMMENT '用户id关联用户，一对一',
  `educations` varchar(1000) NULL COMMENT '学历信息，JSON格式',
  `is_work_experience` tinyint NULL COMMENT '是否有工作经验(0否，1是)',
  `work_experience` varchar(1000) NULL COMMENT '工作经验信息，JSON数组格式',
  `advantage` varchar(255) NULL COMMENT '个人优势信息',
  `project_experience` varchar(1000) NULL COMMENT '项目经验,JSON数组格式',
  `attachment` varchar(255) NULL COMMENT '附件简历地址',
  `job_type` int NULL COMMENT '职位类型固定数据',
  `job_seeking_status` tinyint NULL COMMENT '求职状态（0离校-正在找工作 1在校-正在找工作 2在校-看看机会 3在线-暂时不找工作 4离校-我要当牛马）',
  `credential` varchar(255) NULL COMMENT '资格证书, 公共字符串分割',
  `professional_skill` varchar(1000) NULL COMMENT '专业技能，说明自己擅长的技能信息',
  `self_evaluation` varchar(500) NULL COMMENT '自我评估',
  `create_time` datetime NULL COMMENT '创建时间',
  `create_user` bigint NULL COMMENT '创建用户',
  `update_time` datetime NULL COMMENT '更新时间',
  `is_del` tinyint NULL DEFAULT 0 COMMENT '删除标识（0默认，1删除）',
  PRIMARY KEY (`resume_id`)
);