package com.example.kafkaTopicListener.service;


import com.example.kafkaTopicListener.config.ConfigKafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaMessageListener {
    private static final Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    private final String kafkaTopicName;
    private final String kafkaGroupId;

    public KafkaMessageListener(ConfigKafka configKafka) {
        this.kafkaTopicName = configKafka.getTopicName();
        this.kafkaGroupId = configKafka.getKafkaGroupId();
    }
    @KafkaListener(topics = "#{@configKafka.getTopicName()}", groupId = "#{@configKafka.getKafkaGroupId()}")
    public void justRead(String message) {
        try {
            log.info("Получено сообщение: {}", message);
        } catch (Exception e) {
            log.error("Ошибка при обработке сообщения: {}", e.getMessage(), e);
        }
    }
}
