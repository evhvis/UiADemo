import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';
import { EmployeeModel } from '../models/employee.model';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css', '../app.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: EmployeeModel;
  warningMessage: string;

  constructor(private employeeService: EmployeeService,
    private router: Router) {
    this.warningMessage = null;
  }

  ngOnInit() {
    this.employeeService.findAll().pipe().subscribe(
      data => {
        this.employees = data;
      },
      (error: any) => {
        if (error.status === 401) {
          this.warningMessage = "Mangler rettigheter";
        } 
        else if (error.status === 403) {
          this.warningMessage = "Ikke innlogget";
        } else {
          this.warningMessage = "Noe gikk feil";
        }
      });
  }
}
