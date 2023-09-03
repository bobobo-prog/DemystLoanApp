import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { InitiateApiResponse } from 'src/app/shared/models/api-response.model';
import { FormBuilder, FormGroup, Validators  } from '@angular/forms';
@Component({
  selector: 'app-loan-application',
  templateUrl: './loan-application.component.html',
  styleUrls: ['./loan-application.component.css']
})
export class LoanApplicationComponent implements OnInit {
  applicationInitiated = false;
  applicationSubmitted = true;
  successMessage = '';
  private baseUrl = 'http://localhost:8080/api';

  businessDetailsForm: FormGroup = new FormGroup({});
  accountingForm: FormGroup = new FormGroup({});
  
  constructor(private http:HttpClient,private formBuilder: FormBuilder  ) { }
  

  ngOnInit(): void {
    
    this.businessDetailsForm = this.formBuilder.group({
      businessName: ['', Validators.required],
      yearEstablished: ['', Validators.required],
      loanAmount: ['', Validators.required]
    });

    this.accountingForm = this.formBuilder.group({
      selectedProvider: ['', Validators.required]
    });
    
  }

  
  initiateApplication() 
  {
    this.http.post(`${this.baseUrl}/initiate-application`, {}).subscribe(
      (response) => {
        this.applicationInitiated = true;
        this.successMessage = (response as InitiateApiResponse).message;
      },
      (error) => {
        console.error('Error initiating application:', error);
      }
    );

  }

  submitForm() {
    if (this.businessDetailsForm.valid) {
      
      const formData = this.businessDetailsForm.value;
      this.http.post(`${this.baseUrl}/loan-applications/submit`, formData ).subscribe(
        (response) => {
          this.applicationSubmitted = true;
          this.successMessage = (response as InitiateApiResponse).message;
        },
        (error) => {
          console.error('Error submitting loan application:', error);
        }
      );
    }
  }

  requestBalanceSheet() {
    
    if (this.accountingForm.valid) {
                          
      const formData = this.accountingForm.value;
      console.log(formData);
      this.http.post(`${this.baseUrl}/get-balance-sheet`,formData).subscribe(
        (response) => {
          
          console.log('Balance sheet received:', response);
        },
        (error) => {
          
          console.error('Error requesting balance sheet:', error);
        }
      );
    }
  }


}
