-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.45 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for db_tubes_pbo_trinetra
CREATE DATABASE IF NOT EXISTS `db_tubes_pbo_trinetra` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_tubes_pbo_trinetra`;


-- Dumping structure for table db_tubes_pbo_trinetra.users
DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS `users` (
  `user_type` varchar(31) NOT NULL,
  `id` varchar(36) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `active` bit(1) NOT NULL,
  `email` varchar(150) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.users: ~64 rows (approximately)
INSERT INTO `users` (`user_type`, `id`, `created_at`, `updated_at`, `active`, `email`, `name`, `password`, `phone`) VALUES
	('CITIZEN', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', '2026-04-12 21:43:54.472595', '2026-04-12 22:18:00.882334', b'1', 'warga@smartwaste.com', 'Ahmad Kamarudin', '$2a$12$Q6Q3XB3CKThsOZnCfzvW1O.Y467e10aEg7kU4TI7Ebmo/lWQaDWRi', '081222333444'),
	('CITIZEN', '0fb8dd2e-679d-4c87-b837-6964b9526fa7', '2026-04-26 15:25:57.203304', '2026-04-26 15:25:57.203304', b'1', 'warga49@smartwaste.com', 'Ahmad Wijaya', '$2a$12$u/57qs1leim9ckdq5FFAkuS.9Cnss/nV7KADTgtuV/5dGGPd2wAlO', '081212686046'),
	('CITIZEN', '10e873da-3daf-47d6-8045-faee4402daf1', '2026-04-26 15:25:26.973140', '2026-04-26 15:25:26.973140', b'1', 'warga14@smartwaste.com', 'Dwi Nugroho', '$2a$12$niW8t8omo1IUhvF8y7PlUeL9WvNVTTlL/t8A1sKCeD1.dq.e9ikqi', '081240877529'),
	('COLLECTOR', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', '2026-04-26 20:58:23.436232', '2026-04-26 21:51:29.452663', b'1', 'petugas10@smartwaste.com', 'Joko Susilo', '$2a$12$Nsqw/3XBwpY1sWbe7KSyz.pB4DSLHrmNcvaauMwtNeEVE03eBnkZG', '081100000009'),
	('CITIZEN', '1506fec1-f2ff-4bc8-99a0-8c56ae0f7007', '2026-04-26 15:25:56.316153', '2026-04-26 15:25:56.316153', b'1', 'warga48@smartwaste.com', 'Adi Susanto', '$2a$12$.jPNE/rOwTWLopZCxWwOs./VyAyibmlm4CNpk4Li5PKiiqTVhV9lC', '081284761333'),
	('CITIZEN', '18b62ad3-019a-48dd-b3e0-d4801e35b97f', '2026-04-26 15:25:14.491139', '2026-04-26 15:25:14.491139', b'1', 'warga2@smartwaste.com', 'Siti Nugroho', '$2a$12$ppcIYbcOwFaRf8V52dyrJ.j.qisRIQKcsoWXKdXWNO/otNwpv7xMW', '081235035324'),
	('COLLECTOR', '1a61e6a1-3df0-4460-ac64-df177a973473', '2026-04-26 20:58:17.615620', '2026-04-26 21:51:29.402267', b'1', 'petugas3@smartwaste.com', 'Suryo Utomo', '$2a$12$Cy14RMvK4rKVq9D99kkK7eACmb.8k/sO/D3GEDjK1PBO.NwP2v1d6', '081100000002'),
	('COLLECTOR', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', '2026-04-26 20:58:19.263616', '2026-04-26 21:51:28.668666', b'1', 'petugas5@smartwaste.com', 'Eko Prasetyo', '$2a$12$woxn5ceyxcqkREZjB97FCe4lPeW7yvgXA2Kl2f76itdQ34hF4fo9u', '081100000004'),
	('ADMIN', '20d4665a-19dc-4c6b-9d6a-822422ed3af2', '2026-04-12 21:31:26.663096', '2026-04-12 21:31:26.663096', b'1', 'admin@smartwaste.com', 'Super Admin', '$2a$12$.BNutnHqMakkPlf.enMIL./ujc2sTCW9o7uPa/tVPwnF5RdEdlebq', '08100000001'),
	('CITIZEN', '220150b6-a277-4a6e-b467-6152fe1c23ed', '2026-04-26 15:25:55.428887', '2026-04-26 15:25:55.428887', b'1', 'warga47@smartwaste.com', 'Hendra Pangestu', '$2a$12$QQH7UW7/ZuYOFxiiG5lX7eUGJhAvMRTpCMygc6UTfwbe.bTUpFnd.', '081234371663'),
	('COLLECTOR', '245b8746-cf46-4a94-9148-58dd0315f2b5', '2026-04-12 21:31:27.724937', '2026-04-28 09:12:50.957732', b'1', 'petugas@smartwaste.com', 'Budi Santoso', '$2a$12$mPvwrigOT9oXcK7v7koV8.hJr5xJvYg/FSiSyTZkrran/dImB2JE2', '08100000002'),
	('COLLECTOR', '2df99938-98b4-4472-a4c0-36cbee6be073', '2026-04-26 20:58:16.787396', '2026-04-26 21:51:29.212789', b'1', 'petugas2@smartwaste.com', 'Andi Wijaya', '$2a$12$0u.70kOHacqmXEFkaIwzqumsciHOTGwDWwVTnSPI287JvYxKCek..', '081100000001'),
	('COLLECTOR', '35a41428-3349-45ef-af40-fcbaaa42a3c7', '2026-04-26 20:58:22.594282', '2026-04-26 21:51:29.509249', b'1', 'petugas9@smartwaste.com', 'Indra Kusuma', '$2a$12$04Zv0z2/NmSkGxcC7ISor.8FSHHR9LEdQZrcx4JBSEZ0MJ45RFozm', '081100000008'),
	('CITIZEN', '36f06de1-3827-4a6c-986e-9bacbcb4d4f4', '2026-04-26 15:25:27.837424', '2026-04-26 15:25:27.837424', b'1', 'warga15@smartwaste.com', 'Ahmad Pangestu', '$2a$12$zlT4z823lJFlsEm6pF2kYuZV0vdQwszYszoIa4mfk0ohROIwDjPsW', '081215524418'),
	('CITIZEN', '38e4112c-2738-418f-9583-6b71903324d6', '2026-04-26 15:25:40.816896', '2026-04-26 15:25:40.816896', b'1', 'warga30@smartwaste.com', 'Eko Hidayat', '$2a$12$SOtuKqZPVt5PV56gvc1Wo.Sf4XDLFWXtdYqyRtWR6svDfxDEfUR4u', '081221349493'),
	('CITIZEN', '3b4d284b-cd14-4940-8aac-ea5a2a917ab6', '2026-04-26 15:25:53.745801', '2026-04-26 15:25:53.745801', b'1', 'warga45@smartwaste.com', 'Sari Saputra', '$2a$12$fdsznn6Mt2TjlvhTUBP9SOXK.bQx7LtnBtR/NTvRMXMxcDNsZcGEO', '081293752329'),
	('CITIZEN', '3c413d07-5996-4313-8401-011b46ebf9e1', '2026-04-26 15:25:13.224348', '2026-04-26 15:25:13.224348', b'1', 'warga1@smartwaste.com', 'Putri Wijaya', '$2a$12$l1Hjuh4ypMGSRSqObADpLOPjgMSOjvYMZb3t2UEm4eUQP4e/GYpnK', '081242318276'),
	('COLLECTOR', '4094bc42-9bd0-40ac-889c-345de5ad6198', '2026-04-12 21:31:28.804002', '2026-04-12 21:31:28.804002', b'1', 'robot001@netradump.iot', 'Robot NetraDUMP-001', '$2a$12$Ig1xw/sHZFQZStMVMwxcU.TJTsoK2xcpgJP4dUsLw6xHveAhdlHLG', NULL),
	('CITIZEN', '4296719f-5bc4-4c7e-899f-c6718bc96c1a', '2026-04-26 15:25:26.173243', '2026-04-26 15:25:26.173243', b'1', 'warga13@smartwaste.com', 'Ratna Pangestu', '$2a$12$M73YNW7o/I6B11O4daHbFO4hqhoE1EhHZs4WaZ0S70RD3INpUVDd6', '081217660915'),
	('CITIZEN', '43095137-df51-4004-b68d-b31d1e3adb20', '2026-04-26 15:25:44.177246', '2026-04-26 15:25:44.177246', b'1', 'warga34@smartwaste.com', 'Adi Pratama', '$2a$12$bFbdmUXZroYZD8tn5FaijO7vRCAAYpeD6wU1JpiIhUVvH110VHdX2', '081243676838'),
	('CITIZEN', '482c6ffd-db87-40fb-b8a7-eb962c9ddb30', '2026-04-26 15:25:38.241026', '2026-04-26 15:25:38.241026', b'1', 'warga27@smartwaste.com', 'Eko Lubis', '$2a$12$WiDHcNtu7jJg5ThdHjiYuek11HZW5nOtUyoxrYMdo/LaTBDXKC.6q', '081216492315'),
	('CITIZEN', '4981c6f4-bf64-4ba2-8bd8-54a3d89c1935', '2026-04-26 15:25:47.584052', '2026-04-26 15:25:47.584052', b'1', 'warga38@smartwaste.com', 'Sari Wahyudi', '$2a$12$f4l3yy.8uKoKplRu54X5xuf0Vzi8qWkKvOEprdRCEgEQdMoQ5H8P2', '081253053330'),
	('CITIZEN', '5f788d55-dfcf-456f-8c1e-c1df967691d5', '2026-04-26 15:25:35.547524', '2026-04-26 15:25:35.547524', b'1', 'warga24@smartwaste.com', 'Lestari Sihombing', '$2a$12$N5FsOOuUYM2EWW7rkzJX1erhPemm2hu3/kZekTGcAYPX4rOpIkzdu', '081216446844'),
	('CITIZEN', '5f82c431-faab-4f52-9946-477a5403f451', '2026-04-26 15:25:39.107587', '2026-04-26 15:25:39.107587', b'1', 'warga28@smartwaste.com', 'Siti Pangestu', '$2a$12$KmUuEEL/d5K.qcxPzm9.fO8WgqxC/7VyBBkntKcS0rR8jJTr1xnqS', '081294299977'),
	('CITIZEN', '62e88cb0-1c54-4f23-bfc7-2eab9db66a46', '2026-04-26 15:25:25.227690', '2026-04-26 15:25:25.227690', b'1', 'warga12@smartwaste.com', 'Dwi Wahyudi', '$2a$12$i9oV3rzqr9jjIiVs/Rp64.PeDTpC0yverwlXJX9/IMYe2wDZCEbsO', '081256308580'),
	('CITIZEN', '71b10466-8e32-49d2-bdc5-814c7387915b', '2026-04-26 15:25:46.730338', '2026-04-26 15:25:46.730338', b'1', 'warga37@smartwaste.com', 'Dwi Hidayat', '$2a$12$jW6gE0oyi3zMaM/xHQ41.eoHLQY/8QVPB0f7j9yqvHfV8pYy.CrBW', '081279667706'),
	('CITIZEN', '735016c5-7255-46ee-9031-9ed94a27d90f', '2026-04-26 15:25:28.734938', '2026-04-26 15:25:28.734938', b'1', 'warga16@smartwaste.com', 'Sri Kusuma', '$2a$12$/gvsvi8kQHgpsi7DNnk3X.VF1Ujimkuxh/lXxrwTVMWwga5.5Yltm', '081245578393'),
	('CITIZEN', '7b644e69-dde6-45e9-864e-6d1eee7ff0c5', '2026-04-26 15:25:45.888351', '2026-04-26 15:25:45.888351', b'1', 'warga36@smartwaste.com', 'Budi Sihombing', '$2a$12$7GOUWvu0LPF1bUN.4/DSfuaEzrejnjsrHC9ab/bt/eGjARZO7D4di', '081224794096'),
	('CITIZEN', '7d2ccc7a-c37c-4c88-87d1-bc474486fb6a', '2026-04-26 15:25:41.643795', '2026-04-26 15:25:41.643795', b'1', 'warga31@smartwaste.com', 'Siti Pratama', '$2a$12$4T/SCQ0.T071Po1bQuso..cP6yp4KtCx97gaUtjS6tvRLg5WKm7di', '081282545606'),
	('CITIZEN', '7f02c92e-ac34-49a8-8698-b32986ea2ee1', '2026-04-26 15:25:45.054666', '2026-04-26 15:25:45.054666', b'1', 'warga35@smartwaste.com', 'Nur Nugroho', '$2a$12$.LOd5EupcGLDebH8.qoUIORewXCDqcsH/dhs1Zfjr5Xr1KVr8W8NO', '081211584378'),
	('CITIZEN', '7fda2150-942f-4283-b964-cdf04e467c10', '2026-04-26 15:25:54.599292', '2026-04-26 15:25:54.599292', b'1', 'warga46@smartwaste.com', 'Ahmad Pratama', '$2a$12$57rTKBvwL8QqMtOvJtduKO1B.HN0rVdFhAtBg.P26ogSj9EKdzSau', '081284282553'),
	('CITIZEN', '83741056-db1c-43a6-9ad7-3a12e2d75d06', '2026-04-26 15:25:24.146475', '2026-04-26 15:25:24.146475', b'1', 'warga11@smartwaste.com', 'Sri Firmansyah', '$2a$12$H9tkxY20/17c1/BwF5K/DuADDoIlosli1VN98mOkKhhFqml3tGsbu', '081263476431'),
	('CITIZEN', '85945231-e152-43ae-8b76-d6a27d999e8b', '2026-04-26 15:25:32.915126', '2026-04-26 15:25:32.915126', b'1', 'warga21@smartwaste.com', 'Hendra Saputra', '$2a$12$Y34LQeeJosSYbF6LIiEpU.nWA9r5xQGn7oLZvppNVA9y/o42qMUni', '081289330095'),
	('CITIZEN', '88c9c96f-639a-44b0-ac1e-ceca300374c0', '2026-04-26 15:25:42.482750', '2026-04-26 15:25:42.482750', b'1', 'warga32@smartwaste.com', 'Dwi Santoso', '$2a$12$uqNaTOM55Kw3R91eUNpCweO2AVGDRmnqxlh9ZYQN4n4vLSe7pFn1i', '081233013622'),
	('CITIZEN', '8fe94d3d-1a51-41d8-a0ca-b9e2e49959c3', '2026-04-26 15:25:16.717062', '2026-04-26 15:25:16.717062', b'1', 'warga4@smartwaste.com', 'Ayu Pratama', '$2a$12$uZPVTWat/C6DTuI0bcOv3uwD0roN0HMWo5t3pviy8I57/1AvY91zm', '081262113232'),
	('CITIZEN', '93bc354a-e558-4ea4-a613-7c8ed28dff63', '2026-04-26 15:25:17.840810', '2026-04-26 15:25:17.840810', b'1', 'warga5@smartwaste.com', 'Dwi Nugroho', '$2a$12$IF0Py.MlX1UnIZpOnX9UaOfAKrV3O0QkhOKKe4vz6PBHo09PwB3pO', '081234411547'),
	('COLLECTOR', '956186bd-4a29-4e18-a49d-180ad4289cf7', '2026-04-26 20:58:21.769996', '2026-04-26 21:51:28.813326', b'1', 'petugas8@smartwaste.com', 'Heri Setiawan', '$2a$12$d/WjcrEjNM2O89PyVunf5.LqTSehW7nc38LvCo2arpGZoxcKSGQiS', '081100000007'),
	('COLLECTOR', '98419feb-da21-4d78-97bf-62a2199d6c8c', '2026-04-26 20:58:18.436372', '2026-04-26 21:51:28.968364', b'1', 'petugas4@smartwaste.com', 'Dedi Kurniawan', '$2a$12$AyCA7h5qe2Mpc5AovvygR.HyDkTLheQWQMRE3zQLyXIcgk9grJ2n.', '081100000003'),
	('COLLECTOR', '9a398868-8a1f-4e30-9872-e887e380af93', '2026-04-26 20:58:20.936234', '2026-04-26 21:51:29.312481', b'1', 'petugas7@smartwaste.com', 'Guntur Saputra', '$2a$12$rxM8DYR/o/h1dULNCDSO/eJmGH1y4STgDE.SwafsqCTwwbKyKsdOy', '081100000006'),
	('CITIZEN', '9e1ec042-85f8-4272-94f1-d7e7cfb8f5d3', '2026-04-26 15:25:37.332938', '2026-04-26 15:25:37.332938', b'1', 'warga26@smartwaste.com', 'Nur Santoso', '$2a$12$ZVQV4J4Bv9fkS/AFCCCaPeyEq23bV6ZgdD1QUmccLFOtqT8501rRW', '081289661041'),
	('CITIZEN', '9fdfd91d-f237-4346-9c38-04fb9be9a98c', '2026-04-26 15:25:32.058957', '2026-04-26 15:25:32.058957', b'1', 'warga20@smartwaste.com', 'Eko Firmansyah', '$2a$12$LL6kVgpS4ZzQ4XdW8z2tyeenrpqHA2XQ8PdP8VaN6xdSdNCAtjdf6', '081256061643'),
	('CITIZEN', 'a085dd41-6103-4858-a2b0-417dbb93de09', '2026-04-26 15:25:49.525926', '2026-04-26 15:25:49.525926', b'1', 'warga40@smartwaste.com', 'Rini Kusuma', '$2a$12$WFwhBvO5dxQSGK7qt0D89ejaZA6iAxrXZi3h2kVFhCvrylZ.0HOSi', '081237236771'),
	('CITIZEN', 'a1fdb247-7f63-414a-b34e-5f379a505c55', '2026-04-26 15:25:30.407644', '2026-04-26 15:25:30.407644', b'1', 'warga18@smartwaste.com', 'Adi Wahyudi', '$2a$12$C2B0CQVsLlIH6DMor/Rn5OBWgj1maDKvYyPJNxabgp1IhnuQBckFO', '081282648849'),
	('COLLECTOR', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', '2026-04-26 20:58:20.095330', '2026-04-26 21:51:29.057812', b'1', 'petugas6@smartwaste.com', 'Fajar Ramadhan', '$2a$12$VRiyqSraZbGDw1ubY1Cnf.QBUHxYwzojlE1141ncuD8DS1QefTKWa', '081100000005'),
	('CITIZEN', 'b8566336-b51f-49d4-a838-dbac75545acc', '2026-04-26 15:25:39.944908', '2026-04-26 15:25:39.944908', b'1', 'warga29@smartwaste.com', 'Ahmad Lubis', '$2a$12$Q5W2XI3O260zGwB4GGPIjeyo6waqQsuM9vAcMcXe1wKOp7Udc1zaS', '081273999141'),
	('CITIZEN', 'bd2dc7f2-90dd-4644-9c9f-0241edaab70b', '2026-04-26 15:25:51.253782', '2026-04-26 15:25:51.253782', b'1', 'warga42@smartwaste.com', 'Lestari Pangestu', '$2a$12$fHFnG.eCXcWZOl1IzG5uleJJ8Ri26FTm88VyDPWGBL.2TaooBiQhu', '081224439218'),
	('CITIZEN', 'bffb0d79-03cf-4a88-9219-b00db794c1f6', '2026-04-26 15:25:22.277229', '2026-04-26 15:25:22.277229', b'1', 'warga9@smartwaste.com', 'Agus Wahyudi', '$2a$12$x2GezrdHwxC3phFHwciIWOUU9fpEY5QYMrd9A0IyeKWSgr91nqCUK', '081254338303'),
	('CITIZEN', 'c0f5bf5a-94a4-42e7-8a3a-c30a9ca10faf', '2026-04-26 15:25:36.405214', '2026-04-26 15:25:36.405214', b'1', 'warga25@smartwaste.com', 'Eko Siregar', '$2a$12$i9m4uD1sx47IPMRe0fU0U.33on3qAGzq19ABNrU9/MYCf/29YwkTq', '081211051897'),
	('CITIZEN', 'c230d565-bf47-4ecb-a9c3-9f01a854eb0d', '2026-04-26 15:25:23.168092', '2026-04-26 15:25:23.168092', b'1', 'warga10@smartwaste.com', 'Eko Pangestu', '$2a$12$V.AsWQG5AFnvRW9XQaF8r.bVR9/pjqkexb.l.XMA06ulVKQS8xMrO', '081281255105'),
	('CITIZEN', 'c661afad-1d0d-481f-87f9-8655bbb2a105', '2026-04-26 15:25:19.160217', '2026-04-26 15:25:19.160217', b'1', 'warga6@smartwaste.com', 'Ratna Kusuma', '$2a$12$z3Sw4yHEBcOcK5SI6VWyZ.snMcs4k0G8IWU1Wxl2WQ5xLdyKdAytu', '081273950104'),
	('CITIZEN', 'c96f1890-97aa-4284-be5d-89130bc13f32', '2026-04-26 15:25:48.478492', '2026-04-26 15:25:48.478492', b'1', 'warga39@smartwaste.com', 'Sari Wahyudi', '$2a$12$7ElNd9M0lAl8uPLp4Qz5B.pG1PtD8gOIWv98SCItY0/48Dt2yjdl6', '081227169283'),
	('CITIZEN', 'ce9dd90d-0a34-490f-ab94-95f5edc129bd', '2026-04-26 15:25:21.268470', '2026-04-26 15:25:21.268470', b'1', 'warga8@smartwaste.com', 'Dewi Siregar', '$2a$12$1PgwifZpi/LX7akFmps3BuaYH3/ZsKCWTWffrNhk0joWusVvanqTi', '081241778923'),
	('CITIZEN', 'd5f5c72d-3971-4a5a-842b-375b03183b8c', '2026-04-26 15:25:29.601895', '2026-04-26 15:25:29.601895', b'1', 'warga17@smartwaste.com', 'Dewi Siregar', '$2a$12$neTZMFWDrOdSUg/xXj6SzuQjY08GfMlDBN38lsIvLzE.exmlYjosa', '081233580622'),
	('CITIZEN', 'd7dc83d2-5897-42be-ae6c-447296eb1c97', '2026-04-26 15:25:52.063976', '2026-04-26 15:25:52.063976', b'1', 'warga43@smartwaste.com', 'Adi Firmansyah', '$2a$12$l1j3MjpWBmuBg87FqjB1qeRBkvO35d.6v84bbeXpq5/Cv7tOjLZBu', '081215045494'),
	('CITIZEN', 'd8b68cd6-d9e6-4ae7-9a3f-170c2e5c79c3', '2026-04-26 15:25:50.449328', '2026-04-26 15:25:50.449328', b'1', 'warga41@smartwaste.com', 'Ahmad Hidayat', '$2a$12$UrrKK7gGfY/Y31fpOvOCu.LybJfUGtG6.SWtlxRuuw5cS2e6KqQc6', '081296111338'),
	('CITIZEN', 'da724c70-e971-422f-97eb-10c281e35326', '2026-04-26 15:25:15.634781', '2026-04-26 15:25:15.634781', b'1', 'warga3@smartwaste.com', 'Hendra Pangestu', '$2a$12$Fw1GNmfKurkF7dmwrHMipuvz.4ejZNthXRu7H5eQSQ3EcZIpJJnvS', '081216330262'),
	('CITIZEN', 'dfe9a4e0-bddf-4263-a44a-208b4357daae', '2026-04-26 15:25:58.081214', '2026-04-26 15:25:58.081214', b'1', 'warga50@smartwaste.com', 'Joko Firmansyah', '$2a$12$XI9mqGZM/7VBQ2A8PkXcneQUma5bQjR9gSIWFdmZpdmr00LCmC0Uu', '081291262686'),
	('COLLECTOR', 'e2037d74-845a-40bf-868b-a0807f1a08e4', '2026-04-26 20:58:15.834953', '2026-04-26 21:51:29.358127', b'1', 'petugas1@smartwaste.com', 'Budi Santoso', '$2a$12$6vXSTSx8fOMtzuG4XHMAW.0TNjOzvvKLocxIS2DeRodJz707WqdQG', '081100000000'),
	('CITIZEN', 'e7e5884e-1720-44d0-b3d5-d091698e3524', '2026-04-26 15:25:34.651353', '2026-04-26 15:25:34.651353', b'1', 'warga23@smartwaste.com', 'Nur Nugroho', '$2a$12$kAxxL0ZIv3eLJGWMLX6MT.rKF4npDEOorFYWqdUf9VfpieEuoHnAe', '081296500892'),
	('CITIZEN', 'eb4c2239-f108-4c78-ac9e-ad354bd546fd', '2026-04-26 15:25:43.336868', '2026-04-26 15:25:43.336868', b'1', 'warga33@smartwaste.com', 'Tri Hidayat', '$2a$12$cRyksnfmmmi6cMBrn2d/.uRbXomnVZnH8dNC/fMh.ef/nwgpoVXfy', '081295411551'),
	('CITIZEN', 'f02d9684-0501-4386-b3c4-7799a1a42804', '2026-04-26 15:25:31.198240', '2026-04-26 15:25:31.198240', b'1', 'warga19@smartwaste.com', 'Budi Lubis', '$2a$12$Qn6ZR5sjvtCp0zCd2.cFJ.DVm9oFeNOYuWEf9dsdM8ACXkX6sBmpm', '081260077459'),
	('CITIZEN', 'f052b52b-edf6-4546-985b-cf7cb4d52d4e', '2026-04-26 15:25:20.350562', '2026-04-26 15:25:20.350562', b'1', 'warga7@smartwaste.com', 'Lestari Santoso', '$2a$12$aqO/s2ocENCdpPe7WXu/ZuZA2LCNJfR0Z4pvYQxdq9GZUZI6lij7e', '081276625947'),
	('CITIZEN', 'f9404ec0-2243-435e-a8eb-04f2902794e3', '2026-04-26 15:25:52.942385', '2026-04-26 15:25:52.942385', b'1', 'warga44@smartwaste.com', 'Ratna Sihombing', '$2a$12$X3j6FFEAWkroCvKiV5yTl.PGDFtT0dAodJbtXKadUrg.xV2ZjMsxq', '081290184595'),
	('CITIZEN', 'fa469c10-ad7f-404b-b96d-986f0b650e1b', '2026-04-26 15:25:33.763382', '2026-04-26 15:25:33.763382', b'1', 'warga22@smartwaste.com', 'Joko Santoso', '$2a$12$X7WVpA5yZWb91fMabsag4.gNCOqpXluSSnF1Gjw8cNktWAhaBgO4i', '081250087670');
-- Dumping structure for table db_tubes_pbo_trinetra.admins
DROP TABLE IF EXISTS admins;
CREATE TABLE IF NOT EXISTS `admins` (
  `position` varchar(100) DEFAULT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FKgc8dtql9mkq268detxiox7fpm` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.admins: ~1 rows (approximately)
