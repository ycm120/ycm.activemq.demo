package com.ztycm.activeMQDemo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import com.ztycm.demo.ActiveMqDemoApplication;
import com.ztycm.demo.configuration.JmsProducer;

@SpringBootTest(classes = ActiveMqDemoApplication.class)
@RunWith(SpringRunner.class)
@EnableAsync
public class JmsTest {
    @Autowired
    private JmsProducer producer;

    @Test
    public void sendMsg() {
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("value", "value = " + i);
            producer.sendToTopic(map);
//          producer.sendToQueue(map);
//          producer.sendToVTopic(map);
        }
    }
}
