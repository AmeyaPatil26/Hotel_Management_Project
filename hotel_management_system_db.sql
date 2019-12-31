/*
SQLyog Trial v13.1.5  (64 bit)
MySQL - 5.5.27 : Database - hotel_management_system_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel_management_system_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hotel_management_system_db`;

/*Table structure for table `adminemployeeuser` */

DROP TABLE IF EXISTS `adminemployeeuser`;

CREATE TABLE `adminemployeeuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contactNumber` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nationality` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `adminemployeeuser` */

insert  into `adminemployeeuser`(`id`,`name`,`email`,`contactNumber`,`password`,`nationality`,`address`,`type`) values 
(1,'Admin Portal','admin@gmail.com','7878787878','Admin@123','Indian','Benglore,Karnataka,India','Admin'),
(20,'Mayuri Kadam','mayuri@taj.com','9898787800','Mayuri@123','India','Kolhapur,Maharashtra','Employee'),
(21,'Ameya Patil','ameya@leela.com','9988090987','Ameya@123','India','Pune,Maharashtra','Employee'),
(22,'Sumedh Vartal','sumedh@conrad.com','7777654567','Sumedh@123','India','Mumbai,Maharashtra','Employee'),
(25,'Priti Banik','priti@gmail.com','7786545434','Priti@123','India','Bengole','User'),
(26,'Virat Kohali','virat@gmail.com','7888887879','Virat@123','India','Kolkatta','User'),
(27,'Barak Obama','barak@gmail.com','9988776655','Barak@123','American Samoa','America','User'),
(28,'Shital Patil','shital@gmail.com','9988778877','Shital@123','India','Noida','User'),
(30,'Simran Mulani','simran@gmail.com','9987648115','Simran@123','Algeria','Indore','User'),
(31,'Tim Hinchel','tim.h@email.com','9236547890','Qwerty@1234','Austria','Wakad','User'),
(38,'Qwerty Employee','kmulewa@gmail.com','8765432100','Abc@1234','Iceland','Pune','Employee');

/*Table structure for table `booking_information` */

DROP TABLE IF EXISTS `booking_information`;

CREATE TABLE `booking_information` (
  `bookingId` int(11) NOT NULL AUTO_INCREMENT,
  `bookingAmount` double DEFAULT NULL,
  `roomId` int(11) DEFAULT NULL,
  `roomType` varchar(20) DEFAULT NULL,
  `roomCapacity` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contactNumber` varchar(11) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `licenceNumber` varchar(9) DEFAULT NULL,
  `hotelName` varchar(20) DEFAULT NULL,
  `checkInDate` date DEFAULT NULL,
  `checkOutDate` date DEFAULT NULL,
  PRIMARY KEY (`bookingId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `booking_information` */

insert  into `booking_information`(`bookingId`,`bookingAmount`,`roomId`,`roomType`,`roomCapacity`,`email`,`name`,`address`,`contactNumber`,`nationality`,`licenceNumber`,`hotelName`,`checkInDate`,`checkOutDate`) values 
(2,8000,9,'AC','singleBed','shital@gmail.com','Shital Patil','Noida','9988778877','India','H10101010','Taj Hotel','2019-12-31','2020-01-03'),
(3,25500,10,'Non AC','Double bed','shital@gmail.com','Shital Patil','Noida','9988778877','India','H10101010','Taj Hotel','2019-12-31','2020-01-16'),
(4,128000,12,'AC','Double bed','tim.h@email.com','Tim Hinchel','Wakad','9236547890','Austria','H20202020','Leela Hotel','2019-12-29','2020-01-29'),
(5,1223,0,'AC','singleBed','sadfg@gmail.com','asdf szdxfcvbn','sdfcgvbhfcbv','7887787878','Afganistan','H10101010','Taj Hotel','2019-12-31','2020-07-31'),
(7,-1460282000,9,'AC','singleBed','simran@gmail.com','Simran Mulani','Indore','9987648115','Algeria','H10101010','Taj Hotel','2019-12-31','0020-12-10'),
(8,4000,9,'AC','singleBed','simran@gmail.com','Simran Mulani','Indore','9987648115','Algeria','H10101010','Taj Hotel','2019-12-31','2020-01-01'),
(9,4000,9,'AC','singleBed','simran@gmail.com','Simran Mulani','Indore','9987648115','Algeria','H10101010','Taj Hotel','2019-12-31','2020-01-01'),
(10,4000,9,'AC','singleBed','simran@gmail.com','Simran Mulani','Indore','9987648115','Algeria','H10101010','Taj Hotel','2019-12-31','2020-01-01'),
(11,4000,9,'AC','singleBed','simran@gmail.com','Simran Mulani','Indore','9987648115','Algeria','H10101010','Taj Hotel','2019-12-31','2020-01-01'),
(12,4000,9,'AC','singleBed','simran@gmail.com','Simran Mulani','Indore','9987648115','Algeria','H10101010','Taj Hotel','2019-12-31','2020-01-01');

/*Table structure for table `employee_information` */

DROP TABLE IF EXISTS `employee_information`;

CREATE TABLE `employee_information` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(50) DEFAULT NULL,
  `licenceNumber` varchar(9) DEFAULT NULL,
  `hotelId` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contactNumber` varchar(11) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `employee_information` */

insert  into `employee_information`(`employeeId`,`hotelName`,`licenceNumber`,`hotelId`,`name`,`email`,`password`,`address`,`contactNumber`,`nationality`) values 
(1,'Grant Hyatt','H70707070',13,'Employee Two','employee2@gmail.com','Empl@123','Delhi','8901234567','Indian'),
(10,'Taj Hotel','H10101010',7,'Mayuri Kadam','mayuri@taj.com','Mayuri@123','Kolhapur,Maharashtra','9898787800','India'),
(11,'Leela Hotel','H20202020',8,'Ameya Patil','ameya@leela.com','Ameya@123','Pune,Maharashtra','9988090987','India'),
(12,'Conrad Bengaluru','H30303030',9,'Sumedh Vartal','sumedh@conrad.com','Sumedh@123','Mumbai,Maharashtra','7777654567','India');

/*Table structure for table `hotel_information` */

DROP TABLE IF EXISTS `hotel_information`;

CREATE TABLE `hotel_information` (
  `hotelId` int(11) NOT NULL AUTO_INCREMENT,
  `licenceNumber` varchar(9) NOT NULL,
  `hotelName` varchar(50) NOT NULL,
  `hotelAddress` varchar(100) NOT NULL,
  `hotelContactNumber` varchar(13) NOT NULL,
  `hotelImageURL` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`hotelId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `hotel_information` */

insert  into `hotel_information`(`hotelId`,`licenceNumber`,`hotelName`,`hotelAddress`,`hotelContactNumber`,`hotelImageURL`) values 
(7,'H10101010','Taj Hotel','Apollo Bunder , Mumbai , 400 001','8978798576','https://cdn.pixabay.com/photo/2018/08/08/13/34/taj-mahal-palace-hotel-3592184__340.jpg'),
(8,'H20202020','Leela Hotel',' Lake,  Udaipur, Rajasthan 313001','7676879865','https://cdn.pixabay.com/photo/2019/09/18/13/00/udaipur-4486566_960_720.jpg'),
(9,'H30303030','Conrad Bengaluru','25/3,Bengaluru, Karnataka 560008','9090878987','https://cdn.pixabay.com/photo/2016/11/17/09/28/hotel-1831072__340.jpg'),
(12,'H60606060','JWMarriott Hotel','Pune,Maharashtra','9800900987','https://cdn.pixabay.com/photo/2014/12/31/16/28/caesars-palace-585098__340.jpg'),
(13,'H70707070','Grant Hyatt','Kolhapur,Maharashtra','7776655443','https://cdn.pixabay.com/photo/2015/09/21/09/54/villa-cortine-palace-949552__340.jpg'),
(14,'H80808080','Della Restro','29-1,Noida 5566443','9867654432','https://cdn.pixabay.com/photo/2014/06/05/08/12/hotel-lobby-362568__340.jpg');

/*Table structure for table `room_information` */

DROP TABLE IF EXISTS `room_information`;

CREATE TABLE `room_information` (
  `roomId` int(11) NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(50) DEFAULT NULL,
  `hotelId` int(11) DEFAULT NULL,
  `roomCount` int(11) DEFAULT NULL,
  `roomType` varchar(50) DEFAULT NULL,
  `roomCapacity` varchar(50) DEFAULT NULL,
  `roomAmount` double DEFAULT NULL,
  `roomStatus` varchar(50) DEFAULT NULL,
  `roomImageURL` varchar(500) DEFAULT NULL,
  `licenceNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `room_information` */

insert  into `room_information`(`roomId`,`hotelName`,`hotelId`,`roomCount`,`roomType`,`roomCapacity`,`roomAmount`,`roomStatus`,`roomImageURL`,`licenceNumber`) values 
(10,'Taj Hotel',7,8,'Non AC','Double bed',1500,'Available','https://cdn.pixabay.com/photo/2016/10/18/09/02/hotel-1749602__340.jpg','H10101010'),
(11,'Taj Hotel',7,10,'AC','Double bed',3000,'Available','https://cdn.pixabay.com/photo/2016/03/28/09/34/bedroom-1285156__340.jpg','H10101010'),
(12,'Leela Hotel',8,19,'AC','Double bed',4000,'Available','https://cdn.pixabay.com/photo/2015/04/20/13/12/bed-731162__340.jpg','H20202020'),
(13,'Leela Hotel',8,20,'Non AC','singleBed',1200,'Available','https://cdn.pixabay.com/photo/2019/08/19/13/58/hotel-4416515__340.jpg','H20202020'),
(14,'Leela Hotel',8,20,'AC','Double bed',5000,'Available','https://cdn.pixabay.com/photo/2018/06/14/21/15/the-interior-of-the-3475656__340.jpg','H20202020'),
(15,'Conrad Bengaluru',9,15,'AC','singleBed',1900,'Available','https://cdn.pixabay.com/photo/2016/06/10/01/05/hotel-room-1447201__340.jpg','H30303030'),
(16,'Conrad Bengaluru',9,15,'Non AC','singleBed',1200,'Available','https://cdn.pixabay.com/photo/2017/01/14/12/48/hotel-1979406__340.jpg','H30303030'),
(17,'Conrad Bengaluru',9,15,'AC','Double bed',3400,'Available','https://cdn.pixabay.com/photo/2016/09/18/03/28/travel-1677347__340.jpg','H30303030'),
(19,'Sheraton Grand',10,35,'Non AC','Double bed',3500,'Available','https://cdn.pixabay.com/photo/2016/10/13/09/06/travel-1737168__340.jpg','H40404040'),
(20,'Sheraton Grand',10,35,'AC','Double bed',10000,'Available','https://cdn.pixabay.com/photo/2017/04/28/22/16/room-2269594__340.jpg','H40404040');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
