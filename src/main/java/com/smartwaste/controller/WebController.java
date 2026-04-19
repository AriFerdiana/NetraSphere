package com.smartwaste.controller;

import com.smartwaste.service.impl.PasswordResetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller untuk halaman-halaman publik (landing page, login, register).
 * Menggunakan @Controller (bukan @RestController) untuk mengembalikan nama view Thymeleaf.
 */
@Controller
@RequiredArgsConstructor
public class WebController {

    private final PasswordResetService passwordResetService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/auth/login")
    public String loginPage(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String logout,
            Model model) {
        if (error != null) {
            model.addAttribute("errorMsg", "Email atau password salah. Silakan coba lagi.");
        }
        if (logout != null) {
            model.addAttribute("successMsg", "Anda berhasil logout. Sampai jumpa! 👋");
        }
        return "auth/login";
    }

    @GetMapping("/auth/register")
    public String registerPage() {
        return "auth/register";
    }

    @GetMapping("/auth/access-denied")
    public String accessDenied() {
        return "auth/access-denied";
    }

    @GetMapping("/auth/forgot-password")
    public String forgotPasswordPage() {
        return "auth/forgot-password";
    }

    @PostMapping("/auth/forgot-password")
    public String processForgotPassword(@RequestParam("email") String email, 
                                        RedirectAttributes redirectAttributes) {
        passwordResetService.createPasswordResetTokenForUser(email);
        redirectAttributes.addFlashAttribute("successMessage", "Jika email terdaftar, instruksi reset password telah dikirim.");
        return "redirect:/auth/login";
    }

    @GetMapping("/auth/reset-password")
    public String resetPasswordPage(@RequestParam("token") String token, Model model) {
        model.addAttribute("token", token);
        return "auth/reset-password";
    }

    @PostMapping("/auth/reset-password")
    public String processResetPassword(@RequestParam("token") String token, 
                                       @RequestParam("newPassword") String newPassword,
                                       RedirectAttributes redirectAttributes) {
        boolean success = passwordResetService.resetPassword(token, newPassword);
        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "Password berhasil diubah. Silakan login.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Token tidak valid atau sudah kedaluwarsa.");
        }
        return "redirect:/auth/login";
    }
}
