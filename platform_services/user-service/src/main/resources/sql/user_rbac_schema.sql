CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` BIGINT NOT NULL COMMENT 'Primary key',
  `username` VARCHAR(64) NOT NULL COMMENT 'Username',
  `password` VARCHAR(128) NOT NULL COMMENT 'Password',
  `nickname` VARCHAR(64) DEFAULT NULL COMMENT 'Nickname',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT 'Status: 1 enabled, 0 disabled',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created time',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated time',
  `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT 'Logic delete: 0 active, 1 deleted',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_user_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='User table';

CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` BIGINT NOT NULL COMMENT 'Primary key',
  `role_code` VARCHAR(64) NOT NULL COMMENT 'Role code',
  `role_name` VARCHAR(64) NOT NULL COMMENT 'Role name',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT 'Status: 1 enabled, 0 disabled',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created time',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated time',
  `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT 'Logic delete: 0 active, 1 deleted',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_role_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Role table';

CREATE TABLE IF NOT EXISTS `sys_permission` (
  `id` BIGINT NOT NULL COMMENT 'Primary key',
  `perm_code` VARCHAR(128) NOT NULL COMMENT 'Permission code',
  `perm_name` VARCHAR(64) NOT NULL COMMENT 'Permission name',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT 'Status: 1 enabled, 0 disabled',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created time',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated time',
  `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT 'Logic delete: 0 active, 1 deleted',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_permission_perm_code` (`perm_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Permission table';

CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` BIGINT NOT NULL COMMENT 'Primary key',
  `user_id` BIGINT NOT NULL COMMENT 'User id',
  `role_id` BIGINT NOT NULL COMMENT 'Role id',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_user_role` (`user_id`, `role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='User role relation table';

CREATE TABLE IF NOT EXISTS `sys_role_permission` (
  `id` BIGINT NOT NULL COMMENT 'Primary key',
  `role_id` BIGINT NOT NULL COMMENT 'Role id',
  `permission_id` BIGINT NOT NULL COMMENT 'Permission id',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_role_permission` (`role_id`, `permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Role permission relation table';