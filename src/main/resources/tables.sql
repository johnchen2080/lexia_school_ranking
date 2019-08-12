DROP TABLE IF EXISTS `SCHOOL`;
DROP TABLE IF EXISTS `RANKING`;

CREATE TABLE `SCHOOL` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `school_id` VARCHAR(100),
  `school_name` VARCHAR(255),
  PRIMARY KEY (`sch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 
CREATE TABLE `RANKING` (
  `rank_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `school_id` VARCHAR(100),
  `rank` int(11) unsigned,
  `year` int(11) unsigned,
  PRIMARY KEY (`rank_id`),
  KEY `school_id` (`school_id`),
  CONSTRAINT `rankings_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `SCHOOL` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;