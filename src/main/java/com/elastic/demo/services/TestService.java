package com.elastic.demo.services;

import com.elastic.demo.entity.Commerce;
import com.elastic.demo.repository.TestRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TestService {
    private final TestRepository testRepository;

    TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Flux<Object> findAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        return testRepository.findAll().map(s -> {
            try {
                return objectMapper.readValue(s, Commerce.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
