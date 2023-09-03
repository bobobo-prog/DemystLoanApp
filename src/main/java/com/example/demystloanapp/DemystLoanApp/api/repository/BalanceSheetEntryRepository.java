package com.example.demystloanapp.DemystLoanApp.api.repository;


import com.example.demystloanapp.DemystLoanApp.api.model.BalanceSheetEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  BalanceSheetEntryRepository extends JpaRepository<BalanceSheetEntry, Long> {

}