-- MySQL Script generated by MySQL Workbench
-- Thu Jun  1 13:27:02 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema solvd_taxi_service
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema solvd_taxi_service
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `solvd_taxi_service` DEFAULT CHARACTER SET utf8 ;
USE `solvd_taxi_service` ;

-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Profiles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Profiles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `profile_id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Vehicles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Vehicles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `license_plate` VARCHAR(45) NULL,
  `vehicle_model` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `vehicle_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Driver_Licenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Driver_Licenses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `license_number` VARCHAR(45) NULL,
  `date_of_birth` DATE NULL,
  `expiration_date` DATE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `license_number_UNIQUE` (`license_number` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `profile_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  `driver_license_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_User_profile1_idx` (`profile_id` ASC) VISIBLE,
  INDEX `fk_User_Vehicle1_idx` (`vehicle_id` ASC) VISIBLE,
  INDEX `fk_User_Driver_License1_idx` (`driver_license_id` ASC) VISIBLE,
  CONSTRAINT `fk_User_profile1`
    FOREIGN KEY (`profile_id`)
    REFERENCES `solvd_taxi_service`.`Profiles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `solvd_taxi_service`.`Vehicles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Driver_License1`
    FOREIGN KEY (`driver_license_id`)
    REFERENCES `solvd_taxi_service`.`Driver_Licenses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Ride_Types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Ride_Types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `cost_per_mile` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ride_type_id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Rides`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Rides` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pickup_location` VARCHAR(45) NULL,
  `dropoff_location` VARCHAR(45) NULL,
  `ride_status` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `ride_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ride_id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Ride_User_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_Ride_Ride_Type1_idx` (`ride_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_Ride_User`
    FOREIGN KEY (`user_id`)
    REFERENCES `solvd_taxi_service`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ride_Ride_Type1`
    FOREIGN KEY (`ride_type_id`)
    REFERENCES `solvd_taxi_service`.`Ride_Types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Reviews` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` INT NULL,
  `comment` VARCHAR(45) NULL,
  `ride_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `review_id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Review_Ride1_idx` (`ride_id` ASC) VISIBLE,
  CONSTRAINT `fk_Review_Ride1`
    FOREIGN KEY (`ride_id`)
    REFERENCES `solvd_taxi_service`.`Rides` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Promo_Codes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Promo_Codes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL,
  `discount` DOUBLE NULL,
  `expiration_date` DATE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `promo_id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Trips`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Trips` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date_time` DATETIME(1) NULL,
  `end_date_time` DATETIME(1) NULL,
  `distance` DOUBLE NULL,
  `ride_id` INT NOT NULL,
  `promo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `trip_id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Trip_Ride1_idx` (`ride_id` ASC) VISIBLE,
  INDEX `fk_Trip_Promo_Code1_idx` (`promo_id` ASC) VISIBLE,
  CONSTRAINT `fk_Trip_Ride1`
    FOREIGN KEY (`ride_id`)
    REFERENCES `solvd_taxi_service`.`Rides` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trip_Promo_Code1`
    FOREIGN KEY (`promo_id`)
    REFERENCES `solvd_taxi_service`.`Promo_Codes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Invoices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Invoices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tax_amount` DOUBLE NULL,
  `total_amount` DOUBLE NULL,
  `trip_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `invoice_id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Invoice_Trip1_idx` (`trip_id` ASC) VISIBLE,
  CONSTRAINT `fk_Invoice_Trip1`
    FOREIGN KEY (`trip_id`)
    REFERENCES `solvd_taxi_service`.`Trips` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Payment_Methods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Payment_Methods` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `method` VARCHAR(45) NULL,
  `details` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solvd_taxi_service`.`Payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `solvd_taxi_service`.`Payments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `payment_status` VARCHAR(45) NULL,
  `invoice_id` INT NOT NULL,
  `payment_method_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `payment_id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_payment_Invoice1_idx` (`invoice_id` ASC) VISIBLE,
  INDEX `fk_Payment_Payment_Method1_idx` (`payment_method_id` ASC) VISIBLE,
  CONSTRAINT `fk_payment_Invoice1`
    FOREIGN KEY (`invoice_id`)
    REFERENCES `solvd_taxi_service`.`Invoices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Payment_Payment_Method1`
    FOREIGN KEY (`payment_method_id`)
    REFERENCES `solvd_taxi_service`.`Payment_Methods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;