-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 01-Abr-2016 às 17:26
-- Versão do servidor: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gerenciadorpampatec`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `analiseemprego`
--

CREATE TABLE `analiseemprego` (
  `idAnaliseEmprego` int(11) NOT NULL,
  `relacoesClientes` text,
  `parceriasChaves` text,
  `canais` text,
  `recursosPrincipais` text,
  `concorrentes` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `analiseemprego`
--

INSERT INTO `analiseemprego` (`idAnaliseEmprego`, `relacoesClientes`, `parceriasChaves`, `canais`, `recursosPrincipais`, `concorrentes`) VALUES
(4, 'nteração de produtores através dos comercio eletrônico.', 'Bancos do Brasil e Sicredi que tem interesse em fomentar a comercio entre produtores (principalmente venda de reprodutores\r\ns) que estão restritos ao comercio local e visam exposição e comercio o ano inteiro, não mais, restritos a exposições - feira de primavera. ', 'Estamos buscando a melhor forma de marketing, pois esta e a maior dificuldade encontrada no momento. Como atingir o publico alvo tendo em vista que o produtor ainda e muito refratário aos recursos tecnológico. Estamos focados em atingir aos filhos destes produtores que além da visão de preservação e do bem estar animal já são nativos da informática!', 'Ambiente eletrônico, permitindo ganhos de competitividades através da otimização de processos. Com maior alcance geográfico, de forma segura e transparente,respeitando a privacidade das informações. A aquisição das ofertas por novos produtores gerando receita e bons negócios sem intermediários.', 'As leiloeiras e as corretoras tradicionais.'),
(6, 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.'),
(7, 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.'),
(8, 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.'),
(9, 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.'),
(10, 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.'),
(12, 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.'),
(13, 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.'),
(14, 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete'),
(15, 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentarioanaliseemprego`
--

