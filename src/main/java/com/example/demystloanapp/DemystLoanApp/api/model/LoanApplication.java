package com.example.demystloanapp.DemystLoanApp.api.model;

import jakarta.persistence.*;


@Table(name = "loan_application")
@Entity
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "year_established")
    private Integer yearEstablished;

    @Column(name = "loan_amount")
    private Integer loanAmount;

    public LoanApplication() {
    }

    public LoanApplication(Long id, String businessName, int yearEstablished, int loanAmount) {
        this.id = id;
        this.businessName = businessName;
        this.yearEstablished = yearEstablished;
        this.loanAmount = loanAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }
}