package com.springboottemplate.mapper;

import com.springboottemplate.pojo.TableTestDO;

import java.util.List;

/**
 * @author 唐涛
 * @description: TableTestMapper   主要测试表字段与do字段的关系
 * @date 2021/5/28 14:47
 */
public interface TableTestMapper {
    List<TableTestDO> findAll();

}
/*
 /*
 Navicat Premium Data Transfer

 Source Server         : 118.31.55.236
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 28/05/2021 14:20:14
*/
//
//    SET NAMES utf8mb4;
//        SET FOREIGN_KEY_CHECKS = 0;
//
//        -- ----------------------------
//        -- Table structure for tableTest
//        -- ----------------------------
//        DROP TABLE IF EXISTS `tableTest`;
//        CREATE TABLE `tableTest`  (
//        `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
//        `sid` bigint NULL DEFAULT NULL COMMENT '学号',
//        `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
//        `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
//        `age` bigint NULL DEFAULT NULL COMMENT '年纪',
//        `job` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作',
//        `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
//        `birthday` timestamp NULL DEFAULT NULL,
//        PRIMARY KEY (`id`) USING BTREE,
//        UNIQUE INDEX `phone_index`(`phone`) USING BTREE,
//        INDEX `name_index`(`name`) USING BTREE,
//        INDEX `sid_index`(`sid`) USING BTREE
//        ) ENGINE = InnoDB AUTO_INCREMENT = 605 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
//
//        -- ----------------------------
//        -- Records of tableTest
//        -- ----------------------------
//        INSERT INTO `tableTest` VALUES (404, 541513140101, '琴咏', 'm', 22, '开发', '13701203416', '2021-06-01 11:49:06');
//        INSERT INTO `tableTest` VALUES (405, 541513140102, '禹瑾', 'f', 22, '开发', '15502027280', '2021-05-28 11:49:16');
//        INSERT INTO `tableTest` VALUES (406, 541513140103, '呼旭', 'f', 22, '开发', '13005838429', NULL);
//        INSERT INTO `tableTest` VALUES (407, 541513140104, '钮月荷', 'm', 22, '开发', '13702172362', NULL);
//        INSERT INTO `tableTest` VALUES (408, 541513140105, '伊涛', 'f', 24, '开发', '13804171317', NULL);
//        INSERT INTO `tableTest` VALUES (409, 541513140106, '彭翰', 'f', 27, '产品', '15808778567', NULL);
//        INSERT INTO `tableTest` VALUES (410, 541513140107, '凤翰', 'm', 22, '需求', '15202081152', NULL);
//        INSERT INTO `tableTest` VALUES (411, 541513140108, '缪姬姣', 'f', 22, '测试', '15703068493', NULL);
//        INSERT INTO `tableTest` VALUES (412, 541513140109, '冉彩蕊', 'f', 24, '开发', '15604133843', NULL);
//        INSERT INTO `tableTest` VALUES (413, 541513140110, '魏仁岩', 'm', 24, '开发', '13101369067', NULL);
//        INSERT INTO `tableTest` VALUES (414, 541513140111, '印爱', 'f', 22, '产品', '15601162302', NULL);
//        INSERT INTO `tableTest` VALUES (415, 541513140112, '高致', 'f', 22, '开发', '13403266823', NULL);
//        INSERT INTO `tableTest` VALUES (416, 541513140113, '田以', 'm', 24, '开发', '13800155038', NULL);
//        INSERT INTO `tableTest` VALUES (417, 541513140114, '太盛先', 'f', 24, '开发', '15706379054', NULL);
//        INSERT INTO `tableTest` VALUES (418, 541513140115, '习芸珍', 'f', 19, '测试', '15004846019', NULL);
//        INSERT INTO `tableTest` VALUES (419, 541513140116, '巩新', 'm', 22, '产品', '13806712216', NULL);
//        INSERT INTO `tableTest` VALUES (420, 541513140117, '蓟文岩', 'f', 24, '开发', '15001408599', NULL);
//        INSERT INTO `tableTest` VALUES (421, 541513140118, '鄢晨安', 'f', 24, '开发', '15200936299', NULL);
//        INSERT INTO `tableTest` VALUES (422, 541513140119, '郭岩', 'm', 19, '需求', '15705794720', NULL);
//        INSERT INTO `tableTest` VALUES (423, 541513140120, '益强', 'f', 19, '开发', '15805980631', NULL);
//        INSERT INTO `tableTest` VALUES (424, 541513140121, '方清', 'f', 21, '开发', '13101852790', NULL);
//        INSERT INTO `tableTest` VALUES (425, 541513140122, '台蓓育', 'm', 11, '测试', '15902949085', NULL);
//        INSERT INTO `tableTest` VALUES (426, 541513140123, '包敬承', 'f', 11, '开发', '13000646063', NULL);
//        INSERT INTO `tableTest` VALUES (427, 541513140124, '佘龙', 'f', 11, '开发', '13601092625', NULL);
//        INSERT INTO `tableTest` VALUES (428, 541513140125, '年辉', 'm', 13, '开发', '15000192788', NULL);
//        INSERT INTO `tableTest` VALUES (429, 541513140126, '爱翠悦', 'f', 16, '产品', '15307568599', NULL);
//        INSERT INTO `tableTest` VALUES (430, 541513140127, '胥良风', 'f', 16, '开发', '15605235165', NULL);
//        INSERT INTO `tableTest` VALUES (431, 541513140128, '终心', 'm', 16, '开发', '15600864126', NULL);
//        INSERT INTO `tableTest` VALUES (432, 541513140129, '严盛', 'f', 18, '开发', '13408823401', NULL);
//        INSERT INTO `tableTest` VALUES (433, 541513140130, '闵和', 'f', 18, '开发', '13903555084', NULL);
//        INSERT INTO `tableTest` VALUES (434, 541513140131, '能岩伦', 'm', 21, '产品', '13106048885', NULL);
//        INSERT INTO `tableTest` VALUES (435, 541513140132, '尹先', 'f', 21, '开发', '13202390628', NULL);
//        INSERT INTO `tableTest` VALUES (436, 541513140133, '牟娅', 'f', 23, '开发', '13101617688', NULL);
//        INSERT INTO `tableTest` VALUES (437, 541513140134, '慕薇', 'm', 23, '开发', '13804157068', NULL);
//        INSERT INTO `tableTest` VALUES (438, 541513140135, '庚晶霭', 'f', 23, '开发', '13803253558', NULL);
//        INSERT INTO `tableTest` VALUES (439, 541513140136, '司伊', 'f', 21, '产品', '15007616443', NULL);
//        INSERT INTO `tableTest` VALUES (440, 541513140137, '暨颖昭', 'm', 23, '开发', '13002528364', NULL);
//        INSERT INTO `tableTest` VALUES (441, 541513140138, '耿涛轮', 'f', 23, '开发', '15207673647', NULL);
//        INSERT INTO `tableTest` VALUES (442, 541513140139, '管竹菊', 'f', 23, '开发', '13606771504', NULL);
//        INSERT INTO `tableTest` VALUES (443, 541513140140, '于霭', 'm', 23, '开发', '13701736872', NULL);
//        INSERT INTO `tableTest` VALUES (444, 541513140141, '段兰育', 'f', 20, '开发', '15207363496', NULL);
//        INSERT INTO `tableTest` VALUES (445, 541513140142, '祝若志', 'f', 20, '开发', '15207188537', NULL);
//        INSERT INTO `tableTest` VALUES (446, 541513140143, '都文天', 'm', 20, '需求', '15601609050', NULL);
//        INSERT INTO `tableTest` VALUES (447, 541513140144, '文顺', 'f', 20, '开发', '13102363583', NULL);
//        INSERT INTO `tableTest` VALUES (448, 541513140145, '籍信', 'f', 22, '开发', '13703530931', NULL);
//        INSERT INTO `tableTest` VALUES (449, 541513140146, '邢固', 'm', 20, '产品', '13100533532', NULL);
//        INSERT INTO `tableTest` VALUES (450, 541513140147, '续成', 'f', 20, '开发', '13105470341', NULL);
//        INSERT INTO `tableTest` VALUES (451, 541513140148, '娄琼露', 'f', 20, '开发', '15807730491', NULL);
//        INSERT INTO `tableTest` VALUES (452, 541513140149, '亢平贵', 'm', 22, '开发', '13601790577', NULL);
//        INSERT INTO `tableTest` VALUES (453, 541513140150, '鲍江', 'f', 22, '测试', '13405900442', NULL);
//        INSERT INTO `tableTest` VALUES (454, 541513140151, '敖青', 'f', 20, '产品', '15508581876', NULL);
//        INSERT INTO `tableTest` VALUES (455, 541513140152, '仲榕', 'm', 20, '开发', '13205765815', NULL);
//        INSERT INTO `tableTest` VALUES (456, 541513140153, '孙姣', 'f', 22, '开发', '15903748656', NULL);
//        INSERT INTO `tableTest` VALUES (457, 541513140154, '续凡', 'f', 22, '开发', '15805115080', NULL);
//        INSERT INTO `tableTest` VALUES (458, 541513140155, '司瑶玲', 'm', 22, '需求', '13803560273', NULL);
//        INSERT INTO `tableTest` VALUES (459, 541513140156, '韦龙钧', 'f', 20, '产品', '13203751522', NULL);
//        INSERT INTO `tableTest` VALUES (460, 541513140157, '政贵', 'f', 22, '开发', '13306138604', NULL);
//        INSERT INTO `tableTest` VALUES (461, 541513140158, '法岚倩', 'm', 22, '开发', '15908545053', NULL);
//        INSERT INTO `tableTest` VALUES (462, 541513140159, '百婵云', 'f', 22, '开发', '13408007150', NULL);
//        INSERT INTO `tableTest` VALUES (463, 541513140160, '薛豪兴', 'f', 22, '开发', '13700123121', NULL);
//        INSERT INTO `tableTest` VALUES (464, 541513140161, '於君', 'm', 24, '开发', '13103253487', NULL);
//        INSERT INTO `tableTest` VALUES (465, 541513140162, '夏嘉', 'f', 24, '开发', '15806450654', NULL);
//        INSERT INTO `tableTest` VALUES (466, 541513140163, '墨翔', 'f', 24, '开发', '15906544247', NULL);
//        INSERT INTO `tableTest` VALUES (467, 541513140164, '闾荣', 'm', 19, '测试', '15707822822', NULL);
//        INSERT INTO `tableTest` VALUES (468, 541513140165, '丘和振', 'f', 21, '开发', '13605131944', NULL);
//        INSERT INTO `tableTest` VALUES (469, 541513140166, '申滢珠', 'f', 24, '产品', '15704751668', NULL);
//        INSERT INTO `tableTest` VALUES (470, 541513140167, '令欢', 'm', 19, '需求', '15302317408', NULL);
//        INSERT INTO `tableTest` VALUES (471, 541513140168, '步晓', 'f', 19, '开发', '15201781144', NULL);
//        INSERT INTO `tableTest` VALUES (472, 541513140169, '田爽媛', 'f', 21, '开发', '13302305730', NULL);
//        INSERT INTO `tableTest` VALUES (473, 541513140170, '喻翠欢', 'm', 21, '开发', '15807924872', NULL);
//        INSERT INTO `tableTest` VALUES (474, 541513140171, '乐卿 ', 'f', 24, '产品', '15300484060', NULL);
//        INSERT INTO `tableTest` VALUES (475, 541513140172, '伏才星', 'f', 24, '开发', '15600338723', NULL);
//        INSERT INTO `tableTest` VALUES (476, 541513140173, '国悦育', 'm', 21, '开发', '13703740966', NULL);
//        INSERT INTO `tableTest` VALUES (477, 541513140174, '陆颖', 'f', 21, '开发', '15505128746', NULL);
//        INSERT INTO `tableTest` VALUES (478, 541513140175, '喻会茂', 'f', 21, '开发', '13900756404', NULL);
//        INSERT INTO `tableTest` VALUES (479, 541513140176, '左凤妹', 'm', 24, '产品', '15904598274', NULL);
//        INSERT INTO `tableTest` VALUES (480, 541513140177, '拓子', 'f', 21, '开发', '13301230880', NULL);
//        INSERT INTO `tableTest` VALUES (481, 541513140178, '戈和发', 'f', 21, '测试', '13105255092', NULL);
//        INSERT INTO `tableTest` VALUES (482, 541513140179, '乐冠兴', 'm', 16, '需求', '15601623846', NULL);
//        INSERT INTO `tableTest` VALUES (483, 541513140180, '闻邦', 'f', 16, '开发', '13100124036', NULL);
//        INSERT INTO `tableTest` VALUES (484, 541513140181, '邢俊力', 'f', 18, '开发', '13106861463', NULL);
//        INSERT INTO `tableTest` VALUES (485, 541513140182, '游环', 'm', 18, '开发', '15207703751', NULL);
//        INSERT INTO `tableTest` VALUES (486, 541513140183, '边德榕', 'f', 18, '开发', '13102685647', NULL);
//        INSERT INTO `tableTest` VALUES (487, 541513140184, '归元', 'f', 18, '开发', '15208814424', NULL);
//        INSERT INTO `tableTest` VALUES (488, 541513140185, '葛雁', 'm', 20, '开发', '13303926821', NULL);
//        INSERT INTO `tableTest` VALUES (489, 541513140186, '戴寒荣', 'f', 23, '产品', '13207152098', NULL);
//        INSERT INTO `tableTest` VALUES (490, 541513140187, '柏玲薇', 'f', 23, '开发', '13500976376', NULL);
//        INSERT INTO `tableTest` VALUES (491, 541513140188, '戈言辰', 'm', 23, '开发', '13104786055', NULL);
//        INSERT INTO `tableTest` VALUES (492, 541513140189, '段会', 'f', 20, '开发', '13506718266', NULL);
//        INSERT INTO `tableTest` VALUES (493, 541513140190, '年仁', 'f', 20, '开发', '15007184675', NULL);
//        INSERT INTO `tableTest` VALUES (494, 541513140191, '厍翠娟', 'm', 23, '产品', '13802388440', NULL);
//        INSERT INTO `tableTest` VALUES (495, 541513140192, '百瑗君', 'f', 18, '测试', '13705756187', NULL);
//        INSERT INTO `tableTest` VALUES (496, 541513140193, '鲁亚叶', 'f', 20, '开发', '13007268495', NULL);
//        INSERT INTO `tableTest` VALUES (497, 541513140194, '尚琼', 'm', 20, '开发', '15902487956', NULL);
//        INSERT INTO `tableTest` VALUES (498, 541513140195, '卢咏', 'f', 20, '开发', '15103568249', NULL);
//        INSERT INTO `tableTest` VALUES (499, 541513140196, '秋泽', 'f', 23, '产品', '15200700959', NULL);
//        INSERT INTO `tableTest` VALUES (500, 541513140197, '贲诚', 'm', 20, '开发', '13107507939', NULL);
//        INSERT INTO `tableTest` VALUES (501, 541513140198, '郭心裕', 'f', 20, '开发', '15206278298', NULL);
//        INSERT INTO `tableTest` VALUES (502, 541513140199, '牟以腾', 'f', 15, '测试', '15505303189', NULL);
//        INSERT INTO `tableTest` VALUES (503, 541513140200, '融心', 'm', 15, '开发', '13502094829', NULL);
//        INSERT INTO `tableTest` VALUES (504, 541513140201, '羿永', 'f', 17, '开发', '13100738539', NULL);
//        INSERT INTO `tableTest` VALUES (505, 541513140202, '佟媛', 'f', 17, '开发', '15803893113', NULL);
//        INSERT INTO `tableTest` VALUES (506, 541513140203, '牟筠', 'm', 12, '需求', '15808615923', NULL);
//        INSERT INTO `tableTest` VALUES (507, 541513140204, '门杰', 'f', 12, '开发', '13505097322', NULL);
//        INSERT INTO `tableTest` VALUES (508, 541513140205, '牛奇振', 'f', 14, '开发', '15202718938', NULL);
//        INSERT INTO `tableTest` VALUES (509, 541513140206, '伊义河', 'm', 17, '产品', '15305152517', NULL);
//        INSERT INTO `tableTest` VALUES (510, 541513140207, '蒲竹君', 'f', 17, '开发', '13101846880', NULL);
//        INSERT INTO `tableTest` VALUES (511, 541513140208, '卫元和', 'f', 17, '开发', '13507912201', NULL);
//        INSERT INTO `tableTest` VALUES (512, 541513140209, '史枫', 'm', 19, '开发', '13500632603', NULL);
//        INSERT INTO `tableTest` VALUES (513, 541513140210, '毕晨子', 'f', 19, '开发', '13806901163', NULL);
//        INSERT INTO `tableTest` VALUES (514, 541513140211, '元韵', 'f', 22, '产品', '15104445243', NULL);
//        INSERT INTO `tableTest` VALUES (515, 541513140212, '晏勇力', 'm', 22, '开发', '13400032539', NULL);
//        INSERT INTO `tableTest` VALUES (516, 541513140213, '孟娥眉', 'f', 24, '开发', '15500982735', NULL);
//        INSERT INTO `tableTest` VALUES (517, 541513140214, '皮诚雄', 'f', 24, '开发', '13200194054', NULL);
//        INSERT INTO `tableTest` VALUES (518, 541513140215, '呼娴', 'm', 19, '需求', '13704565445', NULL);
//        INSERT INTO `tableTest` VALUES (519, 541513140216, '何波行', 'f', 22, '产品', '13508283368', NULL);
//        INSERT INTO `tableTest` VALUES (520, 541513140217, '巴珠', 'f', 24, '开发', '13706888182', NULL);
//        INSERT INTO `tableTest` VALUES (521, 541513140218, '澹辉仁', 'm', 24, '开发', '15906805404', NULL);
//        INSERT INTO `tableTest` VALUES (522, 541513140219, '亢凝勤', 'f', 24, '开发', '13003764528', NULL);
//        INSERT INTO `tableTest` VALUES (523, 541513140220, '鲜仁冠', 'f', 14, '测试', '15006128239', NULL);
//        INSERT INTO `tableTest` VALUES (524, 541513140221, '卜庆超', 'm', 16, '开发', '13607141464', NULL);
//        INSERT INTO `tableTest` VALUES (525, 541513140222, '公航有', 'f', 16, '开发', '13900770479', NULL);
//        INSERT INTO `tableTest` VALUES (526, 541513140223, '汤凡', 'f', 16, '开发', '15504456587', NULL);
//        INSERT INTO `tableTest` VALUES (527, 541513140224, '水芬', 'm', 16, '开发', '13708325254', NULL);
//        INSERT INTO `tableTest` VALUES (528, 541513140225, '鄢莎叶', 'f', 18, '开发', '15604885299', NULL);
//        INSERT INTO `tableTest` VALUES (529, 541513140226, '迟羽勤', 'f', 21, '产品', '13503300132', NULL);
//        INSERT INTO `tableTest` VALUES (530, 541513140227, '施娴寒', 'm', 16, '需求', '13307970735', NULL);
//        INSERT INTO `tableTest` VALUES (531, 541513140228, '甄亚春', 'f', 16, '开发', '13505940942', NULL);
//        INSERT INTO `tableTest` VALUES (532, 541513140229, '白有', 'f', 18, '开发', '13901167701', NULL);
//        INSERT INTO `tableTest` VALUES (533, 541513140230, '穆轮', 'm', 18, '开发', '15502841471', NULL);
//        INSERT INTO `tableTest` VALUES (534, 541513140231, '羿婉瑶', 'f', 21, '产品', '13907520389', NULL);
//        INSERT INTO `tableTest` VALUES (535, 541513140232, '殷斌', 'f', 21, '开发', '15001582649', NULL);
//        INSERT INTO `tableTest` VALUES (536, 541513140233, '缪诚裕', 'm', 23, '开发', '15005607507', NULL);
//        INSERT INTO `tableTest` VALUES (537, 541513140234, '聂荣', 'f', 13, '测试', '15101866966', NULL);
//        INSERT INTO `tableTest` VALUES (538, 541513140235, '齐红舒', 'f', 13, '开发', '15802320622', NULL);
//        INSERT INTO `tableTest` VALUES (539, 541513140236, '杜翔群', 'm', 16, '产品', '13708197282', NULL);
//        INSERT INTO `tableTest` VALUES (540, 541513140237, '孔杰健', 'f', 18, '开发', '15805822903', NULL);
//        INSERT INTO `tableTest` VALUES (541, 541513140238, '楚松承', 'f', 18, '开发', '13605885331', NULL);
//        INSERT INTO `tableTest` VALUES (542, 541513140239, '澹馥', 'm', 13, '需求', '13103025734', NULL);
//        INSERT INTO `tableTest` VALUES (543, 541513140240, '於杰', 'f', 13, '开发', '15704957406', NULL);
//        INSERT INTO `tableTest` VALUES (544, 541513140241, '鲍风士', 'f', 15, '开发', '15302928589', NULL);
//        INSERT INTO `tableTest` VALUES (545, 541513140242, '焦成俊', 'm', 15, '开发', '15007387804', NULL);
//        INSERT INTO `tableTest` VALUES (546, 541513140243, '笪裕', 'f', 15, '开发', '15504741538', NULL);
//        INSERT INTO `tableTest` VALUES (547, 541513140244, '葛宏鹏', 'f', 15, '开发', '15100425595', NULL);
//        INSERT INTO `tableTest` VALUES (548, 541513140245, '於岚婕', 'm', 17, '开发', '15007750168', NULL);
//        INSERT INTO `tableTest` VALUES (549, 541513140246, '益宁', 'f', 20, '产品', '13500494701', NULL);
//        INSERT INTO `tableTest` VALUES (550, 541513140247, '凌岚', 'f', 20, '开发', '15601221671', NULL);
//        INSERT INTO `tableTest` VALUES (551, 541513140248, '太安武', 'm', 10, '测试', '15707424600', NULL);
//        INSERT INTO `tableTest` VALUES (552, 541513140249, '孙东栋', 'f', 12, '开发', '15002493201', NULL);
//        INSERT INTO `tableTest` VALUES (553, 541513140250, '桂雄琛', 'f', 12, '开发', '13304141894', NULL);
//        INSERT INTO `tableTest` VALUES (554, 541513140251, '后菁', 'm', 15, '产品', '13005851063', NULL);
//        INSERT INTO `tableTest` VALUES (555, 541513140252, '木山龙', 'f', 15, '开发', '13807820896', NULL);
//        INSERT INTO `tableTest` VALUES (556, 541513140253, '怀叶勤', 'f', 17, '开发', '13504852175', NULL);
//        INSERT INTO `tableTest` VALUES (557, 541513140254, '闻芬柔', 'm', 17, '开发', '15107915631', NULL);
//        INSERT INTO `tableTest` VALUES (558, 541513140255, '平发', 'f', 22, '测试', '13002157705', NULL);
//        INSERT INTO `tableTest` VALUES (559, 541513140256, '夔达庆', 'f', 10, '产品', '13801080533', NULL);
//        INSERT INTO `tableTest` VALUES (560, 541513140257, '鄂宁', 'm', 12, '开发', '15204282910', NULL);
//        INSERT INTO `tableTest` VALUES (561, 541513140258, '辛超', 'f', 12, '开发', '13702017920', NULL);
//        INSERT INTO `tableTest` VALUES (562, 541513140259, '阎羽', 'f', 12, '开发', '15800797949', NULL);
//        INSERT INTO `tableTest` VALUES (563, 541513140260, '阙栋', 'm', 12, '开发', '13204960221', NULL);
//        INSERT INTO `tableTest` VALUES (564, 541513140261, '慕卿洁', 'f', 14, '开发', '15601853678', NULL);
//        INSERT INTO `tableTest` VALUES (565, 541513140262, '怀晓雁', 'f', 24, '测试', '15804116314', NULL);
//        INSERT INTO `tableTest` VALUES (566, 541513140263, '延全', 'm', 19, '需求', '13406608834', NULL);
//        INSERT INTO `tableTest` VALUES (567, 541513140264, '鱼涛', 'f', 19, '开发', '15200125340', NULL);
//        INSERT INTO `tableTest` VALUES (568, 541513140265, '单梁', 'f', 21, '开发', '13001232352', NULL);
//        INSERT INTO `tableTest` VALUES (569, 541513140266, '劳义贵', 'm', 24, '产品', '15500741197', NULL);
//        INSERT INTO `tableTest` VALUES (570, 541513140267, '汝贵庆', 'f', 24, '开发', '15805456891', NULL);
//        INSERT INTO `tableTest` VALUES (571, 541513140268, '艾进豪', 'f', 24, '开发', '15607511748', NULL);
//        INSERT INTO `tableTest` VALUES (572, 541513140269, '广全壮', 'm', 21, '开发', '13700182331', NULL);
//        INSERT INTO `tableTest` VALUES (573, 541513140270, '宁霭娴', 'f', 21, '开发', '13600347557', NULL);
//        INSERT INTO `tableTest` VALUES (574, 541513140271, '祝娟', 'f', 24, '产品', '15508065465', NULL);
//        INSERT INTO `tableTest` VALUES (575, 541513140272, '鞠奇', 'm', 24, '开发', '13905674019', NULL);
//        INSERT INTO `tableTest` VALUES (576, 541513140273, '弘馥纯', 'f', 11, '开发', '13300028089', NULL);
//        INSERT INTO `tableTest` VALUES (577, 541513140274, '太瑗舒', 'f', 11, '开发', '13802692796', NULL);
//        INSERT INTO `tableTest` VALUES (578, 541513140275, '赖诚', 'm', 21, '需求', '13001805097', NULL);
//        INSERT INTO `tableTest` VALUES (579, 541513140276, '柏滢', 'f', 24, '产品', '13805424803', NULL);
//        INSERT INTO `tableTest` VALUES (580, 541513140277, '滑欢', 'f', 11, '开发', '13904573602', NULL);
//        INSERT INTO `tableTest` VALUES (581, 541513140278, '仇义保', 'm', 11, '开发', '15804512992', NULL);
//        INSERT INTO `tableTest` VALUES (582, 541513140279, '黄宜', 'f', 11, '开发', '15204857077', NULL);
//        INSERT INTO `tableTest` VALUES (583, 541513140280, '郭中', 'f', 11, '开发', '13607850017', NULL);
//        INSERT INTO `tableTest` VALUES (584, 541513140281, '昌伊', 'm', 13, '开发', '13003468024', NULL);
//        INSERT INTO `tableTest` VALUES (585, 541513140282, '郭黛', 'f', 13, '开发', '15803701556', NULL);
//        INSERT INTO `tableTest` VALUES (586, 541513140283, '毋可', 'f', 23, '测试', '13302788454', NULL);
//        INSERT INTO `tableTest` VALUES (587, 541513140284, '贾元有', 'm', 23, '开发', '13503852706', NULL);
//        INSERT INTO `tableTest` VALUES (588, 541513140285, '司先', 'f', 20, '开发', '15304747607', NULL);
//        INSERT INTO `tableTest` VALUES (589, 541513140286, '汲山榕', 'f', 23, '产品', '13600014886', NULL);
//        INSERT INTO `tableTest` VALUES (590, 541513140287, '陶英', 'm', 23, '需求', '15604902106', NULL);
//        INSERT INTO `tableTest` VALUES (591, 541513140288, '任德学', 'f', 23, '开发', '13002253867', NULL);
//        INSERT INTO `tableTest` VALUES (592, 541513140289, '宓民庆', 'f', 20, '开发', '13502617042', NULL);
//        INSERT INTO `tableTest` VALUES (593, 541513140290, '孙厚昌', 'm', 15, '测试', '13405783610', NULL);
//        INSERT INTO `tableTest` VALUES (594, 541513140291, '鄢璐娥', 'f', 18, '产品', '15503643402', NULL);
//        INSERT INTO `tableTest` VALUES (595, 541513140292, '谯榕', 'f', 18, '开发', '13201144589', NULL);
//        INSERT INTO `tableTest` VALUES (596, 541513140293, '司澜', 'm', 20, '开发', '13401877141', NULL);
//        INSERT INTO `tableTest` VALUES (597, 541513140294, '习勤璐', 'f', 20, '开发', '13207390786', NULL);
//        INSERT INTO `tableTest` VALUES (598, 541513140295, '赫芳静', 'f', 20, '开发', '13705361906', NULL);
//        INSERT INTO `tableTest` VALUES (599, 541513140296, '梁爽婵', 'm', 23, '产品', '13108200954', NULL);
//        INSERT INTO `tableTest` VALUES (600, 541513140297, '郭妍', 'f', 20, '开发', '15803820152', NULL);
//        INSERT INTO `tableTest` VALUES (601, 541513140298, '良树', 'f', 20, '开发', '13905846398', NULL);
//        INSERT INTO `tableTest` VALUES (602, 541513140299, '傅妹秀', 'm', 20, '需求', '15602233585', NULL);
//        INSERT INTO `tableTest` VALUES (603, 541513140300, '薛玲蕊', 'f', 20, '开发', '13903384899', NULL);
//        INSERT INTO `tableTest` VALUES (604, 541513140301, '濮眉', 'f', 22, '开发', '15107043507', NULL);
//        INSERT INTO `tableTest` VALUES (605, 541513140302, '孙爽', 'f', 22, '产品', '15236546965', NULL);
//
//        SET FOREIGN_KEY_CHECKS = 1;
//
//
