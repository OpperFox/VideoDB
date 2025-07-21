-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: video_db
-- ------------------------------------------------------
-- Server version	9.3.0

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
-- Table structure for table `contenido`
--

DROP TABLE IF EXISTS `contenido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenido` (
  `id_glob` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipo` enum('VIDEO','PELICULA','SERIE','TEMPORADA','PLAYLIST','SAGA') NOT NULL,
  PRIMARY KEY (`id_glob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenido`
--

LOCK TABLES `contenido` WRITE;
/*!40000 ALTER TABLE `contenido` DISABLE KEYS */;
/*!40000 ALTER TABLE `contenido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenido_relacionado`
--

DROP TABLE IF EXISTS `contenido_relacionado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenido_relacionado` (
  `contenedor_id` int NOT NULL,
  `contenido_id` int NOT NULL,
  PRIMARY KEY (`contenedor_id`,`contenido_id`),
  KEY `contenido_id` (`contenido_id`),
  CONSTRAINT `contenido_relacionado_ibfk_1` FOREIGN KEY (`contenedor_id`) REFERENCES `contenido` (`id_glob`),
  CONSTRAINT `contenido_relacionado_ibfk_2` FOREIGN KEY (`contenido_id`) REFERENCES `contenido` (`id_glob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenido_relacionado`
--

LOCK TABLES `contenido_relacionado` WRITE;
/*!40000 ALTER TABLE `contenido_relacionado` DISABLE KEYS */;
/*!40000 ALTER TABLE `contenido_relacionado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mediacontent`
--

DROP TABLE IF EXISTS `mediacontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mediacontent` (
  `id_glob` int NOT NULL,
  `id_loc` int DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_glob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mediacontent`
--

LOCK TABLES `mediacontent` WRITE;
/*!40000 ALTER TABLE `mediacontent` DISABLE KEYS */;
/*!40000 ALTER TABLE `mediacontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `id` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist_video`
--

DROP TABLE IF EXISTS `playlist_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist_video` (
  `playlist_id` int NOT NULL,
  `video_id` int NOT NULL,
  PRIMARY KEY (`playlist_id`,`video_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `playlist_video_ibfk_1` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`id`),
  CONSTRAINT `playlist_video_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `video` (`id_glob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist_video`
--

LOCK TABLES `playlist_video` WRITE;
/*!40000 ALTER TABLE `playlist_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saga`
--

DROP TABLE IF EXISTS `saga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saga` (
  `id` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saga`
--

LOCK TABLES `saga` WRITE;
/*!40000 ALTER TABLE `saga` DISABLE KEYS */;
/*!40000 ALTER TABLE `saga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saga_video`
--

DROP TABLE IF EXISTS `saga_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saga_video` (
  `saga_id` int NOT NULL,
  `video_id` int NOT NULL,
  PRIMARY KEY (`saga_id`,`video_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `saga_video_ibfk_1` FOREIGN KEY (`saga_id`) REFERENCES `saga` (`id`),
  CONSTRAINT `saga_video_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `video` (`id_glob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saga_video`
--

LOCK TABLES `saga_video` WRITE;
/*!40000 ALTER TABLE `saga_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `saga_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie`
--

DROP TABLE IF EXISTS `serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serie` (
  `id` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie`
--

LOCK TABLES `serie` WRITE;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie_temporada`
--

DROP TABLE IF EXISTS `serie_temporada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serie_temporada` (
  `serie_id` int NOT NULL,
  `temporada_id` int NOT NULL,
  PRIMARY KEY (`serie_id`,`temporada_id`),
  KEY `temporada_id` (`temporada_id`),
  CONSTRAINT `serie_temporada_ibfk_1` FOREIGN KEY (`serie_id`) REFERENCES `contenido` (`id_glob`),
  CONSTRAINT `serie_temporada_ibfk_2` FOREIGN KEY (`temporada_id`) REFERENCES `contenido` (`id_glob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie_temporada`
--

LOCK TABLES `serie_temporada` WRITE;
/*!40000 ALTER TABLE `serie_temporada` DISABLE KEYS */;
/*!40000 ALTER TABLE `serie_temporada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temporada`
--

DROP TABLE IF EXISTS `temporada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temporada` (
  `id` int NOT NULL,
  `serie_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `serie_id` (`serie_id`),
  CONSTRAINT `temporada_ibfk_1` FOREIGN KEY (`serie_id`) REFERENCES `serie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporada`
--

LOCK TABLES `temporada` WRITE;
/*!40000 ALTER TABLE `temporada` DISABLE KEYS */;
/*!40000 ALTER TABLE `temporada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temporada_video`
--

DROP TABLE IF EXISTS `temporada_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temporada_video` (
  `temporada_id` int NOT NULL,
  `video_id` int NOT NULL,
  PRIMARY KEY (`temporada_id`,`video_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `temporada_video_ibfk_1` FOREIGN KEY (`temporada_id`) REFERENCES `temporada` (`id`),
  CONSTRAINT `temporada_video_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `video` (`id_glob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporada_video`
--

LOCK TABLES `temporada_video` WRITE;
/*!40000 ALTER TABLE `temporada_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `temporada_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermediaregistry`
--

DROP TABLE IF EXISTS `usermediaregistry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usermediaregistry` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contenido_id` int DEFAULT NULL,
  `usuario_id` int DEFAULT NULL,
  `status` enum('VIENDO','COMPLETADO','PENDIENTE','ABANDONADO','PLANIFICADO','REVISTO','NO_VISTO') DEFAULT NULL,
  `rating` enum('SIN_CALIFICACION','HORRIBLE','MALO','REGULAR','BUENO','MUY_BUENO','SUBLIME') DEFAULT NULL,
  `favorito` tinyint(1) DEFAULT NULL,
  `fecha_comienzo` date DEFAULT NULL,
  `reference_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `contenido_id` (`contenido_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `usermediaregistry_ibfk_1` FOREIGN KEY (`contenido_id`) REFERENCES `contenido` (`id_glob`),
  CONSTRAINT `usermediaregistry_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermediaregistry`
--

LOCK TABLES `usermediaregistry` WRITE;
/*!40000 ALTER TABLE `usermediaregistry` DISABLE KEYS */;
/*!40000 ALTER TABLE `usermediaregistry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uservideohistory`
--

DROP TABLE IF EXISTS `uservideohistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uservideohistory` (
  `fecha` date NOT NULL,
  `contenido_id` int NOT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`fecha`,`contenido_id`,`usuario_id`),
  KEY `contenido_id` (`contenido_id`,`usuario_id`),
  CONSTRAINT `uservideohistory_ibfk_1` FOREIGN KEY (`contenido_id`, `usuario_id`) REFERENCES `uservideoinfo` (`contenido_id`, `usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uservideohistory`
--

LOCK TABLES `uservideohistory` WRITE;
/*!40000 ALTER TABLE `uservideohistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `uservideohistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uservideoinfo`
--

DROP TABLE IF EXISTS `uservideoinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uservideoinfo` (
  `contenido_id` int NOT NULL,
  `usuario_id` int NOT NULL,
  `status` enum('VIENDO','COMPLETADO','PENDIENTE','ABANDONADO','PLANIFICADO','REVISTO','NO_VISTO') DEFAULT NULL,
  `rating` enum('SIN_CALIFICACION','HORRIBLE','MALO','REGULAR','BUENO','MUY_BUENO','SUBLIME') DEFAULT NULL,
  `favorito` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`contenido_id`,`usuario_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `uservideoinfo_ibfk_1` FOREIGN KEY (`contenido_id`) REFERENCES `contenido` (`id_glob`),
  CONSTRAINT `uservideoinfo_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uservideoinfo`
--

LOCK TABLES `uservideoinfo` WRITE;
/*!40000 ALTER TABLE `uservideoinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `uservideoinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video` (
  `id_glob` int NOT NULL,
  `id_loc` int DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_glob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videourl`
--

DROP TABLE IF EXISTS `videourl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videourl` (
  `contenido_id` int NOT NULL,
  `enlace` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contenido_id`),
  CONSTRAINT `videourl_ibfk_1` FOREIGN KEY (`contenido_id`) REFERENCES `contenido` (`id_glob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videourl`
--

LOCK TABLES `videourl` WRITE;
/*!40000 ALTER TABLE `videourl` DISABLE KEYS */;
/*!40000 ALTER TABLE `videourl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-20 13:41:21
