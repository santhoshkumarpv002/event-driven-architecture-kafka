package com.example.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.dto.OrderEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderProducer {
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topic;

    public void orderProducer(OrderEvent orderEvent) {
        // Create a message from the order event
        org.springframework.messaging.Message<OrderEvent> message = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        // Send the message to the Kafka topic
        kafkaTemplate.send(message);

        // Log the successful sending of the message
        log.info("Order event sent: " + orderEvent.toString());
    }
}
