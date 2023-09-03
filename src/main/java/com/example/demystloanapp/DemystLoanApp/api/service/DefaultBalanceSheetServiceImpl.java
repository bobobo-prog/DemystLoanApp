package com.example.demystloanapp.DemystLoanApp.api.service;


import com.example.demystloanapp.DemystLoanApp.api.model.BalanceSheetEntry;
import com.example.demystloanapp.DemystLoanApp.api.repository.BalanceSheetEntryRepository;
import com.example.demystloanapp.DemystLoanApp.api.service.DefaultBalanceSheetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultBalanceSheetServiceImpl  {

    @Autowired
    private BalanceSheetEntryRepository balanceSheetEntryRepository;


    public List<BalanceSheetEntry> getBalanceSheetForProvider(String accountingProvider) {

        return createSampleBalanceSheet(accountingProvider);
    }

    private List<BalanceSheetEntry> createSampleBalanceSheet(String accountingProvider) {
        List<BalanceSheetEntry> res = new ArrayList<>();
        if(accountingProvider!=null) {

            res.add(new BalanceSheetEntry(2020, 12, 250000, 1234));
            res.add(new BalanceSheetEntry(2020, 11, 1150, 5789));
            res.add(new BalanceSheetEntry(2020, 10, 2500, 22345));
            res.add(new BalanceSheetEntry(2020, 9, -187000, 223452));
        }

        return res;
    }


}