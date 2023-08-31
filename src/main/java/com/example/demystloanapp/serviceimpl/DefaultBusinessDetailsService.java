package com.example.demystloanapp.serviceimpl;


import com.example.demystloanapp.model.BusinessDetails;
import com.example.demystloanapp.repository.BusinessDetailsRepository;
import com.example.demystloanapp.service.BusinessDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBusinessDetailsService implements BusinessDetailsService {

    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;

    @Override
    public void saveBusinessDetails(BusinessDetails details) {
        businessDetailsRepository.save(details);
    }
}