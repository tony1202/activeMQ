package com.mq.service.consumer;

import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Map;

@Component("topicConsumer")
public class TopicConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        MapMessage mapMessage = (MapMessage) message;
        try {
            Map<String,String> map = (Map<String, String>) mapMessage.getObject("myqueue2");
            System.out.println(map.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
