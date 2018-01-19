package com.mq.productor;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Map;

@Component("productor")
public class Productor {

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
    public void sendMessage(Map<String,String> map){
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setObject("pmap",map);
                return mapMessage;
            }
        };

        jmsTemplate.send("queue1",messageCreator);
        System.out.println("productor以发送消息");

    }


}
