-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 07, 2017 at 12:27 PM
-- Server version: 5.7.19-log
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sccr`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrador`
--

INSERT INTO `administrador` (`id`, `nome`, `senha`, `login`, `email`) VALUES
(1, 'Flavio', '1230', 'flavio_flavio', 'flavio@gmail'),
(2, 'Lais', '123', 'lais123', 'lais@gmail');

-- --------------------------------------------------------

--
-- Table structure for table `atleta`
--

CREATE TABLE `atleta` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `nomeEquipe` varchar(45) DEFAULT NULL,
  `dtNascimento` varchar(45) DEFAULT NULL,
  `apelido` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `tamCamisa` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `telefoneFixo` varchar(45) DEFAULT NULL,
  `telefoneCelular` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atleta`
--

INSERT INTO `atleta` (`id`, `nome`, `nomeEquipe`, `dtNascimento`, `apelido`, `cpf`, `tamCamisa`, `sexo`, `telefoneFixo`, `telefoneCelular`, `rua`, `bairro`, `cidade`, `estado`, `pais`, `login`, `senha`, `email`) VALUES
(1, 'lais', 'leao', '01-06-1994', 'loris', '12119713450', 'M', 'Feminino', '32222078', '32988456768', 'Rua 01', 'Milho Branco', 'JF', 'MG', 'Brasil', 'lais_lais', '12345', 'lais@gmail.com'),
(3, 'dadasd', NULL, 'asdasdasd', 'dadasd', '333', 'M', 'Masculino', '333', '333', 'adasd', 'dasdas', 'adasdasd', 'das', NULL, 'ddd', 'ddd', 'ddd');

-- --------------------------------------------------------

--
-- Table structure for table `elementokit`
--

CREATE TABLE `elementokit` (
  `id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `kit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `elementokit`
--

INSERT INTO `elementokit` (`id`, `item_id`, `kit_id`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `inscricao`
--

CREATE TABLE `inscricao` (
  `id` int(11) NOT NULL,
  `numeroPeito` int(11) NOT NULL,
  `total` varchar(40) DEFAULT NULL,
  `formaPagamento` varchar(45) DEFAULT NULL,
  `kit_id` int(11) NOT NULL,
  `prova_id` int(11) NOT NULL,
  `percurso_id` int(11) NOT NULL,
  `atleta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `nomeItem` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `nomeItem`) VALUES
(1, 'Camisa');

-- --------------------------------------------------------

--
-- Table structure for table `kit`
--

