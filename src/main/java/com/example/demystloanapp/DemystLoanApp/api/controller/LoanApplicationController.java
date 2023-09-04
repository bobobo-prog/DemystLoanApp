package com.example.demystloanapp.DemystLoanApp.api.controller;

import com.example.demystloanapp.DemystLoanApp.api.dtos.AccountingProviderDto;
import com.example.demystloanapp.DemystLoanApp.api.dtos.ApiResponse;
import com.example.demystloanapp.DemystLoanApp.api.dtos.LoanApplicationDto;
import com.example.demystloanapp.DemystLoanApp.api.model.BusinessDetails;
import com.example.demystloanapp.DemystLoanApp.api.model.LoanApplication;
import com.example.demystloanapp.DemystLoanApp.api.service.*;
import com.example.demystloanapp.DemystLoanApp.api.model.BalanceSheetEntry;
import com.example.demystloanapp.DemystLoanApp.api.service.DefaultBalanceSheetServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/loan-applications/submit")
    public ResponseEntity<ApiResponse> submitLoanApplication(@RequestBody String json) throws JsonProcessingException {

        Integer preAssessment = 0;
        try{
            LoanApplicationDto application = objectMapper.readValue(json, new TypeReference<LoanApplicationDto>() {});

             preAssessment = loanApplicationService.submitLoanApplication(application);
        }
        catch (Exception e)
        {
            System.out.println("ff");
        }
        ApiResponse response = new ApiResponse("Loan Application submitted successfully , Loan favoured to be approved " + String.valueOf(preAssessment) + "% of the requested amount");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/initiate-application")
    public ResponseEntity<ApiResponse> initiateApplication() {
        initiationService.initiateApplication();
        ApiResponse response = new ApiResponse("Application initiated successfully");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping ("/get-balance-sheet/submit")
    public ResponseEntity<List<BalanceSheetEntry>> getBalanceSheet(@RequestParam String accountingProvider) {

        List<BalanceSheetEntry> balanceSheet = new ArrayList<>();
        try{
            balanceSheet = balanceSheetService.getBalanceSheetForProvider(accountingProvider);

        }
        catch (Exception e)
        {
            System.out.println("ggg");

        }
        return ResponseEntity.ok(balanceSheet);

    }


}