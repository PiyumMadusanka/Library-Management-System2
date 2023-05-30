
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

LOCK TABLES `book` WRITE;
INSERT INTO `book` VALUES (1,'001','1984','Dystopian Fiction',NULL,'A'),(2,'002','To Kill a Mockingbird','Classic Literature',NULL,'A'),(3,'003','The Hitchhiker\'s Guide to the Galaxy','Science Fiction',NULL,'A'),(4,'004','Pride and Prejudice','Romance',NULL,'A'),(5,'005','The Great Gatsby','Historical Fiction',NULL,'A'),(6,'006','Harry Potter and the Sorcerer\'s Stone','Fantasy',NULL,'A'),(7,'007','The Catcher in the Rye','Coming-of-age Fiction',NULL,'A'),(8,'008','The Da Vinci Code','Thriller',NULL,'A'),(9,'009','Sapiens: A Brief History of Humankind ty','Non-fiction',NULL,'A'),(10,'010','The Lord of the Rings','Epic Fantasy',NULL,'A'),(15,'qq','qq','qq','2023-05-22 16:13:22','A'),(16,'sdfdsf','Harry Potter and the Sorcerer\'s Stone 2','sdfsdf','2023-05-22 16:27:52','A'),(17,'0011','gfhf','fghg','2023-05-22 16:32:09','A');
UNLOCK TABLES;

DROP TABLE IF EXISTS `issued_book`;
CREATE TABLE `issued_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_code` varchar(45) DEFAULT NULL,
  `issued_user` int(11) DEFAULT NULL,
  `borrowed_user` int(11) DEFAULT NULL,
  `borrowed_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `ac_return_date` date DEFAULT NULL,
  `return_status` varchar(10) DEFAULT NULL,
  `issue_remarks` text,
  `return_remarks` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `issued_book` WRITE;
INSERT INTO `issued_book` VALUES (1,'001',1,1,'2023-05-24','2023-05-27',NULL,'Pending','',NULL,'2023-05-24 23:49:34',NULL,'A'),(2,'002',1,2,'2023-05-24','2023-05-31',NULL,'Pending','sdfdsfsdf',NULL,'2023-05-24 23:50:12',NULL,'A'),(3,'005',1,2,'2023-05-24','2023-05-28',NULL,'Pending','',NULL,'2023-05-24 23:53:56',NULL,'A'),(4,'010',1,1,'2023-05-25','2023-11-07',NULL,'Returned','paid!',NULL,'2023-05-25 00:06:46',NULL,'A'),(5,'010',1,1,'2023-05-25','2023-05-31','2023-05-27','Returned','test','zsfdsdf','2023-05-25 00:30:22','2023-05-25 18:44:21','A');
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `tp_no` varchar(12) DEFAULT NULL,
  `nic_no` varchar(15) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'Admin','admin@my.com','Admin','123','Admin','No 12, Colombo 10','071 1279654','123456789V',NULL,'A'),(2,'Student','student@my.com','Student','123','Student','No 10, Kiribathgoda Kelaniya','077 7968541','123456789V','2023-05-22 18:51:28','A');
UNLOCK TABLES;
