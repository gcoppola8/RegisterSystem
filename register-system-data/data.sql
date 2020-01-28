DELIMITER //

create database app_db // 
use app_db //

DROP TABLE if exists `access_logs` //
DROP TABLE if exists `user` //

CREATE TABLE app_db.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `registered_on` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB

//

CREATE TABLE app_db.`access_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `access_on` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `access_logs_fk` (`user_id`),
  CONSTRAINT `access_logs_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB

//

INSERT INTO `user` (`username`,`password`) VALUES ("Kenneth","nisl. Quisque"),("Hyatt","ipsum."),("Dolan","justo sit amet"),("Gil","nec,"),("Amir","tincidunt, nunc ac mattis ornare, lectus"),("Hall","pede. Praesent eu dui. Cum sociis natoque penatibus et magnis"),("Chandler","dictum mi, ac"),("Hayes","at, egestas a, scelerisque sed, sapien. Nunc pulvinar"),("Kai","Nulla dignissim. Maecenas ornare egestas ligula. Nullam feugiat")//
INSERT INTO `user` (`username`,`password`) VALUES ("Samson","tortor, dictum eu, placerat eget, venenatis a, magna. Lorem"),("Donovan","Nam"),("Abel","ligula. Donec luctus aliquet"),("Brianna","vestibulum lorem, sit amet ultricies sem magna nec quam. Curabitur"),("Nina","Proin"),("Catherine","vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis."),("Maris","varius ultrices, mauris ipsum porta"),("Gwendolyn","fringilla euismod enim. Etiam"),("Clayton","sem ut cursus luctus, ipsum")//
INSERT INTO `user` (`username`,`password`) VALUES ("Kaden","volutpat. Nulla"),("Jerome","odio. Phasellus at augue id ante"),("Vance","Integer vulputate, risus a ultricies"),("Rylee","ac risus. Morbi metus. Vivamus euismod urna. Nullam lobortis quam"),("Nasim","luctus lobortis. Class aptent taciti sociosqu ad litora torquent per"),("Hashim","non, hendrerit id,"),("Demetria","Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper"),("Roanna","amet,"),("Isaiah","eu"),("Byron","pede, nonummy ut, molestie")//
INSERT INTO `user` (`username`,`password`) VALUES ("Melinda","mauris erat eget ipsum. Suspendisse sagittis. Nullam"),("Price","tellus. Nunc lectus pede, ultrices a, auctor non, feugiat"),("Raya","Etiam imperdiet dictum"),("Linus","Donec nibh enim, gravida sit amet, dapibus id, blandit at,"),("Kessie","vel lectus. Cum sociis natoque penatibus et magnis dis parturient"),("Stewart","dictum."),("Tyrone","Curabitur massa. Vestibulum"),("Veda","Etiam bibendum fermentum metus."),("Colorado","turpis vitae purus gravida sagittis. Duis"),("Mercedes","aliquam, enim nec tempus")//


INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (4,"2019-04-04 14:03:06"),(29,"2020-05-14 21:07:29"),(24,"2020-11-23 05:57:30"),(19,"2019-05-27 01:16:46"),(6,"2020-04-20 01:31:06"),(12,"2019-11-24 01:25:17"),(5,"2019-02-08 05:37:32"),(12,"2019-07-16 17:30:17"),(7,"2019-02-28 02:12:16"),(17,"2019-07-10 05:40:16")//
INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (18,"2020-03-29 01:18:54"),(24,"2019-11-28 22:43:54"),(10,"2019-05-06 14:56:47"),(29,"2020-04-27 03:45:22"),(25,"2019-12-28 02:53:01"),(7,"2019-09-30 18:08:06"),(26,"2021-01-08 09:08:12"),(3,"2019-09-27 11:31:44"),(22,"2019-05-11 07:02:59"),(4,"2019-07-03 14:46:14")//
INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (9,"2021-01-04 11:38:32"),(16,"2020-09-19 04:32:39"),(1,"2020-12-22 18:45:24"),(27,"2019-05-09 15:15:41"),(5,"2019-02-24 07:13:02"),(21,"2019-11-01 14:46:05"),(21,"2020-11-20 20:09:14"),(11,"2019-07-05 09:17:25"),(21,"2019-06-10 08:24:41"),(7,"2020-05-14 16:44:31")//
INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (3,"2020-05-11 12:35:15"),(19,"2020-09-22 05:42:58"),(26,"2019-05-18 09:39:26"),(16,"2020-02-03 03:53:52"),(2,"2020-09-15 04:22:14"),(6,"2019-07-05 15:50:56"),(2,"2019-06-11 04:45:46"),(9,"2019-12-28 09:42:34"),(7,"2021-01-10 12:33:23"),(20,"2020-09-16 02:43:26")//
INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (30,"2019-06-13 06:41:16"),(21,"2019-02-27 06:24:28"),(7,"2020-12-31 07:17:30"),(14,"2019-08-01 03:33:30"),(7,"2019-12-12 01:52:39"),(18,"2020-04-30 17:27:15"),(20,"2019-11-18 01:24:36"),(25,"2020-03-06 07:17:32"),(18,"2020-07-06 02:24:50"),(2,"2020-04-03 13:21:04")//
INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (5,"2019-02-04 04:17:57"),(10,"2020-04-28 19:33:56"),(19,"2019-06-18 00:27:05"),(9,"2019-09-08 10:26:29"),(11,"2019-10-08 21:51:58"),(17,"2019-08-30 00:15:25"),(22,"2021-01-12 08:53:41"),(21,"2019-10-24 13:15:11"),(26,"2019-04-02 04:59:37"),(27,"2020-06-16 20:33:20")//
INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (30,"2019-03-09 20:49:04"),(16,"2019-09-20 14:57:39"),(24,"2019-10-02 19:29:20"),(25,"2020-01-18 22:21:35"),(6,"2019-11-17 13:38:30"),(27,"2020-08-23 05:46:59"),(23,"2020-04-14 05:06:26"),(23,"2020-10-12 00:08:41"),(15,"2019-04-17 22:22:31"),(5,"2020-09-22 14:01:55")//
INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (29,"2020-07-30 16:57:56"),(21,"2019-03-30 07:23:36"),(2,"2019-08-28 22:53:58"),(6,"2019-03-27 02:59:08"),(21,"2019-12-15 02:00:20"),(5,"2020-04-02 09:51:44"),(24,"2019-07-28 08:31:09"),(22,"2020-01-18 18:34:08"),(19,"2020-04-17 22:20:31"),(1,"2019-02-20 13:34:58")//
INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (22,"2019-03-20 20:10:19"),(3,"2019-03-09 07:22:02"),(15,"2020-10-22 07:06:16"),(25,"2019-12-28 06:58:44"),(14,"2020-08-22 01:08:19"),(21,"2019-06-12 11:02:32"),(28,"2020-07-25 11:06:20"),(18,"2019-06-21 21:25:57"),(28,"2019-10-30 22:59:51"),(26,"2020-12-21 15:38:38")//
INSERT INTO `access_logs` (`user_id`,`access_on`) VALUES (4,"2019-04-08 17:14:56"),(29,"2020-10-16 07:26:29"),(26,"2019-05-01 08:10:20"),(30,"2020-07-28 01:31:25"),(24,"2019-11-17 23:39:10"),(1,"2020-11-30 03:24:47"),(25,"2020-11-14 10:08:54"),(26,"2019-02-02 02:53:02"),(18,"2020-07-29 12:43:03"),(27,"2019-05-24 22:38:45")//
