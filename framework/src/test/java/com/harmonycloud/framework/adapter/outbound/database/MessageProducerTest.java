package com.harmonycloud.framework.adapter.outbound.database;


import com.harmonycloud.framework.adapter.inbound.message.MessageConsumer;
import com.harmonycloud.framework.adapter.outbound.message.MessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Usage:
 * @Author: Vicky
 * @Date: 2019-09-05 10:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageProducerTest {
    @Autowired
    private MessageProducer messageProducer;
    @Autowired
    private MessageConsumer messageConsumer;
    @Test
    public void send() throws Exception {
        messageProducer.producer("TestYq","test","hello world");
        messageConsumer.messageListener();
    }

}
