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
-- Table structure for table `tb_arte`
--

DROP TABLE IF EXISTS `tb_arte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_arte` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOME_OBRA` varchar(255) DEFAULT NULL,
  `NOME_ARTISTA` varchar(255) DEFAULT NULL,
  `DATA_CRIACAO` date DEFAULT NULL,
  `DESCRICAO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_arte`
--

LOCK TABLES `tb_arte` WRITE;
/*!40000 ALTER TABLE `tb_arte` DISABLE KEYS */;
INSERT INTO `tb_arte` VALUES (1,'Mona Lisa','Leonardo da Vinci','1503-02-02','Mona Lisa também conhecida como A Gioconda ou ainda Mona Lisa del Giocondo é a mais notável e conhecida obra de Leonardo da Vinci, um dos mais eminentes homens do Renascimento italiano.'),(2,'A Última Ceia','Leonardo da Vinci','1498-01-01','A Última Ceia é um afresco de Leonardo da Vinci para a igreja de Santa Maria delle Grazie em Milão, Itália.'),(4,'A Noite Estrelada','Vincent van Gogh','1889-06-01','A Noite Estrelada é uma pintura de Vincent van Gogh de 1889. A obra retrata a vista da janela de um quarto do hospício de Saint-Rémy-de-Provence, pouco antes do nascer do sol, com a adição de um vilarejo idealizado pelo artista.'),(6,'O Nascimento de Vênus','Sandro Botticelli','1485-01-01','O Nascimento de Vênus é uma pintura de Sandro Botticelli, encomendada por Lorenzo di Pierfrancesco de Médici para a Villa Medicea di Castello.'),(7,'A Persistência da Memória','Salvador Dalí','1931-01-01','A Persistência da Memória é uma pintura do artista surrealista Salvador Dalí de 1931. A pintura está localizada na coleção do Museu de Arte Moderna de Nova Iorque desde 1934.'),(8,'Moça com o Brinco de Pérola','Johannes Vermeer','1665-01-01','É uma pintura do artista neerlandês Johannes Vermeer de 1665. Como o seu nome indica, é utilizado um brinco de pérola como ponto focal. A pintura está no Mauritshuis de Haia.'),(9,'O Beijo','Gustav Klimt','1907-01-01','O beijo é um quadro do pintor austríaco Gustav Klimt. Executada em óleo sobre tela, medindo 180x180 centímetros, entre 1907 e 1908, é uma das obras mais conhecidas do Klimt, graças a um elevado número de reproduções.'),(10,'American Gothic','Grant Wood','1930-01-01','American Gothic é uma pintura de Grant Wood. A inspiração de Wood veio de uma casa desenhada em estilo gótico rural com uma distinta janela superior e uma decisão de pintar junto a casa com \"o tipo de pessoa que eu imaginava viver naquela casa.\".'),(11,'O Filho do Homem','René Magritte','1964-01-01','O Filho do Homem é uma pintura de 1964 do pintor surrealista belga René Magritte. Magritte pintou-o como um auto-retrato. A pintura consiste em um homem de fato e chapéu-coco, em pé à frente de um pequeno muro, com o mar e um céu nublado ao fundo.'),(12,'A Criação de Adão','Michelangelo Buonarotti','1511-01-01','A Criação de Adão é um fresco de 280cm x 570cm, pintado por Michelangelo Buonarotti por volta de 1511, que fica no teto da Capela Sistina no Vaticano. A cena representa um episódio do Livro do Gênesis no qual Deus cria o primeiro homem: Adão.'),(13,'Medusa','Caravaggio','1596-01-01','Medusa é uma pintura a óleo sobre tela montada sobre madeira (não é talha dourada), de Michel Angelo Merisi da Caravaggio, também conhecido apenas como Caravaggio.'),(14,'As Meninas','Diego Velázquez','1656-01-01','As Meninas é uma pintura de 1656 por Diego Velázquez, o principal artista do Século de Ouro Espanhol. Ela está atualmente no Museu do Prado em Madrid.'),(15,'A Ronda Noturna','Rembrandt','1639-01-01','A Ronda Noturna ou A Ronda da Noite (em neerlandês: De Nachtwacht) é uma pintura a óleo sobre tela do pintor neerlandês Rembrandt, pintada entre 1639 e 1642.'),(16,'Guernica','Pablo Picasso','1881-01-01','Com 349 cm de altura por 776,5 cm de comprimento, Guernica, uma das obras mais famosas de Pablo Picasso (1881-1973), pintada a óleo em 1937, é uma “declaração de guerra contra a guerra e um manifesto contra a violência”.'),(17,'Decapitação de João Batista','Caravaggio','1608-01-01','A Decapitação de João Batista é uma pintura a óleo criada quando Caravaggio estava sob a proteção dos Cavaleiros de Malta, é considerada uma das obras-primas do pintor e uma das obras mais importantes da pintura ocidental.'),(18,'O Massacre dos Inocentes','Peter Paul Rubens','1636-01-01','O Massacre dos Inocentes é um célebre e importante óleo sobre madeira do artista barroco Peter Paul Rubens, datado de 1636-1638.'),(19,'A escola de Atenas','Rafael','1509-01-01','A Escola de Atenas é uma das mais famosas pinturas do renascentista italiano Rafael e representa a Academia de Atenas. Foi pintada entre 1509 e 1511 na Stanza della Segnatura sob encomenda do Vaticano.'),(20,'Os fuzilamentos de três de Maio','Goya','1814-01-01','Três de Maio de 1808 em Madrid, os fuzilamentos de três de Maio, nome pelo qual é habitualmente conhecido, é um quadro do pintor espanhol Francisco de Goya. O quadro, de 2,68 x 3,47 metros, foi realizado em 1814 e encontra-se no Museu do Prado, em Madrid.'),(21,'O Grito','Edvard Munch','1893-01-01','O Grito é uma série de quatro pinturas do norueguês Edvard Munch, 1893. A obra representa uma figura andrógina num momento de profunda angústia e desespero existencial. O plano de fundo é a doca de Oslofjord (em Oslo) ao pôr-do-Sol.'),(22,'Abaporu','Tarsila do Amaral','1928-01-01','Abaporu é uma pintura a óleo da artista brasileira Tarsila do Amaral. É uma das principais obras do período antropofágico do movimento modernista no Brasil.'),(23,'Auto-Retrato','Vincent van Gogh','1889-09-01','A obra, que pode ter sido o último autorretrato de Van Gogh, foi pintada pouco antes de ele deixar Saint-Rémy-de-Provence, no sul França. A pintura está agora no Musée d\'Orsay em Paris.');
/*!40000 ALTER TABLE `tb_arte` ENABLE KEYS */;
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
