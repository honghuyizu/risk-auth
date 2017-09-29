package com.risk.api.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/2/22.
 */
@Component
public class RabbitMqListener implements ApplicationListener<ContextRefreshedEvent> {
    /**日志对象*/
    static Logger _log = LoggerFactory.getLogger(RabbitMqListener.class);
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext().getParent();
        _log.info("------------------------RabbitMqListener rabbitmq start....--------------------------");
        ApplicationContext contextmq =
                new ClassPathXmlApplicationContext("/rabbitmq-consumer.xml");

    }
}
