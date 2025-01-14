package com.example.kafkaTopicListener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigKafka {

    @Value("${kafkaTopicName:my-topic}")
    String kafkaTopicName;

    public String getTopicName() {
        return kafkaTopicName;
    }
    @Value("${kafkaGroupId:my-group}")
    String kafkaGroupId;

    public String getKafkaGroupId(){
        return kafkaGroupId;
    }

}
