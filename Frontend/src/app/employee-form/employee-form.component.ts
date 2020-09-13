import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeeService} from '../service/employee.service';
import {Employee} from '../models/employee.model';

interface DropDownListType {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css', '../app.component.css']
})

export class EmployeeFormComponent implements OnInit {

  employee: Employee;
  hireTypes: DropDownListType[];
  functionRoles: DropDownListType[];
  workingRoles: DropDownListType[];
  warningMessage: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService) {
    this.employee = new Employee();
    this.warningMessage = null;
    this.hireTypes = [
      {value: 'HIRED', viewValue: 'Ansatt'},
      {value: 'PROBATION', viewValue: 'Prøvetid'},
      {value: 'INVALID', viewValue: 'Ukjent'}
    ];
    this.workingRoles = [
      {value: 'PROJECT_LEADER', viewValue: 'Prosjektleder'},
      {value: 'PROGRAMMER', viewValue: 'Programmerer'},
      {value: 'EMPLOYEE', viewValue: 'Ansatt'}
    ];
  }

  ngOnInit() {
  }

  onSubmit() {
    this.employeeService.save(this.employee).subscribe(
      result => this.goToEmployeeList(),
      (error: any) => {
        if (error.status === 401) {
          this.warningMessage = "Mangler rettigheter";
        }
        if (error.status === 403) {
          this.warningMessage = "Ikke innlogget";
        } else {
           this.warningMessage = "Noe gikk feil";
         }
      }
      );
  }

  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }
}