INSERT INTO `admins` (`position`, `user_id`) VALUES
	('Super Administrator', '20d4665a-19dc-4c6b-9d6a-822422ed3af2');

-- Dumping structure for table db_tubes_pbo_trinetra.chat_logs
DROP TABLE IF EXISTS chat_logs;
CREATE TABLE IF NOT EXISTS `chat_logs` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `ai_model_used` varchar(50) DEFAULT NULL,
  `anonymous_identifier` varchar(100) DEFAULT NULL,
  `bot_response` text,
  `session_id` varchar(100) DEFAULT NULL,
  `success` bit(1) NOT NULL,
  `user_message` text NOT NULL,
  `citizen_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_chatlog_citizen` (`citizen_id`),
  KEY `idx_chatlog_session` (`session_id`),
  CONSTRAINT `FKtgal3v8m3x8ei8gx35a63jxsj` FOREIGN KEY (`citizen_id`) REFERENCES `citizens` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.chat_logs: ~0 rows (approximately)

-- Dumping structure for table db_tubes_pbo_trinetra.chat_messages
DROP TABLE IF EXISTS chat_messages;
CREATE TABLE IF NOT EXISTS `chat_messages` (
  `id` varchar(255) NOT NULL,
  `is_read` bit(1) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `sent_at` datetime(6) DEFAULT NULL,
  `receiver_id` varchar(36) DEFAULT NULL,
  `sender_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKand7mh9iu4kt3n1tn2w9i9of0` (`receiver_id`),
  KEY `FKgiqeap8ays4lf684x7m0r2729` (`sender_id`),
  CONSTRAINT `FKand7mh9iu4kt3n1tn2w9i9of0` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKgiqeap8ays4lf684x7m0r2729` FOREIGN KEY (`sender_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.chat_messages: ~6 rows (approximately)
INSERT INTO `chat_messages` (`id`, `is_read`, `message`, `sent_at`, `receiver_id`, `sender_id`) VALUES
	('0ecd1a03-c414-4b47-accf-bafeb60ae8f9', b'1', 'dfdfd', '2026-04-26 23:20:47.537985', '245b8746-cf46-4a94-9148-58dd0315f2b5', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f'),
	('0fb5dd9f-a7dd-46f6-9e16-a5c00a99ef77', b'1', 'dsdsd', '2026-04-26 23:54:25.356644', '245b8746-cf46-4a94-9148-58dd0315f2b5', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f'),
	('18480342-9260-46f0-bfdd-439950c0f3e0', b'1', 'Halo', '2026-04-26 23:07:45.285646', '245b8746-cf46-4a94-9148-58dd0315f2b5', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f'),
	('75b7c455-2104-4888-942a-9d25ff47d7db', b'1', 'Halo Juga', '2026-04-26 23:09:21.716578', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', '245b8746-cf46-4a94-9148-58dd0315f2b5'),
	('88cf54ff-fbd4-4400-8c22-0432f3c0f84d', b'1', 'sfdgbn', '2026-04-26 23:34:14.630540', '245b8746-cf46-4a94-9148-58dd0315f2b5', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f'),
	('c0c5d0ee-1cb9-4718-94cb-65e2e4bb7a40', b'1', 'xzxzxzxz', '2026-04-26 23:49:24.165093', '245b8746-cf46-4a94-9148-58dd0315f2b5', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f');

-- Dumping structure for table db_tubes_pbo_trinetra.citizens
DROP TABLE IF EXISTS citizens;
CREATE TABLE IF NOT EXISTS `citizens` (
  `address` text,
  `kelurahan` varchar(100) DEFAULT NULL,
  `nik` varchar(16) DEFAULT NULL,
  `rt_rw` varchar(10) DEFAULT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_r0yt63hv6msudilci5kjt4ibw` (`nik`),
  CONSTRAINT `FKgx7s2yqk5jxh5dmc03swk30em` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.citizens: ~51 rows (approximately)
INSERT INTO `citizens` (`address`, `kelurahan`, `nik`, `rt_rw`, `user_id`) VALUES
	('Jl. Kebersihan No. 10, RT 02/01', NULL, '3201012345678901', NULL, '0da6dd2b-486c-4e0e-a99e-83d7a36d155f'),
	('Jl. Dummy No. 49', 'Sumber Rejo', '3201100612098283', '02/04', '0fb8dd2e-679d-4c87-b837-6964b9526fa7'),
	('Jl. Dummy No. 14', 'Maju Jaya', '3201100752249095', '03/05', '10e873da-3daf-47d6-8045-faee4402daf1'),
	('Jl. Dummy No. 48', 'Mekar Sari', '3201100823278328', '01/04', '1506fec1-f2ff-4bc8-99a0-8c56ae0f7007'),
	('Jl. Dummy No. 2', 'Sukabersih', '3201100305832849', '04/02', '18b62ad3-019a-48dd-b3e0-d4801e35b97f'),
	('Jl. Dummy No. 47', 'Mekar Sari', '3201100871724143', '10/09', '220150b6-a277-4a6e-b467-6152fe1c23ed'),
	('Jl. Dummy No. 15', 'Maju Jaya', '3201100677045763', '10/09', '36f06de1-3827-4a6c-986e-9bacbcb4d4f4'),
	('Jl. Dummy No. 30', 'Tirta Makmur', '3201100080897510', '09/05', '38e4112c-2738-418f-9583-6b71903324d6'),
	('Jl. Dummy No. 45', 'Sukabersih', '3201100716864235', '04/08', '3b4d284b-cd14-4940-8aac-ea5a2a917ab6'),
	('Jl. Dummy No. 1', 'Tirta Makmur', '3201100871436183', '03/04', '3c413d07-5996-4313-8401-011b46ebf9e1'),
	('Jl. Dummy No. 13', 'Maju Jaya', '3201100303686232', '09/01', '4296719f-5bc4-4c7e-899f-c6718bc96c1a'),
	('Jl. Dummy No. 34', 'Sukabersih', '3201100408666933', '04/06', '43095137-df51-4004-b68d-b31d1e3adb20'),
	('Jl. Dummy No. 27', 'Maju Jaya', '3201100830492821', '06/04', '482c6ffd-db87-40fb-b8a7-eb962c9ddb30'),
	('Jl. Dummy No. 38', 'Sukabersih', '3201100584295195', '08/03', '4981c6f4-bf64-4ba2-8bd8-54a3d89c1935'),
	('Jl. Dummy No. 24', 'Maju Jaya', '3201100581022796', '02/10', '5f788d55-dfcf-456f-8c1e-c1df967691d5'),
	('Jl. Dummy No. 28', 'Tirta Makmur', '3201100473469289', '05/03', '5f82c431-faab-4f52-9946-477a5403f451'),
	('Jl. Dummy No. 12', 'Tirta Makmur', '3201100047292025', '03/01', '62e88cb0-1c54-4f23-bfc7-2eab9db66a46'),
	('Jl. Dummy No. 37', 'Tirta Makmur', '3201100612656522', '07/10', '71b10466-8e32-49d2-bdc5-814c7387915b'),
	('Jl. Dummy No. 16', 'Mekar Sari', '3201100579166312', '04/09', '735016c5-7255-46ee-9031-9ed94a27d90f'),
	('Jl. Dummy No. 36', 'Sukabersih', '3201100038445513', '04/08', '7b644e69-dde6-45e9-864e-6d1eee7ff0c5'),
	('Jl. Dummy No. 31', 'Sukabersih', '3201100370007469', '05/03', '7d2ccc7a-c37c-4c88-87d1-bc474486fb6a'),
	('Jl. Dummy No. 35', 'Mekar Sari', '3201100303215276', '10/04', '7f02c92e-ac34-49a8-8698-b32986ea2ee1'),
	('Jl. Dummy No. 46', 'Tirta Makmur', '3201100317024020', '08/08', '7fda2150-942f-4283-b964-cdf04e467c10'),
	('Jl. Dummy No. 11', 'Sukabersih', '3201100293094979', '06/05', '83741056-db1c-43a6-9ad7-3a12e2d75d06'),
	('Jl. Dummy No. 21', 'Tirta Makmur', '3201100188186753', '02/03', '85945231-e152-43ae-8b76-d6a27d999e8b'),
	('Jl. Dummy No. 32', 'Maju Jaya', '3201100110183659', '05/10', '88c9c96f-639a-44b0-ac1e-ceca300374c0'),
	('Jl. Dummy No. 4', 'Sukabersih', '3201100251220634', '06/07', '8fe94d3d-1a51-41d8-a0ca-b9e2e49959c3'),
	('Jl. Dummy No. 5', 'Tirta Makmur', '3201100302478990', '02/08', '93bc354a-e558-4ea4-a613-7c8ed28dff63'),
	('Jl. Dummy No. 26', 'Maju Jaya', '3201100563827761', '09/06', '9e1ec042-85f8-4272-94f1-d7e7cfb8f5d3'),
	('Jl. Dummy No. 20', 'Sukabersih', '3201100232437517', '10/04', '9fdfd91d-f237-4346-9c38-04fb9be9a98c'),
	('Jl. Dummy No. 40', 'Tirta Makmur', '3201100047047254', '02/08', 'a085dd41-6103-4858-a2b0-417dbb93de09'),
	('Jl. Dummy No. 18', 'Sukabersih', '3201100124485198', '02/05', 'a1fdb247-7f63-414a-b34e-5f379a505c55'),
	('Jl. Dummy No. 29', 'Tirta Makmur', '3201100271320957', '06/01', 'b8566336-b51f-49d4-a838-dbac75545acc'),
	('Jl. Dummy No. 42', 'Sumber Rejo', '3201100054921906', '01/02', 'bd2dc7f2-90dd-4644-9c9f-0241edaab70b'),
	('Jl. Dummy No. 9', 'Mekar Sari', '3201100876070767', '04/05', 'bffb0d79-03cf-4a88-9219-b00db794c1f6'),
	('Jl. Dummy No. 25', 'Mekar Sari', '3201100875302717', '06/03', 'c0f5bf5a-94a4-42e7-8a3a-c30a9ca10faf'),
	('Jl. Dummy No. 10', 'Sukabersih', '3201100237542637', '02/06', 'c230d565-bf47-4ecb-a9c3-9f01a854eb0d'),
	('Jl. Dummy No. 6', 'Sumber Rejo', '3201100828503795', '10/04', 'c661afad-1d0d-481f-87f9-8655bbb2a105'),
	('Jl. Dummy No. 39', 'Sukabersih', '3201100490758512', '09/01', 'c96f1890-97aa-4284-be5d-89130bc13f32'),
	('Jl. Dummy No. 8', 'Sukabersih', '3201100329093194', '10/04', 'ce9dd90d-0a34-490f-ab94-95f5edc129bd'),
	('Jl. Dummy No. 17', 'Mekar Sari', '3201100019780391', '01/02', 'd5f5c72d-3971-4a5a-842b-375b03183b8c'),
	('Jl. Dummy No. 43', 'Mekar Sari', '3201100760160294', '07/02', 'd7dc83d2-5897-42be-ae6c-447296eb1c97'),
	('Jl. Dummy No. 41', 'Tirta Makmur', '3201100511014422', '01/09', 'd8b68cd6-d9e6-4ae7-9a3f-170c2e5c79c3'),
	('Jl. Dummy No. 3', 'Sumber Rejo', '3201100699268409', '04/07', 'da724c70-e971-422f-97eb-10c281e35326'),
	('Jl. Dummy No. 50', 'Sukabersih', '3201100338599091', '04/05', 'dfe9a4e0-bddf-4263-a44a-208b4357daae'),
	('Jl. Dummy No. 23', 'Tirta Makmur', '3201100173902404', '03/10', 'e7e5884e-1720-44d0-b3d5-d091698e3524'),
	('Jl. Dummy No. 33', 'Tirta Makmur', '3201100197089044', '08/04', 'eb4c2239-f108-4c78-ac9e-ad354bd546fd'),
	('Jl. Dummy No. 19', 'Mekar Sari', '3201100058021701', '10/01', 'f02d9684-0501-4386-b3c4-7799a1a42804'),
	('Jl. Dummy No. 7', 'Sukabersih', '3201100765596662', '05/08', 'f052b52b-edf6-4546-985b-cf7cb4d52d4e'),
	('Jl. Dummy No. 44', 'Mekar Sari', '3201100849248425', '07/01', 'f9404ec0-2243-435e-a8eb-04f2902794e3'),
	('Jl. Dummy No. 22', 'Sukabersih', '3201100306543642', '09/02', 'fa469c10-ad7f-404b-b96d-986f0b650e1b');

-- Dumping structure for table db_tubes_pbo_trinetra.collectors
DROP TABLE IF EXISTS collectors;
CREATE TABLE IF NOT EXISTS `collectors` (
  `assigned_area` varchar(200) DEFAULT NULL,
  `available` bit(1) NOT NULL,
  `is_iot_device` bit(1) NOT NULL,
  `iot_device_id` varchar(50) DEFAULT NULL,
  `vehicle_number` varchar(30) DEFAULT NULL,
  `user_id` varchar(36) NOT NULL,
  `current_load_kg` double DEFAULT NULL,
  `max_capacity_kg` double DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_o8uhe98exkw49gwrikjawpn4w` (`iot_device_id`),
  CONSTRAINT `FK6m9ylxjcfj1o0hgf5o4udcj3o` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.collectors: ~12 rows (approximately)
INSERT INTO `collectors` (`assigned_area`, `available`, `is_iot_device`, `iot_device_id`, `vehicle_number`, `user_id`, `current_load_kg`, `max_capacity_kg`) VALUES
	('Area Wilayah J', b'1', b'0', NULL, 'B 1243 SW', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', 147.5, 500),
	('Area Wilayah C', b'1', b'0', NULL, 'B 1236 SW', '1a61e6a1-3df0-4460-ac64-df177a973473', 136, 500),
	('Area Wilayah E', b'1', b'0', NULL, 'B 1238 SW', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', 105, 500),
	('Area RT 01-10', b'1', b'0', NULL, 'B 1234 SW', '245b8746-cf46-4a94-9148-58dd0315f2b5', 22.4, NULL),
	('Area Wilayah B', b'1', b'0', NULL, 'B 1235 SW', '2df99938-98b4-4472-a4c0-36cbee6be073', 199.5, 500),
	('Area Wilayah I', b'1', b'0', NULL, 'B 1242 SW', '35a41428-3349-45ef-af40-fcbaaa42a3c7', 200.79999999999998, 500),
	('Smart Bin Area A - Balai Desa', b'1', b'1', 'NETRADUMP-001', NULL, '4094bc42-9bd0-40ac-889c-345de5ad6198', NULL, NULL),
	('Area Wilayah H', b'1', b'0', NULL, 'B 1241 SW', '956186bd-4a29-4e18-a49d-180ad4289cf7', 106.60000000000002, 500),
	('Area Wilayah D', b'1', b'0', NULL, 'B 1237 SW', '98419feb-da21-4d78-97bf-62a2199d6c8c', 148.9, 500),
	('Area Wilayah G', b'1', b'0', NULL, 'B 1240 SW', '9a398868-8a1f-4e30-9872-e887e380af93', 110.8, 500),
	('Area Wilayah F', b'1', b'0', NULL, 'B 1239 SW', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', 204.29999999999998, 500),
	('Area Wilayah A', b'1', b'0', NULL, 'B 1234 SW', 'e2037d74-845a-40bf-868b-a0807f1a08e4', 145.69999999999996, 500);

-- Dumping structure for table db_tubes_pbo_trinetra.collector_notifications
DROP TABLE IF EXISTS collector_notifications;
CREATE TABLE IF NOT EXISTS `collector_notifications` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `read_status` bit(1) NOT NULL,
  `title` varchar(255) NOT NULL,
  `collector_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK147252bx2f418se0c2hmohxqo` (`collector_id`),
  CONSTRAINT `FK147252bx2f418se0c2hmohxqo` FOREIGN KEY (`collector_id`) REFERENCES `collectors` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.collector_notifications: ~0 rows (approximately)

-- Dumping structure for table db_tubes_pbo_trinetra.green_wallets
DROP TABLE IF EXISTS green_wallets;
CREATE TABLE IF NOT EXISTS `green_wallets` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `redeemed_points` double NOT NULL,
  `total_points` double NOT NULL,
  `citizen_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iv38bt9mjks8qux51i4o457x7` (`citizen_id`),
  CONSTRAINT `FK1jtobabq932ruksxppbb29g71` FOREIGN KEY (`citizen_id`) REFERENCES `citizens` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.green_wallets: ~51 rows (approximately)
INSERT INTO `green_wallets` (`id`, `created_at`, `updated_at`, `redeemed_points`, `total_points`, `citizen_id`) VALUES
	('01d86f10-c13b-40d9-8ee8-c1239ba4cfa3', '2026-04-26 15:25:35.572994', '2026-04-26 21:51:28.755782', 0, 5225, '5f788d55-dfcf-456f-8c1e-c1df967691d5'),
	('02ac8079-d5ae-4c99-a5e8-fcc82fcafed1', '2026-04-26 15:25:16.747829', '2026-04-26 21:51:26.853636', 0, 5478, '8fe94d3d-1a51-41d8-a0ca-b9e2e49959c3'),
	('04fb6368-4f92-4004-9086-34e5c11f5e90', '2026-04-26 15:25:30.421836', '2026-04-26 21:51:26.900005', 0, 3898, 'a1fdb247-7f63-414a-b34e-5f379a505c55'),
	('11f4420c-3483-4a96-8ff0-523e542a6740', '2026-04-12 21:43:54.521683', '2026-04-26 23:56:01.731286', 0, 1846.4, '0da6dd2b-486c-4e0e-a99e-83d7a36d155f'),
	('19d50a55-fef6-431e-bc1f-d7adcb6d8aad', '2026-04-26 15:25:42.507364', '2026-04-26 21:51:29.389725', 0, 1893, '88c9c96f-639a-44b0-ac1e-ceca300374c0'),
	('1e8a3712-544e-4a85-ac8b-c83ab96884bd', '2026-04-26 15:25:45.899567', '2026-04-26 21:51:28.118535', 0, 2232, '7b644e69-dde6-45e9-864e-6d1eee7ff0c5'),
	('274b6658-e5c7-4b0b-90f9-4cfe1e78425d', '2026-04-26 15:25:44.207644', '2026-04-26 21:51:29.196123', 0, 2407, '43095137-df51-4004-b68d-b31d1e3adb20'),
	('2967c1f5-ef94-4861-b17d-0118733d272a', '2026-04-26 15:25:43.362351', '2026-04-26 21:51:28.215060', 0, 4622, 'eb4c2239-f108-4c78-ac9e-ad354bd546fd'),
	('33a362d7-bf8c-463a-8fe3-3a5a7a26cff0', '2026-04-26 15:25:13.436847', '2026-04-26 21:51:29.249765', 0, 7574, '3c413d07-5996-4313-8401-011b46ebf9e1'),
	('38522fd7-3216-4abb-a1c0-eb0a217ea23a', '2026-04-26 15:25:29.616863', '2026-04-26 21:51:29.091500', 0, 6156, 'd5f5c72d-3971-4a5a-842b-375b03183b8c'),
	('38a6cece-4165-42a6-9648-7e6bcbd78237', '2026-04-26 15:25:47.609063', '2026-04-26 21:51:25.243778', 0, 5301, '4981c6f4-bf64-4ba2-8bd8-54a3d89c1935'),
	('3be6b0a0-6562-4c53-b6dd-c861f689569e', '2026-04-26 15:25:36.438158', '2026-04-26 21:51:26.803343', 0, 3523, 'c0f5bf5a-94a4-42e7-8a3a-c30a9ca10faf'),
	('512a2dd8-5876-40e8-88a3-b03f066184d8', '2026-04-26 15:25:19.176568', '2026-04-26 21:51:27.043915', 0, 251, 'c661afad-1d0d-481f-87f9-8655bbb2a105'),
	('537173d9-8936-4dd0-9c32-e485ffc718aa', '2026-04-26 15:25:48.505401', '2026-04-26 21:51:27.188251', 0, 4006, 'c96f1890-97aa-4284-be5d-89130bc13f32'),
	('54c45f0b-f651-4a1e-b889-74b8548fa66d', '2026-04-26 15:25:26.194019', '2026-04-26 23:54:54.823075', 0, 4758, '4296719f-5bc4-4c7e-899f-c6718bc96c1a'),
	('5509ef9f-95dc-4287-8686-ff3674f9e185', '2026-04-26 15:25:53.770420', '2026-04-26 21:51:28.704387', 0, 6030, '3b4d284b-cd14-4940-8aac-ea5a2a917ab6'),
	('5d69fa02-119e-4915-8a81-884df74ebf91', '2026-04-26 15:25:17.868769', '2026-04-26 21:51:28.801467', 0, 4641, '93bc354a-e558-4ea4-a613-7c8ed28dff63'),
	('5ea73379-60f3-4104-817f-1c5fb7797e5e', '2026-04-26 15:25:32.088875', '2026-04-26 21:51:27.817988', 0, 948, '9fdfd91d-f237-4346-9c38-04fb9be9a98c'),
	('656a4a2b-2e78-418c-9538-ecf4c745f994', '2026-04-26 15:25:46.742221', '2026-04-26 21:51:27.722691', 0, 5629, '71b10466-8e32-49d2-bdc5-814c7387915b'),
	('69bee86f-4ad1-4e1f-abe2-ba626aae8d75', '2026-04-26 15:25:51.269248', '2026-04-26 21:51:27.614721', 0, 3391, 'bd2dc7f2-90dd-4644-9c9f-0241edaab70b'),
	('6cf59034-45f6-4b97-a112-fdcb264c680b', '2026-04-26 15:25:52.956456', '2026-04-26 21:51:25.198375', 0, 4403, 'f9404ec0-2243-435e-a8eb-04f2902794e3'),
	('79960f8d-0bf0-4ca9-9a84-bbc6a1ccc729', '2026-04-26 15:25:55.452586', '2026-04-26 23:56:09.303848', 0, 3742.2, '220150b6-a277-4a6e-b467-6152fe1c23ed'),
	('8238af0c-2cdb-4e2e-98f3-704654cdfa0f', '2026-04-26 15:25:45.067019', '2026-04-26 21:51:23.676518', 0, 5298, '7f02c92e-ac34-49a8-8698-b32986ea2ee1'),
	('825a9507-dc69-4730-9c1f-7fae7314b9d0', '2026-04-26 15:25:23.199357', '2026-04-26 15:25:23.199357', 0, 3598, 'c230d565-bf47-4ecb-a9c3-9f01a854eb0d'),
	('82920df2-66dd-4efe-9435-a780a75c9a18', '2026-04-26 15:25:14.521473', '2026-04-26 21:51:26.998607', 0, 837, '18b62ad3-019a-48dd-b3e0-d4801e35b97f'),
	('83dd24fe-8b1a-43df-a697-bfc87976f48e', '2026-04-26 15:25:39.129712', '2026-04-26 21:51:29.045199', 0, 5880, '5f82c431-faab-4f52-9946-477a5403f451'),
	('84af498e-3271-4b1c-9392-e9c3425b6d09', '2026-04-26 15:25:31.241734', '2026-04-26 21:51:27.520900', 0, 2909, 'f02d9684-0501-4386-b3c4-7799a1a42804'),
	('86fb5539-7348-43ee-b8db-d305e3a029e7', '2026-04-26 15:25:50.471649', '2026-04-26 21:51:28.526773', 0, 1360, 'd8b68cd6-d9e6-4ae7-9a3f-170c2e5c79c3'),
	('889d876a-5eb5-4549-a502-aba59024b00a', '2026-04-26 15:25:20.377715', '2026-04-26 21:51:25.454511', 0, 4520, 'f052b52b-edf6-4546-985b-cf7cb4d52d4e'),
	('8d95f7be-e3b2-4163-84ff-0dbb25dee050', '2026-04-26 15:25:52.093462', '2026-04-26 21:51:24.236887', 0, 5248, 'd7dc83d2-5897-42be-ae6c-447296eb1c97'),
	('923ec50c-b68b-4493-b34c-c6a62aac02a5', '2026-04-26 15:25:38.273170', '2026-04-26 21:51:28.608646', 0, 2588, '482c6ffd-db87-40fb-b8a7-eb962c9ddb30'),
	('988fe501-805b-4ad1-9165-408a9fbaaf8b', '2026-04-26 15:25:24.172849', '2026-04-26 21:51:28.568101', 0, 3311, '83741056-db1c-43a6-9ad7-3a12e2d75d06'),
	('a05c313e-5e2c-4033-8bff-5bfc5693356a', '2026-04-26 15:25:54.612528', '2026-04-26 21:51:27.864632', 0, 3554, '7fda2150-942f-4283-b964-cdf04e467c10'),
	('a08377d1-d043-456e-8696-c67ea6936ea5', '2026-04-26 15:25:33.777781', '2026-04-26 21:51:29.493591', 0, 7173, 'fa469c10-ad7f-404b-b96d-986f0b650e1b'),
	('a3758382-5c3e-457d-a6fe-1ade0db07590', '2026-04-26 15:25:56.333083', '2026-04-26 21:51:23.869556', 0, 830, '1506fec1-f2ff-4bc8-99a0-8c56ae0f7007'),
	('a4adcdf3-e128-41fc-a8d7-8a2fa2536c26', '2026-04-26 15:25:58.111027', '2026-04-26 21:51:29.440065', 0, 6583, 'dfe9a4e0-bddf-4263-a44a-208b4357daae'),
	('a5341632-e68e-42ab-9ead-42cc14bcc81e', '2026-04-26 15:25:41.672269', '2026-04-26 21:51:28.013999', 0, 8224, '7d2ccc7a-c37c-4c88-87d1-bc474486fb6a'),
	('aeb49155-e78d-4f02-b75a-83e4dd83c897', '2026-04-26 15:25:22.299676', '2026-04-26 21:51:27.469629', 0, 2299, 'bffb0d79-03cf-4a88-9219-b00db794c1f6'),
	('b9d86da9-9f17-44a9-9e1c-866a7fc85536', '2026-04-26 15:25:27.855152', '2026-04-26 23:54:43.460616', 0, 550.4, '36f06de1-3827-4a6c-986e-9bacbcb4d4f4'),
	('b9de14af-68e8-47d0-b7a8-8eebc4a3b750', '2026-04-26 15:25:57.226065', '2026-04-26 21:51:25.059640', 0, 647, '0fb8dd2e-679d-4c87-b837-6964b9526fa7'),
	('ba7b102f-00e4-4123-8ff2-15e79b54418a', '2026-04-26 15:25:37.363592', '2026-04-26 15:25:37.363592', 0, 2013, '9e1ec042-85f8-4272-94f1-d7e7cfb8f5d3'),
	('bae4ff7f-b960-4100-95dc-ed481b4aef94', '2026-04-26 15:25:27.005065', '2026-04-26 21:51:25.781712', 0, 4656, '10e873da-3daf-47d6-8045-faee4402daf1'),
	('c7cf78de-d8a4-4ae2-b191-f850f35a3f3f', '2026-04-26 15:25:34.676823', '2026-04-26 21:51:22.326004', 0, 2404, 'e7e5884e-1720-44d0-b3d5-d091698e3524'),
	('caf63fab-025b-402e-bcde-520360e9dc63', '2026-04-26 15:25:32.935894', '2026-04-26 21:51:29.345627', 0, 2489, '85945231-e152-43ae-8b76-d6a27d999e8b'),
	('d10b28cc-1d18-4dbc-a9c5-f2ca4bb6e0e3', '2026-04-26 15:25:49.554305', '2026-04-26 21:51:23.919101', 0, 579, 'a085dd41-6103-4858-a2b0-417dbb93de09'),
	('d1deabdb-a887-4c64-b6d5-075ff52051bb', '2026-04-26 15:25:28.764037', '2026-04-26 21:51:26.947108', 0, 9214, '735016c5-7255-46ee-9031-9ed94a27d90f'),
	('dfadba59-d185-4842-b61c-05a83b5c1490', '2026-04-26 15:25:25.259739', '2026-04-26 21:51:24.712329', 0, 1917, '62e88cb0-1c54-4f23-bfc7-2eab9db66a46'),
	('e07930fc-14a9-4c87-9b97-ad3481aeebff', '2026-04-26 15:25:40.001018', '2026-04-26 21:51:28.955241', 0, 4395, 'b8566336-b51f-49d4-a838-dbac75545acc'),
	('e2987631-9904-4d12-8a57-612349e09520', '2026-04-26 15:25:21.290146', '2026-04-26 21:51:29.299524', 0, 2262, 'ce9dd90d-0a34-490f-ab94-95f5edc129bd'),
	('e8f8ef3b-a576-4105-944e-5370414b187c', '2026-04-26 15:25:40.836992', '2026-04-26 21:51:29.144386', 0, 3584, '38e4112c-2738-418f-9583-6b71903324d6'),
	('e9431380-ff0c-4d93-a2f1-79e6a96e1bd6', '2026-04-26 15:25:15.672272', '2026-04-26 21:51:25.736772', 0, 1629, 'da724c70-e971-422f-97eb-10c281e35326');

-- Dumping structure for table db_tubes_pbo_trinetra.password_reset_tokens
DROP TABLE IF EXISTS password_reset_tokens;
CREATE TABLE IF NOT EXISTS `password_reset_tokens` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `expiry_date` datetime(6) NOT NULL,
  `token` varchar(255) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_71lqwbwtklmljk3qlsugr1mig` (`token`),
  UNIQUE KEY `UK_la2ts67g4oh2sreayswhox1i6` (`user_id`),
  CONSTRAINT `FKk3ndxg5xp6v7wd4gjyusp15gq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.password_reset_tokens: ~0 rows (approximately)

-- Dumping structure for table db_tubes_pbo_trinetra.point_redemptions
DROP TABLE IF EXISTS point_redemptions;
CREATE TABLE IF NOT EXISTS `point_redemptions` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `admin_notes` text,
  `description` text NOT NULL,
  `points_redeemed` double NOT NULL,
  `reward_code` varchar(100) DEFAULT NULL,
  `status` enum('PENDING','APPROVED','REJECTED') NOT NULL,
  `citizen_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_redemption_citizen` (`citizen_id`),
  KEY `idx_redemption_status` (`status`),
  CONSTRAINT `FKehchtngar3nw5cb63d5vvojub` FOREIGN KEY (`citizen_id`) REFERENCES `citizens` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.point_redemptions: ~1 rows (approximately)
INSERT INTO `point_redemptions` (`id`, `created_at`, `updated_at`, `admin_notes`, `description`, `points_redeemed`, `reward_code`, `status`, `citizen_id`) VALUES
	('8c15e8b1-a0c7-4f8b-9a05-bdd28eded9a2', '2026-04-26 23:08:18.185622', '2026-04-26 23:08:18.185622', NULL, 'Minyak Goreng 2L', 800, NULL, 'PENDING', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f');





-- Dumping structure for table db_tubes_pbo_trinetra.waste_categories
DROP TABLE IF EXISTS waste_categories;
CREATE TABLE IF NOT EXISTS `waste_categories` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `active` bit(1) NOT NULL,
  `description` text,
  `icon_url` varchar(500) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `points_per_kg` double NOT NULL,
  `type` enum('ORGANIC','INORGANIC','B3') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.waste_categories: ~7 rows (approximately)
INSERT INTO `waste_categories` (`id`, `created_at`, `updated_at`, `active`, `description`, `icon_url`, `name`, `points_per_kg`, `type`) VALUES
	('032cc629-1ced-441c-9d92-418638f7ea0f', '2026-04-12 21:31:28.928126', '2026-04-12 21:31:28.928126', b'1', 'Kertas bekas, koran, majalah, kardus bersih yang dapat didaur ulang', '📦', 'Kertas & Kardus', 8, 'INORGANIC'),
	('22246f99-6f62-486c-bdeb-a43fd960b624', '2026-04-12 21:31:28.942473', '2026-04-12 21:31:28.942473', b'1', 'Kaleng minuman, kaleng makanan dari aluminium atau baja', '🥫', 'Kaleng Logam', 15, 'INORGANIC'),
	('446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '2026-04-12 21:31:28.890555', '2026-04-12 21:31:28.890555', b'1', 'Sampah organik dari kebun seperti daun kering dan ranting kecil', '🍃', 'Daun & Ranting', 3, 'ORGANIC'),
	('504d5b87-5675-4ce0-9bda-b8f305ebec10', '2026-04-12 21:31:28.913797', '2026-04-12 21:31:28.913797', b'1', 'Botol minuman plastik jenis PET yang dapat didaur ulang', '♻️', 'Botol Plastik (PET)', 12, 'INORGANIC'),
	('8efe8add-58ba-4181-8a5b-4c25e8cdef30', '2026-04-12 21:31:28.959472', '2026-04-12 21:31:28.959472', b'1', 'Baterai AA, AAA, baterai tombol, atau baterai lithium bekas — limbah B3', '🔋', 'Baterai Bekas', 30, 'B3'),
	('9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '2026-04-12 21:31:28.992487', '2026-04-12 21:31:28.992487', b'1', 'Handphone rusak, charger bekas, PCB, lampu LED/neon — limbah B3 elektronik', '💻', 'Elektronik & E-Waste', 50, 'B3'),
	('ed7cc969-180c-44d8-9a27-89f1d3743699', '2026-04-12 21:31:28.865670', '2026-04-12 21:31:28.865670', b'1', 'Sampah organik dari sisa makanan, sayuran, dan buah-buahan', '🍎', 'Sisa Makanan & Dapur', 5, 'ORGANIC');

-- Dumping structure for table db_tubes_pbo_trinetra.waste_deposits
DROP TABLE IF EXISTS waste_deposits;
CREATE TABLE IF NOT EXISTS `waste_deposits` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `confirmed_at` datetime(6) DEFAULT NULL,
  `from_iot` bit(1) NOT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  `iot_device_id` varchar(50) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `notes` text,
  `points_earned` double NOT NULL,
  `status` enum('PENDING','CONFIRMED','REJECTED') NOT NULL,
  `weight_kg` double NOT NULL,
  `category_id` varchar(36) NOT NULL,
  `citizen_id` varchar(36) NOT NULL,
  `collector_id` varchar(36) DEFAULT NULL,
  `pickup_proof_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_deposit_citizen` (`citizen_id`),
  KEY `idx_deposit_status` (`status`),
  KEY `idx_deposit_created` (`created_at`),
  KEY `FK7ttw8blddgf7ifnn1b879c964` (`category_id`),
  KEY `FKofw1j35wn4lxt591ee1ep9u8c` (`collector_id`),
  KEY `idx_deposit_date` (`created_at`),
  CONSTRAINT `FK7ttw8blddgf7ifnn1b879c964` FOREIGN KEY (`category_id`) REFERENCES `waste_categories` (`id`),
  CONSTRAINT `FKaomv4rm5jtsx733yn1wi2tr4k` FOREIGN KEY (`citizen_id`) REFERENCES `citizens` (`user_id`),
  CONSTRAINT `FKofw1j35wn4lxt591ee1ep9u8c` FOREIGN KEY (`collector_id`) REFERENCES `collectors` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_tubes_pbo_trinetra.waste_deposits: ~167 rows (approximately)
INSERT INTO `waste_deposits` (`id`, `created_at`, `updated_at`, `confirmed_at`, `from_iot`, `image_url`, `iot_device_id`, `location`, `notes`, `points_earned`, `status`, `weight_kg`, `category_id`, `citizen_id`, `collector_id`, `pickup_proof_url`) VALUES
	('058065ff-8f2a-40bc-b35b-15fc1819544a', '2026-04-01 18:37:21.027955', '2026-04-26 21:51:22.459543', '2026-04-01 22:37:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #12', 1292, 'CONFIRMED', 21.2, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '735016c5-7255-46ee-9031-9ed94a27d90f', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('061ef160-73d1-46ca-8af5-28ee27f1693e', '2026-04-22 01:07:21.027955', '2026-04-26 21:51:28.979681', '2026-04-22 04:07:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #140', 36, 'CONFIRMED', 2, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '38e4112c-2738-418f-9583-6b71903324d6', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('089d21e7-f682-4886-aa24-94f806ac2a30', '2026-04-16 03:27:21.027955', '2026-04-26 21:51:27.748126', '2026-04-16 06:27:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #116', 56, 'CONFIRMED', 11.2, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '38e4112c-2738-418f-9583-6b71903324d6', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('093389bc-9318-441f-91d0-c999a80b126e', '2026-04-26 23:08:03.616386', '2026-04-26 23:34:55.705606', '2026-04-26 23:34:55.698475', b'0', '/uploads/84166cfe-812f-4831-8e0a-6aa873a7366f.png', NULL, NULL, ' | DITOLAK: sdf', 0, 'REJECTED', 2, '032cc629-1ced-441c-9d92-418638f7ea0f', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', '245b8746-cf46-4a94-9148-58dd0315f2b5', NULL),
	('10a0d180-f35c-4537-9d0b-a80a28f9024c', '2026-04-11 13:04:21.027955', '2026-04-26 21:51:29.024801', '2026-04-11 16:04:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #141', 1052, 'CONFIRMED', 17.2, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '5f82c431-faab-4f52-9946-477a5403f451', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('11906e70-fbef-408c-984a-8fd2511dd0d8', '2026-04-04 15:54:21.027955', '2026-04-26 21:51:26.590598', '2026-04-04 19:54:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #92', 227, 'CONFIRMED', 10.1, '22246f99-6f62-486c-bdeb-a43fd960b624', 'bffb0d79-03cf-4a88-9219-b00db794c1f6', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('11b3d1e9-6a34-4497-a406-69992254b332', '2026-04-08 17:35:21.027955', '2026-04-26 21:51:24.060685', '2026-04-08 20:35:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #41', 118, 'CONFIRMED', 9.8, '032cc629-1ced-441c-9d92-418638f7ea0f', 'a1fdb247-7f63-414a-b34e-5f379a505c55', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('14825b3f-9169-4564-8fd9-2fa16c769523', '2026-04-25 02:18:21.027955', '2026-04-26 21:51:25.905068', '2026-04-25 03:18:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #78', 41, 'CONFIRMED', 13.7, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'dfe9a4e0-bddf-4263-a44a-208b4357daae', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('16a31024-9b8e-4cfc-bb79-f18e1dc25b61', '2026-04-19 10:00:21.027955', '2026-04-26 21:51:22.281901', '2026-04-19 13:00:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #10', 85, 'CONFIRMED', 4.7, '504d5b87-5675-4ce0-9bda-b8f305ebec10', 'e7e5884e-1720-44d0-b3d5-d091698e3524', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('1727a0e7-3f3b-4bd6-9a2b-3cc38336f374', '2026-04-25 18:12:21.027955', '2026-04-26 21:51:29.120978', '2026-04-25 22:12:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #143', 590, 'CONFIRMED', 5.7, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '38e4112c-2738-418f-9583-6b71903324d6', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('19ade533-dbb1-4886-b7ee-19e927d8b855', '2026-04-08 18:50:21.027955', '2026-04-26 21:51:27.700274', '2026-04-08 22:50:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #115', 1660, 'CONFIRMED', 16.4, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '71b10466-8e32-49d2-bdc5-814c7387915b', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('1b523708-1528-4d78-94f5-4485637fd620', '2026-03-28 07:05:21.027955', '2026-04-26 21:51:28.590111', '2026-03-28 09:05:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #132', 513, 'CONFIRMED', 22.8, '22246f99-6f62-486c-bdeb-a43fd960b624', '482c6ffd-db87-40fb-b8a7-eb962c9ddb30', '956186bd-4a29-4e18-a49d-180ad4289cf7', ''),
	('1e5e4f74-c4df-483b-b9ec-a81e4665ca47', '2026-04-22 01:45:21.027955', '2026-04-26 21:51:23.016417', '2026-04-22 04:45:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #21', 83, 'CONFIRMED', 16.5, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'd7dc83d2-5897-42be-ae6c-447296eb1c97', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('1ee95532-0233-41dc-88aa-a236499374d5', '2026-04-16 03:14:21.027955', '2026-04-26 21:51:25.480927', '2026-04-16 04:14:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #69', 18, 'CONFIRMED', 3.5, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'c96f1890-97aa-4284-be5d-89130bc13f32', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('1f44c47b-55c7-4bd7-83e0-b0321022e9d6', '2026-04-19 07:07:21.027955', '2026-04-26 21:51:28.781485', '2026-04-19 11:07:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #136', 66, 'CONFIRMED', 22.1, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '93bc354a-e558-4ea4-a613-7c8ed28dff63', '956186bd-4a29-4e18-a49d-180ad4289cf7', ''),
	('20c25b09-24d8-4245-aa08-535ac7c7c5a6', '2026-04-06 03:29:21.027955', '2026-04-26 21:51:25.715449', '2026-04-06 07:29:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #74', 130, 'CONFIRMED', 10.8, '032cc629-1ced-441c-9d92-418638f7ea0f', 'da724c70-e971-422f-97eb-10c281e35326', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('20e309cf-b1c5-4ead-8aad-ebcdde60eda5', '2026-03-29 18:54:21.027955', '2026-04-26 21:51:26.492175', '2026-03-29 19:54:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #90', 340, 'CONFIRMED', 18.9, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '5f82c431-faab-4f52-9946-477a5403f451', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('21f22da1-9715-4ac4-9982-ab00bc06689b', '2026-04-16 14:34:21.027955', '2026-04-26 21:51:27.646543', '2026-04-16 16:34:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #114', 102, 'CONFIRMED', 8.5, '032cc629-1ced-441c-9d92-418638f7ea0f', 'b8566336-b51f-49d4-a838-dbac75545acc', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('27782548-5e73-41ea-a5cb-70f5b4be7570', '2026-03-30 16:00:21.027955', '2026-04-26 21:51:23.847828', '2026-03-30 19:00:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #37', 25, 'CONFIRMED', 1.4, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '1506fec1-f2ff-4bc8-99a0-8c56ae0f7007', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', ''),
	('2ca5e737-1205-45ae-bb64-7e42bf6e2e39', '2026-03-31 22:59:21.027955', '2026-04-26 21:51:25.574650', '2026-04-01 01:59:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #71', 1720, 'CONFIRMED', 17, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'a1fdb247-7f63-414a-b34e-5f379a505c55', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('2d6b77ae-3049-4af4-98f5-5ca0867c9635', '2026-04-24 11:00:21.027955', '2026-04-26 21:51:22.193707', '2026-04-24 13:00:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #9', 1040, 'CONFIRMED', 10.2, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '735016c5-7255-46ee-9031-9ed94a27d90f', '1a61e6a1-3df0-4460-ac64-df177a973473', ''),
	('2da45848-c1f1-413d-8a47-829cf16db639', '2026-04-26 21:31:21.027955', '2026-04-26 23:49:02.444393', '2026-04-26 23:49:02.438226', b'0', NULL, NULL, '-6.9014,107.6335', 'Menunggu konfirmasi petugas #2 | DITOLAK: dsdsd', 0, 'REJECTED', 14, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'f052b52b-edf6-4546-985b-cf7cb4d52d4e', '245b8746-cf46-4a94-9148-58dd0315f2b5', NULL),
	('3212abaf-5416-4d7f-92bb-95243d95090a', '2026-04-11 10:49:21.027955', '2026-04-26 21:51:24.849449', '2026-04-11 14:49:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #56', 232, 'CONFIRMED', 12.9, '504d5b87-5675-4ce0-9bda-b8f305ebec10', 'eb4c2239-f108-4c78-ac9e-ad354bd546fd', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('35f18418-9dcb-40aa-b7c3-c37d30e3a6e5', '2026-03-31 23:19:21.027955', '2026-04-26 21:51:28.824844', '2026-04-01 03:19:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #137', 170, 'CONFIRMED', 2.5, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('36f7f1b4-7f08-41ff-852f-912f2a9cc465', '2026-04-15 10:58:21.027955', '2026-04-26 21:51:23.485174', '2026-04-15 13:58:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #30', 4, 'CONFIRMED', 1.2, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'a085dd41-6103-4858-a2b0-417dbb93de09', '1a61e6a1-3df0-4460-ac64-df177a973473', ''),
	('379a8e3b-cbd7-4822-ae4a-2e5dac717153', '2026-04-15 22:23:21.027955', '2026-04-26 21:51:28.683255', '2026-04-16 00:23:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #134', 11, 'CONFIRMED', 0.9, '032cc629-1ced-441c-9d92-418638f7ea0f', '3b4d284b-cd14-4940-8aac-ea5a2a917ab6', '956186bd-4a29-4e18-a49d-180ad4289cf7', ''),
	('37bcdfa7-d752-472c-8905-5890d3024e89', '2026-04-22 08:08:21.027955', '2026-04-26 21:51:29.370778', '2026-04-22 12:08:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #148', 53, 'CONFIRMED', 10.6, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '88c9c96f-639a-44b0-ac1e-ceca300374c0', '1a61e6a1-3df0-4460-ac64-df177a973473', ''),
	('388da40d-1aaa-4c77-947d-cfe7c4e846d1', '2026-04-24 11:56:21.027955', '2026-04-26 21:51:24.371222', '2026-04-24 15:56:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #47', 86, 'CONFIRMED', 7.2, '032cc629-1ced-441c-9d92-418638f7ea0f', 'c661afad-1d0d-481f-87f9-8655bbb2a105', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('3898a2f0-9e3c-4a16-9f90-4f72043fa98d', '2026-04-17 06:27:21.027955', '2026-04-26 21:51:27.302953', '2026-04-17 08:27:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #107', 118, 'CONFIRMED', 23.6, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'bd2dc7f2-90dd-4644-9c9f-0241edaab70b', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('397d6e1d-da6d-483c-b544-fb68faddea7b', '2026-04-08 02:24:21.027955', '2026-04-26 21:51:25.130868', '2026-04-08 04:24:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #62', 179, 'CONFIRMED', 14.9, '032cc629-1ced-441c-9d92-418638f7ea0f', '5f788d55-dfcf-456f-8c1e-c1df967691d5', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('39a63fa0-7ff9-4fdb-8fc5-0466c7a1c25f', '2026-04-02 01:07:21.027955', '2026-04-26 21:51:28.635838', '2026-04-02 02:07:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #133', 938, 'CONFIRMED', 15.3, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '3b4d284b-cd14-4940-8aac-ea5a2a917ab6', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', ''),
	('3ab8abd4-085c-4aaf-a159-6a1ba75a6144', '2026-04-03 02:28:21.027955', '2026-04-26 21:51:25.331469', '2026-04-03 04:28:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #66', 68, 'CONFIRMED', 22.7, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '7b644e69-dde6-45e9-864e-6d1eee7ff0c5', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('3b9a1d4f-6826-430b-be68-91d8420f308d', '2026-04-18 13:57:21.027955', '2026-04-26 21:51:26.240691', '2026-04-18 16:57:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #85', 550, 'CONFIRMED', 5.3, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'c96f1890-97aa-4284-be5d-89130bc13f32', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('3e119250-e064-4533-b335-7d3e33e147c0', '2026-04-09 01:54:21.027955', '2026-04-26 21:51:23.275944', '2026-04-09 05:54:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #26', 122, 'CONFIRMED', 24.3, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '8fe94d3d-1a51-41d8-a0ca-b9e2e49959c3', '1a61e6a1-3df0-4460-ac64-df177a973473', ''),
	('4029ebcf-7e79-47a1-aa93-24636153bf88', '2026-04-06 04:23:21.027955', '2026-04-26 21:51:26.444327', '2026-04-06 05:23:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #89', 389, 'CONFIRMED', 17.3, '22246f99-6f62-486c-bdeb-a43fd960b624', 'bd2dc7f2-90dd-4644-9c9f-0241edaab70b', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('4209beeb-7139-4d07-a280-ecac3dce1165', '2026-04-08 02:31:21.027955', '2026-04-26 21:51:22.011772', '2026-04-08 06:31:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #7', 11, 'CONFIRMED', 0.9, '032cc629-1ced-441c-9d92-418638f7ea0f', '7fda2150-942f-4283-b964-cdf04e467c10', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('4248472c-bd75-4b69-8aa3-b28782c8771b', '2026-04-21 21:21:21.027955', '2026-04-26 21:51:27.350378', '2026-04-22 01:21:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #108', 716, 'CONFIRMED', 11.6, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '5f82c431-faab-4f52-9946-477a5403f451', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('430eb5c3-9c9a-4ce5-9624-2b98442c98c1', '2026-04-26 19:52:21.027955', '2026-04-26 21:51:29.556509', NULL, b'0', NULL, NULL, '-6.8905,107.6407', 'Menunggu konfirmasi petugas #3', 0, 'PENDING', 11.3, '22246f99-6f62-486c-bdeb-a43fd960b624', 'bffb0d79-03cf-4a88-9219-b00db794c1f6', NULL, NULL),
	('4628f7c7-e964-4bbc-8434-c370e03fbe94', '2026-04-26 20:45:21.027955', '2026-04-26 23:54:43.460100', '2026-04-26 23:54:43.420597', b'0', NULL, NULL, '-6.8948,107.6362', 'Menunggu konfirmasi petugas #9', 116.4, 'CONFIRMED', 9.7, '032cc629-1ced-441c-9d92-418638f7ea0f', '36f06de1-3827-4a6c-986e-9bacbcb4d4f4', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('46f4d4d4-b4b1-440d-ab11-134ff6196a46', '2026-04-08 17:42:21.027955', '2026-04-26 21:51:26.086765', '2026-04-08 21:42:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #82', 73, 'CONFIRMED', 6.1, '032cc629-1ced-441c-9d92-418638f7ea0f', 'bd2dc7f2-90dd-4644-9c9f-0241edaab70b', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('47ac5d15-76af-440b-a6f8-b6fae4b5a0b3', '2026-04-26 21:35:21.027955', '2026-04-26 23:48:49.201887', '2026-04-26 23:48:49.193387', b'0', NULL, NULL, '-6.9064,107.6299', 'Menunggu konfirmasi petugas #1 | DITOLAK: sfdv', 0, 'REJECTED', 2.6, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'f052b52b-edf6-4546-985b-cf7cb4d52d4e', '245b8746-cf46-4a94-9148-58dd0315f2b5', NULL),
	('48c9f664-f92e-4320-8142-bd8c7303a4b4', '2026-04-17 19:53:21.027955', '2026-04-26 21:51:26.831515', '2026-04-17 22:53:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #97', 512, 'CONFIRMED', 8.2, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '8fe94d3d-1a51-41d8-a0ca-b9e2e49959c3', '956186bd-4a29-4e18-a49d-180ad4289cf7', ''),
	('4d2a37ec-f7eb-4fc1-987b-0764362e0411', '2026-04-26 20:03:21.027955', '2026-04-26 23:56:09.302846', '2026-04-26 23:56:09.288628', b'0', NULL, NULL, '-6.8920,107.6296', 'Menunggu konfirmasi petugas #5', 67.2, 'CONFIRMED', 5.6, '032cc629-1ced-441c-9d92-418638f7ea0f', '220150b6-a277-4a6e-b467-6152fe1c23ed', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('4ddc5c84-237e-4cd9-9612-253fe4a729b9', '2026-04-16 09:06:21.027955', '2026-04-26 21:51:24.470748', '2026-04-16 11:06:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #49', 495, 'CONFIRMED', 22, '22246f99-6f62-486c-bdeb-a43fd960b624', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('4dfd30a3-2fe3-42ae-b994-2103a99ca1d8', '2026-04-06 18:22:21.027955', '2026-04-26 21:51:26.396794', '2026-04-06 19:22:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #88', 140, 'CONFIRMED', 1.2, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '482c6ffd-db87-40fb-b8a7-eb962c9ddb30', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('53dc52ec-a0e1-4a2a-83f1-38c74b176ce3', '2026-04-11 13:02:21.027955', '2026-04-26 21:51:22.594730', '2026-04-11 14:02:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #14', 49, 'CONFIRMED', 9.7, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '88c9c96f-639a-44b0-ac1e-ceca300374c0', '956186bd-4a29-4e18-a49d-180ad4289cf7', ''),
	('551b3919-1263-48b6-bfa4-f54ac3aed9d4', '2026-04-20 01:07:21.027955', '2026-04-26 21:51:23.433715', '2026-04-20 03:07:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #29', 58, 'CONFIRMED', 19.3, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'a085dd41-6103-4858-a2b0-417dbb93de09', '1a61e6a1-3df0-4460-ac64-df177a973473', ''),
	('56031f73-ad44-4c5d-8bee-c02977fe8e4a', '2026-03-28 07:07:21.027955', '2026-04-26 21:51:28.549386', '2026-03-28 08:07:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #131', 1620, 'CONFIRMED', 16, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '83741056-db1c-43a6-9ad7-3a12e2d75d06', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('58c0f6bf-b50d-4449-877d-c43bacdabf63', '2026-04-14 14:44:21.027955', '2026-04-26 21:51:24.264017', '2026-04-14 16:44:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #45', 104, 'CONFIRMED', 8.7, '032cc629-1ced-441c-9d92-418638f7ea0f', 'f02d9684-0501-4386-b3c4-7799a1a42804', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('58c7ef16-a22a-4e1b-8fe6-a6a2ab2049b5', '2026-04-22 07:02:21.027955', '2026-04-26 21:51:23.067576', '2026-04-22 10:02:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #22', 68, 'CONFIRMED', 13.5, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '482c6ffd-db87-40fb-b8a7-eb962c9ddb30', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('58e07537-1341-4b3f-9e93-4a59974e9d56', '2026-04-04 07:00:21.027955', '2026-04-26 21:51:21.896800', '2026-04-04 11:00:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #6', 170, 'CONFIRMED', 2.5, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', 'f052b52b-edf6-4546-985b-cf7cb4d52d4e', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('5d33efd9-5f5f-495a-b42c-a92cd56add3d', '2026-03-29 20:28:21.027955', '2026-04-26 21:51:23.222677', '2026-03-29 23:28:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #25', 162, 'CONFIRMED', 9, '504d5b87-5675-4ce0-9bda-b8f305ebec10', 'd8b68cd6-d9e6-4ae7-9a3f-170c2e5c79c3', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('668bdc78-d99f-4643-9eaa-f1b794ef23eb', '2026-04-05 17:45:21.027955', '2026-04-26 21:51:27.449735', '2026-04-05 19:45:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #110', 5, 'CONFIRMED', 1.6, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'bffb0d79-03cf-4a88-9219-b00db794c1f6', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('68449b15-ad68-4853-ba17-dcc48e2601dc', '2026-04-13 03:23:21.027955', '2026-04-26 21:51:21.780761', '2026-04-13 04:23:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #5', 114, 'CONFIRMED', 22.8, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'bffb0d79-03cf-4a88-9219-b00db794c1f6', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('6a29160b-249f-483f-9450-c362c9df7acd', '2026-03-30 13:00:21.027955', '2026-04-26 21:51:24.748055', '2026-03-30 17:00:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #54', 158, 'CONFIRMED', 8.8, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '3c413d07-5996-4313-8401-011b46ebf9e1', '1a61e6a1-3df0-4460-ac64-df177a973473', ''),
	('6d403039-c60b-437b-8687-dc413bf2526a', '2026-04-12 22:21:37.735085', '2026-04-12 22:22:27.472994', '2026-04-12 22:22:27.440772', b'0', NULL, NULL, NULL, '', 14.4, 'CONFIRMED', 1.2, '032cc629-1ced-441c-9d92-418638f7ea0f', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', '245b8746-cf46-4a94-9148-58dd0315f2b5', NULL),
	('6d4ebd2a-ce53-4701-ae95-456ac22ea3e8', '2026-04-06 03:55:58.946633', '2026-04-26 21:49:59.141898', '2026-04-06 04:55:58.946633', b'0', NULL, NULL, NULL, 'Setoran dummy #2', 580, 'CONFIRMED', 5.6, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '8fe94d3d-1a51-41d8-a0ca-b9e2e49959c3', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('6d922671-9e90-4186-ac01-46a49e574004', '2026-03-29 17:50:21.027955', '2026-04-26 21:51:21.559985', '2026-03-29 18:50:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #3', 63, 'CONFIRMED', 3.5, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '10e873da-3daf-47d6-8045-faee4402daf1', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('717a8e8a-1769-4766-8472-aac5d7ebddde', '2026-04-11 22:09:21.027955', '2026-04-26 21:51:24.619728', '2026-04-12 02:09:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #52', 45, 'CONFIRMED', 15, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '88c9c96f-639a-44b0-ac1e-ceca300374c0', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('72f4d77a-68f0-46d0-9bef-62ee2cca6cd7', '2026-04-25 22:15:21.027955', '2026-04-26 21:51:23.592667', '2026-04-26 00:15:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #32', 18, 'CONFIRMED', 3.5, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '10e873da-3daf-47d6-8045-faee4402daf1', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('7522c6b0-343d-4151-b63b-67c9dd7f38cf', '2026-03-27 21:55:21.027955', '2026-04-26 21:51:26.976350', '2026-03-27 22:55:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #100', 398, 'CONFIRMED', 17.7, '22246f99-6f62-486c-bdeb-a43fd960b624', '18b62ad3-019a-48dd-b3e0-d4801e35b97f', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('75702edd-c104-43e8-8b91-8103b1cb5c9e', '2026-04-12 12:47:21.027955', '2026-04-26 21:51:24.669647', '2026-04-12 15:47:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #53', 1150, 'CONFIRMED', 11.3, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '62e88cb0-1c54-4f23-bfc7-2eab9db66a46', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('763db2a8-a9bb-4e96-98cb-17544fee9713', '2026-04-09 00:45:21.027955', '2026-04-26 21:51:26.637405', '2026-04-09 04:45:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #93', 67, 'CONFIRMED', 13.3, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'ce9dd90d-0a34-490f-ab94-95f5edc129bd', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('76484165-54d4-4b18-9394-9fbdd0f9d955', '2026-04-23 23:10:21.027955', '2026-04-26 21:51:24.988486', '2026-04-24 02:10:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #59', 480, 'CONFIRMED', 4.6, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'dfe9a4e0-bddf-4263-a44a-208b4357daae', '956186bd-4a29-4e18-a49d-180ad4289cf7', ''),
	('787821c5-b390-4763-96b5-788960eef037', '2026-04-07 07:18:21.027955', '2026-04-26 21:51:24.895608', '2026-04-07 09:18:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #57', 8, 'CONFIRMED', 2.6, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '7b644e69-dde6-45e9-864e-6d1eee7ff0c5', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('79bd490f-c907-4614-b9b4-0a5a49c88d3d', '2026-04-20 09:14:21.027955', '2026-04-26 21:51:26.292351', '2026-04-20 12:14:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #86', 104, 'CONFIRMED', 4.6, '22246f99-6f62-486c-bdeb-a43fd960b624', '3b4d284b-cd14-4940-8aac-ea5a2a917ab6', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('79d5b8b4-63a2-4d74-8310-1abb1e435c4c', '2026-04-11 07:19:21.027955', '2026-04-26 21:51:23.705398', '2026-04-11 11:19:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #34', 137, 'CONFIRMED', 7.6, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '1506fec1-f2ff-4bc8-99a0-8c56ae0f7007', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('7a16b251-57f7-4600-8195-7c23c9b14b2c', '2026-03-29 07:37:21.027955', '2026-04-26 21:51:27.118763', '2026-03-29 09:37:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #103', 4, 'CONFIRMED', 0.7, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'c96f1890-97aa-4284-be5d-89130bc13f32', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('7cb4ba20-0046-4e72-865b-76ff777bad15', '2026-03-30 20:06:21.027955', '2026-04-26 21:51:25.177824', '2026-03-30 23:06:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #63', 944, 'CONFIRMED', 15.4, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', 'f9404ec0-2243-435e-a8eb-04f2902794e3', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('7d851ef3-b9f9-4e9c-bcd6-5e6638a795ef', '2026-04-19 03:52:21.027955', '2026-04-26 21:51:27.167358', '2026-04-19 05:52:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #104', 29, 'CONFIRMED', 1.3, '22246f99-6f62-486c-bdeb-a43fd960b624', 'c96f1890-97aa-4284-be5d-89130bc13f32', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('7f197c24-4936-41b7-b065-10f4a5df923c', '2026-04-03 04:24:21.027955', '2026-04-26 21:51:27.943624', '2026-04-03 06:24:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #120', 160, 'CONFIRMED', 7.1, '22246f99-6f62-486c-bdeb-a43fd960b624', '88c9c96f-639a-44b0-ac1e-ceca300374c0', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('822b6ecf-ff6b-4ec2-942c-9bc02c4dd6b2', '2026-03-29 17:48:58.946633', '2026-04-26 21:49:59.220677', '2026-03-29 18:48:58.946633', b'0', NULL, NULL, NULL, 'Setoran dummy #3', 63, 'CONFIRMED', 3.5, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '10e873da-3daf-47d6-8045-faee4402daf1', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('8295e024-2cef-4d65-a9c4-9d06775b12d6', '2026-04-06 17:57:21.027955', '2026-04-26 21:51:28.928991', '2026-04-06 19:57:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #139', 304, 'CONFIRMED', 13.5, '22246f99-6f62-486c-bdeb-a43fd960b624', 'b8566336-b51f-49d4-a838-dbac75545acc', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('852073a7-048f-4d92-8442-24c6e1376f0c', '2026-04-08 09:54:21.027955', '2026-04-26 21:51:27.399948', '2026-04-08 11:54:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #109', 81, 'CONFIRMED', 3.6, '22246f99-6f62-486c-bdeb-a43fd960b624', '43095137-df51-4004-b68d-b31d1e3adb20', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('87d8e1b3-914a-48b9-82bf-c3b5d2ade8c9', '2026-04-16 21:14:21.027955', '2026-04-26 21:51:28.147931', '2026-04-17 00:14:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #124', 23, 'CONFIRMED', 7.7, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '5f788d55-dfcf-456f-8c1e-c1df967691d5', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('88766f08-9470-4b47-98a0-73d7536793bd', '2026-04-05 18:44:21.027955', '2026-04-26 21:51:25.037670', '2026-04-05 21:44:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #60', 11, 'CONFIRMED', 3.5, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '0fb8dd2e-679d-4c87-b837-6964b9526fa7', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('8a39172b-c36d-4f35-aed8-1dc3ccf755b3', '2026-04-05 13:43:21.027955', '2026-04-26 21:51:28.043943', '2026-04-05 15:43:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #122', 72, 'CONFIRMED', 4, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '4296719f-5bc4-4c7e-899f-c6718bc96c1a', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('8cffbd59-61ec-4410-921b-74bec984c422', '2026-04-04 23:46:21.027955', '2026-04-26 21:51:23.122387', '2026-04-05 00:46:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #23', 391, 'CONFIRMED', 21.7, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', '956186bd-4a29-4e18-a49d-180ad4289cf7', ''),
	('8d87c262-b6a7-4f95-b740-fa35ccef1830', '2026-04-16 04:19:21.027955', '2026-04-26 21:51:23.537686', '2026-04-16 07:19:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #31', 1322, 'CONFIRMED', 21.7, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '735016c5-7255-46ee-9031-9ed94a27d90f', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('8d8a4acc-39c9-4f29-b530-2f9639ee750e', '2026-04-23 21:53:21.027955', '2026-04-26 21:51:26.879063', '2026-04-24 01:53:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #98', 55, 'CONFIRMED', 11, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'a1fdb247-7f63-414a-b34e-5f379a505c55', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('93d74469-a719-469a-8c8c-edaf8a18acbc', '2026-04-07 12:27:21.027955', '2026-04-26 21:51:29.071077', '2026-04-07 15:27:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #142', 43, 'CONFIRMED', 14.3, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'd5f5c72d-3971-4a5a-842b-375b03183b8c', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('9419f496-2e90-4fa3-badf-661f4890530e', '2026-04-26 19:42:21.027955', '2026-04-26 21:51:29.662311', NULL, b'0', NULL, NULL, '-6.9031,107.6303', 'Menunggu konfirmasi petugas #10', 0, 'PENDING', 5.1, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '18b62ad3-019a-48dd-b3e0-d4801e35b97f', NULL, NULL),
	('980aa5c1-112b-4e04-9026-94e62c1e0fee', '2026-04-05 03:29:21.027955', '2026-04-26 21:51:26.544776', '2026-04-05 06:29:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #91', 15, 'CONFIRMED', 4.9, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '88c9c96f-639a-44b0-ac1e-ceca300374c0', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('99e23eff-6754-4c07-baf5-bd42a912d141', '2026-04-21 22:14:21.027955', '2026-04-26 21:51:26.782516', '2026-04-22 01:14:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #96', 1148, 'CONFIRMED', 18.8, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', 'c0f5bf5a-94a4-42e7-8a3a-c30a9ca10faf', '1a61e6a1-3df0-4460-ac64-df177a973473', ''),
	('9a058c82-f226-49f5-a418-44b8acbb4b4f', '2026-04-04 17:42:21.027955', '2026-04-26 21:51:24.315275', '2026-04-04 21:42:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #46', 734, 'CONFIRMED', 11.9, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', 'eb4c2239-f108-4c78-ac9e-ad354bd546fd', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('9c228579-90ab-407f-a441-85efcb3a7264', '2026-04-19 05:50:21.027955', '2026-04-26 21:51:23.170677', '2026-04-19 06:50:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #24', 230, 'CONFIRMED', 12.8, '504d5b87-5675-4ce0-9bda-b8f305ebec10', 'a085dd41-6103-4858-a2b0-417dbb93de09', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('9ee31262-d4a5-4453-8a57-b454b30ff81f', '2026-04-18 15:35:21.027955', '2026-04-26 21:51:29.466859', '2026-04-18 16:35:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #150', 2310, 'CONFIRMED', 22.9, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'fa469c10-ad7f-404b-b96d-986f0b650e1b', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('a0c00f84-79fb-474e-9bf2-87a5d715d3ec', '2026-04-23 21:05:21.027955', '2026-04-26 21:51:24.522713', '2026-04-24 01:05:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #50', 52, 'CONFIRMED', 17.4, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'dfe9a4e0-bddf-4263-a44a-208b4357daae', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('a17467f9-fc8d-48c2-b21b-ae5fbe716e11', '2026-04-01 17:44:21.027955', '2026-04-26 21:51:22.101866', '2026-04-01 18:44:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #8', 142, 'CONFIRMED', 7.9, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '7b644e69-dde6-45e9-864e-6d1eee7ff0c5', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', ''),
	('a182896a-26cb-4ff3-b690-438834efa5d7', '2026-04-16 06:42:21.027955', '2026-04-26 21:51:22.720250', '2026-04-16 10:42:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #16', 450, 'CONFIRMED', 4.3, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '71b10466-8e32-49d2-bdc5-814c7387915b', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('a1c43c37-6ffd-491e-b471-04365283a0d6', '2026-04-09 14:27:21.027955', '2026-04-26 21:51:22.898893', '2026-04-09 17:27:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #19', 42, 'CONFIRMED', 14, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '5f82c431-faab-4f52-9946-477a5403f451', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('a26ff6f8-3d6f-4d58-9723-1ca1463cbf5b', '2026-04-08 02:36:21.027955', '2026-04-26 21:51:23.953873', '2026-04-08 03:36:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #39', 1260, 'CONFIRMED', 12.4, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'c0f5bf5a-94a4-42e7-8a3a-c30a9ca10faf', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', ''),
	('a40a7e30-a48d-4662-b696-f676e7b4cd30', '2026-04-22 15:41:21.027955', '2026-04-26 21:51:28.087661', '2026-04-22 17:41:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #123', 13, 'CONFIRMED', 2.5, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '7b644e69-dde6-45e9-864e-6d1eee7ff0c5', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', ''),
	('a57e08d9-a050-4bf5-a0eb-0d6f540688b3', '2026-04-03 03:46:21.027955', '2026-04-26 21:51:27.991031', '2026-04-03 04:46:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #121', 1232, 'CONFIRMED', 20.2, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '7d2ccc7a-c37c-4c88-87d1-bc474486fb6a', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', ''),
	('a777c76c-3a06-4087-8747-765a9865ffe3', '2026-04-10 17:59:21.027955', '2026-04-26 21:51:25.993756', '2026-04-10 20:59:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #80', 960, 'CONFIRMED', 9.4, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '5f82c431-faab-4f52-9946-477a5403f451', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('a883b59b-6383-4954-93e1-e9f5a065aadd', '2026-04-18 08:10:21.027955', '2026-04-26 21:51:23.800856', '2026-04-18 10:10:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #36', 14, 'CONFIRMED', 4.8, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'a1fdb247-7f63-414a-b34e-5f379a505c55', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('a8c3774d-40c6-4c3e-a133-e55091f0a92e', '2026-03-31 03:59:21.027955', '2026-04-26 21:51:24.007318', '2026-03-31 06:59:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #40', 12, 'CONFIRMED', 2.3, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'c96f1890-97aa-4284-be5d-89130bc13f32', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('a8f7115a-19bf-4ac3-a8fb-3416e3fc9672', '2026-04-21 05:39:21.027955', '2026-04-26 21:51:27.796924', '2026-04-21 08:39:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #117', 46, 'CONFIRMED', 15.4, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '9fdfd91d-f237-4346-9c38-04fb9be9a98c', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('aaa63885-9df3-4b19-9192-6b6b6bb262b6', '2026-04-02 08:44:58.946633', '2026-04-26 21:49:58.959822', '2026-04-02 11:44:58.946633', b'0', NULL, NULL, NULL, 'Setoran dummy #1', 29, 'CONFIRMED', 5.8, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '3b4d284b-cd14-4940-8aac-ea5a2a917ab6', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('ac1a3565-e0e3-478e-9dfa-4c87eb6fd18b', '2026-04-07 05:17:21.027955', '2026-04-26 21:51:29.226208', '2026-04-07 08:17:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #145', 2420, 'CONFIRMED', 24, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '3c413d07-5996-4313-8401-011b46ebf9e1', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('af5f1def-953a-4535-8674-1442b3489472', '2026-04-04 17:20:21.027955', '2026-04-26 21:51:26.038885', '2026-04-04 20:20:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #81', 32, 'CONFIRMED', 10.7, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '43095137-df51-4004-b68d-b31d1e3adb20', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('afabcff4-1143-4df1-a768-8a6af7d3196a', '2026-04-22 10:31:21.027955', '2026-04-26 21:51:23.325811', '2026-04-22 12:31:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #27', 65, 'CONFIRMED', 3.6, '504d5b87-5675-4ce0-9bda-b8f305ebec10', 'dfe9a4e0-bddf-4263-a44a-208b4357daae', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('b204fd45-51bf-4713-8bc2-1a0f7db22912', '2026-04-17 10:23:21.027955', '2026-04-26 21:51:24.214097', '2026-04-17 11:23:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #44', 320, 'CONFIRMED', 14.2, '22246f99-6f62-486c-bdeb-a43fd960b624', 'd7dc83d2-5897-42be-ae6c-447296eb1c97', '1a61e6a1-3df0-4460-ac64-df177a973473', ''),
	('b8c4770b-d369-47f1-bf50-be65a16f6fac', '2026-04-26 17:02:21.027955', '2026-04-26 21:51:24.801112', '2026-04-26 20:02:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #55', 392, 'CONFIRMED', 6.2, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '38e4112c-2738-418f-9583-6b71903324d6', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('b9023927-fc35-4ada-94e1-7e6b618d94d4', '2026-04-02 08:46:21.027955', '2026-04-26 21:51:21.048898', '2026-04-02 11:46:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #1', 29, 'CONFIRMED', 5.8, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '3b4d284b-cd14-4940-8aac-ea5a2a917ab6', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('b9737e13-50da-479e-8cad-f64b09e2be05', '2026-03-28 00:46:21.027955', '2026-04-26 21:51:27.257737', '2026-03-28 01:46:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #106', 211, 'CONFIRMED', 17.6, '032cc629-1ced-441c-9d92-418638f7ea0f', '5f788d55-dfcf-456f-8c1e-c1df967691d5', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('b9adabb0-fe6d-44b0-ac0d-427157a3b2bc', '2026-04-14 09:49:21.027955', '2026-04-26 21:51:26.926812', '2026-04-14 11:49:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #99', 1950, 'CONFIRMED', 19.3, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '735016c5-7255-46ee-9031-9ed94a27d90f', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('ba6c1a02-8fa3-4ce4-9e03-d5d59ea2da14', '2026-04-05 11:09:21.027955', '2026-04-26 21:51:29.276150', '2026-04-05 14:09:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #146', 43, 'CONFIRMED', 8.6, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'ce9dd90d-0a34-490f-ab94-95f5edc129bd', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('c03df349-4f65-4caf-bb2e-04840eb77031', '2026-04-05 23:40:21.027955', '2026-04-26 21:51:27.069697', '2026-04-06 01:40:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #102', 36, 'CONFIRMED', 12, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'eb4c2239-f108-4c78-ac9e-ad354bd546fd', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('c0a073b8-2c50-429c-8fc6-94b7cbe8032d', '2026-04-09 19:34:21.027955', '2026-04-26 21:51:29.173193', '2026-04-09 21:34:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #144', 1670, 'CONFIRMED', 16.5, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '43095137-df51-4004-b68d-b31d1e3adb20', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('c0bb392b-9326-454b-82c1-216e2ac44505', '2026-04-09 15:04:21.027955', '2026-04-26 21:51:24.422492', '2026-04-09 17:04:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #48', 570, 'CONFIRMED', 5.5, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'fa469c10-ad7f-404b-b96d-986f0b650e1b', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('c18ce173-8da3-4216-946d-bd70927a7ae6', '2026-04-06 03:17:21.027955', '2026-04-26 21:51:29.323598', '2026-04-06 07:17:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #147', 512, 'CONFIRMED', 8.2, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '85945231-e152-43ae-8b76-d6a27d999e8b', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('c19ff3c8-755d-40eb-8c3f-1592c499e794', '2026-04-09 03:17:21.027955', '2026-04-26 21:51:28.733373', '2026-04-09 06:17:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #135', 970, 'CONFIRMED', 9.5, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '5f788d55-dfcf-456f-8c1e-c1df967691d5', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('c29ba187-8bf2-4529-af0c-0ef185c93bb4', '2026-04-03 07:44:21.027955', '2026-04-26 21:51:26.348260', '2026-04-03 09:44:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #87', 206, 'CONFIRMED', 17.2, '032cc629-1ced-441c-9d92-418638f7ea0f', 'dfe9a4e0-bddf-4263-a44a-208b4357daae', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', ''),
	('c55cc6c7-6038-455b-8e75-7f3b2dcbed9e', '2026-04-13 03:16:21.027955', '2026-04-26 21:51:21.671909', '2026-04-13 05:16:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #4', 112, 'CONFIRMED', 22.4, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '38e4112c-2738-418f-9583-6b71903324d6', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('c59c6c98-493c-4941-b3e8-70d657f0aa8e', '2026-04-20 04:09:21.027955', '2026-04-26 21:51:22.776270', '2026-04-20 08:09:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #17', 137, 'CONFIRMED', 6.1, '22246f99-6f62-486c-bdeb-a43fd960b624', 'ce9dd90d-0a34-490f-ab94-95f5edc129bd', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('c5e224b6-8d4e-4892-86c0-3adc984f7f50', '2026-04-16 05:21:21.027955', '2026-04-26 21:51:25.856602', '2026-04-16 09:21:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #77', 29, 'CONFIRMED', 5.8, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'c0f5bf5a-94a4-42e7-8a3a-c30a9ca10faf', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('c736189d-0e5c-4d14-ad25-ba06a399f86c', '2026-03-30 01:11:21.027955', '2026-04-26 21:51:25.668149', '2026-03-30 05:11:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #73', 392, 'CONFIRMED', 6.2, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '482c6ffd-db87-40fb-b8a7-eb962c9ddb30', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('c75e98d1-e77a-43fe-b055-4d3a5daa7e95', '2026-04-15 12:22:21.027955', '2026-04-26 21:51:25.382419', '2026-04-15 14:22:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #67', 247, 'CONFIRMED', 20.6, '032cc629-1ced-441c-9d92-418638f7ea0f', '88c9c96f-639a-44b0-ac1e-ceca300374c0', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('c954aa1c-067f-42ed-97ac-d65da8caeb6f', '2026-03-31 07:55:21.027955', '2026-04-26 21:51:26.736445', '2026-03-31 09:55:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #95', 131, 'CONFIRMED', 10.9, '032cc629-1ced-441c-9d92-418638f7ea0f', '482c6ffd-db87-40fb-b8a7-eb962c9ddb30', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('ca012f3c-4a89-4def-977a-54e233761416', '2026-04-13 17:32:21.027955', '2026-04-26 21:51:27.545886', '2026-04-13 19:32:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #112', 121, 'CONFIRMED', 6.7, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '43095137-df51-4004-b68d-b31d1e3adb20', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('cafd2e3c-055d-411f-bb10-99b57071ba5a', '2026-04-13 23:55:21.027955', '2026-04-26 21:51:25.807272', '2026-04-14 02:55:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #76', 101, 'CONFIRMED', 4.5, '22246f99-6f62-486c-bdeb-a43fd960b624', 'ce9dd90d-0a34-490f-ab94-95f5edc129bd', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('cbed414c-b5d1-4f67-b16b-f56909eaa940', '2026-04-07 04:34:21.027955', '2026-04-26 21:51:27.499960', '2026-04-07 05:34:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #111', 167, 'CONFIRMED', 7.4, '22246f99-6f62-486c-bdeb-a43fd960b624', 'f02d9684-0501-4386-b3c4-7799a1a42804', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('cd6727aa-e5d6-4fa4-933a-fcd69a23e6e5', '2026-04-02 17:55:21.027955', '2026-04-26 21:51:27.842959', '2026-04-02 19:55:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #118', 1710, 'CONFIRMED', 16.9, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '7fda2150-942f-4283-b964-cdf04e467c10', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('cf951df7-816d-48fa-99c8-fb07c8622f2e', '2026-04-06 03:57:21.027955', '2026-04-26 21:51:21.433192', '2026-04-06 04:57:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #2', 580, 'CONFIRMED', 5.6, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '8fe94d3d-1a51-41d8-a0ca-b9e2e49959c3', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('d03d0063-7ad6-437a-a401-514d4277c263', '2026-04-24 10:56:21.027955', '2026-04-26 21:51:27.023010', '2026-04-24 12:56:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #101', 16, 'CONFIRMED', 5.2, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'c661afad-1d0d-481f-87f9-8655bbb2a105', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('d0c56e13-dca7-4111-a28d-3a19a064208c', '2026-03-28 02:32:21.027955', '2026-04-26 21:51:28.345884', '2026-03-28 06:32:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #128', 1148, 'CONFIRMED', 18.8, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', 'ce9dd90d-0a34-490f-ab94-95f5edc129bd', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('d22ffef8-0698-4377-b86f-cda9fb900324', '2026-04-05 05:04:21.027955', '2026-04-26 21:51:26.183355', '2026-04-05 08:04:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #84', 590, 'CONFIRMED', 9.5, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', 'eb4c2239-f108-4c78-ac9e-ad354bd546fd', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('d351e46d-338f-4327-8ae7-af17b4ae21f1', '2026-04-11 20:13:21.027955', '2026-04-26 21:51:25.276577', '2026-04-12 00:13:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #65', 1460, 'CONFIRMED', 14.4, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'd5f5c72d-3971-4a5a-842b-375b03183b8c', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('d6731ad4-0a2f-4f72-b8f5-5823c189ef8a', '2026-04-08 10:46:21.027955', '2026-04-26 21:51:27.590368', '2026-04-08 13:46:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #113', 57, 'CONFIRMED', 18.9, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'bd2dc7f2-90dd-4644-9c9f-0241edaab70b', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('d71b14f7-bfae-4ebe-9894-5beb5cee4c0f', '2026-04-04 10:40:21.027955', '2026-04-26 21:51:25.761555', '2026-04-04 11:40:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #75', 83, 'CONFIRMED', 16.6, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '10e873da-3daf-47d6-8045-faee4402daf1', '1a61e6a1-3df0-4460-ac64-df177a973473', ''),
	('da2987af-ae4c-4ae0-bacb-128a0e02b30b', '2026-04-21 18:33:21.027955', '2026-04-26 21:51:25.947900', '2026-04-21 20:33:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #79', 175, 'CONFIRMED', 9.7, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '5f788d55-dfcf-456f-8c1e-c1df967691d5', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('da2b4cd9-7c7b-45cd-8de3-0fef8abaa298', '2026-04-12 04:06:21.027955', '2026-04-26 21:51:25.222452', '2026-04-12 06:06:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #64', 1360, 'CONFIRMED', 13.4, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '4981c6f4-bf64-4ba2-8bd8-54a3d89c1935', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('da4db741-5b11-45bd-9f4a-7b9f1c2cb835', '2026-04-25 07:13:21.027955', '2026-04-26 21:51:23.893824', '2026-04-25 11:13:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #38', 99, 'CONFIRMED', 5.5, '504d5b87-5675-4ce0-9bda-b8f305ebec10', 'a085dd41-6103-4858-a2b0-417dbb93de09', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('db2c73f1-b65b-4e32-8e9b-3e8a7bedae66', '2026-03-30 11:17:21.027955', '2026-04-26 21:51:28.505506', '2026-03-30 14:17:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #130', 520, 'CONFIRMED', 5, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'd8b68cd6-d9e6-4ae7-9a3f-170c2e5c79c3', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', ''),
	('db6664cd-b4d2-4288-917a-b4d83a7ddc01', '2026-04-08 07:02:21.027955', '2026-04-26 21:51:28.239771', '2026-04-08 10:02:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #126', 128, 'CONFIRMED', 5.7, '22246f99-6f62-486c-bdeb-a43fd960b624', 'd5f5c72d-3971-4a5a-842b-375b03183b8c', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('ddf2f9ea-2543-4b24-b13b-6b798a54f7d6', '2026-04-09 22:30:21.027955', '2026-04-26 21:51:26.689401', '2026-04-10 01:30:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #94', 42, 'CONFIRMED', 14.1, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'd8b68cd6-d9e6-4ae7-9a3f-170c2e5c79c3', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('deb2885b-a50a-4f31-84bd-06619dda40e2', '2026-04-26 19:58:21.027955', '2026-04-26 23:56:14.721106', '2026-04-26 23:56:14.711890', b'0', NULL, NULL, '-6.8956,107.6276', 'Menunggu konfirmasi petugas #6 | DITOLAK: j', 0, 'REJECTED', 6.7, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'c230d565-bf47-4ecb-a9c3-9f01a854eb0d', '245b8746-cf46-4a94-9148-58dd0315f2b5', NULL),
	('df8e806e-0244-420c-8dd9-f1b749a76c91', '2026-04-15 19:51:21.027955', '2026-04-26 21:51:27.212336', '2026-04-15 21:51:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #105', 116, 'CONFIRMED', 23.1, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '43095137-df51-4004-b68d-b31d1e3adb20', '208a695d-6515-4ee7-bef7-8aa87b1fe88e', ''),
	('dfff8546-d07a-4c06-b97a-3dfa96b11068', '2026-04-26 20:27:21.027955', '2026-04-26 23:55:03.401464', '2026-04-26 23:55:03.390194', b'0', NULL, NULL, '-6.9029,107.6417', 'Menunggu konfirmasi petugas #7 | DITOLAK: f', 0, 'REJECTED', 12.4, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '7fda2150-942f-4283-b964-cdf04e467c10', '245b8746-cf46-4a94-9148-58dd0315f2b5', NULL),
	('e16e4b4c-353a-43ed-ae9f-eb95510cccd5', '2026-04-04 16:38:21.027955', '2026-04-26 21:51:28.287699', '2026-04-04 20:38:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #127', 109, 'CONFIRMED', 9.1, '032cc629-1ced-441c-9d92-418638f7ea0f', '38e4112c-2738-418f-9583-6b71903324d6', '956186bd-4a29-4e18-a49d-180ad4289cf7', ''),
	('e1d2c305-8316-4dfe-8eca-88b18aade5d1', '2026-04-17 02:16:21.027955', '2026-04-26 21:51:24.942103', '2026-04-17 06:16:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #58', 75, 'CONFIRMED', 14.9, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '85945231-e152-43ae-8b76-d6a27d999e8b', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('e1e3f578-7cb7-424a-a0d8-4f7a48ac2d5e', '2026-04-05 01:01:21.027955', '2026-04-26 21:51:27.890059', '2026-04-05 02:01:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #119', 229, 'CONFIRMED', 12.7, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '88c9c96f-639a-44b0-ac1e-ceca300374c0', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('e2627565-0a33-4e9b-9622-2f39192105ac', '2026-04-10 00:52:21.027955', '2026-04-26 21:51:22.658064', '2026-04-10 01:52:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #15', 28, 'CONFIRMED', 5.5, 'ed7cc969-180c-44d8-9a27-89f1d3743699', '10e873da-3daf-47d6-8045-faee4402daf1', 'e2037d74-845a-40bf-868b-a0807f1a08e4', ''),
	('e2a837cf-7450-4585-86bf-d22d71787137', '2026-03-28 06:17:21.027955', '2026-04-26 21:51:22.958437', '2026-03-28 07:17:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #20', 1232, 'CONFIRMED', 20.2, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', 'dfe9a4e0-bddf-4263-a44a-208b4357daae', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('e3390f73-a8bd-4c3f-95dc-30e016c4b71f', '2026-04-09 07:51:21.027955', '2026-04-26 21:51:24.571991', '2026-04-09 11:51:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #51', 95, 'CONFIRMED', 18.9, 'ed7cc969-180c-44d8-9a27-89f1d3743699', 'f9404ec0-2243-435e-a8eb-04f2902794e3', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('e3ab0cf9-5005-4ebf-a03e-d7867a5ea806', '2026-04-26 19:46:21.027955', '2026-04-26 21:51:29.629989', NULL, b'0', NULL, NULL, '-6.8913,107.6383', 'Menunggu konfirmasi petugas #8', 0, 'PENDING', 12.2, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '7f02c92e-ac34-49a8-8698-b32986ea2ee1', NULL, NULL),
	('e6057b8d-c869-4326-8baf-ee5fd23a4a2d', '2026-03-30 21:19:21.027955', '2026-04-26 21:51:24.160927', '2026-03-31 01:19:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #43', 23, 'CONFIRMED', 7.5, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'eb4c2239-f108-4c78-ac9e-ad354bd546fd', '956186bd-4a29-4e18-a49d-180ad4289cf7', ''),
	('e608257e-b12f-41eb-8941-0e34e2903de9', '2026-04-13 18:27:21.027955', '2026-04-26 21:51:25.623223', '2026-04-13 19:27:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #72', 48, 'CONFIRMED', 15.9, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'b8566336-b51f-49d4-a838-dbac75545acc', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('e60de3e1-9e2e-477f-84eb-a56841a84d3c', '2026-04-13 07:13:21.027955', '2026-04-26 21:51:28.429362', '2026-04-13 10:13:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #129', 414, 'CONFIRMED', 23, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('e8a05588-2871-4100-b0df-5f455f670807', '2026-04-06 01:09:21.027955', '2026-04-26 21:51:22.374078', '2026-04-06 03:09:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #11', 64, 'CONFIRMED', 21.2, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', '5f788d55-dfcf-456f-8c1e-c1df967691d5', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('e8e5f74d-e487-413c-ad01-1f14148a4940', '2026-03-28 17:01:21.027955', '2026-04-26 21:51:26.133786', '2026-03-28 19:01:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #83', 1440, 'CONFIRMED', 14.2, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '7fda2150-942f-4283-b964-cdf04e467c10', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('eb1e9cc8-4958-4dee-8aa4-d26d4f462aa1', '2026-04-13 12:53:21.027955', '2026-04-26 21:51:23.653499', '2026-04-13 14:53:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #33', 531, 'CONFIRMED', 23.6, '22246f99-6f62-486c-bdeb-a43fd960b624', '7f02c92e-ac34-49a8-8698-b32986ea2ee1', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('eb422751-8309-4f79-8750-a74f9a72f98b', '2026-04-19 04:56:21.027955', '2026-04-26 21:51:22.530508', '2026-04-19 07:56:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #13', 443, 'CONFIRMED', 19.7, '22246f99-6f62-486c-bdeb-a43fd960b624', 'b8566336-b51f-49d4-a838-dbac75545acc', '9a398868-8a1f-4e30-9872-e887e380af93', ''),
	('ebd4da1d-a0e8-4e9b-b467-27ca3c78a195', '2026-04-06 06:07:21.027955', '2026-04-26 21:51:28.871920', '2026-04-06 08:07:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #138', 350, 'CONFIRMED', 5.5, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('ec37d6cf-1a57-4812-92eb-c2dbf12d9213', '2026-04-26 20:31:21.027955', '2026-04-26 23:54:54.822068', '2026-04-26 23:54:54.804208', b'0', NULL, NULL, '-6.8951,107.6266', 'Menunggu konfirmasi petugas #4', 715, 'CONFIRMED', 7.1, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', '4296719f-5bc4-4c7e-899f-c6718bc96c1a', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('eebb119b-b001-4cad-916f-ee1d0c815602', '2026-04-01 07:32:21.027955', '2026-04-26 21:51:23.754843', '2026-04-01 08:32:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #35', 1262, 'CONFIRMED', 20.7, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '7d2ccc7a-c37c-4c88-87d1-bc474486fb6a', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('ef82d08a-6aa4-4293-8a24-a571b17a75d8', '2026-04-26 23:56:01.722519', '2026-04-26 23:56:01.722519', '2026-04-26 23:56:01.721516', b'0', NULL, NULL, NULL, '', 12, 'CONFIRMED', 1, '032cc629-1ced-441c-9d92-418638f7ea0f', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', '245b8746-cf46-4a94-9148-58dd0315f2b5', NULL),
	('f19230be-485f-497f-9ebf-ce15b814ad9b', '2026-04-12 10:19:21.027955', '2026-04-26 21:51:22.834594', '2026-04-12 12:19:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #18', 290, 'CONFIRMED', 16.1, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '7fda2150-942f-4283-b964-cdf04e467c10', '98419feb-da21-4d78-97bf-62a2199d6c8c', ''),
	('f1dd480b-2566-4cc8-9773-1264c544a5dc', '2026-03-29 21:41:21.027955', '2026-04-26 21:51:25.530163', '2026-03-30 00:41:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #70', 1570, 'CONFIRMED', 15.5, '9e95c899-0fd6-4dc0-88c3-aa1cfeefeee8', 'd5f5c72d-3971-4a5a-842b-375b03183b8c', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('f4372c94-70d4-4bdc-9d09-06312156beb5', '2026-03-29 23:42:21.027955', '2026-04-26 21:51:28.194362', '2026-03-30 00:42:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #125', 260, 'CONFIRMED', 21.7, '032cc629-1ced-441c-9d92-418638f7ea0f', 'eb4c2239-f108-4c78-ac9e-ad354bd546fd', '2df99938-98b4-4472-a4c0-36cbee6be073', ''),
	('f66497ff-f610-4f29-bdca-b46357ac3807', '2026-04-02 06:24:21.027955', '2026-04-26 21:51:25.085605', '2026-04-02 10:24:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #61', 1208, 'CONFIRMED', 19.8, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', '7d2ccc7a-c37c-4c88-87d1-bc474486fb6a', 'b74ccbf8-270e-4222-88ec-44fd9d1f15d5', ''),
	('f6800f6a-86d3-4465-aaaf-33b35972a1e7', '2026-04-21 19:19:21.027955', '2026-04-26 21:51:23.377375', '2026-04-21 22:19:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #28', 191, 'CONFIRMED', 10.6, '504d5b87-5675-4ce0-9bda-b8f305ebec10', '83741056-db1c-43a6-9ad7-3a12e2d75d06', '245b8746-cf46-4a94-9148-58dd0315f2b5', ''),
	('f6e6b25d-0e81-4d12-8a39-df3161fbb704', '2026-04-13 14:19:21.027955', '2026-04-26 21:51:24.110923', '2026-04-13 18:19:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #42', 140, 'CONFIRMED', 2, '8efe8add-58ba-4181-8a5b-4c25e8cdef30', 'd8b68cd6-d9e6-4ae7-9a3f-170c2e5c79c3', '35a41428-3349-45ef-af40-fcbaaa42a3c7', ''),
	('f745226d-9355-4816-8aac-731790914c20', '2026-04-26 16:30:13.082389', '2026-04-26 16:30:13.082389', NULL, b'0', '/uploads/a7252423-9408-4d3d-8e62-e2cf78a81317.png', NULL, NULL, 'Kaleng Bekas Susu Bayi', 0, 'PENDING', 1, '22246f99-6f62-486c-bdeb-a43fd960b624', '0da6dd2b-486c-4e0e-a99e-83d7a36d155f', NULL, NULL),
	('f9b6f861-c06d-47b2-9361-7bd72592c9e1', '2026-04-23 03:14:21.027955', '2026-04-26 21:51:29.415176', '2026-04-23 05:14:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #149', 18, 'CONFIRMED', 1, '504d5b87-5675-4ce0-9bda-b8f305ebec10', 'dfe9a4e0-bddf-4263-a44a-208b4357daae', '130ebb9c-624f-4dc3-924c-7ed9c5c9af6b', ''),
	('ff80f974-5cfe-419f-97c8-539ac74e7f79', '2026-04-04 04:30:21.027955', '2026-04-26 21:51:25.431242', '2026-04-04 07:30:21.027955', b'0', NULL, NULL, NULL, 'Setoran dummy #68', 36, 'CONFIRMED', 12, '446cb7af-2f2f-4289-9c8c-d174b82ce4dd', 'f052b52b-edf6-4546-985b-cf7cb4d52d4e', '1a61e6a1-3df0-4460-ac64-df177a973473', '');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;


