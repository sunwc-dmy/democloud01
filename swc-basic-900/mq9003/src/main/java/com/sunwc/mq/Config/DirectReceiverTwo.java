package com.sunwc.mq.Config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestConsumDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiverTwo {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("消费者2收到消息  : " + testMessage.toString());
    }
}
