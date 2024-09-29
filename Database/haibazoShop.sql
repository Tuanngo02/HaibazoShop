-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: haibazoShop
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `dbl_category`
--

DROP TABLE IF EXISTS dbl_category;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE dbl_category (
  id bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbl_category`
--

LOCK TABLES dbl_category WRITE;
/*!40000 ALTER TABLE dbl_category DISABLE KEYS */;
INSERT INTO dbl_category VALUES (1,'Home & Decor'),(2,'Clothing'),(3,'Accessories'),(4,'Outdoor');
/*!40000 ALTER TABLE dbl_category ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbl_color`
--

DROP TABLE IF EXISTS dbl_color;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE dbl_color (
  id bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbl_color`
--

LOCK TABLES dbl_color WRITE;
/*!40000 ALTER TABLE dbl_color DISABLE KEYS */;
INSERT INTO dbl_color VALUES (1,'Green'),(2,'Red'),(3,'Black'),(4,'Pink'),(5,'White'),(6,'Yellow');
/*!40000 ALTER TABLE dbl_color ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbl_product`
--

DROP TABLE IF EXISTS dbl_product;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE dbl_product (
  id bigint NOT NULL AUTO_INCREMENT,
  image_url varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  original_price float NOT NULL,
  price float NOT NULL,
  rating varchar(255) DEFAULT NULL,
  product_category_id bigint DEFAULT NULL,
  product_color_id bigint DEFAULT NULL,
  product_size_id bigint DEFAULT NULL,
  product_style_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKkl79hfob50vhuhvyx3u5ta7bo (product_category_id),
  KEY FK7jo2q99d8ddv2ehilavgp6gyk (product_color_id),
  KEY FKnf1ejv4sqqv1rt5e0qmwim0lo (product_size_id),
  KEY FK3y0xia5ca347c04fdmxkreafe (product_style_id),
  CONSTRAINT FK3y0xia5ca347c04fdmxkreafe FOREIGN KEY (product_style_id) REFERENCES dbl_style (id),
  CONSTRAINT FK7jo2q99d8ddv2ehilavgp6gyk FOREIGN KEY (product_color_id) REFERENCES dbl_color (id),
  CONSTRAINT FKkl79hfob50vhuhvyx3u5ta7bo FOREIGN KEY (product_category_id) REFERENCES dbl_category (id),
  CONSTRAINT FKnf1ejv4sqqv1rt5e0qmwim0lo FOREIGN KEY (product_size_id) REFERENCES dbl_size (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbl_product`
--

LOCK TABLES dbl_product WRITE;
/*!40000 ALTER TABLE dbl_product DISABLE KEYS */;
INSERT INTO dbl_product VALUES (1,'http://res.cloudinary.com/dpigvaz8s/image/upload/v1727623989/vpbvmk1rhr64jzqneac5.png','Product 1',3000,3000,'5 sao',2,1,1,1),(2,'http://res.cloudinary.com/dpigvaz8s/image/upload/v1727624149/bejtovamf8c7usztfzsb.jpg','Product 2',5000,5000,'5 sao',2,3,3,2),(3,'http://res.cloudinary.com/dpigvaz8s/image/upload/v1727624427/esoz4sbvkz4f7r2vvlib.jpg','Product 3',1000,1000,'4 sao',2,4,5,3);
/*!40000 ALTER TABLE dbl_product ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbl_size`
--

DROP TABLE IF EXISTS dbl_size;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE dbl_size (
  id bigint NOT NULL AUTO_INCREMENT,
  label varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbl_size`
--

LOCK TABLES dbl_size WRITE;
/*!40000 ALTER TABLE dbl_size DISABLE KEYS */;
INSERT INTO dbl_size VALUES (1,'M'),(2,'L'),(3,'S'),(4,'XL'),(5,'One Size'),(6,'Custom');
/*!40000 ALTER TABLE dbl_size ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbl_style`
--

DROP TABLE IF EXISTS dbl_style;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE dbl_style (
  id bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbl_style`
--

LOCK TABLES dbl_style WRITE;
/*!40000 ALTER TABLE dbl_style DISABLE KEYS */;
INSERT INTO dbl_style VALUES (1,'Modern'),(2,'StreetWear'),(3,'Colorfull'),(4,'Vintage'),(5,'Bohemian');
/*!40000 ALTER TABLE dbl_style ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-29 22:50:36
