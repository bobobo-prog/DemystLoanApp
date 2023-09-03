package com.example.demystloanapp.DemystLoanApp.api.dtos;

public class AccountingProviderDto {

    private String selectedProvider;

    public AccountingProviderDto() {
    }

    public AccountingProviderDto(String selectedProvider) {
        this.selectedProvider = selectedProvider;
    }

    public String getAccountingProvider() {
        return selectedProvider;
    }

    public void setAccountingProvider(String selectedProvider) {
        this.selectedProvider = selectedProvider;
    }
}
