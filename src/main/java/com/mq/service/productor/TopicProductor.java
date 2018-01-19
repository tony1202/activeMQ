package com.mq.service.productor;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import java.util.HashMap;
import java.util.Map;

@Component("topicProductor")
public class TopicProductor {
    @Resource(name = "jmTopicTemplate")
    private JmsTemplate jmsTemplate;

    public void createMessage(){
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                Map<String,String> map = new HashMap<>();
                map.put("name","小丽");
                map.put("job","公关");
                mapMessage.setObject("myqueue2",map);
                return mapMessage;
            }
        };
        jmsTemplate.send("queue2",messageCreator);
    }
}
