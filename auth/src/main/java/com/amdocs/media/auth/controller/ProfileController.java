package com.amdocs.media.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.amdocs.media.auth.config.AppProperties;
import com.amdocs.media.auth.service.KafkaService;
import com.amdocs.media.base.models.ProfileDTO;

import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/assignment/profile")
public class ProfileController {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Value(AppProperties.PROFILE_SERVICE_BASE_URL)
	private String profileServiceBaseUrl;

	private static final String URL_SEPARATOR = "/";

	@Autowired
	private KafkaService kafkaService;

	@GetMapping("/{userId}")
	public Mono<ProfileDTO> getProfile(@PathVariable("userId") int userId) {
		Mono<ProfileDTO> userProfile = webClientBuilder.build().get()
				.uri(profileServiceBaseUrl + URL_SEPARATOR + userId).retrieve().bodyToMono(ProfileDTO.class);

		return userProfile;
	}

	@PostMapping
	public Mono<ProfileDTO> saveProfile(@RequestBody ProfileDTO profile) {
		Mono<ProfileDTO> savedProfile = webClientBuilder.build().post().uri(profileServiceBaseUrl).bodyValue(profile)
				.retrieve().bodyToMono(ProfileDTO.class);

		return savedProfile;
	}

	@PutMapping
	public HttpStatus updateProfile(@RequestBody ProfileDTO profile) {
		kafkaService.sendProfileToUpdate(profile);

		return HttpStatus.OK;
	}

	@DeleteMapping("/{userId}")
	public HttpStatus deleteProfile(@PathVariable int userId) {
		ProfileDTO profile = new ProfileDTO();
		profile.setUserId(userId);

		kafkaService.sendProfileToDelete(profile);

		return HttpStatus.OK;
	}

}
