package com.example.practice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@AllArgsConstructor
@Slf4j
public class MyRabbitListener {

    @RabbitListener(queues = "notificationQueue")
    public void processMyQueue(String message) {
        log.info("Received from notificationQueue: {}", message);
    }
}
