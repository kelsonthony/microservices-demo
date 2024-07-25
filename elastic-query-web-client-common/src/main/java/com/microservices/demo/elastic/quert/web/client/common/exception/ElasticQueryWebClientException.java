package com.microservices.demo.elastic.quert.web.client.common.exception;

public class ElasticQueryWebClientException extends RuntimeException {

    public ElasticQueryWebClientException() {
        super();
    }

    public ElasticQueryWebClientException(String message) {
        super(message);
    }

    public ElasticQueryWebClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
