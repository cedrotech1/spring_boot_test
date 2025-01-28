package com.camel.demo.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.camel.demo.controller.requests.EmailRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/send")
    public ResponseEntity<Map<String, Object>> sendEmail(@RequestBody EmailRequest emailRequest) {
        Map<String, Object> response = new HashMap<>();
        try {
            producerTemplate.sendBody("direct:sendEmail", emailRequest);
            response.put("status", 200);
            response.put("message", "Email sent successfully to " + emailRequest.getTo());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", 500);
            response.put("message", "Failed to send email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
