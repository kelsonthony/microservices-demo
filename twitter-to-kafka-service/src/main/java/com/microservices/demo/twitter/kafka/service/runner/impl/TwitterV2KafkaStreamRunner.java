package com.microservices.demo.twitter.kafka.service.runner.impl;

import com.microservices.demo.twitter.kafka.service.config.TwitterKafkaServiceConfigData;
import com.microservices.demo.twitter.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Qualifier("twitterV2KafkaStreamRunner")
@ConditionalOnExpression("${twitter-kafka-service.enable-v2-tweets} && not ${twitter-kafka-service.enable-mock-tweets}")
public class TwitterV2KafkaStreamRunner implements StreamRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterV2KafkaStreamRunner.class);

    private final TwitterKafkaServiceConfigData twitterKafkaServiceConfigData;

    private final TwitterV2StreamHelper twitterV2StreamHelper;

    public TwitterV2KafkaStreamRunner(TwitterKafkaServiceConfigData twitterKafkaServiceConfigData, TwitterV2StreamHelper twitterV2StreamHelper) {
        this.twitterKafkaServiceConfigData = twitterKafkaServiceConfigData;
        this.twitterV2StreamHelper = twitterV2StreamHelper;
    }

    @Override
    public void start() {
        String bearerToken = twitterKafkaServiceConfigData.getTwitterV2BearerToken();
        if (null != bearerToken && !bearerToken.isEmpty()) {
            try {
                twitterV2StreamHelper.setupRules(bearerToken, getRules());
                twitterV2StreamHelper.connectStream(bearerToken);
            } catch (IOException | URISyntaxException e) {
                LOG.error("There was a problem with the Twitter API request", e);
                throw new RuntimeException("Error streaming tweets!", e);

            }

        } else {
            LOG.error("Twitter V2 bearer token is not set, please set it in application.properties");
            throw new RuntimeException("There was a problem getting your bearer tkne. " +
                    "Please check your configuration TWITTER_BEARER_TOKEN");
        }
    }

    private Map<String, String> getRules() {
        List<String> keywords = twitterKafkaServiceConfigData.getTwitterKeywords();
        Map<String, String> rules = new HashMap<>();
        for(String keyword : keywords) {
            rules.put(keyword, "Keyword: " + keyword);
        }
        LOG.info("Created filter for twitter stream for keywords {}", keywords);
        return rules;
    }
}
