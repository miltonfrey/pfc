-- MySQL dump 10.13  Distrib 5.5.24, for Win32 (x86)
--
-- Host: localhost    Database: pfc2
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
INSERT INTO `asignatura` VALUES (1,'Inglés técnico',6,'invierno','','','','','ABC'),(1,'Cálculo',6,'invierno','','https://guiadocente.udc.es/guia_docent/index.php?centre=614&ensenyament=614G01&assignatura=614G01003&any_academic=2014_15&any_academic=2014_15','','','UDC'),(2,'MD',6,'invierno','sdfsdf','https://guiadocente.udc.es/guia_docent/index.php?centre=614&ensenyament=614G01&assignatura=614G01004&any_academic=2014_15&any_academic=2014_15','','','UDC'),(3,'Tecnología de Computadores',6,'primavera','','https://guiadocente.udc.es/guia_docent/index.php?centre=614&ensenyament=614G01&assignatura=614G01007&any_academic=2014_15&any_academic=2014_15','','','UDC'),(4,'rty',6,'anual','','','','','UDC'),(5,'sistemas inteligentes',6,'primavera','','http://www.fic.udc.es','','','UDC'),(5,'calidad',6,'invierno','','','','','Universidad Hitler'),(6,'Estadistica',6,'primavera','','','','','UDC'),(7,'Metodologia de la Programacion',6,'invierno','','','','','UDC'),(8,'Calidad',6,'invierno','','','','','UDC'),(10,'Programacion 2',6,'invierno','','','','','UDC'),(11,'Ingles técnico',6,'invierno','','','','','UDC'),(13,'Programacion',6,'invierno','','','','','UDC'),(16,'fisica',8,'anual','','','','','ABC'),(17,'sistemas inteligentes',6,'invierno','','','','','ABC'),(18,'calidad',7,'invierno','','','','','Universidad Hitler'),(19,'proyectos',6,'invierno','','','','','ABC'),(20,'arquitectura software',6,'invierno','','','','','ABC'),(156,'calculo',6,'anual','','','','','Universidad Hitler'),(1234,'sistemas operativos',6,'primavera','','','','','ABC');
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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (35,25,'2014-10-31 14:32:20','pendiente');
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato_equivalencia`
--

DROP TABLE IF EXISTS `contrato_equivalencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato_equivalencia` (
  `idContrato` int(11) NOT NULL,
  `idEquivalencia` int(11) NOT NULL,
  PRIMARY KEY (`idContrato`,`idEquivalencia`),
  KEY `equivalencia1_idx` (`idEquivalencia`),
  CONSTRAINT `contrato1` FOREIGN KEY (`idContrato`) REFERENCES `contrato` (`idContrato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `equivalencia1` FOREIGN KEY (`idEquivalencia`) REFERENCES `equivalencia` (`idequivalencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato_equivalencia`
--

LOCK TABLES `contrato_equivalencia` WRITE;
/*!40000 ALTER TABLE `contrato_equivalencia` DISABLE KEYS */;
INSERT INTO `contrato_equivalencia` VALUES (35,55);
/*!40000 ALTER TABLE `contrato_equivalencia` ENABLE KEYS */;
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
INSERT INTO `cursoacademico` VALUES ('2014/2015'),('2015/2016'),('2016/2017');
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
  `visible` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`idequivalencia`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equivalencia`
--

LOCK TABLES `equivalencia` WRITE;
/*!40000 ALTER TABLE `equivalencia` DISABLE KEYS */;
INSERT INTO `equivalencia` VALUES (55,'no');
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
INSERT INTO `estado` VALUES ('aceptado'),('pendiente'),('rechazado');
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
INSERT INTO `estado_movilidad` VALUES ('aceptada'),('cancelada'),('pendiente'),('rechazada'),('terminada');
/*!40000 ALTER TABLE `estado_movilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_asignatura_a`
--

DROP TABLE IF EXISTS `grupo_asignatura_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_asignatura_a` (
  `idequivalencia` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idequivalencia`),
  CONSTRAINT `equivalencia` FOREIGN KEY (`idequivalencia`) REFERENCES `equivalencia` (`idequivalencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_asignatura_a`
--

LOCK TABLES `grupo_asignatura_a` WRITE;
/*!40000 ALTER TABLE `grupo_asignatura_a` DISABLE KEYS */;
INSERT INTO `grupo_asignatura_a` VALUES (55);
/*!40000 ALTER TABLE `grupo_asignatura_a` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_asignatura_b`
--

DROP TABLE IF EXISTS `grupo_asignatura_b`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_asignatura_b` (
  `idequivalencia` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idequivalencia`),
  CONSTRAINT `grupo_asignatura_b_ibfk_1` FOREIGN KEY (`idequivalencia`) REFERENCES `equivalencia` (`idequivalencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_asignatura_b`
--

LOCK TABLES `grupo_asignatura_b` WRITE;
/*!40000 ALTER TABLE `grupo_asignatura_b` DISABLE KEYS */;
INSERT INTO `grupo_asignatura_b` VALUES (55);
/*!40000 ALTER TABLE `grupo_asignatura_b` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensaje`
--

LOCK TABLES `mensaje` WRITE;
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
INSERT INTO `mensaje` VALUES (26,'user1','admin','2014-10-30 20:53:35','contrato creado','el usuario user1 ha creado un contrato','no','no','no'),(27,'admin','user1','2014-10-30 20:53:46','cambio de estado de contrato','El estado de un contrato ha sido modificado','no','no','no'),(28,'user1','admin','2014-10-30 20:58:10','movilidad creada','el usuario n1 a1 ha creado una movilidad a ABC entre el 30-10-2014 y 05-02-2015','no','no','no'),(29,'admin','user1','2014-10-30 20:58:25','cambio de estado de movilidad','destino:ABC \nfecha de inicio:30-10-2014 \nfecha fin:05-02-2015\n\nel estado de la movilidad ahora es: aceptada','no','no','no'),(30,'user1','admin','2014-10-30 20:58:40','contrato creado','el usuario user1 ha creado un contrato','no','no','no'),(31,'admin','user1','2014-10-30 20:58:58','cambio de estado de contrato','El estado de un contrato ha sido modificado','no','no','no'),(32,'user1','admin','2014-10-30 21:07:25','movilidad creada','el usuario n1 a1 ha creado una movilidad a ABC entre el 30-10-2014 y 12-02-2015','no','no','no'),(33,'admin','user1','2014-10-30 21:07:40','cambio de estado de movilidad','destino:ABC \nfecha de inicio:30-10-2014 \nfecha fin:12-02-2015\n\nel estado de la movilidad ahora es: aceptada','no','no','no'),(34,'user1','admin','2014-10-30 21:07:50','contrato creado','el usuario user1 ha creado un contrato','no','no','no'),(35,'admin','user1','2014-10-30 21:08:00','cambio de estado de contrato','El estado de un contrato ha sido modificado','no','no','no'),(36,'user1','admin','2014-10-30 21:17:55','movilidad creada','el usuario n1 a1 ha creado una movilidad a ABC entre el 30-10-2014 y 19-03-2015','no','no','no'),(37,'admin','user1','2014-10-30 21:18:20','cambio de estado de movilidad','destino:ABC \nfecha de inicio:30-10-2014 \nfecha fin:19-03-2015\n\nel estado de la movilidad ahora es: aceptada','no','no','no'),(38,'user1','admin','2014-10-30 21:18:42','contrato creado','el usuario user1 ha creado un contrato','no','no','no'),(39,'admin','user1','2014-10-30 21:18:57','cambio de estado de contrato','El estado de un contrato ha sido modificado','no','no','no'),(40,'user1','admin','2014-10-30 21:26:36','movilidad creada','el usuario n1 a1 ha creado una movilidad a ABC entre el 30-10-2014 y 28-02-2015','no','no','no'),(41,'admin','user1','2014-10-30 21:26:48','cambio de estado de movilidad','destino:ABC \nfecha de inicio:30-10-2014 \nfecha fin:28-02-2015\n\nel estado de la movilidad ahora es: aceptada','no','no','no'),(42,'user1','admin','2014-10-30 21:27:02','contrato creado','el usuario user1 ha creado un contrato','no','no','no'),(43,'admin','user1','2014-10-30 21:27:16','cambio de estado de contrato','El estado de un contrato ha sido modificado','no','no','no'),(44,'user1','admin','2014-10-30 21:43:18','movilidad creada','el usuario n1 a1 ha creado una movilidad a ABC entre el 30-10-2014 y 11-02-2015','no','no','no'),(45,'admin','user1','2014-10-30 21:44:16','cambio de estado de movilidad','destino:ABC \nfecha de inicio:30-10-2014 \nfecha fin:11-02-2015\n\nel estado de la movilidad ahora es: aceptada','no','no','no'),(46,'user1','admin','2014-10-30 21:45:14','contrato creado','el usuario user1 ha creado un contrato','no','no','no'),(47,'admin','user1','2014-10-30 21:45:45','cambio de estado de contrato','El estado de un contrato ha sido modificado','no','no','no'),(48,'admin','user1','2014-10-30 21:47:05','cambio de estado de contrato','El estado de un contrato ha sido modificado','no','no','no'),(49,'user1','admin','2014-10-31 14:32:20','contrato creado','el usuario user1 ha creado un contrato','no','no','no');
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro_grupo_asignatura_a`
--

DROP TABLE IF EXISTS `miembro_grupo_asignatura_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `miembro_grupo_asignatura_a` (
  `idmiembro_grupo_asignatura_a` int(11) NOT NULL AUTO_INCREMENT,
  `codAsignatura` int(11) DEFAULT NULL,
  `nombreUniversidad` varchar(50) DEFAULT NULL,
  `idGrupoAsignaturaA` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmiembro_grupo_asignatura_a`),
  KEY `grupoAsignaturaA_idx` (`idGrupoAsignaturaA`),
  KEY `asignaturaA_idx` (`codAsignatura`,`nombreUniversidad`),
  CONSTRAINT `asignaturaA` FOREIGN KEY (`codAsignatura`, `nombreUniversidad`) REFERENCES `asignatura` (`codAsignatura`, `nombreUniversidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grupoAsignaturaA` FOREIGN KEY (`idGrupoAsignaturaA`) REFERENCES `grupo_asignatura_a` (`idequivalencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro_grupo_asignatura_a`
--

LOCK TABLES `miembro_grupo_asignatura_a` WRITE;
/*!40000 ALTER TABLE `miembro_grupo_asignatura_a` DISABLE KEYS */;
INSERT INTO `miembro_grupo_asignatura_a` VALUES (73,1,'UDC',55);
/*!40000 ALTER TABLE `miembro_grupo_asignatura_a` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro_grupo_asignatura_b`
--

DROP TABLE IF EXISTS `miembro_grupo_asignatura_b`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `miembro_grupo_asignatura_b` (
  `idmiembro_grupo_asignatura_b` int(11) NOT NULL AUTO_INCREMENT,
  `codAsignatura` int(11) DEFAULT NULL,
  `nombreUniversidad` varchar(50) DEFAULT NULL,
  `idGrupoAsignaturaB` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmiembro_grupo_asignatura_b`),
  KEY `asignatura_idx` (`codAsignatura`,`nombreUniversidad`),
  KEY `grupoAsignaturaB_idx` (`idGrupoAsignaturaB`),
  CONSTRAINT `asignaturab` FOREIGN KEY (`codAsignatura`, `nombreUniversidad`) REFERENCES `asignatura` (`codAsignatura`, `nombreUniversidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grupoAsignaturaB` FOREIGN KEY (`idGrupoAsignaturaB`) REFERENCES `grupo_asignatura_b` (`idequivalencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro_grupo_asignatura_b`
--

LOCK TABLES `miembro_grupo_asignatura_b` WRITE;
/*!40000 ALTER TABLE `miembro_grupo_asignatura_b` DISABLE KEYS */;
INSERT INTO `miembro_grupo_asignatura_b` VALUES (61,1,'ABC',55);
/*!40000 ALTER TABLE `miembro_grupo_asignatura_b` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movilidad`
--

LOCK TABLES `movilidad` WRITE;
/*!40000 ALTER TABLE `movilidad` DISABLE KEYS */;
INSERT INTO `movilidad` VALUES (25,'2014-10-30 00:00:00','2015-02-11 00:00:00','aceptada','user1','ABC','2014/2015');
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
INSERT INTO `universidad` VALUES ('AAA','España','','','ES-005'),('ABC','Alemania','Universidad nueva.','http://www.meteogalicia.com','GER-072'),('ABD','Alemania','','','GER-005'),('UDC','España','','','ES-001'),('UHH','España','','','ES-004'),('Universidad de Munich','Alemania','Esta universidad es una mierda','http://www.xhamster.com','GER-002'),('Universidad Hitler','Alemania','','','GER-001'),('UOC','España','Esta es una página llena de putas, Harry,putas.','http://xvideos.com','ES-003'),('USC','España','','','ES-002'),('UUH','Alemania','','','GER-0034');
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
INSERT INTO `usuario` VALUES ('admin','21232f297a57a5a743894a0e4a801fc3',0,'admin','admin','admin','admin'),('admin2','c84258e9c39059a89ab77d846ddab909',0,'admin','admin','admin',NULL),('s','0cc175b9c0f1b6a831c399e269772661',1,'GEI','s','s','s'),('user1','a722c63db8ec8625af6cf71cb8c2d939',1,'GEI','n1','a1',''),('user10','4d186321c1a7f0f354b297e8914ab240',1,'MUEI','Nombre1','Apellido1','Apellido2'),('user11','1a1dc91c907325c69271ddf0c944bc72',1,'GEI','a','a','a'),('user2','pass2',1,'GEI','u2','a2',''),('w','1a1dc91c907325c69271ddf0c944bc72',1,'GEI','w','w','w');
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

-- Dump completed on 2014-10-31 14:37:57
