package com.smartwaste.controller;

import com.smartwaste.dto.response.ApiResponse;
import com.smartwaste.dto.response.WasteCategoryResponse;
import com.smartwaste.service.WasteCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Waste Categories", description = "Manajemen kategori sampah")
@SecurityRequirement(name = "bearerAuth")
public class WasteCategoryController {

    private final WasteCategoryService categoryService;

    @GetMapping
    @Operation(summary = "Daftar kategori aktif")
    public ResponseEntity<ApiResponse<List<WasteCategoryResponse>>> getAllActive() {
        return ResponseEntity.ok(ApiResponse.success("Data berhasil diambil.", categoryService.getAllActive()));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Semua kategori (Admin)")
    public ResponseEntity<ApiResponse<List<WasteCategoryResponse>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Data berhasil diambil.", categoryService.getAll()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detail kategori")
    public ResponseEntity<ApiResponse<WasteCategoryResponse>> getById(@PathVariable String id) {
        return ResponseEntity.ok(ApiResponse.success("Data berhasil diambil.", categoryService.getById(id)));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Buat kategori baru (Admin)")
    public ResponseEntity<ApiResponse<WasteCategoryResponse>> create(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String type,
            @RequestParam double pointsPerKg,
            @RequestParam(required = false) String iconUrl) {
        WasteCategoryResponse response = categoryService.create(name, description, type, pointsPerKg, iconUrl);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Kategori berhasil dibuat.", response));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update kategori (Admin)")
    public ResponseEntity<ApiResponse<WasteCategoryResponse>> update(
            @PathVariable String id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") double pointsPerKg) {
        return ResponseEntity.ok(ApiResponse.success("Kategori berhasil diperbarui.",
                categoryService.update(id, name, description, pointsPerKg)));
    }

    @PatchMapping("/{id}/toggle")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Aktifkan/nonaktifkan kategori (Admin)")
    public ResponseEntity<ApiResponse<Void>> toggleActive(@PathVariable String id) {
        categoryService.toggleActive(id);
        return ResponseEntity.ok(ApiResponse.success("Status kategori berhasil diubah."));
    }
}
