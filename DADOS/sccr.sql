-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 03, 2018 at 04:22 PM
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
(2, 'Lais', '1234', 'lais', 'laisalvesjf@hotmail.com'),
(3, 'jonathas', '321', 'jonathas', 'jonathas@gmail.com');

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
(1, 'Lais Botelho', 'leao', '01-06-1994', 'loris', '12119713450', 'M', 'Feminino', '32222078', '32988456768', 'Rua 01', 'Milho Branco', 'JF', 'MG', 'Brasil', 'lais_lais', '12345', 'lais@gmail.com'),
(2, 'Leticia Alves da Silva', 'Academia Em Forma', '15021995', 'Lele', '1306655898', 'M', 'Feminino', '3232213864', '991033564', 'rua ivan batista de oliveira', 'milho branco', 'juiz de fora', 'Minas Gerais', 'Brasil', 'leticiAlves', '32213864', 'leticia@gmail.com'),
(3, 'Dalas Mariana', NULL, 'asdasdasd', 'dadasd', '333555', 'M', 'Masculino', '333', '333', 'adasd', 'dasdas', 'adasdasdkmdaks', 'das', NULL, 'ddd', 'ddd', 'ddd'),
(4, 'Alves da Silva', 'Esporte R7', '15021998', 'lala', '13039586602', 'M', 'Feminino', '32566958', '9923655586', 'Rua Francino Salzer', 'Milho Branco', 'Juiz de Fora', 'Minas Gerais', 'Brasil', 'lais', '123', 'laisjf@hotmail.com'),
(5, 'Antonimo Morais da Silva', 'REsportes', '20121991', 'Toninho', '22369586', '	GG', 'Masculino', '326696586', '9663256', 'Rua Gilberto Silva', 'Teixeiras', 'Jui de Fora', 'Minas Gerais', 'Brasil', 'AntonioMorais', '256369', 'Antonio@bol'),
(6, 'Miguel de Almeida', 'LeaoGEsporte', '15021988', 'miguelinho', '55669958', 'M', 'Masculino', '555555', '699565565', 'rua mirante barrosso', 'escalar', 'Sao Paulo', 'Sao Paulo', 'Brasil', '55666', '5566', 'miguelr7@gmail.com'),
(7, 'Juliano Aquino', 'TransAmericaCorridas', '10081992', 'justinho', '5566958969', 'G', 'Masculino', '5569658', '665559', 'rua f', 'Esperanca', 'Matias Barbosa', 'Minas Gerias', 'Brasil', 'justos', '5586', 'justos00@gmil.com'),
(8, 'Michele Lorenzo', 'leoas Equipe', '20041986', 'mimi', '55602', 'M', 'Feminino', '556256', '444545', 'rua miguel olivreia', 'bairro Encosta do Sol', 'juiz de fora', 'Minas Gerais', 'Brasil', '5566999', '556958695', 'michele@gmail.com'),
(9, 'Carolina Machado da Silva', 'Em Forma Academia', '102569', 'carol', '586958', 'P', 'Femminino', '5566958', '5569848', 'gilbera Neto', 'bairro jardim natal', 'Juiz de fora', 'Minas gerais', 'Brasil', 'carolina machado', '33221', 'carol@gmail.com'),
(10, 'Milena Rosa', 'Em forma Academia', '20061968', 'migueia', '5569252', 'M', 'Feminino', '22156', '153225', 'rua janeiro metropolitana', 'Bairro Bienal', 'Uberlandia', 'Minas Gerais', 'Brasil', 'milena rosa', '5566', 'milena@gmailc.om'),
(12, 'Romulo Oliveira ', 'Siao Esportes Radicais', '20061979', 'romulinho', '5569855', 'M', 'Masculino', '5562525', '55695565', 'rua esperanca nerculi', 'bairro jk', 'leopoldina', 'Minas Gerais', 'Brasil', 'romulo oliveira', '2325', 'romulo@gmail.com'),
(44, 'Aries Carolina', NULL, '1998-12-02', 'dads', '13039586602', 'M', 'Masculino', '55555555', '5555555', 'llll', 'llll', 'll', 'ac', NULL, '6666', '66', 'laislvesjf@hotmail.com');

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
(1, 3, 1),
(2, 7, 4),
(3, 2, 1),
(4, 5, 3);

-- --------------------------------------------------------

--
-- Table structure for table `inscricao`
--

