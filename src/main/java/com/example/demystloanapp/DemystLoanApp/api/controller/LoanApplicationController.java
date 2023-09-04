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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/loan-applications/submit")
    public ResponseEntity<ApiResponse> submitLoanApplication(@RequestBody String json) throws JsonProcessingException {

        Integer preAssessment = 0;
        ApiResponse response = new ApiResponse("");

        try{
            logger.info("Inside submitLoanApplication() Time {}", LocalDate.now());
            LoanApplicationDto application = objectMapper.readValue(json, new TypeReference<LoanApplicationDto>() {});

             preAssessment = loanApplicationService.submitLoanApplication(application);
             response.setMessage("Loan Application submitted successfully , Loan favoured to be approved " + String.valueOf(preAssessment) + "% of the requested amount");
        }
        catch (Exception e)
        {
            logger.error("Exception occured in submitLoanApplication() -- Exception: {}",e);
            response.setMessage("Sorry we're in a pickle , our devs are working on unpickling this! ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }

        logger.info(" submitLoanApplication() completed!  Time {}", LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/initiate-application")
    public ResponseEntity<ApiResponse> initiateApplication() {
        logger.info("Inside initiateApplication() Time {}", LocalDate.now());
        ApiResponse response = new ApiResponse("Application initiated successfully");
        try{
            initiationService.initiateApplication();
        }catch (Exception e)
        {
            logger.error("Exception occured in initiateApplication() -- Exception: {}",e);
            response.setMessage("Sorry we're in a pickle , our devs are working on unpickling this! ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        logger.info(" initiateApplication() completed! Time {}", LocalDate.now());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping ("/get-balance-sheet/submit")
    public ResponseEntity<List<BalanceSheetEntry>> getBalanceSheet(@RequestParam String accountingProvider) {
        logger.info("Inside getBalanceSheet() Time {}", LocalDate.now());
        ApiResponse response = new ApiResponse("");
        List<BalanceSheetEntry> balanceSheet = new ArrayList<>();
        try{
            balanceSheet = balanceSheetService.getBalanceSheetForProvider(accountingProvider);

        }
        catch (Exception e)
        {

            response.setMessage("Sorry we're in a pickle , our devs are working on unpickling this! ");
            logger.error("Exception occured in getBalanceSheet() -- Exception: {}",e);


        }
        logger.info(" getBalanceSheet() completed! Time {}", LocalDate.now());
        return ResponseEntity.ok(balanceSheet);

    }


}