CREATE TABLE `kit` (
  `id` int(11) NOT NULL,
  `nomeKit` varchar(45) DEFAULT NULL,
  `valor` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kit`
--

INSERT INTO `kit` (`id`, `nomeKit`, `valor`) VALUES
(1, 'Kit Basico', 60),
(2, 'Kit 2', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lote`
--

CREATE TABLE `lote` (
  `id` int(11) NOT NULL,
  `identificacao` varchar(45) DEFAULT NULL,
  `desconto` varchar(40) DEFAULT NULL,
  `dataInicio` varchar(45) DEFAULT NULL,
  `dataFim` varchar(45) DEFAULT NULL,
  `prova_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lote`
--

INSERT INTO `lote` (`id`, `identificacao`, `desconto`, `dataInicio`, `dataFim`, `prova_id`) VALUES
(1, 'Lotes 1', '0', '31-10-2017', '31-12-2017', 1);

-- --------------------------------------------------------

--
-- Table structure for table `organizador`
--

CREATE TABLE `organizador` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `administrador_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organizador`
--

INSERT INTO `organizador` (`id`, `nome`, `senha`, `login`, `email`, `administrador_id`) VALUES
(1, 'claudio', '1234', 'claudio_claudio', 'claudio@gmail', 1);

-- --------------------------------------------------------

--
-- Table structure for table `percurso`
--

CREATE TABLE `percurso` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `distancia` varchar(45) DEFAULT NULL,
  `faixaEtaria` varchar(45) DEFAULT NULL,
  `prova_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `percurso`
--

INSERT INTO `percurso` (`id`, `nome`, `distancia`, `faixaEtaria`, `prova_id`) VALUES
(1, 'Percurso da Tijuca', '10km', 'adulto', 1),
(2, '', '', '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `prova`
--

CREATE TABLE `prova` (
  `id` int(11) NOT NULL,
  `nomeProva` varchar(45) DEFAULT NULL,
  `localLargada` varchar(45) DEFAULT NULL,
  `horarioLargada` varchar(45) DEFAULT NULL,
  `dataProva` varchar(45) DEFAULT NULL,
  `maxParticipantes` varchar(45) DEFAULT NULL,
  `inicioInscricao` varchar(45) DEFAULT NULL,
  `fimInscricao` varchar(45) DEFAULT NULL,
  `faixaEtaria` varchar(45) DEFAULT NULL,
  `localRetiradaKit` varchar(45) DEFAULT NULL,
  `organizador_id` int(11) NOT NULL,
  `ranking_id` int(11) NOT NULL,
  `valorProva` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prova`
--

INSERT INTO `prova` (`id`, `nomeProva`, `localLargada`, `horarioLargada`, `dataProva`, `maxParticipantes`, `inicioInscricao`, `fimInscricao`, `faixaEtaria`, `localRetiradaKit`, `organizador_id`, `ranking_id`, `valorProva`) VALUES
(1, 'Prova da fogueira', 'Juiz de Fora', '09:50', '01-06-2017', '2600', '01-03-2017', '01-05-2017', 'Adulto', 'Shopping Jardim Norte', 1, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ranking`
--

CREATE TABLE `ranking` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ranking`
--

INSERT INTO `ranking` (`id`, `nome`) VALUES
(1, 'Ranking JF');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `atleta`
--
ALTER TABLE `atleta`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `elementokit`
--
ALTER TABLE `elementokit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `item_id` (`item_id`),
  ADD KEY `kit_id` (`kit_id`);

--
-- Indexes for table `inscricao`
--
ALTER TABLE `inscricao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kit_id` (`numeroPeito`),
  ADD KEY `kit_id` (`kit_id`),
  ADD KEY `prova_id` (`prova_id`),
  ADD KEY `percurso_id` (`percurso_id`),
  ADD KEY `atleta_id` (`atleta_id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kit`
--
ALTER TABLE `kit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lote`
--
ALTER TABLE `lote`
  ADD PRIMARY KEY (`id`),
  ADD KEY `prova_id` (`prova_id`);

--
-- Indexes for table `organizador`
--
ALTER TABLE `organizador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `administrador_id` (`administrador_id`);

--
-- Indexes for table `percurso`
--
ALTER TABLE `percurso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `prova_id` (`prova_id`);

--
-- Indexes for table `prova`
--
ALTER TABLE `prova`
  ADD PRIMARY KEY (`id`),
  ADD KEY `organizador_id` (`organizador_id`),
  ADD KEY `ranking_id` (`ranking_id`);

--
-- Indexes for table `ranking`
--
ALTER TABLE `ranking`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `elementokit`
--
ALTER TABLE `elementokit`
  ADD CONSTRAINT `elementoKit_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  ADD CONSTRAINT `elementoKit_ibfk_2` FOREIGN KEY (`kit_id`) REFERENCES `kit` (`id`);

--
-- Constraints for table `inscricao`
--
ALTER TABLE `inscricao`
  ADD CONSTRAINT `inscricao_ibfk_1` FOREIGN KEY (`kit_id`) REFERENCES `kit` (`id`),
  ADD CONSTRAINT `inscricao_ibfk_3` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`),
  ADD CONSTRAINT `inscricao_ibfk_4` FOREIGN KEY (`percurso_id`) REFERENCES `percurso` (`id`),
  ADD CONSTRAINT `inscricao_ibfk_5` FOREIGN KEY (`atleta_id`) REFERENCES `atleta` (`id`);

--
-- Constraints for table `lote`
--
ALTER TABLE `lote`
  ADD CONSTRAINT `lote_ibfk_1` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`);

--
-- Constraints for table `organizador`
--
ALTER TABLE `organizador`
  ADD CONSTRAINT `organizador_ibfk_1` FOREIGN KEY (`administrador_id`) REFERENCES `administrador` (`id`);

--
-- Constraints for table `percurso`
--
ALTER TABLE `percurso`
  ADD CONSTRAINT `percurso_ibfk_1` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`);

--
-- Constraints for table `prova`
--
ALTER TABLE `prova`
  ADD CONSTRAINT `prova_ibfk_1` FOREIGN KEY (`organizador_id`) REFERENCES `organizador` (`id`),
  ADD CONSTRAINT `prova_ibfk_2` FOREIGN KEY (`ranking_id`) REFERENCES `ranking` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
