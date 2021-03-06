-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rentijer
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.38-MariaDB

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
-- Table structure for table `oglas`
--

DROP TABLE IF EXISTS `oglas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oglas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPodPodKat` int(11) NOT NULL,
  `opis` varchar(45) NOT NULL,
  `idKorisnik` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idPodPodKat.oglas_idx` (`idPodPodKat`),
  KEY `idKorisnik.oglas_idx` (`idKorisnik`),
  CONSTRAINT `idKorisnik.oglas` FOREIGN KEY (`idKorisnik`) REFERENCES `korisnici` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idPodPodKat.oglas` FOREIGN KEY (`idPodPodKat`) REFERENCES `kategorije` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oglas`
--

LOCK TABLES `oglas` WRITE;
/*!40000 ALTER TABLE `oglas` DISABLE KEYS */;
INSERT INTO `oglas` VALUES (1,2,'PS4 Oglas 1',1),(2,3,'XBOX Oglas 1',1),(3,8,'Ak Oglas 1',2);
/*!40000 ALTER TABLE `oglas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-24 20:26:42
