package com.example.stock_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.dto.OrderEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockConsumerService {
    

@KafkaListener(topics="${spring.kafka.topic.name}",groupId="${spring.kafka.consumer.group-id}")
public void consumer(OrderEvent order){
    log.info("Stock-Service received ->"+order.toString());

}

}
