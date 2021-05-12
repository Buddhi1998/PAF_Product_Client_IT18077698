-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2021 at 07:37 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` varchar(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `amount` varchar(40) NOT NULL,
  `des` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `amount`, `des`) VALUES
('125d', 'dfd', '2000.0', 'sdsd'),
('002A', 'Buddhi', '20000.0', 'P_budhhi lmn'),
('003A', 'Word_product', '23000.0', 'P_budhhi lmn word product'),
('005A', 'Electric kettle', '3900.0', 'electric kettle new product'),
('3652', 'sadfsaf', '23654.0', 'sfdsfsd'),
('003A', 'Word_producttttttttttttt', '23000.0', 'P_budhhi lmn word product'),
('003A', 'Word_productttttttttttt', '23000.0', 'P_budhhi lmn word product'),
('003A', 'Word_productttttttttttt', '23000.0', 'P_budhhi lmn word product'),
('125d', 'dfd', '2000.0', 'sdsdfffffffff'),
('125d', 'dfd', '2000.0', 'sdsdfffffffff'),
('852', 'dfdhgfj', '0.0', 'nwwwwwwwwwwww'),
('003A', 'o', '23000.0', 'P_budhhi lmn word product');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
