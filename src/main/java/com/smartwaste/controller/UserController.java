package com.smartwaste.controller;

import com.smartwaste.service.impl.PasswordResetService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
public class UserController {

    private final PasswordResetService passwordResetService;

    @PostMapping("/change-password")
    public String changePassword(Authentication auth,
                                 @RequestParam String oldPassword,
                                 @RequestParam String newPassword,
                                 RedirectAttributes redirectAttributes) {
        boolean success = passwordResetService.changePassword(auth.getName(), oldPassword, newPassword);
        
        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "Password berhasil diubah!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal mengubah password. Pastikan password lama Anda benar.");
        }
        
        // Redirect back to their respective dashboard
        String role = auth.getAuthorities().iterator().next().getAuthority();
        if (role.equals("ROLE_ADMIN")) {
            return "redirect:/admin/dashboard";
        } else if (role.equals("ROLE_COLLECTOR")) {
            return "redirect:/collector/dashboard";
        } else {
            return "redirect:/citizen/dashboard";
        }
    }
}
