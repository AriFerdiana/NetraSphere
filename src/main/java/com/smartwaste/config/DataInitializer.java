package com.smartwaste.config;

import com.smartwaste.entity.Citizen;
import com.smartwaste.entity.GreenWallet;
import com.smartwaste.entity.Admin;
import com.smartwaste.entity.Collector;
import com.smartwaste.entity.WasteCategory;
import com.smartwaste.entity.enums.WasteType;
import com.smartwaste.repository.CollectorRepository;
import com.smartwaste.repository.GreenWalletRepository;
import com.smartwaste.repository.UserRepository;
import com.smartwaste.repository.CitizenRepository;
import com.smartwaste.repository.WasteCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Data Initializer — Menyiapkan data awal (seed data) saat aplikasi pertama kali dijalankan.
 *
 * <p>Membuat:</p>
 * <ul>
 *   <li>1 Admin default (admin@smartwaste.com / Admin@123)</li>
 *   <li>1 Collector (manusia) default</li>
 *   <li>1 Collector IoT (robot NetraDUMP-001)</li>
 *   <li>7 kategori sampah lengkap dengan poin per kg</li>
 * </ul>
 *
 * <p>Menggunakan {@code CommandLineRunner} sehingga berjalan otomatis
 * setelah konteks Spring selesai di-load.</p>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CollectorRepository collectorRepository;
    private final CitizenRepository citizenRepository;
    private final GreenWalletRepository greenWalletRepository;
    private final WasteCategoryRepository wasteCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        initAdmin();
        initCollectors();
        initCitizen();
        initWasteCategories();
    }

    private void initAdmin() {
        if (!userRepository.existsByEmail("admin@smartwaste.com")) {
            Admin admin = new Admin(
                "Super Admin",
                "admin@smartwaste.com",
                passwordEncoder.encode("Admin@123"),
                "08100000001",
                "Super Administrator"
            );
            userRepository.save(admin);
            log.info("✅ Admin default dibuat: admin@smartwaste.com / Admin@123");
        }
    }

    private void initCollectors() {
        // Collector manusia
        if (!userRepository.existsByEmail("petugas@smartwaste.com")) {
            Collector collector = new Collector(
                "Budi Santoso",
                "petugas@smartwaste.com",
                passwordEncoder.encode("Petugas@123"),
                "08100000002",
                "B 1234 SW",
                "Area RT 01-10"
            );
            collectorRepository.save(collector);
            log.info("✅ Collector default dibuat: petugas@smartwaste.com / Petugas@123");
        }

        // Collector IoT (robot NetraDUMP)
        if (!collectorRepository.existsByIotDeviceId("NETRADUMP-001")) {
            Collector robot = new Collector(
                "Robot NetraDUMP-001",
                "robot001@netradump.iot",
                passwordEncoder.encode("R0b0t@NetraDUMP"),
                "NETRADUMP-001",
                "Smart Bin Area A - Balai Desa",
                true
            );
            collectorRepository.save(robot);
            log.info("✅ IoT Collector dibuat: NETRADUMP-001");
        }
    }

    private void initCitizen() {
        if (!userRepository.existsByEmail("warga@smartwaste.com")) {
            Citizen citizen = new Citizen(
                "Ahmad Warga",
                "warga@smartwaste.com",
                passwordEncoder.encode("Warga@123"),
                "081222333444",
                "3201012345678901",
                "Jl. Kebersihan No. 10, RT 02/01"
            );
            citizen.setRtRw("02/01");
            citizen.setKelurahan("Sukabersih");

            // Simpan citizen terlebih dahulu
            Citizen savedCitizen = citizenRepository.save(citizen);

            // Buat dan simpan GreenWallet untuk citizen ini (pola sama dengan AuthServiceImpl)
            GreenWallet wallet = new GreenWallet(savedCitizen);
            greenWalletRepository.save(wallet);

            log.info("✅ Citizen default dibuat: warga@smartwaste.com / Warga@123");
        }
    }

    private void initWasteCategories() {
        if (wasteCategoryRepository.count() == 0) {
            WasteCategory[] categories = {
                new WasteCategory(
                    "Sisa Makanan & Dapur",
                    "Sampah organik dari sisa makanan, sayuran, dan buah-buahan",
                    WasteType.ORGANIC, 5.0,
                    "🍎"
                ),
                new WasteCategory(
                    "Daun & Ranting",
                    "Sampah organik dari kebun seperti daun kering dan ranting kecil",
                    WasteType.ORGANIC, 3.0,
                    "🍃"
                ),
                new WasteCategory(
                    "Botol Plastik (PET)",
                    "Botol minuman plastik jenis PET yang dapat didaur ulang",
                    WasteType.INORGANIC, 12.0,
                    "♻️"
                ),
                new WasteCategory(
                    "Kertas & Kardus",
                    "Kertas bekas, koran, majalah, kardus bersih yang dapat didaur ulang",
                    WasteType.INORGANIC, 8.0,
                    "📦"
                ),
                new WasteCategory(
                    "Kaleng Logam",
                    "Kaleng minuman, kaleng makanan dari aluminium atau baja",
                    WasteType.INORGANIC, 15.0,
                    "🥫"
                ),
                new WasteCategory(
                    "Baterai Bekas",
                    "Baterai AA, AAA, baterai tombol, atau baterai lithium bekas — limbah B3",
                    WasteType.B3, 30.0,
                    "🔋"
                ),
                new WasteCategory(
                    "Elektronik & E-Waste",
                    "Handphone rusak, charger bekas, PCB, lampu LED/neon — limbah B3 elektronik",
                    WasteType.B3, 50.0,
                    "💻"
                )
            };

            for (WasteCategory category : categories) {
                wasteCategoryRepository.save(category);
            }
            log.info("✅ 7 kategori sampah berhasil dibuat");
        }
    }
}
