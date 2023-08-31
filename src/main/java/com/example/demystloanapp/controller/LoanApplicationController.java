package com.example.demystloanapp.controller;

import com.example.demystloanapp.model.BalanceSheetEntry;
import com.example.demystloanapp.model.BusinessDetails;
import com.example.demystloanapp.model.LoanApplication;

import com.example.demystloanapp.service.ApplicationInitiationService;
import com.example.demystloanapp.service.BalanceSheetService;
import com.example.demystloanapp.service.BusinessDetailsService;
import com.example.demystloanapp.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanApplicationController {

    @Autowired
    private  LoanApplicationService loanApplicationService;

    @Autowired
    private BalanceSheetService balanceSheetService;

    @Autowired
    private  ApplicationInitiationService initiationService;

    @Autowired
    private BusinessDetailsService businessDetailsService;


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