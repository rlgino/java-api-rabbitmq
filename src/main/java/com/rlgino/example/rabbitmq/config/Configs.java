package com.rlgino.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut1","hello-world"})
@Configuration
@EnableRabbit
public class Configs {

    @Bean
    public Queue hello() {
        return new Queue("com.rlgino.go.product_created");
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Profile("receiver")
    @Bean
    public ProductCreatedReciver receiver() {
        return new ProductCreatedReciver();
    }

    @Profile("sender")
    @Bean
    public NotificationSender sender() {
        return new NotificationSender();
    }
}
