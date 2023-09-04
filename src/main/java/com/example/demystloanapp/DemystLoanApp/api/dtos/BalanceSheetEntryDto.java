package com.example.demystloanapp.DemystLoanApp.api.dtos;

public class  BalanceSheetEntryDto {

    private Integer id;
    private Integer year;
    private Integer month;
    private Double profitOrLoss;
    private Double assetsValue;

    public BalanceSheetEntryDto() {
    }

    public BalanceSheetEntryDto(Double assetsValue, Integer id, Integer month, Double profitOrLoss, Integer year) {
        this.assetsValue = assetsValue;
        this.id = id;
        this.month = month;
        this.profitOrLoss = profitOrLoss;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(Double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }

    public Double getAssetsValue() {
        return assetsValue;
    }

    public void setAssetsValue(Double assetsValue) {
        this.assetsValue = assetsValue;
    }
}