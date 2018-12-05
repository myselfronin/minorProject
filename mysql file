-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2018 at 06:13 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minorproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `batch_table`
--

CREATE TABLE `batch_table` (
  `batch_No` int(11) NOT NULL,
  `product_Id` varchar(45) NOT NULL,
  `EntryQty` int(11) NOT NULL,
  `SoldQty` int(11) NOT NULL DEFAULT '0',
  `Expire_Date` date NOT NULL,
  `cost_price` float NOT NULL,
  `MRP` float NOT NULL,
  `deo_id` varchar(45) NOT NULL,
  `entry_date` datetime NOT NULL,
  `Type` varchar(25) NOT NULL DEFAULT 'Regular',
  `expire_status` varchar(10) NOT NULL DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batch_table`
--

INSERT INTO `batch_table` (`batch_No`, `product_Id`, `EntryQty`, `SoldQty`, `Expire_Date`, `cost_price`, `MRP`, `deo_id`, `entry_date`, `Type`, `expire_status`) VALUES
(1, '1', 100, 0, '2018-10-16', 48, 50, '1', '2018-07-02 21:54:58', 'Regular', 'NO'),
(1, '2', 100, 0, '2018-09-04', 48, 50, '1', '2018-07-02 21:56:33', 'Regular', 'NO'),
(1, '3', 100, 0, '2018-09-04', 48, 50, '1', '2018-07-02 21:56:57', 'Regular', 'NO'),
(1, '4', 99, 0, '2018-09-04', 12, 15, '1', '2018-07-02 21:57:45', 'Regular', 'NO'),
(1, '5', 50, 0, '2019-03-11', 73, 75, '1', '2018-07-02 21:58:21', 'Regular', 'NO'),
(2, '5', 12, 0, '2018-07-03', 123, 121, '1', '2018-07-02 23:01:15', 'Regular', 'expired'),
(3, '5', 12, 0, '2018-07-04', 123, 121, '1', '2018-07-02 23:01:18', 'Returned', 'expired'),
(4, '5', 12, 0, '2018-07-05', 123, 121, '1', '2018-07-02 23:01:21', 'Returned', 'expired'),
(5, '5', 232, 0, '2018-07-05', 232, 232, '1', '2018-07-02 23:12:50', 'Returned', 'expired'),
(6, '5', 12, 0, '2018-07-06', 45, 50, '1', '2018-07-02 23:13:40', 'Returned', 'expired'),
(7, '5', 23, 0, '2018-07-08', 56, 56, '1', '2018-07-02 23:16:57', 'Sale', 'expiring'),
(1, '8', 123, 0, '2018-07-06', 123, 234, '1', '2018-07-05 14:49:19', 'Returned', 'expired'),
(2, '4', 1234, 0, '2018-07-08', 678, 678, '1', '2018-07-07 17:53:44', 'Sale', 'expiring');

-- --------------------------------------------------------

--
-- Table structure for table `cashier_info`
--

CREATE TABLE `cashier_info` (
  `Cashier_Id` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact_No` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Created_By` varchar(45) NOT NULL,
  `Created_At` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashier_info`
--

INSERT INTO `cashier_info` (`Cashier_Id`, `Name`, `Username`, `Password`, `Address`, `Contact_No`, `DOB`, `Gender`, `Created_By`, `Created_At`) VALUES
(1, 'Rabinson Ghatani', 'rabinson@cashier', 'bRxYWVUIJNQD2MMa+axnO3uiBub4fmHglqAXKZ901j8=', 'lamachour', '9898989898', '2018-07-10', 'Male', 'jasmine', '2018-07-02 20:48:55'),
(2, 'Jasmine Baral', 'jasmine@cashier', 'bRxYWVUIJNQD2MMa+axnO3uiBub4fmHglqAXKZ901j8=', 'mahendrapool', '9898989898', '2018-07-11', 'Female', 'jasmine', '2018-07-02 20:50:00'),
(3, 'sagar', 'sagar@cahier', '1RrneQTWnrNqOhx3Te8DwaecHbxIlkFZcSAwj+n7Jek=', 'sagar', 'sagar', '2018-07-11', 'Male', 'jasmine', '2018-07-03 21:09:37');

-- --------------------------------------------------------

--
-- Table structure for table `category_table`
--

CREATE TABLE `category_table` (
  `Category_Id` int(11) NOT NULL,
  `Category` varchar(100) NOT NULL,
  `Department_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category_table`
--

INSERT INTO `category_table` (`Category_Id`, `Category`, `Department_Id`) VALUES
(1, 'Snacks & Chocolates', 1),
(2, 'fg', 2);

-- --------------------------------------------------------

--
-- Table structure for table `deo_info`
--

CREATE TABLE `deo_info` (
  `Deo_Id` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact_No` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` text NOT NULL,
  `Created_By` varchar(45) NOT NULL,
  `Created_At` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deo_info`
--

INSERT INTO `deo_info` (`Deo_Id`, `Name`, `Username`, `Password`, `Address`, `Contact_No`, `DOB`, `Gender`, `Created_By`, `Created_At`) VALUES
(1, 'Rabinson Ghatani', '72bct635', 'bRxYWVUIJNQD2MMa+axnO3uiBub4fmHglqAXKZ901j8=', 'jawalakhel', '98989898', '2016-07-04', 'Male', 'jasmine', '2018/07/02 21:01:46');

-- --------------------------------------------------------

--
-- Table structure for table `department_table`
--

CREATE TABLE `department_table` (
  `Department_Id` int(11) NOT NULL,
  `Department` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department_table`
--

INSERT INTO `department_table` (`Department_Id`, `Department`) VALUES
(1, 'Grocery & Foods'),
(2, 'dfgh'),
(3, 'qwerty');

-- --------------------------------------------------------

--
-- Table structure for table `employee_info`
--

CREATE TABLE `employee_info` (
  `Employee_Id` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Position` varchar(45) NOT NULL,
  `Contact_No` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` text NOT NULL,
  `Created_By` varchar(45) NOT NULL,
  `Created_At` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_info`
--

INSERT INTO `employee_info` (`Employee_Id`, `Name`, `Address`, `Position`, `Contact_No`, `DOB`, `Gender`, `Created_By`, `Created_At`) VALUES
(1, 'Rabinson', 'ghjk', 'Stock Clerk', '789', '2018-07-18', 'Male', 'jasmine', '2018-07-07 18:05:33');

-- --------------------------------------------------------

--
-- Table structure for table `manager_info`
--

CREATE TABLE `manager_info` (
  `Manager_Id` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Contact_No` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager_info`
--

INSERT INTO `manager_info` (`Manager_Id`, `Name`, `Username`, `Password`, `Contact_No`) VALUES
(1, 'Jasmine Baral', 'jasmine@manager', 'jasmine', '9898989898');

-- --------------------------------------------------------

--
-- Table structure for table `product_table`
--

CREATE TABLE `product_table` (
  `product_Id` int(11) NOT NULL,
  `BarCode` varchar(35) DEFAULT '000000000000',
  `Name` varchar(255) NOT NULL,
  `Department` varchar(100) NOT NULL,
  `Category` varchar(100) NOT NULL,
  `SubCategory` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_table`
--

INSERT INTO `product_table` (`product_Id`, `BarCode`, `Name`, `Department`, `Category`, `SubCategory`) VALUES
(1, '040000012023', 'Snickers Candy Bar', 'Grocery & Foods', 'Snacks & Chocolates', 'Sweets & Chocolates'),
(2, '034000087525', 'Kit Kat Candy Bars Milk Chocolate', 'Grocery & Foods', 'Snacks & Chocolates', 'Sweets & Chocolates'),
(3, '692991702706', 'Cadbury Dairy Milk Chocolate Bars', 'Grocery & Foods', 'Snacks & Chocolates', 'Sweets & Chocolates'),
(4, '620016273931', 'Cadbury 5 Star Chocolate Bar 24 Gram ', 'Grocery & Foods', 'Snacks & Chocolates', 'Sweets & Chocolates'),
(5, '890406323119', 'Haldiram\'s Aloo Bhujia ', 'Grocery & Foods', 'Snacks & Chocolates', 'Bhujia & Namkins'),
(6, '1234567', '1234567', 'Grocery & Foods', 'Snacks & Chocolates', 'Sweets & Chocolates'),
(7, '1212121', '1212121', 'Grocery & Foods', 'Snacks & Chocolates', 'Sweets & Chocolates'),
(8, '00000', 'sdfgh', 'dfgh', 'fg', 'dfgh'),
(9, '12345', 'werty', 'Grocery & Foods', 'Snacks & Chocolates', 'Sweets & Chocolates');

-- --------------------------------------------------------

--
-- Table structure for table `subcategory_table`
--

CREATE TABLE `subcategory_table` (
  `Subcategory_Id` int(11) NOT NULL,
  `Subcategory` varchar(100) NOT NULL,
  `Category_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subcategory_table`
--

INSERT INTO `subcategory_table` (`Subcategory_Id`, `Subcategory`, `Category_Id`) VALUES
(1, 'Bhujia & Namkins', 1),
(2, 'Chips & Crisps', 1),
(3, 'Sweets & Chocolates', 1),
(4, 'dfgh', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cashier_info`
--
ALTER TABLE `cashier_info`
  ADD PRIMARY KEY (`Cashier_Id`);

--
-- Indexes for table `category_table`
--
ALTER TABLE `category_table`
  ADD PRIMARY KEY (`Category_Id`),
  ADD KEY `Department_Id` (`Department_Id`);

--
-- Indexes for table `deo_info`
--
ALTER TABLE `deo_info`
  ADD PRIMARY KEY (`Deo_Id`);

--
-- Indexes for table `department_table`
--
ALTER TABLE `department_table`
  ADD PRIMARY KEY (`Department_Id`);

--
-- Indexes for table `employee_info`
--
ALTER TABLE `employee_info`
  ADD PRIMARY KEY (`Employee_Id`);

--
-- Indexes for table `manager_info`
--
ALTER TABLE `manager_info`
  ADD PRIMARY KEY (`Manager_Id`);

--
-- Indexes for table `product_table`
--
ALTER TABLE `product_table`
  ADD PRIMARY KEY (`product_Id`);

--
-- Indexes for table `subcategory_table`
--
ALTER TABLE `subcategory_table`
  ADD PRIMARY KEY (`Subcategory_Id`),
  ADD KEY `Subcategory` (`Subcategory`),
  ADD KEY `Category_Id` (`Category_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cashier_info`
--
ALTER TABLE `cashier_info`
  MODIFY `Cashier_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `category_table`
--
ALTER TABLE `category_table`
  MODIFY `Category_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `deo_info`
--
ALTER TABLE `deo_info`
  MODIFY `Deo_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `department_table`
--
ALTER TABLE `department_table`
  MODIFY `Department_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee_info`
--
ALTER TABLE `employee_info`
  MODIFY `Employee_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `manager_info`
--
ALTER TABLE `manager_info`
  MODIFY `Manager_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `product_table`
--
ALTER TABLE `product_table`
  MODIFY `product_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `subcategory_table`
--
ALTER TABLE `subcategory_table`
  MODIFY `Subcategory_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `category_table`
--
ALTER TABLE `category_table`
  ADD CONSTRAINT `category_table_ibfk_1` FOREIGN KEY (`Department_Id`) REFERENCES `department_table` (`Department_Id`);

--
-- Constraints for table `subcategory_table`
--
ALTER TABLE `subcategory_table`
  ADD CONSTRAINT `subcategory_table_ibfk_1` FOREIGN KEY (`Category_Id`) REFERENCES `category_table` (`Category_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
