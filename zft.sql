/*
 Navicat Premium Data Transfer

 Source Server         : mydb
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : zft

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 13/04/2023 23:01:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_table
-- ----------------------------
DROP TABLE IF EXISTS `account_table`;
CREATE TABLE `account_table`  (
  `account_id` bigint NOT NULL AUTO_INCREMENT COMMENT '账号ID',
  `account_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账号名',
  `account_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账号密码',
  `account_tenant_id` bigint NULL DEFAULT NULL COMMENT '账号所属诊所 ',
  PRIMARY KEY (`account_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1641791096919019523 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '账户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_table
-- ----------------------------
INSERT INTO `account_table` VALUES (1641791096919019522, '姜昊波', '123456', 1641791096919019522);
INSERT INTO `account_table` VALUES (1641791096919019523, '张医生', '123456', 1641791096919019522);

-- ----------------------------
-- Table structure for advice_table
-- ----------------------------
DROP TABLE IF EXISTS `advice_table`;
CREATE TABLE `advice_table`  (
  `advice_id` bigint NOT NULL AUTO_INCREMENT COMMENT '病历ID',
  `advice_prescrition_id` bigint NULL DEFAULT NULL COMMENT '病历所属处方ID',
  `advice_patient_id` bigint NULL DEFAULT NULL COMMENT '患者ID',
  `advice_time` datetime NOT NULL COMMENT '就诊时间',
  `advice_chief` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主诉',
  `advice_present_history` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '现病史',
  `advice_past_history` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '既往史',
  `advice_genetic_history` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '遗传史',
  `advice_marry_history` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '婚育史',
  `advice_temperature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '体温',
  `advice_high_pressure` int NULL DEFAULT NULL COMMENT '血压（高压）',
  `advice_low_pressure` int NULL DEFAULT NULL COMMENT '血压（低压）',
  `advice_heart_rate` int NULL DEFAULT NULL COMMENT '心率',
  `advice_description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述症状',
  `advice_diagnosis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '诊断',
  `advice_treatment_method` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '治法',
  `advice_tenant_id` bigint NULL DEFAULT NULL COMMENT '医嘱所属诊所',
  PRIMARY KEY (`advice_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '医嘱表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advice_table
-- ----------------------------

-- ----------------------------
-- Table structure for charge_detail_table
-- ----------------------------
DROP TABLE IF EXISTS `charge_detail_table`;
CREATE TABLE `charge_detail_table`  (
  `charge_detail_id` bigint NOT NULL AUTO_INCREMENT COMMENT '收费单明细ID',
  `charge_id` bigint NULL DEFAULT NULL COMMENT '所属收费单ID',
  `charge_commodity_id` bigint NULL DEFAULT NULL COMMENT '收费单商品ID',
  `charge_commodity_large` int NULL DEFAULT NULL COMMENT '收费单商品数量（大）',
  `charge_commodity_small` int NULL DEFAULT NULL COMMENT '收费单商品数量（小）',
  PRIMARY KEY (`charge_detail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '收费单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of charge_detail_table
-- ----------------------------

-- ----------------------------
-- Table structure for charge_table
-- ----------------------------
DROP TABLE IF EXISTS `charge_table`;
CREATE TABLE `charge_table`  (
  `charge_id` bigint NOT NULL AUTO_INCREMENT COMMENT '收费单主表ID',
  `charge_patient_id` bigint NULL DEFAULT NULL COMMENT '收费单患者ID',
  `charge_money` int NULL DEFAULT NULL COMMENT '收费单总金额',
  `charge_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收费单状态',
  `charge_time` datetime NULL DEFAULT NULL COMMENT '收费时间',
  `charge_tenant_id` bigint NULL DEFAULT NULL COMMENT '收费单所属诊所',
  PRIMARY KEY (`charge_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '收费单主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of charge_table
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_table
-- ----------------------------
DROP TABLE IF EXISTS `commodity_table`;
CREATE TABLE `commodity_table`  (
  `commodity_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `commodity_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `commodity_country_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品国家编码',
  `commodity_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品类别',
  `commodity_bar_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品条码',
  `commodity_approval_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品批准文号',
  `commodity_manufacturer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品生产厂家',
  `commodity_specification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品规格',
  `commodity_large_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品单位（大）',
  `commodity_small_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品单位（小）',
  `commodity_large_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品定价（大）',
  `commodity_small_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品定价（小）',
  `commodity_dosage_form` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品大小转换比',
  `commodity_form_drug` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品剂型',
  `commodity_dosage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品剂量',
  `commodity_dosage_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品剂量单位',
  `commodity_take` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品服用方式',
  `commodity_usage_frequency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品服用频率',
  `commodity_single_dose` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品单次服用剂量',
  `commodity_split_sale_status` tinyint NULL DEFAULT 0 COMMENT '商品是否拆零销售',
  `commodity_enable_status` int NULL DEFAULT 0 COMMENT '商品使用状态',
  `commodity_tenant_id` bigint NULL DEFAULT NULL COMMENT '商品所属诊所',
  PRIMARY KEY (`commodity_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1644009378006732801 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity_table
-- ----------------------------
INSERT INTO `commodity_table` VALUES (1642192710309842945, '测试药品5', 'GF42342343242342', '保健药品', '3214234534564', '456456456546', '四川正泰集团', '20颗一瓶', '瓶', '颗', 10.00, 0.00, '20', '固体剂型', '10', 'g', '饭后服', '一天三次', '10', 1, 1, 1641791096919019522);
INSERT INTO `commodity_table` VALUES (1642193213408153601, '测试药品2', '', '中西成药', '', '', '', '', '盒', '颗', 0.00, 0.00, NULL, '液体剂型', '', 'mg', '空腹服', '一天一次', '', 0, 1, 1641791096919019522);
INSERT INTO `commodity_table` VALUES (1642196023604420610, '测试药品3', 'dsadadasds', '中西成药', 'qweqweq', 'weqweqwewe', '', 'weqewewe', '盒', '颗', 12.00, 2.00, '2', '液体剂型', '12', 'mg', '空腹服', '一天一次', '12', 1, 1, 1641791096919019522);
INSERT INTO `commodity_table` VALUES (1642197849846398977, '测试药品4', '', '中西成药', '', '', '', '', '盒', '颗', 0.00, 0.00, NULL, '液体剂型', '', 'mg', '空腹服', '一天一次', '', 0, 1, 1641791096919019522);
INSERT INTO `commodity_table` VALUES (1644009378006732801, '测试药品6', '323123', '中西成药', '', '', '少打多撒', '', '盒', '颗', 12.00, 2.00, '12', '液体剂型', '', 'mg', '空腹服', '一天一次', '', 1, 1, 1641791096919019522);

-- ----------------------------
-- Table structure for department_table
-- ----------------------------
DROP TABLE IF EXISTS `department_table`;
CREATE TABLE `department_table`  (
  `department_id` bigint NOT NULL AUTO_INCREMENT COMMENT '科室ID',
  `department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '科室名称',
  `department_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '科室类别',
  `department_rate` int NULL DEFAULT NULL COMMENT '科室评级',
  `department_inteoduce` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '科室介绍',
  `department_employee_num` int NULL DEFAULT NULL COMMENT '科室人数',
  `department_tenant_id` bigint NULL DEFAULT NULL COMMENT '科室所属诊所',
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '科室表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department_table
-- ----------------------------

-- ----------------------------
-- Table structure for employee_table
-- ----------------------------
DROP TABLE IF EXISTS `employee_table`;
CREATE TABLE `employee_table`  (
  `employee_id` bigint NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `employee_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工性别',
  `employee_birthday` datetime NULL DEFAULT NULL COMMENT '员工生日',
  `employee_sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工性别',
  `employee_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工电话',
  `employee_position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工职位',
  `employee_account_id` int NULL DEFAULT NULL COMMENT '员工账号',
  `employee_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工头像',
  `employee_id_number` int NULL DEFAULT NULL COMMENT '员工身份证号',
  `employee_department_id` int NULL DEFAULT NULL COMMENT '员工所属科室ID',
  `employee_department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工所属科室名字',
  `employee_introduce` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '员工介绍',
  `employee_tenant_id` bigint NULL DEFAULT NULL COMMENT '员工ID',
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_table
-- ----------------------------

-- ----------------------------
-- Table structure for inventory_check_detail_table
-- ----------------------------
DROP TABLE IF EXISTS `inventory_check_detail_table`;
CREATE TABLE `inventory_check_detail_table`  (
  `inventory_check_detail_id` bigint NOT NULL AUTO_INCREMENT COMMENT '盘点单明细ID',
  `inventory_check_id` bigint NULL DEFAULT NULL COMMENT '盘点单主表ID',
  `inventory_check_commodity_id` bigint NULL DEFAULT NULL COMMENT '商品ID',
  `inventory_check_commodity_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `inventory_check_large_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品库存单位（大）',
  `inventory_check_small_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品库存单位（小）',
  `inventory_check_before_large_num` int NULL DEFAULT NULL COMMENT '商品盘点前数量（大）',
  `inventory_check_before_small_num` int NULL DEFAULT NULL COMMENT '商品盘点前数量（小）',
  `inventory_check_after_large_num` int NULL DEFAULT NULL COMMENT '商品盘点后数量（大）',
  `inventory_check_after_small_num` int NULL DEFAULT NULL COMMENT '商品盘点后数量（小）',
  `inventory_check_large_num` int NULL DEFAULT NULL COMMENT '商品盘点数量（大）',
  `inventory_check_small_num` int NULL DEFAULT NULL COMMENT '商品盘点数量（小）',
  PRIMARY KEY (`inventory_check_detail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '盘点单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory_check_detail_table
-- ----------------------------

-- ----------------------------
-- Table structure for inventory_check_table
-- ----------------------------
DROP TABLE IF EXISTS `inventory_check_table`;
CREATE TABLE `inventory_check_table`  (
  `inventory_check_id` bigint NOT NULL AUTO_INCREMENT COMMENT '盘点单ID',
  `inventory_check_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '盘点单状态',
  `inventory_check_time` datetime NULL DEFAULT NULL COMMENT '盘点时间',
  `inventory_check_create_time` datetime NULL DEFAULT NULL COMMENT '盘点单创建时间',
  `inventory_check_num` decimal(10, 2) NULL DEFAULT NULL COMMENT '盘点盈亏数量',
  `inventory_check_operator_id` bigint NULL DEFAULT NULL COMMENT '盘点人',
  `inventory_check_bid_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '盘点单盈亏金额-进价',
  `inventory_check_sale_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '盘点单盈亏金额-售价',
  `inventory_check_variety` int NULL DEFAULT NULL COMMENT '盘点品种数',
  `inventory_check_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '盘点单备注',
  `inventory_check_tenant_id` bigint NULL DEFAULT NULL COMMENT '盘点单所属诊所',
  PRIMARY KEY (`inventory_check_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '盘点单主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory_check_table
-- ----------------------------
INSERT INTO `inventory_check_table` VALUES (1642192710309942947, '待盘点', '2023-04-12 20:55:20', '2023-04-12 20:55:23', 3.00, 1641791096919019522, 32.00, -19.00, 2, '无', 1641791096919019522);

-- ----------------------------
-- Table structure for inventory_in_detail_table
-- ----------------------------
DROP TABLE IF EXISTS `inventory_in_detail_table`;
CREATE TABLE `inventory_in_detail_table`  (
  `inventory_in_detail_id` bigint NOT NULL AUTO_INCREMENT COMMENT '入库单明细ID',
  `inventory_in_id` bigint NULL DEFAULT NULL COMMENT '入库单主表ID',
  `inventory_in_commodity_id` bigint NULL DEFAULT NULL COMMENT '商品ID',
  `inventory_in_commodity_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `inventory_in_country_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品国家码',
  `inventory_in_large_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品库存单位（大）',
  `inventory_in_small_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品库存单位（小）',
  `inventory_in_before_large_num` int NULL DEFAULT NULL COMMENT '商品入库前数量（大）',
  `inventory_in_before_small_num` int NULL DEFAULT NULL COMMENT '商品入库前数量（小）',
  `inventory_in_after_large_num` int NULL DEFAULT NULL COMMENT '商品入库后数量（大）',
  `inventory_in_after_small_num` int NULL DEFAULT NULL COMMENT '商品入库后数量（小）',
  `inventory_in_large_num` int NULL DEFAULT NULL COMMENT '商品入库数量（大）',
  `inventory_in_small_num` int NULL DEFAULT NULL COMMENT '商品入库数量（小）',
  PRIMARY KEY (`inventory_in_detail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '入库单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory_in_detail_table
-- ----------------------------
INSERT INTO `inventory_in_detail_table` VALUES (1642192710309842957, 1642192710309842947, 1642193213408153601, '测试药品2', NULL, '瓶', '颗', 0, 0, 1, 1, 1, 1);

-- ----------------------------
-- Table structure for inventory_in_table
-- ----------------------------
DROP TABLE IF EXISTS `inventory_in_table`;
CREATE TABLE `inventory_in_table`  (
  `inventory_in_id` bigint NOT NULL AUTO_INCREMENT COMMENT '入库单ID',
  `inventory_in_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入库单状态',
  `inventory_in_supplier_id` bigint NULL DEFAULT NULL COMMENT '入库单供应商ID',
  `inventory_in_variety` int NULL DEFAULT NULL COMMENT '入库品种数',
  `inventory_in_operator_id` bigint NULL DEFAULT NULL COMMENT '入库人',
  `inventory_in_time` datetime NULL DEFAULT NULL COMMENT '入库时间',
  `inventory_in_create_time` datetime NULL DEFAULT NULL COMMENT '入库单创建时间',
  `inventory_in_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '入库单金额',
  `inventory_in_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入库单备注',
  `inventory_in_tenant_id` bigint NULL DEFAULT NULL COMMENT '入库单所属诊所',
  PRIMARY KEY (`inventory_in_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1642192710309842947 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '入库单主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory_in_table
-- ----------------------------
INSERT INTO `inventory_in_table` VALUES (1642192710309842947, '待入库', 1642192710309842950, 1, 1641791096919019522, '2023-04-06 22:41:17', '2023-04-06 22:41:22', 12.32, '无特殊事项', 1641791096919019522);

-- ----------------------------
-- Table structure for inventory_out_detail_table
-- ----------------------------
DROP TABLE IF EXISTS `inventory_out_detail_table`;
CREATE TABLE `inventory_out_detail_table`  (
  `inventory_out_detail_id` bigint NOT NULL AUTO_INCREMENT COMMENT '出库单明细ID',
  `inventory_out_id` bigint NULL DEFAULT NULL COMMENT '出库单主表ID',
  `inventory_out_commodity_id` bigint NULL DEFAULT NULL COMMENT '商品ID',
  `inventory_out_commodity_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `inventory_out_large_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品库存单位（大）',
  `inventory_out_small_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品库存单位（小）',
  `inventory_out_before_large_num` int NULL DEFAULT NULL COMMENT '商品出库前数量（大）',
  `inventory_out_before_small_num` int NULL DEFAULT NULL COMMENT '商品出库前数量（小）',
  `inventory_out_after_large_num` int NULL DEFAULT NULL COMMENT '商品出库后数量（大）',
  `inventory_out_after_small_num` int NULL DEFAULT NULL COMMENT '商品出库后数量（小）',
  `inventory_out_large_num` int NULL DEFAULT NULL COMMENT '商品出库数量（大）',
  `inventory_out_small_num` int NULL DEFAULT NULL COMMENT '商品出库数量（小）',
  PRIMARY KEY (`inventory_out_detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1642192710319852947 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '出库单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory_out_detail_table
-- ----------------------------
INSERT INTO `inventory_out_detail_table` VALUES (1642192710319852947, 1642192710319842947, 1642196023604420610, '测试药品5', '盒', '颗', 0, 0, 1, 1, 1, 1);

-- ----------------------------
-- Table structure for inventory_out_table
-- ----------------------------
DROP TABLE IF EXISTS `inventory_out_table`;
CREATE TABLE `inventory_out_table`  (
  `inventory_out_id` bigint NOT NULL AUTO_INCREMENT COMMENT '出库单ID',
  `inventory_out_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出库单状态',
  `inventory_out_operator_id` bigint NULL DEFAULT NULL COMMENT '出库人',
  `inventory_out_variety` int NULL DEFAULT NULL COMMENT '出库品种数',
  `inventory_out_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出库类型',
  `inventory_out_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '出库单金额',
  `inventory_out_time` datetime NOT NULL COMMENT '出库时间',
  `inventory_out_create_time` datetime NULL DEFAULT NULL COMMENT '出库单创建时间',
  `inventory_out_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出库单备注',
  `inventory_out_tenant_id` bigint NULL DEFAULT NULL COMMENT '出库单所属诊所',
  PRIMARY KEY (`inventory_out_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '出库单主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory_out_table
-- ----------------------------
INSERT INTO `inventory_out_table` VALUES (1642192710319842947, '待出库', 1641791096919019522, 1, '领料出库', 16.33, '2023-04-09 21:56:52', '2023-04-08 21:56:55', NULL, 1641791096919019522);

-- ----------------------------
-- Table structure for inventory_table
-- ----------------------------
DROP TABLE IF EXISTS `inventory_table`;
CREATE TABLE `inventory_table`  (
  `inventory_id` bigint NOT NULL AUTO_INCREMENT COMMENT '库存ID',
  `inventory_commodity_id` bigint NULL DEFAULT NULL COMMENT '商品ID',
  `inventory_commodity_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `inventory_large_num` int NULL DEFAULT 0 COMMENT '商品库存数量（大）',
  `inventory_large_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品库存单位（大）',
  `inventory_small_num` int NULL DEFAULT 0 COMMENT '商品库存数量（小）',
  `inventory_small_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品库存单位（小）',
  `inventory_tenant_id` bigint NULL DEFAULT NULL COMMENT '商品所属诊所',
  PRIMARY KEY (`inventory_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1644009378119979009 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory_table
-- ----------------------------
INSERT INTO `inventory_table` VALUES (1642192710309842947, 1642192710309842945, '测试药品5', 0, '瓶', 0, '颗', 1641791096919019522);
INSERT INTO `inventory_table` VALUES (1642192710309842990, 1642193213408153601, '测试药品2', 0, '盒', 0, '颗', 1641791096919019522);
INSERT INTO `inventory_table` VALUES (1642192710309843222, 1642196023604420610, '测试药品3', 0, '盒', 0, '颗', 1641791096919019522);
INSERT INTO `inventory_table` VALUES (1642192710309843555, 1642197849846398977, '测试药品4', 0, '盒', 0, '颗', 1641791096919019522);
INSERT INTO `inventory_table` VALUES (1644009378119979009, 1644009378006732801, '测试药品6', 0, '盒', 0, '颗', 1641791096919019522);

-- ----------------------------
-- Table structure for patient_table
-- ----------------------------
DROP TABLE IF EXISTS `patient_table`;
CREATE TABLE `patient_table`  (
  `patient_id` bigint NOT NULL AUTO_INCREMENT COMMENT '患者ID',
  `patient_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '患者姓名',
  `patient_sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '患者性别',
  `patient_birthday` datetime NULL DEFAULT NULL COMMENT '患者生日',
  `patient_phone` int NULL DEFAULT NULL COMMENT '患者手机号',
  `patient_medical_number` int NULL DEFAULT NULL COMMENT '患者医保号',
  `patient_medical_balance` int NULL DEFAULT NULL COMMENT '患者医保余额',
  `patient_id_number` int NULL DEFAULT NULL COMMENT '患者身份证号',
  `patient_disease` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '患者所患疾病',
  `patient_department_id` int NULL DEFAULT NULL COMMENT '患者所属科室ID',
  `patient_department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '患者所属科室名字',
  `patient_time` datetime NULL DEFAULT NULL COMMENT '患者就诊时间',
  `patient_tenant_id` bigint NULL DEFAULT NULL COMMENT '患者所属诊所',
  PRIMARY KEY (`patient_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '患者表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient_table
-- ----------------------------

-- ----------------------------
-- Table structure for pay_dict_table
-- ----------------------------
DROP TABLE IF EXISTS `pay_dict_table`;
CREATE TABLE `pay_dict_table`  (
  `pay_id` bigint NOT NULL AUTO_INCREMENT COMMENT '支付方式ID',
  `pay_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支付名称',
  PRIMARY KEY (`pay_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '支付字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_dict_table
-- ----------------------------

-- ----------------------------
-- Table structure for prescription_detail_table
-- ----------------------------
DROP TABLE IF EXISTS `prescription_detail_table`;
CREATE TABLE `prescription_detail_table`  (
  `prescription_detail_id` bigint NOT NULL AUTO_INCREMENT COMMENT '处方明细ID',
  `prescription_id` bigint NULL DEFAULT NULL COMMENT '处方主表ID',
  `prescription_commodity_id` bigint NULL DEFAULT NULL COMMENT '处方药品ID',
  `prescription_dosage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处方药品用法',
  `prescription_total_large` int NULL DEFAULT NULL COMMENT '处方药品总量（大单位）',
  `prescription_total_small` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处方药品总量（小单位）',
  PRIMARY KEY (`prescription_detail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '处方明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescription_detail_table
-- ----------------------------

-- ----------------------------
-- Table structure for prescription_table
-- ----------------------------
DROP TABLE IF EXISTS `prescription_table`;
CREATE TABLE `prescription_table`  (
  `prescription_id` bigint NOT NULL AUTO_INCREMENT COMMENT '处方ID',
  `prescription_advice_id` bigint NULL DEFAULT NULL COMMENT '处方所属病历ID',
  `prescription_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处方类别',
  `prescription_order` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '处方医嘱',
  `prescription_time` datetime NULL DEFAULT NULL COMMENT '处方开设时间',
  `prescription_doctor_id` bigint NULL DEFAULT NULL COMMENT '处方开设医生ID',
  `prescription_doctor_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处方开设医生名字',
  `prescription_patient_id` bigint NULL DEFAULT NULL COMMENT '处方所属患者ID',
  `prescription_patient_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处方所属患者名字',
  `prescription_tenant_id` bigint NULL DEFAULT NULL COMMENT '处方所属诊所',
  PRIMARY KEY (`prescription_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '处方主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescription_table
-- ----------------------------

-- ----------------------------
-- Table structure for supplier_table
-- ----------------------------
DROP TABLE IF EXISTS `supplier_table`;
CREATE TABLE `supplier_table`  (
  `supplier_id` bigint NOT NULL COMMENT '供应商ID',
  `supplier_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `supplier_status` int NULL DEFAULT NULL COMMENT '供应商启用状态',
  `supplier_tenant_id` bigint NULL DEFAULT NULL COMMENT '供应商所属诊所',
  PRIMARY KEY (`supplier_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier_table
-- ----------------------------
INSERT INTO `supplier_table` VALUES (1642192710309842950, '朝阳供应商', 1, 1641791096919019522);
INSERT INTO `supplier_table` VALUES (1642192710309843000, '测试供应商', 1, 1641791096919019522);

-- ----------------------------
-- Table structure for symptom_dict_table
-- ----------------------------
DROP TABLE IF EXISTS `symptom_dict_table`;
CREATE TABLE `symptom_dict_table`  (
  `symptom_id` bigint NOT NULL AUTO_INCREMENT COMMENT '症状ID',
  `symptom_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '症状名字',
  PRIMARY KEY (`symptom_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '症状字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of symptom_dict_table
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_table
-- ----------------------------
DROP TABLE IF EXISTS `tenant_table`;
CREATE TABLE `tenant_table`  (
  `tenant_id` bigint NOT NULL AUTO_INCREMENT COMMENT '诊所ID',
  `tenant_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '诊所名称',
  `tenant_country_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '诊所国家码',
  `tenant_area_province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '诊所所在地区（省级）',
  `tenant_area_urban` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '诊所所在地区（市级）',
  `tenant_area_county` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '诊所所在地区（县级）',
  `tenant_rate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '诊所等级',
  `tenant_begin_time` datetime NULL DEFAULT NULL COMMENT '诊所开设时间',
  `tenant_introduce` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '诊所介绍',
  PRIMARY KEY (`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1641791096919019522 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '诊所表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_table
-- ----------------------------
INSERT INTO `tenant_table` VALUES (1641791096919019522, '成都大学诊所', 'H51010400330', '四川', '成都', '龙泉驿', '4', '2023-02-01 20:33:54', '成都大学诊所是由中国成都大学设立的一家全科医疗机构，拥有一流的医疗设施，提供各类诊疗服务，包括常见病的诊断和治疗、小儿科、内科、外科、妇产科、眼科、耳鼻喉科、康复护理等，并且拥有完善的紧急救护和重症监护功能。');

-- ----------------------------
-- Table structure for visit_table
-- ----------------------------
DROP TABLE IF EXISTS `visit_table`;
CREATE TABLE `visit_table`  (
  `visit_id` bigint NOT NULL AUTO_INCREMENT COMMENT '就诊ID',
  `visit_patient_id` bigint NULL DEFAULT NULL COMMENT '就诊患者ID',
  `visit_patient_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '就诊患者姓名',
  `visit_time` datetime NULL DEFAULT NULL COMMENT '就诊时间',
  `visit_symptom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '就诊症状',
  `visit_doctor_id` bigint NULL DEFAULT NULL COMMENT '就诊医生ID',
  `visit_doctor_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '就诊医生名称',
  `visit_tenant_id` bigint NULL DEFAULT NULL COMMENT '就诊所属诊所',
  PRIMARY KEY (`visit_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '就诊表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of visit_table
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
