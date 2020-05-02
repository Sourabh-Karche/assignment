package com.amdocs.media.auth.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.amdocs.media.auth.config.AppProperties;
import com.amdocs.media.base.models.ProfileDTO;

@Component
public class KafkaProducer {
	@Value(AppProperties.KAFKA_PRODUCER_TOPIC_UPDATE)
	private String kafkaUpdateTopic;
	
	@Value(AppProperties.KAFKA_PRODUCER_TOPIC_DELETE)
	private String kafkaDeleteTopic;

	@Autowired
	private KafkaTemplate<String, ProfileDTO> kafkaTemplate;

	public void sendProfileToUpdate(ProfileDTO profileDTO) {
		this.sendMessage(kafkaUpdateTopic, profileDTO);
	}
	
	public void sendProfileToDelete(ProfileDTO profileDTO) {
		this.sendMessage(kafkaDeleteTopic, profileDTO);
	}
	
	private void sendMessage(String kafkaTopic, ProfileDTO profileDTO) {
		kafkaTemplate.send(kafkaTopic, profileDTO);
	}
}
