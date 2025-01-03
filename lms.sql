-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2025 at 03:52 PM
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
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`name`, `password`) VALUES
('shiran', '123'),
('akila', '123');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `Months` int(11) NOT NULL,
  `fees` int(11) NOT NULL,
  `teacherId` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `name`, `Months`, `fees`, `teacherId`, `date`) VALUES
('C001', 'Introduction to Programming', 3, 200, 'T001', '2025-01-01 08:08:37'),
('C002', 'Web Development Fundamentals', 6, 450, 'T003', '2025-01-01 08:08:37'),
('C003', 'Advanced Java Programming', 6, 600, 'T005', '2025-01-01 08:08:37'),
('C004', 'Data Science with Python', 6, 1200, 'T007', '2025-01-01 08:08:37'),
('C005', 'Machine Learning and AI', 12, 1500, 'T010', '2025-01-01 08:08:37');

-- --------------------------------------------------------

--
-- Table structure for table `coursereg`
--

CREATE TABLE `coursereg` (
  `courseId` varchar(100) NOT NULL,
  `studentId` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coursereg`
--

INSERT INTO `coursereg` (`courseId`, `studentId`) VALUES
('C001', 'S004'),
('C002', 'S003');

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `studentId` varchar(100) NOT NULL,
  `courseId` varchar(100) NOT NULL,
  `marks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`studentId`, `courseId`, `marks`) VALUES
('S001', 'C001', 56),
('S002', 'C001', 34);

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

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` varchar(100) NOT NULL,
  `fName` varchar(100) NOT NULL,
  `lName` varchar(100) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `tel` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `fName`, `lName`, `userName`, `email`, `tel`, `password`, `date`) VALUES
('T001', 'doe', 'john', 'john', 'fdfjldj@gmail.com', 'fdfjldj@gmail.com', '1234', '2025-01-01 07:28:16'),
('T002', 'John', 'Doe', 'johndoe', 'johndoe@email.com', '1234567890', 'password123', '2025-01-01 07:28:16'),
('T003', 'Jane', 'Smith', 'janesmith', 'janesmith@email.com', '2345678901', 'password456', '2025-01-01 07:28:16'),
('T004', 'Emily', 'Johnson', 'emilyjohnson', 'emilyjohnson@email.com', '3456789012', 'password789', '2025-01-01 07:28:16'),
('T005', 'Michael', 'Williams', 'michaelwilliams', 'michaelwilliams@email.com', '4567890123', 'password321', '2025-01-01 07:28:16'),
('T006', 'Sarah', 'Brown', 'sarahbrown', 'sarahbrown@email.com', '5678901234', 'password654', '2025-01-01 07:28:16'),
('T007', 'David', 'Jones', 'davidjones', 'davidjones@email.com', '6789012345', 'password987', '2025-01-01 07:28:16'),
('T008', 'Laura', 'Davis', 'lauradavis', 'lauradavis@email.com', '7890123456', 'password159', '2025-01-01 07:28:16'),
('T009', 'James', 'Miller', 'jamesmiller', 'jamesmiller@email.com', '8901234567', 'password753', '2025-01-01 07:28:16'),
('T010', 'Olivia', 'Taylor', 'oliviataylor', 'oliviataylor@email.com', '9012345678', 'password258', '2025-01-01 07:28:16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacherId` (`teacherId`);

--
-- Indexes for table `coursereg`
--
ALTER TABLE `coursereg`
  ADD PRIMARY KEY (`courseId`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD KEY `studentId` (`studentId`),
  ADD KEY `courseId` (`courseId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `marks_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
