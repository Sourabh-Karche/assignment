package com.amdocs.media.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.media.profile.dao.ProfileDao;
import com.amdocs.media.profile.models.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;

	@Override
	public Profile getProfile(int userId) {
		// TODO Auto-generated method stub
		return profileDao.findById(userId).orElse(null);
	}

	@Override
	public Profile saveProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profileDao.save(profile);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profileDao.save(profile);
	}

	@Override
	public void deleteProfile(int userId) {
		// TODO Auto-generated method stub
		profileDao.deleteById(userId);
	}

}
