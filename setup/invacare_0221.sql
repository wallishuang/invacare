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
	"code" VARCHAR(50) NOT NULL,
	"name" VARCHAR(50) NOT NULL,
	"introducer_code" VARCHAR(50) NULL DEFAULT NULL::character varying,
	"parent_code" VARCHAR(50) NULL DEFAULT NULL::character varying,
	"parent_position" VARCHAR(2) NULL DEFAULT NULL::character varying,
	"created_time" TIMESTAMP NULL DEFAULT NULL,
	"updated_time" TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY ("code")
);

-- 正在傾印表格  public.policyholder 的資料：11 rows
/*!40000 ALTER TABLE "policyholder" DISABLE KEYS */;
INSERT INTO "policyholder" ("code", "name", "introducer_code", "parent_code", "parent_position", "created_time", "updated_time") VALUES
	('001', '保戶1', NULL, NULL, NULL, '2024-02-21 10:45:46', '2024-02-21 10:45:50'),
	('002', '保戶2', '001', '001', 'L', '2024-02-21 10:45:48', '2024-02-21 10:45:49'),
	('003', '保戶3', '001', '001', 'R', '2024-02-20 12:43:49.65486', '2024-02-20 12:43:49.65486'),
	('004', '保戶4', '002', '002', 'L', '2024-02-20 12:43:49.65486', '2024-02-20 12:43:49.65486'),
	('008', '保戶8', '004', '004', 'L', '2024-02-20 12:43:49.65486', '2024-02-20 12:43:49.65486'),
	('011', '保戶11', '006', '006', 'L', '2024-02-20 12:43:49.65486', '2024-02-20 12:43:49.65486'),
	('007', '保戶7', '001', '003', 'R', '2024-02-20 12:43:49.65486', '2024-02-20 12:43:49.65486'),
	('006', '保戶6', '001', '003', 'L', '2024-02-20 12:43:49.65486', '2024-02-20 12:43:49.65486'),
	('005', '保戶5', '001', '002', 'R', '2024-02-20 12:43:49.65486', '2024-02-20 12:43:49.65486'),
	('009', '保戶9', '002', '004', 'R', '2024-02-20 12:43:49.65486', '2024-02-20 12:43:49.65486'),
	('010', '保戶10', '004', '009', 'L', '2024-02-20 12:43:49.65486', '2024-02-20 12:43:49.65486');
/*!40000 ALTER TABLE "policyholder" ENABLE KEYS */;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
