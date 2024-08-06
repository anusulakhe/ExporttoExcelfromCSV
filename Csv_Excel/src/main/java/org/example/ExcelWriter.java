package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


@Component
public class ExcelWriter {

    //LocalDate invoiceDate;
    DateTimeFormatter outputformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");

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
            //LocalDate invoiceDate = LocalDate.parse(user.getInvoiceDate());
            LocalDate inputDate = parseDate(user.getInvoiceDate(),inputFormatter );
            String formattedDate = inputDate.format(outputformatter);
            row.createCell(6).setCellValue(formattedDate);
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static LocalDate parseDate(String invoiceDate, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(invoiceDate,formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

}
