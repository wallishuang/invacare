-- --------------------------------------------------------
-- 主機:                           localhost
-- 伺服器版本:                        PostgreSQL 10.1 on x86_64-pc-linux-gnu, compiled by gcc (Debian 6.3.0-18) 6.3.0 20170516, 64-bit
-- 伺服器作業系統:                      
-- HeidiSQL 版本:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES  */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 傾印  資料表 public.policyholder 結構
CREATE TABLE IF NOT EXISTS "policyholder" (
	"id" SERIAL NOT NULL,
	"code" VARCHAR(50) NULL DEFAULT NULL::character varying,
	"name" VARCHAR(50) NOT NULL,
	"introducer_code" VARCHAR(50) NULL DEFAULT NULL::character varying,
	"parent_code" VARCHAR(50) NULL DEFAULT NULL::character varying,
	"parent_position" VARCHAR(2) NULL DEFAULT NULL::character varying,
	"created_time" TIMESTAMP NULL DEFAULT NULL,
	"updated_time" TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY ("id")
);

-- 正在傾印表格  public.policyholder 的資料：11 rows
/*!40000 ALTER TABLE "policyholder" DISABLE KEYS */;
INSERT INTO "policyholder" ("id", "code", "name", "introducer_code", "parent_code", "parent_position", "created_time", "updated_time") VALUES
	(36, '000000036', '保2', '', '000000029', 'L', '2024-02-21 20:11:52.787', '2024-02-21 20:11:52.787'),
	(39, '000000039', '保3', '', '000000029', 'R', '2024-02-21 20:13:58.473', '2024-02-21 20:13:58.85'),
	(40, '000000040', '保4', '', '000000036', 'L', '2024-02-21 20:17:50.939', '2024-02-21 20:17:50.939'),
	(41, '000000041', '保5', '', '000000036', 'R', '2024-02-21 20:18:22.986', '2024-02-21 20:18:22.986'),
	(44, '000000044', '保6', '', '000000040', 'L', '2024-02-21 20:19:11.017', '2024-02-21 20:19:11.017'),
	(45, '000000045', '保7', '', '000000040', 'R', '2024-02-21 20:19:20.432', '2024-02-21 20:19:20.432'),
	(46, '000000046', '保8', '', '000000044', 'L', '2024-02-21 20:19:40.905', '2024-02-21 20:19:40.905'),
	(47, '000000047', '保9', '', '000000044', 'R', '2024-02-21 20:19:46.494', '2024-02-21 20:19:46.494'),
	(48, '000000048', '保10', '000000047', '000000047', 'L', '2024-02-21 20:20:11.985', '2024-02-21 20:20:11.985'),
	(49, '000000049', '保11', '000000044', '000000046', 'L', '2024-02-21 20:20:37.41', '2024-02-21 20:20:37.41'),
	(29, '000000029', '保1', '', NULL, NULL, '2024-02-21 19:52:24.165', '2024-02-21 19:52:24.165');
/*!40000 ALTER TABLE "policyholder" ENABLE KEYS */;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
