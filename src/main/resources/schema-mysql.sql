CREATE TABLE IF NOT EXISTS `commodity` (
  `number` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `inventory` INT NULL DEFAULT 0,
  `price` INT NULL DEFAULT 0,
  `account_sell` VARCHAR(45) NULL,
  `introduction` VARCHAR(500) NULL,
  `img_path` VARCHAR(500) NULL,
  PRIMARY KEY (`number`));

CREATE TABLE IF NOT EXISTS `delivery_way_code` (
  `code` INT NOT NULL,
  `delivery_way` VARCHAR(45) NULL,
  PRIMARY KEY (`code`));

CREATE TABLE IF NOT EXISTS `identity_code` (
  `code` INT NOT NULL,
  `identity` VARCHAR(45) NULL,
  PRIMARY KEY (`code`));

CREATE TABLE IF NOT EXISTS `order_info` (
  `order_number` INT NOT NULL,
  `account_buy` VARCHAR(45) NULL,
  `account_sale` VARCHAR(45) NULL,
  `order_info` VARCHAR(200) NULL,
  `pay_way` INT NULL DEFAULT 0,
  `delivery_way` INT NULL DEFAULT 0,
  `status` INT NULL DEFAULT 0,
    `time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_number`));

  CREATE TABLE IF NOT EXISTS `pay_way_code` (
  `code` INT NOT NULL,
  `pay_way` VARCHAR(45) NULL,
  PRIMARY KEY (`code`));

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account` VARCHAR(45) NULL,
  `pwd` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `active` TINYINT NULL DEFAULT 0,
  `identity` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

  CREATE TABLE IF NOT EXISTS `shopping_car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NULL,
  `commodity_number` INT NULL DEFAULT 0,
  `quantity` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`));


