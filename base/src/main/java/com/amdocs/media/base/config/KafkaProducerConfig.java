package com.amdocs.media.base.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.amdocs.media.base.models.ProfileDTO;

@Configuration
public class KafkaProducerConfig {
	private static final String BOOTSTRAP_SERVERS_CONFIG="localhost:9092";
	
	@Bean
	public ProducerFactory<String, ProfileDTO> producerFactory() {
		Map<String, Object> config= new HashMap<String, Object>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String, ProfileDTO>(config);
	}
	
	@Bean
	public KafkaTemplate<String, ProfileDTO> kafkaTemplate() {
		return new KafkaTemplate<String, ProfileDTO>(producerFactory());
	}

}
