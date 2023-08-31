package com.example.demystloanapp.service;


import com.example.demystloanapp.model.BalanceSheetEntry;

import java.util.List;


public interface BalanceSheetService {


    public List<BalanceSheetEntry> getBalanceSheetEntriesByYear(int year) ;

    public List<BalanceSheetEntry> getBalanceSheetForProvider(String accountingProvider);


}