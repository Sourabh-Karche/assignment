package com.amdocs.media.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.media.auth.producer.KafkaProducer;
import com.amdocs.media.base.models.ProfileDTO;

@Service
public class KafkaServiceImpl implements KafkaService {

	@Autowired
	private KafkaProducer kafkaProducer;

	@Override
	public void sendProfileToUpdate(ProfileDTO profile) {
		// TODO Auto-generated method stub
		kafkaProducer.sendProfileToUpdate(profile);
	}

	@Override
	public void sendProfileToDelete(ProfileDTO profile) {
		// TODO Auto-generated method stub
		kafkaProducer.sendProfileToDelete(profile);
	}

}
