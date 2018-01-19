package com.mq.consumer;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Map;

@Component("pconsumer")
public class PConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        MapMessage mapMessage = (MapMessage) message;
        try {
            Map<String,String> c1 = (Map<String, String>) mapMessage.getObject("cmap");
            System.out.println("接受到消息");
            System.out.println(c1.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
