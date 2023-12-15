-- CREATE DATABASE IF NOT EXISTS `ad_campaigns`;
-- CREATE DATABASE IF NOT EXISTS `user`;
-- CREATE DATABASE IF NOT EXISTS `transmission_history`;
--
-- -- ad.ad_campaigns definition
--
-- CREATE TABLE `ad_campaigns` (
--     `id`                int DEFAULT NULL,
--     `name`              text,
--     `image_url`         text,
--     `landing_url`       text,
--     `weight`            int DEFAULT NULL,
--     `target_country`    text,
--     `target_gender`     text,
--     `reward`            int DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- -- ad.`user` definition
--
-- CREATE TABLE `user` (
--     `id`                    bigint NOT NULL AUTO_INCREMENT,
--     `reward`                int NOT NULL,
--     `created_at`            datetime(6) NOT NULL,
--     `updated_at`            datetime(6) NOT NULL,
--     PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
--
-- CREATE TABLE `transmission_history` (
--     `id`                    bigint NOT NULL AUTO_INCREMENT,
--     `is_reward_received`    bit(1) NOT NULL,
--     `user_id`               bigint NOT NULL,
--     `advertisement_ids`     varchar(255) DEFAULT NULL,
--     `created_at`            datetime(6) NOT NULL,
--     `updated_at`            datetime(6) NOT NULL,
--     PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO `user` (`id`, `reward`, `created_at`, `updated_at`) VALUES (11324, 0, '2023-01-01 15:00:00.000000', '2023-01-01 15:00:00.000000');
INSERT INTO `transmission_history` (`id`, `is_reward_received`, `user_id`, `advertisement_ids`, `created_at`, `updated_at`) VALUES (1, 0, 11324, '1,2,3', '2023-01-01 15:00:00.000000', '2023-01-01 15:00:00.000000');