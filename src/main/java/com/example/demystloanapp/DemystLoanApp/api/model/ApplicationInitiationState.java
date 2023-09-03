package com.example.demystloanapp.DemystLoanApp.api.model;

import jakarta.persistence.*;

@Table(name = "app_init_state")
@Entity
public class ApplicationInitiationState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "initiated")
    private Boolean initiated;

    public ApplicationInitiationState() {
    }

    public ApplicationInitiationState(Long id, boolean initiated) {
        this.id = id;
        this.initiated = initiated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isInitiated() {
        return initiated;
    }

    public void setInitiated(boolean initiated) {
        this.initiated = initiated;
    }
}
