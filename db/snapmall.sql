create database IF NOT EXISTS `snapmall` default character set utf8mb4 collate utf8mb4_general_ci;

use snapmall;
drop table if exists `tz_user_addr`;
create table `tz_user_addr`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gmt_create`    datetime               NOT NULL,
    `gmt_modified`  datetime                NOT NULL,
    `user_id`       varchar(36)             NOT NULL DEFAULT '0',
    `receiver`      varchar(50)             DEFAULT NULL,
    `province_id`   bigint(20)              DEFAULT NULL,
    `province`      varchar(100)            DEFAULT NULL,
    `city`          varchar(20)             DEFAULT NULL,
    `city_id`       bigint(20)              DEFAULT NULL,
    `area`          varchar(20)             DEFAULT NULL,
    `area_id`       bigint(20)              DEFAULT NULL,
    `post_code`     varchar(15)             DEFAULT NULL,
    `addr`          varchar(1000)           DEFAULT NULL,
    `mobile`        varchar(20)             DEFAULT NULL,
    `status`        int(1)                  NOT NULL COMMENT '1 valid, 0 invalid',
    `is_default_addr`   int(1)              NOT NULL DEFAULT '0' COMMENT '0 false, 1 true',
    `version`       int(5)                  NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8 COMMENT ='user address';

