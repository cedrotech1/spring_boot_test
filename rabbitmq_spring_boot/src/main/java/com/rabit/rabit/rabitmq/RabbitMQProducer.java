package com.rabit.rabit.rabitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.string}")
    private String stringExchange;

    @Value("${rabbitmq.exchange.json}")
    private String jsonExchange;

    @Value("${rabbitmq.routing.key.string}")
    private String stringRoutingKey;

    @Value("${rabbitmq.routing.key.json}")
    private String jsonRoutingKey;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendStringMessage(String message) {
        rabbitTemplate.convertAndSend(stringExchange, stringRoutingKey, message);
        System.out.println("String message sent: " + message);
    }

    public void sendJsonMessage(Map<String, Object> jsonMessage) {
        rabbitTemplate.convertAndSend(jsonExchange, jsonRoutingKey, jsonMessage);
        System.out.println("JSON payload sent: " + jsonMessage);
    }
}
