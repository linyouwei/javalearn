DROP TABLE IF EXISTS `COMMENT`;
CREATE TABLE `COMMENT`(
  `ID` INT(5) NOT NULL AUTO_INCREMENT ,
  `CONTENT` VARCHAR(200) NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DAILY_ID` INT(5) NOT NULL ,
    `USER_ID` INT(5) NOT NULL ,
  PRIMARY KEY (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;