package com.smartwaste.controller;

import com.smartwaste.dto.request.CreateWasteDepositRequest;
import com.smartwaste.dto.request.RedeemPointsRequest;
import com.smartwaste.service.CitizenService;
import com.smartwaste.service.GreenWalletService;
import com.smartwaste.service.WasteCategoryService;
import com.smartwaste.service.WasteDepositService;
import com.smartwaste.service.impl.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller untuk halaman dashboard Citizen.
 * Mengambil data dari service layer dan meneruskan ke Thymeleaf template.
 */
@Controller
@RequestMapping("/citizen")
@PreAuthorize("hasRole('CITIZEN')")
@RequiredArgsConstructor
public class CitizenWebController {

    private final CitizenService citizenService;
    private final GreenWalletService walletService;
    private final WasteDepositService depositService;
    private final WasteCategoryService categoryService;
    private final FileStorageService fileStorageService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication auth) {
        String email = auth.getName();

        model.addAttribute("profile",    citizenService.getMyProfile(email));
        model.addAttribute("wallet",     walletService.getMyWallet(email));
        model.addAttribute("deposits",   depositService.getMyDeposits(email,
                PageRequest.of(0, 10, Sort.by("createdAt").descending())));
        model.addAttribute("categories", categoryService.getAllActive());
        model.addAttribute("pageTitle",  "Dashboard Warga");

        return "citizen/dashboard";
    }

    @PostMapping("/deposit")
    public String createDeposit(Authentication auth, 
                                @RequestParam String categoryId, 
                                @RequestParam Double weightKg, 
                                @RequestParam(required = false) String notes,
                                @RequestParam(value = "file", required = false) MultipartFile file,
                                RedirectAttributes redirectAttributes) {
        try {
            CreateWasteDepositRequest req = new CreateWasteDepositRequest();
            req.setCategoryId(categoryId);
            req.setWeightKg(weightKg);
            req.setNotes(notes);
            
            if (file != null && !file.isEmpty()) {
                String fileUrl = fileStorageService.storeFile(file);
                req.setImageUrl(fileUrl);
            }
            
            depositService.createDeposit(auth.getName(), req);
            redirectAttributes.addFlashAttribute("successMessage", "Berhasil membuat setoran! Harap tunggu petugas mengkonfirmasi.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menyetor sampah: " + e.getMessage());
        }
        return "redirect:/citizen/dashboard";
    }

    @PostMapping("/redeem")
    public String redeemPoints(Authentication auth, 
                               @RequestParam Double points, 
                               @RequestParam String description,
                               RedirectAttributes redirectAttributes) {
        try {
            walletService.requestRedemption(auth.getName(), points, description);
            redirectAttributes.addFlashAttribute("successMessage", "Permintaan penukaran poin Anda berhasil diajukan dan menunggu persetujuan admin.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menukar poin: " + e.getMessage());
        }
        return "redirect:/citizen/dashboard";
    }

    @PostMapping("/settings")
    public String updateSettings(Authentication auth, 
                                 @RequestParam String name, 
                                 @RequestParam String phone, 
                                 @RequestParam String address,
                                 RedirectAttributes redirectAttributes) {
        try {
            var profile = citizenService.getMyProfile(auth.getName());
            citizenService.updateProfile(profile.getId(), name, phone, address);
            redirectAttributes.addFlashAttribute("successMessage", "Profil berhasil diperbarui!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal memperbarui profil: " + e.getMessage());
        }
        return "redirect:/citizen/dashboard";
    }
}
