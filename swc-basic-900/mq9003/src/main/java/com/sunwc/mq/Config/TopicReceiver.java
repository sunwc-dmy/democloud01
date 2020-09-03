package com.sunwc.mq.Config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicReceiver {

    private final Logger log = LoggerFactory.getLogger(TopicReceiver.class);

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = TopicRabbitConfig.QUEUE_NAME, durable = "true"),
            exchange = @Exchange(value = TopicRabbitConfig.TEST_EXCHANGE_HAHA, type = ExchangeTypes.TOPIC),
            key = TopicRabbitConfig.TEST_TOPIC_ROUTINGKEY)
    )
    public void onOrgDeleted(@Payload String msg) {
        log.info("HelloReceiver msg : {}",msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = TopicRabbitConfig.QUEUE_NAME+".test", durable = "true"),
            exchange = @Exchange(value = TopicRabbitConfig.TEST_EXCHANGE_HAHA, type = ExchangeTypes.TOPIC),
            key = TopicRabbitConfig.TEST_TOPIC_ROUTINGKEY)
    )
    public void queueNameTest(@Payload String msg) {
        log.info("{}-----HelloReceiver msg : {}",TopicRabbitConfig.QUEUE_NAME+".test",msg);
    }
}
