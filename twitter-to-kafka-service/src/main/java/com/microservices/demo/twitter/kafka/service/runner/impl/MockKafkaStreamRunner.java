package com.microservices.demo.twitter.kafka.service.runner.impl;

import com.microservices.demo.twitter.kafka.service.config.TwitterKafkaServiceConfigData;
import com.microservices.demo.twitter.kafka.service.listener.TwitterKafkaStatusListener;
import com.microservices.demo.twitter.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

import java.util.Random;

@Component
public class MockKafkaStreamRunner implements StreamRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MockKafkaStreamRunner.class);

    private final TwitterKafkaServiceConfigData twitterKafkaServiceConfigData;

    private final TwitterKafkaStatusListener twitterKafkaStatusListener;

    private static final Random RANDOM = new Random();

    private static final String[] WORDS = new String[] {
            "java", "spring", "kafka", "microservices", "tutorial", "example", "beginner", "advanced",
            "Lorem", "ipsum", "dolor", "sit", "amet.", "Aut", "galisum", "quia", "quo", "dolorem", "ipsum",
    };

    private static final String tweetAsRawJson = "{" +
            "\"created_at\":\"{0}\"," +
            "\"id\":{1}," +
            "\"text\":\"{2}\"," +
            "\"user\":\"{3}\"" +
            "}";

    private static  final String TWITTER_STATUS_DATE_FORMAT = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";

    public MockKafkaStreamRunner(TwitterKafkaServiceConfigData twitterKafkaServiceConfigData, TwitterKafkaStatusListener twitterKafkaStatusListener) {
        this.twitterKafkaServiceConfigData = twitterKafkaServiceConfigData;
        this.twitterKafkaStatusListener = twitterKafkaStatusListener;
    }

    @Override
    public void start() throws TwitterException {

    }
}
