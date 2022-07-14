package com.elastic.demo.web.controllers;

import com.elastic.demo.services.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;

@RestController
public class TestController {
    private TestService testService;

    TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/stream", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Object> getData() {
        return testService.findAll();
    }
}
