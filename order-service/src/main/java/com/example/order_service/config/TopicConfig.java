package com.example.order_service.config;



import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    
@Value("${spring.kafka.topic.name}")
private static String topic;

    @Bean
    public NewTopic newTopic(){

        return TopicBuilder.name(topic)
        // .partitions(0)
        
        .build();
    }
}
