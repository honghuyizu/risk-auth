package com.risk.api.rabbitmq;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;



public class FirstReceiver implements MessageListener {
    public void onMessage(Message message) {
        String str = new String(message.getBody());
        //log.debug("Received message: {}", str);
        System.out.println("the first Received message:" + str);
    }
}
