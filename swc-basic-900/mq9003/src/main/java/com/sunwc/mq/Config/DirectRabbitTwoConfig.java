package com.sunwc.mq.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitTwoConfig {

    //队列 起名：TestDirectQueue
    @Bean
    public Queue TestConsumDirectQueue() {
        return new Queue("TestConsumDirectQueue",true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange TestConsumDirectExchange() {
        return new DirectExchange("TestConsumDirectExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindConsumingDirect() {
        return BindingBuilder.bind(TestConsumDirectQueue()).to(TestConsumDirectExchange()).with("TestConsumDirectRouting");
    }

}
