import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { InitiateApiResponse } from 'src/app/shared/models/api-response.model';
import { FormBuilder, FormGroup, Validators  } from '@angular/forms';
import { BalanceSheetApiResponse } from '../shared/models/api-balance-sheet-response.model';
@Component({
  selector: 'app-loan-application',
  templateUrl: './loan-application.component.html',
  styleUrls: ['./loan-application.component.css']
})
export class LoanApplicationComponent implements OnInit {
  applicationInitiated = false;
  applicationSubmitted = true;
  balanceSheetFlag = false;
  successMessage = '';
  private baseUrl = 'http://localhost:8080/api';
  balanceSheetEntries: BalanceSheetApiResponse[]= [];
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

      const requestBody = {
        formData,
        balanceSheetEntries: this.balanceSheetEntries
      };    

      console.log(requestBody); 

      this.http.post(`${this.baseUrl}/loan-applications/submit`, JSON.stringify(requestBody)).subscribe(
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

  requestBalanceSheet(event: Event) {
    event.preventDefault();
    if (this.accountingForm.valid) {
                          
      const selectedProvider = this.accountingForm.get('selectedProvider')?.value;        
      this.http.post<HttpResponse<BalanceSheetApiResponse[]>>(`${this.baseUrl}/get-balance-sheet/submit?accountingProvider=${selectedProvider}`,{}).subscribe(
        (response) => {
         
            if( response && Array.isArray(response))
            {
              this.balanceSheetEntries = response;  
              this.balanceSheetFlag = true;
            }
            else {
              console.error('Invalid response format:', response);
            }
            
        
          console.log('Balance sheet received:', this.balanceSheetEntries);
        },
        (error) => {
          
          console.error('Error requesting balance sheet:', error);
        }
      );
    }
  }


}
