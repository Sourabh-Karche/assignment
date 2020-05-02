import { Component, OnInit } from '@angular/core';
import { Profile } from '../models/profile';
import { ProfileService } from '../services/profile.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete-profile',
  templateUrl: './delete-profile.component.html',
  styleUrls: ['./delete-profile.component.css']
})
export class DeleteProfileComponent implements OnInit {
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
    this.profileSrv.deleteProfile().subscribe(res => {
      this.router.navigate(['/profile']);
    });
  }
}
