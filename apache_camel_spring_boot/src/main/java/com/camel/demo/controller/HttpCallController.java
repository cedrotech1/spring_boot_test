package com.camel.demo.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/http-call")
public class HttpCallController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/trigger")
    public ResponseEntity<Map<String, Object>> triggerHttpCall() {
        Map<String, Object> response = new HashMap<>();
        try {
            // Trigger the route and capture the response as a List of JSON objects
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> apiResponse = producerTemplate.requestBody("direct:processHttpCall", null, List.class);

            // Prepare JSON response
            response.put("status", 200);
            response.put("message", "HttpCall route triggered successfully.");
            response.put("data", apiResponse); // Include the JSON array in the response
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", 500);
            response.put("message", "Failed to trigger HttpCall route: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
