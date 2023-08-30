package com.example.demystloanapp.serviceimpl;


import com.example.demystloanapp.model.LoanApplication;
import com.example.demystloanapp.repository.LoanApplicationRepository;
import com.example.demystloanapp.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultLoanApplicationServiceImpl implements LoanApplicationService {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplication submitLoanApplication(LoanApplication application) {

        return loanApplicationRepository.save(application);
    }

   
}