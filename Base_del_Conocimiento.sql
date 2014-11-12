-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 12-11-2014 a las 04:12:30
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `Base del Conocimiento`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `danio`
--

CREATE TABLE IF NOT EXISTS `danio` (
`indice` int(3) NOT NULL,
  `definicion` varchar(240) COLLATE utf8_spanish_ci NOT NULL,
  `id_hardware` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hardware`
--

CREATE TABLE IF NOT EXISTS `hardware` (
`indice` int(3) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(140) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `hardware`
--

INSERT INTO `hardware` (`indice`, `nombre`, `descripcion`) VALUES
(1, 'Microprocesador', ''),
(2, 'Tarjeta Madre', ''),
(3, 'Memoria RAM', ''),
(4, 'Fuente de Almentación', ''),
(5, 'Disco Duro', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recomendacion`
--

CREATE TABLE IF NOT EXISTS `recomendacion` (
`indice` int(3) NOT NULL,
  `definición_diag` int(240) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sintoma`
--

CREATE TABLE IF NOT EXISTS `sintoma` (
`id_sintoma` int(3) NOT NULL,
  `descripcion` varchar(140) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_danio` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `danio`
--
ALTER TABLE `danio`
 ADD PRIMARY KEY (`indice`);

--
-- Indices de la tabla `hardware`
--
ALTER TABLE `hardware`
 ADD PRIMARY KEY (`indice`);

--
-- Indices de la tabla `recomendacion`
--
ALTER TABLE `recomendacion`
 ADD PRIMARY KEY (`indice`);

--
-- Indices de la tabla `sintoma`
--
ALTER TABLE `sintoma`
 ADD PRIMARY KEY (`id_sintoma`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `danio`
--
ALTER TABLE `danio`
MODIFY `indice` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `hardware`
--
ALTER TABLE `hardware`
MODIFY `indice` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `recomendacion`
--
ALTER TABLE `recomendacion`
MODIFY `indice` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sintoma`
--
ALTER TABLE `sintoma`
MODIFY `id_sintoma` int(3) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `danio`
--
ALTER TABLE `danio`
ADD CONSTRAINT `danio_hardware` FOREIGN KEY (`indice`) REFERENCES `hardware` (`indice`);

--
-- Filtros para la tabla `sintoma`
--
ALTER TABLE `sintoma`
ADD CONSTRAINT `sintoma_danio` FOREIGN KEY (`id_sintoma`) REFERENCES `danio` (`indice`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
