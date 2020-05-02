package com.amdocs.media.profile.config;

public class AppProperties {
	public static final String PROFILE_SERVICE_BASE_URL="${assignment.profileservice.base.url}";
	public static final String KAFKA_BOOTSTRAP_SERVERS_CONFIG="${assignment.bootstrap.servers.config}";
	public static final String KAFKA_PRODUCER_TOPIC_UPDATE="${assignment.kafka.topic.update}";
	public static final String KAFKA_PRODUCER_TOPIC_DELETE="${assignment.kafka.topic.delete}";
	public static final String GROUP_ID ="${assignment.kafka.consumer.groupid}";
}
