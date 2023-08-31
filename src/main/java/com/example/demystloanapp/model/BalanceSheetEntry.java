package com.example.demystloanapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BalanceSheetEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    private int month;
    private double profitOrLoss;
    private double assetsValue;

    public BalanceSheetEntry(int i, int i1, int i2, int i3) {
    }

    public BalanceSheetEntry(Long id, int year, int month, double profitOrLoss, double assetsValue) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.profitOrLoss = profitOrLoss;
        this.assetsValue = assetsValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
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