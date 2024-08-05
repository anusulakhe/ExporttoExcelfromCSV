package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Component
public class ExcelWriter {

    public void writeToExcel(List<CsvExcelClass> csvExcelClass, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("SR No.");
        headerRow.createCell(1).setCellValue("Vendor Code");
        headerRow.createCell(2).setCellValue("Vendor Name");
        headerRow.createCell(3).setCellValue("PAN Number");
        headerRow.createCell(4).setCellValue("Invoice Type");
        headerRow.createCell(5).setCellValue("Invoice Number");
        headerRow.createCell(6).setCellValue("Invoice Date");

        for (CsvExcelClass user : csvExcelClass) {
            Row row = sheet.createRow(rowNum++);
            System.out.println(user.getSrno());
            row.createCell(0).setCellValue(user.getSrno());
            row.createCell(1).setCellValue(user.getVendorcode());
            row.createCell(2).setCellValue(user.getVendorname());
            row.createCell(3).setCellValue(user.getPANNo());
            row.createCell(4).setCellValue(user.getInvoiceType());
            row.createCell(5).setCellValue(user.getInvoiceNumber());
            row.createCell(6).setCellValue(user.getInvoiceDate());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
