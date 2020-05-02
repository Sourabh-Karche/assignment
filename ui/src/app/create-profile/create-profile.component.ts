import { Component, OnInit } from '@angular/core';
import { Profile } from '../models/profile';
import { ProfileService } from '../services/profile.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-profile',
  templateUrl: './create-profile.component.html',
  styleUrls: ['./create-profile.component.css']
})
export class CreateProfileComponent implements OnInit {
  profile: Profile;
  
  constructor(private profileSrv: ProfileService, private router: Router) { 
    this.profile = new Profile('', 0);
  }

  ngOnInit() {
  }

  onhandleProfile(profile: Profile) {
    this.profile = profile;
    this.profileSrv.saveProfile(this.profile).subscribe(profile => {
      this.profile = profile;
      this.router.navigate(['/profile']);
    });
  }

}
