package com.amdocs.media.profile.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.media.base.models.ProfileDTO;
import com.amdocs.media.profile.convertor.MessageConvertor;
import com.amdocs.media.profile.models.Profile;
import com.amdocs.media.profile.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	@Autowired
	private MessageConvertor messageConvertor;

	@GetMapping("/{userId}")
	public ResponseEntity<ProfileDTO> getProfile(@PathVariable("userId") int userId) {
		ProfileDTO profileDTO = messageConvertor.getProfileDTO(profileService.getProfile(userId));
		return new ResponseEntity<>(profileDTO, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProfileDTO> saveProfile(@RequestBody ProfileDTO profileDTO) {
		Profile profile = messageConvertor.convertMessage(profileDTO);
		if (profile != null) {
			ProfileDTO savedProfileDTO = messageConvertor.getProfileDTO(profileService.saveProfile(profile));
			return new ResponseEntity<>(savedProfileDTO, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public ResponseEntity<ProfileDTO> updateProfile(@RequestBody ProfileDTO profileDTO) {
		Profile profile = messageConvertor.convertMessage(profileDTO);
		if (profile != null) {
			ProfileDTO savedProfileDTO = messageConvertor.getProfileDTO(profileService.updateProfile(profile));
			return new ResponseEntity<>(savedProfileDTO, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ProfileDTO> deleteProfile(@PathVariable("userId") int userId) {
		profileService.deleteProfile(userId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
