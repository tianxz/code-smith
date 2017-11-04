-- --------------------------------------------------------
-- 主机:                           192.168.0.254
-- 服务器版本:                        10.1.16-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 code_smith 的数据库结构
DROP DATABASE IF EXISTS `code_smith_test`;
CREATE DATABASE IF NOT EXISTS `code_smith_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `code_smith_test`;

-- 导出  表 code_smith.user_info 结构
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `ID` bigint(20) NOT NULL COMMENT 'id',
  `FIRST_NAME` varchar(64) DEFAULT NULL COMMENT '姓',
  `LAST_NAME` varchar(64) DEFAULT NULL COMMENT '名',
  `LOGIN_NAME` varchar(64) NOT NULL COMMENT '登录名',
  `LOGIN_PASSWORD` varchar(64) DEFAULT NULL COMMENT '登录密码',
  `GENDER` bit(1) DEFAULT NULL COMMENT '性别',
  `EMAIL` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `NATIONAL_IDENTIFIER` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `CELL_PHONE` varchar(64) DEFAULT NULL COMMENT '手机号',
  `PEOPLE_TYPE` tinyint(4) DEFAULT NULL COMMENT '用户状态',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登录时间',
  `LAST_LOGIN_IP` varchar(64) DEFAULT NULL COMMENT '最后登录日期',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- 正在导出表  code_smith.user_info 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`ID`, `FIRST_NAME`, `LAST_NAME`, `LOGIN_NAME`, `LOGIN_PASSWORD`, `GENDER`, `EMAIL`, `NATIONAL_IDENTIFIER`, `CELL_PHONE`, `PEOPLE_TYPE`, `LAST_LOGIN_TIME`, `LAST_LOGIN_IP`) VALUES
	(6308947494508171264, 'Tian', 'Xize', 'maintk', NULL, NULL, 'mt@hotmail.com', NULL, '13100000001', 5, '2017-11-04 18:05:44', NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
