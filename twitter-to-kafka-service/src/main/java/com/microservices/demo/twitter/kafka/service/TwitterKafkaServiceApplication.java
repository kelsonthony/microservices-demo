package com.microservices.demo.twitter.kafka.service;

import com.microservices.demo.twitter.kafka.service.config.TwitterKafkaServiceConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TwitterKafkaServiceApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaServiceApplication.class);

    private final TwitterKafkaServiceConfigData twitterKafkaServiceConfigData;

    public TwitterKafkaServiceApplication(TwitterKafkaServiceConfigData twitterKafkaServiceConfigData) {
        this.twitterKafkaServiceConfigData = twitterKafkaServiceConfigData;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Apps Twitter Starts...");
        LOG.info(Arrays.toString(twitterKafkaServiceConfigData.getTwitterKeywords().toArray(
                new String[] {} )));
        LOG.info(twitterKafkaServiceConfigData.getWelcomeMessage());
    }
}
