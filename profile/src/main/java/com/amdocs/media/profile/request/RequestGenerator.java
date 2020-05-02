package com.amdocs.media.profile.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.amdocs.media.base.models.ProfileDTO;
import com.amdocs.media.profile.controllers.ProfileController;

@Component
public class RequestGenerator {
	
	@Autowired
	private ProfileController profileController;
	
	public ResponseEntity<ProfileDTO> generatePutRequest(ProfileDTO profileDTO) {
		return profileController.updateProfile(profileDTO);
	}
	
	public ResponseEntity<ProfileDTO> generateDeleteRequest(ProfileDTO profileDTO) {
		return profileController.deleteProfile(profileDTO.getUserId());
	}
}
