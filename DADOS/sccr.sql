-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 08, 2018 at 11:11 PM
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
(2, 'lais', '1234', 'lais', 'laisalvesjf@hotmail.com'),
(3, 'flavio', '1234', 'flavio', 'flavio@gmail.com'),
(4, 'jonathas', '321', 'jonathas', 'jonathas@gmail.com');

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
(2, 'Leticia Alves da Silva', 'Academia Em Forma', '15021995', 'Lele', '1306655898', 'M', 'Feminino', '3232213864', '991033564', 'rua ivan batista de oliveira', 'milho branco', 'juiz de fora', 'Minas Gerais', 'Brasil', 'leticiAlves', '32213864', 'leticia@gmail.com'),
(3, 'dadasd', NULL, 'asdasdasd', 'dadasd', '333555', 'M', 'Masculino', '333', '333', 'adasd', 'dasdas', 'adasdasdkmdaks', 'das', NULL, 'ddd', 'ddd', 'ddd'),
(4, 'Lais Alves da Silva', 'Esporte R7', '15021998', 'lala', '13039586602', 'M', 'Feminino', '32566958', '9923655586', 'Rua Francino Salzer', 'Milho Branco', 'Juiz de Fora', 'Minas Gerais', 'Brasil', 'lais', '123', 'laisjf@hotmail.com'),
(5, 'Antonimo Morais da Silva', 'REsportes', '20121991', 'Toninho', '22369586', '	GG', 'Masculino', '326696586', '9663256', 'Rua Gilberto Silva', 'Teixeiras', 'Jui de Fora', 'Minas Gerais', 'Brasil', 'AntonioMorais', '256369', 'Antonio@bol'),
(6, 'Miguel de Almeida', 'LeaoGEsporte', '15021988', 'miguelinho', '55669958', 'M', 'Masculino', '555555', '699565565', 'rua mirante barrosso', 'escalar', 'Sao Paulo', 'Sao Paulo', 'Brasil', '55666', '5566', 'miguelr7@gmail.com'),
(7, 'Justos', 'TransAmericaCorridas', '10081992', 'justinho', '5566958969', 'G', 'Masculino', '5569658', '665559', 'rua f', 'Esperanca', 'Matias Barbosa', 'Minas Gerias', 'Brasil', 'justos', '5586', 'justos00@gmil.com'),
(8, 'michele', 'leoas Equipe', '20041986', 'mimi', '55602', 'M', 'Feminino', '556256', '444545', 'rua miguel olivreia', 'bairro Encosta do Sol', 'juiz de fora', 'Minas Gerais', 'Brasil', '5566999', '556958695', 'michele@gmail.com'),
(9, 'carolina machado da silva', 'Em Forma Academia', '102569', 'carol', '586958', 'P', 'Femminino', '5566958', '5569848', 'gilbera Neto', 'bairro jardim natal', 'Juiz de fora', 'Minas gerais', 'Brasil', 'carolina machado', '33221', 'carol@gmail.com'),
(10, 'mlena rosa', 'Em forma Academia', '20061968', 'migueia', '5569252', 'M', 'Feminino', '22156', '153225', 'rua janeiro metropolitana', 'Bairro Bienal', 'Uberlandia', 'Minas Gerais', 'Brasil', 'milena rosa', '5566', 'milena@gmailc.om'),
(12, 'Romulo Oliveira ', 'Siao Esportes Radicais', '20061979', 'romulinho', '5569855', 'M', 'Masculino', '5562525', '55695565', 'rua esperanca nerculi', 'bairro jk', 'leopoldina', 'Minas Gerais', 'Brasil', 'romulo oliveira', '2325', 'romulo@gmail.com'),
(13, 'Estefani Souza', 'KidsEsportes', '30062006', NULL, '12345678', 'P', 'feminino', NULL, NULL, 'Rua Francino de Assis', 'Teixeiras', 'juiz de fora', 'Minas Gerais', 'Brasil', 'Camila Freitas', '15633982', 'camilinha@hotmail.com'),
(14, 'Millena Silva', 'KitsEsportes', '15-02-2006', 'mimi', '12345678', 'P', 'feminino', '3232213864', '32991033564', 'rua francino salzer ', 'milho branco', 'juiz de fora', 'Minas Gerais', 'Brasil', '226966', '665599', ''),
(15, 'Camila Rodrigues', 'KidsEsportes', '30062006', NULL, '5569855', 'P', 'feminino', NULL, NULL, 'Rua Francino de Assis', 'Teixeiras', 'juiz de fora', 'Minas Gerais', 'Brasil', 'Camila Freitas', '15633982', 'camilinha@hotmail.com'),
(17, 'Mateus Siquiera Mombache ', NULL, '15022007', 'meteuzinho', '13039586602\r\n', NULL, 'masculino', NULL, NULL, 'rua francino salzer ', 'Milho Branco', 'juiz de fora', 'Minas Gerais', 'Brasil', 'Mateus Siqueira', '5569987', NULL),
(18, 'Giovane Silva ', NULL, '15022007', 'gigi', '5569855', NULL, 'masculino', NULL, NULL, 'rua Ivan Batista de Oliveira', 'Jardin Natal', 'juiz de fora', 'Minas Gerais', 'Brasil', 'Giovane Silva', '889656', NULL),
(19, 'Leticia Gimenes', NULL, '15021990', 'piolho', '15325693', 'M', 'feminino', NULL, NULL, 'Ivan Batista de Oliveira ', 'Francisco Bernardino', 'juiz de fora', 'Minas Gerais', 'Brasil', '5695201', '221036', 'leticiaGH@hotmail.com'),
(20, 'Gilberto Magahaes Pereira', NULL, '15021990', 'lele', '10569', 'M', 'feminino', NULL, NULL, 'Ivan Batista de Oliveira ', 'Francisco Bernardino', 'juiz de fora', 'Minas Gerais', 'Brasil', '55223', '10550', 'gilbertokm@gmail.com'),
(21, 'Gileno Marco Silva', NULL, '15031956', 'gileninho', '56012013', 'G', 'masculino', '32213864', '910356489', 'Rua Alberto Braga', 'Santa Lucia', 'juiz de fora', 'Minas Gerais', 'Brasil', '401010', '102030', 'gilenoBrasileirinho @hotmail.com'),
(44, 'adasdasdd', NULL, '1998-12-02', 'dads', '13039586602', 'M', 'Masculino', '55555555', '5555555', 'llll', 'llll', 'll', 'ac', NULL, '6666', '66', 'laislvesjf@hotmail.com'),
(300, 'Hilton', NULL, '01/09/1902', 'Hil', '123456789', 'M', 'Masculino', '32 32219955', '32 991345678', 'IF Sudeste MG', 'Fabrica', 'Juiz de Fora', 'Minas Gerais', NULL, 'hil_hil', '1234', 'lais@');

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
(4, 5, 3),
(50, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `inscricao`
--

CREATE TABLE `inscricao` (
  `id` int(11) NOT NULL,
  `numeroPeito` int(11) NOT NULL,
  `pago` int(1) NOT NULL,
  `total` varchar(40) DEFAULT NULL,
  `formaPagamento` varchar(45) DEFAULT NULL,
  `categoria` varchar(55) NOT NULL,
  `kit_id` int(11) NOT NULL,
  `prova_id` int(11) NOT NULL,
  `percurso_id` int(11) NOT NULL,
  `atleta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inscricao`
--

INSERT INTO `inscricao` (`id`, `numeroPeito`, `pago`, `total`, `formaPagamento`, `categoria`, `kit_id`, `prova_id`, `percurso_id`, `atleta_id`) VALUES
(1, 1523, 1, '100', 'cartao de credito', 'adulto', 1, 1, 1, 1),
(2, 1569, 1, '100', 'cartao de credito', 'adulto', 3, 2, 1, 4),
(3, 1669, 1, '70', 'cartao de credito', 'idoso', 2, 2, 1, 12),
(4, 55698, 1, '70', 'Boleto BancÃ¡rio', 'infantil', 1, 2, 1, 18),
(5, 226589, 1, '70', 'cartao de credito', 'infantil', 1, 2, 1, 17),
(6, 5511000, 1, '70', 'cartao de credito', 'idoso', 3, 2, 1, 12),
(8, 558920, 1, '70', 'cartao de credito', 'infantil', 1, 2, 1, 15),
(9, 55029, 1, '70', 'cartao de credito', 'infantil', 1, 1, 1, 15),
(10, 210, 1, '70', 'cartao de credito', 'idoso', 3, 2, 1, 13),
(12, 66500, 1, '70', 'cartao de credito', 'idoso', 1, 2, 1, 19),
(15, 502020, 1, '70', 'cartao de credito', 'adulto', 1, 2, 1, 20),
(17, 556, 1, '70', 'cartao de credito', 'adulto', 2, 1, 1, 21),
(19, 102323, 1, '70', 'cartao de credito', 'adulto', 2, 2, 1, 2),
(20, 33660, 1, '70', 'boleto bancario', 'adulto', 1, 2, 1, 2),
(21, 556, 1, '70', 'cartao de credito', 'adulto', 2, 1, 1, 21),
(22, 33660, 1, '70', 'boleto bancario', 'adulto', 1, 2, 1, 2),
(23, 30100, 1, '90', 'cartao de credito', 'adulto', 1, 2, 1, 8),
(24, 7887, 1, '95', 'cartao de credito', 'adulto', 1, 2, 1, 9),
(88, 28458872, 1, '', 'CartÃ£o de Credito', 'infantil-5 a 12 anos', 2, 1, 1, 3),
(900, 43697188, 1, '170', 'CartÃ£o de Credito', 'infantil-5 a 12 anos', 3, 1, 2, 300),
(50000, 148696947, 1, '300', 'Boleto BancÃ¡rio', 'adulto-18 a 59 anos', 3, 30, 2, 1);

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
(1, 'Camisa'),
(2, 'lanterna'),
(3, 'tenis'),
(4, '1 chip descartavel'),
(5, 'toalha fitness'),
(6, '1 camiseta de poliamida'),
(7, 'Numero de Peito'),
(8, 'barra de ceral'),
(9, 'energetiico');

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
(2, 'Kit 2', NULL),
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
(3, 'Lote3', '10', '30-11-2017', '15-12-2017', 1),
(4, 'Lote 1 Asconcer', '20', '30-04-2017', '10-05-2017', 2),
(5, 'Lote 2 Asconcer', '10', '11-05-2017', '28-05-2017', 2);

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
(1, 'claudioSilva', '1234', 'claudio_claudio', 'claudio@gmail', 1),
(2, 'Marina Alves', '1234', 'marina alves', 'mama@gmail.com', 1);

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
(2, 'Ufjf', '10Km', '12-60 anos', 2);

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
  `localRetiradaKit` varchar(45) DEFAULT NULL,
  `organizador_id` int(11) NOT NULL,
  `ranking_id` int(11) NOT NULL,
  `valorProva` varchar(45) DEFAULT NULL,
  `inicioIdade` int(11) NOT NULL,
  `fimIdade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prova`
--

INSERT INTO `prova` (`id`, `nomeProva`, `localLargada`, `horarioLargada`, `dataProva`, `maxParticipantes`, `inicioInscricao`, `fimInscricao`, `localRetiradaKit`, `organizador_id`, `ranking_id`, `valorProva`, `inicioIdade`, `fimIdade`) VALUES
(1, 'Prova da fogueira', 'Juiz de Foras', '09:50', '01-06-2017', '5555', '01-03-2017', '01-05-2017', 'Shopping Jardim Norte', 1, 1, '70', 0, 0),
(2, 'Asconcer', 'ufjf', '8:00', '01 06 2017', '100000', '30-04-2017', '28-05-2017', 'Shopping Jardim norte', 1, 1, '70', 0, 0),
(30, 'Prova do gelo', 'Shopping', '09:30', '06/07/2018', '2000', '01/06/2018', '05/06/2018', 'Getulio vargas', 2, 1, '200', 0, 0);

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
  `nomeAtleta` varchar(45) DEFAULT NULL,
  `numeroPeito` int(11) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `classificacao` int(11) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `prova` varchar(45) DEFAULT NULL,
  `tempo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `resultadoprovas`
--

INSERT INTO `resultadoprovas` (`id`, `nomeAtleta`, `numeroPeito`, `categoria`, `classificacao`, `sexo`, `prova`, `tempo`) VALUES
(1, 'lais', 1523, 'adulto', 5, 'Feminino', 'Asconcer', 0),
(2, 'Lais Alves da Silva', 1569, 'adulto', 2, 'Feminino', 'Asconcer', 0),
(3, 'Romulo Oliveira ', 1669, 'idoso', 6, 'maculino', 'Asconcer ', 0),
(4, 'Giovane Silva ', 55698, 'infantil', 6, 'maculino', 'Asconcer ', 0),
(5, 'Romulo Oliveira ', 5511000, 'idoso', 16, 'masculino', 'asconcer', 0),
(6, 'Alice', 99, 'infantil', 16, 'feminino', 'asconcer', 0),
(7, 'Camila Rodrigues', 558920, 'infantil', 6, 'feminino', 'Asconcer', 0),
(8, 'Millena Silva', 210, 'idoso', 8, 'feminino', 'Asconcer', 0),
(9, 'Gilberto Magahaes Pereira', 502020, 'adulto', 10, 'masculino', 'Asconcer', 0),
(10, 'carolina machado da silva', 502020, 'adulto', 30, 'feminino', 'Asconcer', 0),
(12, 'Mateus Siquiera Mombache ', 226589, 'infantil', 60, 'masculino', 'Asconcer', 0);

-- --------------------------------------------------------

--
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50001;
--
-- AUTO_INCREMENT for table `resultadoprovas`
--
ALTER TABLE `resultadoprovas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100000000;
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
  ADD CONSTRAINT `lote_ibfk_1` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`),
  ADD CONSTRAINT `organizador_id` FOREIGN KEY (`prova_id`) REFERENCES `organizador` (`id`);

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
