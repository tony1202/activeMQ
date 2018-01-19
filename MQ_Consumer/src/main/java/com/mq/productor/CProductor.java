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

@Component("cproductor")
public class CProductor {

    @Resource(name="jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage(Map<String,String> map){
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setObject("cmap",map);
                return mapMessage;
            }
        };

        jmsTemplate.send("queue2",messageCreator);
        System.out.println("consumer以发送消息");

    }


}
