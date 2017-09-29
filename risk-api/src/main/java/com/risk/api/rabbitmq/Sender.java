package com.risk.api.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Sender {
    ApplicationContext context = new ClassPathXmlApplicationContext(
            "/rabbitmq-producer.xml");
    RabbitTemplate amqpTemplate = context.getBean("amqpTemplate", RabbitTemplate.class);
    RabbitTemplate amqpTemplateTwo = context.getBean("amqpTemplateTwo", RabbitTemplate.class);
    public void sendDataToMQ(String str) {
        try {
            amqpTemplate.convertAndSend(str);
            amqpTemplateTwo.convertAndSend(str);
            //log.debug("Send message: {}", str);
            System.out.println("Send message:" + str);
        } catch (Exception e) {
           // log.error("Error info:{}", e);
            e.printStackTrace();
        }

    }
}
