package com.rlgino.example.rabbitmq.config;

import com.rlgino.example.rabbitmq.dto.ProductCreatedDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedReciver {

    @RabbitListener(queues = "com.rlgino.go.product_created", messageConverter = "jackson2JsonMessageConverter")
    public void receive(ProductCreatedDTO prod) {
        System.out.println(" [x] Received product '" + prod.getProdID() + "' from user '" + prod.getUserID() +"'");
    }
}
