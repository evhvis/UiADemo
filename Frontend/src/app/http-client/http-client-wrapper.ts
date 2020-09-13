import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AuthService} from '../auth/auth.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpClientWrapper {

  constructor(private http: HttpClient,
              private authService: AuthService) {
  }

  createAuthorizationHeader(): HttpHeaders {
    let headersItem = new HttpHeaders();
    headersItem = headersItem.set('token', "Bearer " + this.authService.authToken);
    return headersItem;
  }

  get<T>(url): Observable<T> {
    const headersItem = this.createAuthorizationHeader();
    return this.http.get<T>(url, {
      headers: headersItem
    });
  }

  post<T>(url, data): Observable<T> {
    const headersItem = this.createAuthorizationHeader();
    return this.http.post<T>(url, data, {
      headers: headersItem
    });
  }
}
