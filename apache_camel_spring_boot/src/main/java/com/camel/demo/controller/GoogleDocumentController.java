package com.camel.demo.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/google-doc")
public class GoogleDocumentController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @GetMapping("/fetch")
    public ResponseEntity<Map<String, Object>> fetchGoogleDoc() {
        producerTemplate.sendBody("direct:fetchGoogleDoc", null);

        // Create a response body as a map with both status and message
        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("message", "Google Document fetched and saved successfully.");

        // Return the response entity with status 200 (OK)
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

