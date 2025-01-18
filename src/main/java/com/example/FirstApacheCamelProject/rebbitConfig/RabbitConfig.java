package com.example.FirstApacheCamelProject.rebbitConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "exchange";
    public static final String QUEUE_NAME = "myQueue";
    public static final String ROUTING_KEY = "routingKey";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME,true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

}
