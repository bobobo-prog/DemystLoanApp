package com.example.demystloanapp.DemystLoanApp.api.service;


import com.example.demystloanapp.DemystLoanApp.api.model.BusinessDetails;
import com.example.demystloanapp.DemystLoanApp.api.repository.BusinessDetailsRepository;
import com.example.demystloanapp.DemystLoanApp.api.service.DefaultBusinessDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBusinessDetailsService  {

    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;


    public void saveBusinessDetails(BusinessDetails details) {
        businessDetailsRepository.save(details);
    }
}