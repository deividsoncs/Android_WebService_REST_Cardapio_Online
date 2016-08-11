CREATE DATABASE  IF NOT EXISTS `bd_cardapio` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_cardapio`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: bd_cardapio
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `estabelecimento`
--

DROP TABLE IF EXISTS `estabelecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estabelecimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `nome_fantasia` varchar(45) NOT NULL,
  `email` varchar(20) NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `razao_social` varchar(45) DEFAULT NULL,
  `gostaram` int(11) DEFAULT NULL,
  `foto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_usuario_estabelecimento` (`id_usuario`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario_estabelecimento` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estabelecimento`
--

LOCK TABLES `estabelecimento` WRITE;
/*!40000 ALTER TABLE `estabelecimento` DISABLE KEYS */;
INSERT INTO `estabelecimento` VALUES (1,1,'Festa.com','festa@festa.com','32351063','Distribuidora Bla Bla',5,'//localhost/img/festa.jpg'),(4,1,'Belo Restaurante','asdsa@ds.com','99383333','Serviços Gastronomicos Lima',100,'//localhost/img/2/Belo.jpeg');
/*!40000 ALTER TABLE `estabelecimento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-23 16:25:31
