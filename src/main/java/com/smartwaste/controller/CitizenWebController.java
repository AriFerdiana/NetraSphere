package com.smartwaste.controller;

import com.smartwaste.dto.request.CreateWasteDepositRequest;
import com.smartwaste.dto.request.RedeemPointsRequest;
import com.smartwaste.service.CitizenService;
import com.smartwaste.service.GreenWalletService;
import com.smartwaste.service.WasteCategoryService;
import com.smartwaste.service.WasteDepositService;
import com.smartwaste.service.ReportService;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller untuk halaman dashboard Citizen.
 * Mengambil data dari service layer dan meneruskan ke Thymeleaf template.
 */
@Controller
@RequestMapping("/citizen")
@PreAuthorize("hasRole('CITIZEN')")
public class CitizenWebController {

    private final CitizenService citizenService;
    private final GreenWalletService walletService;
    private final WasteDepositService depositService;
    private final WasteCategoryService categoryService;
    private final FileStorageService fileStorageService;
    private final ReportService reportService;

    public CitizenWebController(CitizenService citizenService,
                                GreenWalletService walletService,
                                WasteDepositService depositService,
                                WasteCategoryService categoryService,
                                FileStorageService fileStorageService,
                                ReportService reportService) {
        this.citizenService = citizenService;
        this.walletService = walletService;
        this.depositService = depositService;
        this.categoryService = categoryService;
        this.fileStorageService = fileStorageService;
        this.reportService = reportService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication auth) {
        String email = auth.getName();

        try {
            model.addAttribute("profile",    citizenService.getMyProfile(email));
            model.addAttribute("wallet",     walletService.getMyWallet(email));
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Gagal memuat profil Anda: " + e.getMessage());
            return "redirect:/auth/login";
        }

        try {
            model.addAttribute("deposits",   depositService.getMyDeposits(email,
                    PageRequest.of(0, 10, Sort.by("createdAt").descending())));
        } catch (Exception e) {
            model.addAttribute("deposits", org.springframework.data.domain.Page.empty());
        }

        model.addAttribute("categories", categoryService.getAllActive());
        
        try {
            model.addAttribute("topCitizens", reportService.getSummary().getTopCitizens());
        } catch (Exception e) {
            model.addAttribute("topCitizens", java.util.List.of());
        }

        model.addAttribute("pageTitle",  "Dashboard Warga");
        
        // Mock Daily Quests
        List<Map<String, Object>> quests = new ArrayList<>();
        Map<String, Object> q1 = new HashMap<>();
        q1.put("title", "Setor 2kg Sampah");
        q1.put("progress", 65);
        q1.put("reward", 50);
        q1.put("icon", "⚖️");
        quests.add(q1);
        
        Map<String, Object> q2 = new HashMap<>();
        q2.put("title", "Ajak 1 Tetangga");
        q2.put("progress", 0);
        q2.put("reward", 100);
        q2.put("icon", "🤝");
        quests.add(q2);
        
        model.addAttribute("quests", quests);

        // Generate 50 dummy rewards for household/kitchen
        List<Map<String, Object>> rewards = new ArrayList<>();
        String[] icons = {
            "🍚", "🛢️", "🍬", "🧂", "🥚", "🧅", "🧄", "🌶️", "🍅", "🍜",
            "☕", "🍵", "🥛", "🧀", "🍯", "🧴", "🌶️", "🌾", "🌾", "🧈",
            "🧼", "🧴", "🪥", "🧼", "🧺", "🌸", "🧹", "🧻", "🧻", "🧽",
            "🌾", "🐟", "🥩", "🥛", "🛢️", "🥫", "🧂", "🧂", "🧂", "🧂",
            "🍪", "🍫", "🍹", "💧", "🔥", "⚡", "⚡", "📱", "📱", "🌐"
        };
        String[] names = {
            "Beras Premium 5kg", "Minyak Goreng 2L", "Gula Pasir 1kg", "Garam Dapur 500g", "Telur Ayam 1kg",
            "Bawang Merah 500g", "Bawang Putih 500g", "Cabai Rawit 250g", "Tomat Segar 1kg", "Mie Instan 1 Dus",
            "Kopi Bubuk 250g", "Teh Celup 1 Box", "Susu Kental Manis", "Keju Cheddar 165g", "Madu Asli 250ml",
            "Kecap Manis 520ml", "Saus Sambal 340ml", "Tepung Terigu 1kg", "Tepung Beras 500g", "Margarin 200g",
            "Sabun Mandi Cair 450ml", "Shampoo 300ml", "Pasta Gigi 190g", "Sabun Cuci Piring 780ml", "Deterjen Bubuk 1kg",
            "Pewangi Pakaian 800ml", "Pembersih Lantai 750ml", "Tisu Wajah 250s", "Tisu Toilet 4 Roll", "Spons Cuci Piring",
            "Beras Merah 2kg", "Sarden Kaleng 425g", "Kornet Sapi 340g", "Susu UHT 1L", "Minyak Wijen 150ml",
            "Saus Tiram 275ml", "Kaldu Ayam Bubuk", "Merica Bubuk 50g", "Ketumbar Bubuk 50g", "Kunyit Bubuk 50g",
            "Biskuit Gandum", "Wafer Coklat", "Sirup Jeruk 460ml", "Air Mineral 1 Galon", "Gas Elpiji 3kg",
            "Voucher Listrik 50k", "Voucher Listrik 100k", "Pulsa Telkomsel 50k", "Pulsa Indosat 50k", "Paket Data 10GB"
        };
        int[] basePoints = {1500, 800, 250, 100, 450, 300, 350, 400, 200, 1200, 350, 150, 200, 300, 800, 250, 200, 200, 150, 150, 400, 350, 200, 250, 450, 300, 250, 200, 250, 50, 800, 400, 450, 300, 350, 250, 100, 50, 50, 50, 200, 150, 300, 350, 1000, 5000, 10000, 5000, 5000, 6000};
        
        for (int i = 0; i < 50; i++) {
            Map<String, Object> reward = new HashMap<>();
            reward.put("id", i + 1);
            reward.put("name", names[i]);
            reward.put("points", basePoints[i]);
            reward.put("icon", icons[i]);
            reward.put("redeemCount", (int)(Math.random() * 500) + 50);
            reward.put("isPopular", i < 5 || Math.random() > 0.85);
            
            // Tiered logic
            String reqLevel = "Green Starter";
            if (basePoints[i] >= 5000) reqLevel = "Silver Elite";
            if (basePoints[i] >= 10000) reqLevel = "Gold Champion";
            reward.put("requiredLevel", reqLevel);
            
            rewards.add(reward);
        }
        model.addAttribute("rewards", rewards);

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
