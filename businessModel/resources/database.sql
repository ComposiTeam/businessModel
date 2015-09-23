CREATE DATABASE IF NOT EXISTS gradPlanner; 


CREATE TABLE `gradPlanner`.`Discipline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cod` VARCHAR(45) NULL,
  `name` VARCHAR(300) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `gradPlanner`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(300) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));
