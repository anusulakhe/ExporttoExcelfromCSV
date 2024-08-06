package org.example;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CsvExcelClass {

    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "SrNo")
    private int srno;
    @CsvBindByName(column = "vendorcode")
    private String vendorcode;
    @CsvBindByName(column = "vendorname")
    private String vendorname;
    @CsvBindByName(column = "PANNo")
    private String PANNo;
    @CsvBindByName(column = "InvoiceType")
    private String InvoiceType;
    @CsvBindByName(column = "InvoiceNumber")
    private String InvoiceNumber;
    @CsvCustomBindByName(column = "InvoiceDate", converter = LocaDateConverter.class)
    private LocalDate InvoiceDate;

    public LocalDate getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
       this.InvoiceDate = invoiceDate;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public String getInvoiceType() {
        return InvoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        InvoiceType = invoiceType;
    }

    public String getPANNo() {
        return PANNo;
    }

    public void setPANNo(String PANNo) {
        this.PANNo = PANNo;
    }

    public int getSrno() {
        return srno;
    }

    public void setSrno(int srno) {
        this.srno = srno;
    }

    public String getVendorcode() {
        return vendorcode;
    }

    public void setVendorcode(String vendorcode) {
        this.vendorcode = vendorcode;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
