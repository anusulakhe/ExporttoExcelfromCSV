package org.example;

import com.opencsv.bean.AbstractBeanField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocaDateConverter extends AbstractBeanField<LocalDate, String> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMM-yy");

    @Override
    protected LocalDate convert(String value) {
        try {
            return LocalDate.parse(value, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use dd-MMM-yy. Value: " + value);
        }
    }


}
