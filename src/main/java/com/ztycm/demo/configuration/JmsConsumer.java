package com.ztycm.demo.configuration;

import javax.jms.JMSException;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
    private Logger logger = LoggerFactory.getLogger(JmsConsumer.class);

    @JmsListener(destination = "${activemq.topic}", containerFactory = "firstTopicListener")
    @Async // receive msg asynchronously
    //@Async("taskExecutePool") 
    public void receiveTopic(Message msg) throws JMSException {
        logger.info(Thread.currentThread().getName() + ": topic===========" + msg.getStringProperty("value"));
        try {
            Thread.sleep(1000L);
            // msg.acknowledge(); //消息确认
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.info(Thread.currentThread().getName() + ": topic===========" + msg.getStringProperty("value"));
    }
    
    @JmsListener(destination = "${activemq.queue}", containerFactory = "firstQueueListener")
    @Async
    public void receiveQueue(Message msg) throws JMSException {
        logger.debug(Thread.currentThread().getName() + ": Queue===========" + msg.getStringProperty("value"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug(Thread.currentThread().getName() + ": Queue===========" + msg.getStringProperty("value"));
    }
    
    @JmsListener(destination = "${activemq.virtual.topic.A}", containerFactory = "firstQueueListener")
    @Async
    public void receiveVTopicA1(Message msg) throws JMSException {
        logger.debug(Thread.currentThread().getName() + ": vtopic A1===========" + msg.getStringProperty("value"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug(Thread.currentThread().getName() + ": vtopic A1===========" + msg.getStringProperty("value"));
    }
    
    @JmsListener(destination = "${activemq.virtual.topic.A}", containerFactory = "firstQueueListener")
    @Async
    public void receiveVTopicA2(Message msg) throws JMSException {
        logger.debug(Thread.currentThread().getName() + ": vtopic A2===========" + msg.getStringProperty("value"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug(Thread.currentThread().getName() + ": vtopic A2===========" + msg.getStringProperty("value"));
    }
    
    @JmsListener(destination = "${activemq.virtual.topic.B}", containerFactory = "firstQueueListener")
    @Async
    public void receiveVTopicB(Message msg) throws JMSException {
        logger.debug(Thread.currentThread().getName() + ": vtopic B===========" + msg.getStringProperty("value"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug(Thread.currentThread().getName() + ": vtopic B===========" + msg.getStringProperty("value"));
    }
}
