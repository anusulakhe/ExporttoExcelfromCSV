package org.example;

import org.springframework.context.annotation.Bean;

public class CsvExcelConfig {
    @Bean
    public CsvReader csvReader(){
        return new CsvReader();
    }
    @Bean
    public ExcelWriter excelWrite(){
        return new ExcelWriter();
    }
}
