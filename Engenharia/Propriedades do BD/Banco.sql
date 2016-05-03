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
-- Table structure for table `comentarioanaliseemprego`
--

DROP TABLE IF EXISTS `comentarioanaliseemprego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentarioanaliseemprego` (
  `idcomentarioanaliseemprego` int(11) NOT NULL AUTO_INCREMENT,
  `relacoesClientes` text,
  `parceriasChaves` text,
  `canais` text,
  `recursosPrincipais` text,
  `concorrentes` text,
  PRIMARY KEY (`idcomentarioanaliseemprego`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarioanaliseemprego`
--

LOCK TABLES `comentarioanaliseemprego` WRITE;
/*!40000 ALTER TABLE `comentarioanaliseemprego` DISABLE KEYS */;
INSERT INTO `comentarioanaliseemprego` VALUES (1,'','','','',''),(2,'','','','',''),(3,'','','','',''),(4,'','','','',''),(5,'Comentário Plano 2','','','',''),(6,'Comentário Plano 2','','','',''),(7,'','','','',''),(8,'','','','','');
/*!40000 ALTER TABLE `comentarioanaliseemprego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto_has_empreendedor`
--

DROP TABLE IF EXISTS `projeto_has_empreendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto_has_empreendedor` (
  `Projeto_idProjeto` int(11) NOT NULL,
  `empreendedor_usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`Projeto_idProjeto`,`empreendedor_usuario_id_usuario`),
  KEY `fk_Projeto_has_Empreendedor_Projeto1_idx` (`Projeto_idProjeto`),
  KEY `fk_projeto_has_empreendedor_empreendedor1_idx` (`empreendedor_usuario_id_usuario`),
  CONSTRAINT `fk_Projeto_has_Empreendedor_Projeto1` FOREIGN KEY (`Projeto_idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_has_empreendedor_empreendedor1` FOREIGN KEY (`empreendedor_usuario_id_usuario`) REFERENCES `empreendedor` (`usuario_id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto_has_empreendedor`
--

LOCK TABLES `projeto_has_empreendedor` WRITE;
/*!40000 ALTER TABLE `projeto_has_empreendedor` DISABLE KEYS */;
INSERT INTO `projeto_has_empreendedor` VALUES (31,1),(32,1),(32,2);
/*!40000 ALTER TABLE `projeto_has_empreendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarioprodutoouservico`
--

DROP TABLE IF EXISTS `comentarioprodutoouservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentarioprodutoouservico` (
  `idcomentarioprodutoouservico` int(11) NOT NULL AUTO_INCREMENT,
  `estagioEvolucao` varchar(300) DEFAULT NULL,
  `tecnologiaProcessos` text,
  `potencialInovacaoTecnologica` text,
  `aplicacoes` text,
  `dificuldadesEsperadas` text,
  `interacaoEmpresaUniversidade` text,
  `interacaoEmpresaComunidadeGoverno` text,
  `infraestrutura` text,
  PRIMARY KEY (`idcomentarioprodutoouservico`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarioprodutoouservico`
--

LOCK TABLES `comentarioprodutoouservico` WRITE;
/*!40000 ALTER TABLE `comentarioprodutoouservico` DISABLE KEYS */;
INSERT INTO `comentarioprodutoouservico` VALUES (1,'','','','','','','',''),(2,'','','','','','','',''),(3,'','','','','','','',''),(4,'','','','','','','',''),(5,'','','','','','','',''),(6,'','','','','','','',''),(7,'','','','','','','',''),(8,'','','','','','','','');
/*!40000 ALTER TABLE `comentarioprodutoouservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planofinanceiro`
--

DROP TABLE IF EXISTS `planofinanceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planofinanceiro` (
  `idPlanoFinanceiro` int(11) NOT NULL AUTO_INCREMENT,
  `fontesReceita` text,
  `estruturaCusto` text,
  `investimentoInicial` text,
  `valorTotalFixo` int(11) DEFAULT NULL,
  `valorTotalVariavel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPlanoFinanceiro`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planofinanceiro`
--

LOCK TABLES `planofinanceiro` WRITE;
/*!40000 ALTER TABLE `planofinanceiro` DISABLE KEYS */;
INSERT INTO `planofinanceiro` VALUES (31,'dasdasdsa','dasdasad','asdasdsadas',300,0),(32,'dsadsad','asdasdsa','dsadsadsadsadsa',270,0);
/*!40000 ALTER TABLE `planofinanceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarioprojeto`
--

DROP TABLE IF EXISTS `comentarioprojeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentarioprojeto` (
  `idcomentario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(300) DEFAULT NULL,
  `participacaoacionaria` text,
  `potencialemprego` text,
  `consideracoes` text,
  `comentarioanaliseemprego_idcomentarioanaliseemprego` int(11) NOT NULL,
  `comentarioplanofinanceiro_idcomentarioplanofinanceiro` int(11) NOT NULL,
  `comentarioprodutoouservico_idcomentarioprodutoouservico` int(11) NOT NULL,
  `comentarionegocio_idcomentarionegocio` int(11) NOT NULL,
  `projeto_idProjeto` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcomentario`),
  KEY `fk_comentarioprojeto_comentarioanaliseemprego1_idx` (`comentarioanaliseemprego_idcomentarioanaliseemprego`),
  KEY `fk_comentarioprojeto_comentarioplanofinanceiro1_idx` (`comentarioplanofinanceiro_idcomentarioplanofinanceiro`),
  KEY `fk_comentarioprojeto_comentarioprodutoouservico1_idx` (`comentarioprodutoouservico_idcomentarioprodutoouservico`),
  KEY `fk_comentarioprojeto_comentarionegocio1_idx` (`comentarionegocio_idcomentarionegocio`),
  KEY `fk_comentarioprojeto_projeto1_idx` (`projeto_idProjeto`),
  CONSTRAINT `fk_comentarioprojeto_comentarioanaliseemprego1` FOREIGN KEY (`comentarioanaliseemprego_idcomentarioanaliseemprego`) REFERENCES `comentarioanaliseemprego` (`idcomentarioanaliseemprego`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentarioprojeto_comentarionegocio1` FOREIGN KEY (`comentarionegocio_idcomentarionegocio`) REFERENCES `comentarionegocio` (`idcomentarionegocio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentarioprojeto_comentarioplanofinanceiro1` FOREIGN KEY (`comentarioplanofinanceiro_idcomentarioplanofinanceiro`) REFERENCES `comentarioplanofinanceiro` (`idcomentarioplanofinanceiro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentarioprojeto_comentarioprodutoouservico1` FOREIGN KEY (`comentarioprodutoouservico_idcomentarioprodutoouservico`) REFERENCES `comentarioprodutoouservico` (`idcomentarioprodutoouservico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentarioprojeto_projeto1` FOREIGN KEY (`projeto_idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarioprojeto`
--

LOCK TABLES `comentarioprojeto` WRITE;
/*!40000 ALTER TABLE `comentarioprojeto` DISABLE KEYS */;
INSERT INTO `comentarioprojeto` VALUES (13,'','','','',5,5,5,5,32,1),(14,'','','','',4,4,4,4,32,1),(15,'','Comentário Plano 2','','',6,6,6,6,32,1),(16,'','','','',3,3,3,3,32,1),(17,'','','','',5,5,5,5,32,1),(18,'','Comentário Plano 2','','',6,6,6,6,32,1),(19,'','','','',4,4,4,4,32,1),(20,'','','','',3,3,3,3,32,1),(21,'','','','',7,7,7,7,31,1),(22,'','','','',8,8,8,8,31,1);
/*!40000 ALTER TABLE `comentarioprojeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarioplanofinanceiro`
--

DROP TABLE IF EXISTS `comentarioplanofinanceiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentarioplanofinanceiro` (
  `idcomentarioplanofinanceiro` int(11) NOT NULL AUTO_INCREMENT,
  `fontesReceita` text,
  `estruturaCusto` text,
  `investimentoInicial` text,
  `custosfixos` text,
  `custosvariaveis` text,
  PRIMARY KEY (`idcomentarioplanofinanceiro`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarioplanofinanceiro`
--

LOCK TABLES `comentarioplanofinanceiro` WRITE;
/*!40000 ALTER TABLE `comentarioplanofinanceiro` DISABLE KEYS */;
INSERT INTO `comentarioplanofinanceiro` VALUES (1,'','','','',''),(2,'','','','',''),(3,'','','','',''),(4,'','','','',''),(5,'','','','',''),(6,'','','','',''),(7,'','','','',''),(8,'','','','','');
/*!40000 ALTER TABLE `comentarioplanofinanceiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empreendedoremail`
--

DROP TABLE IF EXISTS `empreendedoremail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empreendedoremail` (
  `idEmpreendedorEmail` varchar(150) NOT NULL DEFAULT '',
  `tipo` varchar(45) DEFAULT NULL,
  `empreendedor_usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`idEmpreendedorEmail`),
  KEY `fk_empreendedoremail_empreendedor1_idx` (`empreendedor_usuario_id_usuario`),
  CONSTRAINT `fk_empreendedoremail_empreendedor1` FOREIGN KEY (`empreendedor_usuario_id_usuario`) REFERENCES `empreendedor` (`usuario_id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empreendedoremail`
--

LOCK TABLES `empreendedoremail` WRITE;
/*!40000 ALTER TABLE `empreendedoremail` DISABLE KEYS */;
/*!40000 ALTER TABLE `empreendedoremail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gerente_relacionamento`
--

DROP TABLE IF EXISTS `gerente_relacionamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gerente_relacionamento` (
  `idgerente_relacionamento` int(11) NOT NULL AUTO_INCREMENT,
  `senha` varchar(100) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cpf` mediumtext,
  PRIMARY KEY (`idgerente_relacionamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gerente_relacionamento`
--

LOCK TABLES `gerente_relacionamento` WRITE;
/*!40000 ALTER TABLE `gerente_relacionamento` DISABLE KEYS */;
INSERT INTO `gerente_relacionamento` VALUES (1,'202CB962AC59075B964B07152D234B70','Gerente Pedro','gerente@gerente.com','111111111111'),(2,'202CB962AC59075B964B07152D234B70','Gerente 2','gerente@hotmail.com','1111111111111111111111111111111111111111111111111'),(3,'202CB962AC59075B964B07152D234B70','Gerente 3','gerente2@gerente.com','1111111111');
/*!40000 ALTER TABLE `gerente_relacionamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `negocio`
--

DROP TABLE IF EXISTS `negocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `negocio` (
  `idNegocio` int(11) NOT NULL AUTO_INCREMENT,
  `segmentoClientes` text,
  `propostaValor` text,
  `atividadesChaves` text,
  PRIMARY KEY (`idNegocio`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `negocio`
--

LOCK TABLES `negocio` WRITE;
/*!40000 ALTER TABLE `negocio` DISABLE KEYS */;
INSERT INTO `negocio` VALUES (31,'dsadas','dasdasdas','dsadasdas'),(32,'dsadasdas','dsadsadsa','dsadsadas');
/*!40000 ALTER TABLE `negocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `cpf` mediumtext,
  `nome` varchar(100) DEFAULT NULL,
  `telefone` mediumtext,
  `senha` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'dsadsadas@dsadsa.com','11771923652','Pedro','1111111111','202CB962AC59075B964B07152D234B70'),(2,'peu06@hotmail.com','63443697011','Pedro 22','1111111111','202CB962AC59075B964B07152D234B70');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarionegocio`
--

DROP TABLE IF EXISTS `comentarionegocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentarionegocio` (
  `idcomentarionegocio` int(11) NOT NULL AUTO_INCREMENT,
  `segmentoClientes` text,
  `propostaValor` text,
  `atividadesChaves` text,
  PRIMARY KEY (`idcomentarionegocio`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarionegocio`
--

LOCK TABLES `comentarionegocio` WRITE;
/*!40000 ALTER TABLE `comentarionegocio` DISABLE KEYS */;
INSERT INTO `comentarionegocio` VALUES (1,'','',''),(2,'Comentário Plano 3','Comentário Plano 1','Comentário Plano 1'),(3,'Plano2','',''),(4,'Comentário Plano 5','',''),(5,'Comentário Plano 2','',''),(6,'Comentário Plano 2dsadasdasdas','',''),(7,'','',''),(8,'','','');
/*!40000 ALTER TABLE `comentarionegocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custo`
--

DROP TABLE IF EXISTS `custo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `custo` (
  `idcusto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `planofinanceiro_idPlanoFinanceiro` int(11) NOT NULL,
  `projecao` int(11) DEFAULT NULL,
  `podeExcluir` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idcusto`),
  KEY `fk_custo_planofinanceiro1_idx` (`planofinanceiro_idPlanoFinanceiro`),
  CONSTRAINT `fk_custo_planofinanceiro1` FOREIGN KEY (`planofinanceiro_idPlanoFinanceiro`) REFERENCES `planofinanceiro` (`idPlanoFinanceiro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custo`
--

LOCK TABLES `custo` WRITE;
/*!40000 ALTER TABLE `custo` DISABLE KEYS */;
INSERT INTO `custo` VALUES (1,'Aluguel com o Pampatec',50,0,31,300,0),(2,'Prolabore',0,0,31,0,0),(3,'Aluguel com o Pampatec',45,0,32,270,0),(4,'Prolabore',0,0,32,0,0);
/*!40000 ALTER TABLE `custo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto` (
  `idProjeto` int(11) NOT NULL AUTO_INCREMENT,
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
  `empreendedorCorrespondente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProjeto`),
  KEY `fk_Projeto_AnaliseEmprego1_idx` (`AnaliseEmprego_idAnaliseEmprego`),
  KEY `fk_Projeto_ProdutoOuServico1_idx` (`ProdutoOuServico_idProdutoOuServico`),
  KEY `fk_Projeto_Negocio1_idx` (`Negocio_idNegocio`),
  KEY `fk_Projeto_PlanoFinanceiro1_idx` (`PlanoFinanceiro_idPlanoFinanceiro`),
  KEY `fk_projeto_gerente_relacionamento1_idx` (`gerente_relacionamento_idgerente_relacionamento`),
  KEY `fk_projeto_empreendedor1_idx` (`empreendedorCorrespondente`),
  CONSTRAINT `fk_Projeto_AnaliseEmprego1` FOREIGN KEY (`AnaliseEmprego_idAnaliseEmprego`) REFERENCES `analiseemprego` (`idAnaliseEmprego`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_Negocio1` FOREIGN KEY (`Negocio_idNegocio`) REFERENCES `negocio` (`idNegocio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_PlanoFinanceiro1` FOREIGN KEY (`PlanoFinanceiro_idPlanoFinanceiro`) REFERENCES `planofinanceiro` (`idPlanoFinanceiro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_ProdutoOuServico1` FOREIGN KEY (`ProdutoOuServico_idProdutoOuServico`) REFERENCES `produtoouservico` (`idProdutoOuServico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_empreendedor1` FOREIGN KEY (`empreendedorCorrespondente`) REFERENCES `empreendedor` (`usuario_id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_gerente_relacionamento1` FOREIGN KEY (`gerente_relacionamento_idgerente_relacionamento`) REFERENCES `gerente_relacionamento` (`idgerente_relacionamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto`
--

LOCK TABLES `projeto` WRITE;
/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
INSERT INTO `projeto` VALUES (31,'Novo Plano','2016-03-21 17:40:30',1,'dasdasdas',4,31,31,31,'dasdsadas','2015abc123','2016-03-21 17:39:12',NULL,1),(32,'Plano Teste Comentário','2016-03-23 09:06:51',1,'dsadsadas',5,32,32,32,'dsadsadsa','2015abc123','2016-03-23 09:04:57',NULL,2);
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtoouservico`
--

DROP TABLE IF EXISTS `produtoouservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtoouservico` (
  `idProdutoOuServico` int(11) NOT NULL AUTO_INCREMENT,
  `estagioEvolucao` varchar(300) DEFAULT NULL,
  `tecnologiaProcessos` text,
  `potencialInovacaoTecnologica` text,
  `aplicacoes` text,
  `dificuldadesEsperadas` text,
  `interacaoEmpresaUniversidade` text,
  `interacaoEmpresaComunidadeGoverno` text,
  `infraestrutura` text,
  PRIMARY KEY (`idProdutoOuServico`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtoouservico`
--

LOCK TABLES `produtoouservico` WRITE;
/*!40000 ALTER TABLE `produtoouservico` DISABLE KEYS */;
INSERT INTO `produtoouservico` VALUES (31,'Em teste no mercado','dasdasdas','dsadasdasdas','dasascxvxcvcx','dsadasdasda','sdasdsadsa','dsadsadsadsa','dasdasdasdas'),(32,'Protótipo Desenvolvido','dsadasdsa','dsadasdas','dsadsadsa','dasdasdsadas','dsadsadsa','dasdsadsa','dsadsadsa');
/*!40000 ALTER TABLE `produtoouservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analiseemprego`
--

DROP TABLE IF EXISTS `analiseemprego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `analiseemprego` (
  `idAnaliseEmprego` int(11) NOT NULL AUTO_INCREMENT,
  `relacoesClientes` text,
  `parceriasChaves` text,
  `canais` text,
  `recursosPrincipais` text,
  `concorrentes` text,
  PRIMARY KEY (`idAnaliseEmprego`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analiseemprego`
--

LOCK TABLES `analiseemprego` WRITE;
/*!40000 ALTER TABLE `analiseemprego` DISABLE KEYS */;
INSERT INTO `analiseemprego` VALUES (4,'dasdsa','dsadasdsadasdsadasdsa','dasdasdasdsadas','dasdasdsaasdas','dasdasdasdas'),(5,'dsadasdsadsa','dsadsadsa','dsadsadsa','dsadsadsa','dsadassadsa');
/*!40000 ALTER TABLE `analiseemprego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empreendedor`
--

DROP TABLE IF EXISTS `empreendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empreendedor` (
  `usuario_id_usuario` int(11) NOT NULL,
  `formacao` text,
  `experiencia` text,
  `bairro` varchar(100) DEFAULT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `idUnico` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`usuario_id_usuario`),
  KEY `fk_empreendedor_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `fk_empreendedor_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empreendedor`
--

LOCK TABLES `empreendedor` WRITE;
/*!40000 ALTER TABLE `empreendedor` DISABLE KEYS */;
INSERT INTO `empreendedor` VALUES (1,'','','dsadas','dsadsa',1231231,'',NULL),(2,'dsadsa','dsadasdas','dsadas','dsadsa',123,'dasdas',NULL);
/*!40000 ALTER TABLE `empreendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacao`
--

DROP TABLE IF EXISTS `notificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notificacao` (
  `idnotificacao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(450) DEFAULT NULL,
  `visualizado` tinyint(1) DEFAULT NULL,
  `link` varchar(100) DEFAULT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`idnotificacao`),
  KEY `fk_notificacao_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `fk_notificacao_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacao`
--

LOCK TABLES `notificacao` WRITE;
/*!40000 ALTER TABLE `notificacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-24 15:43:51
