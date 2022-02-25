import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private API_EMP = 'http://localhost:3000/employee';
  private API_POS = 'http://localhost:3000/position';
  private API_EDU = 'http://localhost:3000/educationDegree';
  private API_DIV = 'http://localhost:3000/division';
  constructor(public http: HttpClient) { }
  getAllEmployee(): Observable<any>{
    return this.http.get(this.API_EMP);
  }
  getAllPosition(): Observable<any>{
    return this.http.get(this.API_POS);
  }
  getAllEducation(): Observable<any>{
    return this.http.get(this.API_EDU);
  }
  getAllDivision(): Observable<any>{
    return this.http.get(this.API_DIV);
  }
  addEmployee(employee): Observable<any>{
    return this.http.post(this.API_EMP, employee);
  }
  getEmployeeById(employeeId): Observable<any>{
    return this.http.get(this.API_EMP + '/' + employeeId);
  }
  editEmployee(employeeId, employee): Observable<any>{
    return this.http.put(this.API_EMP + '/' + employeeId, employee);
  }
  deleteEmployee(employeeId): Observable<any>{
    return this.http.delete(this.API_EMP + '/' + employeeId);
  }
  searchEmployee(nameSearch, emailSearch): Observable<any>{
    return this.http.get(this.API_EMP + '?fullName_like=' + nameSearch + '&email_like=' + emailSearch);
  }
}
