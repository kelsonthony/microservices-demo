package com.microservices.demo.twitter.kafka.service;

import com.microservices.demo.twitter.kafka.service.init.StreamInitializer;
import com.microservices.demo.twitter.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.microservices.demo")
public class TwitterKafkaServiceApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaServiceApplication.class);

    private final StreamRunner streamRunner;

    private final StreamInitializer streamInitializer;

    public TwitterKafkaServiceApplication(StreamRunner streamRunner, StreamInitializer streamInitializer) {
        this.streamRunner = streamRunner;
        this.streamInitializer = streamInitializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Apps Twitter Starts...");
        streamInitializer.init();
        streamRunner.start();
    }
}