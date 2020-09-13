import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EmployeeFormComponent} from './employee-form/employee-form.component';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {AuthGuard} from './auth/auth.guard';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  { path: 'addemployee', component: EmployeeFormComponent, canActivate: [AuthGuard] },
  { path: 'employees', component: EmployeeListComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: '',   redirectTo: '/employees', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule],
  providers: [AuthGuard]
})
export class AppRoutingModule { }
