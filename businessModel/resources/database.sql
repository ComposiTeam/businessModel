CREATE DATABASE IF NOT EXISTS gradPlanner; 


CREATE TABLE `gradPlanner`.`Discipline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cod` VARCHAR(45) NULL,
  `name` VARCHAR(300) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `gradPlanner`.`Role` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_role`),
  UNIQUE INDEX `role_UNIQUE` (`role` ASC)
 );

CREATE TABLE `gradPlanner`.`User` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password`  BLOB NOT  NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
);

CREATE TABLE `gradPlanner`.`USER_ROLE` (
  `id_role` INT NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_role`,`id_user`),
  CONSTRAINT FK_ROLE FOREIGN KEY (id_role) REFERENCES gradPlanner.Role(id_role),
  CONSTRAINT FK_USER FOREIGN KEY (id_user) REFERENCES gradPlanner.User(id_user)
 );
 
CREATE TABLE `gradPlanner`.`Person` (
  `id_person` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `surname`  VARCHAR(200)  NULL,
  PRIMARY KEY (`id_person`),
  CONSTRAINT FK_USER_PERSON FOREIGN KEY (id_user) REFERENCES gradPlanner.User(id_user)
);
  
INSERT INTO `gradPlanner`.`Role`(role) VALUES ("NORMAL_USER");
