-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 03, 2019 at 11:27 AM
-- Server version: 5.7.21
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `final_fmhaca`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `role` varchar(25) NOT NULL,
  PRIMARY KEY (`no`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`no`, `username`, `password`, `role`) VALUES
(12, 'sha', 'sha', 'store'),
(13, 'admin', 'admin', 'admin'),
(14, 'store', 'store', 'store'),
(21, 'storestore', 'store', 'store'),
(23, 'store1store', 'store', 'store'),
(24, 'store123', 'store', 'store'),
(25, 'store124', 'store', 'store'),
(26, 'store25', 'store', 'store'),
(27, 'store26', 'store', 'store'),
(28, 'admi27', 'admin', 'admin'),
(29, 'admi28', 'admin', 'admin'),
(30, 'admi29', 'admin', 'admin'),
(31, '123', '123', 'Store'),
(32, 'FMHACA0131ST', 'fentie123@FMHACA', 'Store'),
(33, 'FMHACA0132ST', 'fentie123@FMHACA', 'Store'),
(34, 'FMHACA0133ST', 'fentie123@FMHACA', 'Store'),
(35, 'FMHACA01ST', '123@FMHACA', 'Store'),
(36, '1FMHACA01ST', '1223@FMHACA', 'Store'),
(37, '11FMHACA01ST', '1223@FMHACA', 'Store'),
(38, 'FMHACA0137ST', 'kabed123@FMHACA', 'Store'),
(39, 'FMHACA0138ST', 'fentie123@FMHACA', 'Store'),
(40, 'FMHACA0139OW', 'g/medan123@FMHACA', 'Store'),
(41, 'FMHACA0140ST', 'g/medan123@FMHACA', 'Store'),
(42, 'FMHACA0141ST', 'kabed123@FMHACA', 'Store'),
(43, 'FMHACA0242MA', 'alemu23@FMHACA', 'Manager'),
(44, 'FMHACA0143ST', 'melaku123@FMHACA', 'Store'),
(45, 'FMHACA0244MA', 'lakewe23@FMHACA', 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(25) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `middle_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `region` varchar(25) NOT NULL,
  `city` varchar(25) NOT NULL,
  `kebele` varchar(25) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`no`, `admin_id`, `first_name`, `middle_name`, `last_name`, `region`, `city`, `kebele`, `status`) VALUES
(1, '12', 'fg', 'k', 'fentie', 'lo', 'bahir dar', '10', 'active'),
(2, 'admin1', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
(3, 'admin18', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `drug`
--

DROP TABLE IF EXISTS `drug`;
CREATE TABLE IF NOT EXISTS `drug` (
  `drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `batchNumber` varchar(255) NOT NULL,
  `brandName` varchar(255) NOT NULL,
  `genericName` varchar(255) NOT NULL,
  `TGroup` varchar(255) NOT NULL,
  `subTGroup` varchar(255) NOT NULL,
  `manufacturer` varchar(255) NOT NULL,
  `countryOfOrgin` varchar(255) NOT NULL,
  `registerDate` date NOT NULL,
  `expirDate` date NOT NULL,
  `amount` float NOT NULL,
  `dosageForm` varchar(25) NOT NULL,
  `strength` varchar(25) NOT NULL,
  `drugInfo` text NOT NULL,
  `status` varchar(25) NOT NULL,
  `cuernt_owner` varchar(25) NOT NULL,
  PRIMARY KEY (`drug_id`),
  KEY `cuernt_owner` (`cuernt_owner`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drug`
--

INSERT INTO `drug` (`drug_id`, `batchNumber`, `brandName`, `genericName`, `TGroup`, `subTGroup`, `manufacturer`, `countryOfOrgin`, `registerDate`, `expirDate`, `amount`, `dosageForm`, `strength`, `drugInfo`, `status`, `cuernt_owner`) VALUES
(1, 'D17035L049', 'gh', 'jh', 'lk', 'uy', 'yu', 'd', '2019-08-17', '2020-02-06', 350, '2gm', '200gm', 'dxcfvgbhnjkml.\r\ndxfcgvhbjnkml.', 'active', '100'),
(2, '7D4BDF98', '45dg', 'dddsds', 'dddsds', 'dddsds', 'dddsds', 'dddsds', '2019-03-30', '2019-05-10', 100, 'dddsds', 'dddsds', 'dddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsdsdddsds', 'active', 'a1'),
(3, 'dddsdsf', '45dg', 'dddsds', 'dddsds', 'dddsds', 'dddsds', 'dddsds', '2019-03-26', '2019-03-30', 10000, '45', 'dddsds', 'zswxdcfrvgbhnujmiko,l.;\'l,kmbhjvgcf', 'active', 'nb');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` varchar(25) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `middle_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `organization` varchar(25) NOT NULL,
  `region` varchar(25) NOT NULL,
  `city` varchar(25) NOT NULL,
  `kebele` varchar(25) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `organization` (`organization`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `first_name`, `middle_name`, `last_name`, `organization`, `region`, `city`, `kebele`, `status`) VALUES
('02301', 'shanbel', 'kassa', 'fentie', '101', 'h', 'bahir dar', '10', 'active'),
('02301g', 'shanbel', 'kassa', 'fentie', 'a1', 'h', 'bahir dar', '10', 'active'),
('02301gbn', 'shanbel', 'kassa', 'fentie', 'a1', 'h', 'bahir dar', '10', 'active'),
('0231', 'shanbel', 'kassa', 'fentie', 'a1', 'h', 'bahir dar', '10', 'active'),
('023104', 'shanbel', 'kassa', 'fentie', '100', 'h', 'bahir dar', '10', 'active'),
('02311v', 'shanbel', 'kassa', 'fentie', '100', 'h', 'bahir dar', '10', 'active'),
('023l01g', 'shanbel', 'kassa', 'fentie', 'a1', 'h', 'bahir dar', '10', 'active'),
('0960', 'fg', 'kassa', 'fentie', '101', 'h', 'bahir dar', '10', 'active'),
('bdu', 'shanbel', 'kassa', 'fentie', '100', 'mj', 'bahir dar', '10', 'active'),
('FMHACA0140ST', 'helen', 'mulagat', 'g/medan', 'a1', 'amhira', 'bahir dar', '10', 'active'),
('FMHACA0141ST', 'hj', 'k', 'kabed', '100', '03', 'bahir', '04', 'active'),
('FMHACA0143ST', 'aster', 'mola', 'melaku', 'a1', '03', 'gonder', '18', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `fmhacamanager`
--

DROP TABLE IF EXISTS `fmhacamanager`;
CREATE TABLE IF NOT EXISTS `fmhacamanager` (
  `manager_id` varchar(25) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `middle_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `region` varchar(25) NOT NULL,
  `city` varchar(25) NOT NULL,
  `kebele` varchar(25) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fmhacamanager`
--

INSERT INTO `fmhacamanager` (`manager_id`, `first_name`, `middle_name`, `last_name`, `region`, `city`, `kebele`, `status`) VALUES
('FMHACA01042MA', 'k', 'l', 'g', 'f', 'r', 'u', 'd'),
('FMHACA0142MA', 'k', 'l', 'g', 'f', 'r', 'u', 'd'),
('FMHACA01MA', 'k', 'l', 'g', 'f', 'r', 'u', 'd'),
('FMHACA0242MA', 'abeba', 'bezabah', 'alemu', '1', '2', '3', 'd'),
('FMHACA0244MA', 'senayt', 'zemene', 'lakewe', '03', 'tip', '01', 'active'),
('ng', 'k', 'l', 'g', 'f', 'r', 'u', 'd'),
('ngi', 'k', 'l', 'g', 'f', 'r', 'u', 'd');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` int(11) NOT NULL,
  `tstus` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
CREATE TABLE IF NOT EXISTS `organization` (
  `org_id` varchar(25) NOT NULL,
  `org_name` varchar(255) NOT NULL,
  `owner` varchar(25) NOT NULL,
  `region` varchar(25) NOT NULL,
  `city` varchar(25) NOT NULL,
  `kebele` varchar(25) NOT NULL,
  `healthProfessionalName` varchar(255) NOT NULL,
  `registerDate` date NOT NULL,
  `typeOgOrganzation` varchar(25) NOT NULL,
  `level` varchar(25) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`org_id`),
  KEY `owner` (`owner`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organization`
--

INSERT INTO `organization` (`org_id`, `org_name`, `owner`, `region`, `city`, `kebele`, `healthProfessionalName`, `registerDate`, `typeOgOrganzation`, `level`, `status`) VALUES
('100', 'a24', '0801787', 'lo', 'bahir dar', 'f', 'h', '2019-03-11', 'f', 'f', 'active'),
('101', 'a24', 'as', 'h', 'bahir dar', '10', 'h', '2019-03-12', 'f', 'f', 'active'),
('a1', 'a', 'as', 'h', 'f', '10', 'h', '2019-03-13', 'f', 'f', 'active'),
('nb', 'a', '0801787', 'h', 'f', '10', 'h', '0005-12-04', 'f', 'f', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
CREATE TABLE IF NOT EXISTS `owner` (
  `owner_id` varchar(25) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `middle_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `region` varchar(25) NOT NULL,
  `city` varchar(25) NOT NULL,
  `kebele` varchar(25) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`owner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`owner_id`, `first_name`, `middle_name`, `last_name`, `region`, `city`, `kebele`, `status`) VALUES
('0801787', 'sganbel', 'kassa', 'fentie', '03', 'bahir dar', '10', 'active'),
('0801787k', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('0801787k0', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('0801787k0j', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('0801787k0j1', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('0801787k0j123', 'shanbel', 'k', 'fentie', 'h', 'bahir dar', '10', 'active'),
('0801787k0j123v', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('0801787k0jb', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('0801787k0jlo', 'shanbel', 'kassa', 'kabed', 'h', 'bahir dar', '10', 'f'),
('0801787k0jm', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('as', 'de', 'bg', 'gt', 'h', 'g', 'v', 't'),
('FMHACA0138ST', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('FMHACA0139OW', 'helen', 'mulagat', 'g/medan', 'amhira', 'abederafi', '04', 'active'),
('ngh', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('nghu', 'shanbel', 'kassa', 'fentie', 'h', 'bahir dar', '10', 'active'),
('nghv', 'shanbel', 'kassa', 'kabed', 'lo', 'bahir dar', '10', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `requesst`
--

DROP TABLE IF EXISTS `requesst`;
CREATE TABLE IF NOT EXISTS `requesst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(25) NOT NULL,
  `resiver` varchar(25) NOT NULL,
  `drugId` int(11) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `resiver` (`resiver`),
  KEY `sender` (`sender`),
  KEY `drugId` (`drugId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tranizaction`
--

DROP TABLE IF EXISTS `tranizaction`;
CREATE TABLE IF NOT EXISTS `tranizaction` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `bayer` varchar(25) NOT NULL,
  `seller` varchar(25) NOT NULL,
  `drug_id` int(11) NOT NULL,
  `batch_no` varchar(255) NOT NULL,
  `amount` float NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`no`),
  KEY `bayer` (`bayer`),
  KEY `seller` (`seller`),
  KEY `drug_id` (`drug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `drug`
--
ALTER TABLE `drug`
  ADD CONSTRAINT `drug_ibfk_1` FOREIGN KEY (`cuernt_owner`) REFERENCES `organization` (`org_id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`organization`) REFERENCES `organization` (`org_id`);

--
-- Constraints for table `organization`
--
ALTER TABLE `organization`
  ADD CONSTRAINT `organization_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `owner` (`owner_id`);

--
-- Constraints for table `requesst`
--
ALTER TABLE `requesst`
  ADD CONSTRAINT `requesst_ibfk_1` FOREIGN KEY (`resiver`) REFERENCES `organization` (`org_id`),
  ADD CONSTRAINT `requesst_ibfk_2` FOREIGN KEY (`sender`) REFERENCES `organization` (`org_id`),
  ADD CONSTRAINT `requesst_ibfk_3` FOREIGN KEY (`drugId`) REFERENCES `drug` (`drug_id`);

--
-- Constraints for table `tranizaction`
--
ALTER TABLE `tranizaction`
  ADD CONSTRAINT `tranizaction_ibfk_1` FOREIGN KEY (`bayer`) REFERENCES `organization` (`org_id`),
  ADD CONSTRAINT `tranizaction_ibfk_2` FOREIGN KEY (`seller`) REFERENCES `organization` (`org_id`),
  ADD CONSTRAINT `tranizaction_ibfk_3` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`drug_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
