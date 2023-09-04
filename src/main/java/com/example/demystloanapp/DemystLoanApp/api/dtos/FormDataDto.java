package com.example.demystloanapp.DemystLoanApp.api.dtos;

public class FormDataDto {

    private String businessName;
    private Integer yearEstablished;
    private Integer loanAmount;


    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(Integer yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

}
