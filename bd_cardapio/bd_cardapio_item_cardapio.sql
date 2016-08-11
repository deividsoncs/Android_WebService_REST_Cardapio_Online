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
-- Table structure for table `item_cardapio`
--

DROP TABLE IF EXISTS `item_cardapio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_cardapio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_secao_cardapio` int(11) NOT NULL,
  `nome_item` varchar(45) NOT NULL,
  `preco` double DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `percentual_desconto` double DEFAULT NULL,
  `data_modificacao` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_secao_cardapio_item_cardapio` (`id_secao_cardapio`),
  CONSTRAINT `fk_id_secao_cardapio_item_cardapio` FOREIGN KEY (`id_secao_cardapio`) REFERENCES `secao_cardapio` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_cardapio`
--

LOCK TABLES `item_cardapio` WRITE;
/*!40000 ALTER TABLE `item_cardapio` DISABLE KEYS */;
INSERT INTO `item_cardapio` VALUES (1,1,'Cipó cravo',4,'cipó cravo itaunas','//localhost/1/1/cipó.jpeg',NULL,'2014-03-21'),(2,1,'Campari',6.5,'campari puro ','//localhost/1/1/campari.jpeg',NULL,'2014-03-21'),(3,2,'Quieber',24.9,'Porção com 20 quiebers','//locahost/1/2/quieber',NULL,'2014-03-21'),(4,2,'Batata',9.9,'Porção com 500 gramas de Batata Frita','//localhost/1/2/batata.jpeg',0.25,'2014-03-22');
/*!40000 ALTER TABLE `item_cardapio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-23 16:26:35
