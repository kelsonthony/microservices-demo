package com.microservices.demo.twitter.kafka.service;

import com.microservices.demo.twitter.kafka.service.config.TwitterKafkaServiceConfigData;
import com.microservices.demo.twitter.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = "com.microservices.demo")
public class TwitterKafkaServiceApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaServiceApplication.class);

    private final TwitterKafkaServiceConfigData twitterKafkaServiceConfigData;

    private final StreamRunner streamRunner;

    public TwitterKafkaServiceApplication(TwitterKafkaServiceConfigData twitterKafkaServiceConfigData,
                                          @Qualifier("twitterKafkaStreamRunner") StreamRunner streamRunner) {
        this.twitterKafkaServiceConfigData = twitterKafkaServiceConfigData;
        this.streamRunner = streamRunner;
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
        streamRunner.start();
    }
}
