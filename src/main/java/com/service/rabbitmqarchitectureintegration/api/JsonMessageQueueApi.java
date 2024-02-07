package com.service.rabbitmqarchitectureintegration.api;

import com.service.rabbitmqarchitectureintegration.dto.User;
import com.service.rabbitmqarchitectureintegration.publisher.MqJsonProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jsonmq")
public class JsonMessageQueueApi {

    private final MqJsonProducer mqJsonProducer;

    public JsonMessageQueueApi(MqJsonProducer mqJsonProducer) {
        this.mqJsonProducer = mqJsonProducer;
    }

    @PostMapping("/send_json")
    public ResponseEntity<Void> sendMessage(@RequestBody User user){
        mqJsonProducer.sendJsonMessage(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
