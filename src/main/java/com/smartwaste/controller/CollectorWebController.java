package com.smartwaste.controller;

import com.smartwaste.dto.response.WasteDepositResponse;
import com.smartwaste.repository.CollectorRepository;
import com.smartwaste.service.WasteDepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller MVC untuk dashboard Petugas (Collector).
 */
@Controller
@RequestMapping("/collector")
@RequiredArgsConstructor
public class CollectorWebController {

    private final WasteDepositService depositService;
    private final CollectorRepository collectorRepository;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('COLLECTOR')")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails,
                            @RequestParam(defaultValue = "0") int page,
                            Model model) {
        
        // Load data profil collector
        collectorRepository.findByEmail(userDetails.getUsername())
                .ifPresent(collector -> {
                    model.addAttribute("collectorName", collector.getName());
                    model.addAttribute("vehicleNumber", collector.getVehicleNumber());
                    model.addAttribute("assignedArea", collector.getAssignedArea());
                    model.addAttribute("available", collector.isAvailable());
                    
                    // Add stats
                    long totalConfirmed = depositService.countByCollectorAndStatus(collector, com.smartwaste.entity.enums.DepositStatus.CONFIRMED);
                    long totalRejected = depositService.countByCollectorAndStatus(collector, com.smartwaste.entity.enums.DepositStatus.REJECTED);
                    
                    model.addAttribute("totalConfirmed", totalConfirmed);
                    model.addAttribute("totalRejected", totalRejected);
                });

        // Load hanya setoran yang berstatus PENDING
        Page<WasteDepositResponse> pendingDeposits = depositService.getPendingDeposits(
                PageRequest.of(page, 50, Sort.by("createdAt").descending()));

        model.addAttribute("pendingDeposits", pendingDeposits);

        return "collector/dashboard";
    }

    @PostMapping("/toggle-availability")
    @PreAuthorize("hasRole('COLLECTOR')")
    public String toggleAvailability(@AuthenticationPrincipal UserDetails userDetails,
                                     org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        try {
            collectorRepository.findByEmail(userDetails.getUsername()).ifPresent(collector -> {
                collector.setAvailable(!collector.isAvailable());
                collectorRepository.save(collector);
            });
            redirectAttributes.addFlashAttribute("successMessage", "Status ketersediaan berhasil diperbarui.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal memperbarui status: " + e.getMessage());
        }
        return "redirect:/collector/dashboard";
    }

    @PostMapping("/deposit/{id}/confirm")
    @PreAuthorize("hasRole('COLLECTOR')")
    public String confirmDeposit(@AuthenticationPrincipal UserDetails userDetails,
                                 @org.springframework.web.bind.annotation.PathVariable String id,
                                 org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        try {
            depositService.confirmDeposit(id, userDetails.getUsername());
            redirectAttributes.addFlashAttribute("successMessage", "Setoran berhasil dikonfirmasi dan poin telah disalurkan.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal konfirmasi: " + e.getMessage());
        }
        return "redirect:/collector/dashboard";
    }

    @PostMapping("/deposit/{id}/reject")
    @PreAuthorize("hasRole('COLLECTOR')")
    public String rejectDeposit(@AuthenticationPrincipal UserDetails userDetails,
                                @org.springframework.web.bind.annotation.PathVariable String id,
                                @RequestParam String reason,
                                org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        try {
            depositService.rejectDeposit(id, userDetails.getUsername(), reason);
            redirectAttributes.addFlashAttribute("successMessage", "Setoran berhasil ditolak.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menolak setoran: " + e.getMessage());
        }
        return "redirect:/collector/dashboard";
    }
}