CREATE TABLE `inscricao` (
  `id` int(11) NOT NULL,
  `numeroPeito` int(11) NOT NULL,
  `pago` tinyint(1) NOT NULL,
  `total` varchar(40) DEFAULT NULL,
  `formaPagamento` varchar(45) DEFAULT NULL,
  `categoria` varchar(55) NOT NULL,
  `kit_id` int(11) NOT NULL,
  `prova_id` int(11) NOT NULL,
  `percurso_id` int(11) NOT NULL,
  `atleta_id` int(11) NOT NULL,
  `kitRetirado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inscricao`
--

INSERT INTO `inscricao` (`id`, `numeroPeito`, `pago`,`kitRetirado`, `total`, `formaPagamento`, `categoria`, `kit_id`, `prova_id`, `percurso_id`, `atleta_id`) VALUES
(1, 1523, 1,1, '100,00', 'Cartao de credito', 'adulto', 1, 1, 1, 1),
(2, 1569, 1,0, '100,00', 'Cartao de credito', 'adulto', 3, 2, 1, 4),
(3, 1668, 1,1, '70,00', 'Cartao de credito', 'idoso', 2, 2, 1, 12),
(4, 265, 0,0, '', 'Boleto', 'infantil', 1, 1, 1, 1),
(5, 1006, 0,1, '', 'Boleto', 'infanti', 1, 2, 1, 3);

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
(1, 'Camisa de malha fina'),
(2, 'Lanterna'),
(3, 'Oculos 3D'),
(4, 'Chip descartavel'),
(5, 'Toalha fitness'),
(6, 'Camiseta de poliamida'),
(7, 'Numero de Peito'),
(8, 'Barra de ceral fitness'),
(9, 'Energetiico');

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
(2, 'Kit Iniciante', 70),
(3, 'Kit Esportivo', 100),
(4, 'kit simples', 30);

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
(1, 'Lotes 1', '0', '31-10-2017', '31-12-2017', 1),
(2, 'Lote 2', '20', '15-11-2017', '28-11-2017', 1),
(3, 'Lote 3', '10', '30-11-2017', '15-12-2017', 1);


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
(1, 'Claudio Silva', '1234', 'claudio_claudio', 'claudio@gmail', 1),
(2, 'Marina Alves', '1234', 'marina_alves', 'mama@gmail.com', 1),
(3, 'Lais Mariana', '1234', 'lais_mariana', 'lais@hotmail.com', 1),
(4, 'Jonas Cesar', '1234', 'jonas_cesar', 'jonas@gmail.com', 1);

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
(1, 'Percurso pequeno', '10km', 'adulto', 1),
(2, 'Percurso medio', '10Km', '12-60 anos', 2);

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
(1, 'Prova da fogueira', 'Juiz de Forass', '09:50', '01-06-2017', '5555', '01-03-2017', '01-05-2017', 'Adulto', 'Shopping Jardim Norte', 1, 1, '70'),
(2, 'Asconcer', 'ufjf', '8:00', '01 06 2017', '100000', '30-04-2017', '28-05-2017', '12-70 anos', 'Shopping Jardim norte', 1, 1, '70');

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

-- --------------------------------------------------------

--
-- Table structure for table `resultadoprovas`
--

CREATE TABLE `resultadoprovas` (
  `id` int(11) NOT NULL,
  `nomeAtleta` varchar(45) NOT NULL,
  `numeroPeito` int(11) NOT NULL,
  `tempo` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `classificacao` int(11) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `prova` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `resultadoprovas`
--

INSERT INTO `resultadoprovas` (`id`, `nomeAtleta`, `numeroPeito`, `tempo`, `categoria`, `classificacao`, `sexo`, `prova`) VALUES
(1, 'Lais Botelho', 3, '45Minutos', 'infantil', 5, 'masculino', 'Asconcer'),
(2, 'Leticia Alves da Silva', 77, '10min', 'infantil', 2, 'masculino', 'Asconcer'),
(3, 'Dalas Mariana', 56, '30min', 'infantil', 6, 'maculino', 'Asconcer Br'),
(4, 'Alves da Silva', 56, '30min', 'infantil', 6, 'maculino', 'Asconcer Br'),
(5, 'Milena Rosa', 99, '60min', 'feminino', 16, 'feminino', 'asconcer'),
(6, 'Romulo Oliveira', 99, '60min', 'infantil', 16, 'feminino', 'asconcer');

-- --------------------------------------------------------

-- Table structure for table `resultadoranking`
--

CREATE TABLE `resultadoranking` (
  `id` int(11) NOT NULL,
  `nomeAtleta` varchar(45) NOT NULL,
  `classificacao` int(11) NOT NULL,
  `pontuacao` int(11) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `ranking` varchar(45) NOT NULL,
  `sexo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `resultadoranking`
--

INSERT INTO `resultadoranking` (`id`, `nomeAtleta`, `classificacao`, `pontuacao`, `categoria`, `ranking`, `sexo`) VALUES
(1, 'larissa almeida', 5, 66, 'idoso', 'RankingJF', 'feminino'),
(2, 'larissa almeida', 5, 66, 'idoso', 'RankingJF', 'masculino');

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
-- Indexes for table `resultadoprovas`
--
ALTER TABLE `resultadoprovas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `resultadoranking`
--
ALTER TABLE `resultadoranking`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inscricao`
--
ALTER TABLE `inscricao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `resultadoprovas`
--
ALTER TABLE `resultadoprovas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `resultadoranking`
--
ALTER TABLE `resultadoranking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
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
