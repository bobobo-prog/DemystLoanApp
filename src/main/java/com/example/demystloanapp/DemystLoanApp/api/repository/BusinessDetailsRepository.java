package com.example.demystloanapp.DemystLoanApp.api.repository;


import com.example.demystloanapp.DemystLoanApp.api.model.BusinessDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDetailsRepository extends JpaRepository<BusinessDetails, Long> {
}