import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Login} from '../models/login.model';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loginUrl: string;

  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:8080/rest/login';
  }

  public login(userName: string, password: string): Observable<Login> {
    const login = new Login();
    login.username = userName;
    login.password = password;
    return this.callLogin(login);
  }

  public callLogin(val: Login): Observable<Login> {
    return this.http.post<Login>(this.loginUrl, val);
  }

  get authToken(): string {
    return sessionStorage.getItem('token');
  }

  get authRole(): string {
    return sessionStorage.getItem('role');
  }

  get isAuthenticated(): boolean {
    const token = sessionStorage.getItem('token');

    if (token !== null && token !== undefined && token.length > 1) {
      return true;
    }

    return false;
  }

  setToken(data: Login) {    
    sessionStorage.setItem('token', data.token);
    sessionStorage.setItem('role', data.role);
  }

  logOut() {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('role');
  }

  get isAuthenticatedAdmin(): boolean {
    const token = sessionStorage.getItem('token');
    const role = this.authRole;
    if (token !== null && token !== undefined && token.length > 1 && role !== 'ADMIN') {
      return true;
    }

    return false;
  }
}
