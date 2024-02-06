package com.service.rabbitmqarchitectureintegration.api;

import com.service.rabbitmqarchitectureintegration.publisher.MqProducer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mq")
public class MessageQueueApi {

    private final MqProducer mqProducer;

    public MessageQueueApi(MqProducer mqProducer) {
        this.mqProducer = mqProducer;
    }

    @GetMapping("/send")
    public ResponseEntity<Void> publishMessage(@RequestParam("message") String message){
        mqProducer.sendMessage(message);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
