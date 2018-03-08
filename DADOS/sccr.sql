-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 08-Mar-2018 às 10:38
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Estrutura da tabela `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `administrador`
--

INSERT INTO `administrador` (`id`, `nome`, `senha`, `login`, `email`) VALUES
(1, 'Flavio', '1230', 'flavio_flavio', 'flavio@gmail'),
(2, 'lais', '1234', 'lais', 'laisalvesjf@hotmail.com'),
(3, 'jonathas', '321', 'jonathas', 'jonathas@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `atleta`
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
-- Extraindo dados da tabela `atleta`
--

INSERT INTO `atleta` (`id`, `nome`, `nomeEquipe`, `dtNascimento`, `apelido`, `cpf`, `tamCamisa`, `sexo`, `telefoneFixo`, `telefoneCelular`, `rua`, `bairro`, `cidade`, `estado`, `pais`, `login`, `senha`, `email`) VALUES
(1, 'Leticia Alves da Silva', 'Academia Em Forma', '15021995', 'Lele', '1306655898', 'M', 'Feminino', '3232213864', '991033564', 'rua ivan batista de oliveira', 'milho branco', 'juiz de fora', 'Minas Gerais', 'Brasil', 'leticiAlves', '32213864', 'leticia@gmail.com'),
(2, 'Antonimo Morais da Silva', 'REsportes', '20121991', 'Toninho', '22369586', '	GG', 'Masculino', '326696586', '9663256', 'Rua Gilberto Silva', 'Teixeiras', 'Jui de Fora', 'Minas Gerais', 'Brasil', 'AntonioMorais', '256369', 'Antonio@bol'),
(3, 'Miguel de Almeida', 'LeaoGEsporte', '15021988', 'miguelinho', '55669958', 'M', 'Masculino', '555555', '699565565', 'rua mirante barrosso', 'escalar', 'Sao Paulo', 'Sao Paulo', 'Brasil', '55666', '5566', 'miguelr7@gmail.com'),
(4, 'Michele', 'leoas Equipe', '20041986', 'mimi', '55602', 'M', 'Feminino', '556256', '444545', 'rua miguel olivreia', 'bairro Encosta do Sol', 'juiz de fora', 'Minas Gerais', 'Brasil', '5566999', '556958695', 'michele@gmail.com'),
(5, 'Carolina Machado da silva', 'Em Forma Academia', '102569', 'carol', '586958', 'P', 'Femminino', '5566958', '5569848', 'gilbera Neto', 'bairro jardim natal', 'Juiz de fora', 'Minas gerais', 'Brasil', 'carolina machado', '33221', 'carol@gmail.com'),
(6, 'Mlena Rosa', 'Em forma Academia', '20061968', 'migueia', '5569252', 'M', 'Feminino', '22156', '153225', 'rua janeiro metropolitana', 'Bairro Bienal', 'Uberlandia', 'Minas Gerais', 'Brasil', 'milena rosa', '5566', 'milena@gmailc.om'),
(7, 'Romulo Oliveira ', 'Siao Esportes Radicais', '20061979', 'romulinho', '5569855', 'M', 'Masculino', '5562525', '55695565', 'rua esperanca nerculi', 'bairro jk', 'leopoldina', 'Minas Gerais', 'Brasil', 'romulo oliveira', '2325', 'romulo@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `elementokit`
--

CREATE TABLE `elementokit` (
  `id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `kit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `elementokit`
--

INSERT INTO `elementokit` (`id`, `item_id`, `kit_id`) VALUES
(1, 3, 1),
(2, 7, 4),
(3, 2, 1),
(4, 5, 3),
(50, 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `inscricao`
--

CREATE TABLE `inscricao` (
  `id` int(11) NOT NULL,
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
-- Extraindo dados da tabela `inscricao`
--

INSERT INTO `inscricao` (`id`, `pago`, `total`, `formaPagamento`, `categoria`, `kit_id`, `prova_id`, `percurso_id`, `atleta_id`) VALUES
(1, 1, '100', 'cartao de credito', 'adulto', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `nomeItem` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `item`
--

INSERT INTO `item` (`id`, `nomeItem`) VALUES
(1, 'Camisa de malha fina'),
(2, 'Lanterna de bolso'),
(3, 'Tenis'),
(4, 'Chip descartavel'),
(5, 'Toalha fitness'),
(6, 'Camiseta de poliamida'),
(7, 'Numero de Peito'),
(8, 'Barra de ceral'),
(9, 'Energetiico');

-- --------------------------------------------------------

--
-- Estrutura da tabela `kit`
--

CREATE TABLE `kit` (
  `id` int(11) NOT NULL,
  `nomeKit` varchar(45) DEFAULT NULL,
  `valor` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `kit`
--

INSERT INTO `kit` (`id`, `nomeKit`, `valor`) VALUES
(1, 'Kit intermediario', 60),
(3, 'Kit Esportivo', 100),
(4, 'kit basico', 30);

-- --------------------------------------------------------

--
-- Estrutura da tabela `lote`
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
-- Extraindo dados da tabela `lote`
--

INSERT INTO `lote` (`id`, `identificacao`, `desconto`, `dataInicio`, `dataFim`, `prova_id`) VALUES
(1, 'Lote 1', '0', '31-10-2017', '31-12-2017', 1),
(2, 'Lote 2', '20', '15-11-2017', '28-11-2017', 1),
(3, 'Lote 3', '10', '30-11-2017', '15-12-2017', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `organizador`
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
-- Extraindo dados da tabela `organizador`
--

INSERT INTO `organizador` (`id`, `nome`, `senha`, `login`, `email`, `administrador_id`) VALUES
(1, 'Claudio Silva', '1234', 'claudio_claudio', 'claudio@gmail', 1),
(2, 'Marina Alves', '1234', 'marina alves', 'mama@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `percurso`
--

CREATE TABLE `percurso` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `distancia` varchar(45) DEFAULT NULL,
  `faixaEtaria` varchar(45) DEFAULT NULL,
  `prova_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `percurso`
