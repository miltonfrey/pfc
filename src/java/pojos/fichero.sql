CREATE DATABASE  IF NOT EXISTS `pfc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pfc`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: pfc
-- ------------------------------------------------------
-- Server version	5.5.24-log

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
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignatura` (
  `codAsignatura` int(11) NOT NULL DEFAULT '0',
  `nombreAsignatura` varchar(50) DEFAULT NULL,
  `creditos` smallint(6) DEFAULT NULL,
  `periodo` varchar(10) DEFAULT NULL,
  `infoAsigantura` longtext,
  `webAsignatura` varchar(200) DEFAULT NULL,
  `facultad` varchar(50) DEFAULT NULL,
  `titulacion` varchar(45) DEFAULT NULL,
  `nombreUniversidad` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`codAsignatura`,`nombreUniversidad`),
  KEY `asignatura_ibfk_1` (`nombreUniversidad`),
  CONSTRAINT `asignatura_ibfk_1` FOREIGN KEY (`nombreUniversidad`) REFERENCES `universidad` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES (1,'Cálculo',6,'invierno','','https://guiadocente.udc.es/guia_docent/index.php?centre=614&ensenyament=614G01&assignatura=614G01003&any_academic=2014_15&any_academic=2014_15','','','UDC'),(2,'MD',6,'invierno','','https://guiadocente.udc.es/guia_docent/index.php?centre=614&ensenyament=614G01&assignatura=614G01004&any_academic=2014_15&any_academic=2014_15','','','UDC'),(3,'Tecnología de Computadores',6,'primavera','','https://guiadocente.udc.es/guia_docent/index.php?centre=614&ensenyament=614G01&assignatura=614G01007&any_academic=2014_15&any_academic=2014_15','','','UDC'),(4,'rty',6,'anual','','','','','UDC'),(6,'idj',6,'anual','','','','','UDC'),(7,'fsd',6,'anual','','','','','UDC'),(8,'sdf',6,'anual','','','','','UDC'),(9,'vcxv',5,'anual','','','','','UDC'),(10,'sdfs',6,'anual','','','','','UDC'),(11,'vvc',6,'anual','','','','','UDC'),(12,'Matematica discreta',6,'invierno','','','','','ABC'),(1234,'sistemas operativos',6,'invierno','','','','','ABC'),(3456,'Cálculo',6,'invierno','','','','','ABC');
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato` (
  `idContrato` int(11) NOT NULL AUTO_INCREMENT,
  `idMovilidad` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idContrato`),
  KEY `idMovilidad_idx` (`idMovilidad`),
  CONSTRAINT `idMovilidad` FOREIGN KEY (`idMovilidad`) REFERENCES `movilidad` (`codMovilidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursoacademico`
--

DROP TABLE IF EXISTS `cursoacademico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursoacademico` (
  `cursoAcademico` varchar(10) NOT NULL,
  PRIMARY KEY (`cursoAcademico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursoacademico`
--

LOCK TABLES `cursoacademico` WRITE;
/*!40000 ALTER TABLE `cursoacademico` DISABLE KEYS */;
INSERT INTO `cursoacademico` VALUES ('2014/2015');
/*!40000 ALTER TABLE `cursoacademico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equivalencia`
--

DROP TABLE IF EXISTS `equivalencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equivalencia` (
  `idequivalencia` int(11) NOT NULL AUTO_INCREMENT,
  `grupoAsignaturaA` int(11) DEFAULT NULL,
  `grupoAsignaturaB` int(11) DEFAULT NULL,
  `idContrato` int(11) DEFAULT NULL,
  `visible` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`idequivalencia`),
  KEY `idContrato_idx` (`idContrato`),
  KEY `grupoAsignaturasA_idx` (`grupoAsignaturaA`),
  KEY `grupoAsignaturasB_idx` (`grupoAsignaturaB`),
  CONSTRAINT `grupoAsignaturasA` FOREIGN KEY (`grupoAsignaturaA`) REFERENCES `grupo_asignatura` (`idgrupoAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grupoAsignaturasB` FOREIGN KEY (`grupoAsignaturaB`) REFERENCES `grupo_asignatura` (`idgrupoAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idContrato` FOREIGN KEY (`idContrato`) REFERENCES `contrato` (`idContrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equivalencia`
--

LOCK TABLES `equivalencia` WRITE;
/*!40000 ALTER TABLE `equivalencia` DISABLE KEYS */;
INSERT INTO `equivalencia` VALUES (1,1,2,NULL,NULL);
/*!40000 ALTER TABLE `equivalencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`estado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES ('aceptado');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_movilidad`
--

DROP TABLE IF EXISTS `estado_movilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_movilidad` (
  `estadoMovilidad` varchar(10) NOT NULL,
  PRIMARY KEY (`estadoMovilidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_movilidad`
--

LOCK TABLES `estado_movilidad` WRITE;
/*!40000 ALTER TABLE `estado_movilidad` DISABLE KEYS */;
INSERT INTO `estado_movilidad` VALUES ('aceptada'),('cancelada'),('en curso'),('pendiente'),('rechazada'),('terminada');
/*!40000 ALTER TABLE `estado_movilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_asignatura`
--

DROP TABLE IF EXISTS `grupo_asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_asignatura` (
  `idgrupoAsignatura` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idgrupoAsignatura`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_asignatura`
--

LOCK TABLES `grupo_asignatura` WRITE;
/*!40000 ALTER TABLE `grupo_asignatura` DISABLE KEYS */;
INSERT INTO `grupo_asignatura` VALUES (1),(2);
/*!40000 ALTER TABLE `grupo_asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensaje` (
  `idmensaje` int(11) NOT NULL AUTO_INCREMENT,
  `origen` varchar(45) NOT NULL,
  `destino` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `tema` mediumtext,
  `texto` longtext NOT NULL,
  `leidoDestino` varchar(2) NOT NULL,
  `eliminadoOrigen` varchar(2) NOT NULL,
  `eliminadoDestino` varchar(2) NOT NULL,
  PRIMARY KEY (`idmensaje`),
  KEY `origen_idx` (`origen`),
  KEY `destino_idx` (`destino`),
  CONSTRAINT `destino` FOREIGN KEY (`destino`) REFERENCES `usuario` (`login`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `origen` FOREIGN KEY (`origen`) REFERENCES `usuario` (`login`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensaje`
--

LOCK TABLES `mensaje` WRITE;
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
INSERT INTO `mensaje` VALUES (36,'admin','user1','2014-09-16 22:49:09','cambio de estado de movilidad','destino:ABC \nfecha de inicio:25-08-2014 \nfecha fin:27-11-2014\n\nel estado de la movilidad ahora es: rechazada','si','no','si'),(37,'admin','user1','2014-09-16 22:51:55','cambio de estado de movilidad','destino:ABC \nfecha de inicio:25-08-2014 \nfecha fin:27-11-2014\n\nel estado de la movilidad ahora es: aceptada','si','no','si');
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro_grupo_asignatura`
--

DROP TABLE IF EXISTS `miembro_grupo_asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `miembro_grupo_asignatura` (
  `codMiembroCodigoAsignatura` int(11) NOT NULL AUTO_INCREMENT,
  `codAsignatura` int(11) DEFAULT NULL,
  `nombreUniversidad` varchar(45) DEFAULT NULL,
  `idGrupoAsignatura` int(11) DEFAULT NULL,
  PRIMARY KEY (`codMiembroCodigoAsignatura`),
  UNIQUE KEY `codAsignatura` (`codAsignatura`,`nombreUniversidad`,`idGrupoAsignatura`),
  KEY `grupoAsignatura` (`idGrupoAsignatura`),
  CONSTRAINT `asignatura` FOREIGN KEY (`codAsignatura`, `nombreUniversidad`) REFERENCES `asignatura` (`codAsignatura`, `nombreUniversidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grupoAsignatura` FOREIGN KEY (`idGrupoAsignatura`) REFERENCES `grupo_asignatura` (`idgrupoAsignatura`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro_grupo_asignatura`
--

LOCK TABLES `miembro_grupo_asignatura` WRITE;
/*!40000 ALTER TABLE `miembro_grupo_asignatura` DISABLE KEYS */;
INSERT INTO `miembro_grupo_asignatura` VALUES (1,7,'UDC',1),(3,3456,'ABC',2);
/*!40000 ALTER TABLE `miembro_grupo_asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movilidad`
--

DROP TABLE IF EXISTS `movilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movilidad` (
  `codMovilidad` int(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime NOT NULL,
  `estado` varchar(10) NOT NULL,
  `loginUsuario` varchar(20) NOT NULL,
  `nombreUniversidad` varchar(45) NOT NULL,
  `cursoAcademico` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codMovilidad`),
  KEY `usuario_idx` (`loginUsuario`),
  KEY `universidad_idx` (`nombreUniversidad`),
  KEY `cursoAcademico_idx` (`cursoAcademico`),
  CONSTRAINT `cursoAcademico` FOREIGN KEY (`cursoAcademico`) REFERENCES `cursoacademico` (`cursoAcademico`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `universidad` FOREIGN KEY (`nombreUniversidad`) REFERENCES `universidad` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuario` FOREIGN KEY (`loginUsuario`) REFERENCES `usuario` (`login`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movilidad`
--

LOCK TABLES `movilidad` WRITE;
/*!40000 ALTER TABLE `movilidad` DISABLE KEYS */;
INSERT INTO `movilidad` VALUES (1,'2014-08-25 00:00:00','2014-11-27 00:00:00','aceptada','user1','ABC','2014/2015');
/*!40000 ALTER TABLE `movilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES ('Alemania'),('España'),('Francia'),('Reino Unido'),('Suecia');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `universidad`
--

DROP TABLE IF EXISTS `universidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `universidad` (
  `nombre` varchar(45) NOT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `info` longtext,
  `web` varchar(50) DEFAULT NULL,
  `codUniversidad` varchar(15) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  UNIQUE KEY `codUniversidad_UNIQUE` (`codUniversidad`),
  KEY `pais_idx` (`pais`),
  CONSTRAINT `pais` FOREIGN KEY (`pais`) REFERENCES `pais` (`nombre`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `universidad`
--

LOCK TABLES `universidad` WRITE;
/*!40000 ALTER TABLE `universidad` DISABLE KEYS */;
INSERT INTO `universidad` VALUES ('ABC','Alemania','','','GER-071'),('UDC','España','','','ES-001'),('UUH','Alemania','','','GER-073');
/*!40000 ALTER TABLE `universidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `login` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `tipo_usuario` smallint(6) NOT NULL,
  `titulacion` varchar(25) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('admin','admin',0,'admin','','',NULL),('user1','pass1',1,'GEI','n1','a1',''),('user2','a',1,'GEI','s','s','');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-16 22:56:12
