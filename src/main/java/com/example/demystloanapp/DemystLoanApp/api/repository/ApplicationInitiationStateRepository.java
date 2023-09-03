package com.example.demystloanapp.DemystLoanApp.api.repository;


import com.example.demystloanapp.DemystLoanApp.api.model.ApplicationInitiationState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationInitiationStateRepository extends JpaRepository<ApplicationInitiationState, Long> {
}