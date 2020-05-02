import { Component, OnInit } from '@angular/core';
import { Profile } from '../models/profile';
import { ProfileService } from '../services/profile.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  profile: Profile;

  constructor(private profileSrv: ProfileService, private router: Router) {
    this.profile = this.profileSrv.profile;
    if (!this.profile)
      this.profile = new Profile('', 0);
  }

  ngOnInit() {
  }

  onhandleProfile(profile: Profile) {
    this.profile = profile;
    this.profileSrv.updateProfile(this.profile).subscribe(res => {
      this.router.navigate(['/profile']);
    });
  }

}
