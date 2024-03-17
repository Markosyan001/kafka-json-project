package net.kafka.kafkajsonproject.srevice.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.kafka.kafkajsonproject.model.User;
import net.kafka.kafkajsonproject.repository.UserRepository;
import net.kafka.kafkajsonproject.srevice.KafkaConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Slf4j
@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final UserRepository userRepository;

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        log.info("Save user {}", user);
        userRepository.save(user);
    }
}
