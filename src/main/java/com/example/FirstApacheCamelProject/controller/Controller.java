package com.example.FirstApacheCamelProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

private final MessageService messageService;
    @Autowired
    public Controller(MessageService messageService) {
        this.messageService = messageService;

    }


    @PostMapping("/message")
    public String sendMassage(@RequestBody String message) {
        messageService.sendMessage(message);
        return "Message sent to RabbitMQ: " + message;
    }

}
