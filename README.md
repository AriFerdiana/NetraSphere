# TriNetra: Smart Community Waste System 🌿

Sistem Pengelolaan Sampah Komunitas Cerdas yang mengintegrasikan pengelolaan sampah berbasis warga, gamifikasi (Green Wallet), integrasi perangkat IoT (NetraDUMP), dan dukungan AI (Mistral AI). Proyek ini dibangun sebagai Tugas Besar Pemrograman Berorientasi Objek (PBO).

## ✨ Fitur Utama
- **RBAC (Role Based Access Control)**: Admin, Warga, dan Petugas Lapangan.
- **Green Wallet**: Sistem poin otomatis berdasarkan berat dan kategori sampah.
- **IoT-Ready**: Endpoint API khusus untuk menerima data setoran dari robot/smart bin otonom.
- **AI Chatbot**: Integrasi Mistral AI untuk panduan pemilahan sampah dan estimasi poin.
- **Reporting**: Ekspor laporan ke PDF & CSV, serta visualisasi grafik statistik.
- **Modern UI**: Dashboard yang responsif dan interaktif dengan Alpine.js dan Tailwind CSS.

## 🚀 Teknologi yang Digunakan
- **Backend**: Java 17, Spring Boot 3.2.x, Spring Security, JPA Hibernate.
- **Database**: MySQL 8.x.
- **Frontend**: Thymeleaf, Tailwind CSS, Alpine.js, Chart.js.
- **AI**: Mistral AI (Small Latest Model).
- **Export**: OpenPDF, OpenCSV.

## 🛠️ Cara Instalasi & Menjalankan Projek

### 1. Prasyarat
- Java JDK 17 atau lebih baru.
- Maven 3.x.
- MySQL Server 8.x.

### 2. Persiapan Database
1. Buat database baru di MySQL:
   ```sql
   CREATE DATABASE db_tubes_pbo_trinetra;
   ```
2. Import file `database_dump.sql` yang tersedia di root folder projek ke database tersebut.

### 3. Konfigurasi Aplikasi
Buka file `src/main/resources/application.yml` dan sesuaikan kredensial berikut:
- **Datasource**: Update `username` dan `password` MySQL Anda.
- **Mail (Opsional)**: Update SMTP credentials untuk fitur reset password via email.
- **Mistral AI (Opsional)**: Masukkan API Key Anda jika ingin menggunakan fitur Chatbot AI.

### 4. Menjalankan Aplikasi
Buka terminal di root direktori projek, lalu jalankan:
```bash
mvn clean spring-boot:run
```
Aplikasi akan berjalan di `http://localhost:8080`.

## 👤 Kredensial Akses (Demo)
| Role | Email | Password |
| :--- | :--- | :--- |
| **Admin** | `admin@smartwaste.com` | `Admin@123` |
| **Petugas** | `petugas@smartwaste.com` | `Petugas@123` |
| **Warga** | `warga@smartwaste.com` | `Warga@123` |

## 📋 API Dokumentasi (Swagger)
Setelah aplikasi berjalan, dokumentasi API dapat diakses di:
`http://localhost:8080/swagger-ui.html`

---
**Tim Trinetra** — *Inovasi untuk Bumi yang Lebih Hijau.*
