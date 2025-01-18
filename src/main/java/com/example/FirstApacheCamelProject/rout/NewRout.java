package com.example.FirstApacheCamelProject.rout;

import jakarta.annotation.PostConstruct;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.FirstApacheCamelProject.rebbitConfig.RabbitConfig.QUEUE_NAME;


@Component
public class NewRout extends RouteBuilder {




    @Override
    public void configure() throws Exception {
        from("rabbitmq:exchange?queue=" + QUEUE_NAME + "&routingKey=routingKey&autoDelete=false")
                .routeId("rabbitmq-consumer-route")
                .autoStartup(true)
                .log("Message received from RabbitMQ: ${body}");
    }
    @PostConstruct
    public void init() {
        System.out.println("Camel Route Initialized");
    }

}

