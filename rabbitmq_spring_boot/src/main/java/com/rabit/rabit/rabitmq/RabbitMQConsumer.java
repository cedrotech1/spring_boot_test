package com.rabit.rabit.rabitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabit.rabit.rabitmq.Dto.MessagePayload;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.string}")
    public void receiveStringMessage(String message) {
        System.out.println("Received String message: " + message);
    }

    @RabbitListener(queues = "${rabbitmq.queue.json}")
    public void receiveJsonMessage(MessagePayload payload) {
        System.out.println("Received JSON payload: " + payload);
    }
}
