import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Profile } from '../models/profile';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  readonly BACKEND_URL: string = environment.backendUrl;
  readonly PROFILE: string = "profile";
  profile: Profile;

  constructor(private http: HttpClient) { }

  getProfile(): Observable<Profile> {
    const userId: string = localStorage.getItem("userId");
    return this.http.get<Profile>(this.BACKEND_URL + "/" + this.PROFILE + "/" + Number(userId));
  }

  public saveProfile(profile: Profile): Observable<Profile> {
    const userId: string = localStorage.getItem("userId");
    profile.userId = Number(userId);
    return this.http.post<Profile>(this.BACKEND_URL + "/" + this.PROFILE, profile);
  }

  public updateProfile(profile: Profile): Observable<Response> {
    const userId: string = localStorage.getItem("userId");
    profile.userId = Number(userId);
    return this.http.put<Response>(this.BACKEND_URL + "/" + this.PROFILE, profile);
  }

  public deleteProfile(): Observable<Response>{
    const userId: string = localStorage.getItem("userId");
    return this.http.delete<Response>(this.BACKEND_URL + "/" + this.PROFILE + "/" + Number(userId));
  }
}