--

INSERT INTO `percurso` (`id`, `nome`, `distancia`, `faixaEtaria`, `prova_id`) VALUES
(1, 'Percurso leve', '05km', 'adulto', 1),
(2, 'Percurso intermediario', '10Km', 'adulto', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `prova`
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
-- Extraindo dados da tabela `prova`
--

INSERT INTO `prova` (`id`, `nomeProva`, `localLargada`, `horarioLargada`, `dataProva`, `maxParticipantes`, `inicioInscricao`, `fimInscricao`, `localRetiradaKit`, `organizador_id`, `ranking_id`, `valorProva`, `inicioIdade`, `fimIdade`) VALUES
(1, 'Prova da fogueira', 'Juiz de Foras', '09:50', '01-06-2017', '5555', '01-03-2017', '01-05-2017', 'Shopping Jardim Norte', 1, 1, '70', 0, 0),
(2, 'Prova da Asconcer', 'ufjf', '8:00', '01-06-2017', '100000', '30-04-2017', '28-05-2017', 'Shopping Jardim norte', 1, 1, '70', 0, 0),
(30, 'Prova da familia', 'Shopping', '09:30', '06-07-2018', '2000', '01-06-2018', '05-06-2018', 'Getulio vargas', 2, 1, '200', 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ranking`
--

CREATE TABLE `ranking` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ranking`
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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inscricao`
--
ALTER TABLE `inscricao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50001;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `elementokit`
--
ALTER TABLE `elementokit`
  ADD CONSTRAINT `elementoKit_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  ADD CONSTRAINT `elementoKit_ibfk_2` FOREIGN KEY (`kit_id`) REFERENCES `kit` (`id`);

--
-- Limitadores para a tabela `inscricao`
--
ALTER TABLE `inscricao`
  ADD CONSTRAINT `inscricao_ibfk_1` FOREIGN KEY (`kit_id`) REFERENCES `kit` (`id`),
  ADD CONSTRAINT `inscricao_ibfk_3` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`),
  ADD CONSTRAINT `inscricao_ibfk_4` FOREIGN KEY (`percurso_id`) REFERENCES `percurso` (`id`),
  ADD CONSTRAINT `inscricao_ibfk_5` FOREIGN KEY (`atleta_id`) REFERENCES `atleta` (`id`);

--
-- Limitadores para a tabela `lote`
--
ALTER TABLE `lote`
  ADD CONSTRAINT `lote_ibfk_1` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`),
  ADD CONSTRAINT `organizador_id` FOREIGN KEY (`prova_id`) REFERENCES `organizador` (`id`);

--
-- Limitadores para a tabela `organizador`
--
ALTER TABLE `organizador`
  ADD CONSTRAINT `organizador_ibfk_1` FOREIGN KEY (`administrador_id`) REFERENCES `administrador` (`id`);

--
-- Limitadores para a tabela `percurso`
--
ALTER TABLE `percurso`
  ADD CONSTRAINT `percurso_ibfk_1` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`);

--
-- Limitadores para a tabela `prova`
--
ALTER TABLE `prova`
  ADD CONSTRAINT `prova_ibfk_1` FOREIGN KEY (`organizador_id`) REFERENCES `organizador` (`id`),
  ADD CONSTRAINT `prova_ibfk_2` FOREIGN KEY (`ranking_id`) REFERENCES `ranking` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
