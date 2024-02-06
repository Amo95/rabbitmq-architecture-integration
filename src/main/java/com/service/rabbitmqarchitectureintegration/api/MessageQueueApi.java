package com.service.rabbitmqarchitectureintegration.api;

import com.service.rabbitmqarchitectureintegration.consumer.MqConsumer;
import com.service.rabbitmqarchitectureintegration.publisher.MqProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mq")
public class MessageQueueApi {

    private final MqProducer mqProducer;
    private final MqConsumer mqConsumer;

    public MessageQueueApi(MqProducer mqProducer, MqConsumer mqConsumer) {
        this.mqProducer = mqProducer;
        this.mqConsumer = mqConsumer;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> publishMessage(@RequestParam("message") String message){
        mqProducer.sendMessage(message);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/message")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok(mqConsumer.getMessage());
    }
}
