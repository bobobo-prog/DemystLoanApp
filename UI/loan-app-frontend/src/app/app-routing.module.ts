import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoanApplicationComponent } from './loan-application/loan-application.component';


const routes: Routes = [  
      {path:'' ,redirectTo:'/loan-application',pathMatch:'full'},
      {path:'loan-application',component:LoanApplicationComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
