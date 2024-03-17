package net.kafka.kafkajsonproject.srevice;

import net.kafka.kafkajsonproject.model.User;

public interface KafkaConsumerService {

    void consume(User user);
}
