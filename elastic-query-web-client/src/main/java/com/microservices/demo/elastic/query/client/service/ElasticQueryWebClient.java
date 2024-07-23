package com.microservices.demo.elastic.query.client.service;

import com.microservices.demo.elastic.query.client.model.ElasticQueryWebClientRequestModel;
import com.microservices.demo.elastic.query.client.model.ElasticQueryWebClientResponseModel;

import java.util.List;

public interface ElasticQueryWebClient {
    List<ElasticQueryWebClientResponseModel> getDataByText(ElasticQueryWebClientRequestModel elasticQueryWebClientRequestModel);
}
