package com.example.demystloanapp.DemystLoanApp.api.controller;

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

import java.util.List;

@RestController
@RequestMapping("/api")
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
    public ResponseEntity<LoanApplication> submitLoanApplication(@RequestBody LoanApplication application) {
        LoanApplication submittedApplication = loanApplicationService.submitLoanApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(submittedApplication);
    }

    @GetMapping("/balance-sheet-entries/{year}")
    public List<BalanceSheetEntry> getBalanceSheetEntriesByYear(@PathVariable int year) {
        return balanceSheetService.getBalanceSheetEntriesByYear(year);
    }

    @PostMapping("/initiate-application")
    public ResponseEntity<String> initiateApplication() {
        initiationService.initiateApplication();
        return ResponseEntity.status(HttpStatus.OK).body("Application initiated successfully.");
    }

    @PostMapping("/save-business-details")
    public ResponseEntity<String> fillBusinessDetails(@RequestBody BusinessDetails details) {
        businessDetailsService.saveBusinessDetails(details);
        return ResponseEntity.status(HttpStatus.CREATED).body("Business details saved successfully.");
    }

    @GetMapping("/get-balance-sheet")
    public ResponseEntity<List<BalanceSheetEntry>> getBalanceSheet(@RequestParam String accountingProvider) {
        List<BalanceSheetEntry> balanceSheet = balanceSheetService.getBalanceSheetForProvider(accountingProvider);
        return ResponseEntity.status(HttpStatus.OK).body(balanceSheet);
    }


}