package org.example;


import java.util.List;
import java.io.FileReader;
import java.io.Reader;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class CsvReader {

    public List<CsvExcelClass> readFromCsv(String filePath){
        try (Reader reader = new FileReader(filePath)) {
            CsvToBean<CsvExcelClass> csvToBean = new CsvToBeanBuilder<CsvExcelClass>(reader)
                    .withType(CsvExcelClass.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}


