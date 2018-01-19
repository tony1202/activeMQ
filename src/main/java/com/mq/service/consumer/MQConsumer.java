package com.mq.service.consumer;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Map;

@Component("mqConsumer")
public class MQConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("123");
        MapMessage mapMessage = (MapMessage) message;
        try {
            Map<String,String> map = (Map<String, String>) mapMessage.getObject("myqueue");
            System.out.println(map.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
