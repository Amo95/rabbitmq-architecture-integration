package com.service.rabbitmqarchitectureintegration.consumer;

import com.service.rabbitmqarchitectureintegration.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MqJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqJsonConsumer.class);

    @RabbitListener(
            queues = "${rabbitmq.queue.json.name}"
    )
    public void getMessage(User user){
        LOGGER.info(String.format("json message received => %s", user));

    }

}
