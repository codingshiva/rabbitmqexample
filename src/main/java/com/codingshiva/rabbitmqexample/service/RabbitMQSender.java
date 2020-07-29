package com.codingshiva.rabbitmqexample.service;

import com.codingshiva.rabbitmqexample.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee employee) {
        amqpTemplate.convertAndSend(exchange, routingkey, employee);
        System.out.println("send msg = " + employee);
    }
}
