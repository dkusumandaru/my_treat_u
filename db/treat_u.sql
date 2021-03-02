-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 02 Mar 2021 pada 05.11
-- Versi Server: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `treat_u`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `action`
--

CREATE TABLE `action` (
  `id_action` int(11) NOT NULL,
  `name_action` varchar(255) NOT NULL,
  `active_action` enum('true','false') NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `action`
--

INSERT INTO `action` (`id_action`, `name_action`, `active_action`) VALUES
(1, 'insert', 'true'),
(2, 'update', 'true'),
(3, 'delete', 'true'),
(4, 'get', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `consultation`
--

CREATE TABLE `consultation` (
  `id_consultation` char(16) NOT NULL,
  `queue_consultation` int(11) DEFAULT NULL,
  `date_consultation` date DEFAULT NULL,
  `id_consultation_status` int(11) DEFAULT NULL,
  `create_date_consultation` datetime DEFAULT NULL,
  `update_date_consultation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by` char(10) DEFAULT NULL,
  `id_schedule` char(3) NOT NULL,
  `id_doctor` char(10) DEFAULT NULL,
  `id_employee` char(10) DEFAULT NULL,
  `counter_consultation` int(11) DEFAULT NULL,
  `response_employee` enum('true','false') NOT NULL DEFAULT 'false',
  `review_consultation` text,
  `id_problem` int(11) DEFAULT NULL,
  `id_stress_level` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `consultation`
--

INSERT INTO `consultation` (`id_consultation`, `queue_consultation`, `date_consultation`, `id_consultation_status`, `create_date_consultation`, `update_date_consultation`, `update_by`, `id_schedule`, `id_doctor`, `id_employee`, `counter_consultation`, `response_employee`, `review_consultation`, `id_problem`, `id_stress_level`) VALUES
('9999999999999987', 1, '2021-02-25', 1, '2021-02-25 09:13:39', '2021-02-25 02:13:39', '0987876576', '', '0987876576', '1213123432', 0, 'false', ' ', 0, 0),
('9999999999999989', 2, '2021-02-25', 1, '2021-02-25 09:15:12', '2021-02-25 02:15:12', '0987876576', '', '0987876576', '1213123433', 0, 'false', ' ', 0, 0),
('9999999999999990', 3, '2021-02-25', 1, '2021-02-25 09:15:18', '2021-02-25 02:15:18', '0987876576', '', '0987876576', '1213123434', 0, 'false', ' ', 0, 0),
('9999999999999991', 4, '2021-02-25', 1, '2021-02-25 09:15:22', '2021-02-25 02:15:22', '0987876576', '', '0987876576', '1213123435', 0, 'false', ' ', 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `consultation_status`
--

CREATE TABLE `consultation_status` (
  `id_consultation_status` int(11) NOT NULL,
  `name_consultation_status` varchar(255) DEFAULT NULL,
  `active_consultation_status` enum('true','false') NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `consultation_status`
--

INSERT INTO `consultation_status` (`id_consultation_status`, `name_consultation_status`, `active_consultation_status`) VALUES
(1, 'to do', 'true'),
(2, 'doing', 'true'),
(3, 'delay', 'true'),
(4, 'done', 'true'),
(5, 'miss', 'true'),
(6, 'canceled', 'true'),
(7, 'terminate', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `department`
--

CREATE TABLE `department` (
  `id_department` int(11) NOT NULL,
  `name_department` varchar(255) DEFAULT NULL,
  `active_department` enum('true','false') NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `department`
--

INSERT INTO `department` (`id_department`, `name_department`, `active_department`) VALUES
(1, 'ADD', 'true'),
(2, 'MSBU', 'true'),
(3, 'Doctor', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `feature`
--

CREATE TABLE `feature` (
  `id_feature` int(11) NOT NULL,
  `name_feature` varchar(255) DEFAULT NULL,
  `active_feature` enum('true','false') NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `feature`
--

INSERT INTO `feature` (`id_feature`, `name_feature`, `active_feature`) VALUES
(1, 'login', 'true'),
(2, 'role', 'true'),
(3, 'department', 'true'),
(4, 'schedule', 'true'),
(5, 'user management', 'true'),
(6, 'room', 'true'),
(7, 'cosultation', 'true'),
(8, 'stress level', 'true'),
(9, 'problem', 'true'),
(10, 'questioner', 'true'),
(11, 'quest questioner', 'true'),
(12, 'answer questioner', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `log`
--

CREATE TABLE `log` (
  `id_log` char(22) NOT NULL,
  `describe_log` text,
  `date_log` datetime DEFAULT NULL,
  `id_action` int(11) DEFAULT NULL,
  `id_feature` int(11) DEFAULT NULL,
  `id_user` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `log`
--

INSERT INTO `log` (`id_log`, `describe_log`, `date_log`, `id_action`, `id_feature`, `id_user`) VALUES
('', 'User Login ', '2021-03-01 08:09:13', 3, 1, '0987364832'),
('0987364832210301080913', 'User Login ', '2021-03-01 08:09:13', 3, 1, '0987364832');

-- --------------------------------------------------------

--
-- Struktur dari tabel `problem`
--

CREATE TABLE `problem` (
  `id_problem` int(11) NOT NULL,
  `name_problem` varchar(255) DEFAULT NULL,
  `active_problem` enum('true','false') NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `problem`
--

INSERT INTO `problem` (`id_problem`, `name_problem`, `active_problem`) VALUES
(0, 'None', 'true'),
(1, 'Working', 'true'),
(2, 'Social', 'true'),
(3, 'Culture', 'true'),
(4, 'Family', 'true'),
(5, 'Religion', 'true'),
(6, 'Others', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `questioner`
--

CREATE TABLE `questioner` (
  `id_questioner` char(20) NOT NULL,
  `title_questioner` varchar(50) DEFAULT NULL,
  `description_questioner` text,
  `create_date_questioner` date DEFAULT NULL,
  `create_by` char(10) NOT NULL,
  `update_date_questioner` datetime DEFAULT NULL,
  `update_by` char(10) DEFAULT NULL,
  `active_questioner` enum('true','false') NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `questioner_detail`
--

CREATE TABLE `questioner_detail` (
  `id_questioner_detail` char(24) NOT NULL,
  `question_questioner_detail` text,
  `answer_questioner_detail` text,
  `create_date_questioner_detail` datetime DEFAULT NULL,
  `create_by` char(10) DEFAULT NULL,
  `update_date_questioner_detail` datetime DEFAULT NULL,
  `update_by` char(10) DEFAULT NULL,
  `active_questioner_detail` enum('true','false') NOT NULL DEFAULT 'true',
  `id_questioner` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `question_answer`
--

CREATE TABLE `question_answer` (
  `id_question_answer` char(34) NOT NULL,
  `answer_question_answer` text,
  `create_date_question_answer` datetime DEFAULT NULL,
  `update_date_question_answer` datetime DEFAULT NULL,
  `id_questioner_detail` char(24) DEFAULT NULL,
  `id_employee` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `name_role` varchar(255) DEFAULT NULL,
  `active_role` enum('true','false') NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `role`
--

INSERT INTO `role` (`id_role`, `name_role`, `active_role`) VALUES
(1, 'doctor', 'true'),
(2, 'employee', 'true'),
(3, 'admin', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `room`
--

CREATE TABLE `room` (
  `id_room` char(4) NOT NULL,
  `capacity_room` int(11) DEFAULT NULL,
  `url_room` varchar(100) DEFAULT NULL,
  `create_date_room` datetime DEFAULT NULL,
  `create_by` char(10) DEFAULT NULL,
  `update_date_room` datetime DEFAULT NULL,
  `update_by` char(10) DEFAULT NULL,
  `id_docter` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `room`
--

INSERT INTO `room` (`id_room`, `capacity_room`, `url_room`, `create_date_room`, `create_by`, `update_date_room`, `update_by`, `id_docter`) VALUES
('1234', 4, 'https://us02web.zoom.us/j/81913797667?pwd=MTRKZjlFbFFXN01pYTF2WGkyckxoZz09', '2021-02-25 09:38:11', '0987876576', '2021-02-25 09:38:11', '0987876576', '0987876576');

-- --------------------------------------------------------

--
-- Struktur dari tabel `schedule`
--

CREATE TABLE `schedule` (
  `id_schedule` char(3) NOT NULL,
  `name_schedule` varchar(50) DEFAULT NULL,
  `start_time_schedule` time DEFAULT NULL,
  `end_time_schedule` time DEFAULT NULL,
  `active_schedule` enum('true','false') NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `schedule`
--

INSERT INTO `schedule` (`id_schedule`, `name_schedule`, `start_time_schedule`, `end_time_schedule`, `active_schedule`) VALUES
('123', 'SESSION 1', '08:00:00', '10:00:00', 'true'),
('124', 'SESSION 2', '10:00:00', '12:00:00', 'true'),
('125', 'SESSION 3', '13:00:00', '15:00:00', 'true'),
('126', 'SESSION 4', '15:00:00', '17:00:00', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `schedule_detail`
--

CREATE TABLE `schedule_detail` (
  `id_schedule_detail` char(13) NOT NULL,
  `id_doctor` char(10) NOT NULL,
  `id_schedule` char(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `schedule_detail`
--

INSERT INTO `schedule_detail` (`id_schedule_detail`, `id_doctor`, `id_schedule`) VALUES
('0987364832123', '0987364832', '123'),
('0987364832124', '0987364832', '124'),
('0987364832125', '0987364832', '125'),
('0987364832126', '0987364832', '126'),
('0987656787123', '0987656787', '123'),
('0987656787124', '0987656787', '124'),
('0987656787125', '0987656787', '125'),
('0987656787126', '0987656787', '126'),
('0987876576123', '0987876576', '123'),
('0987876576124', '0987876576', '124'),
('0987876576125', '0987876576', '125'),
('0987876576126', '0987876576', '126');

-- --------------------------------------------------------

--
-- Struktur dari tabel `stress_level`
--

CREATE TABLE `stress_level` (
  `id_stress_level` int(11) NOT NULL,
  `name_stress_level` text NOT NULL,
  `active_stress_level` enum('true','false') NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `stress_level`
--

INSERT INTO `stress_level` (`id_stress_level`, `name_stress_level`, `active_stress_level`) VALUES
(0, 'None', 'true'),
(1, 'High', 'true'),
(2, 'Medium', 'true'),
(3, 'Low', 'true');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id_user` char(10) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email_user` varchar(255) DEFAULT NULL,
  `password_user` varchar(255) DEFAULT NULL,
  `active_user` enum('true','false') NOT NULL DEFAULT 'true',
  `id_role` int(11) DEFAULT NULL,
  `id_department` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id_user`, `first_name`, `last_name`, `email_user`, `password_user`, `active_user`, `id_role`, `id_department`) VALUES
('0987364832', 'Desy', 'aaa', 'bayu@bayu.com', '12345', 'true', 1, 2),
('0987656787', 'Genoveva', 'vvv', 'bayu@bayu.com', '12345', 'true', 1, 2),
('0987876576', 'Maria', 'Doc', 'bayu@bayu.com', '12345', 'true', 1, 2),
('1213123410', 'Bayu', 'vvv', 'bayu@bayu.co.id', '12345', 'true', 2, 2),
('1213123411', 'Bayu', 'aaa', 'bayu@bayu.com.my', '123456', 'true', 2, 2),
('1213123432', 'Bayu', 'fff', 'bayu@bayu.com.uk', '12346', 'true', 2, 1),
('1213123433', 'Bayu', 'ddd', 'bayu@bayu.co.fr', '123457', 'true', 2, 2),
('1213123434', 'Bayu', '555', 'bayu@bayu.com', '12345', 'true', 2, 2),
('1213123435', 'Bayu', 'ttt', 'bayu@bayu.com', '12345', 'true', 2, 2),
('1213123436', 'Bayu', 'ttt', 'bayu@bayu.com', '12345', 'true', 2, 2),
('1213123437', 'Bayu', 'ttt', 'bayu@bayu.com', '12345', 'true', 2, 2),
('1213123438', 'Bayu', 'nnn', 'bayu@bayu.com', '12345', 'true', 2, 2),
('1213123439', 'Bayu', 'ggg', 'bayu@bayu.com', '12345', 'true', 2, 2),
('1213123440', 'Hanif', 'Alfatta', 'hanif@hanif.com', 'hanif123', 'true', 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `action`
--
ALTER TABLE `action`
  ADD PRIMARY KEY (`id_action`);

--
-- Indexes for table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`id_consultation`),
  ADD KEY `id_doctor` (`id_doctor`),
  ADD KEY `id_employee` (`id_employee`),
  ADD KEY `id_problem` (`id_problem`),
  ADD KEY `id_stress_level` (`id_stress_level`),
  ADD KEY `id_consultation_status` (`id_consultation_status`);

--
-- Indexes for table `consultation_status`
--
ALTER TABLE `consultation_status`
  ADD PRIMARY KEY (`id_consultation_status`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id_department`);

--
-- Indexes for table `feature`
--
ALTER TABLE `feature`
  ADD PRIMARY KEY (`id_feature`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id_log`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_feature` (`id_feature`),
  ADD KEY `id_action` (`id_action`);

--
-- Indexes for table `problem`
--
ALTER TABLE `problem`
  ADD PRIMARY KEY (`id_problem`);

--
-- Indexes for table `questioner`
--
ALTER TABLE `questioner`
  ADD PRIMARY KEY (`id_questioner`),
  ADD KEY `create_by` (`create_by`),
  ADD KEY `update_by` (`update_by`);

--
-- Indexes for table `questioner_detail`
--
ALTER TABLE `questioner_detail`
  ADD PRIMARY KEY (`id_questioner_detail`),
  ADD KEY `create_by` (`create_by`),
  ADD KEY `update_by` (`update_by`),
  ADD KEY `id_questioner` (`id_questioner`);

--
-- Indexes for table `question_answer`
--
ALTER TABLE `question_answer`
  ADD PRIMARY KEY (`id_question_answer`),
  ADD KEY `id_questioner_detail` (`id_questioner_detail`),
  ADD KEY `id_karyawan` (`id_employee`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id_room`),
  ADD KEY `id_docter` (`id_docter`),
  ADD KEY `create_by` (`create_by`),
  ADD KEY `update_by` (`update_by`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id_schedule`);

--
-- Indexes for table `schedule_detail`
--
ALTER TABLE `schedule_detail`
  ADD PRIMARY KEY (`id_schedule_detail`),
  ADD KEY `id_doctor` (`id_doctor`),
  ADD KEY `id_schedule` (`id_schedule`);

--
-- Indexes for table `stress_level`
--
ALTER TABLE `stress_level`
  ADD PRIMARY KEY (`id_stress_level`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_role` (`id_role`),
  ADD KEY `id_department` (`id_department`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `action`
--
ALTER TABLE `action`
  MODIFY `id_action` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `consultation_status`
--
ALTER TABLE `consultation_status`
  MODIFY `id_consultation_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id_department` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `feature`
--
ALTER TABLE `feature`
  MODIFY `id_feature` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `problem`
--
ALTER TABLE `problem`
  MODIFY `id_problem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `consultation_ibfk_1` FOREIGN KEY (`id_doctor`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `consultation_ibfk_2` FOREIGN KEY (`id_employee`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `consultation_ibfk_3` FOREIGN KEY (`id_problem`) REFERENCES `problem` (`id_problem`),
  ADD CONSTRAINT `consultation_ibfk_4` FOREIGN KEY (`id_stress_level`) REFERENCES `stress_level` (`id_stress_level`),
  ADD CONSTRAINT `consultation_ibfk_5` FOREIGN KEY (`id_consultation_status`) REFERENCES `consultation_status` (`id_consultation_status`),
  ADD CONSTRAINT `consultation_ibfk_6` FOREIGN KEY (`id_consultation_status`) REFERENCES `consultation_status` (`id_consultation_status`);

--
-- Ketidakleluasaan untuk tabel `log`
--
ALTER TABLE `log`
  ADD CONSTRAINT `log_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `log_ibfk_2` FOREIGN KEY (`id_action`) REFERENCES `action` (`id_action`),
  ADD CONSTRAINT `log_ibfk_3` FOREIGN KEY (`id_feature`) REFERENCES `feature` (`id_feature`);

--
-- Ketidakleluasaan untuk tabel `questioner`
--
ALTER TABLE `questioner`
  ADD CONSTRAINT `questioner_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `questioner_ibfk_2` FOREIGN KEY (`update_by`) REFERENCES `users` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `questioner_detail`
--
ALTER TABLE `questioner_detail`
  ADD CONSTRAINT `questioner_detail_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `questioner_detail_ibfk_2` FOREIGN KEY (`update_by`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `questioner_detail_ibfk_3` FOREIGN KEY (`id_questioner`) REFERENCES `questioner` (`id_questioner`);

--
-- Ketidakleluasaan untuk tabel `question_answer`
--
ALTER TABLE `question_answer`
  ADD CONSTRAINT `question_answer_ibfk_1` FOREIGN KEY (`id_questioner_detail`) REFERENCES `questioner_detail` (`id_questioner_detail`),
  ADD CONSTRAINT `question_answer_ibfk_2` FOREIGN KEY (`id_employee`) REFERENCES `users` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`id_docter`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `room_ibfk_2` FOREIGN KEY (`create_by`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `room_ibfk_3` FOREIGN KEY (`update_by`) REFERENCES `users` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `schedule_detail`
--
ALTER TABLE `schedule_detail`
  ADD CONSTRAINT `schedule_detail_ibfk_1` FOREIGN KEY (`id_doctor`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `schedule_detail_ibfk_2` FOREIGN KEY (`id_schedule`) REFERENCES `schedule` (`id_schedule`);

--
-- Ketidakleluasaan untuk tabel `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`),
  ADD CONSTRAINT `users_ibfk_2` FOREIGN KEY (`id_department`) REFERENCES `department` (`id_department`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
