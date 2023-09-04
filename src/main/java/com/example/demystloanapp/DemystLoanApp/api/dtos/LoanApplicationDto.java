package com.example.demystloanapp.DemystLoanApp.api.dtos;

import com.example.demystloanapp.DemystLoanApp.api.model.BalanceSheetEntry;

import java.util.List;

public class LoanApplicationDto {

    private FormDataDto formData;
    private List<BalanceSheetEntryDto> balanceSheetEntries;


    public LoanApplicationDto() {
    }

    public LoanApplicationDto(FormDataDto formData, List<BalanceSheetEntryDto> balanceSheetEntries) {
        this.formData = formData;
        this.balanceSheetEntries = balanceSheetEntries;
    }

    public FormDataDto getFormData() {
        return formData;
    }

    public void setFormData(FormDataDto formData) {
        this.formData = formData;
    }

    public List<BalanceSheetEntryDto> getBalanceSheetEntries() {
        return balanceSheetEntries;
    }

    public void setBalanceSheetEntries(List<BalanceSheetEntryDto> balanceSheetEntries) {
        this.balanceSheetEntries = balanceSheetEntries;
    }
}
