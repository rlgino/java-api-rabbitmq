package com.rlgino.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut1", "hello-world"})
@Configuration
@EnableRabbit
public class Configs {

    public static final String COM_RLGINO_GO_PRODUCT_CREATED = "product_notifier.notification.publish_notification_on_product_created";

    @Bean
    public Queue productCreated() {
        return new Queue(COM_RLGINO_GO_PRODUCT_CREATED);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("logs_topic", true, false);
    }

    @Bean
    public Binding bindingExchange(TopicExchange topicExchange,
                                   Queue productCreated) {
        return BindingBuilder.bind(productCreated)
                .to(topicExchange).with("rlgino.product_creator.*");
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
