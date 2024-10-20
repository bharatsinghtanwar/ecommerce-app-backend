CREATE TABLE `user` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(255) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `roles` VARCHAR(255) NOT NULL, -- You might store roles as a comma-separated list or use a join table for roles
    `enabled` BOOLEAN NOT NULL DEFAULT TRUE
);


CREATE TABLE `product` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `description` TEXT,
    `price` DECIMAL(10, 2) NOT NULL,
    `stock` INT NOT NULL,
    `category` VARCHAR(255)
);


CREATE TABLE `cart` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT NOT NULL,
    `total_price` DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
);


CREATE TABLE `cart_item` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `cart_id` BIGINT NOT NULL,
    `product_id` BIGINT NOT NULL,
    `quantity` INT NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (`cart_id`) REFERENCES `cart`(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`product_id`) REFERENCES `product`(`id`) ON DELETE CASCADE
);


CREATE TABLE `cart_item` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `cart_id` BIGINT NOT NULL,
    `product_id` BIGINT NOT NULL,
    `quantity` INT NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (`cart_id`) REFERENCES `cart`(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`product_id`) REFERENCES `product`(`id`) ON DELETE CASCADE
);


CREATE TABLE `order` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT NOT NULL,
    `total_price` DECIMAL(10, 2) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
);


CREATE TABLE `order_item` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `order_id` BIGINT NOT NULL,
    `product_id` BIGINT NOT NULL,
    `quantity` INT NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (`order_id`) REFERENCES `order`(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`product_id`) REFERENCES `product`(`id`) ON DELETE CASCADE
);


