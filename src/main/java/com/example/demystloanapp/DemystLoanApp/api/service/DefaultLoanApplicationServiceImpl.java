package com.example.demystloanapp.DemystLoanApp.api.service;


import com.example.demystloanapp.DemystLoanApp.api.repository.LoanApplicationRepository;
import com.example.demystloanapp.DemystLoanApp.api.service.DefaultLoanApplicationServiceImpl;
import com.example.demystloanapp.DemystLoanApp.api.model.LoanApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultLoanApplicationServiceImpl  {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;


    public LoanApplication submitLoanApplication(LoanApplication application) {

        return loanApplicationRepository.save(application);
    }


}