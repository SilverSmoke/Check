-- phpMyAdmin SQL Dump
-- version 4.0.10.10
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Время создания: Янв 18 2017 г., 14:13
-- Версия сервера: 5.5.45
-- Версия PHP: 5.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `checkDB`
--

-- --------------------------------------------------------

--
-- Структура таблицы `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `market` varchar(32) NOT NULL,
  `section` varchar(32) NOT NULL,
  `product` varchar(32) NOT NULL,
  `price` double NOT NULL,
  `time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

--
-- Дамп данных таблицы `test`
--

INSERT INTO `test` (`id`, `market`, `section`, `product`, `price`, `time`) VALUES
(1, 'Lenta', 'продукты', 'хлеб', 30, 2147483647),
(9, 'Castorama', 'стройка', 'клей', 45, 0),
(10, 'Сибириада', 'Продукты', 'Молоко', 56, 1484733034),
(11, 'Сибириада', 'Продукты', 'Кефир', 51, 1484733126),
(12, 'khgjkg', 'khjbkl', 'kjhkb', 45, 1484734455),
(13, 'khgjkg', 'khjbkl', 'kjhkb', 45, 1484734685),
(14, 'khgjkg', 'khjbkl', 'kjhkb', 45, 1484736467),
(15, 'khgjkg', 'khjbkl', 'kjhkb', 45, 1484736471),
(16, 'khgjkg', 'khjbkl', 'kjhkb', 45, 1484736473),
(17, 'khgjkg', 'khjbkl', 'kjhkb', 45, 1484736486),
(18, '', '', '', 0, 1484736633),
(19, '', '', '', 0, 1484736669),
(20, '', '', '', 0, 1484737242),
(21, '', '', '', 0, 1484737273),
(22, '-', '-', '-', 0, 1484737586),
(23, 'cgd6hvdhy6b', 'xsrgfcce', 'srxf', 45, 1484737626),
(24, '-', '-', '-', 0, 1484737818);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
