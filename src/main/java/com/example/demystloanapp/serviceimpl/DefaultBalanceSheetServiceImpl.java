package com.example.demystloanapp.serviceimpl;


import com.example.demystloanapp.model.BalanceSheetEntry;
import com.example.demystloanapp.repository.BalanceSheetEntryRepository;
import com.example.demystloanapp.service.BalanceSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultBalanceSheetServiceImpl implements BalanceSheetService {
    @Autowired
    private BalanceSheetEntryRepository balanceSheetEntryRepository;

    @Override
    public List<BalanceSheetEntry> getBalanceSheetEntriesByYear(int year) {
        List<BalanceSheetEntry> res = new ArrayList<>();
    try{

        res = balanceSheetEntryRepository.findByYear(year);


    }
    catch(Exception e )
    {
       // logger.error("gg");
    }
        return res;

    }


}