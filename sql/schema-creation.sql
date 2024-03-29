-- MySQL Script generated by MySQL Workbench
-- 05/29/19 23:19:59
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- CREATING USER TABLE

CREATE TABLE IF NOT EXISTS `moviecruiser`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT, 
  `us_name` VARCHAR(60) NULL,
    PRIMARY KEY (`us_id`))
ENGINE = InnoDB;

-- CREATING TABLE FOR MOVIE

CREATE TABLE IF NOT EXISTS `moviecruiser`.`movie` (
  `mo_id` INT NOT NULL AUTO_INCREMENT,
  `mo_title` VARCHAR(100) NULL,
  `mo_box_office` BIGINT NULL,  
  `mo_active` VARCHAR(3) NULL,
  `mo_date_of_launch` DATE NULL,
  `mo_genre` VARCHAR(45) NULL,
  `mo_has_teaser` VARCHAR(3) NULL,
  PRIMARY KEY (`mo_id`))
ENGINE = InnoDB;

-- CREATING FAVORITE

CREATE TABLE IF NOT EXISTS `moviecruiser`.`favorite` (
  `fv_id` INT NOT NULL AUTO_INCREMENT,
  `fv_us_id` INT NULL,
  `fv_mo_id` INT NULL,
  PRIMARY KEY (`fv_id`),
  INDEX `fv_us_fk_idx` (`fv_us_id` ASC),
  INDEX `fv_me_fk_idx` (`fv_mo_id` ASC),
  CONSTRAINT `fv_us_fk`
    FOREIGN KEY (`fv_us_id`)
    REFERENCES `moviecruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fv_mo_fk`
    FOREIGN KEY (`fv_mo_id`)
    REFERENCES `moviecruiser`.`movie` (`mo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;