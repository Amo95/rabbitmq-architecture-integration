package com.service.rabbitmqarchitectureintegration.publisher;

import com.service.rabbitmqarchitectureintegration.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MqJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqJsonProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key}")
    private String routingKey;
    private final RabbitTemplate rabbitTemplate;

    public MqJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("json message sent => %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKey, user);
    }
}
