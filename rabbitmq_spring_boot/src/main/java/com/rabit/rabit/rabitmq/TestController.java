package com.rabit.rabit.rabitmq;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class TestController {

    private final RabbitMQProducer producer;

    public TestController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send-string")
    public ResponseEntity<Object> sendStringMessage(@RequestParam("message") String message) {
        producer.sendStringMessage(message);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", message);
        response.put("details", "String message sent to RabbitMQ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/send-json")
    public ResponseEntity<Object> sendJsonMessage(@RequestBody Map<String, Object> jsonPayload) {
        producer.sendJsonMessage(jsonPayload);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", jsonPayload);
        response.put("details", "JSON message sent to RabbitMQ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
