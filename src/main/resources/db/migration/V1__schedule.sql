CREATE TABLE `users` (
	`id` SERIAL NOT NULL,
	`studentnumber` VARCHAR(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`password` TEXT(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	PRIMARY KEY (`studentnumber`)
) ENGINE=InnoDB;