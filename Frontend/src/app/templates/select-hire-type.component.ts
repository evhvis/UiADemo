import {Component} from '@angular/core';

interface HireType {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-select-hire-type',
  templateUrl: 'select-hire-type.component.html',
  styleUrls: ['select-hire-type.css'],
})
export class SelectHireTypeComponent {
  hireTypes: HireType[] = [
    {value: 'PERMANENT', viewValue: 'Fast'},
    {value: 'TEMPORARY', viewValue: 'Midlertidig'}
  ];
}
