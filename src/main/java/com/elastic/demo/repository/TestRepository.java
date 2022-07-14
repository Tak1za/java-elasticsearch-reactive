package com.elastic.demo.repository;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public class TestRepository {
    private final ReactiveElasticsearchClient reactiveElasticsearchClient;

    TestRepository(ReactiveElasticsearchClient reactiveElasticsearchClient) {
        this.reactiveElasticsearchClient = reactiveElasticsearchClient;
    }

    public Flux<String> findAll() {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        searchRequest.indices("kibana_sample_data_ecommerce");
        return reactiveElasticsearchClient.scroll(searchRequest).map(h -> h.getSourceAsString()).doOnError(error -> System.out.println(error.getMessage()));
    }
}
