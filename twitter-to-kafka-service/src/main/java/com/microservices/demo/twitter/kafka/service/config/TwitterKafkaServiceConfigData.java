package com.microservices.demo.twitter.kafka.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "twitter-kafka-service")
public class TwitterKafkaServiceConfigData {
    private List<String> twitterKeywords;
    private String welcomeMessage;
    private String twitterV2BaseUrl;
    private String twitterV2RulesUrl;
    private String twitterV2BearerToken;
}
