package com.sunwc.mq.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TopicRabbitConfig {


    final public static String QUEUE_NAME = "queue.name";
    final public static String TEST_TOPIC_ROUTINGKEY = "test.topic.routingKey";
    final public static String TEST_EXCHANGE_HAHA = "test.exchange.haha";

    /**
     * 设置交换器的名称
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(TopicRabbitConfig.TEST_EXCHANGE_HAHA);
    }

    /**
     * 队列名称
     * @return
     */
    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.QUEUE_NAME);
    }

    /**
     * 将指定routing key的名称绑定交换器的队列
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(TopicRabbitConfig.TEST_TOPIC_ROUTINGKEY);
    }

    /**
     * 匹配以topic开头的路由键routing key
     * 交换机绑定多个队列
     */

    /*@Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }*/
}




