package com.amdocs.media.profile.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.amdocs.media.base.models.ProfileDTO;
import com.amdocs.media.profile.request.RequestGenerator;

@Component
public class KafkaConsumer {

	@Autowired
	private RequestGenerator requestGenerator;

	@KafkaListener(topics = "assignment_update", groupId = "group_id", containerFactory = "kafkaListnerContainerFactory")
	public void getProfileToUpdate(@Payload ProfileDTO profileDTO) {
		requestGenerator.generatePutRequest(profileDTO);
	}

	@KafkaListener(topics = "assignment_delete", groupId = "group_id", containerFactory = "kafkaListnerContainerFactory")
	public void getProfileToDelete(@Payload ProfileDTO profileDTO) {
		requestGenerator.generateDeleteRequest(profileDTO);
	}
}
