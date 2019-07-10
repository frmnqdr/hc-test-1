-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.1.16-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_hc-test
CREATE DATABASE IF NOT EXISTS `db_hc-test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_hc-test`;

-- Dumping structure for table db_hc-test.app_user
CREATE TABLE IF NOT EXISTS `app_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `group` tinyint(4) NOT NULL,
  `active_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  KEY `fk_group` (`group`),
  CONSTRAINT `fk_appuser_group` FOREIGN KEY (`group`) REFERENCES `m_app_user_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Dumping data for table db_hc-test.app_user: ~6 rows (approximately)
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` (`user_id`, `username`, `password`, `group`, `active_status`) VALUES
	(1, 'fqodry', '$2b$10$D0nSuSnGMi15uiNRl/BbKejqgoPUxvHophHD8VLCU6RbNKzsbCw22', 1, 1),
	(2, 'nisahaps', '$2b$10$D0nSuSnGMi15uiNRl/BbKejqgoPUxvHophHD8VLCU6RbNKzsbCw22', 3, 1),
	(3, 'abubakar', '$2b$10$D0nSuSnGMi15uiNRl/BbKejqgoPUxvHophHD8VLCU6RbNKzsbCw22', 2, 1),
	(4, 'umar', '$2b$10$D0nSuSnGMi15uiNRl/BbKejqgoPUxvHophHD8VLCU6RbNKzsbCw22', 1, 1),
	(5, 'utsman', '$2b$10$D0nSuSnGMi15uiNRl/BbKejqgoPUxvHophHD8VLCU6RbNKzsbCw22', 1, 1),
	(6, 'ali', '$2b$10$D0nSuSnGMi15uiNRl/BbKejqgoPUxvHophHD8VLCU6RbNKzsbCw22', 2, 1);
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;

-- Dumping structure for table db_hc-test.m_app_modules
CREATE TABLE IF NOT EXISTS `m_app_modules` (
  `module_id` tinyint(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_hc-test.m_app_modules: ~5 rows (approximately)
/*!40000 ALTER TABLE `m_app_modules` DISABLE KEYS */;
INSERT INTO `m_app_modules` (`module_id`, `name`, `description`) VALUES
	(1, 'PromoCard', 'Promo'),
	(2, 'CategoryCard', 'Category'),
	(3, 'NewsCard', 'News'),
	(4, 'FlashSaleCard', 'FlashSale'),
	(5, 'HistoryCard', 'History');
/*!40000 ALTER TABLE `m_app_modules` ENABLE KEYS */;

-- Dumping structure for table db_hc-test.m_app_user_group
CREATE TABLE IF NOT EXISTS `m_app_user_group` (
  `group_id` tinyint(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_hc-test.m_app_user_group: ~3 rows (approximately)
/*!40000 ALTER TABLE `m_app_user_group` DISABLE KEYS */;
INSERT INTO `m_app_user_group` (`group_id`, `name`, `description`) VALUES
	(1, 'Group A', 'User Group A'),
	(2, 'Group B', 'User Group B'),
	(3, 'Group C', 'User Group C');
/*!40000 ALTER TABLE `m_app_user_group` ENABLE KEYS */;

-- Dumping structure for table db_hc-test.ref_user_group_modules
CREATE TABLE IF NOT EXISTS `ref_user_group_modules` (
  `ref_id` smallint(5) NOT NULL AUTO_INCREMENT,
  `group_id` tinyint(4) NOT NULL,
  `module_id` tinyint(4) NOT NULL,
  `order` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ref_id`),
  KEY `fk_group_id` (`group_id`),
  KEY `fk_module_id` (`module_id`),
  CONSTRAINT `fk_ugmodules_groupid` FOREIGN KEY (`group_id`) REFERENCES `m_app_user_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ugmodules_moduleid` FOREIGN KEY (`module_id`) REFERENCES `m_app_modules` (`module_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dumping data for table db_hc-test.ref_user_group_modules: ~15 rows (approximately)
/*!40000 ALTER TABLE `ref_user_group_modules` DISABLE KEYS */;
INSERT INTO `ref_user_group_modules` (`ref_id`, `group_id`, `module_id`, `order`) VALUES
	(1, 1, 1, 1),
	(2, 1, 2, 2),
	(3, 1, 4, 3),
	(4, 1, 5, 4),
	(5, 1, 3, 5),
	(6, 2, 1, 1),
	(7, 2, 3, 2),
	(8, 2, 4, 3),
	(9, 2, 2, 4),
	(10, 2, 5, 5),
	(11, 3, 1, 1),
	(12, 3, 4, 2),
	(13, 3, 2, 3),
	(14, 3, 3, 4),
	(15, 3, 5, 5);
/*!40000 ALTER TABLE `ref_user_group_modules` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
