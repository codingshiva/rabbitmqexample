package com.codingshiva.rabbitmqexample.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

  
    Queue marketingQueue() {
        return new Queue("marketingQueue", false);
    }

  
    Queue financeQueue() {
        return new Queue("financeQueue", false);
    }

  
    Queue adminQueue() {
        return new Queue("adminQueue", false);
    }

    DirectExchange exchange() {
        return new DirectExchange("direct-exchange");
    }

  
    Binding marketingBinding(Queue marketingQueue, DirectExchange exchange) {
        return BindingBuilder.bind(marketingQueue).to(exchange).with("marketing");
    }

  
    Binding financeBiding(Queue financeQueue, DirectExchange exchange) {
        return BindingBuilder.bind(financeQueue).to(exchange).with("finance");
    }

  
    Binding adminBinding(Queue adminQueue, DirectExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange).with("admin");
    }

}
