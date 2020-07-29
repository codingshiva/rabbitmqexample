package com.codingshiva.rabbitmqexample.controller;

import com.codingshiva.rabbitmqexample.model.Employee;
import com.codingshiva.rabbitmqexample.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/codingshiva-rabbitmq")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("name") String name) {
        Employee employee = new Employee(name);
        rabbitMQSender.send(employee);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

}
