-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: database-museum
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_funcionario`
--

DROP TABLE IF EXISTS `tb_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_funcionario` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) DEFAULT NULL,
  `CPF` varchar(255) DEFAULT NULL,
  `TELEFONE` varchar(255) DEFAULT NULL,
  `CARGO` varchar(255) DEFAULT NULL,
  `TURNO` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `SENHA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_funcionario`
--

LOCK TABLES `tb_funcionario` WRITE;
/*!40000 ALTER TABLE `tb_funcionario` DISABLE KEYS */;
INSERT INTO `tb_funcionario` VALUES (1,'Ana Beatriz Barbosa Alves','53118352817','11987382244','Administrador','Matutino','beatrizbalves2@outlook.com','VppC1auS/GQ='),(4,'Júlia Lie Okita da Silva','16289447815','11987017977','Museólogo','Vespertino','julia.silva56@fatec.sp.gov.br','VppC1auS/GQ='),(5,'Arthur Viveiros','40801274800','11979781228','Gerente','Vespertino','arthur.viveiros@fatec.sp.gov.br','VppC1auS/GQ='),(7,'Lucas Rufino Maiellaro','86091440896','11982356799','Segurança','Vespertino','lucas.maiellaro@fatec.sp.gov.br','VppC1auS/GQ='),(8,'Gael Moreira Jales','94420182806','11981495057','Museólogo','Vespertino','gael.jales@geradornv.com.br','Qz6WbEHs+us=');
/*!40000 ALTER TABLE `tb_funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-19 18:55:50
