package com.codingshiva.rabbitmqexample.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/codingshiva/fanout/")
public class RabbitMqFanOutController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @GetMapping(value = "/producer")
    public String getFanoutMessage(@RequestParam("exchangeName") String exchange,
                                   @RequestParam("messageData") String messageData){

        amqpTemplate.convertAndSend(exchange, "" ,messageData);
        return "Rabbit-mq sent with fan-out exchange successfully";
    }
}
