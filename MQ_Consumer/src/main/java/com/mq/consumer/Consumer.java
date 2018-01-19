package com.mq.consumer;

import com.mq.productor.CProductor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.HashMap;
import java.util.Map;
@Component("consumer")
public class Consumer implements MessageListener {
    @Resource(name = "cproductor")
    private CProductor productor;

    @Override
    public void onMessage(Message message) {
        MapMessage mapMessage = (MapMessage) message;
        try {
            Map<String,String> c1 = (Map<String, String>) mapMessage.getObject("pmap");
            System.out.println("接受到消息");
            System.out.println(c1.toString());
            Map<String,String> map = new HashMap<>();
            map.put("name","consumer");
            productor.sendMessage(map);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
