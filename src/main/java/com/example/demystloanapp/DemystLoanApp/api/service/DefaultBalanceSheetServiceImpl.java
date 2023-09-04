package com.example.demystloanapp.DemystLoanApp.api.service;


import com.example.demystloanapp.DemystLoanApp.api.model.BalanceSheetEntry;
import com.example.demystloanapp.DemystLoanApp.api.repository.BalanceSheetEntryRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultBalanceSheetServiceImpl  {

    @Autowired
    private BalanceSheetEntryRepository balanceSheetEntryRepository;


    public List<BalanceSheetEntry>  getBalanceSheetForProvider(String accountingProvider) {

        return createSampleBalanceSheet(accountingProvider);
    }

    private  List<BalanceSheetEntry> createSampleBalanceSheet(String accountingProvider) {
        List<BalanceSheetEntry> balanceSheet = new ArrayList<>();
        Map<String, List<BalanceSheetEntry>> response = new HashMap<>();
        if (accountingProvider != null) {

            ObjectMapper objectMapper = new ObjectMapper();
            String json = " [\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 12,\n" +
                    "        \"profitOrLoss\": 250000,\n" +
                    "        \"assetsValue\": 1234\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 11,\n" +
                    "        \"profitOrLoss\": 1150,\n" +
                    "        \"assetsValue\": 5789\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 10,\n" +
                    "        \"profitOrLoss\": 2500,\n" +
                    "        \"assetsValue\": 22345\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 9,\n" +
                    "        \"profitOrLoss\": -187000,\n" +
                    "        \"assetsValue\": 223452\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 8,\n" +
                    "        \"profitOrLoss\": -18000,\n" +
                    "        \"assetsValue\": 2352\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 7,\n" +
                    "        \"profitOrLoss\": 7000,\n" +
                    "        \"assetsValue\": 223452\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 6,\n" +
                    "        \"profitOrLoss\": -1000,\n" +
                    "        \"assetsValue\": 22345\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 5,\n" +
                    "        \"profitOrLoss\": 90000,\n" +
                    "        \"assetsValue\": 22352\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 4,\n" +
                    "        \"profitOrLoss\": -97000,\n" +
                    "        \"assetsValue\": 223452\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 3,\n" +
                    "        \"profitOrLoss\": -187000,\n" +
                    "        \"assetsValue\": 223452\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 2,\n" +
                    "        \"profitOrLoss\": 66000,\n" +
                    "        \"assetsValue\": 22352\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"year\": 2020,\n" +
                    "        \"month\": 1,\n" +
                    "        \"profitOrLoss\": 997000,\n" +
                    "        \"assetsValue\": 2452\n" +
                    "    }\n" +
                    "]";

            try {

                 balanceSheet = objectMapper.readValue(json, new TypeReference<List<BalanceSheetEntry>>() {});


            } catch (Exception  e) {
               System.out.println("gg");
            }

        }


        return balanceSheet;
    }
}