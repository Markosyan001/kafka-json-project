package net.kafka.kafkajsonproject.controller;

import net.kafka.kafkajsonproject.dto.UserDto;
import net.kafka.kafkajsonproject.kafka.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final JsonKafkaProducer kafkaProducer;

    public KafkaController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody UserDto dto) {
        kafkaProducer.sendMessage(dto);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }


}
