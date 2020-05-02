import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Profile } from '../models/profile';

@Component({
  selector: 'app-profile-form',
  templateUrl: './profile-form.component.html',
  styleUrls: ['./profile-form.component.css']
})
export class ProfileFormComponent implements OnInit {
  @Input() profile: Profile;
  @Output() profileEmitter: EventEmitter<Profile> = new EventEmitter<Profile>();
  profileForm: FormGroup;
  loading: boolean = false;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.profileForm = this.formBuilder.group({
      address: [this.profile.address],
      phone: [this.profile.phone]
    });
  }

  get f() { return this.profileForm.controls; }

  onSubmit() {
    const profile = new Profile(this.f.address.value, this.f.phone.value);
    this.loading = true;
    setTimeout(() => {
      this.profileEmitter.emit(profile);
    }, 4000);
  }

}
