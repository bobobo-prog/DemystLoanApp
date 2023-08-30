package com.example.demystloanapp.repository;


import com.example.demystloanapp.model.ApplicationInitiationState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationInitiationStateRepository extends JpaRepository<ApplicationInitiationState, Long> {
}