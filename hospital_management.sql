-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2020 at 11:23 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `diagonostics`
--

CREATE TABLE `diagonostics` (
  `patient_id` int(11) NOT NULL,
  `test` text NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diagonostics`
--

INSERT INTO `diagonostics` (`patient_id`, `test`, `amount`) VALUES
(123456789, 'ecg', 2000),
(987654321, 'echo', 5000),
(123456789, 'endo', 10000),
(987654321, 'thyroid', 3000),
(123498765, 'lipid', 5000),
(987654321, 'lipid', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `medicines`
--

CREATE TABLE `medicines` (
  `patient_id` int(11) NOT NULL,
  `medicine_name` text NOT NULL,
  `quantity` int(11) NOT NULL,
  `rate` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicines`
--

INSERT INTO `medicines` (`patient_id`, `medicine_name`, `quantity`, `rate`, `amount`) VALUES
(123456789, 'paracetamol', 5, 50, 250),
(987654321, 'crocin', 10, 100, 1000),
(123456789, 'femocid', 10, 150, 1500),
(987654321, 'pan forte', 5, 250, 1250),
(123498765, 'allegra', 20, 180, 3600);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `ssn` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `patient_name` text NOT NULL,
  `address` text NOT NULL,
  `age` int(3) NOT NULL,
  `doj` date NOT NULL,
  `dod` date NOT NULL,
  `room_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`ssn`, `patient_id`, `patient_name`, `address`, `age`, `doj`, `dod`, `room_id`) VALUES
(123456789, 123456789, 'abc abc', '123 abc road', 22, '2020-06-26', '2020-07-26', 101),
(123498765, 123498765, 'abd', 'AJC Bose Road, Kolkata, West Bengal', 24, '2020-06-08', '2020-07-22', 103),
(987654321, 987654321, 'Srija Ghosh', 'Bagati,Mogra,Hooghly, West Bengal', 18, '2020-06-03', '2020-07-13', 102);

-- --------------------------------------------------------

--
-- Table structure for table `room_type`
--

CREATE TABLE `room_type` (
  `id` int(11) NOT NULL,
  `room_type` text NOT NULL,
  `rate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_type`
--

INSERT INTO `room_type` (`id`, `room_type`, `rate`) VALUES
(101, 'General', 2000),
(102, 'Shared', 3000),
(103, 'Single', 5000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diagonostics`
--
ALTER TABLE `diagonostics`
  ADD KEY `patient_id` (`patient_id`);

--
-- Indexes for table `medicines`
--
ALTER TABLE `medicines`
  ADD KEY `patient_id` (`patient_id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patient_id`) USING BTREE,
  ADD KEY `room_id` (`room_id`);

--
-- Indexes for table `room_type`
--
ALTER TABLE `room_type`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diagonostics`
--
ALTER TABLE `diagonostics`
  ADD CONSTRAINT `diagonostics_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`);

--
-- Constraints for table `medicines`
--
ALTER TABLE `medicines`
  ADD CONSTRAINT `medicines_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`);

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room_type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
