package com.amdocs.media.auth.service;


import com.amdocs.media.base.models.ProfileDTO;

public interface KafkaService {
	public void sendProfileToUpdate(ProfileDTO profile);
	public void sendProfileToDelete(ProfileDTO profile);
}
