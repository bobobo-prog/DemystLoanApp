package com.example.demystloanapp.DemystLoanApp.api.model;

import jakarta.persistence.*;

@Table(name = "business_details")
@Entity
public class BusinessDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "year_established")
    private Integer yearEstablished;

    public BusinessDetails() {
    }

    public BusinessDetails(Long id, String businessName, int yearEstablished) {
        this.id = id;
        this.businessName = businessName;
        this.yearEstablished = yearEstablished;
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
}