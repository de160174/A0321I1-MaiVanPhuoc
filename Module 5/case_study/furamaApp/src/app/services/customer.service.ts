import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private API_URL = 'http://localhost:3000/customer';
  constructor(public http: HttpClient) { }
  getAllCustomers(): Observable<any>{
    return this.http.get(this.API_URL);
  }
  addNewCustomer(customer): Observable<any>{
    return this.http.post(this.API_URL, customer);
  }
}
