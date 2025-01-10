-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2025 at 05:37 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` varchar(100) NOT NULL,
  `fName` varchar(100) NOT NULL,
  `lName` varchar(100) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `fName`, `lName`, `userName`, `email`, `gender`, `age`, `password`, `date`) VALUES
('S001', 'shiran', 'lakshitha', 'shiran', 'hldsjfs@gmail.com', 'Male ', 22, '123', '2025-01-01 07:33:08'),
('S002', 'Alice', 'Brown', 'alicebrown', 'alice.brown@email.com', 'Female', 20, 'password123', '2025-01-01 07:19:44'),
('S003', 'Bob', 'Smith', 'bobsmith', 'bob.smith@email.com', 'Male', 22, 'password456', '2025-01-01 07:19:44'),
('S004', 'Charlie', 'Johnson', 'charliejohnson', 'charlie.johnson@email.com', 'Male', 19, 'password789', '2025-01-01 07:19:44'),
('S005', 'Diana', 'Taylor', 'dianataylor', 'diana.taylor@email.com', 'Female', 21, 'password321', '2025-01-01 07:19:44'),
('S006', 'Ethan', 'Williams', 'ethanwilliams', 'ethan.williams@email.com', 'Male', 23, 'password654', '2025-01-01 07:19:44'),
('S007', 'Fiona', 'Davis', 'fionadavis', 'fiona.davis@email.com', 'Female', 20, 'password987', '2025-01-01 07:19:44'),
('S008', 'George', 'Miller', 'georgemiller', 'george.miller@email.com', 'Male', 24, 'password159', '2024-12-01 07:19:44'),
('S009', 'Hannah', 'Anderson', 'hannahanderson', 'hannah.anderson@email.com', 'Female', 18, 'password753', '2024-12-25 07:19:44'),
('S010', 'Ian', 'Clark', 'ianclark', 'ian.clark@email.com', 'Male', 21, 'password258', '2025-01-01 07:19:44'),
('S011', 'Julia', 'Martinez', 'juliamartinez', 'julia.martinez@email.com', 'Female', 22, 'password369', '2025-01-01 07:19:44');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
