package com.example.demystloanapp.repository;


import com.example.demystloanapp.model.BalanceSheetEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceSheetEntryRepository extends JpaRepository<BalanceSheetEntry, Long> {
    List<BalanceSheetEntry> findByYear(int year);

}