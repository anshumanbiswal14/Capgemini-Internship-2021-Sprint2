import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmiService {

  private baseURL = 'http://localhost:9090/customer/EMIcalculator/';

  constructor(private http: HttpClient) { }


  calculateEmi(emi:number,interestRate: number,time: number): Observable<any> {

    return this.http.get(`http://localhost:9090/customer/EMIcalculator/${emi}/${interestRate}/${time}`);
  }
}

