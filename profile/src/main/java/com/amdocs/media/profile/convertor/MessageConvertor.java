package com.amdocs.media.profile.convertor;

import org.springframework.stereotype.Component;

import com.amdocs.media.base.models.ProfileDTO;
import com.amdocs.media.profile.models.Profile;

@Component
public class MessageConvertor {

	public Profile convertMessage(ProfileDTO profileDTO) {
		Profile profile = null;
		
		if (profileDTO != null) {
			profile = new Profile();
			profile.setAddress(profileDTO.getAddress());
			profile.setPhone(profileDTO.getPhone());
			profile.setUserId(profileDTO.getUserId());
		}

		return profile;
	}
	
	public ProfileDTO getProfileDTO(Profile profile) {
		ProfileDTO profileDTO = null;
		
		if (profile != null) {
			profileDTO = new ProfileDTO();
			profileDTO.setAddress(profile.getAddress());
			profileDTO.setPhone(profile.getPhone());
			profileDTO.setUserId(profile.getUserId());
		}

		return profileDTO;
	}
}
