package com.codingshiva.rabbitmqexample.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    
    Queue adminQueue(){
        return new Queue("adminQueue", false);
    }

    
    Queue marketingQueue() {
        return new Queue("marketingQueue", false);
    }

    
    Queue financeQueue() {
        return new Queue("financeQueue", false);
    }

    
    Queue allQueue() {
        return new Queue("allQueue", false);
    }

    
    TopicExchange exchange(){
        return new TopicExchange("topic-exchange");
    }

    
    Binding marketingBinding(Queue marketingQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(marketingQueue).to(topicExchange).with("queue.marketing");
    }

    
    Binding financeBinding(Queue financeQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(financeQueue).to(topicExchange).with("queue.finance");
    }

    
    Binding adminBinding(Queue adminQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(adminQueue).to(topicExchange).with("queue.admin");
    }

    
    Binding allBinding(Queue allQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(allQueue).to(topicExchange).with("queue.*");
    }
}
