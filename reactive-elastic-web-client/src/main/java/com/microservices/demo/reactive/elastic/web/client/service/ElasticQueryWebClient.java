package com.microservices.demo.reactive.elastic.web.client.service;

import com.microservices.demo.elastic.quert.web.client.common.model.ElasticQueryWebClientRequestModel;
import com.microservices.demo.elastic.quert.web.client.common.model.ElasticQueryWebClientResponseModel;
import reactor.core.publisher.Flux;

public interface ElasticQueryWebClient {
    Flux<ElasticQueryWebClientResponseModel> getDataByText(ElasticQueryWebClientRequestModel elasticQueryWebClientRequestModel);
}
