import { Component } from '@angular/core';
import {Router} from '@angular/router';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;

  constructor( private router: Router, private authService: AuthService) {
    this.title = 'UiA Demo Prosjekt';
  }

  clearLocalStorage(): void {
    this.authService.logOut();
    this.router.navigate(['/login']);
  }
}
