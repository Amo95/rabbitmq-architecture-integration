package com.service.rabbitmqarchitectureintegration.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MqConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqConsumer.class);

    @RabbitListener(
            queues = {"${rabbitmq.queue.name}"}
    )
    public String getMessage(String message){
        LOGGER.info(String.format("received message => %s", message));
        return message;
    }
}
