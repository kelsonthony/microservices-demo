package com.microservices.demo.elastic.query.client.service;

import com.microservices.demo.elastic.model.index.IndexModel;

import java.util.List;

public interface ElasticQueryClient<T extends IndexModel> {

    T getIndexById(String id);

    List<T> getIndexModelByText(String text);

    List<T> getAllIndexModels();
}
