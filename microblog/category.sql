DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`(
  `id` INT(5) NOT NULL AUTO_INCREMENT ,
  `category_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;