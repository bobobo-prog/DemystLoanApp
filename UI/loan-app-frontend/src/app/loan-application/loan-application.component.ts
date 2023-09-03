import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-loan-application',
  templateUrl: './loan-application.component.html',
  styleUrls: ['./loan-application.component.css']
})
export class LoanApplicationComponent implements OnInit {
  applicationInitiated = false;
  successMessage = '';
  private baseUrl = environment.apiUrl; 

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }


  initiateApplication() 
  {
    this.http.post('/api/initiate-application', {}).subscribe(
      () => {
        this.applicationInitiated = true;
        this.successMessage = 'Application initiated successfully.';
      },
      (error) => {
        console.error('Error initiating application:', error);
      }
    );

  }


}
