-- Task 1
create database bgg;

-- -- login with root, create user fred and grant rights. then login with user fred and use created database
-- create user 'fred'@'localhost' identified by 'fred';
-- grant ALL PRIVILEGES ON bgg.* TO 'fred'@'localhost';

use bgg;
-- for railway deployment, use railway auto created database;

CREATE TABLE `user` (
  `user_id` VARCHAR(8) NOT NULL,
  `username` VARCHAR(45) CHARACTER SET 'ascii' COLLATE 'ascii_general_ci' NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE);

-- Task 5
CREATE TABLE `task` (
  `task_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `priority` INT NULL,
  `due_date` DATE NULL,
  PRIMARY KEY (`task_id`));