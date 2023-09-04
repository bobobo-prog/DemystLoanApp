package com.example.demystloanapp.DemystLoanApp.api.service;


import com.example.demystloanapp.DemystLoanApp.api.dtos.BalanceSheetEntryDto;
import com.example.demystloanapp.DemystLoanApp.api.dtos.LoanApplicationDto;
import com.example.demystloanapp.DemystLoanApp.api.repository.LoanApplicationRepository;
import com.example.demystloanapp.DemystLoanApp.api.service.DefaultLoanApplicationServiceImpl;
import com.example.demystloanapp.DemystLoanApp.api.model.LoanApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultLoanApplicationServiceImpl  {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;


    public Integer submitLoanApplication(LoanApplicationDto application) {

        Integer preAssessment = calculatePreAssessment(application);

        LoanApplication  app = new LoanApplication();
        app.setBusinessName(application.getFormData().getBusinessName());
        app.setYearEstablished(application.getFormData().getYearEstablished());
        app.setLoanAmount(application.getFormData().getLoanAmount());

        loanApplicationRepository.save(app);
            return preAssessment;
    }


    public int calculatePreAssessment(LoanApplicationDto loanApplication) {

        boolean hasProfit = calculateHasProfit(loanApplication);

        if (hasProfit) {
            return 60;
        } else {
            double averageAssetValue = calculateAverageAssetValue(loanApplication);

            if (averageAssetValue > loanApplication.getFormData().getLoanAmount()) {
                return 100;
            } else {
                return 20;
            }
        }
    }

    private boolean calculateHasProfit(LoanApplicationDto application) {

        boolean res = false;
        Double val = 0.0;

        List<BalanceSheetEntryDto> temp = application.getBalanceSheetEntries();
        val = temp.
                stream()
                .mapToDouble(BalanceSheetEntryDto::getProfitOrLoss)
                .sum();

        if(val>0.0)
        {
            return true;
        }
        else{
            return false;
        }


    }

    private double calculateAverageAssetValue(LoanApplicationDto application) {

        Double averageAssetval = 0.0;
        List<BalanceSheetEntryDto> temp = application.getBalanceSheetEntries();
        averageAssetval = temp.
                stream()
                .mapToDouble(BalanceSheetEntryDto::getAssetsValue)
                .average()
                .orElse(Double.NaN);

        return averageAssetval;

    }


}