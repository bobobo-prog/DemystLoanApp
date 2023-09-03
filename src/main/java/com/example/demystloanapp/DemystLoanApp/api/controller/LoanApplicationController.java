package com.example.demystloanapp.DemystLoanApp.api.controller;

import com.example.demystloanapp.DemystLoanApp.api.dtos.AccountingProviderDto;
import com.example.demystloanapp.DemystLoanApp.api.dtos.ApiResponse;
import com.example.demystloanapp.DemystLoanApp.api.dtos.LoanApplicationDto;
import com.example.demystloanapp.DemystLoanApp.api.model.BusinessDetails;
import com.example.demystloanapp.DemystLoanApp.api.model.LoanApplication;
import com.example.demystloanapp.DemystLoanApp.api.service.*;
import com.example.demystloanapp.DemystLoanApp.api.model.BalanceSheetEntry;
import com.example.demystloanapp.DemystLoanApp.api.service.DefaultBalanceSheetServiceImpl;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoanApplicationController {

    @Autowired
    private  DefaultLoanApplicationServiceImpl loanApplicationService;

    @Autowired
    private DefaultBalanceSheetServiceImpl balanceSheetService;

    @Autowired
    private ApplicationInitiationServiceImpl initiationService;

    @Autowired
    private DefaultBusinessDetailsService businessDetailsService;


    @PostMapping("/loan-applications/submit")
    public ResponseEntity<ApiResponse> submitLoanApplication(@RequestBody LoanApplicationDto application) {
            LoanApplication submittedApplication = loanApplicationService.submitLoanApplication(application);
        ApiResponse response = new ApiResponse("Loan Application submitted successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/initiate-application")
    public ResponseEntity<ApiResponse> initiateApplication() {
        initiationService.initiateApplication();
        ApiResponse response = new ApiResponse("Application initiated successfully");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/get-balance-sheet/submit")
    public ResponseEntity<List<BalanceSheetEntry>> getBalanceSheet(@RequestBody AccountingProviderDto accountingProvider) {
        List<BalanceSheetEntry> balanceSheet = balanceSheetService.getBalanceSheetForProvider(accountingProvider.getAccountingProvider());
        return ResponseEntity.status(HttpStatus.OK).body(balanceSheet);
    }


}