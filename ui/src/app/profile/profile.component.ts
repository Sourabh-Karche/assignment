import { Component, OnInit } from '@angular/core';
import { Profile } from '../models/profile';
import { ProfileService } from '../services/profile.service';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profile: Profile = new Profile('', 0);
  username: string;

  constructor(private profileSrv: ProfileService, private loginSrv: LoginService, private router: Router) {
    this.username = localStorage.getItem("username");
    this.profileSrv.getProfile().subscribe(profile => {
      if (profile != null)
        this.profile = profile;

      this.profileSrv.profile = this.profile;
    })
  }

  ngOnInit() {
  }

  onCreate() {
    this.router.navigate(['/new-profile']);
  }


  onEdit() {
    this.router.navigate(['/edit-profile']);
  }


  onDelete() {
    this.router.navigate(['/delete-profile']);
  }

  onLogout() {
    this.loginSrv.logout();
    this.router.navigate(['/login']);
  }

}
