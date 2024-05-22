package com.microservices.demo.twitter.kafka.service.exception;

public class TwitterKafkaServiceException extends RuntimeException {

        public TwitterKafkaServiceException(String message) {
            super(message);
        }

        public TwitterKafkaServiceException(String message, Throwable cause) {
            super(message, cause);
        }
}
