package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class CsvtoExcelMain {
    public static void main(String[] args) {
        System.out.println("hi");

        ApplicationContext context = SpringApplication.run(CsvtoExcelMain.class, args);

        CsvReader csvReader = context.getBean(CsvReader.class);
        ExcelWriter excelWriter = context.getBean(ExcelWriter.class);

        String csvFilePath = "D:\\Anu\\java\\PanasonicFile.csv";
        String excelFilePath = "D:\\Anu\\java\\PanasonicFile.xlsx";


        List<CsvExcelClass> csvExcelClass = csvReader.readFromCsv(csvFilePath);
        if (csvExcelClass != null) {
            excelWriter.writeToExcel(csvExcelClass, excelFilePath);
            System.out.println("Data exported to Excel successfully!");
        } else {
            System.out.println("Failed to read data from CSV.");
        }


    }
}