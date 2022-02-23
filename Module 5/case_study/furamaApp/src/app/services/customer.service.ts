import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private API_URL = 'http://localhost:3000/customer';
  private API_TYPE_URL = 'http://localhost:3000/customerType';
  constructor(public http: HttpClient) { }
  getAllCustomers(): Observable<any>{
    return this.http.get(this.API_URL);
  }
  getAllCustomerType(): Observable<any>{
    return this.http.get(this.API_TYPE_URL);
  }
  addNewCustomer(customer): Observable<any>{
    return this.http.post(this.API_URL, customer);
  }
  getCustomerById(customerId): Observable<any>{
    return this.http.get(this.API_URL + '/' + customerId);
  }
  deleteCustomer(customerId): Observable<any>{
    return this.http.delete(this.API_URL + '/' + customerId);
  }
  editCustomer(customerId, customer): Observable<any>{
    return this.http.put(this.API_URL + '/' + customerId, customer);
  }
  searchCustomer(search: string): Observable<any>{
    return this.http.get(this.API_URL + '?fullName_like=' + search);
  }
}
