package com.smartwaste.controller;

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

/**
 * Controller untuk halaman-halaman Admin.
 */
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
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

    @GetMapping("/dashboard")
    public String dashboard(Model model,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "") String search,
                            @RequestParam(required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) java.time.LocalDate startDate,
                            @RequestParam(required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) java.time.LocalDate endDate) {

        java.time.LocalDateTime start = (startDate != null) ? startDate.atStartOfDay() : null;
        java.time.LocalDateTime end = (endDate != null) ? endDate.atTime(23, 59, 59) : null;

        model.addAttribute("report", reportService.getSummary());
        model.addAttribute("citizens", search.isBlank()
                ? citizenService.getAllCitizens(PageRequest.of(page, 10))
                : citizenService.searchCitizens(search, PageRequest.of(page, 10)));
        model.addAttribute("collectors", collectorService.getAllCollectors(PageRequest.of(0, 50)));
        model.addAttribute("deposits", depositService.getAllDeposits(start, end,
                PageRequest.of(0, 50, Sort.by("createdAt").descending())));
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("redemptions", walletService.getPendingRedemptions(
                PageRequest.of(0, 10, Sort.by("createdAt").descending())));
        model.addAttribute("search",    search);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate",   endDate);
        model.addAttribute("pageTitle", "Admin Dashboard");

        return "admin/dashboard";
    }

    @GetMapping("/export/deposits/pdf")
    public org.springframework.http.ResponseEntity<byte[]> exportDepositsPdf() {
        byte[] pdfBytes = pdfExportService.exportDepositsToPdf();
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Laporan_Setoran_" + java.time.LocalDate.now() + ".pdf");
        return new org.springframework.http.ResponseEntity<>(pdfBytes, headers, org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("/export/deposits/csv")
    public org.springframework.http.ResponseEntity<byte[]> exportDepositsCsv() {
        java.util.List<com.smartwaste.entity.WasteDeposit> deposits = depositRepository.findAll();
        StringBuilder csv = new StringBuilder("ID,Tanggal,Warga,Kategori,Berat(kg),Poin,Status\n");
        java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (com.smartwaste.entity.WasteDeposit d : deposits) {
            csv.append(String.format("%s,%s,%s,%s,%.2f,%.2f,%s\n",
                d.getId(), d.getCreatedAt().format(fmt),
                d.getCitizen() != null ? d.getCitizen().getName() : "-",
                d.getCategory() != null ? d.getCategory().getName() : "-",
                d.getWeightKg(), d.getPointsEarned(), d.getStatus()));
        }
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.parseMediaType("text/csv"));
        headers.setContentDispositionFormData("attachment", "Laporan_Setoran.csv");
        return new org.springframework.http.ResponseEntity<>(csv.toString().getBytes(), headers, org.springframework.http.HttpStatus.OK);
    }

    @PostMapping("/categories")
    public String createCategory(@RequestParam String name, @RequestParam String description, 
                                 @RequestParam String type, @RequestParam double pointsPerKg,
                                 RedirectAttributes redirectAttributes) {
        try {
            categoryService.create(name, description, type, pointsPerKg, null);
            redirectAttributes.addFlashAttribute("successMessage", "Kategori sampah berhasil ditambahkan.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menambah kategori: " + e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/categories/{id}/toggle")
    public String toggleCategory(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            categoryService.toggleActive(id);
            redirectAttributes.addFlashAttribute("successMessage", "Status kategori berhasil diubah.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal mengubah status kategori: " + e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/citizens/{id}/toggle")
    public String toggleCitizen(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            citizenService.deactivateCitizen(id);
            redirectAttributes.addFlashAttribute("successMessage", "Status warga berhasil diubah (Nonaktif).");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal mengubah status warga: " + e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/redemptions/{id}/approve")
    public String approveRedemption(@PathVariable String id, @RequestParam String adminNotes, RedirectAttributes redirectAttributes) {
        try {
            walletService.approveRedemption(id, adminNotes);
            redirectAttributes.addFlashAttribute("successMessage", "Penukaran poin berhasil disetujui!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menyetujui penukaran: " + e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/redemptions/{id}/reject")
    public String rejectRedemption(@PathVariable String id, @RequestParam String adminNotes, RedirectAttributes redirectAttributes) {
        try {
            walletService.rejectRedemption(id, adminNotes);
            redirectAttributes.addFlashAttribute("successMessage", "Penukaran poin berhasil ditolak.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menolak penukaran: " + e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/citizens/import")
    public String importCitizens(@RequestParam("file") org.springframework.web.multipart.MultipartFile file, 
                                 RedirectAttributes redirectAttributes) {
        String result = csvImportService.importCitizens(file);
        if (result.startsWith("Terjadi kesalahan") || result.startsWith("File CSV")) {
            redirectAttributes.addFlashAttribute("errorMessage", result);
        } else {
            redirectAttributes.addFlashAttribute("successMessage", result);
        }
        return "redirect:/admin/dashboard?activeTab=citizens";
    }
}
