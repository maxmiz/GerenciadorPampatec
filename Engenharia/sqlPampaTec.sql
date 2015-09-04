CREATE DATABASE  IF NOT EXISTS `gerenciadorpampatec` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gerenciadorpampatec`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: gerenciadorpampatec
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `analiseemprego`
--

DROP TABLE IF EXISTS `analiseemprego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `analiseemprego` (
  `idAnaliseEmprego` int(11) NOT NULL,
  `relacoesClientes` varchar(300) DEFAULT NULL,
  `parceriasChaves` varchar(300) DEFAULT NULL,
  `canais` varchar(300) DEFAULT NULL,
  `recursosPrincipais` varchar(300) DEFAULT NULL,
  `concorrentes` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idAnaliseEmprego`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analiseemprego`
--

LOCK TABLES `analiseemprego` WRITE;
/*!40000 ALTER TABLE `analiseemprego` DISABLE KEYS */;
/*!40000 ALTER TABLE `analiseemprego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custo`
--

DROP TABLE IF EXISTS `custo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `custo` (
  `idcusto` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `valor` float NOT NULL,
  `PlanoFinanceiro_idPlanoFinanceiro` int(11) NOT NULL,
  PRIMARY KEY (`idcusto`),
  KEY `fk_custo_PlanoFinanceiro1_idx` (`PlanoFinanceiro_idPlanoFinanceiro`),
  CONSTRAINT `fk_custo_PlanoFinanceiro1` FOREIGN KEY (`PlanoFinanceiro_idPlanoFinanceiro`) REFERENCES `planofinanceiro` (`idPlanoFinanceiro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custo`
--

LOCK TABLES `custo` WRITE;
/*!40000 ALTER TABLE `custo` DISABLE KEYS */;
/*!40000 ALTER TABLE `custo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empreendedor`
--

DROP TABLE IF EXISTS `empreendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empreendedor` (
  `idEmpreendedor` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `telefone` mediumtext,
  `cpf` mediumtext NOT NULL,
  `email` varchar(45) NOT NULL,
  `formacao` varchar(300) NOT NULL,
  `experiencia` varchar(300) DEFAULT NULL,
  `competencia` varchar(300) DEFAULT NULL,
  `participacaoAcionaria` varchar(300) DEFAULT NULL,
  `Endereco_idEndereco` int(11) NOT NULL,
  PRIMARY KEY (`idEmpreendedor`),
  KEY `fk_Empreendedor_Endereco_idx` (`Endereco_idEndereco`),
  CONSTRAINT `fk_Empreendedor_Endereco` FOREIGN KEY (`Endereco_idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empreendedor`
--

LOCK TABLES `empreendedor` WRITE;
/*!40000 ALTER TABLE `empreendedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `empreendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `negocio`
--

DROP TABLE IF EXISTS `negocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `negocio` (
  `idNegocio` int(11) NOT NULL,
  `segmentoClientes` varchar(300) NOT NULL,
  `PropostaValor` varchar(300) NOT NULL,
  `AtividadesChaves` varchar(300) NOT NULL,
  PRIMARY KEY (`idNegocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `negocio`
--

LOCK TABLES `negocio` WRITE;
/*!40000 ALTER TABLE `negocio` DISABLE KEYS */;
/*!40000 ALTER TABLE `negocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planofinanceiro`
--

DROP TABLE IF EXISTS `planofinanceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planofinanceiro` (
  `idPlanoFinanceiro` int(11) NOT NULL,
  `fontesReceita` varchar(300) NOT NULL,
  `estruturaCusto` varchar(300) NOT NULL,
  `investimentoInicial` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idPlanoFinanceiro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planofinanceiro`
--

LOCK TABLES `planofinanceiro` WRITE;
/*!40000 ALTER TABLE `planofinanceiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `planofinanceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtoouservico`
--

DROP TABLE IF EXISTS `produtoouservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtoouservico` (
  `idProdutoOuServico` int(11) NOT NULL,
  `estagioEvolucao` varchar(45) NOT NULL,
  `tecnologiaProcessos` varchar(300) DEFAULT NULL,
  `potencialInovacaoTecnologica` varchar(300) DEFAULT NULL,
  `aplicacoes` varchar(300) DEFAULT NULL,
  `dificuldadesEsperadas` varchar(300) DEFAULT NULL,
  `interacaoEmpresaUniversidade` varchar(300) DEFAULT NULL,
  `interacaoEmpresaComunidadeGoverno` varchar(300) DEFAULT NULL,
  `infraestrutura` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idProdutoOuServico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtoouservico`
--

LOCK TABLES `produtoouservico` WRITE;
/*!40000 ALTER TABLE `produtoouservico` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtoouservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto` (
  `idProjeto` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `dataEnvio` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `potencialEmprego` varchar(45) DEFAULT NULL,
  `AnaliseEmprego_idAnaliseEmprego` int(11) NOT NULL,
  `ProdutoOuServico_idProdutoOuServico` int(11) NOT NULL,
  `Negocio_idNegocio` int(11) NOT NULL,
  `PlanoFinanceiro_idPlanoFinanceiro` int(11) NOT NULL,
  PRIMARY KEY (`idProjeto`),
  KEY `fk_Projeto_AnaliseEmprego1_idx` (`AnaliseEmprego_idAnaliseEmprego`),
  KEY `fk_Projeto_ProdutoOuServico1_idx` (`ProdutoOuServico_idProdutoOuServico`),
  KEY `fk_Projeto_Negocio1_idx` (`Negocio_idNegocio`),
  KEY `fk_Projeto_PlanoFinanceiro1_idx` (`PlanoFinanceiro_idPlanoFinanceiro`),
  CONSTRAINT `fk_Projeto_AnaliseEmprego1` FOREIGN KEY (`AnaliseEmprego_idAnaliseEmprego`) REFERENCES `analiseemprego` (`idAnaliseEmprego`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_Negocio1` FOREIGN KEY (`Negocio_idNegocio`) REFERENCES `negocio` (`idNegocio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_PlanoFinanceiro1` FOREIGN KEY (`PlanoFinanceiro_idPlanoFinanceiro`) REFERENCES `planofinanceiro` (`idPlanoFinanceiro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_ProdutoOuServico1` FOREIGN KEY (`ProdutoOuServico_idProdutoOuServico`) REFERENCES `produtoouservico` (`idProdutoOuServico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto`
--

LOCK TABLES `projeto` WRITE;
/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto_has_empreendedor`
--

DROP TABLE IF EXISTS `projeto_has_empreendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto_has_empreendedor` (
  `Projeto_idProjeto` int(11) NOT NULL,
  `Empreendedor_idEmpreendedor` int(11) NOT NULL,
  PRIMARY KEY (`Projeto_idProjeto`,`Empreendedor_idEmpreendedor`),
  KEY `fk_Projeto_has_Empreendedor_Empreendedor1_idx` (`Empreendedor_idEmpreendedor`),
  KEY `fk_Projeto_has_Empreendedor_Projeto1_idx` (`Projeto_idProjeto`),
  CONSTRAINT `fk_Projeto_has_Empreendedor_Empreendedor1` FOREIGN KEY (`Empreendedor_idEmpreendedor`) REFERENCES `empreendedor` (`idEmpreendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_has_Empreendedor_Projeto1` FOREIGN KEY (`Projeto_idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto_has_empreendedor`
--

LOCK TABLES `projeto_has_empreendedor` WRITE;
/*!40000 ALTER TABLE `projeto_has_empreendedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto_has_empreendedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-03 15:32:09
