package com.amdocs.media.profile.service;

import com.amdocs.media.profile.models.Profile;

public interface ProfileService {
	public Profile getProfile(int userId);
	public Profile saveProfile(Profile profile);
	public Profile updateProfile(Profile profile);
	public void deleteProfile(int userId);
}
