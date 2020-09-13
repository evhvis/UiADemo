import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth/auth.service';
import {Login} from '../models/login.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css', '../app.component.css']
})
export class LoginComponent implements OnInit {

  loginModel: Login;
  loginFailed: String;

  constructor(private loginService: AuthService,
              private router: Router) {
    this.loginModel = new Login();
    this.loginFailed = null;
  }

  ngOnInit(): void {
  }

  public onAuthenticate(): void {
    var self = this;
    this.loginService.callLogin(this.loginModel).subscribe(data => {
      if (data.token) {
        this.loginService.setToken(data);
        this.router.navigate(['/employees']).then(r => false);
      }
    },
    (error: any) => {
      if(error.status === 401) {
        self.loginFailed = "Innlogging feilet";
      }
    }
  );
  }

}
