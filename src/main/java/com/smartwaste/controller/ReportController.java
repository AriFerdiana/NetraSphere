package com.smartwaste.controller;

import com.smartwaste.dto.response.ApiResponse;
import com.smartwaste.dto.response.ReportSummaryResponse;
import com.smartwaste.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
@Tag(name = "Reports", description = "Laporan dan statistik sistem (Admin)")
@SecurityRequirement(name = "bearerAuth")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/summary")
    @PreAuthorize("hasAnyRole('ADMIN', 'COLLECTOR')")
    @Operation(summary = "Ringkasan laporan keseluruhan sistem")
    public ResponseEntity<ApiResponse<ReportSummaryResponse>> getSummary() {
        return ResponseEntity.ok(ApiResponse.success("Laporan berhasil diambil.", reportService.getSummary()));
    }
}
