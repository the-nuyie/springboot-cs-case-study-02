package com.training.java.springboot.casestudy.service;

import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

    //@JmsListener(destination = "test.queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
