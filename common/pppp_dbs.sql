/*
 Navicat MySQL Dump SQL

 Source Server         : azure-mysql
 Source Server Type    : MySQL
 Source Server Version : 50744 (5.7.44-log)
 Source Host           : property-mysql.mysql.database.azure.com:3306
 Source Schema         : pppp_dbs

 Target Server Type    : MySQL
 Target Server Version : 50744 (5.7.44-log)
 File Encoding         : 65001

 Date: 28/06/2024 21:21:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for interest
-- ----------------------------
DROP TABLE IF EXISTS `interest`;
CREATE TABLE `interest`  (
  `interestID` int(10) NOT NULL AUTO_INCREMENT,
  `userID` int(10) NOT NULL,
  `propertyID` int(10) NOT NULL,
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`interestID`) USING BTREE,
  INDEX `userID`(`userID`) USING BTREE,
  INDEX `propertyID`(`propertyID`) USING BTREE,
  CONSTRAINT `interest_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `interest_ibfk_2` FOREIGN KEY (`propertyID`) REFERENCES `property` (`propertyID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of interest
-- ----------------------------
INSERT INTO `interest` VALUES (1, 2, 1, 'interested');
INSERT INTO `interest` VALUES (2, 2, 2, 'considering');
INSERT INTO `interest` VALUES (3, 2, 3, 'interested');
INSERT INTO `interest` VALUES (4, 1, 5, 'interest');
INSERT INTO `interest` VALUES (9, 1, 4, 'interest');

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location`  (
  `locationID` int(10) NOT NULL AUTO_INCREMENT,
  `street` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `postalCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  PRIMARY KEY (`locationID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES (1, '10 Bayfront Avenue', '018956', 1.2834, 103.861);
INSERT INTO `location` VALUES (2, '1 Fullerton Road', '049213', 1.2868, 103.854);
INSERT INTO `location` VALUES (3, '3 Orchard By-The-Park', '248644', 1.3064, 103.829);
INSERT INTO `location` VALUES (4, '123 Street Name', '123456', 1.2345, 103.568);
INSERT INTO `location` VALUES (5, '123 Street Name', '123457', 1.4444, 123.568);

-- ----------------------------
-- Table structure for media
-- ----------------------------
DROP TABLE IF EXISTS `media`;
CREATE TABLE `media`  (
  `mediaID` int(10) NOT NULL AUTO_INCREMENT,
  `propertyID` int(10) NOT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`mediaID`) USING BTREE,
  INDEX `propertyID`(`propertyID`) USING BTREE,
  CONSTRAINT `media_ibfk_1` FOREIGN KEY (`propertyID`) REFERENCES `property` (`propertyID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of media
-- ----------------------------
INSERT INTO `media` VALUES (3, 2, 'video', 'http://example.com/properties/2/video1.mp4');
INSERT INTO `media` VALUES (4, 4, 'image', 'http://example.com/image1.jpg');
INSERT INTO `media` VALUES (5, 4, 'image', 'http://example.com/image2.jpg');
INSERT INTO `media` VALUES (6, 4, 'image', 'http://example.com/image3.jpg');
INSERT INTO `media` VALUES (7, 4, 'video', 'http://example.com/video.mp4');
INSERT INTO `media` VALUES (8, 5, 'image', 'http://example.com/image4.jpg');
INSERT INTO `media` VALUES (9, 5, 'image', 'http://example.com/image5.jpg');
INSERT INTO `media` VALUES (10, 5, 'image', 'http://example.com/image6.jpg');
INSERT INTO `media` VALUES (11, 5, 'video', 'http://example.com/video.mp5');
INSERT INTO `media` VALUES (12, 1, 'image', 'http://example.com/properties/1/new_image1.jpg');
INSERT INTO `media` VALUES (13, 1, 'image', 'http://example.com/properties/1/new_image2.jpg');
INSERT INTO `media` VALUES (14, 1, 'image', 'http://example.com/properties/1/new_image3.jpg');
INSERT INTO `media` VALUES (15, 1, 'video', 'http://example.com/properties/1/new_video.mp4');

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property`  (
  `propertyID` int(10) NOT NULL AUTO_INCREMENT,
  `userID` int(10) NOT NULL,
  `locationID` int(10) NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` float(10, 2) NOT NULL,
  `agent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`propertyID`) USING BTREE,
  INDEX `userID`(`userID`) USING BTREE,
  INDEX `locationID`(`locationID`) USING BTREE,
  CONSTRAINT `property_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `property_ibfk_2` FOREIGN KEY (`locationID`) REFERENCES `location` (`locationID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of property
-- ----------------------------
INSERT INTO `property` VALUES (1, 1, 1, 'Updated description', NULL, NULL, 'Updated Title', 2600000.00, NULL);
INSERT INTO `property` VALUES (2, 1, 2, 'Historic colonial-style house located in the heart of the city', 'house', '3000 sqft', 'Historic colonial-style house located in the heart of the city', 45777.00, NULL);
INSERT INTO `property` VALUES (3, 2, 3, 'Modern studio apartment in a prestigious Orchard Road skyscraper', 'studio', '550 sqft', 'Modern studio apartment in a prestigious Orchard Road skyscraper', 56666.00, NULL);
INSERT INTO `property` VALUES (4, 6, 4, 'A luxurious apartment in the heart of the city.', NULL, NULL, 'Luxurious Apartment', 2500000.00, NULL);
INSERT INTO `property` VALUES (5, 6, 5, 'An another luxurious apartment in the heart of the city.', 'HDB', '22000', 'Luxurious Apartment 2', 2600000.00, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleID` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`roleID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'Admin');
INSERT INTO `role` VALUES (2, 'Data Analyst');
INSERT INTO `role` VALUES (3, 'Seller');
INSERT INTO `role` VALUES (4, 'Buyer');

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`  (
  `transactionID` int(10) NOT NULL AUTO_INCREMENT,
  `propertyID` int(10) NOT NULL,
  `date` date NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`transactionID`) USING BTREE,
  INDEX `propertyID`(`propertyID`) USING BTREE,
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`propertyID`) REFERENCES `property` (`propertyID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transaction
-- ----------------------------
INSERT INTO `transaction` VALUES (1, 1, '2023-01-15', 2500000);
INSERT INTO `transaction` VALUES (2, 2, '2023-02-20', 4700000);
INSERT INTO `transaction` VALUES (3, 3, '2023-03-05', 950000);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '12345678',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `profile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`userID`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Alice Smith', 'alice.smith@example.com', 'encrypted_password1', '', '');
INSERT INTO `user` VALUES (2, 'Bob Johnson', 'bob.johnson@example.com', 'encrypted_password2', '', '');
INSERT INTO `user` VALUES (3, 'Carol White', 'carol.white@example.com', 'encrypted_password3', '', '');
INSERT INTO `user` VALUES (5, 'John Doe', 'john.doe@example.com', 'password123', '', '');
INSERT INTO `user` VALUES (6, 'testSeller', 'testSeller@qq.com', 'testSeller', '84573890', 'http://example.com/testSeller.jpg');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `userID` int(11) NOT NULL,
  `roleID` int(11) NOT NULL,
  PRIMARY KEY (`userID`, `roleID`) USING BTREE,
  INDEX `roleID`(`roleID`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`roleID`) REFERENCES `role` (`roleID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (5, 1);
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (2, 3);
INSERT INTO `user_role` VALUES (6, 3);
INSERT INTO `user_role` VALUES (3, 4);

SET FOREIGN_KEY_CHECKS = 1;
