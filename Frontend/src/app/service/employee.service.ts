import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Employee, EmployeeModel} from '../models/employee.model';
import {HttpClientWrapper} from '../http-client/http-client-wrapper';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private employeeUrl: string;

  constructor(private http: HttpClientWrapper) {
    this.employeeUrl = 'http://localhost:8080/rest/employees';
  }

  public findAll(): Observable<EmployeeModel> {
    return this.http.get<EmployeeModel>(this.employeeUrl);
  }

  public save(employee: Employee) {
    return this.http.post<Employee>(this.employeeUrl, employee);
  }
}
