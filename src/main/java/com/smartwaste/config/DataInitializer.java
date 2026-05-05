package com.smartwaste.config;

import com.smartwaste.entity.*;
import com.smartwaste.entity.enums.DepositStatus;
import com.smartwaste.entity.enums.WasteType;
import com.smartwaste.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * Data Initializer — Menyiapkan data awal (seed data) saat aplikasi pertama kali dijalankan.
 *
 * <p>Membuat:</p>
 * <ul>
 *   <li>1 Admin default</li>
 *   <li>10 Collector manusia + 1 IoT robot</li>
 *   <li>51 Citizen dummy beserta GreenWallet</li>
 *   <li>7 Kategori sampah lengkap</li>
 *   <li>~160 WasteDeposit dummy (CONFIRMED + PENDING) untuk mengisi grafik &amp; statistik</li>
 * </ul>
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DataInitializer.class);

    private final UserRepository          userRepository;
    private final CollectorRepository     collectorRepository;
    private final CitizenRepository       citizenRepository;
    private final GreenWalletRepository   greenWalletRepository;
    private final WasteCategoryRepository wasteCategoryRepository;
    private final WasteDepositRepository  wasteDepositRepository;
    private final PasswordEncoder         passwordEncoder;

    public DataInitializer(UserRepository userRepository,
                           CollectorRepository collectorRepository,
                           CitizenRepository citizenRepository,
                           GreenWalletRepository greenWalletRepository,
                           WasteCategoryRepository wasteCategoryRepository,
                           WasteDepositRepository wasteDepositRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.collectorRepository = collectorRepository;
        this.citizenRepository = citizenRepository;
        this.greenWalletRepository = greenWalletRepository;
        this.wasteCategoryRepository = wasteCategoryRepository;
        this.wasteDepositRepository = wasteDepositRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        System.out.println(">>> SEEDER DEBUG: Starting data initialization...");
        initAdmin();
        initCollectors();
        initCitizen();
        initWasteCategories();
        initWasteDeposits();
        System.out.println(">>> SEEDER DEBUG: Initialization complete.");
        System.out.println(">>> SEEDER DEBUG: Total Users: "     + userRepository.count());
        System.out.println(">>> SEEDER DEBUG: Total Collectors: " + collectorRepository.count());
        System.out.println(">>> SEEDER DEBUG: Total Citizens: "   + citizenRepository.count());
        System.out.println(">>> SEEDER DEBUG: Total Deposits: "   + wasteDepositRepository.count());
    }

    // ==================== Admin ====================

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

    // ==================== Collector ====================

    private void initCollectors() {
        String[] names = {
            "Budi Santoso", "Andi Wijaya", "Suryo Utomo", "Dedi Kurniawan", "Eko Prasetyo",
            "Fajar Ramadhan", "Guntur Saputra", "Heri Setiawan", "Indra Kusuma", "Joko Susilo"
        };

        for (int i = 0; i < names.length; i++) {
            String email = "petugas" + (i + 1) + "@smartwaste.com";
            if (!userRepository.existsByEmail(email)) {
                Collector collector = new Collector(
                    names[i], email,
                    passwordEncoder.encode("Petugas@123"),
                    "081" + (100000000 + i),
                    "B " + (1234 + i) + " SW",
                    "Area Wilayah " + (char)('A' + i)
                );
                collectorRepository.save(collector);
                log.info("✅ Collector {} dibuat: {}", i + 1, email);
            }
        }

        if (!collectorRepository.existsByIotDeviceId("NETRADUMP-001")) {
            Collector robot = new Collector(
                "Robot NetraDUMP-001", "robot001@netradump.iot",
                passwordEncoder.encode("R0b0t@NetraDUMP"),
                "NETRADUMP-001", "Smart Bin Area A - Balai Desa", true
            );
            collectorRepository.save(robot);
            log.info("✅ IoT Collector dibuat: NETRADUMP-001");
        }
    }

    // ==================== Citizen ====================

    private void initCitizen() {
        if (!userRepository.existsByEmail("warga@smartwaste.com")) {
            Citizen citizen = new Citizen(
                "Ahmad Warga", "warga@smartwaste.com",
                passwordEncoder.encode("Warga@123"),
                "081222333444", "3201012345678901",
                "Jl. Kebersihan No. 10, RT 02/01"
            );
            citizen.setRtRw("02/01");
            citizen.setKelurahan("Sukabersih");
            Citizen saved = citizenRepository.save(citizen);
            greenWalletRepository.save(new GreenWallet(saved));
            log.info("✅ Citizen default dibuat: warga@smartwaste.com / Warga@123");
        }

        if (citizenRepository.count() < 50) {
            String[] firstNames = {
                "Budi","Siti","Agus","Dewi","Ahmad","Ayu","Joko","Rini","Hendra","Nur",
                "Eko","Putri","Adi","Sri","Rudi","Ratna","Dwi","Lestari","Tri","Sari"
            };
            String[] lastNames = {
                "Santoso","Wijaya","Kusuma","Pratama","Saputra",
                "Wahyudi","Nugroho","Setiawan","Hidayat","Firmansyah",
                "Susanto","Lubis","Siregar","Sihombing","Pangestu"
            };
            String[] kelurahans = {"Sukabersih","Maju Jaya","Tirta Makmur","Mekar Sari","Sumber Rejo"};
            Random rnd = new Random(42);

            for (int i = 1; i <= 50; i++) {
                String email = "warga" + i + "@smartwaste.com";
                if (!userRepository.existsByEmail(email)) {
                    Citizen c = new Citizen(
                        firstNames[rnd.nextInt(firstNames.length)] + " " + lastNames[rnd.nextInt(lastNames.length)],
                        email,
                        passwordEncoder.encode("Warga@123"),
                        "0812" + (10000000 + rnd.nextInt(90000000)),
                        "3201" + (100000000000L + rnd.nextInt(900000000)),
                        "Jl. Dummy No. " + i
                    );
                    c.setRtRw(String.format("%02d/%02d", rnd.nextInt(10) + 1, rnd.nextInt(10) + 1));
                    c.setKelurahan(kelurahans[rnd.nextInt(kelurahans.length)]);
                    Citizen saved = citizenRepository.save(c);
                    GreenWallet wallet = new GreenWallet(saved);
                    wallet.addPoints(50 + rnd.nextInt(4950));
                    greenWalletRepository.save(wallet);
                }
            }
            log.info("✅ 50 Citizen dummy berhasil dibuat.");
        }
    }

    // ==================== Kategori Sampah ====================

    private void initWasteCategories() {
        if (wasteCategoryRepository.count() == 0) {
            WasteCategory[] categories = {
                new WasteCategory("Sisa Makanan & Dapur",
                    "Sampah organik dari sisa makanan, sayuran, dan buah-buahan",
                    WasteType.ORGANIC, 5.0, "🍎"),
                new WasteCategory("Daun & Ranting",
                    "Sampah organik dari kebun seperti daun kering dan ranting kecil",
                    WasteType.ORGANIC, 3.0, "🍃"),
                new WasteCategory("Botol Plastik (PET)",
                    "Botol minuman plastik jenis PET yang dapat didaur ulang",
                    WasteType.INORGANIC, 12.0, "♻️"),
                new WasteCategory("Kertas & Kardus",
                    "Kertas bekas, koran, majalah, kardus bersih yang dapat didaur ulang",
                    WasteType.INORGANIC, 8.0, "📦"),
                new WasteCategory("Kaleng Logam",
                    "Kaleng minuman, kaleng makanan dari aluminium atau baja",
                    WasteType.INORGANIC, 15.0, "🥫"),
                new WasteCategory("Baterai Bekas",
                    "Baterai AA, AAA, baterai tombol, atau baterai lithium bekas — limbah B3",
                    WasteType.B3, 30.0, "🔋"),
                new WasteCategory("Elektronik & E-Waste",
                    "Handphone rusak, charger bekas, PCB, lampu LED/neon — limbah B3 elektronik",
                    WasteType.B3, 50.0, "💻")
            };
            for (WasteCategory cat : categories) wasteCategoryRepository.save(cat);
            log.info("✅ 7 kategori sampah berhasil dibuat");
        }
    }

    // ==================== Waste Deposit Dummy Data ====================

    /**
     * Membuat data setoran sampah dummy untuk mengisi:
     * <ul>
     *   <li>Grafik distribusi berat &amp; frekuensi kategori di tab Analitik</li>
     *   <li>Angka konfirmasi di leaderboard petugas</li>
     *   <li>Tabel riwayat di tab Riwayat</li>
     *   <li>Beberapa setoran PENDING di tab Tugas Aktif</li>
     * </ul>
     * Bersifat idempotent — tidak akan membuat ulang jika sudah ada data.
     */
    private void initWasteDeposits() {
        // Skip jika sudah ada cukup data (threshold 100 agar idempotent tapi tetap bisa top-up)
        if (wasteDepositRepository.count() >= 100) return;

        List<Citizen>       citizens   = citizenRepository.findAll();
        List<Collector>     collectors = collectorRepository.findAll();
        List<WasteCategory> categories = wasteCategoryRepository.findAll();

        if (citizens.isEmpty() || collectors.isEmpty() || categories.isEmpty()) {
            log.warn("⚠️ Deposit seeder dilewati: citizens/collectors/categories belum siap.");
            return;
        }

        // Hanya gunakan collector manusia (non-IoT) untuk konfirmasi manual
        List<Collector> human = collectors.stream().filter(c -> !c.isIotDevice()).toList();
        if (human.isEmpty()) human = collectors;

        Random        rnd     = new Random(123);
        LocalDateTime now     = LocalDateTime.now();
        int           created = 0;

        // ── 150 deposit CONFIRMED — tersebar 30 hari terakhir ──────────────
        for (int i = 0; i < 150; i++) {
            Citizen      citizen   = citizens.get(rnd.nextInt(citizens.size()));
            Collector    collector = human.get(rnd.nextInt(human.size()));
            WasteCategory cat      = categories.get(rnd.nextInt(categories.size()));

            // Berat acak antara 0.5 – 25 kg
            double weight = Math.round((0.5 + rnd.nextInt(24) + rnd.nextDouble()) * 10.0) / 10.0;
            double points = calcPoints(weight, cat);

            // Waktu tersebar merata dalam 30 hari terakhir
            LocalDateTime createdAt   = now.minusDays(rnd.nextInt(30))
                                           .minusHours(rnd.nextInt(24))
                                           .minusMinutes(rnd.nextInt(60));
            LocalDateTime confirmedAt = createdAt.plusHours(1 + rnd.nextInt(4));

            WasteDeposit d = new WasteDeposit(citizen, cat, weight, "Setoran dummy #" + (i + 1));
            d.setCollector(collector);
            d.setStatus(DepositStatus.CONFIRMED);
            d.setPointsEarned(points);
            d.setConfirmedAt(confirmedAt);
            d.setCreatedAt(createdAt);
            d.setPickupProofUrl("");
            wasteDepositRepository.save(d);

            // Kredit poin ke wallet warga
            greenWalletRepository.findByCitizen(citizen).ifPresent(w -> {
                w.addPoints(points);
                greenWalletRepository.save(w);
            });

            // Update muatan kendaraan collector (capped di max)
            double currentLoad = collector.getCurrentLoadKg() != null ? collector.getCurrentLoadKg() : 0.0;
            double maxCapacity = collector.getMaxCapacityKg() != null ? collector.getMaxCapacityKg() : 500.0;
            
            double newLoad = Math.min(currentLoad + weight, maxCapacity);
            collector.setCurrentLoadKg(newLoad);
            collectorRepository.save(collector);

            created++;
        }

        // ── 10 deposit PENDING — antrean tugas aktif ────────────────────────
        for (int i = 0; i < 10; i++) {
            Citizen      citizen = citizens.get(rnd.nextInt(citizens.size()));
            WasteCategory cat    = categories.get(rnd.nextInt(categories.size()));
            double weight = Math.round((0.5 + rnd.nextInt(15) + rnd.nextDouble()) * 10.0) / 10.0;

            LocalDateTime createdAt = now.minusMinutes(10 + rnd.nextInt(170)); // 10–180 mnt lalu

            // Koordinat acak di sekitar area Itenas Bandung (untuk marker peta)
            double lat = -6.8975 + (rnd.nextDouble() - 0.5) * 0.02;
            double lon = 107.6350 + (rnd.nextDouble() - 0.5) * 0.02;

            WasteDeposit d = new WasteDeposit(citizen, cat, weight,
                "Menunggu konfirmasi petugas #" + (i + 1));
            d.setStatus(DepositStatus.PENDING);
            d.setCreatedAt(createdAt);
            d.setLocation(String.format("%.4f,%.4f", lat, lon));
            wasteDepositRepository.save(d);
            created++;
        }

        log.info("✅ {} data dummy WasteDeposit berhasil dibuat (150 CONFIRMED + 10 PENDING).", created);
    }

    /**
     * Kalkulasi poin inline — mereplikasi logika Strategy Pattern
     * tanpa inject bean (cukup untuk keperluan seeder).
     */
    private double calcPoints(double weightKg, WasteCategory category) {
        double base = weightKg * category.getPointsPerKg();
        return switch (category.getType()) {
            case ORGANIC   -> Math.round(base * 1.0);
            case INORGANIC -> Math.round(base * 1.5);
            case B3        -> Math.round(base * 2.0 + 20);
        };
    }
}
