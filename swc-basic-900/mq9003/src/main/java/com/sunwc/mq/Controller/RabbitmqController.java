package com.sunwc.mq.Controller;

import com.sunwc.mq.Config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class RabbitmqController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/mqTest",method = RequestMethod.GET)
    @ResponseBody
    public void mqTest (String quene,String object){
        rabbitTemplate.convertAndSend(quene,object);
    }

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "TestDirectExchange!";
        String messageData2 = "TestConsumDirectExchange!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        Map<String,Object> map2=new HashMap<>();
        map2.put("messageId",messageId);
        map2.put("messageData",messageData2);
        map2.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        rabbitTemplate.convertAndSend("TestConsumDirectExchange", "TestConsumDirectRouting", map2);
        return "ok";
    }

    @GetMapping(value = "/sendMakeMessage")
    public String sendMakeMessage(){
//        rabbitTemplate.setDefaultReceiveQueue("swc");
//        rabbitTemplate.setExchange("swcExchange");
//        rabbitTemplate.setRoutingKey("swcRouting");
//        rabbitTemplate.convertAndSend("swcExchange","swcRouting","自定义exchange和routing！！");
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TEST_EXCHANGE_HAHA,TopicRabbitConfig.TEST_TOPIC_ROUTINGKEY, "context");
        return "ok";
    }
}
