-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2023 at 07:26 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `internship2`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_course`
--

CREATE TABLE `t_course` (
  `id` int(11) NOT NULL DEFAULT 0,
  `name` varchar(128) DEFAULT NULL COMMENT '课程名称',
  `course_info` varchar(500) DEFAULT NULL COMMENT '课程介绍',
  `teacher_name` varchar(255) DEFAULT NULL COMMENT '老师姓名',
  `face_img` varchar(255) DEFAULT NULL COMMENT '封面',
  `price` double DEFAULT NULL COMMENT '价格',
  `category_name` varchar(255) DEFAULT NULL COMMENT '类别名称',
  `organization_name` varchar(255) DEFAULT NULL COMMENT '所属机构名称',
  `class_hour` int(11) DEFAULT NULL COMMENT '课时',
  `add_time` datetime DEFAULT current_timestamp() COMMENT '添加时间',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `t_course`
--

INSERT INTO `t_course` (`id`, `name`, `course_info`, `teacher_name`, `face_img`, `price`, `category_name`, `organization_name`, `class_hour`, `add_time`, `update_time`) VALUES
(1, '前端框架vue3', '这是前端课程', NULL, '/files/wximages/courses/1.jpg', 0.02, '0', NULL, 120, '2022-10-13 10:45:54', '2023-03-21 00:47:34'),
(8, '大数据技术之hadoop', '这是大数据课程', NULL, '/files/wximages/courses/2.jpg', 0.02, '0', NULL, 160, '2022-10-13 15:48:17', '2023-03-21 00:47:34'),
(9, '微信小程序开发技术', '机器视觉', NULL, '/files/wximages/courses/3.jpg', 0.02, '0', NULL, 200, '2022-10-13 14:42:46', '2023-03-21 00:47:34'),
(12, '人工智能-NLP', NULL, NULL, '/files/wximages/courses/4.jpg', 0.02, '0', NULL, 2222, '2022-10-26 22:59:14', '2023-03-21 00:47:34'),
(41, NULL, NULL, '小李', '/files/2.JPG', 0.02, '嵌入式开发', 'LG教育', NULL, '2023-03-22 15:50:16', '2023-03-22 15:50:16'),
(42, '9999123', '234234234', '小王', '/files/1.JPG', 0.02, NULL, 'LG教育', NULL, '2023-03-22 15:54:46', '2023-03-22 15:54:46'),
(43, '99992123123', '123123', NULL, '/files/2.JPG', 0.02, '人工智能', NULL, NULL, '2023-03-22 16:01:09', '2023-03-22 16:01:09'),
(44, '999912388811', '123123123', '小李', '/files/2.JPG', 0.02, 'java架构', 's学堂', NULL, '2023-03-22 16:04:22', '2023-03-22 16:04:22');

-- --------------------------------------------------------

--
-- Table structure for table `t_user`
--

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(255) DEFAULT NULL COMMENT 'email'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `t_user`
--

INSERT INTO `t_user` (`id`, `name`, `age`, `email`) VALUES
(1, '1sadf', 20, 'xxx'),
(2, '小明', 20, 'xiaoming@sina.com'),
(3, '小明', 20, 'xiaoming@sina.com'),
(4, '小明', 20, 'xiaoming@sina.com'),
(5, '小芳', 20, 'xxx');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `t_user`
--
ALTER TABLE `t_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID', AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
