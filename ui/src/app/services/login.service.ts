import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  readonly BACKEND_URL: string = environment.backendUrl;

  constructor(private http: HttpClient) { }

  public login(username: string, password: string): Observable<User> {
    const user: User = new User(username, password);
    return this.http.post<User>(this.BACKEND_URL + '/login', user);
  }

  public logout() {
    localStorage.clear();
  }
}