CREATE TABLE `comentarioanaliseemprego` (
  `idcomentarioanaliseemprego` int(11) NOT NULL,
  `relacoesClientes` text,
  `parceriasChaves` text,
  `canais` text,
  `recursosPrincipais` text,
  `concorrentes` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentarionegocio`
--

CREATE TABLE `comentarionegocio` (
  `idcomentarionegocio` int(11) NOT NULL,
  `segmentoClientes` text,
  `propostaValor` text,
  `atividadesChaves` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentarioplanofinanceiro`
--

CREATE TABLE `comentarioplanofinanceiro` (
  `idcomentarioplanofinanceiro` int(11) NOT NULL,
  `fontesReceita` text,
  `estruturaCusto` text,
  `investimentoInicial` text,
  `custosfixos` text,
  `custosvariaveis` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentarioprodutoouservico`
--

CREATE TABLE `comentarioprodutoouservico` (
  `idcomentarioprodutoouservico` int(11) NOT NULL,
  `estagioEvolucao` varchar(300) DEFAULT NULL,
  `tecnologiaProcessos` text,
  `potencialInovacaoTecnologica` text,
  `aplicacoes` text,
  `dificuldadesEsperadas` text,
  `interacaoEmpresaUniversidade` text,
  `interacaoEmpresaComunidadeGoverno` text,
  `infraestrutura` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentarioprojeto`
--

CREATE TABLE `comentarioprojeto` (
  `idcomentario` int(11) NOT NULL,
  `nome` varchar(300) DEFAULT NULL,
  `participacaoacionaria` text,
  `potencialemprego` text,
  `consideracoes` text,
  `comentarioanaliseemprego_idcomentarioanaliseemprego` int(11) NOT NULL,
  `comentarioplanofinanceiro_idcomentarioplanofinanceiro` int(11) NOT NULL,
  `comentarioprodutoouservico_idcomentarioprodutoouservico` int(11) NOT NULL,
  `comentarionegocio_idcomentarionegocio` int(11) NOT NULL,
  `projeto_idProjeto` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `custo`
--

CREATE TABLE `custo` (
  `idcusto` int(11) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `planofinanceiro_idPlanoFinanceiro` int(11) NOT NULL,
  `projecao` int(11) DEFAULT NULL,
  `podeExcluir` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `custo`
--

INSERT INTO `custo` (`idcusto`, `descricao`, `total`, `tipo`, `planofinanceiro_idPlanoFinanceiro`, `projecao`, `podeExcluir`) VALUES
(1, 'Aluguel com o Pampatec', 45, 0, 31, 270, 0),
(2, 'Prolabore', 0, 0, 31, 0, 0),
(3, 'Internet', 0, 0, 31, 0, 1),
(4, 'Telefone', 0, 0, 31, 0, 1),
(5, 'Manutenção do Site', 0, 0, 31, 0, 1),
(6, 'Impostos', 0, 1, 31, 0, 1),
(7, 'Transporte', 0, 1, 31, 0, 1),
(8, 'Terceirizados para inspeção dos animais', 0, 1, 31, 0, 1),
(11, 'Telefône', 250, 0, 33, 1500, 0),
(12, 'Prolabore', 0, 0, 33, 0, 0),
(13, 'Internet', 100, 0, 33, 600, 1),
(14, 'Novo Custo', 0, 0, 33, 0, 1),
(15, 'Novo Custo', 0, 1, 33, 0, 1),
(16, 'Novo Custo', 0, 1, 33, 0, 1),
(17, 'Prolabore', 0, 0, 34, 0, 0),
(18, 'Aluguel com o Pampatec', 45, 0, 34, 270, 0),
(19, 'Novo Custo', 0, 0, 34, 0, 1),
(20, 'Novo Custo', 0, 0, 34, 0, 1),
(21, 'Novo Custo', 0, 0, 34, 0, 1),
(22, 'Novo Custo', 0, 0, 34, 0, 1),
(23, 'Novo Custo', 0, 1, 34, 0, 1),
(24, 'Novo Custo', 0, 1, 34, 0, 1),
(25, 'Novo Custo', 0, 1, 34, 0, 1),
(26, 'Prolabore', 0, 0, 35, 0, 0),
(27, 'Aluguel com o Pampatec', 45, 0, 35, 270, 0),
(28, 'Novo Custo', 0, 0, 35, 0, 1),
(29, 'Novo Custo', 0, 0, 35, 0, 1),
(30, 'Novo Custo', 0, 0, 35, 0, 1),
(31, 'Novo Custo', 0, 1, 35, 0, 1),
(32, 'Novo Custo', 0, 1, 35, 0, 1),
(33, 'Novo Custo', 0, 1, 35, 0, 1),
(34, 'Novo Custo', 0, 1, 35, 0, 1),
(35, 'Novo Custo', 0, 1, 35, 0, 1),
(36, 'Novo Custo', 0, 1, 35, 0, 1),
(37, 'Novo Custo', 0, 1, 35, 0, 1),
(38, 'Aluguel com o Pampatec', 45, 0, 36, 270, 0),
(39, 'Prolabore', 0, 0, 36, 0, 0),
(40, 'Novo Custo', 0, 0, 36, 0, 1),
(41, 'Novo Custo', 0, 0, 36, 0, 1),
(42, 'Novo Custo', 0, 0, 36, 0, 1),
(43, 'Novo Custo', 0, 0, 36, 0, 1),
(44, 'Novo Custo', 0, 0, 36, 0, 1),
(45, 'Novo Custo', 0, 0, 36, 0, 1),
(46, 'Novo Custo', 0, 1, 36, 0, 1),
(47, 'Novo Custo', 0, 1, 36, 0, 1),
(48, 'Novo Custo', 0, 1, 36, 0, 1),
(49, 'Novo Custo', 0, 1, 36, 0, 1),
(50, 'Novo Custo', 0, 1, 36, 0, 1),
(51, 'Prolabore', 0, 0, 37, 0, 0),
(52, 'Aluguel com o Pampatec', 45, 0, 37, 270, 0),
(53, 'Novo Custo', 0, 0, 37, 0, 1),
(54, 'Novo Custo', 0, 0, 37, 0, 1),
(55, 'Novo Custo', 0, 0, 37, 0, 1),
(56, 'Novo Custo', 0, 0, 37, 0, 1),
(57, 'Novo Custo', 0, 0, 37, 0, 1),
(58, 'Novo Custo', 0, 1, 37, 0, 1),
(59, 'Novo Custo', 0, 1, 37, 0, 1),
(60, 'Novo Custo', 0, 1, 37, 0, 1),
(61, 'Novo Custo', 0, 1, 37, 0, 1),
(71, 'Aluguel com o Pampatec', 45, 0, 39, 270, 0),
(72, 'Prolabore', 0, 0, 39, 0, 0),
(73, 'Novo Custo', 0, 0, 39, 0, 1),
(74, 'Novo Custo', 0, 0, 39, 0, 1),
(75, 'Novo Custo', 0, 0, 39, 0, 1),
(76, 'Novo Custo', 0, 0, 39, 0, 1),
(77, 'Novo Custo', 0, 0, 39, 0, 1),
(78, 'Novo Custo', 0, 1, 39, 0, 1),
(79, 'Novo Custo', 0, 1, 39, 0, 1),
(80, 'Novo Custo', 0, 1, 39, 0, 1),
(81, 'Novo Custo', 0, 1, 39, 0, 1),
(82, 'Novo Custo', 0, 1, 39, 0, 1),
(83, 'Novo Custo', 0, 1, 39, 0, 1),
(84, 'Aluguel com o Pampatec', 45, 0, 40, 270, 0),
(85, 'Prolabore', 0, 0, 40, 0, 0),
(86, 'Novo Custo', 0, 0, 40, 0, 1),
(87, 'Novo Custo', 0, 0, 40, 0, 1),
(88, 'Novo Custo', 0, 0, 40, 0, 1),
(89, 'Novo Custo', 0, 0, 40, 0, 1),
(90, 'Novo Custo', 0, 1, 40, 0, 1),
(91, 'Novo Custo', 0, 1, 40, 0, 1),
(92, 'Novo Custo', 0, 1, 40, 0, 1),
(93, 'Aluguel com o Pampatec', 45, 0, 41, 270, 0),
(94, 'Prolabore', 0, 0, 41, 0, 0),
(95, 'Novo Custo', 0, 0, 41, 0, 1),
(96, 'Novo Custo', 0, 0, 41, 0, 1),
(97, 'Novo Custo', 0, 0, 41, 0, 1),
(98, 'Novo Custo', 0, 0, 41, 0, 1),
(99, 'Novo Custo', 0, 1, 41, 0, 1),
(100, 'Novo Custo', 0, 1, 41, 0, 1),
(101, 'Novo Custo', 0, 1, 41, 0, 1),
(102, 'Novo Custo', 0, 1, 41, 0, 1),
(103, 'Aluguel com o Pampatec', 45, 0, 42, 270, 0),
(104, 'Prolabore', 0, 0, 42, 0, 0),
(105, 'Novo Custo', 0, 0, 42, 0, 1),
(106, 'Novo Custo', 0, 0, 42, 0, 1),
(107, 'Novo Custo', 0, 0, 42, 0, 1),
(108, 'Novo Custo', 0, 0, 42, 0, 1),
(109, 'Novo Custo', 0, 1, 42, 0, 1),
(110, 'Novo Custo', 0, 1, 42, 0, 1),
(111, 'Novo Custo', 0, 1, 42, 0, 1),
(112, 'Novo Custo', 0, 1, 42, 0, 1),
(113, 'Novo Custo', 0, 1, 42, 0, 1),
(114, 'Novo Custo', 0, 1, 42, 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `empreendedor`
--

CREATE TABLE `empreendedor` (
  `usuario_id_usuario` int(11) NOT NULL,
  `formacao` text,
  `experiencia` text,
  `bairro` varchar(100) DEFAULT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `idUnico` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `empreendedor`
--

INSERT INTO `empreendedor` (`usuario_id_usuario`, `formacao`, `experiencia`, `bairro`, `rua`, `numero`, `complemento`, `idUnico`) VALUES
(1, 'Graduando em Eng. Software na Universidade Federal do Pampa.', '', 'São Francisco', 'Avenida São Francisco', 4563, '', NULL),
(2, 'Graduado em Ciência da Computação pela Universidade de São Paulo (USP).', '', 'São Jorge', 'Avenida São Jorge', 2357, '', NULL),
(3, 'Graduada em Engenharia de Produção pela Universidade Federal do Rio Grande do Sul (UFRGS).', '', 'Nossa Senhora Aparecida', 'Avenida Nossa Senhora Aparecida', 7361, '', NULL),
(4, 'Doutora em Segurança da Informação pela Universidade da Califórnia - Irvine (UCI).', '', 'Santa Maria', 'Avenida Santa Maria', 5513, '', NULL),
(5, 'Graduada em Administração pela Universidade Federal do Pampa (Unipampa).', '', 'São Domingos', 'Avenida São Domingos', 1147, '', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `empreendedoremail`
--

CREATE TABLE `empreendedoremail` (
  `idEmpreendedorEmail` varchar(150) NOT NULL DEFAULT '',
  `tipo` varchar(45) DEFAULT NULL,
  `empreendedor_usuario_id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gerente_relacionamento`
--

CREATE TABLE `gerente_relacionamento` (
  `idgerente_relacionamento` int(11) NOT NULL,
  `senha` varchar(100) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cpf` mediumtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `gerente_relacionamento`
--

INSERT INTO `gerente_relacionamento` (`idgerente_relacionamento`, `senha`, `nome`, `email`, `cpf`) VALUES
(1, '202CB962AC59075B964B07152D234B70', 'Juliano M.', 'admin@email.com', '5532169874'),
(2, '202CB962AC59075B964B07152D234B70', 'Sarah S.', 'sarah.s@email.com', '25980198229'),
(3, '202CB962AC59075B964B07152D234B70', 'Vitor A.', 'vitor@gerente.com', '98486939550');

-- --------------------------------------------------------

--
-- Estrutura da tabela `negocio`
--

CREATE TABLE `negocio` (
  `idNegocio` int(11) NOT NULL,
  `segmentoClientes` text,
  `propostaValor` text,
  `atividadesChaves` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `negocio`
--

INSERT INTO `negocio` (`idNegocio`, `segmentoClientes`, `propostaValor`, `atividadesChaves`) VALUES
(31, 'Empresário rurais, formando grupos de produtores, clientes e fornecedores.', 'Agromural tem por objetivo principal a interação do empresário rural com clientes e fornecedores, permitindo ganhos de competitividades através da otimização de processos, redução de custos, oferecendo acesso das ofertas a novos produtores trafegadas em nosso portal.', 'AGROMURAL :  Comercio de produtos agropecuários em ambiente eletrônico permitindo ganhos de competitividades através da otimização de processos, redução de custos, oferecendo acesso de um grande numero de clientes, visando o BEM ESTAR ANIMAL a geração de receita e bons negócios de forma segura e transparente.'),
(33, 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.'),
(34, 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.'),
(35, 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.'),
(36, 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.'),
(37, 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.'),
(39, 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.'),
(40, 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.'),
(41, 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete'),
(42, 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `notificacao`
--

CREATE TABLE `notificacao` (
  `idnotificacao` int(11) NOT NULL,
  `descricao` varchar(450) DEFAULT NULL,
  `visualizado` tinyint(1) DEFAULT NULL,
  `link` varchar(100) DEFAULT NULL,
  `usuario_id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `planofinanceiro`
--

CREATE TABLE `planofinanceiro` (
  `idPlanoFinanceiro` int(11) NOT NULL,
  `fontesReceita` text,
  `estruturaCusto` text,
  `investimentoInicial` text,
  `valorTotalFixo` int(11) DEFAULT NULL,
  `valorTotalVariavel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `planofinanceiro`
--

INSERT INTO `planofinanceiro` (`idPlanoFinanceiro`, `fontesReceita`, `estruturaCusto`, `investimentoInicial`, `valorTotalFixo`, `valorTotalVariavel`) VALUES
(31, 'Atualmente o mercado funciona através de corretores autônomos que cobram 2% de cada parte ou leiloeiras que cobram 5% de cada parte. Visamos reduzir estes custos que serão fracionados para expositores, leilões virtuais, compra e venda garantida, e outras forma de acordo com a necessidade dos clientes.', 'Manutenção do site, criação dos aplicativos.', ' R$ 15.000,00', 270, 0),
(33, 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 2100, 0),
(34, 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.', 270, 0),
(35, 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.', 270, 0),
(36, 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 270, 0),
(37, 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 270, 0),
(39, 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 270, 0),
(40, 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.', 270, 0),
(41, 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 270, 0),
(42, 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 270, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtoouservico`
--

CREATE TABLE `produtoouservico` (
  `idProdutoOuServico` int(11) NOT NULL,
  `estagioEvolucao` varchar(300) DEFAULT NULL,
  `tecnologiaProcessos` text,
  `potencialInovacaoTecnologica` text,
  `aplicacoes` text,
  `dificuldadesEsperadas` text,
  `interacaoEmpresaUniversidade` text,
  `interacaoEmpresaComunidadeGoverno` text,
  `infraestrutura` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produtoouservico`
--

INSERT INTO `produtoouservico` (`idProdutoOuServico`, `estagioEvolucao`, `tecnologiaProcessos`, `potencialInovacaoTecnologica`, `aplicacoes`, `dificuldadesEsperadas`, `interacaoEmpresaUniversidade`, `interacaoEmpresaComunidadeGoverno`, `infraestrutura`) VALUES
(31, 'Em teste no mercado', 'Ambiente eletrônico, livre da circulação de animais em pé  “desnecessárias”  evitando aglomerações que favorecem ao contagio e/ou disseminação de enfermidades de toda ordem, salvaguardando o bem estar animal.', 'Soluções de alto valor agregado, reinventando assim o comércio entre empresários rurais.', 'Bovinos, ovinos, equinos, pequenos animais, grãos, insumos, maquinas e etc.', 'Acesso ao produtor rural que não domina os recursos tecnológicos.', 'Buscar nas mentes soluções que venham a quebrar estes paradigmas! Criação de aplicativos, soluções em marketing.', 'Soluções em cadeia uma vez que os produtores reduzem custos, com ênfase ao bem estar animal, acesso a insumos de melhor qualidade a preços justos, transparência no comercio livre de sonegadores. ', 'Ambiente proativo com ideias inovadoras.'),
(33, 'Clientes Pagando', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.', 'Plano de negócio - Touro.'),
(34, 'Projeto Básico', 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.', 'Plano de negócio - CA.'),
(35, 'Em teste no mercado', 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.', 'Plano de negócio - CT.'),
(36, 'Protótipo Desenvolvido', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.', 'Plano de negócio - ADD.'),
(37, 'Em teste no mercado', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.', 'Plano de Negócio - Confi.'),
(39, 'Clientes Pagando', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.', 'Plano de negócio - STJ.'),
(40, 'Em teste no mercado', 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.', 'Plano de negócio - Good.'),
(41, 'Clientes Pagando', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete', 'Plano de negócio - Do Alegrete'),
(42, 'Protótipo Desenvolvido', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.', 'Plano de negócio - Tcampo.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto`
--

CREATE TABLE `projeto` (
  `idProjeto` int(11) NOT NULL,
  `nome` varchar(300) DEFAULT NULL,
  `dataEnvio` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `potencialEmprego` text,
  `AnaliseEmprego_idAnaliseEmprego` int(11) DEFAULT NULL,
  `ProdutoOuServico_idProdutoOuServico` int(11) DEFAULT NULL,
  `Negocio_idNegocio` int(11) DEFAULT NULL,
  `PlanoFinanceiro_idPlanoFinanceiro` int(11) DEFAULT NULL,
  `participacaoacionaria` text,
  `edital` varchar(45) DEFAULT NULL,
  `dataCriacao` datetime DEFAULT NULL,
  `gerente_relacionamento_idgerente_relacionamento` int(11) DEFAULT NULL,
  `empreendedorCorrespondente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `projeto`
--

INSERT INTO `projeto` (`idProjeto`, `nome`, `dataEnvio`, `status`, `potencialEmprego`, `AnaliseEmprego_idAnaliseEmprego`, `ProdutoOuServico_idProdutoOuServico`, `Negocio_idNegocio`, `PlanoFinanceiro_idPlanoFinanceiro`, `participacaoacionaria`, `edital`, `dataCriacao`, `gerente_relacionamento_idgerente_relacionamento`, `empreendedorCorrespondente`) VALUES
(31, 'Agromural', '2016-04-01 11:32:18', 1, '25 anos no comercio de produtos agropecuários.', 4, 31, 31, 31, ' Advogado e produtor rural.', '2015abc123', '2016-04-01 11:18:30', NULL, 4),
(35, 'Touro - Investimentos em Agronegócio', '2016-04-01 11:55:52', 7, 'Plano de negócio - Touro.', 6, 33, 33, 33, 'Plano de negócio - Touro.', '2015abc123', '2016-04-01 11:53:28', NULL, 1),
(36, 'CA - Canecas e Acessórios', '2016-04-01 11:59:02', 6, 'Plano de negócio - CA.', 7, 34, 34, 34, 'Plano de negócio - CA.', '2015abc123', '2016-04-01 11:56:54', NULL, 3),
(37, 'CT - Comércio e Tecnologia assistida', '2016-04-01 12:00:52', 1, 'Plano de negócio - CT.', 8, 35, 35, 35, 'Plano de negócio - CT.', '2015abc123', '2016-04-01 11:59:37', NULL, 4),
(38, 'ADD - Assinatura Digital de Documentos', '2016-04-01 12:03:11', 7, 'Plano de negócio - ADD.', 9, 36, 36, 36, 'Plano de negócio - ADD.', '2015abc123', '2016-04-01 12:01:57', NULL, 5),
(39, 'Confi - Segurança e Privacidade', '2016-04-01 12:05:38', 1, 'Plano de Negócio - Confi.', 10, 37, 37, 37, 'Plano de Negócio - Confi.', '2015abc123', '2016-04-01 12:03:20', NULL, 5),
(41, 'STJ - Serviços Tecnológicos', '2016-04-01 12:09:01', 1, 'Plano de negócio - STJ.', 12, 39, 39, 39, 'Plano de negócio - STJ.', '2015abc123', '2016-04-01 12:07:09', NULL, 2),
(42, 'Good - Serviços Alimentícios', '2016-04-01 12:11:41', 6, 'Plano de negócio - Good.', 13, 40, 40, 40, 'Plano de negócio - Good.', '2015abc123', '2016-04-01 12:10:03', NULL, 1),
(43, 'Do Alegrete - Erva Mate', '2016-04-01 12:15:26', 7, 'Plano de negócio - Do Alegrete', 14, 41, 41, 41, 'Plano de negócio - Do Alegrete', '2015abc123', '2016-04-01 12:12:41', NULL, 2),
(44, 'TCampo - Tecnologia para o Campo', '2016-04-01 12:18:08', 2, 'Plano de negócio - Tcampo.', 15, 42, 42, 42, 'Plano de negócio - Tcampo.', '2015abc123', '2016-04-01 12:16:11', NULL, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto_has_empreendedor`
--

CREATE TABLE `projeto_has_empreendedor` (
  `Projeto_idProjeto` int(11) NOT NULL,
  `empreendedor_usuario_id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `projeto_has_empreendedor`
--

INSERT INTO `projeto_has_empreendedor` (`Projeto_idProjeto`, `empreendedor_usuario_id_usuario`) VALUES
(31, 2),
(31, 4),
(35, 1),
(36, 3),
(37, 4),
(38, 5),
(39, 5),
(41, 2),
(42, 1),
(43, 2),
(44, 2),
(44, 3),
(44, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cpf` mediumtext,
  `nome` varchar(100) DEFAULT NULL,
  `telefone` mediumtext,
  `senha` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `email`, `cpf`, `nome`, `telefone`, `senha`) VALUES
(1, 'juliano.m@email.com', '56320932201', 'Juliano M.', '6499887755', '202CB962AC59075B964B07152D234B70'),
(2, 'christopher.a@email.com', '45975442834', 'Christopher A.', '3454678901', '202CB962AC59075B964B07152D234B70'),
(3, 'alessandra.c@email.com', '21171644981', 'Alessandra C.', '1145693257', '202CB962AC59075B964B07152D234B70'),
(4, 'marcelat@email.com', '02167753101', 'Marcela T.', '5584759235', '202CB962AC59075B964B07152D234B70'),
(5, 'fernandas@email.com', '98757331138', 'Fernanda S.', '5584736259', '202CB962AC59075B964B07152D234B70');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `analiseemprego`
--
ALTER TABLE `analiseemprego`
  ADD PRIMARY KEY (`idAnaliseEmprego`);

--
-- Indexes for table `comentarioanaliseemprego`
--
ALTER TABLE `comentarioanaliseemprego`
  ADD PRIMARY KEY (`idcomentarioanaliseemprego`);

--
-- Indexes for table `comentarionegocio`
--
ALTER TABLE `comentarionegocio`
  ADD PRIMARY KEY (`idcomentarionegocio`);

--
-- Indexes for table `comentarioplanofinanceiro`
--
ALTER TABLE `comentarioplanofinanceiro`
  ADD PRIMARY KEY (`idcomentarioplanofinanceiro`);

--
-- Indexes for table `comentarioprodutoouservico`
--
ALTER TABLE `comentarioprodutoouservico`
  ADD PRIMARY KEY (`idcomentarioprodutoouservico`);

--
-- Indexes for table `comentarioprojeto`
--
ALTER TABLE `comentarioprojeto`
  ADD PRIMARY KEY (`idcomentario`),
  ADD KEY `fk_comentarioprojeto_comentarioanaliseemprego1_idx` (`comentarioanaliseemprego_idcomentarioanaliseemprego`),
  ADD KEY `fk_comentarioprojeto_comentarioplanofinanceiro1_idx` (`comentarioplanofinanceiro_idcomentarioplanofinanceiro`),
  ADD KEY `fk_comentarioprojeto_comentarioprodutoouservico1_idx` (`comentarioprodutoouservico_idcomentarioprodutoouservico`),
  ADD KEY `fk_comentarioprojeto_comentarionegocio1_idx` (`comentarionegocio_idcomentarionegocio`),
  ADD KEY `fk_comentarioprojeto_projeto1_idx` (`projeto_idProjeto`);

--
-- Indexes for table `custo`
--
ALTER TABLE `custo`
  ADD PRIMARY KEY (`idcusto`),
  ADD KEY `fk_custo_planofinanceiro1_idx` (`planofinanceiro_idPlanoFinanceiro`);

--
-- Indexes for table `empreendedor`
--
ALTER TABLE `empreendedor`
  ADD PRIMARY KEY (`usuario_id_usuario`),
  ADD KEY `fk_empreendedor_usuario1_idx` (`usuario_id_usuario`);

--
-- Indexes for table `empreendedoremail`
--
ALTER TABLE `empreendedoremail`
  ADD PRIMARY KEY (`idEmpreendedorEmail`),
  ADD KEY `fk_empreendedoremail_empreendedor1_idx` (`empreendedor_usuario_id_usuario`);

--
-- Indexes for table `gerente_relacionamento`
--
ALTER TABLE `gerente_relacionamento`
  ADD PRIMARY KEY (`idgerente_relacionamento`);

--
-- Indexes for table `negocio`
--
ALTER TABLE `negocio`
  ADD PRIMARY KEY (`idNegocio`);

--
-- Indexes for table `notificacao`
--
ALTER TABLE `notificacao`
  ADD PRIMARY KEY (`idnotificacao`),
  ADD KEY `fk_notificacao_usuario1_idx` (`usuario_id_usuario`);

--
-- Indexes for table `planofinanceiro`
--
ALTER TABLE `planofinanceiro`
  ADD PRIMARY KEY (`idPlanoFinanceiro`);

--
-- Indexes for table `produtoouservico`
--
ALTER TABLE `produtoouservico`
  ADD PRIMARY KEY (`idProdutoOuServico`);

--
-- Indexes for table `projeto`
--
ALTER TABLE `projeto`
  ADD PRIMARY KEY (`idProjeto`),
  ADD KEY `fk_Projeto_AnaliseEmprego1_idx` (`AnaliseEmprego_idAnaliseEmprego`),
  ADD KEY `fk_Projeto_ProdutoOuServico1_idx` (`ProdutoOuServico_idProdutoOuServico`),
  ADD KEY `fk_Projeto_Negocio1_idx` (`Negocio_idNegocio`),
  ADD KEY `fk_Projeto_PlanoFinanceiro1_idx` (`PlanoFinanceiro_idPlanoFinanceiro`),
  ADD KEY `fk_projeto_gerente_relacionamento1_idx` (`gerente_relacionamento_idgerente_relacionamento`),
  ADD KEY `fk_projeto_empreendedor1_idx` (`empreendedorCorrespondente`);

--
-- Indexes for table `projeto_has_empreendedor`
--
ALTER TABLE `projeto_has_empreendedor`
  ADD PRIMARY KEY (`Projeto_idProjeto`,`empreendedor_usuario_id_usuario`),
  ADD KEY `fk_Projeto_has_Empreendedor_Projeto1_idx` (`Projeto_idProjeto`),
  ADD KEY `fk_projeto_has_empreendedor_empreendedor1_idx` (`empreendedor_usuario_id_usuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `analiseemprego`
--
ALTER TABLE `analiseemprego`
  MODIFY `idAnaliseEmprego` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `comentarioanaliseemprego`
--
ALTER TABLE `comentarioanaliseemprego`
  MODIFY `idcomentarioanaliseemprego` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comentarionegocio`
--
ALTER TABLE `comentarionegocio`
  MODIFY `idcomentarionegocio` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comentarioplanofinanceiro`
--
ALTER TABLE `comentarioplanofinanceiro`
  MODIFY `idcomentarioplanofinanceiro` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comentarioprodutoouservico`
--
ALTER TABLE `comentarioprodutoouservico`
  MODIFY `idcomentarioprodutoouservico` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comentarioprojeto`
--
ALTER TABLE `comentarioprojeto`
  MODIFY `idcomentario` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `custo`
--
ALTER TABLE `custo`
  MODIFY `idcusto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;
--
-- AUTO_INCREMENT for table `gerente_relacionamento`
--
ALTER TABLE `gerente_relacionamento`
  MODIFY `idgerente_relacionamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `negocio`
--
ALTER TABLE `negocio`
  MODIFY `idNegocio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `notificacao`
--
ALTER TABLE `notificacao`
  MODIFY `idnotificacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `planofinanceiro`
--
ALTER TABLE `planofinanceiro`
  MODIFY `idPlanoFinanceiro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `produtoouservico`
--
ALTER TABLE `produtoouservico`
  MODIFY `idProdutoOuServico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `projeto`
--
ALTER TABLE `projeto`
  MODIFY `idProjeto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `comentarioprojeto`
--
ALTER TABLE `comentarioprojeto`
  ADD CONSTRAINT `fk_comentarioprojeto_comentarioanaliseemprego1` FOREIGN KEY (`comentarioanaliseemprego_idcomentarioanaliseemprego`) REFERENCES `comentarioanaliseemprego` (`idcomentarioanaliseemprego`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_comentarioprojeto_comentarionegocio1` FOREIGN KEY (`comentarionegocio_idcomentarionegocio`) REFERENCES `comentarionegocio` (`idcomentarionegocio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_comentarioprojeto_comentarioplanofinanceiro1` FOREIGN KEY (`comentarioplanofinanceiro_idcomentarioplanofinanceiro`) REFERENCES `comentarioplanofinanceiro` (`idcomentarioplanofinanceiro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_comentarioprojeto_comentarioprodutoouservico1` FOREIGN KEY (`comentarioprodutoouservico_idcomentarioprodutoouservico`) REFERENCES `comentarioprodutoouservico` (`idcomentarioprodutoouservico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_comentarioprojeto_projeto1` FOREIGN KEY (`projeto_idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `custo`
--
ALTER TABLE `custo`
  ADD CONSTRAINT `fk_custo_planofinanceiro1` FOREIGN KEY (`planofinanceiro_idPlanoFinanceiro`) REFERENCES `planofinanceiro` (`idPlanoFinanceiro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `empreendedor`
--
ALTER TABLE `empreendedor`
  ADD CONSTRAINT `fk_empreendedor_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `empreendedoremail`
--
ALTER TABLE `empreendedoremail`
  ADD CONSTRAINT `fk_empreendedoremail_empreendedor1` FOREIGN KEY (`empreendedor_usuario_id_usuario`) REFERENCES `empreendedor` (`usuario_id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `notificacao`
--
ALTER TABLE `notificacao`
  ADD CONSTRAINT `fk_notificacao_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `projeto`
--
ALTER TABLE `projeto`
  ADD CONSTRAINT `fk_Projeto_AnaliseEmprego1` FOREIGN KEY (`AnaliseEmprego_idAnaliseEmprego`) REFERENCES `analiseemprego` (`idAnaliseEmprego`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Projeto_Negocio1` FOREIGN KEY (`Negocio_idNegocio`) REFERENCES `negocio` (`idNegocio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Projeto_PlanoFinanceiro1` FOREIGN KEY (`PlanoFinanceiro_idPlanoFinanceiro`) REFERENCES `planofinanceiro` (`idPlanoFinanceiro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Projeto_ProdutoOuServico1` FOREIGN KEY (`ProdutoOuServico_idProdutoOuServico`) REFERENCES `produtoouservico` (`idProdutoOuServico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_projeto_empreendedor1` FOREIGN KEY (`empreendedorCorrespondente`) REFERENCES `empreendedor` (`usuario_id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_projeto_gerente_relacionamento1` FOREIGN KEY (`gerente_relacionamento_idgerente_relacionamento`) REFERENCES `gerente_relacionamento` (`idgerente_relacionamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `projeto_has_empreendedor`
--
ALTER TABLE `projeto_has_empreendedor`
  ADD CONSTRAINT `fk_Projeto_has_Empreendedor_Projeto1` FOREIGN KEY (`Projeto_idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_projeto_has_empreendedor_empreendedor1` FOREIGN KEY (`empreendedor_usuario_id_usuario`) REFERENCES `empreendedor` (`usuario_id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
