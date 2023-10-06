-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2023 at 10:18 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `cita_agendada`
--

CREATE TABLE `cita_agendada` (
  `id_cita` int(11) NOT NULL,
  `cedula` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `cita_agendada`
--

INSERT INTO `cita_agendada` (`id_cita`, `cedula`, `id_medico`, `fecha`, `hora`) VALUES
(1, 117790909, 111111111, '2023-10-20', '15:30:00'),
(2, 117790909, 111111111, '2023-10-31', '05:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `cita_disponible`
--

CREATE TABLE `cita_disponible` (
  `id_cita_disponible` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `cita_disponible`
--

INSERT INTO `cita_disponible` (`id_cita_disponible`, `id_medico`, `fecha`, `hora`) VALUES
(1, 111111111, '2024-09-06', '15:30:00'),
(2, 111111111, '2023-11-16', '07:00:00'),
(3, 456789012, '2023-10-01', '09:30:00'),
(4, 456789012, '2023-11-01', '14:00:00'),
(5, 456789012, '2023-12-15', '08:30:00'),
(6, 456789012, '2024-01-20', '12:30:00'),
(7, 456789012, '2024-03-05', '16:00:00'),
(8, 456789012, '2024-04-10', '10:30:00'),
(9, 456789012, '2024-05-22', '13:00:00'),
(10, 543210987, '2023-10-12', '11:30:00'),
(11, 543210987, '2023-11-20', '15:00:00'),
(12, 543210987, '2023-12-05', '07:30:00'),
(13, 555444333, '2023-10-20', '10:30:00'),
(14, 555444333, '2023-11-25', '16:30:00'),
(15, 555444333, '2023-12-10', '08:30:00'),
(16, 555444333, '2024-01-15', '13:00:00'),
(17, 555444333, '2024-03-20', '09:30:00'),
(18, 567890123, '2023-11-01', '14:00:00'),
(19, 567890123, '2023-12-10', '16:30:00'),
(20, 654321098, '2023-11-10', '15:00:00'),
(21, 654321098, '2023-12-20', '10:30:00'),
(22, 654321098, '2024-01-05', '14:00:00'),
(23, 654321098, '2024-03-15', '08:30:00'),
(24, 654321098, '2024-04-20', '12:30:00'),
(25, 654321098, '2024-06-05', '16:00:00'),
(26, 666333222, '2023-11-16', '07:30:00'),
(27, 666333222, '2023-12-25', '11:00:00'),
(28, 666333222, '2024-01-10', '14:30:00'),
(29, 666333222, '2024-03-18', '09:00:00'),
(30, 765432109, '2023-11-25', '16:00:00'),
(31, 765432109, '2024-01-05', '09:30:00'),
(32, 765432109, '2024-02-15', '13:00:00'),
(33, 765432109, '2024-04-01', '10:30:00'),
(34, 777888999, '2024-01-15', '11:00:00'),
(35, 777888999, '2024-02-25', '14:30:00'),
(36, 777888999, '2024-04-10', '08:00:00'),
(37, 789012345, '2024-02-25', '12:30:00'),
(38, 789012345, '2024-04-05', '08:00:00'),
(39, 789012345, '2024-05-15', '11:30:00'),
(40, 789012345, '2024-07-01', '15:00:00'),
(41, 789012345, '2024-08-10', '09:30:00'),
(42, 789012345, '2024-09-22', '14:00:00'),
(43, 876543210, '2024-04-14', '08:00:00'),
(44, 876543210, '2024-05-25', '11:30:00'),
(45, 888999777, '2024-06-30', '14:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `especialidad`
--

CREATE TABLE `especialidad` (
  `id_especialidad` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `especialidad`
--

INSERT INTO `especialidad` (`id_especialidad`, `nombre`) VALUES
(1, 'Medicina General'),
(2, 'Cardiologia'),
(3, 'Dermatologia'),
(4, 'Oftalmologia'),
(5, 'Gastroenterologia'),
(6, 'Neurologia');

-- --------------------------------------------------------

--
-- Table structure for table `expediente`
--

CREATE TABLE `expediente` (
  `id_expediente` int(11) NOT NULL,
  `cedula` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `padecimiento` varchar(255) NOT NULL,
  `procedimiento` varchar(255) NOT NULL,
  `medicamentos` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `expediente`
--

INSERT INTO `expediente` (`id_expediente`, `cedula`, `fecha`, `padecimiento`, `procedimiento`, `medicamentos`) VALUES
(1, 117790909, '2023-09-28', 'Colesterol alto', 'Se le aconseja hacer ejercicio y comer mas sano. Tambien se analiza la posibilidad de referirlo a un cardiologo para revision.', 'Bajacolesterol en pastillas, un vaso de agua');

-- --------------------------------------------------------

--
-- Table structure for table `medico`
--

CREATE TABLE `medico` (
  `cedula` int(11) NOT NULL,
  `contrasena` varchar(40) NOT NULL,
  `id_especialidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `medico`
--

INSERT INTO `medico` (`cedula`, `contrasena`, `id_especialidad`) VALUES
(111111111, '123', 1),
(456789012, '123', 1),
(543210987, '123', 2),
(555444333, '123', 3),
(567890123, '123', 4),
(654321098, '123', 5),
(666333222, '123', 6),
(765432109, '123', 1),
(777888999, '123', 2),
(789012345, '123', 3),
(876543210, '123', 4),
(888999777, '123', 5);

-- --------------------------------------------------------

--
-- Table structure for table `paciente`
--

CREATE TABLE `paciente` (
  `cedula` int(11) NOT NULL,
  `contrasena` varchar(40) NOT NULL,
  `medico_cabecera` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `paciente`
--

INSERT INTO `paciente` (`cedula`, `contrasena`, `medico_cabecera`) VALUES
(12345678, '123', 789012345),
(109876543, '123', 456789012),
(111222333, '123', 456789012),
(117790909, 'Pablo123', 111111111),
(210987654, '123', 456789012),
(222333444, '123', 765432109),
(234567890, '123', 765432109),
(321098765, '123', 543210987),
(333222111, '123', 765432109),
(333444555, '123', 765432109),
(345678912, '123', 765432109),
(432109876, '123', 654321098),
(444555666, '123', 765432109);

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `correo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`cedula`, `nombre`, `apellido`, `correo`) VALUES
(12345678, 'Isabel Lopez', 'Diaz', 'isabel.lopez@email.com'),
(109876543, 'Isabel Lopez', 'Diaz', 'isabel.lopez@email.com'),
(111111111, 'Juan', 'Mora', 'mora@gmail.com'),
(111222333, 'Natalia Vargas', 'Diaz', 'natalia.vargas@email.com'),
(117790909, 'Pablo', 'Venegas', 'pablo.venegas@estudiantec.cr'),
(210987654, 'Javier Ramirez', 'Perez', 'javier.ramirez@email.com'),
(222333444, 'Eduardo Rojas', 'Martinez', 'eduardo.rojas@email.com'),
(234567890, 'Carlos Rodriguez', 'Martinez', 'carlos.rodriguez@email.com'),
(321098765, 'Sofia Garcia', 'Molina', 'sofia.garcia@email.com'),
(333222111, 'Marta Rodriguez', 'Lopez', 'marta.rodriguez@email.com'),
(333444555, 'Carmen Cruz', 'Sanchez', 'carmen.cruz@email.com'),
(345678912, 'Juan Perez', 'Gomez', 'juan.perez@email.com'),
(432109876, 'Fernando Perez', 'Gonzalez', 'fernando.perez@email.com'),
(444555666, 'Carlos Soto', 'Gomez', 'carlos.soto@email.com'),
(456789012, 'Diego Ramirez', 'Hernandez', 'diego.ramirez@email.com'),
(543210987, 'Ricardo Mendez', 'Santos', 'ricardo.mendez@email.com'),
(555444333, 'Lucia Morales', 'Vega', 'lucia.morales@email.com'),
(567890123, 'Ana Martinez', 'Fernandez', 'ana.martinez@email.com'),
(654321098, 'Gabriela Torres', 'Lopez', 'gabriela.torres@email.com'),
(666333222, 'Pablo Ortiz', 'Garcia', 'pablo.ortiz@email.com'),
(765432109, 'Andres Hernandez', 'Gomez', 'andres.hernandez@email.com'),
(777888999, 'Valeria Castro', 'Hernandez', 'valeria.castro@email.com'),
(789012345, 'Laura Lopez', 'Sanchez', 'laura.lopez@email.com'),
(876543210, 'Maria Gonzalez', 'Lopez', 'maria.gonzalez@email.com'),
(888999777, 'Felipe Mora', 'Gomez', 'felipe.mora@email.com'),
(890123456, 'Pedro Sanchez', 'Garcia', 'pedro.sanchez@email.com'),
(987654321, 'Elena Rios', 'Castro', 'elena.rios@email.com'),
(999888777, 'Camila Hernandez', 'Lopez', 'camila.hernandez@email.com');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefono` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellido`, `email`, `telefono`, `password`) VALUES
(1, 'Prueba', 'Apellido', 'Prueba@gmail.com', '88888888', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cita_agendada`
--
ALTER TABLE `cita_agendada`
  ADD PRIMARY KEY (`id_cita`),
  ADD KEY `cedula` (`cedula`),
  ADD KEY `id_medico` (`id_medico`);

--
-- Indexes for table `cita_disponible`
--
ALTER TABLE `cita_disponible`
  ADD PRIMARY KEY (`id_cita_disponible`),
  ADD KEY `id_medico` (`id_medico`);

--
-- Indexes for table `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indexes for table `expediente`
--
ALTER TABLE `expediente`
  ADD PRIMARY KEY (`id_expediente`),
  ADD KEY `cedula` (`cedula`);

--
-- Indexes for table `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `cedula` (`cedula`),
  ADD KEY `id_especialidad` (`id_especialidad`);

--
-- Indexes for table `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `medico_cabecera` (`medico_cabecera`),
  ADD KEY `cedula` (`cedula`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`cedula`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cita_agendada`
--
ALTER TABLE `cita_agendada`
  MODIFY `id_cita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cita_disponible`
--
ALTER TABLE `cita_disponible`
  MODIFY `id_cita_disponible` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id_especialidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `expediente`
--
ALTER TABLE `expediente`
  MODIFY `id_expediente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cita_agendada`
--
ALTER TABLE `cita_agendada`
  ADD CONSTRAINT `cita_agendada_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`cedula`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cita_agendada_ibfk_2` FOREIGN KEY (`cedula`) REFERENCES `paciente` (`cedula`) ON UPDATE CASCADE;

--
-- Constraints for table `cita_disponible`
--
ALTER TABLE `cita_disponible`
  ADD CONSTRAINT `cita_disponible_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`cedula`) ON UPDATE CASCADE;

--
-- Constraints for table `expediente`
--
ALTER TABLE `expediente`
  ADD CONSTRAINT `expediente_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `paciente` (`cedula`) ON UPDATE CASCADE;

--
-- Constraints for table `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `persona` (`cedula`) ON UPDATE CASCADE,
  ADD CONSTRAINT `medico_ibfk_2` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id_especialidad`) ON UPDATE CASCADE;

--
-- Constraints for table `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `persona` (`cedula`) ON UPDATE CASCADE,
  ADD CONSTRAINT `paciente_ibfk_2` FOREIGN KEY (`medico_cabecera`) REFERENCES `medico` (`cedula`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
