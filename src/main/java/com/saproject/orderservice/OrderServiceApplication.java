package com.saproject.orderservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public NewTopic orderTopic(){
        return TopicBuilder.name("order").
                partitions(10).
                replicas(1).
                build();
    }
    @KafkaListener(id = "myId", topics = "order")
    public void listen(String in) {
        System.out.println(in);
    }

}
