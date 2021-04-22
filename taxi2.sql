-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-04-2021 a las 11:06:05
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `taxi2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos2`
--

CREATE TABLE `datos2` (
  `Latitud` double NOT NULL,
  `Longitud` double NOT NULL,
  `Tiempo` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datos2`
--

INSERT INTO `datos2` (`Latitud`, `Longitud`, `Tiempo`) VALUES
(10.418, -75.5414, '2021-04-21 10:05:21'),
(10.4182, -75.5416, '2021-04-21 10:10:21'),
(10.4181, -75.5418, '2021-04-21 10:21:21'),
(10.4179, -75.542, '2021-04-22 10:27:21'),
(10.4176, -75.5424, '2021-04-21 10:35:21'),
(10.4172, -75.5428, '2021-04-21 10:46:21');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
