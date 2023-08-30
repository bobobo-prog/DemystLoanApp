package com.example.demystloanapp.controller;

import com.example.demystloanapp.model.BalanceSheetEntry;
import com.example.demystloanapp.model.LoanApplication;

import com.example.demystloanapp.service.ApplicationInitiationService;
import com.example.demystloanapp.service.BalanceSheetService;
import com.example.demystloanapp.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-applications")
public class LoanApplicationController {

    @Autowired
    private  LoanApplicationService loanApplicationService;

    @Autowired
    private BalanceSheetService balanceSheetService;

    @Autowired
    private  ApplicationInitiationService initiationService;


    @PostMapping
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


}