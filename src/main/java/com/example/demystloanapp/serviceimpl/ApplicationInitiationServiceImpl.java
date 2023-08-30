package com.example.demystloanapp.serviceimpl;

import com.example.demystloanapp.model.ApplicationInitiationState;
import com.example.demystloanapp.repository.ApplicationInitiationStateRepository;
import com.example.demystloanapp.service.ApplicationInitiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ApplicationInitiationServiceImpl  implements ApplicationInitiationService {

    @Autowired
    private ApplicationInitiationStateRepository initiationStateRepository;


    public void initiateApplication() {
        ApplicationInitiationState initiationState = initiationStateRepository.findById(1L).orElse(null);
        if (initiationState == null) {
            initiationState = new ApplicationInitiationState();
            initiationState.setInitiated(true);
            initiationStateRepository.save(initiationState);
            System.out.println("Application initiated successfully.");
        } else {
            System.out.println("Application has already been initiated.");
        }
    }

}


