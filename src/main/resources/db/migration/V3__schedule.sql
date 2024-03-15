CREATE TABLE 
`allscheules` (
	`id` SERIAL NOT NULL,
	`datetime` DATETIME NOT NULL,
	`title` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`detail` VARCHAR(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`place` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
) ENGINE=InnoDB;
