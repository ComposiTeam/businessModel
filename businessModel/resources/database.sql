CREATE DATABASE IF NOT EXISTS gradPlanner; 

-- -----------------------------------------------------
-- Table `gradPlanner`.`Discipline`
-- -----------------------------------------------------
CREATE TABLE `gradPlanner`.`Discipline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cod` VARCHAR(45) NULL,
  `name` VARCHAR(300) NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `gradPlanner`.`User`
-- -----------------------------------------------------
CREATE TABLE `gradPlanner`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password`  BLOB NOT  NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));
  
CREATE TABLE IF NOT EXISTS `gradPlanner`.`TranscriptOfRecords` (
  `idTranscriptOfRecords` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idTranscriptOfRecords`)  COMMENT '')
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `gradPlanner`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Person` (
  `idPerson` INT NOT NULL COMMENT '',
  `email` VARCHAR(45) NULL COMMENT '',
  `User_idUser` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idPerson`)  COMMENT '',
  INDEX `fk_Person_User1_idx` (`User_idUser` ASC)  COMMENT '',
  CONSTRAINT `fk_Person_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `gradPlanner`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Student` (
  `id` INT NOT NULL COMMENT '',
  `registrationNumber` VARCHAR(45) NULL COMMENT '',
  `passwordMW` VARCHAR(45) NULL COMMENT '',
  `TranscriptOfRecords_idTranscriptOfRecords` INT NOT NULL COMMENT '',
  `Person_idPerson` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_Student_TranscriptOfRecords1_idx` (`TranscriptOfRecords_idTranscriptOfRecords` ASC)  COMMENT '',
  INDEX `fk_Student_Person1_idx` (`Person_idPerson` ASC)  COMMENT '',
  CONSTRAINT `fk_Student_TranscriptOfRecords1`
    FOREIGN KEY (`TranscriptOfRecords_idTranscriptOfRecords`)
    REFERENCES `gradPlanner`.`TranscriptOfRecords` (`idTranscriptOfRecords`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Person1`
    FOREIGN KEY (`Person_idPerson`)
    REFERENCES `gradPlanner`.`Person` (`idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`ClassPeriod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`ClassPeriod` (
  `idClassPeriod` INT NOT NULL COMMENT '',
  `semester` INT NULL COMMENT '',
  `academicYear` INT NULL COMMENT '',
  PRIMARY KEY (`idClassPeriod`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`ClassSchedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`ClassSchedule` (
  `idClassSchedule` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idClassSchedule`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Class` (
  `idClass` INT NOT NULL COMMENT '',
  `Period_idPeriod` INT NOT NULL COMMENT '',
  `ClassSchedule_idClassSchedule` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idClass`)  COMMENT '',
  INDEX `fk_Class_Period1_idx` (`Period_idPeriod` ASC)  COMMENT '',
  INDEX `fk_Class_ClassSchedule1_idx` (`ClassSchedule_idClassSchedule` ASC)  COMMENT '',
  CONSTRAINT `fk_Class_Period1`
    FOREIGN KEY (`Period_idPeriod`)
    REFERENCES `gradPlanner`.`ClassPeriod` (`idClassPeriod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Class_ClassSchedule1`
    FOREIGN KEY (`ClassSchedule_idClassSchedule`)
    REFERENCES `gradPlanner`.`ClassSchedule` (`idClassSchedule`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Mention`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Mention` (
  `idMention` INT NOT NULL COMMENT '',
  `abreviation` VARCHAR(3) NULL COMMENT '',
  `heaviness` INT NULL COMMENT '',
  PRIMARY KEY (`idMention`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Result` (
  `Student_id` INT NOT NULL COMMENT '',
  `Class_idClass` INT NOT NULL COMMENT '',
  `Mention_idMention` INT NOT NULL COMMENT '',
  `TranscriptOfRecords_idTranscriptOfRecords` INT NOT NULL COMMENT '',
  `description` VARCHAR(200) NULL COMMENT '',
  INDEX `fk_Result_Student_idx` (`Student_id` ASC)  COMMENT '',
  INDEX `fk_Result_Class1_idx` (`Class_idClass` ASC)  COMMENT '',
  INDEX `fk_Result_Mention1_idx` (`Mention_idMention` ASC)  COMMENT '',
  INDEX `fk_Result_TranscriptOfRecords1_idx` (`TranscriptOfRecords_idTranscriptOfRecords` ASC)  COMMENT '',
  CONSTRAINT `fk_Result_Student`
    FOREIGN KEY (`Student_id`)
    REFERENCES `gradPlanner`.`Student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Result_Class1`
    FOREIGN KEY (`Class_idClass`)
    REFERENCES `gradPlanner`.`Class` (`idClass`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Result_Mention1`
    FOREIGN KEY (`Mention_idMention`)
    REFERENCES `gradPlanner`.`Mention` (`idMention`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Result_TranscriptOfRecords1`
    FOREIGN KEY (`TranscriptOfRecords_idTranscriptOfRecords`)
    REFERENCES `gradPlanner`.`TranscriptOfRecords` (`idTranscriptOfRecords`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Matrix`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Matrix` (
  `idMatrix` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idMatrix`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Discipline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Discipline` (
  `idDiscipline` INT NOT NULL COMMENT '',
  `Class_idClass` INT NOT NULL COMMENT '',
  `Matrix_idMatrix` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idDiscipline`)  COMMENT '',
  INDEX `fk_Discipline_Class1_idx` (`Class_idClass` ASC)  COMMENT '',
  INDEX `fk_Discipline_Matrix1_idx` (`Matrix_idMatrix` ASC)  COMMENT '',
  CONSTRAINT `fk_Discipline_Class1`
    FOREIGN KEY (`Class_idClass`)
    REFERENCES `gradPlanner`.`Class` (`idClass`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Discipline_Matrix1`
    FOREIGN KEY (`Matrix_idMatrix`)
    REFERENCES `gradPlanner`.`Matrix` (`idMatrix`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Feedback` (
  `idFeedback` INT NOT NULL COMMENT '',
  `comment` VARCHAR(1024) NULL COMMENT '',
  `User_idUser` INT NOT NULL COMMENT '',
  `date` DATE NULL COMMENT '',
  PRIMARY KEY (`idFeedback`)  COMMENT '',
  INDEX `fk_Feedback_User1_idx` (`User_idUser` ASC)  COMMENT '',
  CONSTRAINT `fk_Feedback_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `gradPlanner`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Teacher` (
  `idTeacher` INT NOT NULL COMMENT '',
  `Person_idPerson` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idTeacher`)  COMMENT '',
  INDEX `fk_Teacher_Person1_idx` (`Person_idPerson` ASC)  COMMENT '',
  CONSTRAINT `fk_Teacher_Person1`
    FOREIGN KEY (`Person_idPerson`)
    REFERENCES `gradPlanner`.`Person` (`idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Grid`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Grid` (
  `idGrid` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idGrid`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Grid_has_Class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Grid_has_Class` (
  `Grid_idGrid` INT NOT NULL COMMENT '',
  `Class_idClass` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Grid_idGrid`, `Class_idClass`)  COMMENT '',
  INDEX `fk_Grid_has_Class_Class1_idx` (`Class_idClass` ASC)  COMMENT '',
  INDEX `fk_Grid_has_Class_Grid1_idx` (`Grid_idGrid` ASC)  COMMENT '',
  CONSTRAINT `fk_Grid_has_Class_Grid1`
    FOREIGN KEY (`Grid_idGrid`)
    REFERENCES `gradPlanner`.`Grid` (`idGrid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Grid_has_Class_Class1`
    FOREIGN KEY (`Class_idClass`)
    REFERENCES `gradPlanner`.`Class` (`idClass`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Offer` (
  `idOffer` INT NOT NULL COMMENT '',
  `ClassPeriod_idPeriod` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idOffer`)  COMMENT '',
  INDEX `fk_Offer_Period1_idx` (`ClassPeriod_idPeriod` ASC)  COMMENT '',
  CONSTRAINT `fk_Offer_Period1`
    FOREIGN KEY (`ClassPeriod_idPeriod`)
    REFERENCES `gradPlanner`.`ClassPeriod` (`idClassPeriod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gradPlanner`.`Offer_has_Class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradPlanner`.`Offer_has_Class` (
  `Offer_idOffer` INT NOT NULL COMMENT '',
  `Class_idClass` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Offer_idOffer`, `Class_idClass`)  COMMENT '',
  INDEX `fk_Offer_has_Class_Class1_idx` (`Class_idClass` ASC)  COMMENT '',
  INDEX `fk_Offer_has_Class_Offer1_idx` (`Offer_idOffer` ASC)  COMMENT '',
  CONSTRAINT `fk_Offer_has_Class_Offer1`
    FOREIGN KEY (`Offer_idOffer`)
    REFERENCES `gradPlanner`.`Offer` (`idOffer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Offer_has_Class_Class1`
    FOREIGN KEY (`Class_idClass`)
    REFERENCES `gradPlanner`.`Class` (`idClass`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;