package com.example.demystloanapp.DemystLoanApp.api.model;

import jakarta.persistence.*;


@Table(name = "bal_sheet_entry")
@Entity
public class BalanceSheetEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "year_of")
    private Integer year_of;

    @Column(name = "month_of")
    private Integer month_of;

    @Column(name = "profitOrLoss")
    private Double profitOrLoss;

    @Column(name = "assetsValue")
    private Double assetsValue;

    public BalanceSheetEntry() {
    }

    public BalanceSheetEntry(Long id, int year, int month, double profitOrLoss, double assetsValue) {
        this.id = id;
        this.year_of = year;
        this.month_of = month;
        this.profitOrLoss = profitOrLoss;
        this.assetsValue = assetsValue;
    }

    public BalanceSheetEntry(int i, int i1, int i2, int i3) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year_of;
    }

    public void setYear(int year) {
        this.year_of = year;
    }

    public int getMonth() {
        return month_of;
    }

    public void setMonth(int month) {
        this.month_of = month;
    }

    public double getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }

    public double getAssetsValue() {
        return assetsValue;
    }

    public void setAssetsValue(double assetsValue) {
        this.assetsValue = assetsValue;
    }
}