DROP TABLE player;
DROP TABLE team;

CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `player` (
  `id_player` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_player`),
  KEY `FK_player_team` (`team_id`),
  CONSTRAINT `FK_player_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

insert into Team (id,name) values(1,'Barcelona');
INSERT INTO `orcl`.`team` (`id`, `name`) VALUES ('2', 'Sevilla');
INSERT INTO `orcl`.`team` (`name`) VALUES ('Albacete');
INSERT INTO `orcl`.`team` (`name`) VALUES ('Rayo Vallecano');

insert into Player (team_id, name, num, position) values(1,'Lionel Messi', 10, 'Forward');
insert into Player (team_id, name, num, position) values(1,'Andreas Inniesta', 8, 'Midfielder');
insert into Player (team_id, name, num, position) values(1,'Pique', 3, 'Defender');

DELETE FROM team WHERE name = 'Sevilla';
commit;
