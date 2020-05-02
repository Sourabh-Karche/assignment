package com.amdocs.media.base.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.amdocs.media.base.models.ProfileDTO;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	private static final String BOOTSTRAP_SERVERS_CONFIG="localhost:9092";
	private static final String GROUP_ID="group_id";
	
	@Bean
	public ConsumerFactory<String, ProfileDTO> consumerFactory() {
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<String, ProfileDTO>(config, new StringDeserializer(),
				new JsonDeserializer<ProfileDTO>(ProfileDTO.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, ProfileDTO> kafkaListnerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, ProfileDTO> factory = new ConcurrentKafkaListenerContainerFactory<String, ProfileDTO>();
		factory.setConsumerFactory(consumerFactory());

		return factory;
	}
}
