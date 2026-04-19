package com.smartwaste.service.impl;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.smartwaste.entity.WasteDeposit;
import com.smartwaste.repository.WasteDepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PdfExportService {

    private final WasteDepositRepository wasteDepositRepository;

    public byte[] exportDepositsToPdf() {
        List<WasteDeposit> deposits = wasteDepositRepository.findAll();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Fonts
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Color.BLACK);
            Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Font tableBodyFont = FontFactory.getFont(FontFactory.HELVETICA, 11, Color.BLACK);

            // Title
            Paragraph title = new Paragraph("Laporan Setoran Sampah - SmartWaste System", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20f);
            document.add(title);

            // Table setup
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1.5f, 2f, 2f, 1.5f, 1f, 2f, 2f}); // Column widths

            // Headers
            String[] headers = {"ID Setoran", "Warga", "Kategori", "Berat (Kg)", "Poin", "Status", "Tanggal"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, tableHeaderFont));
                cell.setBackgroundColor(new Color(16, 185, 129)); // Emerald 500
                cell.setPadding(8f);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            // Data
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            for (WasteDeposit deposit : deposits) {
                addCell(table, deposit.getId(), tableBodyFont);
                addCell(table, deposit.getCitizen() != null ? deposit.getCitizen().getName() : "-", tableBodyFont);
                addCell(table, deposit.getCategory() != null ? deposit.getCategory().getName() : "-", tableBodyFont);
                addCell(table, String.valueOf(deposit.getWeightKg()), tableBodyFont);
                addCell(table, String.valueOf(deposit.getPointsEarned()), tableBodyFont);
                addCell(table, deposit.getStatus() != null ? deposit.getStatus().name() : "-", tableBodyFont);
                addCell(table, deposit.getCreatedAt() != null ? deposit.getCreatedAt().format(dtf) : "-", tableBodyFont);
            }

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

    private void addCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(6f);
        table.addCell(cell);
    }
}
