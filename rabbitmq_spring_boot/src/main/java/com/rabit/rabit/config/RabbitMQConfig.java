package com.rabit.rabit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.string}")
    private String stringQueue;

    @Value("${rabbitmq.queue.json}")
    private String jsonQueue;

    @Value("${rabbitmq.exchange.string}")
    private String stringExchange;

    @Value("${rabbitmq.exchange.json}")
    private String jsonExchange;

    @Value("${rabbitmq.routing.key.string}")
    private String stringRoutingKey;

    @Value("${rabbitmq.routing.key.json}")
    private String jsonRoutingKey;

    @Bean
    public Queue stringQueue() {
        return new Queue(stringQueue, true);
    }

    @Bean
    public Queue jsonQueue() {
        return new Queue(jsonQueue, true);
    }

    @Bean
    public TopicExchange stringExchange() {
        return new TopicExchange(stringExchange);
    }

    @Bean
    public TopicExchange jsonExchange() {
        return new TopicExchange(jsonExchange);
    }

    @Bean
    public Binding stringBinding() {
        return BindingBuilder.bind(stringQueue()).to(stringExchange()).with(stringRoutingKey);
    }

    @Bean
    public Binding jsonBinding() {
        return BindingBuilder.bind(jsonQueue()).to(jsonExchange()).with(jsonRoutingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
