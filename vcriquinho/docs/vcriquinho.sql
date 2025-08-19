-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `vcriquinho`
--
DROP DATABASE IF EXISTS `vcriquinho`;
CREATE DATABASE IF NOT EXISTS `vcriquinho` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vcriquinho`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  `nome` varchar(65) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `contas`
--

CREATE TABLE `contas` (
  `id` int(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  `id_cliente` int(10) UNSIGNED NOT NULL,
  `saldo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `contas_cdi`
--

CREATE TABLE `contas_cdi` (
  `id_conta` int(10) UNSIGNED NOT NULL PRIMARY KEY,
  FOREIGN KEY (`id_conta`) REFERENCES `contas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `contas_corrente`
--

CREATE TABLE `contas_corrente` (
  `id_conta` int(10) UNSIGNED NOT NULL PRIMARY KEY,
  FOREIGN KEY (`id_conta`) REFERENCES `contas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `contas_inv_aut`
--

CREATE TABLE `contas_inv_aut` (
  `id_conta` int(10) UNSIGNED NOT NULL,
  `pessoa_fisica` tinyint(1) DEFAULT 0,
  FOREIGN KEY (`id_conta`) REFERENCES `contas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoas_fisicas`
--

CREATE TABLE `pessoas_fisicas` (
  `id_cliente` int(10) UNSIGNED NOT NULL PRIMARY KEY,
  `cpf` char(11) NOT NULL UNIQUE,
  FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoas_juridicas`
--

CREATE TABLE `pessoas_juridicas` (
  `id_cliente` int(10) UNSIGNED NOT NULL PRIMARY KEY,
  `cnpj` char(14) NOT NULL UNIQUE,
  FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos`
--

CREATE TABLE `produtos` (
  `id` int(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  `id_conta` int(10) UNSIGNED NOT NULL,
  `nome` varchar(33) NOT NULL,
  `descricao` varchar(129) DEFAULT NULL,
  `rendimento` int(11) DEFAULT NULL,
  FOREIGN KEY (`id_conta`) REFERENCES `contas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos_renda_fixa`
--

CREATE TABLE `produtos_renda_fixa` (
  `id_produto` int(10) UNSIGNED NOT NULL PRIMARY KEY,
  `em_carencia` tinyint(1) DEFAULT 1,
  `dias_carencia` tinyint(3) UNSIGNED DEFAULT 0,
  FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos_renda_variavel`
--

CREATE TABLE `produtos_renda_variavel` (
  `id_produto` int(10) UNSIGNED NOT NULL PRIMARY KEY,
  FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
