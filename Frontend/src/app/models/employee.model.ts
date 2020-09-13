export class Employee {
  firstName: string;
  lastName: string;
  company: string;
  hireType: string;
  birthday: string;
  workingRole: string;
}

export class EmployeeModel {
  valid: number;
  warnings: number;
  invalid: number;
  total: number;
  employees: Employee[];
}
