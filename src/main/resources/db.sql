CREATE TABLE `personaldatajpa`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  PRIMARY KEY (`role_id`));
  
  CREATE TABLE `personaldatajpa`.`app_user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`));
  
CREATE TABLE `personaldatajpa`.`role_appuser` (
    `role_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    PRIMARY KEY (`role_id`, `user_id`),
    INDEX `FK_ROLE` (`role_id`),
    CONSTRAINT `FK_APPUSER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`user_id`),
    CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
)