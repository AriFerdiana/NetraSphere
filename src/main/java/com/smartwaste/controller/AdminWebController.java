package com.smartwaste.controller;

import com.smartwaste.dto.request.RegisterCollectorRequest;
import com.smartwaste.repository.WasteDepositRepository;
import com.smartwaste.service.CitizenService;
import com.smartwaste.service.CollectorService;
import com.smartwaste.service.GreenWalletService;
import com.smartwaste.service.ReportService;
import com.smartwaste.service.WasteCategoryService;
import com.smartwaste.service.WasteDepositService;
import com.smartwaste.service.impl.CsvImportService;
import com.smartwaste.service.impl.PdfExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.transaction.annotation.Transactional;

/**
 * Controller untuk halaman-halaman Admin.
 *
 * <p><b>OOP — Encapsulation:</b> Semua operasi CRUD admin diproses melalui
 * service layer, controller hanya bertanggung jawab atas routing dan
 * pengiriman pesan feedback ke view.</p>
 */
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminWebController {

    private final ReportService reportService;
    private final CitizenService citizenService;
    private final CollectorService collectorService;
    private final WasteDepositService depositService;
    private final WasteCategoryService categoryService;
    private final GreenWalletService walletService;
    private final PdfExportService pdfExportService;
    private final CsvImportService csvImportService;
    private final WasteDepositRepository depositRepository;

    public AdminWebController(ReportService reportService,
                               CitizenService citizenService,
                               CollectorService collectorService,
                               WasteDepositService depositService,
                               WasteCategoryService categoryService,
                               GreenWalletService walletService,
                               PdfExportService pdfExportService,
                               CsvImportService csvImportService,
                               WasteDepositRepository depositRepository) {
        this.reportService = reportService;
        this.citizenService = citizenService;
        this.collectorService = collectorService;
        this.depositService = depositService;
        this.categoryService = categoryService;
        this.walletService = walletService;
        this.pdfExportService = pdfExportService;
        this.csvImportService = csvImportService;
        this.depositRepository = depositRepository;
    }

    // ==================== DASHBOARD UTAMA ====================

    @GetMapping("/dashboard")
    @Transactional(readOnly = true)
    public String dashboard(Model model,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "") String search,
                            @RequestParam(defaultValue = "") String collectorSearch,
                            @RequestParam(required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) java.time.LocalDate startDate,
                            @RequestParam(required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) java.time.LocalDate endDate,
                            @RequestParam(required = false) String depositStatus) {

        java.time.LocalDateTime start = (startDate != null) ? startDate.atStartOfDay() : null;
        java.time.LocalDateTime end = (endDate != null) ? endDate.atTime(23, 59, 59) : null;

        // Data utama dashboard
        model.addAttribute("report", reportService.getSummary());

        // Manajemen Warga (dengan search dan pagination)
        model.addAttribute("citizens", search.isBlank()
                ? citizenService.getAllCitizens(PageRequest.of(page, 10))
                : citizenService.searchCitizens(search, PageRequest.of(page, 10)));

        // Semua citizen (termasuk nonaktif) untuk admin view
        model.addAttribute("allCitizens", citizenService.getAllCitizens(PageRequest.of(0, 100)));

        // Manajemen Petugas (dengan search)
        model.addAttribute("collectors", collectorSearch.isBlank()
                ? collectorService.getAllCollectors(PageRequest.of(0, 50))
                : collectorService.searchCollectors(collectorSearch, PageRequest.of(0, 50)));

        // Setoran Sampah (dengan filter tanggal dan status)
        model.addAttribute("deposits", depositService.getAllDeposits(start, end, depositStatus,
                PageRequest.of(0, 50, Sort.by("createdAt").descending())));

        // Kategori sampah
        model.addAttribute("categories", categoryService.getAll());

        // Penukaran poin: pending (untuk approval) + riwayat semua
        model.addAttribute("redemptions", walletService.getPendingRedemptions(
                PageRequest.of(0, 10, Sort.by("createdAt").descending())));
        model.addAttribute("redemptionHistory", walletService.getAllRedemptions(
                PageRequest.of(0, 30, Sort.by("createdAt").descending())));

        model.addAttribute("search", search);
        model.addAttribute("collectorSearch", collectorSearch);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("depositStatus", depositStatus);
        model.addAttribute("pageTitle", "Admin Dashboard");

        return "admin/dashboard";
    }

    // ==================== EXPORT LAPORAN ====================

    /**
     * Export semua setoran ke format PDF.
     */
    @GetMapping("/export/deposits/pdf")
    public org.springframework.http.ResponseEntity<byte[]> exportDepositsPdf() {
        byte[] pdfBytes = pdfExportService.exportDepositsToPdf();
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment",
                "Laporan_Setoran_" + java.time.LocalDate.now() + ".pdf");
        return new org.springframework.http.ResponseEntity<>(pdfBytes, headers,
                org.springframework.http.HttpStatus.OK);
    }

    /**
     * Export semua setoran ke format CSV.
     * FIX Bug #1: URL endpoint diperbaiki dari /export/deposits → /export/deposits/csv
     */
    @GetMapping("/export/deposits/csv")
    public org.springframework.http.ResponseEntity<byte[]> exportDepositsCsv() {
        java.util.List<com.smartwaste.entity.WasteDeposit> deposits = depositRepository.findAll();
        StringBuilder csv = new StringBuilder("ID,Tanggal,Warga,Kategori,Berat(kg),Poin,Status\n");
        java.time.format.DateTimeFormatter fmt =
                java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (com.smartwaste.entity.WasteDeposit d : deposits) {
            csv.append(String.format("%s,%s,%s,%s,%.2f,%.2f,%s\n",
                    d.getId(),
                    d.getCreatedAt().format(fmt),
                    d.getCitizen() != null ? d.getCitizen().getName() : "-",
                    d.getCategory() != null ? d.getCategory().getName() : "-",
                    d.getWeightKg(),
                    d.getPointsEarned(),
                    d.getStatus()));
        }
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.parseMediaType("text/csv"));
        headers.setContentDispositionFormData("attachment",
                "Laporan_Setoran_" + java.time.LocalDate.now() + ".csv");
        return new org.springframework.http.ResponseEntity<>(
                csv.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8),
                headers,
                org.springframework.http.HttpStatus.OK);
    }

    // ==================== MANAJEMEN KATEGORI ====================

    @PostMapping("/categories")
    public String createCategory(@RequestParam String name,
                                 @RequestParam String description,
                                 @RequestParam String type,
                                 @RequestParam double pointsPerKg,
                                 RedirectAttributes redirectAttributes) {
        try {
            categoryService.create(name, description, type, pointsPerKg, null);
            redirectAttributes.addFlashAttribute("successMessage",
                    "✅ Kategori '" + name + "' berhasil ditambahkan.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Gagal menambah kategori: " + e.getMessage());
        }
        return "redirect:/admin/dashboard?activeTab=categories";
    }

    @PostMapping("/categories/{id}/toggle")
    public String toggleCategory(@PathVariable String id,
                                 RedirectAttributes redirectAttributes) {
        try {
            categoryService.toggleActive(id);
            redirectAttributes.addFlashAttribute("successMessage", "✅ Status kategori berhasil diubah.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Gagal mengubah status kategori: " + e.getMessage());
        }
        return "redirect:/admin/dashboard?activeTab=categories";
    }

    /**
     * Edit nama, deskripsi, dan poin per kg kategori.
     */
    @PostMapping("/categories/{id}/edit")
    public String editCategory(@PathVariable String id,
                               @RequestParam String name,
                               @RequestParam String description,
                               @RequestParam double pointsPerKg,
                               RedirectAttributes redirectAttributes) {
        try {
            categoryService.update(id, name, description, pointsPerKg);
            redirectAttributes.addFlashAttribute("successMessage",
                    "✅ Kategori berhasil diperbarui.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Gagal memperbarui kategori: " + e.getMessage());
        }
        return "redirect:/admin/dashboard?activeTab=categories";
    }

    // ==================== MANAJEMEN WARGA ====================

    /**
     * Toggle status aktif/nonaktif warga (dua arah — bisa reaktivasi).
     * FIX Bug #2: Sebelumnya hanya bisa nonaktifkan, sekarang toggle dua arah.
     */
    @PostMapping("/citizens/{id}/toggle")
    public String toggleCitizen(@PathVariable String id,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "") String search,
                                RedirectAttributes redirectAttributes) {
        try {
            citizenService.toggleCitizenActive(id);
            redirectAttributes.addFlashAttribute("successMessage", "✅ Status warga berhasil diubah.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Gagal mengubah status warga: " + e.getMessage());
        }
        // FIX Bug #7: Kembalikan ke tab yang sama dengan parameter yang sama
        return "redirect:/admin/dashboard?activeTab=citizens&page=" + page + "&search=" + search;
    }

    @PostMapping("/citizens/import")
    public String importCitizens(
            @RequestParam("file") org.springframework.web.multipart.MultipartFile file,
            RedirectAttributes redirectAttributes) {
        String result = csvImportService.importCitizens(file);
        if (result.startsWith("Terjadi kesalahan") || result.startsWith("File CSV")) {
            redirectAttributes.addFlashAttribute("errorMessage", "❌ " + result);
        } else {
            redirectAttributes.addFlashAttribute("successMessage", "✅ " + result);
        }
        return "redirect:/admin/dashboard?activeTab=citizens";
    }

    // ==================== MANAJEMEN PETUGAS (COLLECTOR) ====================

    /**
     * Daftarkan petugas collector baru dari admin dashboard.
     */
    @PostMapping("/collectors")
    public String registerCollector(@RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String password,
                                    @RequestParam(required = false, defaultValue = "") String phone,
                                    @RequestParam(required = false, defaultValue = "-") String vehicleNumber,
                                    @RequestParam(required = false, defaultValue = "Belum ditentukan") String assignedArea,
                                    RedirectAttributes redirectAttributes) {
        try {
            RegisterCollectorRequest request = new RegisterCollectorRequest();
            request.setName(name);
            request.setEmail(email);
            request.setPassword(password);
            request.setPhone(phone);
            request.setVehicleNumber(vehicleNumber);
            request.setAssignedArea(assignedArea);
            collectorService.registerCollector(request);
            redirectAttributes.addFlashAttribute("successMessage",
                    "✅ Petugas '" + name + "' berhasil didaftarkan.");
        } catch (com.smartwaste.exception.DuplicateEmailException e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Email '" + email + "' sudah terdaftar dalam sistem.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Gagal mendaftarkan petugas: " + e.getMessage());
        }
        return "redirect:/admin/dashboard?activeTab=collectors";
    }

    /**
     * Toggle aktif/nonaktif petugas collector.
     */
    @PostMapping("/collectors/{id}/toggle")
    public String toggleCollector(@PathVariable String id,
                                  RedirectAttributes redirectAttributes) {
        try {
            collectorService.toggleActive(id);
            redirectAttributes.addFlashAttribute("successMessage",
                    "✅ Status petugas berhasil diubah.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Gagal mengubah status petugas: " + e.getMessage());
        }
        return "redirect:/admin/dashboard?activeTab=collectors";
    }

    /**
     * Edit data petugas collector.
     */
    @PostMapping("/collectors/{id}/edit")
    public String editCollector(@PathVariable String id,
                                @RequestParam String name,
                                @RequestParam(required = false) String phone,
                                @RequestParam(required = false) String vehicleNumber,
                                @RequestParam(required = false) String assignedArea,
                                RedirectAttributes redirectAttributes) {
        try {
            collectorService.updateCollector(id, name, phone, vehicleNumber, assignedArea);
            redirectAttributes.addFlashAttribute("successMessage",
                    "✅ Data petugas berhasil diperbarui.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Gagal memperbarui data petugas: " + e.getMessage());
        }
        return "redirect:/admin/dashboard?activeTab=collectors";
    }

    // ==================== PENUKARAN POIN (REDEMPTIONS) ====================

    /**
     * Admin menyetujui penukaran poin.
     * FIX Bug #3: Dipanggil dari modal AlpineJS (bukan window.prompt).
     */
    @PostMapping("/redemptions/{id}/approve")
    public String approveRedemption(@PathVariable String id,
                                    @RequestParam(required = false, defaultValue = "") String adminNotes,
                                    RedirectAttributes redirectAttributes) {
        try {
            walletService.approveRedemption(id, adminNotes);
            redirectAttributes.addFlashAttribute("successMessage",
                    "✅ Penukaran poin berhasil disetujui!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Gagal menyetujui penukaran: " + e.getMessage());
        }
        return "redirect:/admin/dashboard?activeTab=redemptions";
    }

    /**
     * Admin menolak penukaran poin.
     * FIX Bug #3: Dipanggil dari modal AlpineJS (bukan window.prompt).
     */
    @PostMapping("/redemptions/{id}/reject")
    public String rejectRedemption(@PathVariable String id,
                                   @RequestParam(required = false, defaultValue = "Ditolak oleh admin.") String adminNotes,
                                   RedirectAttributes redirectAttributes) {
        try {
            walletService.rejectRedemption(id, adminNotes);
            redirectAttributes.addFlashAttribute("successMessage",
                    "✅ Penukaran poin berhasil ditolak.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Gagal menolak penukaran: " + e.getMessage());
        }
        return "redirect:/admin/dashboard?activeTab=redemptions";
    }
}
