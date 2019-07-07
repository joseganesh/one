-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2019 at 12:27 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jewellery`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountgroup`
--

CREATE TABLE IF NOT EXISTS `accountgroup` (
  `AccountGroupId` int(11) NOT NULL,
  `AccountName` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `AccountHead` varchar(255) DEFAULT NULL,
  `GroupCode` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `accountgroup`
--

INSERT INTO `accountgroup` (`AccountGroupId`, `AccountName`, `Status`, `Date`, `AccountHead`, `GroupCode`) VALUES
(1, 'asdf', 'A', '2018-08-10 12:26:28', 'Income', NULL),
(2, 'onetwothreefourfivesixseveneight', 'A', '2018-08-10 12:30:43', 'Income', NULL),
(3, 'account', 'A', '2018-09-18 10:28:56', 'Income', '11aa'),
(4, 'ffhfhfh', 'A', '2019-06-05 23:09:17', 'Income', 'dgf');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE IF NOT EXISTS `bill` (
  `BillId` int(11) NOT NULL,
  `BillNo` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `VendorId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `cashdata`
--

CREATE TABLE IF NOT EXISTS `cashdata` (
  `CashDataId` int(11) NOT NULL,
  `Cash` varchar(255) DEFAULT NULL,
  `CustomerId` int(11) NOT NULL,
  `Cashdiscount` double DEFAULT NULL,
  `Taxrs` double DEFAULT NULL,
  `Cgst` double DEFAULT NULL,
  `Sgst` double DEFAULT NULL,
  `IGST` double DEFAULT NULL,
  `Totalamtpay` double DEFAULT NULL,
  `Amntinwords` varchar(255) DEFAULT NULL,
  `Invoiceno` varchar(255) DEFAULT NULL,
  `Date` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cashdata`
--

INSERT INTO `cashdata` (`CashDataId`, `Cash`, `CustomerId`, `Cashdiscount`, `Taxrs`, `Cgst`, `Sgst`, `IGST`, `Totalamtpay`, `Amntinwords`, `Invoiceno`, `Date`) VALUES
(1, '2', 0, 2, 2, 22, 3, 3, 2, 'two only/_', 'dds44', '2018-09-12 13:29:57'),
(2, '22', 0, 2, 2, 2, 2, 2, 2, 'two', 'aa11', '2018-09-12 13:32:58'),
(3, '6', 0, 66, 66, 66, 66, 66, 66, 'sixty six/-', 'aa11', '2018-09-12 15:21:51'),
(4, '222', 9, 22, 22, 22, 22, 22, 22, 'twentytwo only/-', 'hgjjh', '2018-09-13 13:26:47'),
(5, '4', 10, 4, 4, 4, 4, 4, 4, 'fouronly/-', '54354', '2018-09-14 05:43:22'),
(6, '3', 11, 33, 3, 3, 3, 3, 3, 'three', 'th65', '2018-09-14 05:45:29'),
(7, '', 24, 1000, 39296, 4009.8, 3207.84, 5346.4, 51860.04, 'Rupees Fifty One Thousand Eight Hundred and Sixty Only', 'bb', '2019-01-22 15:34:54'),
(8, '', 25, 1000, 79212, 8082.9, 6466.32, 10777.2, 104538.42, 'Rupees One Lakh Four Thousand Five Hundred and Thirty Eight Only', 'free', '2019-01-22 15:46:30'),
(9, '', 26, 1000, 57172, 5833.95, 4667.16, 7778.6, 75451.71, 'Rupees Seventy Five Thousand Four Hundred and Fifty One Only', 'aaaaaaa', '2019-01-22 15:50:41'),
(10, '', 27, 1000, 58972, 6017.55, 4814.04, 8023.4, 77826.98999999999, 'Rupees Seventy Seven Thousand Eight Hundred and Twenty Six Only', 'ertfy', '2019-01-22 15:55:02'),
(11, '', 28, 1000, 55504, 5663.7, 4530.96, 7551.6, 73250.26000000001, 'Rupees Seventy Three Thousand Two Hundred and Fifty Only', '2134', '2019-01-22 16:02:57'),
(12, '', 29, 1000, 36840, 3759.15, 3007.32, 5012.2, 48618.67, 'Rupees Forty Eight Thousand Six Hundred and Eighteen Only', 'xxx', '2019-01-22 16:06:41'),
(13, '', 30, 1000, 82432, 8411.4, 6729.12, 11215.2, 108787.71999999999, 'Rupees One Lakh Eight Thousand Seven Hundred and Eighty Seven Only', 'gggggggg', '2019-01-22 16:10:10'),
(14, '', 31, 200, 104772, 10690.95, 8552.76, 14254.6, 138270.31, 'Rupees One Lakh Thirty Eight Thousand Two Hundred and Seventy Only', 'iuytf', '2019-01-22 16:16:08'),
(15, '', 32, 1000, 82432, 8411.4, 6729.12, 11215.2, 108787.71999999999, 'Rupees One Lakh Eight Thousand Seven Hundred and Eighty Seven Only', 'SSSSSSSSSS', '2019-01-22 16:21:48'),
(16, '', 45, 1000, 105956, 10811.85, 8649.48, 14415.8, 139833.13, 'Rupees One Lakh Thirty Nine Thousand Eight Hundred and Thirty Three Only', 'wertf', '2019-01-26 12:28:17'),
(17, '', 46, 556, -9387.56, -957.9, -766.32, -1277.2, -12388.98, 'Zero or Negative number not for conversion', 'dfd', '2019-01-26 12:30:59'),
(18, '', 47, 55, 132.52, 13.5, 10.8, 18, 174.82000000000002, 'Rupees One Hundred and Seventy Four Only', '5455', '2019-01-26 15:28:59'),
(19, '', 48, 55, -3168899.5104, -323357.1, -258685.68, -431142.8, -4182085.0904, 'Zero or Negative number not for conversion', '43', '2019-01-26 15:47:53'),
(20, '', 49, 66, 28020, 2859.15, 2287.32, 3812.2, 36978.67, 'Rupees Thirty Six Thousand Nine Hundred and Seventy Eight Only', '44444', '2019-01-26 16:41:46'),
(21, '', 51, 444, -305.0091, -31.05, -24.84, -41.4, -402.29909999999995, 'Zero or Negative number not for conversion', '55', '2019-01-26 16:44:23'),
(22, '', 52, 1, 183.441, 18.75, 15, 25, 242.191, 'Rupees Two Hundred and Forty Two Only', '3t5535', '2019-01-26 16:50:05'),
(23, '', 53, 1, 44.4501, 4.5, 3.6, 6, 58.5501, 'Rupees Fifty Eight Only', '45454', '2019-01-26 16:54:07'),
(24, '', 54, 1, 44.45011, 4.5, 3.6, 6, 58.550110000000004, 'Rupees Fifty Eight Only', '6666', '2019-01-26 16:55:57'),
(25, '', 55, 1, 44.4501, 4.5, 3.6, 6, 58.5501, 'Rupees Fifty Eight Only', '4444', '2019-01-26 17:04:55'),
(26, '', 56, 1, 44.4501, 4.5, 3.6, 6, 58.5501, 'Rupees Fifty Eight Only', '555', '2019-01-26 17:08:30'),
(27, '', 57, 1, 48.8511, 4.95, 3.96, 6.6, 64.36110000000001, 'Rupees Sixty Four Only', '444', '2019-01-26 17:09:50'),
(28, '', 58, 1, 58.851099999999995, 6, 4.8, 8, 77.6511, 'Rupees Seventy Seven Only', '3333333', '2019-01-26 17:38:41'),
(29, '', 61, 234, 4717, 481.35, 385.08, 641.8, 6225.2300000000005, 'Rupees Six Thousand Two Hundred and Twenty Five Only', 'ww', '2019-01-26 17:58:48'),
(30, '', 62, 123, 5039, 514.2, 411.36, 685.6, 6650.16, 'Rupees Six Thousand Six Hundred and Fifty Only', 'qeq', '2019-01-26 18:06:01'),
(31, '', 63, 0, 21498, 2193.6, 1754.88, 2924.8, 28371.28, 'Rupees Twenty Eight Thousand Three Hundred and Seventy One Only', 'qw', '2019-01-26 18:07:16'),
(32, '', 64, 12, 10044, 1024.95, 819.96, 1366.6, 13255.51, 'Rupees Thirteen Thousand Two Hundred and Fifty Five Only', 'ere', '2019-01-26 18:09:16'),
(33, '', 65, 100, 48895, 4989.3, 3991.44, 6652.4, 64528.14000000001, 'Rupees Sixty Four Thousand Five Hundred and Twenty Eight Only', '45', '2019-01-26 18:11:08'),
(34, '', 66, 1, 96.64, 9.9, 7.92, 13.2, 127.66000000000001, 'Rupees One Hundred and Twenty Seven Only', '444444', '2019-01-26 18:14:01'),
(35, '', 67, 789, 43751, 4464.45, 3571.56, 5952.6, 57739.60999999999, 'Rupees Fifty Seven Thousand Seven Hundred and Thirty Nine Only', '5679', '2019-01-26 18:20:24'),
(36, '', 68, 1222, 48773, 4976.85, 3981.48, 6635.8, 64367.130000000005, 'Rupees Sixty Four Thousand Three Hundred and Sixty Seven Only', '579', '2019-01-26 18:23:52'),
(37, '', 69, 1, 0.010099999999999998, 0, 0, 0, 0.010099999999999998, 'Zero or Negative number not for conversion', '555', '2019-01-26 18:26:00'),
(38, '', 70, 1, 44.4501, 4.5, 3.6, 6, 58.5501, 'Rupees Fifty Eight Only', '44', '2019-01-26 18:28:59'),
(39, '', 71, 123, 44440, 4534.65, 3627.72, 6046.2, 58648.57, 'Rupees Fifty Eight Thousand Six Hundred and Forty Eight Only', '567890', '2019-01-26 18:33:20'),
(40, '', 72, 123, 444288, 45335.55, 36268.44, 60447.4, 586339.39, 'Rupees Five Lakh Eighty Six Thousand Three Hundred and Thirty Nine Only', '56780', '2019-01-26 18:37:23'),
(41, '', 73, 223, 44750.7804, 4566.45, 3653.16, 6088.6, 59058.9904, 'Rupees Fifty Nine Thousand Fifty Eight Only', '4567890', '2019-01-26 18:39:19'),
(42, '', 86, 2, 135.2305, 13.8, 11.04, 18.4, 178.47050000000002, 'Rupees One Hundred and Seventy Eight Only', 'SS/11/2019', '2019-01-27 11:04:57'),
(43, '', 87, 2, 129.0901, 13.2, 10.56, 17.6, 170.4501, 'Rupees One Hundred and Seventy Only', 'SS/12/2019', '2019-01-27 11:23:21'),
(44, '', 88, 3, 273.2214, 27.9, 22.32, 37.2, 360.6414, 'Rupees Three Hundred and Sixty Only', 'SS/11/2019', '2019-01-27 12:06:24'),
(45, '', 90, 1000, 97868, 9986.55, 7989.24, 13315.4, 129159.19, 'Rupees One Lakh Twenty Nine Thousand One Hundred and Fifty Nine Only', 'SS/11/2019', '2019-01-30 09:19:39');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `CatId` int(11) NOT NULL,
  `CategoryName` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `Date` date DEFAULT NULL,
  `UnitId` int(11) DEFAULT NULL,
  `CategoryCode` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CatId`, `CategoryName`, `status`, `Date`, `UnitId`, `CategoryCode`) VALUES
(10, 'silver', 'A', NULL, NULL, 222),
(11, 'platinum', 'A', NULL, NULL, 333),
(12, '916gold', 'A', NULL, NULL, 444),
(13, 'gold', 'A', NULL, NULL, 111),
(14, 'whitegold', 'A', NULL, NULL, 14441);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `CustomerId` int(11) NOT NULL,
  `CustomerName` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `ContactNo` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Pin` bigint(20) DEFAULT NULL,
  `EventDate` date DEFAULT NULL,
  `Event` varchar(255) DEFAULT NULL,
  `LedgerId` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerId`, `CustomerName`, `Status`, `Date`, `Email`, `ContactNo`, `Gender`, `Address`, `Pin`, `EventDate`, `Event`, `LedgerId`) VALUES
(1, 'ddh', NULL, '2018-07-01', 'd@mail', '4576587', NULL, 'eh\ntrfl\nkgjdh', 4524, '2018-07-31', 'dssz', NULL),
(2, 'ytfhgj', NULL, '2018-07-01', 'z@gmail.com', '988466464', NULL, 'jhjhg\nyft\nkghcdh\nljgfytu', 216486, '2018-07-31', 'kiug', NULL),
(3, 'sdf', NULL, '2018-07-30', 'dsf', '53465', 'Male', 'asdf', 4334, '2018-07-31', 'fgsa', NULL),
(4, 'dfgdf', NULL, '2018-07-01', 'edfag', '543676', 'Female', 'afgdsdfsg', 3465, '2018-07-31', 'dshy', NULL),
(6, 'fsdgfa', NULL, '2018-07-31', '@gmail', '54365424', 'Male', 'dfgfg', 23543, '2018-07-31', 'fhgth', NULL),
(7, 'hh', NULL, NULL, NULL, '452453645', NULL, 'hh\nkk\nll', NULL, NULL, NULL, NULL),
(8, 'js', NULL, NULL, NULL, '2456788657', NULL, 'kk\nll\noo', NULL, NULL, NULL, NULL),
(9, 'gfg', NULL, NULL, NULL, '4525636565', NULL, 'd\nhgjk\njgk', NULL, NULL, NULL, NULL),
(10, 'ggg', NULL, NULL, NULL, '43565754', NULL, 'fsd\njjh\n', NULL, NULL, NULL, NULL),
(11, 'yyyy', NULL, NULL, NULL, '4357456', NULL, 'rrr\nhh', NULL, NULL, NULL, NULL),
(12, 'jose', NULL, NULL, NULL, '123456789', NULL, 'jhkjl\nkjuhihujik\nljkkl	', NULL, NULL, NULL, NULL),
(13, 'sample', NULL, NULL, NULL, '1464621', NULL, 'jhhj	\nkjjh	\nkjjkh', NULL, NULL, NULL, NULL),
(14, 'sample', NULL, NULL, NULL, '123467890', NULL, 'hbkjkhj\nfdsf\nd', NULL, NULL, NULL, NULL),
(15, 'ddd', NULL, NULL, NULL, '34523445', NULL, 'fd\nkjhl\ngkjl', NULL, NULL, NULL, NULL),
(16, 'jj', NULL, NULL, NULL, '42445', NULL, 'gffg', NULL, NULL, NULL, NULL),
(17, 'ff', NULL, NULL, NULL, '435454354', NULL, 'fdgdf\ndf\nfga\n', NULL, NULL, NULL, NULL),
(18, 'tt', NULL, NULL, NULL, '45679', NULL, 'jh', NULL, NULL, NULL, NULL),
(19, 'prakash', NULL, '2018-11-21', 'k;jf', '245265789', 'Male', 'dfjkkd', 629158, '2018-11-21', 'birthday', NULL),
(20, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(21, 'aaaaa', NULL, NULL, NULL, '123456789', NULL, 'qqq\nwww\nrrr', NULL, NULL, NULL, NULL),
(22, 'www', NULL, NULL, NULL, '124567890', NULL, 'sssss\neeeee', NULL, NULL, NULL, NULL),
(23, 'jhfc', NULL, NULL, NULL, '123457', NULL, 'hhh	jjjk	', NULL, NULL, NULL, NULL),
(24, 'zzzz', NULL, NULL, NULL, '1234', NULL, 'eryu', NULL, NULL, NULL, NULL),
(25, 'eeeeeeee', NULL, NULL, NULL, '765432', NULL, 'rrrrrrrrrrrrrrrrrrr', NULL, NULL, NULL, NULL),
(26, 'aaa', NULL, NULL, NULL, 'aaaaaaaa', NULL, 'aaaaaaaaaa', NULL, NULL, NULL, NULL),
(27, 'tttttttttt', NULL, NULL, NULL, '2557', NULL, 'ttttttttttttt	', NULL, NULL, NULL, NULL),
(28, 'iiiii', NULL, NULL, NULL, '875432', NULL, 'iiiiiiii	', NULL, NULL, NULL, NULL),
(29, '987654', NULL, NULL, NULL, '98765432', NULL, 'kjhgfd	', NULL, NULL, NULL, NULL),
(30, '87654', NULL, NULL, NULL, '9875', NULL, 'kjhgfcds	', NULL, NULL, NULL, NULL),
(31, '87654', NULL, NULL, NULL, '98765', NULL, 'gfds', NULL, NULL, NULL, NULL),
(32, 'SDFGH', NULL, NULL, NULL, '234567', NULL, 'SDFGHJ', NULL, NULL, NULL, NULL),
(33, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(34, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(35, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(36, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(37, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(38, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(39, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(40, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(41, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(42, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(43, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(44, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(45, 'hallos', NULL, NULL, NULL, '98753733', NULL, 'hallos', NULL, NULL, NULL, NULL),
(46, 'uuiu', NULL, NULL, NULL, '777888', NULL, 'uiufu	', NULL, NULL, NULL, NULL),
(47, 'fdfddf', NULL, NULL, NULL, '5536775788', NULL, 'dfd', NULL, NULL, NULL, NULL),
(48, 'sf', NULL, NULL, NULL, '5356', NULL, 'sdf', NULL, NULL, NULL, NULL),
(49, 'cfc', NULL, NULL, NULL, '4444444444', NULL, 'SCs', NULL, NULL, NULL, NULL),
(50, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(51, 'vccf', NULL, NULL, NULL, '5', NULL, 'ssssss', NULL, NULL, NULL, NULL),
(52, 'hhhhhhh', NULL, NULL, NULL, '777777', NULL, 'hhhh				', NULL, NULL, NULL, NULL),
(53, 'fggg', NULL, NULL, NULL, '5555666', NULL, 'hhhjjjj			', NULL, NULL, NULL, NULL),
(54, 'fffggg', NULL, NULL, NULL, '66666', NULL, 'gggggg		', NULL, NULL, NULL, NULL),
(55, 'vvvvvvv', NULL, NULL, NULL, '4444444', NULL, 'sFFFFFFFF', NULL, NULL, NULL, NULL),
(56, 'ffffff', NULL, NULL, NULL, '55555', NULL, 'hhhhh			', NULL, NULL, NULL, NULL),
(57, 'gggjjj', NULL, NULL, NULL, '444444', NULL, 'jjjjj	', NULL, NULL, NULL, NULL),
(58, 'eeeeeeeeeee', NULL, NULL, NULL, '44444444', NULL, 'ddddddddddddd', NULL, NULL, NULL, NULL),
(59, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(60, '121', NULL, NULL, NULL, '1212', NULL, 'sd', NULL, NULL, NULL, NULL),
(61, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(62, '13', NULL, NULL, NULL, '13', NULL, 'ds', NULL, NULL, NULL, NULL),
(63, '131', NULL, NULL, NULL, '11', NULL, '13', NULL, NULL, NULL, NULL),
(64, '131', NULL, NULL, NULL, '131', NULL, '131', NULL, NULL, NULL, NULL),
(65, 'dfgh', NULL, NULL, NULL, '45', NULL, 'dfghj	', NULL, NULL, NULL, NULL),
(66, 'rrrrrrr', NULL, NULL, NULL, '44444', NULL, 'frrrrrrrrrrrr', NULL, NULL, NULL, NULL),
(67, 'vbm,.', NULL, NULL, NULL, '4568', NULL, 'dfghjl;', NULL, NULL, NULL, NULL),
(68, 'fghjkl;''', NULL, NULL, NULL, '567890', NULL, 'sdfghjl;''\n', NULL, NULL, NULL, NULL),
(69, 'ff', NULL, NULL, NULL, '55', NULL, 'fff', NULL, NULL, NULL, NULL),
(70, 'df', NULL, NULL, NULL, '4444', NULL, 'ffffffff', NULL, NULL, NULL, NULL),
(71, 'ertyuiop', NULL, NULL, NULL, '567890', NULL, 'fghjk;l''	', NULL, NULL, NULL, NULL),
(72, 'rfgjk;''', NULL, NULL, NULL, 'r67890', NULL, 'frghjk;\n', NULL, NULL, NULL, NULL),
(73, 'dfghjkl', NULL, NULL, NULL, '34567', NULL, 'fgh	jk', NULL, NULL, NULL, NULL),
(74, '3333333', NULL, NULL, NULL, '333333', NULL, '3333333', NULL, NULL, NULL, NULL),
(75, 'fffffffffff', NULL, NULL, NULL, '55555555555', NULL, 'fffffffffffffffffffffffffffffffffffffffffffffff', NULL, NULL, NULL, NULL),
(76, 'cccccccccc', NULL, NULL, NULL, '3333333', NULL, 'ccccccccccc', NULL, NULL, NULL, NULL),
(77, 'fdddd', NULL, NULL, NULL, '2222222', NULL, 'cccccccccc', NULL, NULL, NULL, NULL),
(78, '3333', NULL, NULL, NULL, '3333333', NULL, '3333333', NULL, NULL, NULL, NULL),
(79, '2222', NULL, NULL, NULL, '2222', NULL, '2222222', NULL, NULL, NULL, NULL),
(80, '222', NULL, NULL, NULL, '222', NULL, '2222222', NULL, NULL, NULL, NULL),
(81, '11111111', NULL, NULL, NULL, '111', NULL, '111111', NULL, NULL, NULL, NULL),
(82, 'ajiydg', NULL, NULL, NULL, '656656', NULL, 'dfkkkkkkkkkkkk', NULL, NULL, NULL, NULL),
(83, '222', NULL, NULL, NULL, '2', NULL, '2222', NULL, NULL, NULL, NULL),
(84, '', NULL, NULL, NULL, '', NULL, '', NULL, NULL, NULL, NULL),
(85, '2222222222222222', NULL, NULL, NULL, '22222', NULL, '2222222222222', NULL, NULL, NULL, NULL),
(86, 'AJITH', NULL, NULL, NULL, '11111', NULL, '11111111', NULL, NULL, NULL, NULL),
(87, 'asddd', NULL, NULL, NULL, '3333333', NULL, 'dddddd', NULL, NULL, NULL, NULL),
(88, 'ajith', NULL, NULL, NULL, '97905098087', NULL, 'sdfkjSKJFCBKJ', NULL, NULL, NULL, NULL),
(89, 'muthu ', NULL, NULL, NULL, '9337748', NULL, 'mamoodu\nkulsekhtrm\n							', NULL, NULL, NULL, NULL),
(90, 'jhgfds', NULL, NULL, NULL, '975r', NULL, 'oiuytre', NULL, NULL, NULL, NULL),
(91, 'ytfhgj', NULL, '1970-01-01', 'z@gmail.com', '988466464', 'Male', 'jhjhg\nyft\nkghcdh\nljgfytu', 216486, '1970-01-01', 'kiug', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `EmployeeId` int(11) NOT NULL,
  `EmployeeName` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `pin` int(11) NOT NULL,
  `ContactNo` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `DateofBirth` date DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `AatharNo` bigint(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeId`, `EmployeeName`, `Status`, `Date`, `pin`, `ContactNo`, `Address`, `DateofBirth`, `Gender`, `AatharNo`, `Email`) VALUES
(3, 'gebfd', NULL, '1970-01-01', 4287278, '6242', 'dfhgb\nfjhjn\nkjgjk', '1970-01-01', 'Female', 8762822, 'fgEDytre'),
(4, 'jhgk', NULL, '2018-07-11', 547665, '7772', 'dfh\njl;km;\ngi/l;', '2018-07-30', 'Male', 2354334, '@gmail.com'),
(5, 'shakin', NULL, '2018-07-31', 266322, '566656666', 'hjk	jlkjkl	kjljkljkl	kjljkljk	l\nklnlkj;\nlmk;lkjn', '2018-07-02', 'Male', 4623269623, 'Gmail.com'),
(6, 'sgbfd', NULL, '2018-07-31', 23453, '345453', 'fdsg	', '2018-07-01', 'Female', 345432, '@gmail.com'),
(7, 'fdsgf', NULL, '2018-07-31', 3444453, '346546', 'dsaf', '2018-07-01', 'Male', 246534, '2yahoo.com'),
(8, 'sfdg', NULL, '2018-07-31', 32543, '5432', 'sdfs\n	', '2018-07-03', 'Male', 435543, '@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `InvoiceId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`InvoiceId`) VALUES
(0);

-- --------------------------------------------------------

--
-- Table structure for table `ledger`
--

CREATE TABLE IF NOT EXISTS `ledger` (
  `LedgerId` int(11) NOT NULL,
  `LedgerName` varchar(255) NOT NULL,
  `AccountGroupId` int(11) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `LedgerCode` varchar(255) DEFAULT NULL,
  `CustomerId` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ledger`
--

INSERT INTO `ledger` (`LedgerId`, `LedgerName`, `AccountGroupId`, `Date`, `Status`, `LedgerCode`, `CustomerId`) VALUES
(1, 'gfdgf', NULL, '2018-08-10 12:57:44', 'A', NULL, NULL),
(2, 'abcdef', 1, '2018-08-10 13:01:15', 'A', NULL, NULL),
(3, 'ghijk', 2, '2018-08-10 13:01:57', 'D', NULL, NULL),
(4, 'name', 3, '2018-09-18 10:34:41', 'A', '11aa', NULL),
(5, 'asdf', 2, '2018-09-18 17:22:04', 'A', '22bb', 11);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `LoginId` int(11) NOT NULL,
  `Password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`LoginId`, `Password`) VALUES
(4, 'hallos'),
(5, 'jose');

-- --------------------------------------------------------

--
-- Table structure for table `model`
--

CREATE TABLE IF NOT EXISTS `model` (
  `ModelId` int(11) NOT NULL,
  `ModelCode` varchar(255) DEFAULT NULL,
  `ModelName` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `model`
--

INSERT INTO `model` (`ModelId`, `ModelCode`, `ModelName`, `Date`, `Status`) VALUES
(1, '1', 'a', '2018-09-19', 'A'),
(2, '2', 'b', '2018-09-19', 'A'),
(3, '3', 'c', '2018-09-19', 'A'),
(4, '4', 'd', '1970-01-01', 'A'),
(5, '5', 'e', '2018-09-19', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `ProductId` int(11) NOT NULL,
  `ProductName` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `UnitId` int(11) DEFAULT NULL,
  `ProductCode` varchar(255) DEFAULT NULL,
  `CatId` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductId`, `ProductName`, `Status`, `Date`, `UnitId`, `ProductCode`, `CatId`) VALUES
(3, 'jewel1', 'A', '1970-01-01', NULL, 'one', 11),
(4, 'jewel2', 'A', '1970-01-01', NULL, 'two', 12),
(7, 'jewel3', 'A', '1970-01-01', NULL, 'three', 13),
(8, 'jewel4', 'A', '1970-01-01', NULL, 'four', 10),
(9, 'jewel5', 'A', '1970-01-01', NULL, 'five', 14),
(10, 'ww', 'A', '1970-01-01', NULL, 'q', 13);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE IF NOT EXISTS `purchase` (
  `PurchaseId` int(11) NOT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `Quantity` double DEFAULT NULL,
  `Amount` bigint(20) DEFAULT NULL,
  `VendorId` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `BillId` int(11) NOT NULL,
  `CatId` int(11) NOT NULL,
  `UnitId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`PurchaseId`, `Status`, `Date`, `Quantity`, `Amount`, `VendorId`, `ProductId`, `BillId`, `CatId`, `UnitId`) VALUES
(1, NULL, '2018-08-07 16:26:05', 3, 7, 0, 0, 0, 0, 0),
(4, NULL, '2018-08-07 16:34:02', 11, 1111, 0, 1, 1, 0, 1),
(5, NULL, '2018-08-07 16:37:10', 2, 2, 0, 1, 2, 0, 1),
(6, NULL, '2018-08-07 16:37:10', 3, 3, 0, 1, 3, 0, 1),
(7, NULL, '2018-08-09 12:26:38', 11, 111, 0, 1, 1, 0, 1),
(8, NULL, '2018-08-09 12:26:38', 22, 222, 0, 1, 2, 0, 1),
(9, NULL, '2018-08-09 12:26:38', 33, 333, 0, 1, 3, 0, 1),
(10, NULL, '2018-08-09 12:26:38', 44, 444, 0, 1, 4, 0, 1),
(11, NULL, '2018-08-09 12:26:38', 55, 555, 0, 1, 5, 0, 1),
(12, NULL, '2018-08-09 12:26:38', 66, 666, 0, 1, 6, 0, 1),
(13, NULL, '2018-08-09 12:30:10', 22, 222222, 0, 1, 33, 0, 1),
(14, NULL, '2018-08-09 12:30:10', 7, 777, 0, 1, 77, 0, 1),
(15, NULL, '2018-08-09 12:30:10', 888, 88888, 0, 1, 8, 0, 1),
(16, NULL, '2018-08-09 12:30:10', 99, 99999, 0, 1, 9, 0, 1),
(17, NULL, '2018-08-09 12:32:35', 3, 3, 0, 1, 3, 0, 1),
(18, NULL, '2018-08-09 12:32:36', 4, 4, 0, 1, 4, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `purchasescreen`
--

CREATE TABLE IF NOT EXISTS `purchasescreen` (
  `PurchaseId` int(11) NOT NULL,
  `HSNCode` varchar(255) DEFAULT NULL,
  `ProductName` int(11) DEFAULT NULL,
  `Purity` double DEFAULT NULL,
  `Gwt` double DEFAULT NULL,
  `Touch` double DEFAULT NULL,
  `Netwt` double DEFAULT NULL,
  `Rate` double DEFAULT NULL,
  `Totalamt` double DEFAULT NULL,
  `Sumamt` double DEFAULT NULL,
  `Roundoff` double DEFAULT NULL,
  `LastTotAmt` double DEFAULT NULL,
  `Amtinwords` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `purchasescreen`
--

INSERT INTO `purchasescreen` (`PurchaseId`, `HSNCode`, `ProductName`, `Purity`, `Gwt`, `Touch`, `Netwt`, `Rate`, `Totalamt`, `Sumamt`, `Roundoff`, `LastTotAmt`, `Amtinwords`) VALUES
(1, '1', 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'one only/-'),
(2, '111', 3, 1, 1, 1, 11, 1, 1, 8, 88, 8, 'eight'),
(3, '1', 3, 11, 1, 1, 1, 1, 1, 5, 5, 5, 'three'),
(4, '1', 3, 2, 2, 2, 2, 2, 3, 3, 3, 3, 'three'),
(5, '2', 3, 2, 2, 2, 2, 2, 3, 3, 3, 3, '3'),
(6, '2', 3, 2, 2, 2, 2, 22, 3, 3, 3, 3, '3'),
(7, '4', 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 'four only/-'),
(8, '4', 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, '4'),
(9, '4', 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, '4'),
(10, '3', 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 'three'),
(11, '3', 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, '3');

-- --------------------------------------------------------

--
-- Table structure for table `qucashdata`
--

CREATE TABLE IF NOT EXISTS `qucashdata` (
  `CashDataId` int(11) NOT NULL,
  `Cash` varchar(255) DEFAULT NULL,
  `CustomerId` int(11) NOT NULL,
  `Cashdiscount` double DEFAULT NULL,
  `Taxrs` double DEFAULT NULL,
  `Cgst` double DEFAULT NULL,
  `Sgst` double DEFAULT NULL,
  `IGST` double DEFAULT NULL,
  `Totalamtpay` double DEFAULT NULL,
  `Amntinwords` varchar(255) DEFAULT NULL,
  `Invoiceno` varchar(255) DEFAULT NULL,
  `Date` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `qucashdata`
--

INSERT INTO `qucashdata` (`CashDataId`, `Cash`, `CustomerId`, `Cashdiscount`, `Taxrs`, `Cgst`, `Sgst`, `IGST`, `Totalamtpay`, `Amntinwords`, `Invoiceno`, `Date`) VALUES
(1, '', 33, 1000, 70304, 7173.9, 5739.12, 9565.2, 92782.21999999999, 'Rupees Ninety Two Thousand Seven Hundred and Eighty Two Only', '', '2019-01-24 13:50:47'),
(2, '', 34, 1000, 70304, 7173.9, 5739.12, 9565.2, 92782.21999999999, 'Rupees Ninety Two Thousand Seven Hundred and Eighty Two Only', '', '2019-01-24 13:58:31'),
(3, '', 35, 1000, 70304, 7173.9, 5739.12, 9565.2, 92782.21999999999, 'Rupees Ninety Two Thousand Seven Hundred and Eighty Two Only', '', '2019-01-24 14:49:44'),
(4, '', 37, 1000, 70304, 7173.9, 5739.12, 9565.2, 92782.21999999999, 'Rupees Ninety Two Thousand Seven Hundred and Eighty Two Only', '', '2019-01-24 14:55:43'),
(5, '', 38, 1000, 70304, 7173.9, 5739.12, 9565.2, 92782.21999999999, 'Rupees Ninety Two Thousand Seven Hundred and Eighty Two Only', '', '2019-01-24 15:06:12'),
(6, '', 39, 1000, 70304, 7173.9, 5739.12, 9565.2, 92782.21999999999, 'Rupees Ninety Two Thousand Seven Hundred and Eighty Two Only', '', '2019-01-24 15:17:37'),
(7, '', 40, 2000, 193736, 19768.95, 15815.16, 26358.6, 255678.71000000002, 'Rupees Two Lakh Fifty Five Thousand Six Hundred and Seventy Eight Only', '', '2019-01-24 15:29:16'),
(8, '', 41, 1000, 70304, 7173.9, 5739.12, 9565.2, 92782.21999999999, 'Rupees Ninety Two Thousand Seven Hundred and Eighty Two Only', '', '2019-01-24 15:41:10'),
(9, '', 42, 1000, 70304, 7173.9, 5739.12, 9565.2, 92782.21999999999, 'Rupees Ninety Two Thousand Seven Hundred and Eighty Two Only', '', '2019-01-24 15:43:58'),
(10, '', 43, 10000, 791920, 80808.15, 64646.52, 107744.2, 1045118.87, 'Rupees Ten Lakh Forty Five Thousand One Hundred and Eighteen Only', '', '2019-01-24 15:53:28'),
(11, '', 44, 2000, 114736, 11707.8, 9366.24, 15610.4, 151420.44, 'Rupees One Lakh Fifty One Thousand Four Hundred and Twenty Only', '', '2019-01-24 15:58:09');

-- --------------------------------------------------------

--
-- Table structure for table `qusalesscreen`
--

CREATE TABLE IF NOT EXISTS `qusalesscreen` (
  `SalesScreenId` int(11) NOT NULL,
  `ProductCode` int(11) DEFAULT NULL,
  `ProductName` int(11) DEFAULT NULL,
  `HSNCode` varchar(255) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Gwt` double DEFAULT NULL,
  `Swt` double DEFAULT NULL,
  `Netwt` double DEFAULT NULL,
  `Rate` double DEFAULT NULL,
  `Va` double DEFAULT NULL,
  `AfterDis` double DEFAULT NULL,
  `StoneCash` double DEFAULT NULL,
  `Totalamount` double DEFAULT NULL,
  `ModelId` int(11) DEFAULT NULL,
  `CashDataId` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `qusalesscreen`
--

INSERT INTO `qusalesscreen` (`SalesScreenId`, `ProductCode`, `ProductName`, `HSNCode`, `Quantity`, `Gwt`, `Swt`, `Netwt`, `Rate`, `Va`, `AfterDis`, `StoneCash`, `Totalamount`, `ModelId`, `CashDataId`) VALUES
(1, 1, 3, '5', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 15),
(2, 6, 1, '3', 3, 3, 10, 2, 8, 35200, NULL, 1, 100, 35652, 15),
(3, 1, 3, '2', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 15),
(4, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 15),
(5, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 15),
(6, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 15),
(7, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 15),
(8, 1, 3, '1', 1, 20, 2, 18, 79200, 1, NULL, 100, 79992, 3, 15),
(9, 3, 3, '2', 1, 1, 20, 2, 18, 79200, NULL, 1, 100, 80092, 15),
(10, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 15),
(11, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 15),
(12, 1, 3, '1', 1, 100, 10, 90, 396000, 1, NULL, 1000, 400960, 3, 15),
(13, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 200, 35752, 3, 15),
(14, 3, 3, '2', 2, 20, 2, 18, 79200, 2, NULL, 200, 80984, 1, 15);

-- --------------------------------------------------------

--
-- Table structure for table `rate`
--

CREATE TABLE IF NOT EXISTS `rate` (
  `RateId` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Amount` double DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `UnitId` int(11) DEFAULT NULL,
  `CatId` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rate`
--

INSERT INTO `rate` (`RateId`, `Date`, `Amount`, `Status`, `UnitId`, `CatId`) VALUES
(37, '2018-09-06', 100, 'A', 1, 10),
(38, '2018-09-06', 44000, 'A', 3, 11),
(39, '1970-01-01', 2200, 'A', 3, 12),
(40, '2018-09-10', 4400, 'A', 3, 11),
(41, '2018-09-06', 1500, 'A', 1, 13),
(42, '2018-09-06', 2000, 'A', 2, 13),
(43, '2018-09-06', 2500, 'A', 3, 13),
(44, '2018-09-06', 5000, 'A', 1, 14),
(45, '2018-09-09', 1100, 'A', 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `SalesId` int(11) NOT NULL,
  `Date` datetime DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Amount` bigint(20) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `CustomerId` int(11) DEFAULT NULL,
  `UnitId` int(11) DEFAULT NULL,
  `VendorId` int(11) DEFAULT NULL,
  `CatId` int(11) DEFAULT NULL,
  `ProductId` int(11) DEFAULT NULL,
  `RateId` int(11) DEFAULT NULL,
  `TaxId` int(11) DEFAULT NULL,
  `Gram` float DEFAULT NULL,
  `Discount` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`SalesId`, `Date`, `Status`, `Amount`, `Quantity`, `CustomerId`, `UnitId`, `VendorId`, `CatId`, `ProductId`, `RateId`, `TaxId`, `Gram`, `Discount`) VALUES
(1, '2018-09-04 15:31:17', NULL, 1111, 1, 0, 1, 0, 0, 1, 0, 0, 11, 1111),
(2, '2018-09-04 15:40:54', NULL, 222, 2, 0, 1, 0, 0, 1, 0, 0, 2, 22),
(3, '2018-09-04 15:43:38', NULL, 222, 2, 0, 1, 0, 0, 1, 0, 0, 2, 22),
(4, '2018-09-04 15:44:20', NULL, 4, 1, 0, 1, 0, 0, 1, 0, 0, 2, 3),
(5, '2018-09-04 15:49:16', NULL, 8, 2, 0, 1, 0, 0, 1, 0, 0, 2, 8),
(6, '2018-09-04 16:02:51', NULL, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1),
(7, '2018-09-04 16:10:32', NULL, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1),
(8, '2018-09-04 16:20:37', NULL, 112, 222, 0, 1, 0, 0, 1, 0, 0, 22, 333),
(9, '2018-09-04 16:20:37', NULL, 88, 55, 0, 1, 0, 0, 1, 0, 0, 67, 88),
(10, '2018-09-04 16:20:37', NULL, 34, 67, 0, 1, 0, 0, 1, 0, 0, 44, 3434),
(11, '2018-09-05 11:08:55', NULL, 22, 22, 0, 1, 0, 0, 1, 0, 0, 22, 22),
(12, '2018-09-05 11:08:55', NULL, 33, 33, 0, 2, 0, 0, 1, 0, 0, 33, 33),
(13, '2018-09-05 11:08:55', NULL, 44, 44, 0, 2, 0, 0, 1, 0, 0, 44, 44),
(14, '2018-09-05 11:08:55', NULL, 55, 55, 0, 3, 0, 0, 1, 0, 0, 55, 55),
(15, '2018-09-05 11:09:38', NULL, 77, 77, 0, 2, 0, 0, 1, 0, 0, 77, 77),
(16, '2018-09-05 11:09:38', NULL, 888, 88, 0, 3, 0, 0, 1, 0, 0, 88, 88),
(17, '2018-09-05 11:10:43', NULL, 99, 9999, 0, 1, 0, 0, 1, 0, 0, 99, 99),
(18, '2018-09-05 11:10:44', NULL, 777777, 77, 0, 2, 0, 0, 1, 0, 0, 777, 77),
(19, '2018-09-05 11:10:44', NULL, 888888, 88, 0, 1, 0, 0, 1, 0, 0, 8888, 888),
(20, '2018-09-10 18:44:41', NULL, 4400, 1, 0, 1, 0, 0, 3, 0, 0, 1, 1),
(21, '2018-09-10 18:44:42', NULL, 22, 1, 0, 1, 0, 0, 3, 0, 0, 2, 2),
(22, '2018-09-10 18:45:33', NULL, 13200, 3, 0, 1, 0, 0, 3, 0, 0, 3, 3),
(23, '2018-09-10 18:45:33', NULL, 3, 3, 0, 1, 0, 0, 3, 0, 0, 3, 3),
(24, '2018-09-14 12:12:27', NULL, 8800, 1, 0, 1, 0, 0, 3, 0, 0, 2, 2),
(25, '2018-09-14 12:12:27', NULL, 13200, 3, 0, 2, 0, 0, 3, 0, 0, 3, 3),
(26, '2018-09-14 12:18:25', NULL, 4400, 1, 0, 1, 0, 0, 3, 0, 0, 1, 1),
(27, '2018-09-14 12:18:25', NULL, 8800, 1, 0, 1, 0, 0, 3, 0, 0, 2, 2),
(28, '2018-09-14 12:22:20', NULL, 48400, 1, 0, 1, 0, 0, 3, 0, 0, 11, 1),
(29, '2018-09-14 12:57:43', NULL, 4400, 1, 0, 1, 0, 0, 3, 0, 0, 1, 1),
(30, '2018-09-14 13:04:25', NULL, 4400, 1, 0, 1, 0, 0, 3, 0, 0, 1, 1),
(31, '2018-09-14 13:04:25', NULL, 8800, 2, 0, 2, 0, 0, 3, 0, 0, 2, 2),
(32, '2018-09-14 13:06:59', NULL, 4400, 1, 0, 1, 0, 0, 3, 0, 0, 1, 1),
(33, '2018-09-14 13:11:06', NULL, 4400, 1, 0, 1, 0, 0, 3, 0, 0, 1, 1),
(34, '2018-09-14 13:12:35', NULL, 4400, 1, 0, 1, 0, 0, 3, 0, 0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `salesscreen`
--

CREATE TABLE IF NOT EXISTS `salesscreen` (
  `SalesScreenId` int(11) NOT NULL,
  `ProductCode` int(11) DEFAULT NULL,
  `ProductName` int(11) DEFAULT NULL,
  `HSNCode` varchar(255) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Gwt` double DEFAULT NULL,
  `Swt` double DEFAULT NULL,
  `Netwt` double DEFAULT NULL,
  `Rate` double DEFAULT NULL,
  `Va` double DEFAULT NULL,
  `AfterDis` double DEFAULT NULL,
  `StoneCash` double DEFAULT NULL,
  `Totalamount` double DEFAULT NULL,
  `ModelId` int(11) DEFAULT NULL,
  `CashDataId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `salesscreen`
--

INSERT INTO `salesscreen` (`SalesScreenId`, `ProductCode`, `ProductName`, `HSNCode`, `Quantity`, `Gwt`, `Swt`, `Netwt`, `Rate`, `Va`, `AfterDis`, `StoneCash`, `Totalamount`, `ModelId`, `CashDataId`) VALUES
(1, 3, 3, '12', 1, 1, 1, 1, 11, 11, 11, 1, 11, 10, 0),
(2, 3, 3, '2', 2, 2, 22, 2, 2, 22, 2, 2, 2, 14, 0),
(3, 3, 3, '2', 222, 22, 22, 2, 2222, 22, 22, 22, 2, 10, 0),
(4, 3, 3, '', 444, 44, 44, 44, 44, 44, 4, 44, 4, 12, 0),
(5, 4, 4, '12', 2, 9, 9, 9, 9, 9, 9, 9, 9, 12, 0),
(6, 3, 3, '2', 77, 777, 777, 77, 77, 777, 77, 77, 77, 10, 0),
(7, 3, 3, '8', 8, 8, 8, 8, 8, 8, 8, 8, 8, 10, 0),
(8, 3, 3, '2', 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 0),
(9, 3, 3, '3', 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0),
(10, 4, 3, '3', 10, 4, 4, 4, 4, 4, 4, 4, 4, 47, 0),
(11, 5, 3, '3', 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0),
(12, 6, 3, '3', 10, 66, 6, 6, 6, 6, 6, 6, 6, 6, 0),
(13, 3, 3, '2', 22, 22, 22, 222, 22, 22, 22, 22, 2, 10, 4),
(14, 33, 3, '3', 10, 33, 3, 3, 33, 3, 333, 33, 33, 3, 4),
(15, 33, 3, '3', 10, 44, 44, 44, 4, 4, 44, 4, 44, 4, 4),
(16, 3, 3, '1', 111, 11, 11, 11, 11, 11, 11, 11, 11, 13, 5),
(17, 2, 3, '3', 13, 22, 22, 22, 2, 22, 22, 22, 2, 22, 5),
(18, 3, 3, '3', 13, 33, 33, 3, 3, 33, 33, 3, 33, 33, 5),
(19, 3, 3, '33', 33, 3, 33, 33, 3, 33, 33, 33, 33, 11, 6),
(20, 9, 3, '3', 11, 9, 99, 9, 99, 9, 9, 99, 9, 9, 6),
(21, 8, 3, '3', 11, 88, 8, 8, 88, 8, 88, 8, 8, 88, 6),
(22, 7, 3, '3', 11, 77, 7, 77, 7, 7, 7, 77, 7, 7, 6),
(23, 1, 3, '1', 1, 8, 2, 6, 26400, 1, NULL, 200, 26864, 3, 12),
(24, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 1000, 36552, 3, 13),
(25, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 14),
(26, 2, 1, '3', 3, 2, 20, 5, 15, 66000, NULL, 2, 2000, 69320, 14),
(27, 1, 3, '1', 2, 10, 2, 8, 35200, 1, NULL, 1000, 36552, 3, 15),
(28, 2, 1, '3', 3, 2, 20, 10, 10, 44000, NULL, 2, 2000, 46880, 15),
(29, 1, 3, '1', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 16),
(30, 2, 1, '3', 3, 2, 10, 2, 8, 35200, NULL, 1, 100, 35652, 16),
(31, 3, 1, '3', 3, 3, 10, 2, 8, 35200, NULL, 1, 100, 35652, 16),
(32, 1, 3, 'jfh', 1, 1, 1, 0.01, 44, 1, NULL, 464, 508.44, 3, 17),
(33, 1, 3, 'sds', 1, 1, 1, 0, 0, 1, NULL, 4, 4, 3, 18),
(34, 1, 3, 'dddd', 2, 5, 677, -672, -2956800, 7, NULL, 89, -3163687, 3, 19),
(35, 1, 3, '333', 4, 3, 5, -2, -8800, 5, NULL, 5, -9235, 3, 20),
(36, 444, 1, '3', 3, 6, 7, 8, -1, 35200, NULL, 6, 9, 37321, 20),
(37, 1, 3, 'cfdf', 1, 3, 3, 0.03, 132.03, 3, NULL, 3, 138.9909, 3, 21),
(38, 1, 3, 'ggg', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 22),
(39, 1, 3, 'gggg', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 23),
(40, 1, 3, '1', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 24),
(41, 1, 3, 'ssssssssss', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 25),
(42, 1, 3, 'sdff', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.45011, 3, 26),
(43, 1, 3, '222', 1, 1, 1, 0.01, 44, 11, NULL, 1, 48.84, 3, 27),
(44, 1, 3, 'ffff', 1, 1, 1, 0.01, 44.01, 11, NULL, 11, 59.851099999999995, 3, 28),
(45, 1, 3, '1', 1, 2, 1, 1, 4400, 12, NULL, 23, 4951, 3, 29),
(46, 1, 3, '2', 2, 2, 1, 1, 4400, 12, NULL, 234, 5162, 3, 30),
(47, 1, 3, '1', 3, 4, 1, 3, 13200, 23, NULL, 100, 16336, 3, 31),
(48, 1, 3, '2', 4, 3, 1, 2, 8800, 12, NULL, 200, 10056, 3, 32),
(49, 1, 3, '1', 1, 12, 1, 11, 48400, 1, NULL, 111, 48995, 3, 33),
(50, 1, 3, 'ffffffffffffff', 1, 2, 2, 0.02, 88, 3, NULL, 7, 97.64, 3, 34),
(51, 1, 3, '1', 1, 12, 2, 10, 44000, 1, NULL, 100, 44540, 3, 35),
(52, 1, 3, '1', 1, 12, 1, 11, 48400, 1, NULL, 1111, 49995, 3, 36),
(53, 1, 3, '444', 1, 1, 1, 0, 0.01, 1, NULL, 1, 1.0101, 3, 37),
(54, 1, 3, 'ffffffff', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.45011, 3, 38),
(55, 1, 3, '1', 1, 12, 2, 10, 44000, 1, NULL, 123, 44563, 3, 39),
(56, 1, 3, '1', 1, 112, 12, 100, 440000, 1, NULL, 11, 444411, 3, 40),
(57, 1, 3, '1', 1, 12, 2, 10, 44000, 2, NULL, 2, 44882, 3, 41),
(58, 22, 1, '3', 3, 2, 2, 2, 0.02, 88.02, NULL, 2, 2, 92, 41),
(59, 1, 3, '11111', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 41),
(60, 4444, 1, '3', 3, 2, 2, 2, 0.02, 88.02, NULL, 2, 2, 92, 41),
(61, 1, 3, 'qqqqqqq', 1, 2, 2, 0.01, 44, 1, NULL, 1, 45.44, 3, 41),
(62, 1, 3, 'fffff', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 41),
(63, 22, 1, '3', 3, 2, 2, 2, 0.02, 88.02, NULL, 2, 2, 92, 41),
(64, 1, 3, 'ddd', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 41),
(65, 1, 3, '2', 22222, 22, 3, 19, 83600.04, 4, NULL, 4, 86948.0416, 3, 41),
(66, 1, 3, '1', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 41),
(67, 1, 3, '22', 2, 2, 2, 0.02, 88.02, 2, NULL, 2, 91.7804, 3, 41),
(68, 2, 1, '3', 3, 3, 3, 3, 0.03, 132.03, NULL, 3, 3, 139, 41),
(69, 1, 3, '1111', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 41),
(70, 2222, 1, '3', 3, 2, 2, 2, 0.02, 88.02, NULL, 2, 2, 92, 41),
(71, 1, 3, '1', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 41),
(72, 2222, 1, '3', 3, 2, 2, 2, 0.02, 88.02, NULL, 2, 2, 92, 41),
(73, 2, 1, '3', 3, 2, 2, 2, 0, 2, NULL, 2, 2, 4, 41),
(74, 1, 3, '111', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 41),
(75, 2222, 1, '3', 3, 2, 2, 2, 0.02, 88.02, NULL, 2, 2, 92, 41),
(76, 1, 3, '1111', 1, 1, 1, 0.01, 44.1, 1, NULL, 1, 45.541000000000004, 3, 41),
(77, 222, 1, '3', 3, 2, 2, 2, 0.02, 88.02, NULL, 2, 2, 92, 41),
(78, 1, 3, 'a', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 42),
(79, 1, 3, '1', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 43),
(80, 2, 1, '3', 3, 2, 2, 2, 0.02, 82, NULL, 2, 2, 86, 43),
(81, 1, 3, '1', 1, 1, 1, 0.01, 44.01, 1, NULL, 1, 45.4501, 3, 44),
(82, 2, 1, '3', 3, 2, 2, 2, 0.02, 88.02, NULL, 2, 2, 92, 44),
(83, 3, 1, '3', 3, 3, 3, 3, 0.03, 132.03, NULL, 3, 3, 139, 44),
(84, 1, 3, '3333', 1, 10, 2, 8, 35200, 1, NULL, 100, 35652, 3, 45),
(85, 2222, 1, '3', 3, 3, 19, 5, 14, 61600, NULL, 1, 1000, 63216, 45);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
  `StockId` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `ProductId` int(11) DEFAULT NULL,
  `ModelId` int(11) DEFAULT NULL,
  `NetWt` double DEFAULT NULL,
  `Quantity` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`StockId`, `Date`, `ProductId`, `ModelId`, `NetWt`, `Quantity`) VALUES
(2, '1970-01-01', 3, 1, 100.1, 14),
(3, '2018-09-12', 3, 3, 104, 11),
(4, '2019-01-21', 3, 1, -8, -2),
(5, '2019-01-26', 3, 1, -8, -1),
(6, '2019-01-26', 3, 1, 2, -4),
(7, '2019-01-25', 3, 1, -0.03, -1),
(8, '2019-01-26', 3, 1, -0.01, -1),
(9, '2019-01-25', 3, 1, -0.01, -1),
(10, '2019-01-25', 3, 1, -0.01, -1),
(11, '2019-01-26', 3, 1, -0.01, -1),
(12, '2019-01-24', 3, 1, -0.01, -1),
(13, '2019-01-26', 3, 1, -0.01, -1),
(14, '2019-01-26', 3, 1, -0.01, -1),
(15, '2019-01-16', 3, 1, -1, -1),
(16, '2019-01-15', 3, 1, -1, -2),
(17, '2019-01-24', 3, 1, -3, -3),
(18, '2019-01-17', 3, 1, -2, -4),
(19, '2019-01-10', 3, 1, -11, -1),
(20, '2019-01-25', 3, 1, -0.02, -1),
(21, '2019-01-02', 3, 1, -10, -1),
(22, '2019-01-02', 3, 1, -11, -1),
(23, '2019-01-26', 3, 1, 0, -1),
(24, '2019-01-26', 3, 1, -0.01, -1),
(25, '2019-01-12', 3, 1, -10, -1),
(26, '2019-01-10', 3, 1, -100, -1),
(27, '2019-01-04', 3, 1, -10, -1),
(28, '2019-01-27', 3, 1, -0.01, -1),
(29, '2019-01-27', 3, 1, -0.01, -1),
(30, '2019-01-28', 3, 1, -19, -22222),
(31, '2019-01-27', 3, 1, -0.01, -1),
(32, '2019-01-27', 3, 1, -0.02, -2),
(33, '2019-01-27', 3, 1, -0.01, -1),
(34, '2019-01-27', 3, 1, -0.01, -1),
(35, '2019-01-27', 3, 1, -0.01, -1),
(36, '2019-01-27', 3, 1, -0.01, -1),
(37, '2019-01-27', 3, 1, -0.01, -1),
(38, '2019-01-27', 3, 1, -0.01, -1),
(39, '2019-01-30', 3, 1, -8, -1);

-- --------------------------------------------------------

--
-- Table structure for table `tax`
--

CREATE TABLE IF NOT EXISTS `tax` (
  `TaxId` int(11) NOT NULL,
  `SGST` double DEFAULT NULL,
  `CGST` double DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `IGST` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tax`
--

INSERT INTO `tax` (`TaxId`, `SGST`, `CGST`, `Date`, `Status`, `IGST`) VALUES
(42, 12, 15, '2018-09-06', 'A', 20),
(43, 78, 67, '2019-06-13', 'A', 67),
(44, 66, 77, '2019-06-13', 'A', 77),
(45, 788, 98, '2019-06-20', 'A', 67);

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

CREATE TABLE IF NOT EXISTS `unit` (
  `UnitId` int(11) NOT NULL,
  `Carat` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unit`
--

INSERT INTO `unit` (`UnitId`, `Carat`) VALUES
(1, 18),
(2, 22),
(3, 24);

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE IF NOT EXISTS `vendor` (
  `VendorId` int(11) NOT NULL,
  `VendorName` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `AatharNo` bigint(11) DEFAULT NULL,
  `ContactNo` varchar(255) DEFAULT NULL,
  `VendorCode` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`VendorId`, `VendorName`, `Status`, `Date`, `Address`, `AatharNo`, `ContactNo`, `VendorCode`) VALUES
(2, 'PRAKASH', 'A', '2018-07-28', '646ljjhlkhj	\nlkjkhj\nhbgkhjg\\\nkhjggjh\n', 446646124644646, '918344396312', 'LL55'),
(3, 'www', 'A', '2018-08-25', 'eee', 4578905670987, '87456789', '11'),
(4, 'gfgg', 'A', '2018-08-25', 'ffffffffffffffff', 256789098765, '987654322', '222'),
(5, 'fdf', 'A', '2018-08-25', 'dsf', 674533222432, '554332244', 'd4'),
(6, 'jjjj', 'A', '2018-08-25', 'wwww', 98765434778, '987654357', '222'),
(7, 'gfd', 'A', '2018-08-25', 'tfr', 24578987654, '987654322', '111'),
(8, 'wwwwqqq', 'A', '2018-08-25', 'qwqw', 1234567890876, '987654321', 'rt5'),
(9, 'jjjjooo', 'A', '2018-08-25', 'jhghgh', 123457890876, '987654321', 'r15'),
(11, 'qqq', 'D', '2018-09-04', 'qqq\nq\nq\nq', 5643432343, '24465476', 'qqq'),
(12, 'qrwe', 'A', '2018-09-04', 'rwsdfawd\nasdfg\ndsfg\n', 2342334345345, '3443524323', 'ewtq342'),
(13, 'erwdsgf', 'A', '2018-09-04', 'efdasa\nafgs\nseda\n', 3234334435453, '453643534545', '35eerw'),
(14, 'abc', 'A', '2018-09-05', 'kkkk	\nkllklk	\nkljkk', 987634567898, '987654334567', '7687689');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountgroup`
--
ALTER TABLE `accountgroup`
  ADD PRIMARY KEY (`AccountGroupId`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`BillId`),
  ADD UNIQUE KEY `VendorId` (`VendorId`);

--
-- Indexes for table `cashdata`
--
ALTER TABLE `cashdata`
  ADD PRIMARY KEY (`CashDataId`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CatId`),
  ADD UNIQUE KEY `CatId` (`CatId`),
  ADD UNIQUE KEY `UnitId` (`UnitId`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeId`);

--
-- Indexes for table `ledger`
--
ALTER TABLE `ledger`
  ADD PRIMARY KEY (`LedgerId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`LoginId`);

--
-- Indexes for table `model`
--
ALTER TABLE `model`
  ADD PRIMARY KEY (`ModelId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductId`),
  ADD UNIQUE KEY `UnitId` (`UnitId`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`PurchaseId`);

--
-- Indexes for table `purchasescreen`
--
ALTER TABLE `purchasescreen`
  ADD PRIMARY KEY (`PurchaseId`);

--
-- Indexes for table `qucashdata`
--
ALTER TABLE `qucashdata`
  ADD PRIMARY KEY (`CashDataId`);

--
-- Indexes for table `qusalesscreen`
--
ALTER TABLE `qusalesscreen`
  ADD PRIMARY KEY (`SalesScreenId`);

--
-- Indexes for table `rate`
--
ALTER TABLE `rate`
  ADD PRIMARY KEY (`RateId`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`SalesId`);

--
-- Indexes for table `salesscreen`
--
ALTER TABLE `salesscreen`
  ADD PRIMARY KEY (`SalesScreenId`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`StockId`);

--
-- Indexes for table `tax`
--
ALTER TABLE `tax`
  ADD PRIMARY KEY (`TaxId`);

--
-- Indexes for table `unit`
--
ALTER TABLE `unit`
  ADD PRIMARY KEY (`UnitId`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`VendorId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accountgroup`
--
ALTER TABLE `accountgroup`
  MODIFY `AccountGroupId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `BillId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cashdata`
--
ALTER TABLE `cashdata`
  MODIFY `CashDataId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `CatId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=92;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `EmployeeId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `ledger`
--
ALTER TABLE `ledger`
  MODIFY `LedgerId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `LoginId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `model`
--
ALTER TABLE `model`
  MODIFY `ModelId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ProductId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `PurchaseId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `purchasescreen`
--
ALTER TABLE `purchasescreen`
  MODIFY `PurchaseId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `qucashdata`
--
ALTER TABLE `qucashdata`
  MODIFY `CashDataId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `qusalesscreen`
--
ALTER TABLE `qusalesscreen`
  MODIFY `SalesScreenId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `rate`
--
ALTER TABLE `rate`
  MODIFY `RateId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `SalesId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `salesscreen`
--
ALTER TABLE `salesscreen`
  MODIFY `SalesScreenId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=86;
--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `StockId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `tax`
--
ALTER TABLE `tax`
  MODIFY `TaxId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT for table `unit`
--
ALTER TABLE `unit`
  MODIFY `UnitId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `VendorId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`UnitId`) REFERENCES `unit` (`UnitId`) ON DELETE SET NULL ON UPDATE SET NULL;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
