package com.mq.service.productor;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.HashMap;
import java.util.Map;

@Component("queueProductor")
public class QueueProductor {
    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    public void product(){
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Map<String,String> map= new HashMap<>();
                map.put("name","小美");
                map.put("age","18");
                map.put("level","一级");
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setObject("myqueue",map);
                return mapMessage;
            }
        };
        //发送消息
        jmsTemplate.send("queue1",messageCreator);
    }
}
