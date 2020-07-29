package com.codingshiva.rabbitmqexample.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {


    Queue adminQueue(){
        return new Queue("adminQueue", false);
    }


    Queue marketingQueue() {
        return new Queue("marketingQueue", false);
    }


    Queue financeQueue() {
        return new Queue("financeQueue", false);
    }


    FanoutExchange exchange() {
        return new FanoutExchange("fanout-exchange");
    }

    Binding marketingBinding(Queue marketingQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(marketingQueue).to(exchange);
    }


    Binding financeBinding(Queue financeQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(financeQueue).to(exchange);
    }


    Binding adminBinding(Queue adminQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange);
    }
}
