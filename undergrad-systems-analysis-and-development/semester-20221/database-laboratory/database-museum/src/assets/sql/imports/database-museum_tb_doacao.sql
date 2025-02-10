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
-- Table structure for table `tb_doacao`
--

DROP TABLE IF EXISTS `tb_doacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_doacao` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOME_INSTITUICAO` varchar(255) DEFAULT NULL,
  `CNPJ` varchar(255) DEFAULT NULL,
  `VALOR_DOADO` double DEFAULT NULL,
  `DATA_DOACAO` date DEFAULT NULL,
  `DESCRICAO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_doacao`
--

LOCK TABLES `tb_doacao` WRITE;
/*!40000 ALTER TABLE `tb_doacao` DISABLE KEYS */;
INSERT INTO `tb_doacao` VALUES (1,'Antônia e Felipe Financeira ME','32742359000120',11250,'2022-01-10','Doação'),(2,'Lucca e Isabel Restaurante Ltda','36766928000129',5000,'2022-01-20','Doação'),(3,'Isabella e Mariah Joalheria Ltda','81136549000100',10546.7,'2022-02-16','Doação'),(4,'Sandra e Olivia Joalheria Ltda','00532950000167',4500.44,'2022-02-04','Doação'),(5,'Natália e Miguel Telecomunicações Ltda','64479716000104',6995.55,'2022-03-17','Doacao'),(6,'Benedito e Yuri Consultoria Financeira Ltda','04578769000142',6948.43,'2022-03-29','Doacao x'),(7,'Igor e Fabiana Marketing Ltda','07249553000121',9741.76,'2022-04-07','Doacao'),(8,'Priscila e César Adega Ltda','64556143000167',7213.2,'2022-04-27','Doacao'),(9,'Laís e Paulo Publicidade e Propaganda ME','69242479000179',8171.21,'2022-05-09','Doacao'),(10,'Sabrina e Amanda Pães e Doces ME','65163291000184',3614.17,'2022-05-23','Doacao'),(11,'Emanuelly e Vicente Informática ME','30171392000112',17461.54,'2022-06-02','Doacao'),(12,'Geraldo e Igor Financeira ME','12728715000144',5716.49,'2022-06-13','Doacao'),(13,'Helena e Rafaela Joalheria Ltda','96120945000116',4000,'2022-05-02','Doacao xpto');
/*!40000 ALTER TABLE `tb_doacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-19 18:55:49
