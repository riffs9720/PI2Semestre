CREATE DATABASE  IF NOT EXISTS `sistemadesugestao` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sistemadesugestao`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemadesugestao
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao` (
  `idAvaliacao` int(11) NOT NULL AUTO_INCREMENT,
  `resposta` text NOT NULL,
  `aprovado` tinyint(1) NOT NULL,
  `dtAvaliacao` datetime NOT NULL,
  `sugestao_idSugestao` int(11) NOT NULL,
  `usuarioAcesso_idUsuarioAcesso` int(11) NOT NULL,
  PRIMARY KEY (`idAvaliacao`),
  KEY `fk_avaliacao_sugestao1_idx` (`sugestao_idSugestao`),
  KEY `fk_avaliacao_usuarioAcesso1_idx` (`usuarioAcesso_idUsuarioAcesso`),
  CONSTRAINT `fk_avaliacao_sugestao1` FOREIGN KEY (`sugestao_idSugestao`) REFERENCES `sugestao` (`idSugestao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_usuarioAcesso1` FOREIGN KEY (`usuarioAcesso_idUsuarioAcesso`) REFERENCES `usuarioacesso` (`idUsuarioAcesso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentariosugestao`
--

DROP TABLE IF EXISTS `comentariosugestao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentariosugestao` (
  `idComentarioSugestao` int(11) NOT NULL AUTO_INCREMENT,
  `conteudo` varchar(255) NOT NULL,
  `dtComentario` datetime NOT NULL,
  `numeroCurtida` int(10) DEFAULT NULL,
  `usuarioAcesso_idUsuarioAcesso` int(11) NOT NULL,
  `sugestao_idSugestao` int(11) NOT NULL,
  PRIMARY KEY (`idComentarioSugestao`),
  KEY `fk_comentarioSugestao_usuarioAcesso1_idx` (`usuarioAcesso_idUsuarioAcesso`),
  KEY `fk_comentarioSugestao_sugestao1_idx` (`sugestao_idSugestao`),
  CONSTRAINT `fk_comentarioSugestao_sugestao1` FOREIGN KEY (`sugestao_idSugestao`) REFERENCES `sugestao` (`idSugestao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentarioSugestao_usuarioAcesso1` FOREIGN KEY (`usuarioAcesso_idUsuarioAcesso`) REFERENCES `usuarioacesso` (`idUsuarioAcesso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentariosugestao`
--

LOCK TABLES `comentariosugestao` WRITE;
/*!40000 ALTER TABLE `comentariosugestao` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentariosugestao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nomeDepartamento` varchar(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'CAA'),(2,'Cantina');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filtro`
--

DROP TABLE IF EXISTS `filtro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filtro` (
  `idFiltro` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `tipoPerfil_idTipoPerfil` int(11) NOT NULL,
  `tipoFiltro_idTipoFiltro` int(11) NOT NULL,
  PRIMARY KEY (`idFiltro`),
  KEY `fk_filtro_tipoPerfil1_idx` (`tipoPerfil_idTipoPerfil`),
  KEY `fk_filtro_tipoFiltro1_idx` (`tipoFiltro_idTipoFiltro`),
  CONSTRAINT `fk_filtro_tipoFiltro1` FOREIGN KEY (`tipoFiltro_idTipoFiltro`) REFERENCES `tipofiltro` (`idTipoFiltro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_filtro_tipoPerfil1` FOREIGN KEY (`tipoPerfil_idTipoPerfil`) REFERENCES `tipoperfil` (`idTipoPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filtro`
--

LOCK TABLES `filtro` WRITE;
/*!40000 ALTER TABLE `filtro` DISABLE KEYS */;
INSERT INTO `filtro` VALUES (1,'Departamento',1,1),(2,'Departamento',2,1),(3,'Departamento',3,1),(4,'Departamento',4,1),(5,'Rancking',2,2),(6,'Rancking',3,2),(7,'Rancking',4,2);
/*!40000 ALTER TABLE `filtro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocorrencia`
--

DROP TABLE IF EXISTS `ocorrencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocorrencia` (
  `idOcorrencia` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `nomeUsuario` varchar(45) NOT NULL,
  `assunto` varchar(45) NOT NULL,
  `conteudo` text NOT NULL,
  `dtOcorrencia` date NOT NULL,
  `usuarioAcesso_idUsuarioAcesso` int(11) NOT NULL,
  `status_idStatus` int(11) NOT NULL,
  PRIMARY KEY (`idOcorrencia`),
  KEY `fk_ocorrencia_usuarioAcesso1_idx` (`usuarioAcesso_idUsuarioAcesso`),
  KEY `fk_ocorrencia_status1_idx` (`status_idStatus`),
  CONSTRAINT `fk_ocorrencia_status1` FOREIGN KEY (`status_idStatus`) REFERENCES `status` (`idStatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ocorrencia_usuarioAcesso1` FOREIGN KEY (`usuarioAcesso_idUsuarioAcesso`) REFERENCES `usuarioacesso` (`idUsuarioAcesso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocorrencia`
--

LOCK TABLES `ocorrencia` WRITE;
/*!40000 ALTER TABLE `ocorrencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocorrencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `idStatus` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Aberto'),(2,'Em andamento'),(3,'Finalizado');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sugestao`
--

DROP TABLE IF EXISTS `sugestao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sugestao` (
  `idSugestao` int(11) NOT NULL AUTO_INCREMENT,
  `conteudo` varchar(200) NOT NULL,
  `dtSugestao` datetime NOT NULL,
  `usuarioAcesso_id_usuarioAcesso` int(11) NOT NULL,
  `departamento_idDepartamento` int(11) NOT NULL,
  `tipoSugestao` varchar(20) NOT NULL,
  `status_idStatus` int(11) NOT NULL,
  PRIMARY KEY (`idSugestao`),
  KEY `fk_sugestao_usuarioAcesso1_idx` (`usuarioAcesso_id_usuarioAcesso`),
  KEY `fk_sugestao_departamento1_idx` (`departamento_idDepartamento`),
  KEY `fk_sugestao_status1_idx` (`status_idStatus`),
  CONSTRAINT `fk_sugestao_departamento1` FOREIGN KEY (`departamento_idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sugestao_status1` FOREIGN KEY (`status_idStatus`) REFERENCES `status` (`idStatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sugestao_usuarioAcesso1` FOREIGN KEY (`usuarioAcesso_id_usuarioAcesso`) REFERENCES `usuarioacesso` (`idUsuarioAcesso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sugestao`
--

LOCK TABLES `sugestao` WRITE;
/*!40000 ALTER TABLE `sugestao` DISABLE KEYS */;
INSERT INTO `sugestao` VALUES (1,'Sua Sugestão','2016-11-13 21:49:55',5,1,'Elogio',1),(3,'Lanches mais baratos e saudaveis.','2016-11-13 22:01:45',7,2,'Melhoria',3),(5,'Sua Sugestão','2016-11-13 22:38:17',5,1,'Elogio',1),(7,'Preço muito elevado para a qualidade da comida.','2016-11-13 23:09:44',5,2,'Reclamação',1),(8,'bla','2016-11-13 23:11:54',5,1,'Elogio',1),(10,'carlos é muito chato','2016-11-13 23:18:59',14,1,'Elogio',1),(11,'Não está funcionando.','2016-11-13 23:50:06',5,1,'Reclamação',1),(12,'Não disponibilizam serviços após as 21h30.','2016-11-14 11:54:56',5,2,'Reclamação',1),(13,'Sua Sugestão','2016-11-14 18:38:30',5,1,'Elogio',1),(14,'oi fernanda :D','2016-11-14 21:41:22',5,1,'Elogio',1),(15,'Amo!!!','2016-11-15 02:26:15',15,1,'Elogio',1);
/*!40000 ALTER TABLE `sugestao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipofiltro`
--

DROP TABLE IF EXISTS `tipofiltro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipofiltro` (
  `idTipoFiltro` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoFiltro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipofiltro`
--

LOCK TABLES `tipofiltro` WRITE;
/*!40000 ALTER TABLE `tipofiltro` DISABLE KEYS */;
INSERT INTO `tipofiltro` VALUES (1,'Pesquisa'),(2,'Relatorio');
/*!40000 ALTER TABLE `tipofiltro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoidentificacao`
--

DROP TABLE IF EXISTS `tipoidentificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoidentificacao` (
  `idTipoIdentificacao` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoIdentificacao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoidentificacao`
--

LOCK TABLES `tipoidentificacao` WRITE;
/*!40000 ALTER TABLE `tipoidentificacao` DISABLE KEYS */;
INSERT INTO `tipoidentificacao` VALUES (1,'RA'),(2,'RF');
/*!40000 ALTER TABLE `tipoidentificacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoperfil`
--

DROP TABLE IF EXISTS `tipoperfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoperfil` (
  `idTipoPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoperfil`
--

LOCK TABLES `tipoperfil` WRITE;
/*!40000 ALTER TABLE `tipoperfil` DISABLE KEYS */;
INSERT INTO `tipoperfil` VALUES (1,'colaborador'),(2,'avaliador'),(3,'superior'),(4,'administrador');
/*!40000 ALTER TABLE `tipoperfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioacesso`
--

DROP TABLE IF EXISTS `usuarioacesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioacesso` (
  `idUsuarioAcesso` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `senha` char(32) NOT NULL,
  `usuarioCadastro_idUsuarioCadastro` int(11) NOT NULL,
  PRIMARY KEY (`idUsuarioAcesso`),
  KEY `fk_usuarioAcesso_usuarioCadastro_idx` (`usuarioCadastro_idUsuarioCadastro`),
  CONSTRAINT `fk_usuarioAcesso_usuarioCadastro` FOREIGN KEY (`usuarioCadastro_idUsuarioCadastro`) REFERENCES `usuariocadastro` (`idUsuarioCadastro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioacesso`
--

LOCK TABLES `usuarioacesso` WRITE;
/*!40000 ALTER TABLE `usuarioacesso` DISABLE KEYS */;
INSERT INTO `usuarioacesso` VALUES (1,'sergio@se.br','202cb962ac59075b964b07152d234b70',8),(2,'jessica@se.br','aae039d6aa239cfc121357a825210fa3',9),(3,'fmaoim','202cb962ac59075b964b07152d234b70',10),(4,'ceci@ceci.com','827ccb0eea8a706c4c34a16891f84e7b',11),(5,'sandra@br.com','202cb962ac59075b964b07152d234b70',12),(6,'maria@mole.nz','263bce650e68ab4e23f28263760b9fa5',13),(7,'lienerosada@hotmail.com','dab56d863ec9c549b1faa561554d4f85',14),(8,'mariadocarmo@yahoo.com.br','202cb962ac59075b964b07152d234b70',15),(9,'joana@bol.com','202cb962ac59075b964b07152d234b70',16),(10,'santos_almeida@gmail.com','202cb962ac59075b964b07152d234b70',17),(11,'mardossantos@gmail.com','202cb962ac59075b964b07152d234b70',18),(12,'teste','202cb962ac59075b964b07152d234b70',19),(13,'mara','202cb962ac59075b964b07152d234b70',20),(14,'carlos@gmail.com','202cb962ac59075b964b07152d234b70',21),(15,'jana@gmail.com','9439aec52eb100234ad0d3bf4471b575',22);
/*!40000 ALTER TABLE `usuarioacesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioacesso_has_departamento`
--

DROP TABLE IF EXISTS `usuarioacesso_has_departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioacesso_has_departamento` (
  `usuarioAcesso_idUsuarioAcesso` int(11) NOT NULL,
  `departamento_idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`usuarioAcesso_idUsuarioAcesso`,`departamento_idDepartamento`),
  KEY `fk_usuarioAcesso_has_departamento_departamento1_idx` (`departamento_idDepartamento`),
  KEY `fk_usuarioAcesso_has_departamento_usuarioAcesso1_idx` (`usuarioAcesso_idUsuarioAcesso`),
  CONSTRAINT `fk_usuarioAcesso_has_departamento_departamento1` FOREIGN KEY (`departamento_idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarioAcesso_has_departamento_usuarioAcesso1` FOREIGN KEY (`usuarioAcesso_idUsuarioAcesso`) REFERENCES `usuarioacesso` (`idUsuarioAcesso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioacesso_has_departamento`
--

LOCK TABLES `usuarioacesso_has_departamento` WRITE;
/*!40000 ALTER TABLE `usuarioacesso_has_departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarioacesso_has_departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariocadastro`
--

DROP TABLE IF EXISTS `usuariocadastro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuariocadastro` (
  `idUsuarioCadastro` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` char(11) NOT NULL,
  `dtNascimento` date NOT NULL,
  `genero` char(1) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `numeroIdentificacao` int(11) NOT NULL,
  `dtCadastro` date NOT NULL,
  `tipoPerfil_id_tipoPerfil` int(11) NOT NULL,
  `tipoIdentificacao_id_tipoIdentificacao` int(11) NOT NULL,
  PRIMARY KEY (`idUsuarioCadastro`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  KEY `fk_usuarioCadastro_tipoPerfil1_idx` (`tipoPerfil_id_tipoPerfil`),
  KEY `fk_usuarioCadastro_tipoIdentificacao1_idx` (`tipoIdentificacao_id_tipoIdentificacao`),
  CONSTRAINT `fk_usuarioCadastro_tipoIdentificacao1` FOREIGN KEY (`tipoIdentificacao_id_tipoIdentificacao`) REFERENCES `tipoidentificacao` (`idTipoIdentificacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarioCadastro_tipoPerfil1` FOREIGN KEY (`tipoPerfil_id_tipoPerfil`) REFERENCES `tipoperfil` (`idTipoPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariocadastro`
--

LOCK TABLES `usuariocadastro` WRITE;
/*!40000 ALTER TABLE `usuariocadastro` DISABLE KEYS */;
INSERT INTO `usuariocadastro` VALUES (6,'João Marcos Santos','235148569','1998-06-06','M','Rua Santo Carlo, 15 - São Paulo - SP',815114785,'2016-11-02',1,1),(7,'Maria','12345678941','1998-12-25','f','rua das caldeiras, 23 SP',912145365,'2016-11-12',2,2),(8,'Sergio','12345678945','1998-06-09','m','Rua d, 1u sp',912145873,'2016-11-12',2,2),(9,'Jessica de Almeida','22214565896','1995-03-15','f','Rua A, 12 ',815125478,'2016-11-12',1,1),(10,'idaonf','45678945685','1998-06-06','f','fsa',816114578,'2016-11-12',1,1),(11,'Cecilia','11145878452','1998-06-03','f','rya stsrsrtsrt',816147859,'2016-11-12',1,1),(12,'Sandra','11122255544','1971-10-29','F','rua a',815445784,'2016-11-12',1,1),(13,'maria mole','61669665663','1996-06-06','F','Rua do Alambique, 69 Santa Cruz',959565874,'2016-11-12',2,2),(14,'Eliene Aparecida dos Santos Silva Luiz','44478460809','1998-10-21','F','Rua Joaquim das neves corticeiro, 67',858852147,'2016-11-13',1,1),(15,'Maria do Carmo Silva','5554784856','1958-11-25','F','Rua das Palmeiras, 18 São Paulo',915478147,'2016-11-13',2,2),(16,'Joana','11111111111','1995-11-10','F','rua dos calouros, 23 santo dias sp',916114785,'2016-11-13',2,2),(17,'Santos Almeida Campo','66654789568','1956-10-30','F','Av. Santo Amaro, 23 Santo Amaro - SP',916125147,'2016-11-13',3,2),(18,'Marcos dos Santos','44458747859','1998-06-05','M','Av. Guarapiranga, 999 Guarapiranga - SP',816147852,'2016-11-13',1,1),(19,'testes','44444444444','1998-05-05','F','testes',816125478,'2016-11-13',1,1),(20,'saraiva','12345678123','1998-06-06','F','rua a',816147858,'2016-11-13',1,1),(21,'Carlos Almeida','44478456558','1995-05-06','M','Rua das Cadeiras, 19 Horizonte, sp',816154781,'2016-11-13',1,1),(22,'Janaina Emilia','44478486867','0199-06-03','F','Rua claude audran, 17 sp',816114781,'2016-11-15',1,1);
/*!40000 ALTER TABLE `usuariocadastro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-15 16:53:49
