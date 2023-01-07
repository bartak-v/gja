# A sql file for table creation
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;

DROP TABLE IF EXISTS `EMPLOYEE`;
CREATE TABLE IF NOT EXISTS `employee` (
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `salary` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;